package Colaborador;

public class Main {

    public static void main(String[] args) {

        Colaborador colaborador1 = new Colaborador("Joao da Silva", 1621.00, 2);

        Colaborador colaborador2 = new Colaborador("Maria Souza", 3200.00, 1, 10);

        Colaborador colaborador3 = new Colaborador("Pedro Alves", 5000.00, 0, 6, 0.5);

        Colaborador colaborador4 = new Colaborador("Ana Ferreira", 9500.00, 3, 4, 1.0);

        colaborador1.imprimeFolha();
        colaborador2.imprimeFolha();
        colaborador3.imprimeFolha();
        colaborador4.imprimeFolha();

        PJ pj1 = new PJ("Carlos Mendes", 80.00, 160, 96000.00);
        PJ pj2 = new PJ("Fernanda Lima", 120.00, 140, 250000.00);

        pj1.imprimeFatura();
        pj2.imprimeFatura();
    }
}