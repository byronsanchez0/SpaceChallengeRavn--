package classes

class U1(): Rocket(){
    init{
        cost = 100
        weight = 10000
        currentWeight = 10000
        maxWeight = 18000
    }

    override fun launch(): Boolean {
        chanceOfLaunchExplosion = 0.05 * (currentWeight - weight) / (maxWeight - weight)
        return chanceOfLaunchExplosion <= Math.random() * 0.1
    }

    override fun land(): Boolean {
        chanceOfLandCrash = 0.01 * (currentWeight - weight) / (maxWeight - weight)
        return chanceOfLandCrash <= Math.random() * 0.1
    }
}