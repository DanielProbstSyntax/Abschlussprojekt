//open class Beutel(var heiltrank:Heiltrank = Heiltrank(),var stärkungstrank: Stärkungstrank = Stärkungstrank()) {
//    fun inhalt(){
//
//        println("Es sind ${heiltrank.anzahl} Heiltränke und ${stärkungstrank.anzahl} Stärkungstränke im Beutel")
//    }
//
//}

class Beutel(var inhalt: MutableList<Potions> = mutableListOf(Heiltrank(),Stärkungstrank())){
    fun statusBeutel(){
        for (i in inhalt)
            println(i)
    }
}
