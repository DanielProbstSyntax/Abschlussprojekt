import Böse.Endboss

fun select(team: MutableList<Held>): Held {

    var count = 1

    for (i in team) {
        println("Tippe $count für ${i.name}")
        count++
    }
    var input = readln().toInt()

    when (input) {
        1 -> team[0]
        2 -> team[1]
        3 -> team[2]

    }

    while (input > team.size || input == 0) {
        println("Falsche Eingabe, versuche es nochmal")
        input = readln().toInt()
    }
    return team[input - 1]

}

fun statsHelden(team: MutableList<Held>) {
    for (i in team.indices) {
        println(team[i])
    }



}
fun statsBoese(boese: MutableList<Endboss>){
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




