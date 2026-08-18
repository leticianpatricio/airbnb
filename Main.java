import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Propriedade> listaPropriedades = new ArrayList<>();
        ArrayList<Reserva> listaReservas = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioArquivoDAO();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Cadastrar propriedade");
            System.out.println("4 - Listar propriedades");
            System.out.println("5 - Fazer reserva");
            System.out.println("6 - Listar reservas");
            System.out.println("7 - Verificar disponibilidade");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    try {

                        System.out.println("\n1 - Cliente");
                        System.out.println("2 - Proprietário");

                        System.out.print("Tipo: ");

                        int tipo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        if (!email.contains("@")) {

                            System.out.println("Email inválido.");
                            break;
                        }

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        if (tipo == 1) {

                            Cliente cliente =
                                    new Cliente(
                                            nome,
                                            email,
                                            senha
                                    );

                            listaUsuarios.add(cliente);

                            usuarioDAO.salvar(cliente);

                            System.out.println(
                                    "Cliente cadastrado."
                            );

                        } else if (tipo == 2) {

                            Proprietario proprietario =
                                    new Proprietario(
                                            nome,
                                            email,
                                            senha
                                    );

                            listaUsuarios.add(proprietario);

                            usuarioDAO.salvar(proprietario);

                            System.out.println(
                                    "Proprietário cadastrado."
                            );

                        } else {

                            System.out.println(
                                    "Tipo inválido."
                            );
                        }

                    } catch (Exception e) {

                        System.out.println(
                                "Erro no cadastro."
                        );
                    }

                    break;

                case 2:

                    if (listaUsuarios.isEmpty()) {

                        System.out.println(
                                "Nenhum usuário cadastrado."
                        );

                    } else {

                        for (Usuario u : listaUsuarios) {

                            u.imprimirDados();
                            System.out.println();
                        }
                    }

                    break;

                case 3:

                    try {

                        ArrayList<Proprietario> proprietarios =
                                new ArrayList<>();

                        for (Usuario u : listaUsuarios) {

                            if (u instanceof Proprietario) {

                                proprietarios.add(
                                        (Proprietario) u
                                );
                            }
                        }

                        if (proprietarios.isEmpty()) {

                            System.out.println(
                                    "Nenhum proprietário cadastrado."
                            );

                            break;
                        }

                        System.out.println(
                                "\nEscolha o proprietário:"
                        );

                        for (int i = 0;
                             i < proprietarios.size();
                             i++) {

                            System.out.println(
                                    i + " - " +
                                    proprietarios
                                            .get(i)
                                            .getNome()
                            );
                        }

                        int indiceProp = sc.nextInt();
                        sc.nextLine();

                        Proprietario proprietarioEscolhido =
                                proprietarios
                                        .get(indiceProp);

                        System.out.println("\n1 - Casa");
                        System.out.println("2 - Apartamento");
                        System.out.println("3 - Sitio");

                        System.out.print("Tipo: ");

                        int tipoProp = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();

                        System.out.print("Localização: ");
                        String localizacao = sc.nextLine();

                        System.out.print("Capacidade: ");
                        int capacidade = sc.nextInt();

                        if (capacidade <= 0) {

                            System.out.println(
                                    "Capacidade inválida."
                            );

                            break;
                        }

                        System.out.print(
                                "Preço por noite: "
                        );

                        double preco = sc.nextDouble();

                        sc.nextLine();

                        Propriedade propriedade = null;

                        if (tipoProp == 1) {

                            System.out.print(
                                    "Possui piscina? "
                            );

                            boolean piscina =
                                    sc.nextBoolean();

                            System.out.print(
                                    "Preço por pessoa: "
                            );

                            double precoPessoa =
                                    sc.nextDouble();

                            propriedade = new Casa(
                                    true,
                                    titulo,
                                    descricao,
                                    localizacao,
                                    capacidade,
                                    preco,
                                    proprietarioEscolhido,
                                    piscina,
                                    precoPessoa
                            );

                        } else if (tipoProp == 2) {

                            System.out.print("Andar: ");

                            int andar = sc.nextInt();

                            System.out.print("Taxa: ");

                            double taxa =
                                    sc.nextDouble();

                            propriedade =
                                    new Apartamento(
                                            true,
                                            titulo,
                                            descricao,
                                            localizacao,
                                            capacidade,
                                            preco,
                                            proprietarioEscolhido,
                                            andar,
                                            taxa
                                    );

                        } else if (tipoProp == 3) {

                            System.out.print(
                                    "Área total: "
                            );

                            double area =
                                    sc.nextDouble();

                            propriedade = new Sitio(
                                    true,
                                    titulo,
                                    descricao,
                                    localizacao,
                                    capacidade,
                                    preco,
                                    proprietarioEscolhido,
                                    area
                            );
                        }

                        listaPropriedades.add(
                                propriedade
                        );

                        proprietarioEscolhido
                                .cadastrarPropriedade(
                                        propriedade
                                );

                        System.out.println(
                                "Propriedade cadastrada."
                        );

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao cadastrar propriedade."
                        );

                        sc.nextLine();
                    }

                    break;

                case 4:

                    if (listaPropriedades.isEmpty()) {

                        System.out.println(
                                "Nenhuma propriedade cadastrada."
                        );

                    } else {

                        for (Propriedade p :
                                listaPropriedades) {

                            p.imprimirDados();

                            System.out.println();
                        }
                    }

                    break;

                case 5:

                    try {

                        ArrayList<Cliente> clientes =
                                new ArrayList<>();

                        for (Usuario u :
                                listaUsuarios) {

                            if (u instanceof Cliente) {

                                clientes.add(
                                        (Cliente) u
                                );
                            }
                        }

                        if (clientes.isEmpty()) {

                            System.out.println(
                                    "Nenhum cliente cadastrado."
                            );

                            break;
                        }

                        if (listaPropriedades.isEmpty()) {

                            System.out.println(
                                    "Nenhuma propriedade cadastrada."
                            );

                            break;
                        }

                        System.out.println(
                                "\nEscolha o cliente:"
                        );

                        for (int i = 0;
                             i < clientes.size();
                             i++) {

                            System.out.println(
                                    i + " - " +
                                    clientes
                                            .get(i)
                                            .getNome()
                            );
                        }

                        int indiceCliente =
                                sc.nextInt();

                        Cliente clienteEscolhido =
                                clientes.get(
                                        indiceCliente
                                );

                        System.out.println(
                                "\nEscolha a propriedade:"
                        );

                        for (int i = 0;
                             i < listaPropriedades.size();
                             i++) {

                            System.out.println(
                                    i + " - " +
                                    listaPropriedades
                                            .get(i)
                                            .getTitulo()
                            );
                        }

                        int indiceImovel =
                                sc.nextInt();

                        Propriedade prop =
                                listaPropriedades.get(
                                        indiceImovel
                                );

                        if (!prop.isDisponivel()) {

                            System.out.println(
                                    "Propriedade indisponível."
                            );

                            break;
                        }

                        System.out.print(
                                "Ano check-in: "
                        );

                        int anoIn = sc.nextInt();

                        System.out.print(
                                "Mês check-in: "
                        );

                        int mesIn = sc.nextInt();

                        System.out.print(
                                "Dia check-in: "
                        );

                        int diaIn = sc.nextInt();

                        System.out.print(
                                "Ano check-out: "
                        );

                        int anoOut = sc.nextInt();

                        System.out.print(
                                "Mês check-out: "
                        );

                        int mesOut = sc.nextInt();

                        System.out.print(
                                "Dia check-out: "
                        );

                        int diaOut = sc.nextInt();

                        LocalDate checkIn =
                                LocalDate.of(
                                        anoIn,
                                        mesIn,
                                        diaIn
                                );

                        LocalDate checkOut =
                                LocalDate.of(
                                        anoOut,
                                        mesOut,
                                        diaOut
                                );

                        Reserva reserva =
                                new Reserva(
                                        prop,
                                        clienteEscolhido,
                                        checkIn,
                                        checkOut
                                );

                        listaReservas.add(
                                reserva
                        );

                        clienteEscolhido
                                .getReservasRealizadas()
                                .add(reserva);

                        prop.setDisponivel(false);

                        System.out.println(
                                "Reserva realizada."
                        );

                    } catch (
                            InputMismatchException e
                    ) {

                        System.out.println(
                                "Digite valores válidos."
                        );

                        sc.nextLine();

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao realizar reserva."
                        );
                    }

                    break;

                case 6:

                    if (listaReservas.isEmpty()) {

                        System.out.println(
                                "Nenhuma reserva cadastrada."
                        );

                    } else {

                        for (Reserva r :
                                listaReservas) {

                            r.imprimirDados();

                            System.out.println();
                        }
                    }

                    break;

                case 7:

                    for (Propriedade p :
                            listaPropriedades) {

                        System.out.println(
                                p.getTitulo()
                        );

                        p.verificarDisponibilidade();

                        System.out.println();
                    }

                    break;

                case 0:

                    System.out.println("Saindo...");
                    break;

                default:

                    System.out.println(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);

        sc.close();
    }
}