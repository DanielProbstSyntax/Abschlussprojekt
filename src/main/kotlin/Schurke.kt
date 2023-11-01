class Schurke(name: String,hp: Int,weapon: String,atk: Int,stealth:Boolean,crit:Boolean,shild:Boolean=false):Held(name,hp,weapon,atk,stealth,shild) {
    override fun toString(): String {
        return "$name: hat $hp Lebenspunkte und $atk Angriffskraft"
    }


}