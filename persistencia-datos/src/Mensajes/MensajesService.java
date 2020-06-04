package Mensajes;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class MensajesService {
    public static void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribir mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribir autor");
        String autor = sc.nextLine();
        MensajesModel mensajeModel = new MensajesModel();
        mensajeModel.setMensaje(mensaje);
        mensajeModel.setAutorMensaje(autor);
        MensajesDAO.create(mensajeModel);
    }

    public static void list() {
        MensajesDAO.read();
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Id del mensaje a borrar: ");
        int id = sc.nextInt();
        MensajesDAO.delete(id);
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mensaje nuevo: ");
        String mensaje = sc.nextLine();
        System.out.println("Id del mensaje: ");
        int id = sc.nextInt();
        MensajesModel mensajeModel = new MensajesModel();
        mensajeModel.setMensaje(mensaje);
        mensajeModel.setIdMensaje(id);
        MensajesDAO.update(mensajeModel);
    }
}
