public class Alunos {
    String rgm;
    String nome;
    String curso;
    ListaEncadeada disciplinas;

    //criando objetos 'Alunos'
    public Alunos(String rgm, String nome, String curso) {
        this.rgm = rgm;
        this.nome = nome;
        this.curso = curso;
        this.disciplinas = null;
    }
}
