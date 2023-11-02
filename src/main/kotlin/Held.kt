open class Held(
    var name: String,
    var hp: Int,
    var weapon: String,
    var atk: Int,
    var stealth: Boolean = true,
    var shild: Boolean,
    var ausweichen: Boolean
) {


    fun usePotion(team: MutableList<Held>, beutel: Beutel) {
        var anzahlTränke = beutel.inhalt.filterIsInstance<Heiltrank>().first.anzahl
        var anzahlStärkung = beutel.inhalt.filterIsInstance<Stärkungstrank>().first.anzahl
        println("Dein Held greift in den beutel, was soll er benutzen ? :")
        println("1 für Heiltrank, du hast noch $anzahlTränke Tränke")
        println("2 für ATK-Power Buff, du hast noch $anzahlStärkung Tränke")

        var input = readln().toInt()
        while (input > 2 || input == 0) {
            println("Falsche Eingabe, versuche es nochmal")
            input = readln().toInt()
        }
        when (input) {
            1 -> anzahlTränke -= 1
            2 -> anzahlStärkung -= 1
        }

        var targetHeal = select(team)
        if (input == 1) {
            targetHeal.hp += 40
            println("{${targetHeal.name}} hat einen Heiltrank benutzt und hat jetzt ${targetHeal.hp} Lebenspunkte")

        } else if (input == 2) {
            targetHeal.atk += 50
            println("${targetHeal.name} hat einen Angriffskraft-Trank benutzt und hat jetzt ${targetHeal.atk} Angriffskraft")
        }
    }
}

