package banco;

import java.util.Scanner;

public class caixaEletronico {
    public static void main(String[] args) {
        var sicredi = new ContaCorrente();

        Scanner s= new Scanner(System.in);
        System.out.println("Depositar valor: ");
        sicredi.depositar(s.nextDouble());
        System.out.println("Sacar valor: ");
        sicredi.sacar(s.nextDouble());

        System.out.println(sicredi.getSaldo());
    }
}
