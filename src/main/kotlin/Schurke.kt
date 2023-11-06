import Böse.Endboss
import kotlin.random.Random

class Schurke(
    name: String,
    hp: Int,
    weapon: String,
    atk: Int,
    stealth: Boolean,
    var crit: Int,
    shild: Boolean = false,
    ausweichen: Boolean
) : Held(name, hp, weapon, atk, stealth, shild, ausweichen) {


    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und kämpft mit einem $weapon"
    }

    fun hinterhalt(endboss: Endboss) {
        val drache = endboss // <---- NOCHMAL ABCHECKEN
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

    fun critHit(endboss: Endboss) {
        //val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= 100
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name wetzt seine Klinge am $weapon um einen garantiert Kritischen Treffer zu erziehlen.")
            Thread.sleep(1000)
            println("${endboss.name} bekommt den $weapon in sein Fleisch gerammt")
            schaden *= 2
            endboss.hp -= schaden
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
        }

    }

    fun dodge() {
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

    fun dolchhieb(endboss: Endboss) {
        //val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name greift ${endboss.name} mit einem Ktitischen Dolchhieb an")
            Thread.sleep(1000)
            schaden *= 2
            endboss.hp -= schaden
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
        } else {
            println("$name greift ${endboss.name} mit einem Dolchhieb an")
            Thread.sleep(500)
            endboss.hp -= schaden
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")


        }
    }

    fun angriffe(endboss: Endboss, beutel: MutableList<Beutel>, boese: MutableList<Endboss>) {
        if (hp < 0) {
            hp = 0
        }
        if (verflucht && hp > maxHp * 0.2) {
            var schaden = maxHp * 0.1
            hp - schaden
        }
        if (hp < maxHp * 0.2) {
            verflucht = false

        }
        if (!verflucht) {
            flüche - 1
        }

        println("$name ist jetzt dran")
        var helfer = boese[1]
        var drache = boese[0]
        if (endboss.helfer) {

            println("Wähle eine Aktion")
            println("1 für Hinterhalt")
            println("2 für Kritischer Treffer")
            println("3 für Ausweichen")
            println("4 für Dolchhieb")
            var x = readln().toInt()
            when (x) {
                1 -> hinterhalt(helfer)
                2 -> critHit(helfer)
                3 -> dodge()
                4 -> dolchhieb(helfer)
                5 -> usePotion(beutel)
            }

        } else {
            println("Wähle eine Aktion")
            println("1 für Hinterhalt")
            println("2 für Kritischer Treffer")
            println("3 für Ausweichen")
            println("4 für Dolchhieb")
            var x = readln().toInt()
            when (x) {
                1 -> hinterhalt(drache)
                2 -> critHit(drache)
                3 -> dodge()
                4 -> dolchhieb(drache)
                5 -> usePotion(beutel)


            }


        }




    }
    fun tot() {
        besiegt = true
        //println("$name wurde besiegt!")
    }
}

