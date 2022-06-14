abstract class job(
    val wage: Int,
    val workload: Int,
    val entryTime: Int,
    val departureTime: Int
)

class developer : job(10000, 44, 9, 19)

fun main() {
    developer().let {
        println(it.departureTime)
        println(it.entryTime)
        println(it.wage)
        println(it.workload)
    }

    Bulldog().move()
}

/*
Classe abstrata: não pode ser instanciada e deve ser herdada
Classe open: pode ser instanciada e herdada em simultâneo

Para subscrecer um método ou atributo, devemos usar a palavra chave OVERRIDE
se for necessário chamar a implementação da classe herdada, devemos usar a palavra super
 */

abstract class Animal {
    abstract  fun move()
}

abstract  class Dog : Animal() {
    override fun move() {
        println("Cachorros andam =)")
    }
}

class  Bulldog : Dog() {
    override fun move() {
        super.move()
        println("utilizando o super para retornar a função acima")
    }
}

