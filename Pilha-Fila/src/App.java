import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String vPilha[] = new String[5];
        String vFila[] = new String[5];

        Random ran = new Random();
        for (int i = 0; i < vPilha.length; i++) {
            vPilha[i] = ran.String(100);
        }

        /* System.out.println("### Lista Desordenada ###");
        for (int val : vPilha) {
            System.out.print(val + "-");
        } */

        int opc = 0;
        while (opc != 5) {
            System.out.println("\n" + "#### PILHA ####");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar");
            System.out.println("3 - Listar Pilha");
            System.out.println("#### FILA ####");
            System.out.println("4 - Incluir Fila");
            System.out.println("5 - Remover Fila");
            System.out.println("6 - Listar Fila");
            System.out.println("##############");
            System.out.println("7 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = ler.nextInt();
            switch (opc) {
                /*
                 * case 1:
                 * //EMPILHAR
                 * Pilha.Empilhar();
                 * break;
                 * case 2:
                 * //DESEMPILHAR
                 * Pilha.Desempilhar();
                 * break;
                 * case 3:
                 * //LISTAR PILHA
                 * Pilha.Listar();
                 * break;
                 * case 4:
                 * //INCLUIR FILA
                 * break;
                 * case 5:
                 * //EXCLUIR FILA
                 * break;
                 * case 6:
                 * //LISTAR FILA
                 * break;
                 * case 7:
                 * System.out.println("Sair");
                 * break;
                 * default:
                 * System.out.println("Opção inválida!");
                 * break;
                 */
            }
        }
    }

    private static void Empilhar(int vPilha[]) {

    }
}
