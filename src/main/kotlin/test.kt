import Böse.Drache
import Böse.Endboss
import Böse.Helfer

fun main() {
    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = 50, false, false, false)
    var magier = Magier("Selina", 100, "Zauberstab", 0, false, 0, false, false)
    var schurke = Schurke("Schlitzohr", 150, "Dolch", 0, false, 50, false, false)
    val alleHelden: MutableList<Held> = mutableListOf(
        krieger,magier,schurke
        //Krieger("Hugo", 200, "Axt", 0, crit = 50, false, false, false),
        //Magier("Selina", 100, "Zauberstab", 0, false, 0, false, false),
        //Schurke("Schlitzohr", 150, "Dolch", 0, false, 50, false, false)
    )
    var drache = Drache("Dämon Infernothor", 1000, 0, "Dämonen Schwert", false)
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        drache,
        //Drache("Dämon Infernothor", 1000, 0, "Dämonen Schwert", false),
        Helfer("Gustav der böse", 500, 0, "Schwert", false)

    )

    var beutel = Beutel()


    println("Willst du ein neues Spiel starten ? ")
    println("1 für JA")
    println("2 für Nein")
    println("3 für Infos über das Spiel")


    var input = readln().toInt()


    when (input) {
        1 -> {
            println("Spiel wird gestartet, wer soll den ersten Angriff ausführen ?")
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
            if (input2 == 1){
                input = 1
            }

        }
    }

    if (input == 1){
        var runde = 1


        while (true){
            println("Das Spiel hat begonnen. Runde: $runde")
            krieger.angriffe(drache)


        }

    }



}





















//    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = false, shild = false, stealth = false)
//    var magier = Magier("Selina", 100, "Zauberstab", 0, false, false)
//    var schurke = Schurke("Schlitzohr", 100, "Dolch", 0, false, false)
//    var drache = Drache("Infernothor", 1000, 100, "Dämonen Schwert", false)







//    krieger.brutalSmash(drache)
//    krieger.shildblock()

//    var beutel = Beutel()
//    println(beutel)
    //val beutel = Beutel()
    //stats(alleHelden,alleBoesen)
    //alleHelden.filterIsInstance<Schurke>().first.dodge()
    //alleBoesen.filterIsInstance<Drache>().first.spikeShot(alleHelden)
    //beutel.statusBeutel()

   // println(beutel)
    //alleBoesen.filterIsInstance<Helfer>().last.punsh(alleHelden)


//   println( alleHelden.filterIsInstance<Krieger>().first.maxHp)
//    alleHelden.filterIsInstance<Krieger>().first.hp-=23
//    println( alleHelden.filterIsInstance<Krieger>().first.hp)
//
//   println( alleHelden.filterIsInstance<Krieger>().first.maxHp)
//    alleHelden.filterIsInstance<Krieger>().first.brutalSmash(alleBoesen)
       //alleHelden.filterIsInstance<Krieger>().first.usePotion(beutel)


    //stats(alleHelden,alleBoesen)








