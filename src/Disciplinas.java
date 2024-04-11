class Disciplinas {
    String nome;
    Disciplinas proxima;
    Disciplinas anterior;

    // cria objeto 'Disciplinas'
    public Disciplinas(String nome) {
        this.nome = nome;
        this.proxima = null;
        this.anterior = null;
    }
}