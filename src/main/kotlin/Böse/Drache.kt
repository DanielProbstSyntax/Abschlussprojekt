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

        if (!held.shild) {

            val schaden = (20..30).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(800)
            println("Die Erde bebt")
            Thread.sleep(800)
            println("ZAAAACK")
            held.hp -= schaden
            if (held.hp < 0){
                held.hp = 0
            }
            Thread.sleep(800)
            println("__ __ __ __ __ __ __ ")
            println("${held.name} wurden $schaden HP abgezogen")
            println("${held.name} hat jetzt noch ${held.hp}")
            Thread.sleep(800)

        } else {
            val schaden = (10..15).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(800)
            println("Die Erde bebt")
            Thread.sleep(800)
            println("ZAAAACK")
            println("${held.name} Blockt durch das Schild etwas Schaden vom Angriff")
            Thread.sleep(800)
            held.hp -= schaden
            if (held.hp < 0){
                held.hp = 0
            }
            println("__ __ __ __ __ __ __ ")
            println("${held.name} wurden $schaden HP abgezogen")
            println("${held.name} hat jetzt noch ${held.hp}")
            held.shild = false
            Thread.sleep(800)

        }

    }

    fun tailWhip(helden: MutableList<Held>) {
        val held = helden.random()
        var schaden = (20..30).random() + atk
        if (!held.shild) {
            println("$name dreht sich einmal schnell im Kreis und schlägt mit deinem Stachelbesetzten Schwanz zu")
            Thread.sleep(800)
            println("....")
            Thread.sleep(800)
            println("ZISCHHH wie eine Peitsche")
            Thread.sleep(800)
            held.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
            Thread.sleep(800)

        } else {
            schaden = (10..15).random() + atk
            println("$name dreht sich einmal schnell im Kreis und schlägt mit deinem Stachelbesetzten Schwanz zu")
            Thread.sleep(500)
            println("....")
            Thread.sleep(800)
            println("ZISCHHH wie eine Peitsche")
            Thread.sleep(800)
            println("${held.name} aber, Blockt durch sein Schild etwas Schaden vom Angriff")
            Thread.sleep(800)
            held.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
            held.shild = false

        }


    }

    fun firebreath(helden: MutableList<Held>) {
        println("Der Drache $name holt tiieeeffff Luft uuuund ...")
        Thread.sleep(800)
        println("trifft alle Helden mit seinem Flammenatem")
        Thread.sleep(800)
        var schaden = (10..15).random() + atk
        for (i in helden.indices) {
            helden[i].hp -= schaden
        }
        println("__ __ __ __ __ __ __ ")
        println("Den Helden wurden $schaden Lebenspunkte abgezogen")
        Thread.sleep(800)


    }

    fun earthquake(helden: MutableList<Held>) {
        println("Plötzlich springt der Drache hoch in die Luft, schwingt einmal stark mit deinen Flügeln und")
        println("rast auf den Boden zu. Als er aufkommt entsteht ein heftiges Erdbeben")
        var schaden = (10..15).random() + atk
        for (i in helden.indices) {
            helden[i].hp -= (10..15).random() + atk
            println("__ __ __ __ __ __ __ ")
            println("${helden[i].name} wurde $schaden zugefügt")
        }

    }

    fun minion() {

        if (minion > 0) {
            println("__ __ __ __ __ __ __ ")
            println("      ___       ___  ___  __      __   ___  __   __             __   __   ___      \n" +
                    "|__| |__  |    |__  |__  |__)    |__) |__  /__` /  ` |__| |  | /  \\ |__) |__  |\\ | \n" +
                    "|  | |___ |___ |    |___ |  \\    |__) |___ .__/ \\__, |  | |/\\| \\__/ |  \\ |___ | \\| \n" +
                    "                                                                                   ")
            println("__ __ __ __ __ __ __ ")
            helfer = true
            minion = 0
            }else println("Keine Kraft mehr um den Helfer zu beschwören")


    }

    fun fluch(helden: MutableList<Held>) {
        val held = helden.random()
        println("__ __ __ __ __ __ __ ")
        println(" ___            __       \n" +
                "|__  |    |  | /  ` |__| \n" +
                "|    |___ \\__/ \\__, |  | \n" +
                "                         ")
        println("__ __ __ __ __ __ __ ")

        if (!held.verflucht && held.flüche == 0) {

            held.verflucht = true
            held.flüche +1
            println("${held.name} ist jetzt verflucht bis die Lebenspunkte bei 20 % angekommen sind")


        }else println("${held.name} ist schon verflucht.")
    }

    fun angriff(helden: MutableList<Held>){
        if (hp < 0) {
            hp = 0
        }
        println("__ __ __ __ __ __ __ ")
        println(" __   __   __   __   __             __   ___ \n" +
                "|__) /  \\ /__` /__` |__) |  | |\\ | |  \\ |__  \n" +
                "|__) \\__/ .__/ .__/ |  \\ \\__/ | \\| |__/ |___ \n" +
                "                                             ")
        println("__ __ __ __ __ __ __ ")
        Thread.sleep(800)
        //var randomAttack = Random.nextInt(1,6)
        var randomAttack = 5
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