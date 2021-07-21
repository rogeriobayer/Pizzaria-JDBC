package pizzaria.model;

import pizzaria.utils.FormaPizzaEnum;

public class Triangulo extends Forma {
    
    @Override
    public double calcularArea(double lado) {
        return (lado * lado * Math.sqrt(3))/4;
    }

    @Override
    public double calcularLadoOuRaio(double area) {
        return Math.sqrt(area*4/Math.sqrt(3));
    }
    
    @Override
    public int getForma() {
        return FormaPizzaEnum.TRIANGULO;
    }
    
    @Override
    public String getNomeForma() {
        return "Triângulo";
    }
}
