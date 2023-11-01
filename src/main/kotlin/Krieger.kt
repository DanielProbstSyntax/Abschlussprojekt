import Böse.Drache
import Böse.Endboss
import kotlin.random.Random

open class Krieger(name: String, hp: Int, weapon: String, atk: Int, var crit: Int, shild: Boolean, stealth: Boolean) :
    Held(name, hp, weapon, atk, stealth, shild) {
        var battleShout = 1

    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }

    fun shildblock() {
        println("$name hebt sein Schild um den nächsten Angriff zu Blocken")
        shild = true


    }

    fun headbutt(endboss: Endboss) { // NICHT FERTIG
        var schaden = (30..60).random() + atk
        println("$name nimmt anlauf und rammt seinen Kopf mit aller Wucht gegen ${endboss.name}s Schädel ")
        Thread.sleep(500)
        println("BOOOM - Es knall laut und ${endboss.name} ist benommen. Ihm wurde etwas Angriffskraft für den nächsten Angriff abgezogen ")
        endboss.hp -= schaden
        endboss.atk -= 20
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")


    }

    fun brutalSmash(boese: MutableList<Endboss>) {
        val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht einen Kritischen Treffer mit seinen Brutalen Schlag")
            println("BÄäÄääÄääÄÄÄÄM")
            schaden *= 2
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        } else {
            println("$name holt zu einem Brutalen Schlag aus")
            Thread.sleep(500)
            println("BÄÄÄÄÄM")
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        }
    }

    fun battleShout(team: MutableList<Held>) {
        if (battleShout >0) {
            println("Ein lauter Schrei ertönt und alle Helden bekommen zusätzliche Angriffskraft")
            for (i in team.indices)
                team[i].atk = atk + 40
                battleShout -=1
        }else println("Kampfschrei ist nicht mehr verfügbar")


    }

//    fun beutel(beutel:Beutel){
//
//
//    }
}