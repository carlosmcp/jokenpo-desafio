package jokenpo.controllers

import jokenpo.engine.JokenpoEngine
import jokenpo.models.Game
import jokenpo.models.ParamId
import jokenpo.models.PlayerMove
import jokenpo.services.PlayerService
import jokenpo.services.RuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/api/v1/jokenpo")
class GameController(
    @Autowired val playerService: PlayerService,
    @Autowired val ruleService: RuleService
) {

    @PostMapping("/play")
    fun play(@Valid @RequestBody game: List<Game>) {
        return game.map {
            val playerFound =
                playerService.findById(ParamId(it.playerId.toString())) ?: throw Exception("Jogador não localizado")
            PlayerMove(playerFound.name, it.move)
        }.let { players ->
            val rules = ruleService.findAll()
            JokenpoEngine.rules.addAll(rules)
            JokenpoEngine.evalGame(players).let {
                if (it != null) "Winner: ${it.player} Move: ${it.move}" else "Draw!"
            }
        }
    }


}