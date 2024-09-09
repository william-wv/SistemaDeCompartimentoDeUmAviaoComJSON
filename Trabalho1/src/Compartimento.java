import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Compartimento {
    private BigDecimal capacidade;
    private String nome;
    private List<Caixa> cargas = new ArrayList<>(); // Lista de caixas no compartimento

    public void receber(Caixa caixa) {
        this.capacidade = this.capacidade.subtract(caixa.getPeso());
        cargas.add(caixa); // Adicionar caixa à lista de cargas
    }

    public BigDecimal getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(BigDecimal capacidade) {
        this.capacidade = capacidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Caixa> getCargas() {
        return cargas;
    }
}