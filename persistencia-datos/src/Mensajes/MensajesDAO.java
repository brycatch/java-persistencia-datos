package Mensajes;

import Connection.ConnectionMySql;

import java.sql.*;

public class MensajesDAO {

    public static void create(MensajesModel mensaje) {
        ConnectionMySql connectionMySql = new ConnectionMySql();
        try (Connection cnx = connectionMySql.getConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje,fecha_mensaje) VALUES (?, ? ,CURRENT_TIMESTAMP);";
                ps = cnx.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutorMensaje());
                ps.executeUpdate();
                System.out.println("Mensaje creado correctamente");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException exception) {

        }

    }

    public static void read() {
        ConnectionMySql connectionMySql = new ConnectionMySql();
        try (Connection cnx = connectionMySql.getConnection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String query = "SELECT * FROM mensajes";
            ps = cnx.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getDate("fecha_mensaje"));
                System.out.println();
            }
        } catch (SQLException exception) {
            System.out.println("No se pudieron recuperar mensajes");
        }

    }

    public static void update(MensajesModel mensaje) {
        ConnectionMySql connectionMySql = new ConnectionMySql();
        try (Connection cnx = connectionMySql.getConnection()) {
            PreparedStatement ps = null;
            String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
            ps = cnx.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getIdMensaje());
            ps.executeUpdate();
            System.out.println("Mensaje actualizado correctamente");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void delete(int id) {
        ConnectionMySql connectionMySql = new ConnectionMySql();
        try (Connection cnx = connectionMySql.getConnection()) {
            PreparedStatement ps = null;
            String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
            ps = cnx.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("El mensaje fue borrado");
        } catch (SQLException e) {
            System.out.println("No se pudieron borrar el mensaje");
        }
    }


}
