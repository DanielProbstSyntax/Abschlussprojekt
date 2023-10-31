package Böse

import Held
import Krieger

class Drache(name: String, hp: Int, override var atk: Int, weapon: String,headbutt:Boolean) : Endboss(name, hp, atk, weapon,headbutt) {


    fun spikeShot(helden: MutableList<Held>) {
        val held=helden.random()
        if (!held.shild) {

            val schaden = (20..30).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(500)
            println("Die Erde bebt")
            Thread.sleep(1500)
            println("ZAAAACK")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")

        } else {
            val schaden = (10..15).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(500)
            println("Die Erde bebt")
            Thread.sleep(1500)
            println("ZAAAACK")
            println("${held.name} kann gerade noch so sein Schild unter sich schmeißen und Blockt etwas Schaden")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
            held.shild = false

        }

    }
    fun tailWhip(held: Held){
        val schaden = (25..40).random() + atk
        println("$name bereitet einen ")



    }

}