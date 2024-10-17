class Knight(health:Int,
             power:Int,
             var defense:Int
):Human(health, power) {

    override fun attack(human1: Human, human2: Human): String {
        var uron:Int = 0
        if (human1 is Knight) {
            if (((1..100).random()) < 15) {
                uron = (15..20).random() + human1.power
                human2.health -= uron
            }else if(((1..100).random()) < 30){
                uron = (10..15).random() + human1.power
                human2.health -= uron
            }else if(((1..100).random()) < 70) {
                uron = (5..10).random() + human1.power
                human2.health -= uron
            }else{
                uron = human1.power
                human2.health -= uron
        }}
        return "${human1} Нанёс ${uron} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Knight) {
            if (((1..100).random()) < 10) {
                hp = (15..20).random()
                human.health += hp
            }else if(((1..100).random()) < 30){
                hp = (10..15).random()
                human.health += hp
            }else if(((1..100).random()) < 70) {
                hp = (1..10).random()
                human.health += hp
            }else{
                println("Не удалось восстановить хп")
            }}
        return "${human} восстановил ${hp} хп"
    }

    fun vosstanovlenieBrony(human:Human):String {
        var vb: Int = 0
        if (human is Knight) {
            if (((1..100).random()) < 10) {
                vb = (10..15).random()
                human.defense += vb
            }else if(((1..100).random()) < 30){
                vb = (5..10).random()
                human.defense += vb
            }else if(((1..100).random() < 70)) {
                vb = (1..5).random()
                human.defense += vb
            }else
                println("Не удалось восстановить броню")
        }
        return "${human} восстановил ${vb} брони"
    }

    override fun toString(): String {
        return "Knight(health=$health,power=$power,defense=$defense)"
    }
}