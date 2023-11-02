import Böse.Drache
import Böse.Endboss
import Böse.Helfer

fun main() {

    val alleHelden: MutableList<Held> = mutableListOf(
        Krieger("Hugo", 200, "Axt", 0, crit = 50, false, false, false),
        Magier("Selina", 100, "Zauberstab", 0, false, 0, false, false),
        Schurke("Schlitzohr", 150, "Dolch", 0, false, 50, false)
    )
    val alleBoesen: MutableList<Endboss> = mutableListOf(
        Drache("Dämon Infernothor", 1000, 10, "Dämonen Schwert", false),
        Helfer("Gustav der böse", 500, 0, "Schwert", false)

    )


//    var krieger = Krieger("Hugo", 200, "Axt", 0, crit = false, shild = false, stealth = false)
//    var magier = Magier("Selina", 100, "Zauberstab", 0, false, false)
//    var schurke = Schurke("Schlitzohr", 100, "Dolch", 0, false, false)
//    var drache = Drache("Infernothor", 1000, 100, "Dämonen Schwert", false)







//    krieger.brutalSmash(drache)
//    krieger.shildblock()

//    var beutel = Beutel()
//    println(beutel)
    val beutel = Beutel()
    //stats(alleHelden,alleBoesen)
    alleBoesen.filterIsInstance<Helfer>().first.stehlen(beutel)
    beutel.statusBeutel()

   // println(beutel)
    //alleBoesen.filterIsInstance<Helfer>().last.punsh(alleHelden)
   alleHelden.filterIsInstance<Krieger>().first.usePotion(alleHelden,beutel)


//    alleHelden.filterIsInstance<Krieger>().first.battleShout(alleHelden)
//    alleHelden.filterIsInstance<Krieger>().first.brutalSmash(alleBoesen)
       //alleHelden.filterIsInstance<Krieger>().first.usePotion(beutel)


    //stats(alleHelden,alleBoesen)


}





