public class Casa extends Propriedade {

    private boolean piscina;
    private double precoPessoa;

    public Casa(
            boolean disponivel,
            String titulo,
            String descricao,
            String localizacao,
            int capacidade,
            double precoNoite,
            Proprietario proprietario,
            boolean piscina,
            double precoPessoa
    ) {

        super(
                disponivel,
                titulo,
                descricao,
                localizacao,
                capacidade,
                precoNoite,
                proprietario
        );

        this.piscina = piscina;
        this.precoPessoa = precoPessoa;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public double getPrecoPessoa() {
        return precoPessoa;
    }

    public void setPrecoPessoa(double precoPessoa) {
        this.precoPessoa = precoPessoa;
    }

    @Override
    public void imprimirDados() {

        System.out.println("===== CASA =====");

        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Localização: " + getLocalizacao());
        System.out.println("Capacidade: " + getCapacidade());
        System.out.println("Preço por noite: " + getPrecoNoite());

        System.out.println("Piscina: " + piscina);
        System.out.println("Preço por pessoa: " + precoPessoa);

        System.out.println(
                "Proprietário: " +
                getProprietario().getNome()
        );
    }

    @Override
    public double calcularPrecoTotal(int dias) {

        return (getPrecoNoite() * dias)
                + precoPessoa;
    }
}