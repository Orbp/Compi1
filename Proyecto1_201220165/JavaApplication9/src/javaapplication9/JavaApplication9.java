/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author oscar
 */
public class JavaApplication9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String entrada = "";
        System.out.println("Ingrese la entrada: ");
        Scanner sc = new Scanner(System.in);
        entrada = sc.nextLine();
        lexico scanner = new lexico(new BufferedReader(new StringReader(entrada)));
        sintactico parser = new sintactico(scanner);
        try {
            parser.parse();
        } catch (Exception ex) {
            Logger.getLogger(JavaApplication9.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
