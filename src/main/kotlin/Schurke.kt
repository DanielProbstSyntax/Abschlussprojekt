import Böse.Endboss
import kotlin.random.Random

class Schurke(
    name: String,
    maxHp: Int,
    weapon: String,
    atk: Int,
    stealth: Boolean,
    var crit: Int,
    shild: Boolean = false,
    ausweichen: Boolean
) : Held(name, maxHp, weapon, atk, stealth, shild, ausweichen) {



    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte, $atk Angriffskraft und kämpft mit einem $weapon"
    }

    fun hinterhalt(endboss: Endboss) {
        val drache = endboss // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht sich unsichtbar, schleicht sich hinter ${drache.name} und ...")
            Thread.sleep(800)
            println("... sticht mit einen Kritischen Treffer mehrere male schnell zu.(doppelter Schaden)")
            Thread.sleep(800)
            schaden *= 2
            drache.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
            Thread.sleep(800)
        } else {
            println("$name macht sich unsichtbar, schleicht sich hinter ${drache.name} und ...")
            Thread.sleep(800)
            println("... sticht mehrere male schnell zu.")
            Thread.sleep(800)
            drache.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${drache.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${drache.hp}")
            Thread.sleep(800)
        }


    }

    fun critHit(endboss: Endboss) {
        //val drache=boese.first // <---- NOCHMAL ABCHECKEN
        val criticalHit = Random.nextInt(1, 101) <= 100
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name wetzt seine Klinge am $weapon um einen garantiert Kritischen Treffer zu erziehlen.(doppelter Schaden)")
            Thread.sleep(800)
            println("${endboss.name} bekommt den $weapon in sein Fleisch gerammt")
            Thread.sleep(800)
            schaden *= 2
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)

        }

    }

    fun glühendeKlinge(endboss: Endboss) {
        println("$name lässt mit seiner Macht die Klinge des ${weapon}es glühen")
        Thread.sleep(800)

        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name schleicht zu ${endboss.name}...")
            Thread.sleep(1000)
            println("pssssst macht es! Der glühende Dolch steckt jetzt in ${endboss.name}ens Rücken")
            Thread.sleep(500)
            println("$name hat Glück, denn der Treffer war Kritisch (doppelter Schaden)")
            schaden *= 2
            endboss.hp -= schaden
            Thread.sleep(800)
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)
        } else {
            println("$name schleicht zu ${endboss.name}...")
            Thread.sleep(1000)
            println("pssssst macht es! Der glühende Dolch steckt jetzt in ${endboss.name}ens Rücken")
            Thread.sleep(500)
            schaden *= 2
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)
        }

    }

    fun dolchhieb(endboss: Endboss) {

        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name greift ${endboss.name} mit einem Ktitischen Dolchhieb an. (doppelter Schaden)")
            Thread.sleep(800)
            schaden *= 2
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)
        } else {
            println("$name greift ${endboss.name} mit einem Dolchhieb an")
            Thread.sleep(800)
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)


        }
    }

    fun angriffe(endboss: Endboss, beutel: MutableList<Beutel>, boese: MutableList<Endboss>) {

        if (verflucht && hp > maxHp * 0.2) {
            var schaden = maxHp * 0.1
            hp - schaden
            println("Durch den Fluch von ${endboss.name} hat $name $schaden HP verloren ")
            Thread.sleep(800)
        }
        if (verflucht && hp < maxHp * 0.2) {
            verflucht = false
            endboss.flüche = 1
            println("Der Fluch ist abgelaufen und verursacht keinen Schaden mehr")
            Thread.sleep(800)
        }


        Thread.sleep(800)
        var helfer = boese[1]
        var drache = boese[0]
        if (!besiegt) {
            println("$name ist jetzt dran")
            println("Seine HP sind: $hp")
            println("__ __ __ __ __ __ __ ")

            if (endboss.helfer) {

                chooseAktion()
                var x = readln().toInt()
                when (x) {
                    1 -> hinterhalt(helfer)
                    2 -> critHit(helfer)
                    3 -> glühendeKlinge(helfer)
                    4 -> dolchhieb(helfer)
                    5 -> usePotion(beutel)

                }

            } else {
                chooseAktion()
                var x = readln().toInt()
                when (x) {
                    1 -> hinterhalt(drache)
                    2 -> critHit(drache)
                    3 -> glühendeKlinge(drache)
                    4 -> dolchhieb(drache)
                    5 -> usePotion(beutel)


                }

            }

            if (endboss.helfer && helfer.hp <= 0) {
                endboss.helfer = false
                println(
                    "      ___       ___  ___  __      __   ___  __     ___  __  ___ \n" +
                            "|__| |__  |    |__  |__  |__)    |__) |__  /__` | |__  / _`  |  \n" +
                            "|  | |___ |___ |    |___ |  \\    |__) |___ .__/ | |___ \\__>  |  \n" +
                            "                                                                "
                )
                Thread.sleep(800)
            }
        }else println("Der Held ist tot")


    }

    private fun chooseAktion() {
        println("Wähle eine Aktion")
        Thread.sleep(400)
        println("1 für Hinterhalt")
        Thread.sleep(400)
        println("2 für Kritischer Treffer")
        Thread.sleep(400)
        println("3 für Glühende Klinge")
        Thread.sleep(400)
        println("4 für Dolchhieb")
        Thread.sleep(400)
        println("5 um den Beutel zu benutzen")
        println("__ __ __ __ __ __ __ ")
    }

    fun tot() {
        besiegt = true
        println("                              /`._      ,\n" +
                "                             /     \\   / \\\n" +
                "                             ) ,-==-> /\\/ \\\n" +
                "                              )__\\\\/ // \\  |\n" +
                "                             /  /' \\//   | |\n" +
                "                            /  (  /|/    | /\n" +
                "                           /     //|    /,'\n" +
                "                          // /  (( )    '\n" +
                "                         //     // \\    |\n" +
                "                        //     (#) |\n" +
                "                       /        )\\/ \\   '       ____\n" +
                "                      /        /#/   )         /,.__\\__,,--=_,\n" +
                "                     /         \\#\\  /)      __/ + \\____,--==<\n" +
                "                     //gnv_____/#/_/'      (\\_\\__+/_,   ---<^\n" +
                "                                                    '==--=='")
    }
}

