/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pages_Jeff_Admin;

/**
 *
 * @author jeffplatel
 */

 import javax.swing.*;
 import javax.swing.JOptionPane;

public class Refund {
    Refund(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Order cancelled. Refund wil be given.");
    }
    public static void main(String[] args) {
        new Refund();   
    }
}

