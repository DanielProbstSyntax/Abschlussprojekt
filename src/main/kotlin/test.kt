import Böse.Drache
import Böse.Endboss

fun main() {

    val alleHelden: MutableList<Held> = mutableListOf(
        Krieger("Hugo", 200, "Axt", 0, crit = false, shild = false, stealth = false),
        Magier("Selina", 100, "Zauberstab", 0, false, false),
        Schurke("Schlitzohr", 100, "Dolch", 0, false, false)
    )
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        Drache("Infernothor", 1000, 0, "Dämonen Schwert", false)

    )


//    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = false, shild = false, stealth = false)
//    var magier = Magier("Selina", 100, "Zauberstab", 0, false, false)
//    var schurke = Schurke("Schlitzohr", 100, "Dolch", 0, false, false)
//    var drache = Drache("Infernothor", 1000, 100, "Dämonen Schwert", false)

//    var beutel = Beutel(3, 1)
//    alleHelden[1].beutel(beutel)

//    krieger.brutalSmash(drache)
//    krieger.shildblock()




    alleBoesen.filterIsInstance<Drache>().first.spikeShot(alleHelden)
    alleHelden.filterIsInstance<Magier>().first.heal(alleHelden)
    println(alleHelden)
    alleHelden[2].



//    when (readln().toInt()) {
//        1 -> println("Spiel starten")
//
//    }
}





