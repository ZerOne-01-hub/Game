interface knightFunc {
    fun otrazhenieUrona(uron:Int, human:Human):Int {
        var zashita: Int = 0
        if (human is Knight) {
            if (human.defense > 0) {
                if ((1..100).random() < 10) {
                    zashita = human.defense
                    if (uron < zashita) {
                        zashita = uron
                        human.defense -= uron
                    } else
                        human.defense -= zashita
                } else if ((1..100).random() < 30) {
                    zashita = human.defense / 2
                    if (uron < zashita) {
                        zashita = uron
                        human.defense -= uron
                    } else
                        human.defense -= zashita
                }
            }else
                println("Восстановите броню")
        }
        return zashita
    }
}