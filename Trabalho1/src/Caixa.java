import java.math.BigDecimal;

public class Caixa {
    public enum TiposCaixa {
        SIMPLES, PRECIOSO;
    }
    
    private TiposCaixa tipo;
    private BigDecimal peso;
    private int numeroRastreio;

    // Getters e Setters
    public TiposCaixa getTipo() {
        return tipo;
    }

    public void setTipo(TiposCaixa tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public int getNumeroRastreio() {
        return numeroRastreio;
    }

    public void setNumeroRastreio(int numeroRastreio) {
        this.numeroRastreio = numeroRastreio;
    }
}