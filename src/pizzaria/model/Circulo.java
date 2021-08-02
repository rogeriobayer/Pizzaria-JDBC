package pizzaria.model;

import pizzaria.utils.FormaPizzaEnum;

public class Circulo extends Forma {

    @Override
    public double calcularArea(double raio) {
        return raio * raio * Math.PI;
    }

    @Override
    public double calcularLadoOuRaio(double area) {
        return Math.sqrt(area / Math.PI);
    }

    @Override
    public int getForma() {
        return FormaPizzaEnum.CIRCULO;
    }

    @Override
    public String getNomeForma() {
        return "Círculo";
    }

    @Override
    public Integer getNumberForma() {
        return 1;
    }
}
