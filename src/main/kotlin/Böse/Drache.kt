package Böse

import Held

class Drache(name:String, hp:Int, override var atk:Int, weapon:String):Endboss(name,hp,atk,weapon) {
    var schaden = (20..30).random()+atk

    open fun spikeShot(held: Held){


        println("$name hebt seine Armwe in die Luft in erschafft untern dem ${held.name} spitze Stacheln")
        Thread.sleep(500)
        println("Die Erde bebt")
        Thread.sleep(1500)
        println("ZAAAACK")
        held.hp -= schaden
        println("${held.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${held.hp}")

    }


}