fun select(team: MutableList<Held>):Held {
    println("Auf welchen Helden soll die Aktion ausgeführt werden ?")
    println("1 für Krieger")
    println("2 für Magier")
    println("3 für Schurke")

//    var count = 1
//
//    for (i in team) {
//        println("Tippe $count für ${i.name}")
//        count++
//    }
    var input = readln().toInt()

    when (input) {
        1 -> {
            team[0]
            println("Krieger wurde gewält")
        }

        2 -> team[1]
        3 -> team[2]

    }

    while (input > team.size || input == 0) {
        println("Falsche Eingabe, versuche es nochmal")
        input = readln().toInt()
    }
    return team[input-1]

}
fun stats(team: MutableList<Held>){
    for (i in team.indices)
    println(team[i])



}

