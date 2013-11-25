/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestname;

import java.util.Scanner;

/**
 *
 * @author Georgi
 */
public class ShortestName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = 0;

        while (n < 2 || n > 10) {
            System.out.println("Enter number of employees between 2 and 10:");
            n = scan.nextInt();
        }
        
        String[] employees = new String[n];
        
        System.out.println("Enter " + n + " employee names, each on a new line");
        
        
        // Присвояваме на shortestNameLength най-голямото число, 
        // което се събира в int променлива: 2147483647
        // по този начин се подсигуряваме почти на 100%, че ще има име,
        // чиято дължина е по-малка от първоначалната
        // стойност на shortestNameLength, за да можем по-късно 
        // (в цикъла) да присвояваме все по-малка и по-малка стойност.
        int shortestNameLength = Integer.MAX_VALUE;
        String shortestName = new String();
        
        for (int i = 0; i < employees.length; i++) {
            employees[i] = scan.next();
            
            if (employees[i].length() < shortestNameLength) {
                shortestNameLength = employees[i].length();
                shortestName = employees[i];
            }
        }
        
        System.out.println("The employee with the shortest name is: " + shortestName);

    }

}
