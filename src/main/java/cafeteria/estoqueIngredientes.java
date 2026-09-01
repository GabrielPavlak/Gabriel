package cafeteria;

public class estoqueIngredientes {
    private double agua;
    private double cafe;
    private double acucar;
    private int copos;

    public estoqueIngredientes() {
        agua = 1000;
        cafe = 200;
        acucar = 100;
        copos = 20;
    }

    public boolean prepararCafe() {
        double aguaPorCafe = 50;
        double cafePorCafe = 10;
        double acucarPorCafe = 5;
        int copoPorCafe = 1;

        if (agua < aguaPorCafe) {
            System.out.println("Água insuficiente para preparar o café.");
            return false;
        }
        if (cafe < cafePorCafe) {
            System.out.println("Café insuficiente para preparar o café.");
            return false;
        }
        if (acucar < acucarPorCafe) {
            System.out.println("Açúcar insuficiente para preparar o café.");
            return false;
        }
        if (copos < copoPorCafe) {
            System.out.println("Não há copos disponíveis.");
            return false;
        }

        agua -= aguaPorCafe;
        cafe -= cafePorCafe;
        acucar -= acucarPorCafe;
        copos -= copoPorCafe;

        System.out.println("Café preparado com sucesso!");
        return true;
    }

    public void reporAgua(double quantidade) {
        agua += quantidade;
        System.out.println("Água reposta. Novo estoque: " + agua + " ml");
    }

    public void reporCafe(double quantidade) {
        cafe += quantidade;
        System.out.println("Café reposto. Novo estoque: " + cafe + " g");
    }

    public void reporAcucar(double quantidade) {
        acucar += quantidade;
        System.out.println("Açúcar reposto. Novo estoque: " + acucar + " g");
    }

    public void reporCopos(int quantidade) {
        copos += quantidade;
        System.out.println("Copos repostos. Novo estoque: " + copos + " unidades");
    }

    public double getAgua() {
        return agua;
    }

    public double getCafe() {
        return cafe;
    }

    public double getAcucar() {
        return acucar;
    }

    public int getCopos() {
        return copos;
    }
}