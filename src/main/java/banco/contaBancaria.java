package banco;

public class contaBancaria {
    public String correntista;
    public double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("saldo insuficiente");
        } else {
            saldo = saldo - valor;
        }
    }

}


