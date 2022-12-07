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
import javax.swing.JOptionPane;

/**
 * Error message prompt class
 * @author Kelvin Dhoman
 *
 */
public class ErrorMessage {
    ErrorMessage(){
        JFrame frame = new JFrame();
        String message = "Item already exists. Try again.";
        JOptionPane.showMessageDialog(frame, message);
        
    }
    public static void main(String[] args) {
        new ErrorMessage();   
    }
}
