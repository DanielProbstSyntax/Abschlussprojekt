class Magier(name: String,hp: Int,weapon: String,atk: Int,stealth:Boolean,shild:Boolean=false):Held(name,hp,weapon,atk,stealth,shild) {
    override fun toString(): String {
        return name
    }

    fun heal(team: MutableList<Held>){
        var targetHeal = select(team)
        targetHeal.hp+=20
        println("${targetHeal.name} wurde um 20 geheilt")
        println("Er hat jetzt ${targetHeal.hp}")

//        when (input) {
//            1 -> held.filterIsInstance<Krieger>().first.hp+20
//            2 -> held.filterIsInstance<Schurke>()
//            3 -> held.filterIsInstance<Magier>()
//        }

    }

}



