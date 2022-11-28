/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages_Jeff_Seller;

/**
 *
 * @author jeffplatel
 */

import javax.swing.*;

public class Logout {
    Logout(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "You've successfully logged out!");
    }
    public static void main(String[] args) {
        new Logout();   
    }
}
