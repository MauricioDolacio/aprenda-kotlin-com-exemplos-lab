// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(
    val nome: String,
    val email: String,
    val dataNascimento: String,
) {
    private val formacoesMatriculadas = mutableListOf<Formacao>()

    fun adicionarFormacao(formacao: Formacao) {
        formacoesMatriculadas.add(formacao)
    }

    fun imprimirFormacoes() {
        println("Formações matriculadas por $nome:")
        for (formacao in formacoesMatriculadas) {
            println("- ${formacao.nome} (Nível: ${formacao.nivel})")
        }
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        usuario.adicionarFormacao(this)
        println("${usuario.nome} foi matriculado na formação $nome.")
    }

    fun imprimirUsuariosMatriculados() {
        println("Usuários matriculados na formação $nome:")
        for (usuario in inscritos) {
            println("- ${usuario.nome} (${usuario.email})")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 120)

    val formacaoKotlin = Formacao("Formação Kotlin", mutableListOf(conteudo1), Nivel.BASICO)
    val formacaoAndroid = Formacao("Formação Android", mutableListOf(conteudo2), Nivel.AVANCADO)

    val usuario1 = Usuario("Mauricio", "mauriciodolacio@outlook.com", "05/10/2002")
    val usuario2 = Usuario("Maria", "maria@email.com", "01/12/2001")
    val usuario3 = Usuario("Pedro", "pedro@email.com", "09/06/2009")

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoAndroid.matricular(usuario2)
    formacaoAndroid.matricular(usuario3)

    println()
    formacaoKotlin.imprimirUsuariosMatriculados()
    formacaoAndroid.imprimirUsuariosMatriculados()

    println()
    usuario1.imprimirFormacoes()
    usuario2.imprimirFormacoes()
    usuario3.imprimirFormacoes()
}
