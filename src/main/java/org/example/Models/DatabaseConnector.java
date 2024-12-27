package org.example.Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
    //deklarasi atribut
    private static final String url = "jdbc:mysql://localhost/serkom";
    private static final String user = "root";
    private static final String password = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void testConnection() {
        try (Connection connection = connect()) {
            if (connection != null) {
                System.out.println("Koneksi berhasil ke MySQL!");;
            } else {
                System.out.println("Koneksi gagal ke MySQL!");
            }
        } catch (SQLException e) {
            System.err.println("Error saat mencoba koneksi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void savePayment(int amount, Date date) {
        String query = "INSERT INTO savepayment (amount, date) VALUES (?, ?)";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, amount);
                preparedStatement.setDate(2, date);
                preparedStatement.executeUpdate();
                System.out.println("Payment successfully saved!");
                System.out.println();
                System.out.println();
        } catch (SQLException e) {
            System.err.println("Error while saving payment " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<PaymentRecords> PaymentRecords() throws SQLException {
        List<PaymentRecords> records = new ArrayList<>();
        String query = "SELECT id, amount, date FROM savepayment";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                records.add(new PaymentRecords(
                        rs.getInt("id"),
                        rs.getInt("amount"),
                        rs.getDate("date")
                ));
            }
        }
        return records;
    }
}
