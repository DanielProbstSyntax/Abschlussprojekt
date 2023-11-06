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
    var helfer = Helfer("Gustav der böse", 500, 0, "Schwert", false)
    var drache = Drache("Dämon Infernothor", 1000, 0, "Dämonen Schwert", false)
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
    println("Ok $userName, viel Spass beim spielen ")
    Thread.sleep(800)
    println("Willst du ein neues Spiel starten ? ")
    Thread.sleep(800)
    println("1 für JA")
    Thread.sleep(800)
    println("2 für Nein")
    Thread.sleep(800)
    println("3 für Infos über das Spiel")


    var input = readln().toInt()


    when (input) {
        1 -> {
            println("Spiel wird gestartet. $userName, viel Erfolg im Kamp gegen ${drache.name}.")
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
            println("Das Spiel hat begonnen. Runde: $runde")
        while (true) {

            krieger.angriffe(drache,alleHelden,alleTraenke)
            statsHelden(alleHelden)
            magier.angriffe(drache, alleHelden, alleBoesen,alleTraenke)
            statsHelden(alleHelden)
            schurke.angriffe(drache,alleTraenke,alleBoesen)
            statsHelden(alleHelden)
            if (drache.helfer == true){
                helfer.angriff(alleHelden,alleBoesen,alleTraenke)
            }else drache.angriff(alleHelden)
            statsHelden(alleHelden)

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