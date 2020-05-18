package jokenpo.services

import jokenpo.models.ParamId
import jokenpo.models.Rule
import jokenpo.repositorys.RuleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Rule Service Class
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
@Service
class RuleService (@Autowired private val ruleRepository: RuleRepository) {
    fun findById(id: ParamId) = ruleRepository.findById(id)
    fun findAll() = ruleRepository.findAll()
    fun save(rule: Rule) = ruleRepository.save(rule)
    fun delete(id: ParamId) = ruleRepository.delete(id)
    fun update(id: ParamId, rule: Rule) = ruleRepository.update(id, rule)
}