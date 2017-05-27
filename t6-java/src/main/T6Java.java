package main;

import java.util.Scanner;

/**
 * Main class of this project.
 *
 * @author João Bolsson (joaovictorbolsson@gmail.com)
 * @since 2017, 27 May.
 */
public class T6Java {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Quantos cookies no pacote?");
        int n = entrada.nextInt();

        Pack pack = new Pack(n);
        pack.showCookies();

    }

}
