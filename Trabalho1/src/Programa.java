import java.math.BigDecimal;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        AviaoCargueiro aviao = new AviaoCargueiro();
        Scanner entrada = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            Caixa caixa = new Caixa();

            System.out.println("Informe o tipo da caixa (Simples ou Precioso):");
            String tipoEntrada = entrada.nextLine();
            try {
                Caixa.TiposCaixa tipoCaixa = Caixa.TiposCaixa.valueOf(tipoEntrada.toUpperCase());
                caixa.setTipo(tipoCaixa);
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de caixa inválido. Tente novamente.");
                continue;
            }

            System.out.println("Informe o peso da caixa:");
            caixa.setPeso(entrada.nextBigDecimal());
            entrada.nextLine();

            aviao.armazenar(caixa);

            System.out.println("Peso total armazenado: " + aviao.getPesoTotal() + " kg");

            System.out.println("Deseja colocar mais uma caixa? (s/n)");
            String resposta = entrada.nextLine();

            if (resposta.equalsIgnoreCase("n")) {
                continuar = false;
            }
        }

        BigDecimal pesoTotal = aviao.getPesoTotal();
        if (pesoTotal.compareTo(new BigDecimal("500")) >= 0) {
            System.out.println("O avião pode decolar. Peso total armazenado: " + pesoTotal + " kg");
        } else {
            System.out.println("O avião não pode decolar. Peso total armazenado: " + pesoTotal + " kg. Necessário um mínimo de 500 kg.");
        }

        // Gerar o manifesto em JSON
        aviao.gerarManifesto("manifesto_carga.json");

        entrada.close();
    }
}
