package cafeteria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class maquinaDeCafe {
    public static void main(String[] args) {
        var cafeteira = new estoqueIngredientes();
        Scanner s = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Preparar café");
            System.out.println("2 - Repor água");
            System.out.println("3 - Repor café");
            System.out.println("4 - Repor açúcar");
            System.out.println("5 - Repor copo");
            System.out.println("6 - Ver estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = s.nextInt();

                switch (opcao) {
                    case 1:
                        cafeteira.prepararCafe();
                        break;
                    case 2:
                        System.out.print("Quantidade de água (ml): ");
                        cafeteira.reporAgua(s.nextDouble());
                        break;
                    case 3:
                        System.out.print("Quantidade de café (g): ");
                        cafeteira.reporCafe(s.nextDouble());
                        break;
                    case 4:
                        System.out.print("Quantidade de açúcar (g): ");
                        cafeteira.reporAcucar(s.nextDouble());
                        break;
                    case 5:
                        System.out.print("Quantidade de copos: ");
                        cafeteira.reporCopos(s.nextInt());
                        break;
                    case 6:
                        System.out.println("Água: " + cafeteira.getAgua() + " ml");
                        System.out.println("Café: " + cafeteira.getCafe() + " g");
                        System.out.println("Açúcar: " + cafeteira.getAcucar() + " g");
                        System.out.println("Copos: " + cafeteira.getCopos() + " unidades");
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, digite um número.");
                s.next();
                opcao = -1;
            }

        } while (opcao != 0);

        s.close();
    }
}