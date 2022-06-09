const val ID = 1
fun main(){
    println("Exercicios variaveis e tipos de dados")

    println("VARIÁVEIS")
    println("===========================================")

    println("Em kotlin, as variáveis tem o tipo inferido")
    val i = 1

    println("o tipo da variavel $i é inteiro, inferido pelo kotlin")

    println("Se necessário especificar o tipo  de dados, pode ser feito da seguinte forma:")
    println("val i: Int = 1")

    val inteiro: Int = 10
    println("O exemplo dessa variavel inferida é $inteiro")

    println("Para diferenciar Ints, Longs e Floats, que são essencialmente\n" +
            "números, você deverá adicionar a inicial de Long ou Float à direita do\n" +
            "valor declarado.")
    val longValue = 10L
    val floatValue = 10F
    println("os numeros são $longValue e $floatValue")

    /*
    Importante:
    VAR: declara uma variável que pode mudar, ou seja, pode ser modificada em qualquer momento.
    VAL: declara a imutabilidade de uma variável, é dizer, que não poderá ser modificada.
    CONST VAL: declara a imutabilidade de uma varável, mas ao contrário de val, será resolvida na hora da compilação.
    Portanto, não poderá ser declarada dentro de uma função.
    */
    println("o valor da const val é de $ID")

    println("OPERAÇÕES")
    println("===========================================")

    println("Atividade de Revisão")
    val a: Int = 1
    val b: Int = 2
    val c: Float = 3f
    val d: Float = 4f
    val resultB = b.plus(c*d)
    val resultA = a % resultB

    println("o resultado da soma de b com a multiplicação de c e d é: $resultB")
    println("o resultado do resto entre a e o resultadoB é de: $resultA")


    println("STRING")
    println("===========================================")

    val numberOfPets = 5
    val phrase = "i have $numberOfPets pets"
    println(phrase)
    println("Essa string contem a? ${phrase.contains("a")}")
    println("Essa é a substring (startIndex inclusive, endIndex exclusive)da frase acima: ${phrase.substring(1,3)}")
    println("Para testar se a string é vazia utiliza-se o isEmpty: ${phrase.isEmpty()}")

    println("Atividade de Revisão")
    val cadeia = "TS9FlJwaPV"
    println("A frase contem a? ${cadeia.contains("a")}")

    println("PAIR AND TRIPLES")
    println("===========================================")

    /*
    PAIR: para armazenar pares
    TRIPLES: para armazenar trios
    Util, pois evita a geração de classes desnecessárias
    É como se fosse uma classe genérica
    */

    val userPair : Pair<Int, String> = Pair(1, "Wiki")
    val userPair2 : Pair<Int, String> = Pair(2, "Maya")
    val (userId, userName) = userPair
    val (userId2, userName2) = userPair2

    println("O par é: $userPair")
    println("Obtendo conteudo do Pair com first: ${userPair.first}")
    println("Obtendo conteudo do Pair com second: ${userPair.second}")
    println("Obtendo o conteudo do Pair direto $userId e $userName")
    println("Obtendo o conteudo do Pair direto $userId2 e $userName2")

    /*
    O caso do Triple é análogo, com exceção de que o Triple terá o método third
    */

    println("COLEÇÕES")
    println("===========================================")

    /*
    Conjunto de itens do mesmo tipo que podem ser armazenados em uma unica variável.
    Mutable: podem ser modificadas == ARRAY
    Read only: apenas leitura == LIST por padrão, para atualizar utilize MutableList
    Para ADD elementos a uma lista, NÃO pode usar array, deve-se utilizar MutableList.
    Array tem tamanho fixo.
     */

    val charList = listOf('A', 'B', 'C')
    val charArray = arrayOf('A', 'B', 'C')
    val charArrayInt = intArrayOf(11, 12, 23)
    val charMutableList = mutableListOf<Int>(1,2,3)
    println("Coleção de lista criada: $charList")
    println("Coleção de array criada: $charArray")

    /*
    Para acessar qualquer um dos elementos dessas coleções utiliza-se
    GET ou POSIÇÃO
     */

    println("Acessando charList com get, posição 1: ${charList.get(1)}")
    println("Acessando charList com [ ], posição 1: ${charList[1]}")
    println("Acessando charArray com get, posição 2: ${charArray.get(2)}")
    println("Acessando charArray com [ ], posição 2: ${charArray[2]}")

    println("Para conhecer a posição de um elemento usa-se indexOf: ${charArray.indexOf('A')}")
    println("Se um elemento não existir o indexOf retorna: ${charArray.indexOf('D')}")

    println("Método Size em coleções: ${charList.size}")
    println("Uma lista mutavel somente é criada utilizando o método MutableList: $charMutableList")
    println("Adicionando um item a lista charMutableList: ${charMutableList.add((22))}, após add: $charMutableList")
    println("Geralmente Array tem classes especializadas para tipos de dados: $charArrayInt")
}
