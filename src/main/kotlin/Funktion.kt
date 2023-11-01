import Böse.Endboss

fun select(team: MutableList<Held>): Held {

    for (name in team){

    println("Auf welchen Helden soll die Aktion ausgeführt werden ?")
    println("1 für ${name.name}")
    println("2 für ${name.name}") // Nochmal abchecken ! will den namen aus der liste bekommen
    println("3 für Schurke")
    }

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
    return team[input - 1]

}

fun stats(team: MutableList<Held>, boese: MutableList<Endboss>) {
    for (i in team.indices) {
        println(team[i])
    }
    for (i in boese.indices) {
        println(boese[i])
    }


}
//fun schildCheck(helden: MutableList<Held>,boese: MutableList<Endboss>){
//    val held=helden.random()
//    val boese123=boese.first
//    if (!held.shild) {
//
//
//    }else {
//        boese123.normalerSchaden = false
//
//    }
//}




