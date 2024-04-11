class Disciplinas {
    String nome;
    Disciplinas proxima;
    Disciplinas anterior;

    // criando objeto 'Disciplinas'
    public Disciplinas(String nome) {
        this.nome = nome;
        this.proxima = null;
        this.anterior = null;
    }
}