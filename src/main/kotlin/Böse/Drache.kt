package Böse

import Held
import Krieger
import kotlin.random.Random

class Drache(name: String, hp: Int, override var atk: Int, weapon: String, headbutt: Boolean) :
    Endboss(name, hp, atk, weapon, headbutt) {
    var minion = 1
    var fluch = 1


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
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")

        } else {
            val schaden = (10..15).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(500)
            println("Die Erde bebt")
            Thread.sleep(1500)
            println("ZAAAACK")
            println("${held.name} Blockt durch sein Schild etwas Schaden vom Angriff")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
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
        for (i in helden.indices) {
            helden[i].hp -= (10..15).random() + atk
        }

    }

    fun minion(boese: MutableList<Endboss>) { // BTIMMT FALSCH
        var helfer = boese.filterIsInstance<Helfer>().first()
        if (minion > 0) {
            println("$name hat seinen Helfer beschworen")
            minion = 0
            helfer.alive = true

        } else {
            println("Zu schwach um einen Helfer zu beschwören")

        }


    }

    fun fluch(helden: MutableList<Held>) {
        val held = helden.random()
        if (fluch > 0) {
            held.verflucht = true

        }
    }

}