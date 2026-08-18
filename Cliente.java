import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Usuario {

    private ArrayList<Reserva> reservasRealizadas;

    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
        reservasRealizadas = new ArrayList<>();
    }

    public ArrayList<Reserva> getReservasRealizadas() {
        return reservasRealizadas;
    }

    public void realizarReserva(Propriedade p, LocalDate checkIn, LocalDate checkOut) {
        Reserva r = new Reserva(p, this, checkIn, checkOut);
        reservasRealizadas.add(r);
        p.setDisponivel(false);
    }

    public void listarReservas() {
        for (Reserva r : reservasRealizadas) {
            r.imprimirDados();
            System.out.println();
        }
    }

    public void listarPropriedadesDisponiveis(ArrayList<Propriedade> propriedades) {
        for (Propriedade p : propriedades) {
            if (p.isDisponivel()) {
                p.imprimirDados();
            }
        }
    }

    @Override
    public void imprimirDados() {
        System.out.println("CLIENTE");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
    }
}