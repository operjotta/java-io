import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Demonstra a leitura e formatação de dados de um arquivo texto usando Scanner.
 * Esta classe lê dados estruturados de um arquivo texto contendo informações sobre produtos
 * e formata a saída usando NumberFormat para valores monetários.
 */
public class LerFormatarComScanner {
    public static void main(String[] args) {
        File file = new File("scanner.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String produto = scanner.next();
                int qtd = scanner.nextInt();
                double preco = scanner.nextDouble();
                boolean adquirido = scanner.nextBoolean();

                double subtotal = qtd * preco;

                String subtotalFormatado = NumberFormat.getCurrencyInstance().format(subtotal);
                String precoFormatado = NumberFormat.getCurrencyInstance().format(preco);

                System.out.println("Produto: " + produto);
                System.out.println("Quantidade: " + qtd);
                System.out.println("Preço: " + precoFormatado);
                System.out.println("Adquirido: " + adquirido);
                System.out.println("Subtotal: " + subtotalFormatado);
                System.out.println();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Ficheiro não encontrado!");
        }
    }
}
