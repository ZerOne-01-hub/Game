import java.lang.Math.round

class Robot(health:Int,
            power:Int,
            var battery:Int
):Human(health, power),knightFunc {

    override fun attack(human1: Human, human2: Human): String {
        var uron:Int = 0
        if (human1 is Robot) {
            if (human1.battery >= 70) {
                human1.battery -= 5
                uron = human1.power
            } else if ((30 < human1.battery) and (human1.battery < 70)) {
                human1.battery -= 5
                uron = (human1.power / 2)
            } else if ((5 < human1.battery) and (human1.battery <= 30)) {
                human1.battery -= 5
                uron = (human1.power / 3)
            }else{
                println("Роботу нужна подзарядка")
            }
        }
        if (human2 is Knight){
            uron = uron - otrazhenieUrona(uron,human2)
        }
        human2.health -= uron
        return "${human1} Нанёс ${uron} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Robot) {
            if (human.battery >= 70) {
                human.battery -= 5
                hp = (20..30).random()
                human.health += hp
            }else if ((30 < human.battery) and (human.battery < 70)) {
                human.battery -= 5
                hp = (10..20).random()
                human.health += hp
            }else if((5 <= human.battery) and (human.battery <= 30)){
                human.battery -= 5
                hp = (1..10).random()
                human.health += hp
            }}else
            println("Необходимо подзарядить робота")
        return "${human} восстановил ${hp} хп"
    }

    fun podzaryadka(human:Human):String {
        var vz: Int = 0
        if (human is Robot) {
            if (((1..100).random()) < 10) {
                vz = (20..30).random()
                human.battery += vz
            }else if(((1..100).random()) < 30){
                vz = (10..20).random()
                human.battery += vz
            }else if(((1..100).random()) < 70) {
                vz = (1..10).random()
                human.battery += vz
            }else
                println("Не удалось восстановить заряд")
        }
        return "${human} восстановил ${vz} заряда"
    }


    override fun toString(): String {
        return "Robot(health=$health,power=$power,battery=$battery)"
    }
}