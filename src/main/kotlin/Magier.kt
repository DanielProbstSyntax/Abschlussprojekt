import Böse.Endboss

class Magier(
    name: String,
    maxHp: Int,
    weapon: String,
    atk: Int,
    shild: Boolean = false,
    var crit: Int,
    stealth: Boolean,
    ausweichen: Boolean
) :
    Held(name, maxHp, weapon, atk, shild, stealth, ausweichen) {
    override fun toString(): String {
        return "$name: hat $maxHp Lebenspunkte, $atk Angriffskraft und kämpft mit einem $weapon"
    }

    fun heal(team: MutableList<Held>) {
        println("$name kanalisiert ihre Macht und will jemanden Heilen")
        Thread.sleep(800)
        var targetHeal = select(team)
        Thread.sleep(800)
        targetHeal.maxHp += 20
        println("__ __ __ __ __ __ __ ")
        println("${targetHeal.name} wurde um 20 geheilt")
        println("Er hat jetzt ${targetHeal.maxHp} Lebenspunkte")
        Thread.sleep(800)


    }

    fun shild() {
        println("$name erschafft eine Eisschild im sich um etwas schaden zu blocken")
        shild = true
        Thread.sleep(800)
    }

    fun lavaBurst(endboss: Endboss) {

        var schaden = (30..60).random() + atk
        println("$name faltet ihre Hände zusammen und kanalisiert einen Lavaschlag")
        Thread.sleep(800)
        println("Es knistert und ....")
        Thread.sleep(800)
        println("... ein riesiger Lavaball rast auf ${endboss.name} zu.")
        Thread.sleep(800)
        endboss.hp -= schaden
        println("__ __ __ __ __ __ __ ")
        println("${endboss.name} wurden $schaden HP abgezogen")
        println("Er hat jetzt noch ${endboss.hp}")
        Thread.sleep(800)

    }

    fun frostBlizzard(boese: MutableList<Endboss>) {
        var drache = boese
        var schaden = (30..60).random() + atk
        println("$name erschafft über den Gegnern ein Eisregen")
        Thread.sleep(800)
        println("Der Regen verusacht schwere Frostbrandwunden")
        Thread.sleep(800)
        for (i in boese.indices) {
            boese[i].hp - schaden
        }
        println("Es wurde $schaden Schaden verursacht")
        Thread.sleep(800)


    }

    fun tot() {
        besiegt = true
        //println("$name wurde besiegt!")
    }

    fun angriffe(
        endboss: Endboss,
        helden: MutableList<Held>,
        alleBoesen: MutableList<Endboss>,
        beutel: MutableList<Beutel>
    ) {

        if (maxHp < 0) {
            maxHp = 0
        }
        if (verflucht && hp > maxHp * 0.2) {
            var schaden = maxHp * 0.1
            hp - schaden
            println("Durch den Fluch von ${endboss.name} hat $name $schaden HP verloren ")
            Thread.sleep(800)
        }
        if (verflucht && hp < maxHp * 0.2) {
            verflucht = false
            endboss.flüche = 0
            println("Der Fluch ist abgelaufen und verursacht keinen Schaden mehr")
            Thread.sleep(800)
        }


        var helfer = alleBoesen[1]
        var drache = alleBoesen[0]
        println("$name ist jetzt dran")
        println("__ __ __ __ __ __ __ ")
        if (!besiegt) {
            if (endboss.helfer && helfer.hp <= 0) {
                endboss.helfer = false
                println("Der Helfer wurde besiegt")
            }
            if (endboss.helfer) {
                chooseAktion()
                println("__ __ __ __ __ __ __ ")
                var x = readln().toInt()
                when (x) {
                    1 -> heal(helden)
                    2 -> shild()
                    3 -> lavaBurst(helfer)
                    4 -> frostBlizzard(alleBoesen)
                    5 -> usePotion(beutel)

                }


            } else {
                chooseAktion()
                var x = readln().toInt()
                when (x) {
                    1 -> heal(helden)
                    2 -> shild()
                    3 -> lavaBurst(drache)
                    4 -> frostBlizzard(alleBoesen)
                    5 -> usePotion(beutel)

                }
            }
        }

        if (verflucht) {
            var schaden = maxHp * 0.1
            maxHp - schaden
            println("Es wurden $schaden Schaden durch einen Fluch verursacht")
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

    }

    private fun chooseAktion() {
        println("Wähle eine Aktion")
        Thread.sleep(500)
        println("1 für Heilen")
        Thread.sleep(500)
        println("2 für Eis-Schild")
        Thread.sleep(500)
        println("3 für Lava Schlag")
        Thread.sleep(500)
        println("4 für Eisregen")
        Thread.sleep(500)
        println("5 um den Beutel zu öffnen")
    }


}



