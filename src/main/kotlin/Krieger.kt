import Böse.Endboss
import kotlin.random.Random

class Krieger(
    name: String,
    maxHp: Int,
    weapon: String,
    atk: Int,
    var crit: Int,
    shild: Boolean,
    verflucht: Boolean

) :
    Held(name, maxHp, weapon, atk, shild,verflucht) {
    var battleShout = 1

    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte, $atk Angriffskraft und kämpft mit einer $weapon"
    }


    fun shildblock() {
        println("__ __ __ __ __ __ __ ")
        println("  |`-._/\\_.-`|\n" +
                "  |    ||    |\n" +
                "  |___o()o___|\n" +
                "  |__((<>))__|\n" +
                "  \\   o\\/o   /\n" +
                "   \\   ||   /\n" +
                "    \\  ||  /\n" +
                "      '.||.'\n" +
                "                ``")
        println("__ __ __ __ __ __ __ ")
        Thread.sleep(800)
        println("$name hebt sein Schild um den nächsten Angriff zu Blocken")
        shild = true
        Thread.sleep(800)


    }

    fun headbutt(endboss: Endboss) {
        var schaden = (30..60).random() + atk
        println("$name nimmt anlauf und rammt seinen Kopf mit aller Wucht gegen ${endboss.name}s Schädel ")
        Thread.sleep(800)
        println("BOOOM - Es knall laut und ${endboss.name} ist benommen.")
        Thread.sleep(800)
        endboss.hp -= schaden
        println("__ __ __ __ __ __ __ ")
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")
        Thread.sleep(800)


    }

    fun brutalSmash(endboss: Endboss) {

        val criticalHit = Random.nextInt(1, 101) <= crit
        var schaden = (30..60).random() + atk
        if (criticalHit) {
            println("$name macht einen Kritischen Treffer mit seinen Brutalen Schlag(Doppelter Schaden")
            Thread.sleep(800)
            println("BÄäÄääÄääÄÄÄÄM")
            Thread.sleep(800)
            schaden *= 2
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)
        } else {
            println("$name holt zu einem Brutalen Schlag aus")
            Thread.sleep(800)
            println("BÄÄÄÄÄM")
            Thread.sleep(800)
            endboss.hp -= schaden
            println("__ __ __ __ __ __ __ ")
            println("${endboss.name} wurden $schaden HP abgezogen")
            println("Er hat jetzt noch ${endboss.hp}")
            Thread.sleep(800)
        }
    }

    fun battleShout(team: MutableList<Held>) {
        if (battleShout > 0) {
            println("Ein lauter Schrei ertönt und alle Helden bekommen zusätzliche Angriffskraft")
            Thread.sleep(800)
            for (i in team.indices)
                team[i].atk = atk + 40
            battleShout = 0
        } else {
            println("Kampfschrei ist nicht mehr verfügbar")
            Thread.sleep(800)

        }


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

    fun angriffe(endboss: Endboss, team: MutableList<Held>, beutel: MutableList<Beutel>, boese: MutableList<Endboss>) {

        if (verflucht && hp > maxHp * 0.2) {
            var schaden = (maxHp * 0.1).toInt()
            hp -= schaden
            println("Durch den Fluch von ${endboss.name} hat $name $schaden HP verloren ")
            Thread.sleep(800)
        }
        if (verflucht && hp < maxHp * 0.2) {
            verflucht = false
             endboss.flüche = 0
            println("Der Fluch ist abgelaufen und verursacht keinen Schaden mehr")
            Thread.sleep(800)
        }


        var helfer = boese[1]
        var drache = boese[0]

        if (!besiegt) {
            println("$name ist jetzt dran")
            println("Seine HP sind: $hp")
            println("__ __ __ __ __ __ __ ")
            if (endboss.helfer && helfer.hp <= 0) {
                endboss.helfer = false
                println("Der Helfer wurde besiegt")
                Thread.sleep(800)
            }


            if (endboss.helfer) {

                chooseAktion()
                var x = readln().toInt()
                when (x) {
                    1 -> shildblock()
                    2 -> headbutt(helfer)
                    3 -> brutalSmash(helfer)
                    4 -> battleShout(team)
                    5 -> usePotion(beutel)

                }


            } else {
                chooseAktion()
                println("__ __ __ __ __ __ __ ")
                var x = readln().toInt()
                when (x) {
                    1 -> shildblock()
                    2 -> headbutt(drache)
                    3 -> brutalSmash(drache)
                    4 -> battleShout(team)
                    5 -> usePotion(beutel)

                }

            }

        } else println("$name ist Tot und und kann nicht mehr kämpfen")

        if (endboss.helfer && helfer.hp <= 0) {
            endboss.helfer = false
            println(
                "         ___       ___  ___  __   __      ___  __   ___   __   ___ \n" +
                        "|__| |__  |    |__  |__  |__)    |__) |__  /__` | |__  / _`  |  \n" +
                        "|  | |___ |___ |    |___ |  \\    |__) |___ .__/ | |___ \\__>  |  \n" +
                        "                                                                "
            )
            Thread.sleep(800)
        }

    }

    private fun chooseAktion() {
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
    }
//    fun chooseAktion2(){
//        Thread.sleep(500)
//        println("Wähle eine Aktion")
//        Thread.sleep(500)
//        println("1 für Schild-Block")
//        Thread.sleep(500)
//        println("2 für Kopfnuss")
//        Thread.sleep(500)
//        println("3 für Brutaler Schlag")
//        Thread.sleep(500)
//        println("4 für Kampfschrei")
//        Thread.sleep(500)
//        println("5 für Trank benutzen")
//    }



}