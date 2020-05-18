package jokenpo.models

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * PLayer Move Model
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
data class PlayerMove(
    @JsonProperty("player")
    val player: String,

    @JsonProperty("movie1")
    val move: String
)
