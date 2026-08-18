public class Sitio extends Propriedade {

    private double areaTotal;

    public Sitio(
            boolean disponivel,
            String titulo,
            String descricao,
            String localizacao,
            int capacidade,
            double precoNoite,
            Proprietario proprietario,
            double areaTotal
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

        this.areaTotal = areaTotal;
    }

    public double getAreaTotal() {
        return areaTotal;
    }

    public void setAreaTotal(
            double areaTotal
    ) {

        this.areaTotal = areaTotal;
    }

    @Override
    public void imprimirDados() {

        System.out.println(
                "===== SITIO ====="
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
                "Área total: " +
                areaTotal
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

        return getPrecoNoite() * dias;
    }
}