open class Held(
    var name: String,
    var maxHp: Int,

    var weapon: String,
    var atk: Int,
    var stealth: Boolean = true,
    var shild: Boolean,
    var ausweichen: Boolean,
    var verflucht: Boolean = false
) {
    var besiegt:Boolean = false
    var hp: Int = maxHp





    fun usePotion(beutel:MutableList<Beutel>) {
        println("Wähle einen Trank..")
            var counter = 1
        for (i in beutel){
            println("$counter für ${i.name}. Du hast noch ${i.anzahl} Tränke")
            counter++
        }

        var input = readln().toInt()-1

        when (input) {
            0 -> {

                if (beutel[input].anzahl <= 0) beutel.removeAt(input) else beutel[input].anzahl -=1


                maxHp += 50
                println(
                    "$name hat den Heiltrank gewählt." +
                            " Seine Lebenspunkte sind jetzt bei $maxHp HP."
                )
            }

            1 -> {
                if (beutel[input].anzahl <= 0) beutel.removeAt(input) else beutel[input].anzahl -=1

                atk += 50
                println(
                    "$name hat den Powertrank gewählt." +
                            " Seine Angriffspunkte sind jetzt bei $atk ATK."
                )
            }
        }

    }
}



