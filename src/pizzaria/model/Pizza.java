package pizzaria.model;

import java.util.UUID;

public class Pizza {

    private String id;
    private String id_pedido;
    private Forma forma;
    private boolean isMetricaCmQuadrado;
    private double area;
    private double ladoOuRaio;
    private String id_sabor1;
    private String id_sabor2;
    private double precoTotal;

    public Pizza(String pedido, Forma forma, boolean isMetricaCmQuadrado,
            double area, String sabor1, String sabor2,
            double precoTotal) {
        this.id = UUID.randomUUID().toString();
        this.id_pedido = pedido;
        this.forma = forma;
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
        this.area = area;
        this.ladoOuRaio = ladoOuRaio;
        this.id_sabor1 = sabor1;
        this.id_sabor2 = sabor2;
        this.precoTotal = precoTotal;
    }

    public Pizza(String id, String pedido, Forma forma, boolean isMetricaCmQuadrado,
            double area, double ladoOuRaio, String sabor1, String sabor2,
            double precoTotal) {
        this.id = id;
        this.id_pedido = pedido;
        this.forma = forma;
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
        this.area = area;
        this.ladoOuRaio = ladoOuRaio;
        this.id_sabor1 = sabor1;
        this.id_sabor2 = sabor2;
        this.precoTotal = precoTotal;
    }

    public Pizza(String id, String id_pedido, Integer id_forma, boolean isMetricaCmQuadrado,
            double area, double ladoOuRaio, String sabor1, String sabor2,
            double precoTotal) {
        this.id = id;
        this.id_pedido = id_pedido;
        setFormaFromNumber(id_forma);
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
        this.area = area;
        this.ladoOuRaio = ladoOuRaio;
        this.id_sabor1 = sabor1;
        this.id_sabor2 = sabor2;
        this.precoTotal = precoTotal;
    }

    public Pizza(String id_pedido, Integer id_forma, boolean isMetricaCmQuadrado,
            double ladoOuRaio, String sabor1, String sabor2) {
        this.id = UUID.randomUUID().toString();
        this.id_pedido = id_pedido;
        setFormaFromNumber(id_forma);
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
        this.area = 0;
        this.ladoOuRaio = ladoOuRaio;
        this.id_sabor1 = sabor1;
        this.id_sabor2 = sabor2;
        this.precoTotal = 0;
    }

    public Pizza() {
    }

    public Forma getForma() {
        return forma;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumberForma() {
        return forma.getNumberForma();
    }

    public String getFormaString() {
        return forma.getNomeForma();
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public void setFormaFromNumber(Integer forma) {
        if (forma == 0) {
            this.forma = new Circulo();
        } else if (forma == 1) {
            this.forma = new Quadrado();
        } else if (forma == 2) {
            this.forma = new Triangulo();
        }
    }

    public String getPedido() {
        return id_pedido;
    }

    public void setPedido(String pedido) {
        this.id_pedido = pedido;
    }

    public boolean isIsMetricaCmQuadrado() {
        return isMetricaCmQuadrado;
    }

    public void setIsMetricaCmQuadrado(boolean isMetricaCmQuadrado) {
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getLadoOuRaio() {
        return ladoOuRaio;
    }

    public void setLadoOuRaio(double ladoOuRaio) {
        this.ladoOuRaio = ladoOuRaio;
    }

    public String getSabor1() {
        return id_sabor1;
    }

    public void setSabor1(String sabor1) {
        this.id_sabor1 = sabor1;
    }

    public String getSabor2() {
        return id_sabor2;
    }

    public void setSabor2(String sabor2) {
        this.id_sabor2 = sabor2;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
