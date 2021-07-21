package pizzaria.model;

public class Pizza {
    
    private Pedido pedido;
    private Forma forma;
    private boolean isMetricaCmQuadrado;
    private double area;
    private double ladoOuRaio;
    private SaborPizza sabor1;
    private SaborPizza sabor2;
    private double precoTotal;

    public Pizza(Pedido pedido, Forma forma, boolean isMetricaCmQuadrado, double area, double ladoOuRaio, SaborPizza sabor1, SaborPizza sabor2, double precoTotal) {
        this.pedido = pedido;
        this.forma = forma;
        this.isMetricaCmQuadrado = isMetricaCmQuadrado;
        this.area = area;
        this.ladoOuRaio = ladoOuRaio;
        this.sabor1 = sabor1;
        this.sabor2 = sabor2;
        this.precoTotal = precoTotal;
    }

    public Pizza() {
    }
    
    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }
        
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public SaborPizza getSabor1() {
        return sabor1;
    }

    public void setSabor1(SaborPizza sabor1) {
        this.sabor1 = sabor1;
    }

    public SaborPizza getSabor2() {
        return sabor2;
    }

    public void setSabor2(SaborPizza sabor2) {
        this.sabor2 = sabor2;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
