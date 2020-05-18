package jokenpo.repositorys

import jokenpo.models.ParamId
import jokenpo.models.Rule
import org.springframework.stereotype.Component

/**
 * PLayer Repository
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
@Component
object RuleRepository {
    private val rules = HashMap<Int, Rule>()
    private var idSeed: Int = 0

    fun save(rule: Rule): Rule? {
        val id = this.genId()
        rule.setId(id)
        this.rules.set(id, rule)
        return this.rules.get(id)
    }

    fun update(paramId: ParamId, rule: Rule) {
        this.rules.remove(paramId.value(), rule)
    }

    fun delete(paramId: ParamId) {
        this.rules.remove(paramId.value())
    }

    fun findById(paramId: ParamId) = this.rules.get(paramId.value())

    fun findAll() = this.rules.map { it.value}

    private fun genId() = ++this.idSeed
}