package Böse

import Beutel
import Held
import kotlin.random.Random

class Helfer(name: String, hp: Int, atk: Int, weapon: String, headbutt: Boolean, var alive: Boolean = false) :
    Endboss(name, hp, atk, weapon, headbutt) {
    var heal = 1

    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }
//    fun steal(beutel: Beutel) { // Hilfe von ChatGPT
//        val gestohleneTrankart: String
//        val trankArt = listOf("Heiltrank", "Stärkungstrank")
//
//        val zufallsIndex = Random.nextInt(trankArt.size)
//        gestohleneTrankart = trankArt[zufallsIndex]
//
//
//        when (gestohleneTrankart) {
//            "Heiltrank" -> {
//                if (beutel.heiltrank.anzahl > 0) {
//                    beutel.heiltrank.anzahl--
//                    println("$name hat einen Heiltrank aus dem Beutel gestohlen.")
//
//                } else {
//                    println("$name konnte keinen Trank stehlen")
//                }
//            }
//
//            "Stärkungstrank" -> {
//                if (beutel.stärkungstrank.anzahl > 0) {
//                    beutel.stärkungstrank.anzahl--
//                    println("$name hat einen Stärkungstrank aus dem Beutel gestohlen.")
//
//                } else {
//                    println("$name konnte keinen Trank stehlen")
//                }
//            }
//        }
//
//    }

    fun stehlen(beutel: Beutel) {
        var xx = beutel.inhalt.random()
        xx.anzahl -= 1
        println("Ein ${xx.name} wurde gestohlen")
        println(beutel.inhalt)
    }

    fun punsh(helden: MutableList<Held>) {
        val held = helden.random()
        var schaden = (20..30).random() + atk
        if (!held.shild) {
            println("$name rennt auf ${held.name} zu und gibt ihm einen harten Schlag ins Gesicht")
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("PATSCH, in youuur FACE")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")

        } else {
            schaden = (10..15).random() + atk
            println("$name rennt auf ${held.name} zu und will ihm einen schlag ins Gesicht geben")
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("ABER")
            println("${held.name} hebt schnell sein Schild und blockt etwas Schaden ab")
            held.hp -= schaden
            println("${held.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${held.hp}")
            held.shild = false

        }
    }

    fun heal(boese: MutableList<Endboss>) {
        if (heal > 0) {
            println("$name beginnt komische Worte zu flüstern, keiner versteht was er sagt")
            Thread.sleep(800)
            println("Zyrkthar")
            Thread.sleep(800)
            println("Quelthandor")
            Thread.sleep(800)
            println("Fyrrnol")
            Thread.sleep(800)
            println("Drystonix")
            Thread.sleep(800)
            println("Glymboros")
            Thread.sleep(800)
            println("Vrylthara")
            Thread.sleep(800)
            println("........ stille kehrt ein.....")
            Thread.sleep(2000)



            println("Die Wörter ergeben einen Heilzauber die auf ${boese.first.name} gewirkt haben")
            boese.first.hp += 50
        } else println("$name wollte einen Heilzauber sprechen, hat aber nicht genug Energie dafür")
    }
    fun kick(helden: MutableList<Held>) {
        val held = helden.random()
        var schaden = (20..30).random() + atk
        if (held.shild) {
            println("$name springt in die Luft und gibt allen Helden einen heftigen Roundhousekick" )
            Thread.sleep(800)
            println("Die Attacke ist so stark, dass die Schilde der Helden keine Wirkung zeigen")
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("BAFFFF, $held klatschen auf den Boden und rutschen 5 m weit.")
            for (i in helden.indices) {
                helden[i].hp - schaden
            }
            println("$held wurden $schaden HP abgezogen")
            for (i in helden.indices) {
            println("Sie haben jetzt noch ${helden[i].hp}")
            }
            for (i in helden.indices) {
                helden[i].shild = false
            }


        } else {
            println("$name springt in die Luft und gibt allen Helden einen heftigen Roundhousekick" )
            Thread.sleep(500)
            println("....")
            Thread.sleep(1500)
            println("BAFFFF, $held klatschen auf den Boden und rutschen 5 m weit.")
            for (i in helden.indices) {
                helden[i].hp - schaden
            }
            println("$held wurden $schaden HP abgezogen")
            for (i in helden.indices) {
                println("Sie haben jetzt noch ${helden[i].hp}")
            }

        }
    }


}