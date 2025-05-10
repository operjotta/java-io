import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Demonstra diferentes métodos de leitura de arquivos texto
 * Esta classe implementa várias abordagens de leitura de arquivo:
 */
@SuppressWarnings({"unused", "Convert2MethodRef", "ResultOfMethodCallIgnored"})
public class LeituraLinhaPorLinha {

    /**
     * Realiza a leitura de um arquivo texto utilizando um BufferedReader.
     * Eficiente para arquivos grandes, pois utiliza buffer interno para
     * otimizar a leitura linha por linha do arquivo.
     *
     * @param fr FileReader inicializado com o arquivo a ser lido
     */
    private static void leituraEmBuffer(FileReader fr) {
        try (BufferedReader reader = new BufferedReader(fr)) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException ex) {
            System.err.println("Err de leitura em buffer: " + ex.getMessage());
        }
    }


    /**
     * Realiza a leitura de um arquivo texto utilizando a API de Streams do Java.
     * Oferece melhor desempenho para processamento paralelo e é mais adequado para
     * operações funcionais sobre o conteúdo do arquivo.
     *
     * @param fr FileReader inicializado com o arquivo a ser lido
     */
    private static void leituraEmFluxo(FileReader fr) {
        try (BufferedReader reader = new BufferedReader(fr)) {
            reader.lines().forEach(linha -> System.out.println(linha));
            // ou ainda reader.lines().forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("Err de leitura em fluxo contínuo: " + ex.getMessage());
        }
    }

    /**
     * Realiza a leitura de um arquivo texto caractere por caractere.
     *
     * @param fr FileReader inicializado com o arquivo a ser lido
     * @apiNote Esta abordagem é significativamente mais lenta que outras e deve ser
     * utilizada apenas quando é necessário um controle caractere a cacractere.
     */
    private static void leituraPorByte(FileReader fr) {
        try (BufferedReader reader = new BufferedReader(fr)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.err.println("Erro de leitura em bytes: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("historia_java.txt");
            // chame os métodos aqui
            fileReader.close();
        } catch (IOException ex) {
            System.err.println("Erro de leitura: " + ex.getMessage());
        }
    }

    /**
     * Realiza a leitura direta do arquivo usando FileReader com um buffer personalizado.
     * Oferece um equilíbrio entre desempenho e uso de memória, lendo o arquivo em blocos
     * de 1024 caracteres.
     *
     * @param fr FileReader inicializado com o arquivo a ser lido
     */
    private static void leituraPorByteDireta(FileReader fr) {
        try {
            int bytesLidos;
            char[] buffer = new char[1024];
            while ((bytesLidos = fr.read(buffer, 0, 1024)) != -1) {
                System.out.print(new String(buffer, 0, bytesLidos));
            }
        } catch (Exception ex) {
            System.err.println("Erro de leitura direta no FileReader: " + ex.getMessage());
        }
    }

    /**
     * Realiza a leitura do arquivo ignorando os primeiros 27 caracteres.
     * Utiliza o skip() do FileReader para avançar no arquivo e continua a
     * leitura a partir deste ponto usando um buffer.
     *
     * @param fr FileReader inicializado com o arquivo a ser lido
     */
    private static void ignoraOsPrimeiros27Caracteres(FileReader fr) {
        try {
            int bytesLidos;
            char[] buffer = new char[1024];
            fr.skip(27);
            while ((bytesLidos = fr.read(buffer, 0, 1024)) != -1) {
                System.out.print(new String(buffer, 0, bytesLidos));
            }
        } catch (IOException ex) {
            System.err.println("Erro de leitura: " + ex.getMessage());
        }
    }

}
