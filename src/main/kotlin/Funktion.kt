import Böse.Endboss

fun select(team: MutableList<Held>): Held {
    var count = 1
    for (i in team) {
        println("Tippe $count für ${i.name}")
        Thread.sleep(800)
        count++
    }
    var input = readln().toInt()
    when (input) {
        1 -> team[0]
        2 -> team[1]
        3 -> team[2]

    }
    while (input > team.size || input == 0) {
        println("Falsche Eingabe, versuche es nochmal")
        input = readln().toInt()
    }
    return team[input - 1]
}

fun statsHelden(team: MutableList<Held>) {
    for (i in team.indices) {
        println(team[i])
    }


}

fun statsBoese(boese: MutableList<Endboss>) {
    for (i in boese.indices) {
        println(boese[i])
    }
}

fun eingabeAktionKrieger(min: Int = 1, max: Int= 5): Int {
    var index: Int
    do {
        chooseAktionKrieger()

        index = try {
            readln().toInt()
        } catch (e: Exception) {
            println("AUFPASSEN! Du musst einen gültigen Integer eingeben")
            -1
        }

    } while (index !in min..max)

    return index
}
fun eingabeAktionMagier(min: Int = 1, max: Int= 5): Int {
    var index: Int
    do {
        chooseAktionMagier()

        index = try {
            readln().toInt()
        } catch (e: Exception) {
            println("AUFPASSEN! Du musst einen gültigen Integer eingeben")
            -1
        }

    } while (index !in min..max)

    return index
}
fun eingabeAktionSchurke(min: Int = 1, max: Int= 5): Int {
    var index: Int
    do {
        chooseAktionSchurke()

        index = try {
            readln().toInt()
        } catch (e: Exception) {
            println("AUFPASSEN! Du musst einen gültigen Integer eingeben")
            -1
        }

    } while (index !in min..max)

    return index
}
fun chooseAktionKrieger() {
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

fun chooseAktionMagier() {
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
fun chooseAktionSchurke() {
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

}
fun chooseDifficulti(min: Int = 1, max: Int = 2): Int {
    var index: Int
    val green = "\u001B[32m"
    val yellow = "\u001B[33m"
    val blue = "\u001B[34m"
    val magenta = "\u001B[35m"
    val cyan = "\u001B[36m"
    val bold = "\u001B[1m"
    val underline = "\u001B[4m"
    val backgroundYellow = "\u001B[43m"
    val red = "\u001B[31m"
    // alle zuvor verwendeten Formatierungen zurücksetzen, ohne bleiben sie auch in den nächsten printlns bestehen bestehen
    val reset = "\u001B[0m"
    do {
        println("Wähle folgendes:")
        Thread.sleep(800)
        println("""1 für${green} Leicht $reset
            Drache - HP: 1000 ATK: 0
            Helfer - HP: 500 ATK: 0
            Helden - HP + 30
            """.trimMargin())
        Thread.sleep(800)
        println("""2 für${red} Schwer $reset
            Drache - HP: 1000 ATK: 20
            Helfer - HP: 700 ATK: 10
        """.trimMargin())

        try {
            index = readln().toInt()
        } catch (e: NumberFormatException){
            println("AUFPASSEN! Du musst eine gültige Zahl eingeben")
            index = -1
        }

    } while (index !in min..max)

    return index
}






