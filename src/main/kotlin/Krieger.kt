import Böse.Drache
import Böse.Endboss

open class Krieger(name: String, hp: Int, weapon: String, atk: Int, crit:Boolean,shild: Boolean, stealth:Boolean):Held(name,hp,weapon,atk,stealth,shild) {
    override fun toString(): String {
        return "$name: $hp HP"
    }

    fun shildblock(){
        println("$name hebt sein Schild um den nächsten Angriff zu Blocken")
        shild = true





    }
    fun headbutt(endboss: Endboss){
        var schaden = (30..60).random()+atk
        println("$name holt zu einem Brutalen Schlag aus")
        Thread.sleep(500)
        println("BÄÄÄÄÄM")
        endboss.hp -= schaden
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")


    }

    fun brutalSmash(endboss: Endboss){
        var schaden = (30..60).random()+atk
        println("$name holt zu einem Brutalen Schlag aus")
        Thread.sleep(500)
        println("BÄÄÄÄÄM")
        endboss.hp -= schaden
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")


    }

    fun battleShout(){

    }

//    fun beutel(beutel:Beutel){
//
//
//    }
}