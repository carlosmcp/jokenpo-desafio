package jokenpo.services

import jokenpo.models.ParamId
import jokenpo.models.Player
import jokenpo.repositorys.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * PLayer Service Class
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
@Service
class PlayerService(@Autowired private val playerRepository: PlayerRepository) {
    fun findById(id: ParamId) = playerRepository.findById(id)
    fun findAll() = playerRepository.findAll()
    fun save(player: Player) = playerRepository.save(player)
    fun delete(id: ParamId) = playerRepository.delete(id)
    fun update(id: ParamId, player: Player) = playerRepository.update(id, player)
}