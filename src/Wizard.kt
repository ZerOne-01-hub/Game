class Wizard(health:Int,
             power:Int,
             var mana:Int
) :Human(health, power),knightFunc {

    override fun attack(human1: Human, human2: Human): String {
        var uron:Int = 0
        if (human1 is Wizard) {
            if (human1.mana >= 5) {
                if (((1..100).random()) < 30) {
                    human1.mana -= 5
                    uron = human1.power + (10..20).random()
                } else{
                    uron = human1.power
            }}else{
                uron = human1.power
        }}
        if (human2 is Knight){
            uron = uron - otrazhenieUrona(uron,human2)
        }
        human2.health -= uron
        return "${human1} Нанёс ${uron} урон ${human2}"
    }

    override fun heal(human: Human): String {
        var hp:Int = 0
        if (human is Wizard) {
            if (human.mana >= 5) {
                if (((1..100).random()) < 70) {
                    human.mana -= 5
                    hp = (10..20).random()
                    human.health += hp
                } else{
                    hp = 0
                    human.health += hp
            }} else if (((1..100).random()) < 20) {
                hp = (1..10).random()
                human.health += hp
            } else{
                hp = 0
                human.health += hp
                println("Необходимо восстановить ману")
        }}
        return "${human} восстановил ${hp} хп"
    }

    fun vosstanovlenieMana(human:Human):String {
        var vm: Int = 0
        if (human is Wizard) {
            if (((1..100).random()) < 10) {
                vm = (20..30).random()
                human.mana += vm
            }else if(((1..100).random()) < 30){
                vm = (10..20).random()
                human.mana += vm
            }else if(((1..100).random()) < 70) {
                vm = (1..10).random()
                human.mana += vm
            }else
                println("Не удалось восстановить ману")
        }
        return "${human} восстановил ${vm} маны"
    }
    override fun toString(): String {
        return "Wizard(health=$health,power=$power,mana=$mana)"
    }

}