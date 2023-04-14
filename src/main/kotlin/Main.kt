import classes.Item
import classes.Simulation

fun main() {
    class Main {
        val simulation = Simulation()
        val itemsPhase1 = simulation.loadItems("src/main/kotlin/missionspecs/Phase-1.txt") //loading items of phase1
        val itemsPhase2 = simulation.loadItems("src/main/kotlin/missionspecs/Phase-2.txt") //loading items of phase2

        val rocketsU1 = simulation.loadU1(ArrayList(itemsPhase1.plus(itemsPhase2)))//loadingrockets U1 with both phases
        val rocketsU2 = simulation.loadU2(ArrayList(itemsPhase1.plus(itemsPhase2)))// loading rockets U2 with both phases

        val totalBudget = simulation.runSimulation(rocketsU1, rocketsU2)


    }

    var finalResult = Main()

    println("To send the U1 rocket safely in both phases, a budget of $ ${finalResult.totalBudget[0]} million is needed.")
    println("To send the U2 rocket safely in both phases, a budget of $ ${finalResult.totalBudget[1]} million is needed.")
    println("***********")
    println("Here is some data you will need to know:")
    //ROCKETS U1
    println("ROCKETS U1")
    println("***********")
    println("U1 ROCKETS WITH ITEMS OF BOTH PHASES:")
    println(finalResult.rocketsU1.size)// WITH ITEMS OF BOTH PHASES
    println("****************************")
    //ROCKETS U2
    println("ROCKETS U2")
    println("****************************")
    println("U2 ROCKETS WITH ITEMS OF BOTH PHASES:")
    println(finalResult.rocketsU2.size)// WITH ITEMS OF BOTH PHASES
    println()
    println("************************************************")
    println("************************************************")
    println("************************************************")
    println("              Lets go visit MARS            ")
    println("")
    println("")
    println("")
}