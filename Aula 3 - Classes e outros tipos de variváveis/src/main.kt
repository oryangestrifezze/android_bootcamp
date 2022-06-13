enum class Button(val cor: String, val id: String) {
    PRIMARY(cor = "Red", id= "vermelho"),
    SECUNDARY(cor="Blue", id= "azul")
}

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

enum class Cities(val latitude: Int, val longitude: Int) {
    BUENOSAIRES(latitude = 111, longitude = 111),
    LIMA(latitude = 222, longitude = 222),
    MONTEVIDEU(latitude = 333, longitude = 333),
    SANTIAGOCHILE(latitude = 444, longitude = 444),
}

object Utils {
    fun isFormatValid(email: String) :Boolean {
        return email.contains("@") && email.contains(".com")
    }
}

/*
As classes abstratas são as que não permitem realizar qualquer tipo de instância.
São classes feitas especialmente para serem modelos para suas classes derivadas.
As classes derivadas, via de regra, deverão sobrescrever os métodos para realizar
a implementação dos mesmos.
 */
sealed class MathOperation {
    abstract  fun operate(num1: Float, num2: Float): Float
}

class SumOperation : MathOperation() {
    override fun operate(num1: Float, num2: Float) = num1 + num2
}

sealed class Error {
    abstract fun getMessage(text:String): String
}

class MessageErrorOne :Error() {
    override fun getMessage(text: String) = "A primeira mensagem de erro é: $text"
}

class MessageErrorTwo :Error() {
    override fun getMessage(text: String) = "A segunda mensagem de erro é: $text"
}


class BigBen {
    companion object {
        fun getBongs(nTimes: Int) {
            for(i in 2 ..nTimes)
            println("BONG")
        }
    }
}

/*
O operador de dois pontos duplos (: :) , também conhecido como operador de referência de
 método em Java, é usado para chamar um método referindo-se a ele diretamente com a ajuda
 de sua classe. Eles se comportam exatamente como as expressões lambda. A única diferença
 que tem das expressões lambda é que ela usa referência direta ao método por nome em vez de fornecer um delegado ao método.
 */
class UserLateinit {
    private lateinit var name: String
    fun setName(name: String) {
        if(!this::name.isInitialized) this.name = name
    }
    fun getName() = if(this::name.isInitialized) this.name else ""
}


data class Person(
    val name: String,
    val age: Int,
    val profession: String? = null,
    val nickname: String? = null
)

fun main() {
    println("CLASSES")
    println("==============================")

    /*
    CLASS
     */
    class User(val id: Int, var password: String)
    println("Esta é a Class User ${User(12345, "12345678")}")

    /*
    DATA CLASS
    Classes utilizadas para armazenar valores e possuem métodos para copiar uma instancia
     */

    data class UserTwo(val nome: String, val id: Int)
    println("Esta é a Data Class User: ${UserTwo("Sun", 123456)}")
    val user = UserTwo("Sun", 123456)
    val newUser = user.copy()
    println("Essa é a cópia do Data Class User: $newUser")
    println("Essa é a comparação de user e cópia de user: ${user.equals(newUser)}")

    println("Exercício")
    data class Movie(val title: String, val year: Int, val director: String, val rating: Int)

    val movie = Movie("Um Filme", 1997, "Alcides Marques", 5)
    println("Objeto criado: $movie")
    println("Cópia do objeto criado: ${movie.copy()}")

    println("ENUM CLASS")
    println("==============================")
    /*
    Usados para representar um jogo finito de valores diferentes e podem conter propriedades
    e métodos como qualquer outra classe
     */
    println("O valor de Enum é: ${Button.PRIMARY}")
    println("O valor de Enum é: ${Button.SECUNDARY}")

    println("Exercício")
    println("O enum Cities é:${Cities.BUENOSAIRES}")
    println("O enum Cities é:${Cities.LIMA}")
    println("O enum Cities é:${Cities.MONTEVIDEU}")
    println("O enum Cities é:${Cities.SANTIAGOCHILE}")

    println("SEALED CLASS")
    println("==============================")
    /*
    A sealed class is abstract by itself,
    it cannot be instantiated directly and can have abstract members.

        Uma classe de tipo Sealed é muito semelhante a uma classe Enum, exceto
    que esta última permite uma única instância por enum, enquanto
    sealed class permite várias instâncias.
    Uma sealed class é uma classe abstrata, que não pode ser instanciada
    diretamente e pode conter métodos abstratos.
    Por exemplo, podemos definir uma sealed class que represente uma
    operação matemática (MathOperation) e as classes adição
    (SumOperation) e subtração (RemoveOperation) que herdem dela.
     */
    println("Selead class escrita fora da classe também =)")
    println("Retorno da classe abstract: ${MessageErrorOne().getMessage("teste")}")
    println("Retorno da classe abstract: ${MessageErrorTwo().getMessage("teste 2")}")

    println("OBJECT")
    println("==============================")

    /*
    Classes estáticas são chamadas de object e são uma instancia de uma classe,
    também chamado singleton

    IMPORTANTE:
    Este tipo de classe NÃO pode ser usado para armazenas dados.
     */

    println("Testando uma object: ${Utils.isFormatValid(("oryange@mercadolivre.com"))}")


    println("COMPANION OBJECT")
    println("==============================")
    /*
    Para definir métodos estáticos dentro de uma classe,
    um companion object poderá ser definido dentro dela e, neste lugar,
    as unções declaradas serão do tipo estático.
     */
    println("Companion object (o numero é a position) - como é void, apenas invoca:")
    BigBen.getBongs(5)


    println("LATEINIT VAR")
    println("==============================")
    /*
    Se declararmos uma lateinit var, estaremos informando ao compiladr que essa variável
    pode ser inicializada a qualquer momento.

    ver exemplo Class UserLateinit
     */
    var nome = UserLateinit()
    nome.setName("Ory")
    println("Resultado da lateinit var: ${nome.getName()} ")

    println("LAZY VAR")
    println("==============================")

    /*
    lazy só vai ser executado durante a inicialização, portanto, se a inicialização for
    custosa, só vai ser feita quando for necessário/utilizado e apenas uma única vez
    A inicialização lazy, obriga o uso de properties imutáveis (um benefício e tanto!),
    e também, é mais flexível, pois permite declarar o tipo da property tanto explicitamente, como também implicitamente
     */

    val valueLazy: String by lazy {
        println("computed")
        "Hello"
    }

    println("Esta é a variavel $valueLazy")
    println("============================= lazy")
    println(valueLazy)
    println(valueLazy)

    println("SCOPE FUNCTIONS DO KOTLIN")
    println("==============================")
    /*
    AS scopes functions do koltin são funçoes qe facilitam a leitura do código que estamos
    desenvolvendo - usando algumas das vantagens que oferece esta linguagem, entre elas,
    null safety

    Esses 3 scoping functions(LET, RUN E WITH) tem o mesmo propósito.

    LET - transforma: RETORNA qualquer valor a partir de um objeto do qual o escopo originou
     e refere-se a esse objeto como it
    RUN - transforma: RETORNA qualquer valor a partir de um objeto do qual o escopo se originou
     e refere-se a esse objeto como this.
    WITH - tranforma: RETORNA qualquer valor a partir de um objeto do qual o escopo se originou
     e refere-se a esse objeto como this.


    Trabalhar com um objeto de forma mais organizada? apply e also

    APPLY: Retorna o próprio objeto do qual partiu o escopo e dentro desse escopo o objeto é
    referido como this.
    ALSO: Retorna o próprio objeto do qual partiu o escopo e dentro desse escopo o objeto é
    referido como it.

    As funções de escopo não introduzem novos recursos técnicos, mas podem tornar seu código
     mais conciso e legível.

     As funções de escopo diferem pelo resultado que retornam:
     apply e also: retorne o objeto de contexto.
     let, run e with: retorne o resultado lambda.


     */

    Person(name = "Marcos Martins", 29, "Tech Lead").let {
        println(it)
        println(it.age)
    }

    Person("Sundari", 30, "Android Developer").run {
        println(this)
        println(this.name)
    }

    Person("Wiki", 1, "Cachorro").apply {
        println(this)
        println(this.name)
    }

    /*
    Exercicios:
    1 - Let, run, with, apply e also

     */
}
