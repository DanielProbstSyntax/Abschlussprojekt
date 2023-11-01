import Böse.Drache
import Böse.Endboss
import Böse.Helfer

fun main() {

    val alleHelden: MutableList<Held> = mutableListOf(
        Krieger("Hugo", 200, "Axt", 0, crit = 50,false, false),
        Magier("Selina", 100, "Zauberstab", 0, false, false),
        Schurke("Schlitzohr", 150, "Dolch", 0, false, false)
    )
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        Drache("Infernothor", 1000, 10, "Dämonen Schwert", false),
        Helfer("Gunstav",500,0,"Schwert",false)

    )


//    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = false, shild = false, stealth = false)
//    var magier = Magier("Selina", 100, "Zauberstab", 0, false, false)
//    var schurke = Schurke("Schlitzohr", 100, "Dolch", 0, false, false)
//    var drache = Drache("Infernothor", 1000, 100, "Dämonen Schwert", false)


//    alleHelden[1].beutel(beutel)

//    krieger.brutalSmash(drache)
//    krieger.shildblock()



    stats(alleHelden,alleBoesen)
//    alleBoesen.filterIsInstance<Drache>().first.spikeShot(alleHelden)
  //  alleBoesen.filterIsInstance<Drache>().first.firebreath(alleHelden)
    alleHelden.filterIsInstance<Magier>().first.heal(alleHelden)
//    alleHelden.filterIsInstance<Krieger>().first.battleShout(alleHelden)
//    alleHelden.filterIsInstance<Krieger>().first.brutalSmash(alleBoesen)
//    alleHelden.filterIsInstance<Krieger>().first.battleShout(alleHelden)


    stats(alleHelden,alleBoesen)




//    when (readln().toInt()) {
//        1 -> println("Spiel starten")
//
//    }
}





