package Böse

import Held
import Krieger
import kotlin.random.Random

class Drache(name: String, hp: Int, override var atk: Int, weapon: String, headbutt: Boolean) :
    Endboss(name, hp, atk, weapon, headbutt) {
    var minion = 1



    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }


    fun spikeShot(helden: MutableList<Held>) {
        val held = helden.random()
        // FUNKTION NICHT FERTIG
//        val canDodgeAttack = held.ausweichen && Random.nextBoolean()
//            if (canDodgeAttack) {
//                println("${held.name} weicht dem Angriff des Drachen aus!")
//            } else {
//                println("$name wurde vom Drachen angegriffen!")
//                // Hier kannst du den Schaden verarbeiten oder entsprechend reagieren
//            }


        if (!held.shild) {

            val schaden = (20..30).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(500)
            println("Die Erde bebt")
            Thread.sleep(1500)
            println("ZAAAACK")
            held.hp -= schaden
            if (held.hp < 0){
                held.hp = 0
            }
            println("${held.name} wurden $schaden HP abgezogen")
            println("${held.name} hat jetzt noch ${held.hp}")

        } else {
            val schaden = (10..15).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(500)
            println("Die Erde bebt")
            Thread.sleep(1500)
            println("ZAAAACK")
            println("${held.name} Blockt durch das Schild etwas Schaden vom Angriff")
            held.hp -= schaden
            if (held.hp < 0){
                held.hp = 0
            }
            println("${held.name} wurden $schaden HP abgezogen")
            println("${held.name} hat jetzt noch ${held.hp}")
            held.shild = false

        }

    }

    fun tailWhip(helden: MutableList<Held>) {
        val held = helden.random()
        var schaden = (20..30).random() + atk
        if (!held.shild) {
            println("$name dreht sich einmal schnell im Kreis und schlägt mit deinem Stachelbesetzten Schwanz zu")
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("ZISCHHH wie eine Peitsche")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")

        } else {
            schaden = (10..15).random() + atk
            println("$name dreht sich einmal schnell im Kreis und schlägt mit deinem Stachelbesetzten Schwanz zu")
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("ZISCHHH wie eine Peitsche")
            println("${held.name} aber, Blockt durch sein Schild etwas Schaden vom Angriff")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
            held.shild = false

        }


    }

    fun firebreath(helden: MutableList<Held>) {
        println("Der Drache $name holt tiieeeffff Luft uuuund ...")
        Thread.sleep(500)
        println("trifft alle Helden mit seinem Flammenatem")
        var schaden = (10..15).random() + atk
        for (i in helden.indices) {
            helden[i].hp -= schaden
        }

        println("Den Helden wurden $schaden Lebenspunkte abgezogen")
        //println("Ihr aktuelles Leben beträgt ${helden[i].hp}")

    }

    fun earthquake(helden: MutableList<Held>) {
        println("Plötzlich springt der Drache hoch in die Luft, schwingt einmal stark mit deinen Flügeln und")
        println("rast auf den Boden zu. Als er aufkommt entsteht ein heftiges Erdbeben")
        var schaden = (10..15).random() + atk
        for (i in helden.indices) {
            helden[i].hp -= (10..15).random() + atk
            println("${helden[i].name} wurde $schaden zugefügt")
        }

    }

    fun minion() {

        if (minion > 0) {
            println("$name hat seinen Helfer beschworen")
            helfer = true
            minion = 0
            }else println("Keine Kraft mehr um den Helfer zu beschwören")


    }

    fun fluch(helden: MutableList<Held>) {
        val held = helden.random()

        if (!held.verflucht && held.flüche == 0) {

            held.verflucht = true
            held.flüche +1
            println("${held.name} ist jetzt verflucht bis seine Lebenspunkte bei 20 % angekommen sind")


        }else println("${held.name} ist schon verflucht.")
    }

    fun angriff(helden: MutableList<Held>){
        if (hp < 0) {
            hp = 0
        }
        //var randomAttack = Random.nextInt(1,6)
        var randomAttack = 6


        when(randomAttack){
            1 -> spikeShot(helden)
            2 -> tailWhip(helden)
            3 -> firebreath(helden)
            4 -> earthquake(helden)
            5 -> minion()
            6 -> fluch(helden)
        }
    }

    fun dracheBesiegt(){
        println("Das Spiel ist zu Ende")

    }

}