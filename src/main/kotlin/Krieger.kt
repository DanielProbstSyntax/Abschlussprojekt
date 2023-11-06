import Böse.Drache
import Böse.Endboss
import kotlin.random.Random

class Krieger(
    name: String,
    hp: Int,
    weapon: String,
    atk: Int,
    var crit: Int,
    shild: Boolean,
    stealth: Boolean,
    ausweichen: Boolean
) :
    Held(name, hp, weapon, atk, shild, stealth, ausweichen) {
    var battleShout = 1

    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und kämpft mit einer $weapon"
    }


    fun shildblock() {
        println("$name hebt sein Schild um den nächsten Angriff zu Blocken")
        shild = true


    }

    fun headbutt(endboss: Endboss) { // NICHT FERTIG
        var schaden = (30..60).random() //+ atk
        println("$name nimmt anlauf und rammt seinen Kopf mit aller Wucht gegen ${endboss.name}s Schädel ")
        Thread.sleep(500)
        println("BOOOM - Es knall laut und ${endboss.name} ist benommen. Ihm wurde etwas Angriffskraft für den nächsten Angriff abgezogen ")
        endboss.hp -= schaden
        //endboss.atk -= 20
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")


    }

    fun brutalSmash(endboss: Endboss) {
        //val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht einen Kritischen Treffer mit seinen Brutalen Schlag")
            Thread.sleep(1000)
            println("BÄäÄääÄääÄÄÄÄM")
            Thread.sleep(1000)
            schaden *= 2
            endboss.hp -= schaden
            println("${endboss.name} wurden $schaden HP abgezogen")
            Thread.sleep(1000)
            println("Er hat jetzt noch ${endboss.hp}")
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
        if (battleShout > 0) {
            println("Ein lauter Schrei ertönt und alle Helden bekommen zusätzliche Angriffskraft")
            for (i in team.indices)
                team[i].atk = atk + 40
            battleShout = 0
        } else {
            println("Kampfschrei ist nicht mehr verfügbar")

        }


    }

    fun tot() {
        besiegt = true

    }

    fun angriffe(endboss: Endboss, team: MutableList<Held>,beutel: MutableList<Beutel>) {
        if (hp < 0){
            hp = 0
        }
        if (verflucht && hp > maxHp*0.2){
            var schaden = maxHp * 0.1
            hp - schaden
        }
        if (hp < maxHp*0.2){
            verflucht = false

        }
        if (!verflucht){
            flüche-1
        }
        if (!besiegt) {
            println("$name ist jetzt dran")
            Thread.sleep(500)
            println("Wähle eine Aktion")
            Thread.sleep(500)
            println("1 für Schild-Block")
            Thread.sleep(500)
            println("2 für Kopfnuss")
            Thread.sleep(500)
            println("3 für Brutaler Schlag")
            Thread.sleep(500)
            println("4 für Kampfschrei")
            Thread.sleep(500)
            println("5 für Trank benutzen")
            var x = readln().toInt()
            when (x) {
                1 -> shildblock()
                2 -> headbutt(endboss)
                3 -> brutalSmash(endboss)
                4 -> battleShout(team)
                5 -> usePotion(beutel)

            }
            if (verflucht){
                var schaden = maxHp * 0.1
                hp - schaden
                println("Es wurden $schaden Schaden durch einen Fluch verursacht")
            }

        } else {
            println("$name kann nicht angreifen, da er bereits besiegt wurde.")
        }


    }


}