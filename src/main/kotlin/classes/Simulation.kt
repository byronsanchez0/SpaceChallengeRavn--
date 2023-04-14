package classes

import java.io.File

class Simulation {
    fun loadItems( url: String): ArrayList<Item>{
        val itemsToLoad = File   (url).bufferedReader().use { it.readText() }
        val itemsArray = arrayListOf<Item>()
        for (item in itemsToLoad.lines()){
            val itemElement = item.split("=")
            if(itemElement[0] != null && itemElement[1] != null)
                itemsArray.add(Item(itemElement[0], itemElement[1].toInt()))
        }
        return itemsArray
    }
    fun loadU1(itemsArr: ArrayList<Item>): ArrayList<U1>{
        val rocketsU1 = ArrayList<U1>()
        var rocketU1= U1()
        for(item in itemsArr){
            if(rocketU1.canCarry(item)){
                rocketU1.carry(item)
            }else{
                rocketsU1.add(rocketU1)
                rocketU1 = U1()
                rocketU1.carry(item)
            }
        }
        if(itemsArr.size != 0){
            rocketsU1.add(rocketU1)
        }
        return rocketsU1
    }
    fun loadU2(itemsArr: ArrayList<Item>): ArrayList<U2>{
        val rocketsU2 = ArrayList<U2>()
        var rocketU2= U2()
        for(item in itemsArr){

            if(rocketU2.canCarry(item)){
                rocketU2.carry(item)
            }else{
                rocketsU2.add(rocketU2)
                rocketU2 = U2()
                rocketU2.carry(item)
            }
        }
        if(itemsArr.size != 0){
            rocketsU2.add(rocketU2)
        }
        return rocketsU2
    }

    fun runSimulation(rocketsArrayU1: ArrayList<U1>, rocketsArrayU2: ArrayList<U2>): Array<Int>{
        var totalCostU1 = 0
        var totalCostU2 = 0
        for(item in rocketsArrayU1){
            while(item.launch() || item.land()) {
                totalCostU1 += item.cost
            }
        }
        for(item in rocketsArrayU2){
            while(item.launch() || item.land()) {
                totalCostU2 += item.cost
            }
        }
        if(totalCostU1 < totalCostU2){
            println("\nThe design U1 is cheaper than the U2 so its recommended to use this one")
            println()
            println("*******")
            println("*******                                     ")
            println("*******                                     ")
            println("*******       Lets go visit MARS            ")
            println("*******                                     ")
            println("*******                                    ")
            println("*******")
        }else if(totalCostU2 < totalCostU1){
            println("\nThe design U2 is cheaper than the U1 so its recommended to use this one")
            println()
            println("*******")
            println("*******                                     ")
            println("*******                                     ")
            println("*******       Lets go visit MARS            ")
            println("*******                                     ")
            println("*******                                    ")
            println("*******")
        }else{
            println("\n Both designs are cheap to use, so its good to use either of the two")
            println()
            println("*******")
            println("*******                                     ")
            println("*******                                     ")
            println("*******       Lets go visit MARS            ")
            println("*******                                     ")
            println("*******                                    ")
            println("*******")
        }

        return arrayOf(totalCostU1, totalCostU2)

    }
}