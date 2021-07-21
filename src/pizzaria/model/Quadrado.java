package pizzaria.model;

import pizzaria.utils.FormaPizzaEnum;

public class Quadrado extends Forma {
    
    @Override
    public double calcularArea(double lado) {
        return lado * lado;
    }

    @Override
    public double calcularLadoOuRaio(double area) {
        return Math.sqrt(area);
    }
    
    @Override
    public int getForma() {
        return FormaPizzaEnum.QUADRADO;
    }
    
    @Override
    public String getNomeForma() {
        return "Quadrado";
    }
}
