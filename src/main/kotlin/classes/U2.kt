package classes

class U2 : Rocket() {
    init {
        cost = 120
        weight = 18000
        currentWeight = 18000
        maxWeight = 29000
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