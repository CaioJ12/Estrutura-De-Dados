public class ListaEncadeada {
    Disciplinas primeiro;
    Disciplinas ultimo;
    int tamanho;

    //Construindo objeto ListaEncadeada
    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    //função inserir para inserir disciplinas
    public void inserir(String nome) {
        //iniciando objeto disciplinas
        Disciplinas novaDisciplina = new Disciplinas(nome);

        // verificação do conteudo do primeiro ponteiro (caso o primeiro for null a novaDisciplina é o primeiro e último)
        if (primeiro == null) {
            primeiro = novaDisciplina;
            ultimo = novaDisciplina;
        } else {
            // adiciona 'novaDisciplina' ao final da lista e atualiza o 'último'
            novaDisciplina.anterior = ultimo;
            ultimo.proxima = novaDisciplina;
            ultimo = novaDisciplina;
        }
        tamanho++;
    }

}
