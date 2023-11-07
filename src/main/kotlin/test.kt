import Böse.Drache
import Böse.Endboss
import Böse.Helfer

fun main() {
    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = 50, false, false, false)
    var magier = Magier("Selina", 150, "Zauberstab", 0, false, 0, false, false)
    var schurke = Schurke("Schlitzohr", 100, "Dolch", 0, false, 50, false, false)
    val alleHelden: MutableList<Held> = mutableListOf(
        krieger, magier, schurke

    )
    var helfer = Helfer("Gustav der böse", 50, 0, "Schwert", false)
    var drache = Drache("Dämon Inferno", 1000, 0, "Dämonen Schwert", false)
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        drache,helfer
    )
    var heiltrank = Heiltrank("Heiltrank",3)
    var staerkungstrank = Stärkungstrank("Stärkungstrank",1)
    var alleTraenke : MutableList<Beutel> = mutableListOf(heiltrank,staerkungstrank)



    var userName : String = ""




    println("Willkommen zu meinen RPG, bitte gib deinen Namen ein")
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
            println("Spiel wird gestartet. $userName,")
            Thread.sleep(800)
            println("        ___          ___  __   ___  __        __  \n" +
                    "\\  / | |__  |       |__  |__) |__  /  \\ |    / _` \n" +
                    " \\/  | |___ |___    |___ |  \\ |    \\__/ |___ \\__> \n")
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

            println("Runde: $runde")
        println("__ __ __ __ __ __ __ ")
        while (true) {

            krieger.angriffe(drache,alleHelden,alleTraenke,alleBoesen)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")
            magier.angriffe(drache, alleHelden, alleBoesen,alleTraenke)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")
            schurke.angriffe(drache,alleTraenke,alleBoesen)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")
            if (drache.helfer == true){
                helfer.angriff(alleHelden,alleBoesen,alleTraenke)
            }else drache.angriff(alleHelden)
            println("__ __ __ __ __ __ __ ")
            statsHelden(alleHelden)
            println("__ __ __ __ __ __ __ ")

            if (helfer.hp <= 0){
                drache.helfer = false
            }

            if (krieger.hp <= 0){
                krieger.tot()
                println("${krieger.name} ist im Kampf gefallen ")

            }
            if (magier.hp <= 0){
                magier.tot()
                println("${magier.name} ist im Kamp gefallen ")

            }
            if (schurke.hp <= 0){
                schurke.tot()
                println("${schurke.name} ist im Kamp gefallen ")

            }
            if (alleHelden.all { it.hp <= 0 }) {
                println("Der Drache hat gewonnen!")
                break
            }
            if (drache.hp <= 0) {
                drache.dracheBesiegt()
                println("Die Helden haben gewonnen!")
                break
            }

            runde++





        }


    }


}