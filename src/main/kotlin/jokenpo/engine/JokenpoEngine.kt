package jokenpo.engine

import jokenpo.models.Move
import jokenpo.models.PlayerMove
import jokenpo.models.Rule

/**
 * Singleton Class with Rules and Logic's Jokepon
 *
 * @see {https://en.wikipedia.org/wiki/Rock_paper_scissors} - nomenclaturas
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
object JokenpoEngine {
    //private val productRepository: ProductRepository? = null
    val rules = ArrayList<Rule>()

    fun evalThrow(move1: Move, move2: Move): Rule? {
        return rules.find { rule ->//find match the Role
            ((rule.move1 == move1 && rule.move2 == move2)
                    || (rule.move1 == move2 && rule.move2 == move1))
        }.let {
            if (it == null) throw Exception("Rule not found for moves '$move1' and '$move2'.")
            it
        }
    }

    fun evalGame(playerMoves: List<PlayerMove>): PlayerMove {
        return playerMoves.reduce { potentialWinner, challengerPlayer ->
            evalThrow(potentialWinner.move, challengerPlayer.move)
                .let { result ->
                if (result?.beat == potentialWinner.move) potentialWinner else challengerPlayer
            }
        }
    }

}

