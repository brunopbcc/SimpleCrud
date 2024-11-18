import java.util.ArrayList;
import java.util.Scanner;

public class CrudClientes {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\nSistema CRUD de Clientes");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Buscar Cliente por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    buscarClientePorId();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        clientes.add(new Cliente(id, nome, email, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nLista de Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void atualizarCliente() {
        System.out.print("ID do Cliente para atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = buscarCliente(id);

        if (cliente != null) {
            System.out.print("Novo Nome: ");
            cliente.setNome(scanner.nextLine());
            System.out.print("Novo Email: ");
            cliente.setEmail(scanner.nextLine());
            System.out.print("Novo Telefone: ");
            cliente.setTelefone(scanner.nextLine());
            System.out.println("Dados do cliente atualizados com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removerCliente() {
        System.out.print("ID do Cliente para remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = buscarCliente(id);

        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void buscarClientePorId() {
        System.out.print("ID do Cliente para buscar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = buscarCliente(id);

        if (cliente != null) {
            System.out.println("\nDetalhes do Cliente:");
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
