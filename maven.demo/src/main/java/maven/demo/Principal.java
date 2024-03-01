package maven.demo;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.conectar();
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("Menu:");
            System.out.println("1) Listar");
            System.out.println("2) Inserir");
            System.out.println("3) Excluir");
            System.out.println("4) Atualizar");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    // Listar
                    Usuario[] usuarios = dao.getUsuarios();
                    for (Usuario usuario : usuarios) {
                        System.out.println(usuario.toString());
                    }
                    break;
                case 2:
                    // Inserir
                    System.out.println("Informe os dados do Usuario:");
                    System.out.print("ID: ");
                    int id = scanner.nextInt(); // Solicita o ID ao usuário
                    System.out.print("Login: ");
                    String login = scanner.next();
                    System.out.print("Senha: ");
                    String senha = scanner.next();
                    System.out.print("Sexo: ");
                    char sexo = scanner.next().charAt(0);
                    
                    Usuario novoUsuario = new Usuario(id, login, senha, sexo);
                    if (dao.inserirUsuario(novoUsuario)) {
                        System.out.println("Inserção bem-sucedida: " + novoUsuario.toString());
                    } else {
                        System.out.println("Erro ao inserir Usuario.");
                    }
                    break;
                case 3:
                    // Excluir
                    System.out.print("Informe o Código do Usuario a ser excluído: ");
                    int codigoExcluir = scanner.nextInt();
                    if (dao.excluirUsuario(codigoExcluir)) {
                        System.out.println("Exclusão bem-sucedida.");
                    } else {
                        System.out.println("Erro ao excluir Usuario.");
                    }
                    break;
                case 4:
                    // Atualizar
                    System.out.println("Informe os novos dados do Usuario:");
                    System.out.print("Código: ");
                    int codigoAtualizar = scanner.nextInt();
                    System.out.print("Login: ");
                    String novoLogin = scanner.next();
                    System.out.print("Senha: ");
                    String novaSenha = scanner.next();
                    System.out.print("Sexo: ");
                    char novoSexo = scanner.next().charAt(0);
                    
                    Usuario usuarioAtualizar = new Usuario(codigoAtualizar, novoLogin, novaSenha, novoSexo);
                    if (dao.atualizarUsuario(usuarioAtualizar)) {
                        System.out.println("Atualização bem-sucedida.");
                    } else {
                        System.out.println("Erro ao atualizar Usuario.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
        
        dao.close();
        scanner.close();
    }
}
