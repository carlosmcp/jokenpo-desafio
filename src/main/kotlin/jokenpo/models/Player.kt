package jokenpo.models

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

/**
 * PLayer Model
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
data class Player(
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    @JsonProperty("id")
    private var id:Int,

    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    @JsonProperty("name")
    val name: String
) {
    fun getId():Int = this.id
    fun setId(id: Int) { this.id = id }
}
