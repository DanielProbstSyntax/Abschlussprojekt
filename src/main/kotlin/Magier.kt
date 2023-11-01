class Magier(name: String,hp: Int,weapon: String,atk: Int,stealth:Boolean,shild:Boolean=false):Held(name,hp,weapon,atk,stealth,shild) {
    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }

    fun heal(team: MutableList<Held>){
        println("$name kanalisiert ihre Macht und will jemanden Heilen")
        var targetHeal = select(team) // <----- NOCHMAL ABCHECKEN, WICHTIG FÜR SPÄTER
        targetHeal.hp+=20
        println("${targetHeal.name} wurde um 20 geheilt")
        println("Er hat jetzt ${targetHeal.hp} Lebenspunkte")

//        when (input) {
//            1 -> held.filterIsInstance<Krieger>().first.hp+20
//            2 -> held.filterIsInstance<Schurke>()
//            3 -> held.filterIsInstance<Magier>()
//        }

    }

}



