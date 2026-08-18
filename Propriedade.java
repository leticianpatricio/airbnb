public abstract class Propriedade {

    private boolean disponivel;
    private String titulo;
    private String descricao;
    private String localizacao;
    private int capacidade;
    private double precoNoite;
    private Proprietario proprietario;

    public Propriedade(boolean disponivel, String titulo, String descricao,
                       String localizacao, int capacidade, double precoNoite,
                       Proprietario proprietario) {

        this.disponivel = disponivel;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.precoNoite = precoNoite;
        this.proprietario = proprietario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPrecoNoite() {
        return precoNoite;
    }

    public void setPrecoNoite(double precoNoite) {
        this.precoNoite = precoNoite;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public void verificarDisponibilidade() {
        if (disponivel) {
            System.out.println("Propriedade disponível.");
        } else {
            System.out.println("Propriedade indisponível.");
        }
    }

    public abstract void imprimirDados();

    public abstract double calcularPrecoTotal(int dias);
}