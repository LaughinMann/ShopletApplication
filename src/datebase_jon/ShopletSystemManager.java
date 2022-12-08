package datebase_jon;

import java.sql.Connection;
import java.sql.DriverManager;  
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class ShopletSystemManager {

	public Integer current_user_id;
	
    private static ShopletSystemManager _instance = null;
    
    /**
     * Retrieves the singleton instance of a Cart object.
     * @return The current user's cart.
     */
    public static synchronized ShopletSystemManager getInstance()
    {
    	if (_instance == null)
    		_instance = new ShopletSystemManager();
    	
    	return _instance;
    }

    /**
     * connect to existing database
     * @return connection object
     */
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


    /**
     * add a new user to the database
     * @param firstname first name of user 
     * @param lastname last name of user 
     * @param email email of user 
     * @param password password of user 
     * @param account_type account_type of user (seller, buyer, admin)
     * @param approval approval of user (this is for when a seller is approved or not)
     * @return a "success" response message
     */
    public String add_user(String firstname, String lastname, String email, String password, String account_type, Boolean approval) {

        String sql = "INSERT INTO users(firstname, lastname, email, password, account_type, approval) VALUES(?,?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstname.toLowerCase());
            pstmt.setString(2, lastname.toLowerCase());
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

            return "User has been added";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "no database connection";
        }
    }
    
    /**
     * compare username and password to database
     * @param email email of the user
     * @param password password of the user
     * @return a user object with information
     */
    public User authenticate_user(String email, String password){
        User user = new User();
        String sql =  "SELECT * FROM users WHERE email = ?";

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
                    System.out.println("User account found");
                    user.user_id = results.getInt("user_id");
                    user.firstname = results.getString("firstname");
                    user.lastname = results.getString("lastname");
                    user.email = results.getString("email");
                    user.account_type = results.getString("account_type");
                    user.approval = results.getBoolean("approval");
                    user.authenticated = true;
                    current_user_id = user.user_id;
                    return user;
                } else {
                    System.out.println("User not found, possible incorrect username or password");
                    user.authenticated = false;
                    return user;
                }

            } catch (NoSuchAlgorithmException e){
                System.out.println(e.getMessage());
                user.authenticated = false;
                return user;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            user.authenticated = false;
            return user;
        }
    }
    
    /**
     * get a list of approved or unapproved sellers
     * @param approved boolean of whether the sellers are approved or not
     * @return list of user objects
     */
    public List<User> grab_sellers(Boolean approved){
        String sql =  "SELECT * FROM users WHERE approval = ? AND account_type = ?";
        
        List<User> sellerList = new ArrayList<User>();

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                if (approved) {
                    pstmt.setString(1, "1");
                    pstmt.setString(2, "seller");
                } else {
                    pstmt.setString(1, "0");
                }
                ResultSet results = pstmt.executeQuery();

                while(results.next()) {
                    User user = new User();
                    user.user_id = results.getInt("user_id");
                    user.firstname = results.getString("firstname");
                    user.lastname = results.getString("lastname");
                    user.email = results.getString("email");
                    user.account_type = results.getString("account_type");
                    user.approval = results.getBoolean("approval");
                    sellerList.add(user);
                }

                return sellerList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return sellerList;
        }
    }

    /**
     * edit an existing user's information
     * @param user_id user's id as it is in the database
     * @param firstname first name of user
     * @param lastname last name of user
     * @param email email of user
     * @param password password of user
     * @param account_type account_type of user (seller, buyer, admin)
     * @param approval approval of user (this is for when a seller is approved or not)
     * @return a user object with current users updated information
     */
    public User edit_user(Integer user_id, String firstname, String lastname, String email, String password, String account_type, Boolean approval){
        
        User user = new User();

        String query1 =  "SELECT user_id FROM users WHERE user_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, user_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return user;
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

        String queryFinal =  "SELECT * FROM users WHERE user_id = ?";
        try (Connection connQueryFinal = this.connect(); PreparedStatement pstmt1 = connQueryFinal.prepareStatement(queryFinal)) {
            pstmt1.setInt(1, user_id);
            ResultSet resultsFinal = pstmt1.executeQuery();

            
            user.user_id = resultsFinal.getInt("user_id");
            user.firstname = resultsFinal.getString("firstname");
            user.lastname = resultsFinal.getString("lastname");
            user.email = resultsFinal.getString("email");
            user.account_type = resultsFinal.getString("account_type");
            user.approval = resultsFinal.getBoolean("approval");

            return user;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return user;
        }
    }

    /**
     * remove a product from the database
     * @param product_id id of the product as it is in the database 
     * @return a "success" response message
     */
    public String delete_user(Integer user_id){

        String query1 =  "SELECT user_id FROM users WHERE user_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, user_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("User does not exist");
                return "User does not exist";
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
                return "User has been deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "No db connection";
        }
    }
    
    /**
     * get a user from the database
     * @param user_id user's id as it is in the database
     * @return a user object with information
     */
    public User grab_user_info(Integer user_id){
        String sql =  "SELECT * FROM users WHERE user_id = ?";
        User user = new User();

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, user_id);

                ResultSet results = pstmt.executeQuery();

                user.user_id = results.getInt("user_id");
                user.firstname = results.getString("firstname");
                user.lastname = results.getString("lastname");
                user.email = results.getString("email");
                user.account_type = results.getString("account_type");
                user.approval = results.getBoolean("approval");

                System.out.println(results.getInt("user_id") + " " + results.getString("firstname") + " " + results.getString("lastname") + " " + results.getString("email") + " " + results.getString("account_type") + " " + results.getString("approval"));
                return user;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return user;
        }
    }

    /**
     * add a new product to the database
     * @param name name of product
     * @param description description of product
     * @param price price of product
     * @param amount_sold amount_sold of product
     * @param user_id user id of seller as it is in database
     * @return a product object with information
     */
    public Product add_product(String name, String description, Integer price, Integer amount_sold, Integer user_id){
        String sql = "INSERT INTO products(name, description, price, amount_sold, seller_id) VALUES(?,?,?,?,?)";
        Product product = new Product();

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, price);
            pstmt.setInt(4, amount_sold);
            pstmt.setInt(5, user_id);
            pstmt.executeUpdate();

            String sql2 = "SELECT MAX(product_id) AS product_id FROM products";
            try (Connection conn2 = this.connect(); PreparedStatement pstmt2 = conn2.prepareStatement(sql2)) {
                ResultSet results = pstmt2.executeQuery();


                product.product_id = results.getInt("product_id");

                String sql3 = "SELECT * FROM products WHERE product_id = ?";
                try (Connection conn3 = this.connect(); PreparedStatement pstmt3 = conn3.prepareStatement(sql3)) {
                    pstmt3.setInt(1, product.product_id);
                    ResultSet results3 = pstmt3.executeQuery();

                    product.name = results3.getString("name");
                    product.description = results3.getString("description");
                    product.price = results3.getInt("price");
                    product.amount_sold = results3.getInt("amount_sold");
                    product.seller_id = results3.getInt("seller_id");
                    return product;
                }

            }   catch (SQLException e) {
                System.out.println(e.getMessage());
                return product;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return product;
        }
    }
    
    /**
     * add a review to the database
     * @param user_id user_id of author as it is in the database
     * @param product_id product_id if the product as it is in the database
     * @param review_name name of review
     * @param review_rating rating of review
     * @param review_content content of review
     * @return a review object with information
     */
    public Review add_review(Integer user_id, Integer product_id, String review_name, String review_rating, String review_content){
        String sql = "INSERT INTO reviews(product_id, review_rating, review_content, review_author_name, review_author_id) VALUES(?,?,?,?,?)";
        Review review = new Review();

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, product_id);
            pstmt.setString(2, review_rating);
            pstmt.setString(3, review_content);
            pstmt.setString(4, review_name);
            pstmt.setInt(5, user_id);
            pstmt.executeUpdate();

            String sql2 = "SELECT MAX(review_id) AS review_id FROM reviews";
            try (Connection conn2 = this.connect(); PreparedStatement pstmt2 = conn2.prepareStatement(sql2)) {
                ResultSet results = pstmt2.executeQuery();

                review.review_id = results.getInt("review_id");

                String sql3 = "SELECT * FROM reviews WHERE review_id = ?";
                try (Connection conn3 = this.connect(); PreparedStatement pstmt3 = conn3.prepareStatement(sql3)) {
                    pstmt3.setInt(1, review.review_id);
                    ResultSet results3 = pstmt3.executeQuery();

                    review.product_id = results3.getInt("product_id");
                    review.review_rating = results3.getString("review_rating");
                    review.review_content = results3.getString("review_content");
                    review.reviewer_name = results3.getString("review_author_name");
                    review.user_id = results3.getInt("review_author_id");
                    return review;
                }

            }   catch (SQLException e) {
                System.out.println(e.getMessage());
                return review;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return review;
        }
    }
    
    /**
     * Grabs a list of the reviews from a product id
     * @param product_id the id of the product
     * @return a list of review objects
     */
    public List<Review> grab_reviews(Integer product_id){
        String sql =  "SELECT * FROM reviews WHERE product_id = ?";
        
        List<Review> reviewList = new ArrayList<Review>();

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, product_id);

                ResultSet results = pstmt.executeQuery();

                while(results.next()) {
                Review review = new Review();
                review.user_id = results.getInt("review_author_id");
                review.product_id = results.getInt("product_id");
                review.review_content = results.getString("review_content");
                review.review_rating = results.getString("review_rating");
                review.reviewer_name = results.getString("review_author_name");
                review.review_id = results.getInt("review_id");
                reviewList.add(review);
                }
                return reviewList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return reviewList;
        }
    }
    
    /**
     * add a order to the database
     * @param buyer_id user_id of buyer as it is in the database
     * @param total_cost total_cost of order
     * @param product_ids product_ids of products in order
     * @return an order object with information
     */
    public Order add_order(Integer buyer_id, String total_cost, String product_ids){
        String sql = "INSERT INTO orders(buyer_id, total_cost, product_ids) VALUES(?,?, ?)";
        Order order = new Order();

        try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, buyer_id);
            pstmt.setString(2, total_cost);
            pstmt.setString(3, product_ids);
            pstmt.executeUpdate();

            String sql2 = "SELECT MAX(order_id) AS order_id FROM orders";
            try (Connection conn2 = this.connect(); PreparedStatement pstmt2 = conn2.prepareStatement(sql2)) {
                ResultSet results = pstmt2.executeQuery();


                order.order_id = results.getInt("order_id");

                String sql3 = "SELECT * FROM orders WHERE order_id = ?";
                try (Connection conn3 = this.connect(); PreparedStatement pstmt3 = conn3.prepareStatement(sql3)) {
                    pstmt3.setInt(1, order.order_id);
                    ResultSet results3 = pstmt3.executeQuery();

                    order.buyer_id = results3.getInt("buyer_id");
                    order.total_cost = results3.getString("total_cost");
                    order.product_ids = results3.getString("product_ids");
                    return order;
                }

            }   catch (SQLException e) {
                System.out.println(e.getMessage());
                return order;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return order;
        }
    }
    
    /**
     * edit an existing product's information
     * @param product_id product_id of the product as it is in the database 
     * @param name name of product
     * @param description description of product
     * @param price price of product
     * @param amount_sold amount_sold of product
     * @return a "success" response message
     */
    public String edit_product(Integer product_id, String name, String description, Integer price, Integer amount_sold){
        String query1 =  "SELECT product_id FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("Product does not exist");
                return "Product does not exist";
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

        return "Item has been updated";
    }

    /**
     * add the amount of sells a product has
     * @param product_id product_id of the product as it is in the database 
     * @param amount quantity of product sold
     * @return a "success" response message
     */
    public String add_product_sale(Integer product_id, Integer amount){

        Integer ogAmount = 0;
        String query1 =  "SELECT amount_sold FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("Product does not exist");
                return "Product does not exist";
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
                return "Count updated!";
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return "Count updated!";
            }
    }

    /**
     * remove a product from the database
     * @param product_id product_id of the product as it is in the database 
     * @return a "success" response message
     */
    public String delete_product(Integer product_id){
        String query1 =  "SELECT product_id FROM products WHERE product_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, product_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("Product does not exist");
                return "Product does not exist";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql =  "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, product_id);
                pstmt.executeUpdate();
                System.out.println("Product has been deleted");
                return "Product has been deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "No db connection";
        }
    }
    
    /**
     * get all orders in the database
     * @return list of order objects
     */
    public List<Order> get_all_orders(){
        List<Order> order_list = new ArrayList<Order>();
        String sql =  "SELECT * FROM orders";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet results = pstmt.executeQuery();

                while(results.next()){
                    Order order = new Order();
                    order.order_id = results.getInt("order_id");
                    order.buyer_id = results.getInt("buyer_id");
                    order.total_cost = results.getString("total_cost");
                    order.product_ids = results.getString("product_ids");               
                    order_list.add(order);
                }

                return order_list;
                
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return order_list;
        }
    }
    
    /**
     * remove a order from the database
     * @param order_id product_id of the product as it is in the database 
     * @return a "success" response message
     */
    public String delete_order(Integer order_id){
        String query1 =  "SELECT order_id FROM orders WHERE order_id = ?";
        try (Connection connQuery1 = this.connect(); PreparedStatement pstmt1 = connQuery1.prepareStatement(query1)) {
            pstmt1.setInt(1, order_id);
            ResultSet results1 = pstmt1.executeQuery();
            if (results1.next() == false) {
                System.out.println("Order does not exist");
                return "Order does not exist";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        String sql =  "DELETE FROM orders WHERE order_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, order_id);
                pstmt.executeUpdate();
                System.out.println("Order has been deleted");
                return "Order has been deleted";
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "No db connection";
        }
    }

    /**
     * get all products in the database
     * @return list of product objects
     */
    public List<Product> get_list_of_products(){
        List<Product> product_list = new ArrayList<Product>();
        String sql =  "SELECT * FROM products";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                ResultSet results = pstmt.executeQuery();

                while(results.next()){
                    Product product = new Product();
                    product.product_id = results.getInt("product_id");
                    product.name = results.getString("name");
                    product.description = results.getString("description");
                    product.price = results.getInt("price");
                    product.amount_sold = results.getInt("amount_sold");
                    product.seller_id = results.getInt("seller_id");
                    product_list.add(product);
                }

                return product_list;

        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return product_list;
        }
    }
    
    /**
     * get current user's products in the database
     * @return list of product objects
     */
    public List<Product> get_list_of_own_products(Integer user_id){
        List<Product> product_list = new ArrayList<Product>();
        String sql =  "SELECT * FROM products WHERE seller_id = ?";
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, user_id);
                ResultSet results = pstmt.executeQuery();

                while(results.next()){
                    Product product = new Product();
                    product.product_id = results.getInt("product_id");
                    product.name = results.getString("name");
                    product.description = results.getString("description");
                    product.price = results.getInt("price");
                    product.amount_sold = results.getInt("amount_sold");
                    product.seller_id = results.getInt("seller_id");
                    product_list.add(product);
                }

                return product_list;


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return product_list;
        }
    }
    
    /**
     * Main function
     * @param args arguments
     * @throws Exception exception
     */
    public static void main(String[] args) throws Exception {
        ShopletSystemManager db = new ShopletSystemManager();
        // add user
        // refer to method to see arguments. All must be filled out or else error will raise.
        //db.add_user("jon", "mercer", "test@email.com", "password", "buyer", true);

        // authenticate_user
        // must use given email and password as arguments
        
        //User user = db.authenticate_user("test@email.com", "passwordd");
        // System.out.println(user.user_id);
        // System.out.println(user.firstname);
        // System.out.println(user.lastname);
        // System.out.println(user.email);
        // System.out.println(user.account_type);
        // System.out.println(user.approval);



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
        // db.add_product("product", "This is the description", 0, 0, 2);
        // db.add_product("product1", "This is the description1", 1, 1, 1);
        // db.add_product("product2", "This is the description2", 2, 2, 1);
        // db.add_product("product3", "This is the description3", 3, 3, 1);
        // db.add_product("product4", "This is the description4", 4, 4, 1);

        // edit_product
        // refer to method to see arguments. All must be filled out but if there is an attribute you dont want to change you can set the arugment to null.
        //db.edit_product(1, "product-edit", null , 999, 99);

        // add_product_sale
        // give a product id, and amount sold and the amount_sold will increment by the argument
        //db.add_product_sale(1, 7);

        // delete_product
        // give a product id and the product will be deleted from the database
        //db.delete_product(1);

        //get_list_of_products
        /**
        List<Product> list = db.get_list_of_products();
        System.out.println(Arrays.toString(list.toArray()));
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s %s %s %d %d %d \n", list.get(i).product_id, list.get(i).name, list.get(i).description, list.get(i).price, list.get(i).amount_sold, list.get(i).seller_id);
        }
		**/
    }
}
