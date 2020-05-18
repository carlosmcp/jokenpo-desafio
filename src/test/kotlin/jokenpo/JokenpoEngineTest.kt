package jokenpo

import jokenpo.models.PlayerMove
import jokenpo.engine.JokenpoEngine
import jokenpo.models.Rule
import org.junit.jupiter.api.*

/**
 * jokenpo.Jokenpo's test
 *
 * @author Carlos Brito <carlosmcp@gmail.com>
 * @since 1.0 <2020/05/16>
 */
@DisplayName("jokenpo.Jokenpo class test")
class JokenpoEngineTest {
    val rulesEngine = ArrayList<Rule>()

    @BeforeEach
    fun addRules() {
        JokenpoEngine.rules.add(Rule(1, "pedra", "lagarto", "pedra"))/*pedra esmaga lagarto*/
        JokenpoEngine.rules.add(Rule(2,"lagarto", "spock", "lagarto"))/*lagarto envenena Spock*/
        JokenpoEngine.rules.add(Rule(3,"spock", "tesoura", "spock"))/*Spock quebra tesoura*/
        JokenpoEngine.rules.add(Rule(4,"tesoura", "lagarto", "tesoura"))/*tesoura decapita lagarto*/
        JokenpoEngine.rules.add(Rule(5,"lagarto", "papel", "lagarto"));/*lagarto come papel*/
        JokenpoEngine.rules.add(Rule(6,"papel", "spock", "papel"))/*papel contesta Spock*/
        JokenpoEngine.rules.add(Rule(7,"spock", "pedra", "spock"))/*Spock vaporiza pedra*/
        JokenpoEngine.rules.add(Rule(8,"pedra", "tesoura", "pedra"))/*Pedra quebra Tesoura*/
        JokenpoEngine.rules.add(Rule(9,"papel", "pedra", "papel"))/*Papel cobre a pedra*/
        JokenpoEngine.rules.add(Rule(10,"tesoura", "papel", "tesoura"))//tesoura corta papel
    }

    @AfterEach
    fun afterAll() {
        JokenpoEngine.rules.clear()
    }

    @Test
    fun `Should remove a rule`() {
        with(JokenpoEngine.rules) {
            remove(Rule(1,"pedra", "tesoura", "pedra"))
            this
        }.let {
            it.find { item -> item == (Rule(1, "pedra", "tesoura", "pedra")) }
        }.also {
            Assertions.assertEquals(it, null)
        }
    }

    @Test
    fun `Should add a rule`() {
        with(JokenpoEngine.rules) {
            add(Rule(1, "spock", "tesoura", "pedra"))
            this
        }.let {
            it.get(1)
        }.also {
            Assertions.assertNotEquals(it, null)
        }
    }

    @Test
    fun `Should eval a rule`() {
        JokenpoEngine.evalThrow("pedra", "lagarto").let {
            Assertions.assertEquals(it?.beat, "pedra")
        }
    }

    @Test
    fun `Should not eval a rule`() {
        val movie1  = "#pedra#"
        val movie2 = "papel"

        Assertions.assertThrows(Exception::class.java) {
            JokenpoEngine.evalThrow(movie1, movie2)
        }.also {
            Assertions.assertTrue(it.message == "Rule not found for moves '${movie1}' and '${movie2}'.")
        }
    }

    @Test
    fun `Should find a winner into a list of Moves - 1`() {
        listOf(
            PlayerMove("Jogador 1", "spock"),
            PlayerMove("Jogador 3", "tesoura"),
            PlayerMove("Jogador 2", "papel")

        ).let {
            JokenpoEngine.evalGame(it).apply {
                Assertions.assertTrue(player == "Jogador 2")
            }
        }
    }

    @Test
    fun `Should find a winner into a list of Moves - 2`() {
        listOf(
            PlayerMove("Jogador 1", "spock"),
            PlayerMove("Jogador 3", "tesoura"),
            PlayerMove("Jogador 2", "papel")

        ).let {
            JokenpoEngine.evalGame(it).apply {
                 Assertions.assertTrue(player == "Jogador 2")
            }
        }
    }
}