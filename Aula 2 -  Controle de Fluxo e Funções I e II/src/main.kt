fun main() {
    println("Exercicios Controle de fluxos")

    println("CONDICIONAIS")
    println("===========================================")

    val a = 10
    val b = 20
    val maxValue = if(a>b) a else b
    println(maxValue)

    /*
    Operações Uteis:
    >
    <
    >=
    <=
    == valor
    === referencia na memória
    !=
    ||
    &&
    */

    println("Exercicio: crie um codigo que avalie se um caracter é vogal ou não")

    fun isVogal(letter: String) {
        when(letter) {
            "A" -> println("A letra A é uma vogal")
            "E" -> println("A letra E é uma vogal")
            "I" -> println("A letra I é uma vogal")
            "O" -> println("A letra O é uma vogal")
            "U" -> println("A letra  U é uma vogal")
            else -> println("A letra $letter não é uma vogal!")
        }
    }
    println("Teste de vogal A: ")
    isVogal("A")
    isVogal("L")

    println("EXCEÇÕES")
    println("===========================================")

    try {
        val result = 2/0
        println("result")
    } catch (e: java.lang.Exception) {
        println(e)
    }

    println("CONDICIONAIS")
    println("===========================================")

    val today = "Monday"
    val a = 20
    val b = 10
    when {
        today == "Monday" -> println("Monday")
        a < b -> println("a < b")
        else -> println("Unknown")
    }

    println("Exercicio")
    val temp = 9
    when {
        temp < 0 -> println("Freezing weather")
        temp < 10 -> println("Very Cold weather")
        temp >= 10 || temp < 20 -> println("Cold weather")
        temp >= 20 || temp < 30 -> println("Normal in Temp")
        temp >= 30 || temp < 40 -> println("It's Hot")
        temp >=40 -> println("It's Very Hot")
    }

    /*
    NULL SAFETY
    Para indicar que uma variável pode ser do tipo null acrescentamos ?
     */
    var price: Float? = null
    var amount: Int = 0

    println("ELVIS OPERATOR")
    println("===========================================")

    /*
    ELVIS OPERATOR permite avaliar se uma variável é null com o operador ?: e atribuir a ela um valor se for o caso.
     */
    var height
    height = height ?: 1.60F

    println("CICLOS")
    println("===========================================")

    val ingredients = listOf<String>("tomato", "potato")
    ingredients.forEach {
        println("$it")
    }

    /*
    FOREACHINDEXED:
    Caso queira utilizar o indice no ForEach.
     */

    ingredients.forEach { i, it ->
        println("indice: $i, ingrediente: $")
    }

    println("COLLECTION FUNCTIONS")
    println("===========================================")
    /*
    FILTER: permite percorrer uma coleção e filtrar os elementos que atendem a condição desejada
    MAP: permite aplicar uma modificação a cada elemento da coleção
    ANY: retornará verdadeiro se pelo menos um elemento da coleção cumpre a condição especificada
     */

    val intList = listOf(1, 23,5,10)
    val filterList = intList.filter { it > 5}
    println("Os elementos filtrados são: $filterList")

    println("Exercicio")
    val newList = listOf(13, 61, 35, 96, 3, 93, 6, 43, 68, 75, 88, 19, 17, 81, 52, 5, 51, 74, 54, 10, 45, 91, 39, 47, 83, 59, 65, 30, 46, 24, 29, 32, 12, 38, 7, 84, 31, 87, 69, 85, 97,28, 70, 1, 36, 34, 8, 77, 48, 42, 82, 18, 53, 9, 98, 78, 67, 56, 16, 26, 73, 20, 86, 62, 95, 76, 25, 71, 11, 58, 57, 55, 33, 94, 22, 21, 41, 15, 40, 27, 89, 4, 90, 72, 92, 63, 44, 60, 79, 99, 64, 66, 37, 50, 2, 80, 49, 23, 14)
    val resultNewList = newList.filter { it > 60}
        .find { it % 7 == 0}
    println("Nova Lista: $resultNewList")

    println("Exercicios de Funções")
    println("==========================================="

   /*
   DEFINIÇÃO básica de uma função
   */

    println("DEFAULT")
    println("===========================================")
        fun getInitial(name: String = "Jhon") : Char {
            return name[0]
        }
        val maryInitial = getInitial("Mary")
        println("$maryInitial")

    /*
    Em Kotlin, o compilador infere o retorno, portanto pode-se escrever a função diretamente:
     */
    fun getInitial(name: String = "Jhon") = name[0]

    println("Exercicio")

    fun findFibo(n: Int = 5): List<Int> {
        val fibo = listOf(0, 1, 1, 2, 3, 5, 8, 13, 21)
        return fibo.take(n)
    }
    println("${findFibo()}")

    println("UNIT ANY NOTHING")
    println("===========================================")

    /*
    UNIT: substitui o void - caso uma função não retorne nenhum valor, Unit pode ser usado como o tipo de retorno.
    ANY: todas as classes kotlin herdam de any, ou seja, se uma função nao receber uma variável do tipo Ay como parämetro, ela pode aceitar qualquer tipo de dado.
    NOTHING: usado para representar um valor que nunca existirá. Uma função que retorna nothing significa que ela nunca retornará, ou seja, ela lançará uma exceção ou entrará em um loop.
     */
}

    fun throwException(): Nothing {
        throw Exception("Exception message)
    }

    println("HIGH ORDER FUNCTIONS")
    println("===========================================")
        /*
        Funções que tem uma função como parâmetro ou que retornam uma função
         */
    fun calculate(x: Int, y: Int, operation:(Int, Int) -> Int) {
        return operation(x,y)
    }

    fun sum(x: Int, y: Int) = x+y
    val sumResult = calculate(4,5, ::sum)
    val mulResult = calculate(4,5) {a,b -> a*b}

    println("LAMBDA FUNCTIONS")
    println("===========================================")
        /*
        São uma maneira simples de escrever funções e hof, deixando ao compilador inferir os tipos de dados a partir dos parâmetros de entrada ou saída.
         */
        val sum = {a:Int, b: Int -> a+b}

    println("EXTENSION FUNCTIONS")
    println("===========================================")
        /*
        Extende o comportamento de tipos de dados existentes - para todos os tipos.
         */
    fun String.isPalidrome() : Boolean {
        val testString = this.toLowerCase()
            .replace(""[\W+]"".toRegex(), "")
            return testString == testString.reversed()
    }

    println("Exercicio")
    fun Int.isPair() : String = if(this % 2 == 0) "é par" else "é ímpar"
    println("O número é par? ${6.isPair()}")

