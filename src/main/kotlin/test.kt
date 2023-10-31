import Böse.Drache
import Böse.Endboss

fun main() {
    var beutel = Beutel(3,1)
    var krieger = Krieger("Hugo",200,"Axt",0,crit = false,shild = false,stealth = false)
    var drache = Drache("Infernothor",1000,100,"Dämonen Schwert")
    //krieger.beutel(beutel)

    //krieger.brutalSmash(drache)
    drache.spikeShot(krieger)






//    when(readln().toInt()){
//        1 -> println("Spiel starten")
//
//
//
//
//    }


}


