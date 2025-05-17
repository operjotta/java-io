import java.io.File;
import java.util.Scanner;

public class VerificarExistencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;

        System.out.print("Digite o nome do ficheiro ou diretório: ");
        nome = scanner.next();

        File file = new File(nome);
        boolean ficheiroExiste = file.exists();

        if (ficheiroExiste) {
            System.out.println("O ficheiro existe no diretório actual");
        } else {
            System.out.println("O ficheiro não existe no diretório actual");
        }
    }
}
