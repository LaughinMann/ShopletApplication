# ShopletApplication

The Shoplet Application, an application for the semester project for COP4331 at Florida Atlantic University. 
Features a buyer panel that contains checking out, viewing a product's information,
posting a review for the product, and checking out with personal and billing information and then placing a purchase order. Also features
a Seller's panel that once approved features adding products, editing products, deleting products, and viewing one's profit from all their sold products.
Lastly, features an admin panel for a admin to approve or deny seller accounts, along with canceling orders and modifying other products for specific sellers.

# Adding the MigLayout external .JAR & SQL lite .JAR file

The Shoplet Application utilizes a external Java layout called MigLayout, in order to compile and run the project one must ensure that the MigLayout is added
an external .JAR file for the project. This project was done in Eclipse, so the following is how to add it in Eclipse:

1. First navigate to the build path, and then configure build path:
![First picture](https://i.imgur.com/y0hajho.png)

2. Select "classpath" section header and then Add External .JARs button.
![Second picture](https://i.imgur.com/AHhl2TS.png)

3. Add "miglayout15-swing.JAR" file in the project folder and then close and open Eclipse and then Project > Clean to ensure everything works.

4. Do the same with the SQL lite jar file as shown in the pictures above.

# Running the Shoplet Application

After ensuring no errors exist, one can launch the Shoplet Application through the Login.java file if within the project folder.
