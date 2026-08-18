import java.util.ArrayList;

public class Proprietario extends Usuario {

    private ArrayList<Propriedade> propriedades;

    public Proprietario(String nome, String email, String senha) {
        super(nome, email, senha);
        propriedades = new ArrayList<>();
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void cadastrarPropriedade(Propriedade p) {
        propriedades.add(p);
    }

    public void listarPropriedades() {
        for (Propriedade p : propriedades) {
            p.imprimirDados();
            System.out.println();
        }
    }

    public void listarPropriedadesAlugadas() {
        for (Propriedade p : propriedades) {
            if (!p.isDisponivel()) {
                p.imprimirDados();
            }
        }
    }

    @Override
    public void imprimirDados() {
        System.out.println("PROPRIETÁRIO");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
    }
}