import Böse.Endboss
import kotlin.random.Random

class Schurke(name: String, hp: Int, weapon: String, atk: Int, stealth:Boolean, var crit:Int, shild:Boolean=false,ausweichen:Boolean):Held(name,hp,weapon,atk,stealth,shild,ausweichen) {


    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und kämpft mit einem $weapon"
    }

    fun hinterhalt(boese: MutableList<Endboss>){
        val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht sich unsichtbar, schleicht sich hinter ${drache.name} und ...")
            Thread.sleep(1000)
            println("... sticht mit einen Kritischen Treffer mehrere male schnell zu.")
            schaden *= 2
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        } else {
            println("$name macht sich unsichtbar, schleicht sich hinter ${drache.name} und ...")
            Thread.sleep(500)
            println("... sticht mehrere male schnell zu.")
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        }


    }
    fun critHit(boese: MutableList<Endboss>){
        val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= 100
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name wetzt seine Klinge am $weapon um einen garantiert Kritischen Treffer zu erziehlen.")
            Thread.sleep(1000)
            println("${drache.name} bekommt den $weapon in sein Fleisch gerammt")
            schaden *= 2
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        }

    }
    fun dodge(){
        println("$name setzt 'Ausweichen' ein und hat damit die Chance den nächsten Angriff auszuweichen")
        ausweichen = true

//        val canDodgeAttack = ausweichen && Random.nextBoolean()
//
//        if (canDodgeAttack) {
//            println("$name weicht dem Angriff des Drachen aus!")
//        } else {
//            println("$name wurde vom Drachen angegriffen!")
//            // Hier kannst du den Schaden verarbeiten oder entsprechend reagieren
//        }
    }

    fun basicAttack(boese: MutableList<Endboss>){
        val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name greift ${drache.name} mit einer Ktitischen Standartattacke an")
            Thread.sleep(1000)
            schaden *= 2
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
        } else {
            println("$name greift ${drache.name} mit einer Standartattacke an")
            Thread.sleep(500)
            drache.hp -= schaden
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")


        }
    }



}