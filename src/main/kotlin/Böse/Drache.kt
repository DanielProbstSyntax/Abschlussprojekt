package Böse

import Held
import kotlin.random.Random
import kotlin.random.nextInt

class Drache(name: String, hp: Int, override var atk: Int, weapon: String, headbutt: Boolean) :
    Endboss(name, hp, atk, weapon, headbutt) {
    var minion = 1


    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }


    fun spikeShot(helden: MutableList<Held>) {
        val held = helden.random()

        if (!held.shild) {

            val schaden = (15..20).random() + atk
            println("$name hebt seine Arme in die Luft und erschafft unter ${held.name} spitze Stacheln")
            Thread.sleep(800)
            println("Die Erde bebt")
            Thread.sleep(800)
            println("ZAAAACK")
            held.hp -= schaden
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
            println("__ __ __ __ __ __ __ ")
            println(
                "  |`-._/\\_.-`|\n" +
                        "  |    ||    |\n" +
                        "  |___o()o___|\n" +
                        "  |__((<>))__|\n" +
                        " \\   o\\/o   /\n" +
                        "  \\   ||   /\n" +
                        "   \\  ||  /\n" +
                        "     '.||.'\n" +
                        "                ``"
            )
            println("__ __ __ __ __ __ __ ")
            println("${held.name} Blockt durch das Schild etwas Schaden vom Angriff")
            Thread.sleep(800)
            held.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${held.name} wurden $schaden HP abgezogen")
            println("${held.name} hat jetzt noch ${held.hp}")
            held.shild = false
            Thread.sleep(800)

        }

    }

    fun tailWhip(helden: MutableList<Held>) {
        val held = helden.random()
        var schaden = (15..20).random() + atk
        if (!held.shild) {
            println("$name dreht sich einmal schnell im Kreis und schlägt ${held.name} mit seinem Stachelbesetzten Schwanz zu")
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
            println("$name dreht sich einmal schnell im Kreis und schlägt ${held.name} mit seinem Stachelbesetzten Schwanz zu")
            Thread.sleep(500)
            println("....")
            Thread.sleep(800)
            println("ZISCHHH wie eine Peitsche")
            Thread.sleep(800)
            println("__ __ __ __ __ __ __ ")
            println(
                "  |`-._/\\_.-`|\n" +
                        "  |    ||    |\n" +
                        "  |___o()o___|\n" +
                        "  |__((<>))__|\n" +
                        " \\   o\\/o   /\n" +
                        "  \\   ||   /\n" +
                        "   \\  ||  /\n" +
                        "     '.||.'\n" +
                        "                ``"
            )
            println("__ __ __ __ __ __ __ ")
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
        println("                          .\n" +
                "                          /  , /\n" +
                "                        ,/' /`'\n" +
                "                       /(/`'   _\n" +
                "                      f'/)  ,-'\n" +
                "                     /    ,' itz\n" +
                "                    f,/  /\n" +
                "                    /\"  7\n" +
                "                   / ,f /\n" +
                "              )   / / |J\n" +
                "                 7,( ;|j\n" +
                "      ,       (. \"`/ ('\n" +
                "          `    )`-'/ l `\n" +
                "    (  (    ) '   ' (_,'  )\n" +
                " (     ,)  7`  /  /,  (, (\n" +
                "  ,  ) (,- `-'  /  (,   -') (\n" +
                " (_ ( `-_(,_,'_(_(__ )_, _`-_, _")
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
        for (held in helden) {
            if (!held.shild) {
                held.hp -= schaden
                println("__ __ __ __ __ __ __ ")
                println("${held.name} wurde $schaden Schaden zugefügt")
                Thread.sleep(800)

            } else {
                println("__ __ __ __ __ __ __ ")
                println(
                    "  |`-._/\\_.-`|\n" +
                            "  |    ||    |\n" +
                            "  |___o()o___|\n" +
                            "  |__((<>))__|\n" +
                            "  \\   o\\/o   /\n" +
                            "   \\   ||   /\n" +
                            "    \\  ||  /\n" +
                            "      '.||.'\n "
                )

                println("__ __ __ __ __ __ __ ")
                Thread.sleep(800)
                println("${held.name} hatte ein Schild aktiv und reduziert damit den Schaden")
                Thread.sleep(800)
                schaden = (5..10).random() + atk
                held.hp -= schaden
                println("__ __ __ __ __ __ __ ")
                println("${held.name} wurde $schaden Schaden zugefügt")

            }

        }
    }

    fun minion(helden: MutableList<Held>) {

        if (minion > 0) {
            println("__ __ __ __ __ __ __ ")
            println(
                "      ___       ___  ___  __      __   ___  __   __             __   __   ___      \n" +
                        "|__| |__  |    |__  |__  |__)    |__) |__  /__` /  ` |__| |  | /  \\ |__) |__  |\\ | \n" +
                        "|  | |___ |___ |    |___ |  \\    |__) |___ .__/ \\__, |  | |/\\| \\__/ |  \\ |___ | \\| \n" +
                        "                                                                                   "
            )
            println("__ __ __ __ __ __ __ ")
            helfer = true
            minion = 0
        } else {
            println("Der Drache ist zu schwach um einen neuen Helfer zu beschwören. Er greift trotzdem an!!!")
            println("__ __ __ __ __ __ __ ")
            if (flüche == 1) {
                val randomAttack = Random.nextInt(1, 5)
                when (randomAttack) {
                    1 -> spikeShot(helden)
                    2 -> tailWhip(helden)
                    3 -> firebreath(helden)
                    4 -> earthquake(helden)
                    5 -> fluch(helden)
                }
            } else {
                val randomAttack = Random.nextInt(1, 4)
                when (randomAttack) {
                    1 -> spikeShot(helden)
                    2 -> tailWhip(helden)
                    3 -> firebreath(helden)
                    4 -> earthquake(helden)

                }

            }

        }


    }

    fun fluch(helden: MutableList<Held>) {


        val held = helden.random()
        if (!held.verflucht && flüche == 1) {

            println(
                " ___            __       \n" +
                        "|__  |    |  | /  ` |__| \n" +
                        "|    |___ \\__/ \\__, |  | \n" +
                        "                         "
            )
            println("__ __ __ __ __ __ __ ")
            held.verflucht = true
            flüche = 0

            println("${held.name} ist jetzt verflucht bis die Lebenspunkte bei 20 % angekommen sind")


        } else println("${held.name} ist schon verflucht.")
    }

    fun angriff(helden: MutableList<Held>) {


        println(
            " __   __   __   __   __             __   ___ \n" +
                    "|__) /  \\ /__` /__` |__) |  | |\\ | |  \\ |__  \n" +
                    "|__) \\__/ .__/ .__/ |  \\ \\__/ | \\| |__/ |___ \n" +
                    "                                             "
        )
        println("__ __ __ __ __ __ __ ")
        Thread.sleep(800)

        if (flüche == 1) {
            val randomAttack = Random.nextInt(1, 6)
            when (randomAttack) {
                1 -> spikeShot(helden)
                2 -> tailWhip(helden)
                3 -> firebreath(helden)
                4 -> earthquake(helden)
                5 -> minion(helden)
                6 -> fluch(helden)
            }
        } else {
            val randomAttack = Random.nextInt(1, 5)
            when (randomAttack) {
                1 -> spikeShot(helden)
                2 -> tailWhip(helden)
                3 -> firebreath(helden)
                4 -> earthquake(helden)
                5 -> minion(helden)
            }

        }

    }

    fun dracheBesiegt() {
        println(" __   __        __        ___     __   ___  __     ___  __  ___ \n" +
                "|  \\ |__)  /\\  /  ` |__| |__     |__) |__  /__` | |__  / _`  |  \n" +
                "|__/ |  \\ /~~\\ \\__, |  | |___    |__) |___ .__/ | |___ \\__>  |  \n" +
                "                                                                ")

    }

}