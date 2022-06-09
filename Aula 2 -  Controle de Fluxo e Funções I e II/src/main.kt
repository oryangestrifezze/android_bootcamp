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

}