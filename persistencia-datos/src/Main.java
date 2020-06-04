import Connection.ConnectionMySql;

import java.sql.Connection;
import java.util.Scanner;

import Mensajes.MensajesService;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Eliminar");
            System.out.println("5. Salir");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    MensajesService.create();
                    break;
                case 2:
                    MensajesService.list();
                    break;
                case 3:
                    MensajesService.update();
                    break;
                case 4:
                    MensajesService.delete();
                    break;
                default:
                    break;
            }
        } while (option != 5);

        /*ConnectionMySql connection = new ConnectionMySql();
        try (Connection cnx = connection.getConnection()) {

        } catch (Exception exception) {

        }*/
    }
}
