package jokenpo.controllers

import jokenpo.models.ParamId
import jokenpo.models.Rule
import jokenpo.services.RuleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/jokenpo")
open class RulesController(@Autowired val ruleService: RuleService) {

    @GetMapping("/rules")
    @ResponseStatus(HttpStatus.OK)
    fun listAll() = ruleService.findAll()

    @GetMapping("/rules/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@Valid @PathVariable id: ParamId) = ruleService.findById(id)

    @PostMapping("/rules")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody rule: Rule) = ruleService.save(rule)

    @PutMapping("/rules/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update( @Valid @RequestBody rule: Rule, @Valid @PathVariable id: ParamId) = ruleService.update(id, rule)

    @DeleteMapping("/rules/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@Valid @PathVariable id: ParamId) = ruleService.delete(id)
}