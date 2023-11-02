import Böse.Endboss

class Magier(name: String, hp: Int, weapon: String, atk: Int, shild: Boolean=false, var crit: Int,stealth:Boolean,ausweichen:Boolean) :
    Held(name,hp,weapon,atk,shild,stealth,ausweichen) {
    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }

    fun heal(team: MutableList<Held>) {
        println("$name kanalisiert ihre Macht und will jemanden Heilen")
        var targetHeal = select(team) // <----- NOCHMAL ABCHECKEN, WICHTIG FÜR SPÄTER
        targetHeal.hp += 20
        println("${targetHeal.name} wurde um 20 geheilt")
        println("Er hat jetzt ${targetHeal.hp} Lebenspunkte")


    }

    fun shild() {
        println("$name erschafft eine Eisschild im sich um etwas schaden zu blocken")
        shild = true
    }

    fun lavaBurst(boese: MutableList<Endboss>) {
        val drache = boese.first
        var schaden = (30..60).random() + atk
        println("$name faltet seine Hände zusammen und kanalisiert einen Lavaschlag")
        Thread.sleep(500)
        println("Es knistert und ....")
        Thread.sleep(500)
        println("... ein riesiger Lavaball rast auf den $ zu.")
        drache.hp -= schaden
        println("${drache.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${drache.hp}")

    }

    fun frostBlizzard(boese: MutableList<Endboss>) {
        var schaden = (30..60).random() + atk
        println("$name erschafft über den Gegnern ein Eisregen")
        Thread.sleep(500)
        println("Der Regen verusacht schwere Frostbrandwunden")
        for (i in boese.indices) {
            boese[i].hp - schaden
        }
        println("Es wurde $schaden Schaden verursacht")


    }


}



