import Böse.Drache
import Böse.Endboss

class Krieger(name: String, hp: Int, weapon: String, atk: Int, crit:Boolean, shild: Boolean = true, stealth:Boolean):Held(name,hp,weapon,atk,stealth,) {

    fun shildblock(drache: Drache){
        var schadenBlocken = drache.schaden


    }
    fun headbutt(){


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