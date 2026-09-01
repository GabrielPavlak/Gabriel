package Colaborador;

public class Colaborador {

    private String nome;
    private double salario;
    private int dependentes;
    private double horasExtras;
    private double percentualAdicionalHoraExtra;

    private static final double JORNADA_MENSAL = 220.0;
    private static final double DEDUCAO_POR_DEPENDENTE = 189.59;

    public Colaborador(String nome, double salario, int dependentes) {
        this(nome, salario, dependentes, 0.0, 0.5);
    }

    public Colaborador(String nome, double salario, int dependentes, double horasExtras) {
        this(nome, salario, dependentes, horasExtras, 0.5);
    }

    public Colaborador(String nome, double salario, int dependentes,
                       double horasExtras, double percentualAdicionalHoraExtra) {
        this.nome = nome;
        this.salario = salario;
        this.dependentes = dependentes;
        this.horasExtras = horasExtras;
        this.percentualAdicionalHoraExtra = percentualAdicionalHoraExtra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getPercentualAdicionalHoraExtra() {
        return percentualAdicionalHoraExtra;
    }

    public void setPercentualAdicionalHoraExtra(double percentualAdicionalHoraExtra) {
        this.percentualAdicionalHoraExtra = percentualAdicionalHoraExtra;
    }

    public double getValorHoraNormal() {
        return salario / JORNADA_MENSAL;
    }

    public double getValorHoraExtra() {
        return getValorHoraNormal() * (1.0 + percentualAdicionalHoraExtra);
    }

    public double getTotalHorasExtras() {
        return horasExtras * getValorHoraExtra();
    }

    public double getSalarioBruto() {
        return salario + getTotalHorasExtras();
    }

    private double getPrevidencia() {
        double base = Math.min(getSalarioBruto(), 8475.55);
        double inss = 0.0;

        if (base > 4354.27) {
            inss += (base - 4354.27) * 0.14;
            base = 4354.27;
        }

        if (base > 2902.84) {
            inss += (base - 2902.84) * 0.12;
            base = 2902.84;
        }

        if (base > 1621.00) {
            inss += (base - 1621.00) * 0.09;
            base = 1621.00;
        }

        if (base > 0.0) {
            inss += base * 0.075;
        }

        return inss;
    }

    private double getBaseCalculoIRRF() {
        double deducaoDependentes = dependentes * DEDUCAO_POR_DEPENDENTE;
        double base = getSalarioBruto() - getPrevidencia() - deducaoDependentes;
        return Math.max(base, 0.0);
    }

    private double getImpostoRenda() {
        double baseCalculo = getBaseCalculoIRRF();
        double impostoTabela;

        if (baseCalculo <= 2428.80) {
            impostoTabela = 0.0;
        } else if (baseCalculo <= 2826.65) {
            impostoTabela = (baseCalculo * 0.075) - 182.16;
        } else if (baseCalculo <= 3751.05) {
            impostoTabela = (baseCalculo * 0.15) - 394.16;
        } else if (baseCalculo <= 4664.68) {
            impostoTabela = (baseCalculo * 0.225) - 675.49;
        } else {
            impostoTabela = (baseCalculo * 0.275) - 908.73;
        }

        impostoTabela = Math.max(impostoTabela, 0.0);

        double rendimentoTributavel = getSalarioBruto();
        double reducao = 0.0;

        if (rendimentoTributavel <= 5000.00) {
            reducao = Math.min(impostoTabela, 312.89);
        } else if (rendimentoTributavel <= 7350.00) {
            reducao = 978.62 - (0.133145 * rendimentoTributavel);
            reducao = Math.max(reducao, 0.0);
            reducao = Math.min(reducao, impostoTabela);
        }

        return Math.max(impostoTabela - reducao, 0.0);
    }

    public double getSalarioLiquido() {
        return getSalarioBruto() - getPrevidencia() - getImpostoRenda();
    }

    public void imprimeFolha() {
        System.out.println("----- Folha de Pagamento (CLT) -----");
        System.out.println("Colaborador: " + nome);
        System.out.println("Dependentes: " + dependentes);
        System.out.printf("Salario Base: R$ %.2f%n", salario);
        System.out.printf("Valor Hora Normal: R$ %.2f%n", getValorHoraNormal());
        System.out.printf("Horas Extras: %.1f h (adicional de %.0f%%)%n",
                horasExtras, percentualAdicionalHoraExtra * 100);
        System.out.printf("Valor Hora Extra: R$ %.2f%n", getValorHoraExtra());
        System.out.printf("Total Horas Extras: R$ %.2f%n", getTotalHorasExtras());
        System.out.printf("Salario Bruto: R$ %.2f%n", getSalarioBruto());
        System.out.printf("INSS: R$ %.2f%n", getPrevidencia());
        System.out.printf("Base de Calculo IRRF: R$ %.2f%n", getBaseCalculoIRRF());
        System.out.printf("IRRF: R$ %.2f%n", getImpostoRenda());
        System.out.printf("Salario Liquido: R$ %.2f%n", getSalarioLiquido());
        System.out.println("-------------------------------------");
    }
}