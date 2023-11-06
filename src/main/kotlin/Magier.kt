import Böse.Endboss

class Magier(
    name: String,
    hp: Int,
    weapon: String,
    atk: Int,
    shild: Boolean = false,
    var crit: Int,
    stealth: Boolean,
    ausweichen: Boolean
) :
    Held(name, hp, weapon, atk, shild, stealth, ausweichen) {
    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und kämpft mit einem $weapon"
    }

    fun heal(team: MutableList<Held>) {
        println("$name kanalisiert ihre Macht und will jemanden Heilen")
        var targetHeal = select(team) // <----- NOCHMAL ABCHECKEN, WICHTIG FÜR SPÄTER
        targetHeal.hp += 20
        println("${targetHeal.name} wurde um 20 geheilt")
        println("Er hat jetzt ${targetHeal.hp} Lebenspunkte")


    }

    fun shild() {
        println("$name erschafft eine Eisschild im sich um etwas schaden zu blocken")
        shild = true
        Thread.sleep(1000)
    }

    fun lavaBurst(endboss: Endboss) {
        //val drache = boese.first
        var schaden = (30..60).random() + atk
        println("$name faltet seine Hände zusammen und kanalisiert einen Lavaschlag")
        Thread.sleep(500)
        println("Es knistert und ....")
        Thread.sleep(1000)
        println("... ein riesiger Lavaball rast auf den $ zu.")
        Thread.sleep(1000)
        endboss.hp -= schaden
        println("${endboss.name} wurden $schaden HP abgezogen")
        Thread.sleep(1000)
        println("Er hat jetzt noch ${endboss.hp}")
        Thread.sleep(1000)

    }

    fun frostBlizzard(boese: MutableList<Endboss>) {
        var drache = boese
        var schaden = (30..60).random() + atk
        println("$name erschafft über den Gegnern ein Eisregen")
        Thread.sleep(500)
        println("Der Regen verusacht schwere Frostbrandwunden")
        Thread.sleep(1000)
        for (i in boese.indices) {
            boese[i].hp - schaden
        }
        println("Es wurde $schaden Schaden verursacht")
        Thread.sleep(1000)


    }

    fun tot() {
        besiegt = true
        //println("$name wurde besiegt!")
    }

    fun angriffe(endboss: Endboss, helden: MutableList<Held>, alleBoesen: MutableList<Endboss>,beutel:MutableList<Beutel>) {

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
            var x = readln().toInt()
            when (x) {
                1 -> heal(helden)
                2 -> shild()
                3 -> lavaBurst(endboss)
                4 -> frostBlizzard(alleBoesen)
                5 -> usePotion(beutel)

            }



        } else {
            println("$name kann nicht angreifen, da Sie bereits besiegt wurde.")
        }

    }


}



