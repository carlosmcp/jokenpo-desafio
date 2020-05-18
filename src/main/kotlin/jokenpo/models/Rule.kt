package jokenpo.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * Entity Rule
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */

typealias Move = String

data class ParamId(
    @JsonProperty("id")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    val id:String
) {
    fun value () = id.toInt()
}

class Rule(
    @JsonProperty("id")
    private var id:Int,

    @JsonProperty("move1")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    val move1: Move,

    @JsonProperty("move2")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio")
    val move2: Move,

    @JsonProperty("beat")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    val beat: Move
 ) {
    fun getId():Int = this.id
    fun setId(id: Int) { this.id = id }
}