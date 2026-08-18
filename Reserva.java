import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {

    private Propriedade propriedade;
    private Cliente cliente;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double custoTotal;

    public Reserva(Propriedade propriedade, Cliente cliente,
                    LocalDate checkIn, LocalDate checkOut) {

        this.propriedade = propriedade;
        this.cliente = cliente;
        this.checkIn = checkIn;
        this.checkOut = checkOut;

        this.custoTotal = calcularCustoTotal();
    }

    public double calcularCustoTotal() {
        long dias = ChronoUnit.DAYS.between(checkIn, checkOut);
        return propriedade.calcularPrecoTotal((int)dias);
    }

    public void imprimirDados() {
        System.out.println("RESERVA");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Propriedade: " + propriedade.getTitulo());
        System.out.println("Check-in: " + checkIn);
        System.out.println("Check-out: " + checkOut);
        System.out.println("Custo total: " + custoTotal);
    }
}