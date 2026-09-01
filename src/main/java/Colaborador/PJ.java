package Colaborador;

public class PJ {

    private String nome;
    private double valorHora;
    private double horasTrabalhadas;
    private double faturamentoAcumulado12Meses;

    public PJ(String nome, double valorHora, double horasTrabalhadas,
              double faturamentoAcumulado12Meses) {
        this.nome = nome;
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.faturamentoAcumulado12Meses = faturamentoAcumulado12Meses;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getFaturamentoAcumulado12Meses() {
        return faturamentoAcumulado12Meses;
    }

    public void setFaturamentoAcumulado12Meses(double faturamentoAcumulado12Meses) {
        this.faturamentoAcumulado12Meses = faturamentoAcumulado12Meses;
    }

    public double getFaturamentoBruto() {
        return valorHora * horasTrabalhadas;
    }

    private double getAliquotaEfetivaSimplesNacional() {
        double rbt12 = faturamentoAcumulado12Meses;

        if (rbt12 <= 0.0) {
            throw new IllegalArgumentException("O RBT12 deve ser maior que zero.");
        }

        if (rbt12 > 4800000.00) {
            throw new IllegalArgumentException("RBT12 acima do limite geral do Simples Nacional.");
        }

        double aliquotaNominal;
        double parcelaDeduzir;

        if (rbt12 <= 180000.00) {
            aliquotaNominal = 0.06;
            parcelaDeduzir = 0.0;
        } else if (rbt12 <= 360000.00) {
            aliquotaNominal = 0.112;
            parcelaDeduzir = 9360.00;
        } else if (rbt12 <= 720000.00) {
            aliquotaNominal = 0.135;
            parcelaDeduzir = 17640.00;
        } else if (rbt12 <= 1800000.00) {
            aliquotaNominal = 0.16;
            parcelaDeduzir = 35640.00;
        } else if (rbt12 <= 3600000.00) {
            aliquotaNominal = 0.21;
            parcelaDeduzir = 125640.00;
        } else {
            aliquotaNominal = 0.33;
            parcelaDeduzir = 648000.00;
        }

        return ((rbt12 * aliquotaNominal) - parcelaDeduzir) / rbt12;
    }

    public double getValorImposto() {
        return getFaturamentoBruto() * getAliquotaEfetivaSimplesNacional();
    }

    public double getValorLiquido() {
        return getFaturamentoBruto() - getValorImposto();
    }

    public void imprimeFatura() {
        System.out.println("----- Faturamento PJ -----");
        System.out.println("Prestador: " + nome);
        System.out.printf("Horas Trabalhadas: %.1f h%n", horasTrabalhadas);
        System.out.printf("Valor Hora: R$ %.2f%n", valorHora);
        System.out.printf("Faturamento Bruto: R$ %.2f%n", getFaturamentoBruto());
        System.out.printf("RBT12: R$ %.2f%n", faturamentoAcumulado12Meses);
        System.out.printf("Aliquota Efetiva do Simples: %.2f%%%n",
                getAliquotaEfetivaSimplesNacional() * 100);
        System.out.printf("DAS estimado: R$ %.2f%n", getValorImposto());
        System.out.printf("Valor Liquido estimado: R$ %.2f%n", getValorLiquido());
        System.out.println("---------------------------");
    }
}