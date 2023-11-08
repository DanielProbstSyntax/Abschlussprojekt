import Böse.Drache
import Böse.Endboss
import Böse.Helfer

fun main() {
    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = 50, false,false)
    var magier = Magier("Selina", 100, "Zauberstab", 0, false, 0, false)
    var schurke = Schurke("Schlitzohr", 150, "Dolch", 0,50,false,false)
    val alleHelden: MutableList<Held> = mutableListOf(
        krieger, magier, schurke

    )
    var helfer = Helfer("Gustav der böse", 500, 0, "Schwert", false)
    var drache = Drache("Dämon Inferno", 1000, 0, "Dämonen Schwert", false)
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        drache, helfer
    )
    var heiltrank = Heiltrank("Heiltrank", 3)
    var staerkungstrank = Stärkungstrank("Stärkungstrank", 1)
    var alleTraenke: MutableList<Beutel> = mutableListOf(heiltrank, staerkungstrank)


    var userName: String = ""




    println("                                               _   __,----'~~~~~~~~~`-----.__\n" +
            "                                        .  .    `//====-              ____,-'~`\n" +
            "                        -.            \\_|/ .   /||\\\\  `~~~~`---.___./\n" +
            "                  ______-==.       _-~o  `\\/    |||  \\\\           _,'`\n" +
            "            __,--'   ,=='||\\=_    ;_,_,/ _-'|-   |`\\   \\\\        ,'\n" +
            "         _-'      ,='    | \\\\`.    '',/~7  /-   /  ||   `\\.     /\n" +
            "       .'       ,'       |  \\\\  \\_  \"  /  /-   /   ||      \\   /\n" +
            "      / _____  /         |     \\\\.`-_/  /|- _/   ,||       \\ /\n" +
            "     ,-'     `-|--'~~`--_ \\     `==-/  `| \\'--===-'       _/`\n" +
            "               '         `-|      /|    )-'\\~'      _,--\"'\n" +
            "                           '-~^\\_/ |    |   `\\_   ,^             \\\n" +
            "                                /  \\     \\__   \\/~               `\\__\n" +
            "                            _,-' _/'\\ ,-'~____-'`-/                 ``===\\\n" +
            "                           ((->/'    \\|||' `.     `\\.  ,                _||\n" +
            "             ./                       \\_     `\\      `~---|__i__i__\\--~'_/\n" +
            "            <_n_                     __-^-_    `)  \\-.______________,-~'\n" +
            "             `B'\\)                  ///,-'~`__--^-  |-------~~~~^'\n" +
            "             /^>                           ///,--~`-\\\n" +
            "            `  `                                       ")
    println()
    println()
    println("      ___  __   __   ___  __                __      __   __        __   __       \n" +
            "|__| |__  |__) /  \\ |__  /__`     /\\  |\\ | |  \\    |  \\ |__)  /\\  / _` /  \\ |\\ | \n" +
            "|  | |___ |  \\ \\__/ |___ .__/    /~~\\ | \\| |__/    |__/ |  \\ /~~\\ \\__> \\__/ | \\| \n" +
            "                                                                                 ")
    println("Willkommen zu Heroes and Dragon, bitte gib deinen Namen ein")

    Thread.sleep(800)
    userName = readln()
    Thread.sleep(800)
    println("Hallo $userName, wähle eine der folgenden Aktionen")
    Thread.sleep(800)
    println("1 für Spiel starten")
    Thread.sleep(800)
    println("2 für Abbruch")
    Thread.sleep(800)
    println("3 für Infos über das Spiel")
    Thread.sleep(800)


    var input = readln().toInt()



    when (input) {
        1 -> {
            println("Noob oder Pro, du entscheidest :)")
            when (chooseDifficulti()) {
                1 -> {
                    drache.atk = 0
                    krieger.maxHp + 30
                    magier.maxHp +  30
                    schurke.maxHp + 30
                }
                2 -> {
                    drache.atk = 20
                    helfer.hp += 200
                    helfer.atk = 20
                }


            }
            println("Spiel wird gestartet. $userName,")
            Thread.sleep(800)
            println(
                "        ___          ___  __   ___  __        __  \n" +
                        "\\  / | |__  |       |__  |__) |__  /  \\ |    / _` \n" +
                        " \\/  | |___ |___    |___ |  \\ |    \\__/ |___ \\__> \n"
            )
            println("im Kamp gegen ${drache.name}.")
            println("__ __ __ __ __ __ __ ")
            Thread.sleep(800)
        }

        2 -> {
            println("Abbruch")
        }

        3 -> {
            println("Hier ist eine Liste aller Helden und Bösewichte:")
            Thread.sleep(800)
            println("-----")
            statsHelden(alleHelden)
            println("-----")
            statsBoese(alleBoesen)
            println("-----")
            println("Drücke 1 um das Spiel zu starten")
            var input2 = readln().toInt()
            if (input2 == 1) {
                input = 1


            }

        }
    }

    if (input == 1) {

        var runde = 1


        while (true) {
            println("Runde: $runde")
            println("__ __ __ __ __ __ __ ")

            krieger.angriffe(drache, alleHelden, alleTraenke, alleBoesen)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            if (drache.hp <= 0 && !drache.helfer) {
                drache.dracheBesiegt()
                println("${krieger.name} hat ${drache.name} getötet")
                break
            }
            println("__ __ __ __ __ __ __ ")
            magier.angriffe(drache, alleHelden, alleBoesen, alleTraenke)
            if (drache.hp <= 0 && !drache.helfer) {
                drache.dracheBesiegt()
                println("${magier.name} hat ${drache.name} getötet")
                break
            }
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")
            schurke.angriffe(drache, alleTraenke, alleBoesen)
            if (drache.hp <= 0 && !drache.helfer) {
                drache.dracheBesiegt()
                println("${schurke.name} hat ${drache.name} getötet")
                println(" __                     __  ___     __   ___       __             ___      \n" +
                        "|  \\ |  |    |__|  /\\  /__`  |     / _` |__  |  | /  \\ |\\ | |\\ | |__  |\\ | \n" +
                        "|__/ \\__/    |  | /~~\\ .__/  |     \\__> |___ |/\\| \\__/ | \\| | \\| |___ | \\| \n" +
                        "                                                                           ")
                break
            }
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")
            if (drache.helfer == true) {
                helfer.angriff(alleHelden, alleBoesen, alleTraenke)
            } else drache.angriff(alleHelden)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")

            if (helfer.hp <= 0) {
                drache.helfer = false
            }

            if (krieger.hp <= 0) {
                krieger.tot()
                println("${krieger.name} ist im Kampf gefallen ")
                println("__ __ __ __ __ __ __ ")

            }
            if (magier.hp <= 0) {
                magier.tot()
                println("${magier.name} ist im Kamp gefallen ")
                println("__ __ __ __ __ __ __ ")

            }
            if (schurke.hp <= 0) {
                schurke.tot()
                println("${schurke.name} ist im Kamp gefallen ")
                println("__ __ __ __ __ __ __ ")

            }
            if (alleHelden.all { it.hp <= 0 }) {
                println("Der Drache hat gewonnen!")
                break
            }


            runde++


        }


    }


}