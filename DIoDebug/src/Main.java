import br.com.dio.dao.UserDAO;
import br.com.dio.model.MenuOption;

import java.util.Scanner;

public class Main {

    private final static UserDAO dao = new UserDAO();

    public static void main(String[] args) {
     var scanner =  new Scanner(System.in);
     System.out.println("Bem-Vindo ao cadastro de usuários, selecione a operação desejada:");
     System.out.println("1 - Cadastrar");
     System.out.println("2 - Atualizar");
     System.out.println("3 - Excluir");
     System.out.println("4 - Buscar");
     System.out.println("5 - Listar o identificador");
     System.out.println("6 - Sair");
     var userInput = scanner.nextInt();
     while (true){
         var selectedOption = MenuOption.values()[userInput-1];
     }
    }
}