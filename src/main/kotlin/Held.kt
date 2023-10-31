open class Held(var name: String, var hp: Int, var weapon: String, var atk: Int, var stealth: Boolean) {

    open fun beutel(beutel: Beutel) {
        println("Dein Held greift in den beutel, was soll er benutzen ? :")
        println("1 für Heiltrank, du hast noch ${beutel.healthPotion} Tränke")
        println("2 für ATK-Power Buff, du hast noch ${beutel.buffAtk} Tränke")
        var input = readln().toInt()
        while (input > 2 || input == 0) {
            println("Falsche Eingabe, versuche es nochmal")
            input = readln().toInt()
        }
        when (input) {
            1 -> beutel.healthPotion -= 1
            2 -> beutel.buffAtk -= 1
        }
        if (input == 1) {
            hp += 20
            println("$name hat einen Heiltrank benutzt und hat jetzt $hp Lebenspunkte")

        } else if (input == 2) {
            atk += 50
            println("$name hat einen Angriffskraft-Trank benutzt und hat jetzt $atk Angriffskraft")
        }


    }
}

