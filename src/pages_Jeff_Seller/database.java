/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages_Jeff_Seller;

/**
 *
 * @author jeffplatel
 */
import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

public class database {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:sqlite.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    //edit later
    public void add_product(String product_name_text, String price_text, String quantity_text, String description_text, Boolean approval) {
    	System.out.print("starting");

        String sql = "INSERT INTO users(product_name_text, price_text, quantity_text, description_text, approval) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product_name_text.toLowerCase());
            //pstmt.setString(2, lastname.toLowerCase());
            pstmt.setString(3, price_text.toLowerCase());

            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(quantity_text.getBytes(StandardCharsets.UTF_8));
                byte[] passwordHashBytes = messageDigest.digest();
                String passwordHashString = "";
  
                // Iterating through each byte in the array
                for (byte i : passwordHashBytes) {
                    passwordHashString += String.format("%02X", i);
                }
                pstmt.setString(4, passwordHashString);
            } catch (NoSuchAlgorithmException e){
                System.out.println(e.getMessage());
            }
        
            pstmt.setString(5, description_text.toLowerCase());
            pstmt.setBoolean(6, approval);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("ending");
    }

    public void add_user(String firstname, String email, String password, String account_type, Boolean approval) {
    	System.out.print("starting");

        String sql = "INSERT INTO users(firstname, email, password, account_type, approval) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstname.toLowerCase());
            //pstmt.setString(2, lastname.toLowerCase());
            pstmt.setString(3, email.toLowerCase());

            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
                byte[] passwordHashBytes = messageDigest.digest();
                String passwordHashString = "";
  
                // Iterating through each byte in the array
                for (byte i : passwordHashBytes) {
                    passwordHashString += String.format("%02X", i);
                }
                pstmt.setString(4, passwordHashString);
            } catch (NoSuchAlgorithmException e){
                System.out.println(e.getMessage());
            }
        
            pstmt.setString(5, account_type.toLowerCase());
            pstmt.setBoolean(6, approval);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.print("ending");
    }

    public boolean authenticate_user(String email, String password){
        String sql =  "SELECT * FROM users WHERE email = ?";			
       // String sql2 = "SELECT * FROM users WHERE username = "

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, email.toLowerCase());

                ResultSet results = pstmt.executeQuery();
                

            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
                byte[] passwordHashBytes = messageDigest.digest();
                String passwordHashString = "";
  
                // Iterating through each byte in the array
                for (byte i : passwordHashBytes) {
                    passwordHashString += String.format("%02X", i);
                }

                if (passwordHashString.equals(results.getString("password"))){
                    System.out.print("you have an account");
                    return true;
                } else {
                    System.out.print("you do not have an account");
                    return false;
                }

            } catch (NoSuchAlgorithmException e){
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void edit_user(Integer user_id, String firstname, String lastname, String email, String password, String account_type, Boolean approval){
        
        String query1 =  "SELECT user_id FROM users WHERE user_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, user_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (firstname != null){
            String query2 =  "UPDATE users SET firstname = ? WHERE user_id = ?";
            try (Connection connQuery2 = this.connect(); PreparedStatement pstmt2 = connQuery2.prepareStatement(query2)){
                pstmt2.setString(1, firstname);
                pstmt2.setInt(2, user_id);
                pstmt2.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (lastname != null){
            String query3 =  "UPDATE users SET lastname = ? WHERE user_id = ?";
            try (Connection connQuery3 = this.connect(); PreparedStatement pstmt3 = connQuery3.prepareStatement(query3)){
                pstmt3.setString(1, lastname);
                pstmt3.setInt(2, user_id);
                pstmt3.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (email != null){
            String query4 =  "UPDATE users SET email = ? WHERE user_id = ?";
            try (Connection connQuery4 = this.connect(); PreparedStatement pstmt4 = connQuery4.prepareStatement(query4)){
                pstmt4.setString(1, email);
                pstmt4.setInt(2, user_id);
                pstmt4.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (password != null){
            String passwordHashString = "";
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
                byte[] passwordHashBytes = messageDigest.digest();
    
                // Iterating through each byte in the array
                for (byte i : passwordHashBytes) {
                    passwordHashString += String.format("%02X", i);
                }
            } catch (NoSuchAlgorithmException e){
                System.out.println(e.getMessage());
            }

            String query5 =  "UPDATE users SET password = ? WHERE user_id = ?";
            try (Connection connQuery5 = this.connect(); PreparedStatement pstmt5 = connQuery5.prepareStatement(query5)){
                pstmt5.setString(1, passwordHashString);
                pstmt5.setInt(2, user_id);
                pstmt5.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (account_type != null){
            String query6 =  "UPDATE users SET account_type = ? WHERE user_id = ?";
            try (Connection connQuery6 = this.connect(); PreparedStatement pstmt6 = connQuery6.prepareStatement(query6)){
                pstmt6.setString(1, account_type);
                pstmt6.setInt(2, user_id);
                pstmt6.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (approval != null){
            String query7 =  "UPDATE users SET approval = ? WHERE user_id = ?";
            try (Connection connQuery7 = this.connect(); PreparedStatement pstmt7 = connQuery7.prepareStatement(query7)){
                pstmt7.setBoolean(1, approval);
                pstmt7.setInt(2, user_id);
                pstmt7.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void delete_user(Integer user_id){

        String query1 =  "SELECT user_id FROM users WHERE user_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, user_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql =  "DELETE FROM users WHERE user_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, user_id);
                pstmt.executeUpdate();
                System.out.println("User has been deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void grab_user_info(Integer user_id){
        String sql =  "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, user_id);

                ResultSet results = pstmt.executeQuery();

                System.out.println(results.getInt("user_id") + " " + results.getString("firstname") + " " + results.getString("lastname") + " " + results.getString("email") + " " + results.getString("account_type") + " " + results.getString("approval"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add_product(String name, String description, Integer price, Integer amount_sold, Integer user_id){
        String sql = "INSERT INTO products(name, description, price, amount_sold, seller_id) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, price);
            pstmt.setInt(4, amount_sold);
            pstmt.setInt(5, user_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void edit_product(Integer product_id, String name, String description, Integer price, Integer amount_sold){
        String query1 =  "SELECT product_id FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (name != null){
            String query2 =  "UPDATE products SET name = ? WHERE product_id = ?";
            try (Connection connQuery2 = this.connect(); PreparedStatement pstmt2 = connQuery2.prepareStatement(query2)){
                pstmt2.setString(1, name);
                pstmt2.setInt(2, product_id);
                pstmt2.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (description != null){
            String query3 =  "UPDATE products SET description = ? WHERE product_id = ?";
            try (Connection connQuery3 = this.connect(); PreparedStatement pstmt3 = connQuery3.prepareStatement(query3)){
                pstmt3.setString(1, description);
                pstmt3.setInt(2, product_id);
                pstmt3.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (price != null){
            String query3 =  "UPDATE products SET price = ? WHERE product_id = ?";
            try (Connection connQuery3 = this.connect(); PreparedStatement pstmt3 = connQuery3.prepareStatement(query3)){
                pstmt3.setInt(1, price);
                pstmt3.setInt(2, product_id);
                pstmt3.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (amount_sold != null){
            String query4 =  "UPDATE products SET amount_sold = ? WHERE product_id = ?";
            try (Connection connQuery4 = this.connect(); PreparedStatement pstmt4 = connQuery4.prepareStatement(query4)){
                pstmt4.setInt(1, amount_sold);
                pstmt4.setInt(2, product_id);
                pstmt4.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void add_product_sale(Integer product_id, Integer amount){

        Integer ogAmount = 0;
        String query1 =  "SELECT amount_sold FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return;
            } else {
                ogAmount = results1.getInt("amount_sold");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql =  "UPDATE products SET amount_sold = ? WHERE product_id = ?";
            try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)){
                pstmt.setInt(1, ogAmount + amount);
                pstmt.setInt(2, product_id);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }

    public void delete_product(Integer product_id){
        String query1 =  "SELECT product_id FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("Product does not exist");
                return;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql =  "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, product_id);
                pstmt.executeUpdate();
                System.out.println("User has been deleted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        database db = new database();
        // add user
        // refer to method to see arguments. All must be filled out or else error will raise.
        //db.add_user("jar", "mercer", "test@email.com", "password", "buyer", true);
        

        // authenticate_user
        // must use given email and password as arguments
        db.authenticate_user("test@email.com", "password");

        // grab_user_info
        // give user id and all information will be printed to console
        //db.grab_user_info(1);

        // edit_user
        // refer to method to see arguments. All must be filled out but if there is an attribute you dont want to change you can set the arugment to null.
        //db.edit_user(1, "jon_edit", "mercer_edit" , "test-edit@email.com", "password1", "seller", false);

        // delete_user
        // give a user id and the user will be deleted from the database
        //db.delete_user(1);

        // add product
        // refer to method to see arguments. All must be filled out or else error will raise.
        //db.add_product("product", "This is the description", 999, 0, 1);

        // edit_product
        // refer to method to see arguments. All must be filled out but if there is an attribute you dont want to change you can set the arugment to null.
        //db.edit_product(1, "product-edit", null , 999, 99);

        // add_product_sale
        // give a product id, and amount sold and the amount_sold will increment by the argument
        //db.add_product_sale(1, 7);

        // delete_product
        // give a product id and the product will be deleted from the database
        //db.delete_product(1);

    }

    void add_user(String text, String text0, String valueOf, String valueOf0, boolean match) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

