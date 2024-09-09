import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AviaoCargueiro {

    private Compartimento principal = new Compartimento();
    private Compartimento precioso = new Compartimento();
    private Compartimento auxiliar = new Compartimento();
    private int contadorRastreio = 0;

    public AviaoCargueiro() {
        principal.setNome("Compartimento Principal");
        principal.setCapacidade(new BigDecimal("833"));
        
        precioso.setNome("Compartimento Precioso");
        precioso.setCapacidade(new BigDecimal("21"));
        
        auxiliar.setNome("Compartimento Auxiliar");
        auxiliar.setCapacidade(new BigDecimal("222"));
    }

    public void armazenar(Caixa c) {
        BigDecimal pesoCaixa = c.getPeso();

        if (c.getTipo() == Caixa.TiposCaixa.PRECIOSO) {
            if (precioso.getCapacidade().compareTo(pesoCaixa) >= 0) {
                precioso.receber(c);
            } else {
                System.out.println("Não há espaço suficiente no Compartimento Precioso para esta caixa.");
            }
        } else if (c.getTipo() == Caixa.TiposCaixa.SIMPLES) {
            if (principal.getCapacidade().compareTo(pesoCaixa) >= 0) {
                principal.receber(c);
            } else if (auxiliar.getCapacidade().compareTo(pesoCaixa) >= 0) {
                auxiliar.receber(c);
            } else {
                System.out.println("Não há espaço suficiente no Compartimento Principal e no Auxiliar para esta caixa.");
            }
        } else {
            System.out.println("Tipo de caixa desconhecido.");
        }
    }

    public BigDecimal getPesoTotal() {
        BigDecimal pesoTotal = new BigDecimal("0");
        pesoTotal = pesoTotal.add(calcularPesoTotalCompartimento(principal));
        pesoTotal = pesoTotal.add(calcularPesoTotalCompartimento(precioso));
        pesoTotal = pesoTotal.add(calcularPesoTotalCompartimento(auxiliar));
        return pesoTotal;
    }

    private BigDecimal calcularPesoTotalCompartimento(Compartimento compartimento) {
        BigDecimal pesoTotal = new BigDecimal("0");
        for (Caixa caixa : compartimento.getCargas()) {
            pesoTotal = pesoTotal.add(caixa.getPeso());
        }
        return pesoTotal;
    }

    public String serializar() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    
    public void gerarManifesto(String nomeArquivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            gson.toJson(this, writer);
        } catch (IOException e) {
            System.err.println("Erro ao gerar o manifesto: " + e.getMessage());
        }

    }
    // Getters e Setters
    public Compartimento getPrincipal() {
        return principal;
    }

    public void setPrincipal(Compartimento principal) {
        this.principal = principal;
    }

    public Compartimento getPrecioso() {
        return precioso;
    }

    public void setPrecioso(Compartimento precioso) {
        this.precioso = precioso;
    }

    public Compartimento getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Compartimento auxiliar) {
        this.auxiliar = auxiliar;
    }

    public int getContadorRastreio() {
        return contadorRastreio;
    }

    public void setContadorRastreio(int contadorRastreio) {
        this.contadorRastreio = contadorRastreio;
    }
}
