package jokenpo.repositorys

import jokenpo.models.ParamId
import jokenpo.models.Player
import org.springframework.stereotype.Component

/**
 * PLayer Repository
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
@Component
object PlayerRepository {
    private val players = HashMap<Int, Player>()
    private var idSeed: Int = 0

    fun save(Player: Player): Player? {
        val id = this.genId()
        Player.setId(id)
        this.players.set(id, Player)
        return this.players.get(id)
    }

    fun update(paramId: ParamId, Player: Player) {
        this.players.remove(paramId.value(), Player)
    }

    fun delete(paramId: ParamId) {
        this.players.remove(paramId.value())
    }

    fun findById(paramId: ParamId) = this.players.get(paramId.value())

    fun findAll() = this.players

    private fun genId() = ++this.idSeed
}