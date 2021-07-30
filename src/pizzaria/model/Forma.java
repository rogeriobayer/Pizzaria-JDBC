package pizzaria.model;

public abstract class Forma {

    public abstract double calcularArea(double ladoOuRaio);

    public abstract double calcularLadoOuRaio(double area);

    public abstract int getForma();

    public abstract String getNomeForma();

    public abstract Integer getNumberForma();

}
