package Week02.classicmodels.peristence;

import Week02.classicmodels.business.Product;
import week03.classicmodels.persistence.EmployeeDao;
import week03.classicmodels.persistence.EmployeeDaoImpl;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl {

    public List<Product> getAllProducts() {
        ArrayList<Product> productList = new ArrayList<>();

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/classicmodels";
        String username = "root";
        String password = "";
        try {
            Class.forName(driver);

            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                try (PreparedStatement ps = conn.prepareStatement("SELECT * from products")) {
                    try (ResultSet rs = ps.executeQuery()) {
                        while (rs.next()) {
                            Product p = new Product(
                                    rs.getString("productCode"),
                                    rs.getString("productName"),
                                    rs.getString("productLine"),
                                    rs.getString("productScale"),
                                    rs.getString("productVendor"),
                                    rs.getString("productDescription"),
                                    rs.getInt("quantityInStock"),
                                    rs.getDouble("buyPrice"),
                                    rs.getDouble("MSRP")
                            );
                            productList.add(p);
                        }
                    } catch (SQLException e) {
                        System.out.println(LocalDateTime.now() + ": An SQLException  occurred while running the query" +
                                " or processing the result.");
                        System.out.println("Error: " + e.getMessage());
                        e.printStackTrace();
                    }
                } catch (SQLException e) {
                    System.out.println(LocalDateTime.now() + ": An SQLException  occurred while preparing the SQL " +
                            "statement.");
                    System.out.println("Error: " + e.getMessage());
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println(LocalDateTime.now() + ": An SQLException  occurred while trying to connect to the " + url +
                        "database.");
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(LocalDateTime.now() + ": A ClassNotFoundException occurred while trying to load the MySQL driver.");
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return productList;

    }
    public static void main(String[] args) {
        ProductDaoImpl empDao = new ProductDaoImpl();
        System.out.println(empDao.getAllProducts());
        System.out.println("---------------------------------------");
    }
}

