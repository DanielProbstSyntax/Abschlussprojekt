fun select(team: MutableList<Held>):Held {
    println("Auf welchen Helden soll die Aktion ausgeführt werden ?")

    var count = 1
    for (i in team) {
        println("Tippe $count für ${i.name}")
        count++
    }
    var input = readln().toInt()
    while (input > team.size || input == 0) {
        println("Falsche Eingabe, versuche es nochmal")
        input = readln().toInt()
    }
    return team[input-1]

}

