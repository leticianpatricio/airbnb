public class Apartamento extends Propriedade {

    private int andar;
    private double taxaCondominio;

    public Apartamento(
            boolean disponivel,
            String titulo,
            String descricao,
            String localizacao,
            int capacidade,
            double precoNoite,
            Proprietario proprietario,
            int andar,
            double taxaCondominio
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

        this.andar = andar;
        this.taxaCondominio = taxaCondominio;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getTaxaCondominio() {
        return taxaCondominio;
    }

    public void setTaxaCondominio(
            double taxaCondominio
    ) {

        this.taxaCondominio =
                taxaCondominio;
    }

    @Override
    public void imprimirDados() {

        System.out.println(
                "===== APARTAMENTO ====="
        );

        System.out.println(
                "Título: " + getTitulo()
        );

        System.out.println(
                "Descrição: " +
                getDescricao()
        );

        System.out.println(
                "Localização: " +
                getLocalizacao()
        );

        System.out.println(
                "Capacidade: " +
                getCapacidade()
        );

        System.out.println(
                "Preço por noite: " +
                getPrecoNoite()
        );

        System.out.println(
                "Andar: " + andar
        );

        System.out.println(
                "Taxa condomínio: " +
                taxaCondominio
        );

        System.out.println(
                "Proprietário: " +
                getProprietario().getNome()
        );
    }

    @Override
    public double calcularPrecoTotal(
            int dias
    ) {

        return (getPrecoNoite() * dias)
                + taxaCondominio;
    }
}