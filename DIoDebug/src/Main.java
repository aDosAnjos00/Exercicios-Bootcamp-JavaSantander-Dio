import br.com.dio.dao.UserDAO;
import br.com.dio.exception.UserNotFoundException;
import br.com.dio.model.MenuOption;
import br.com.dio.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    private final static UserDAO dao = new UserDAO();
    private final static Scanner scanner =  new Scanner(System.in);

    public static void main(String[] args) {
     while (true){
         System.out.println("Bem-Vindo ao cadastro de usuários, selecione a operação desejada:");
         System.out.println("1 - Cadastrar");
         System.out.println("2 - Atualizar");
         System.out.println("3 - Excluir");
         System.out.println("4 - Buscar");
         System.out.println("5 - Listar o identificador");
         System.out.println("6 - Sair");
         var userInput = scanner.nextInt();
         var selectedOption = MenuOption.values()[userInput-1];
         switch (selectedOption){
             case SAVE -> {
                 var user = dao.save(requesToSave());
                 System.out.printf("Usuário cadastrado %s", user);
             }
             case UPDATE -> {
                 var user = dao.update(requesToUpdate());
                 System.out.printf("Usuário atualizado %s", user);
             }
             case DELETE -> {
                 dao.delete(resquestId());
                System.out.println("Usuário excluido");
             }
             case FIND_BY_ID -> {
               try{
                   var id = resquestId();
                 var user = dao.findById(id);
                 System.out.printf("Usuários cadastrados:", id);
                 System.out.println(user);
               }catch (UserNotFoundException ex){

               }catch (Exception ex){

               }
             }
             case FIND_ALL -> {
                var users = dao.findAll();
                 System.out.printf("Usuários cadastrados: %s \n", users);
                 users.forEach(System.out::println);
             }
             case EXIT -> System.exit(0);
         }
     }
    }

    private static long resquestId(){
        System.out.println("Informe o identificador do usuário:");
        return scanner.nextLong();
    }

    private static UserModel requesToSave(){
        System.out.println("Informe o nome do usuário:");
        var name = scanner.next();
        System.out.println("Informe o email do usuário:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (DD/MM/YYYY):");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        var birthday = LocalDate.parse(birthdayString, formatter);
        var user = new UserModel(0,name, email, birthday);
        return new UserModel(0,name, email, birthday);
    }

    private static UserModel requesToUpdate(){
        System.out.println("Informe o identificador do usuário:");
        var id = scanner.nextLong();
        System.out.println("Informe o nome do usuário:");
        var name = scanner.next();
        System.out.println("Informe o email do usuário:");
        var email = scanner.next();
        System.out.println("Informe a data de nascimento do usuário (DD/MM/YYYY):");
        var birthdayString = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        var birthday = LocalDate.parse(birthdayString, formatter);
        var user = new UserModel(id,name, email, birthday);
        return new UserModel(id,name, email, birthday);
    }
}