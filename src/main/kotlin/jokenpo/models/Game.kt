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
data class Game (
    @JsonProperty("playerId")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    val playerId: Int,

    @JsonProperty("move")
    @field:NotNull(message = "Campo obrigatório")
    @field:NotEmpty(message = "Não pode ser vazio.")
    val move: String
)