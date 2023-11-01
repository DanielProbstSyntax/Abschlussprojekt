import Böse.Drache
import Böse.Endboss
import kotlin.random.Random

open class Krieger(name: String, hp: Int, weapon: String, atk: Int, var crit: Int, shild: Boolean, stealth: Boolean) :
    Held(name, hp, weapon, atk, stealth, shild) {

    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }

    fun shildblock() {
        println("$name hebt sein Schild um den nächsten Angriff zu Blocken")
        shild = true


    }

    fun headbutt(endboss: Endboss) {
        var schaden = (30..60).random() + atk
        println("$name nimmt anlauf und rammt seinen Kopf mit aller Wucht gegen ${endboss.name}s Schädel ")
        Thread.sleep(500)
        println("BOOOM - Es knall laut und ${endboss.name} ist benommen. Ihm wurde etwas Angriffskraft für den nächsten Angriff abgezogen ")
        endboss.hp -= schaden
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")


    }

    fun brutalSmash(boese: MutableList<Endboss>) {
        val drache=boese.first
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht einen Kritischen Treffer mit seinen Brutalen Schlag")
            schaden *= 2
            endboss.hp -= schaden
        } else {
            println("$name holt zu einem Brutalen Schlag aus")
            Thread.sleep(500)
            println("BÄÄÄÄÄM")
            endboss.hp -= schaden
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
        }
    }

    fun battleShout(team: MutableList<Held>) {
        println("Ein lauter Schrei ertönt und alle Helden bekommen zusätzliche Angriffskraft für den nächsten Angriff")
        for (i in team.indices)
            team[i].atk = atk + 40


    }

//    fun beutel(beutel:Beutel){
//
//
//    }
}