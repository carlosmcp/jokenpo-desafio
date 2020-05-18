package jokenpo.controllers

import jokenpo.models.ParamId
import jokenpo.models.Player
import jokenpo.services.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/jokenpo")
open class PlayerController(@Autowired val playerService: PlayerService) {

    @GetMapping("/players")
    @ResponseStatus(HttpStatus.OK)
    fun listAll() = playerService.findAll()

    @GetMapping("/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@Valid @PathVariable id: ParamId) = playerService.findById(id)

    @PostMapping("/players")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody player: Player) = playerService.save(player)

    @PutMapping("/players/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update( @Valid @RequestBody player: Player, @Valid @PathVariable id: ParamId) = playerService.update(id, player)

    @DeleteMapping("/players/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@Valid @PathVariable id: ParamId) = playerService.delete(id)
}