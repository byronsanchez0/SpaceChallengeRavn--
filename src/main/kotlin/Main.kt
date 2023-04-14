import classes.Simulation

fun main() {
    class Main(){
        val simulation = Simulation()
        val itemsPhase1 = simulation.loadItems("src/main/kotlin/missionspecs/Phase-1.txt")
        val itemsPhase2 = simulation.loadItems("src/main/kotlin/missionspecs/Phase-2.txt")
        val rocketsU1 = simulation.loadU1(ArrayList(itemsPhase1.plus(itemsPhase2)))
        val rocketsU2 = simulation.loadU2(ArrayList(itemsPhase1.plus(itemsPhase2)))
        val budgets = simulation.runSimulation(rocketsU1, rocketsU2)
    }


    var resultados  = Main()


    println("To send the U1 rocket safely in both phases, a budget of $ ${resultados.budgets[0]} million is needed.")
    println("To send the U2 rocket safely in both phases, a budget of $ ${resultados.budgets[1]} million is needed.")


}