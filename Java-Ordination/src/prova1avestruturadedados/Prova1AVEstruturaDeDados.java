package prova1avestruturadedados;
import java.util.Random;
import java.util.Scanner;

/**
 * O Projeto foi realizado pela equipe:
 * 1 - 01508417 e Gabriel Cauã Barbosa Dos Santos 01
 * 2 - 01522475 e Victor Giovanni de Oliveira 02
 * 
 * Turma: (2MA, 2MB, 2MC, 2MD, 2NA, 2NB ou 2NC)
 * Disciplina: Estrutura de Dados
 * Professor: José Mário Souza
 * 34,56,115,238,247,270,318,367,399,485,534,541,621,715,795,862,875,889,925,979
 */

public class Prova1AVEstruturaDeDados {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int vet[] = new int[20];
        int vetAux[] = new int[vet.length];

        Random aleatorio = new Random();
        for (int i = 0; i < vet.length; i++) {
            vet[i] = aleatorio.nextInt(1000);
        }

        System.out.println("### Lista Desordenada ###");
        for (int val : vet) {
            System.out.print(val + "-");
        }
        System.out.println("");
        Scanner leia = new Scanner(System.in);
        int opc = 0;
        while (opc != 4) {
            System.out.println("");
            System.out.println("# Vamos Ordenar? #");
            System.out.println("1 - Por Troca");
            System.out.println("2 - Por Selação");
            System.out.println("3 - Por Inserção");
            System.out.println("4 - Sair");
            System.out.println("");
            System.out.print("Informe a opção desejada: ");
            opc = leia.nextInt();
            switch (opc) {
                case 1:
                    vetAux = vet.clone();
                    ordenarPorTroca(vetAux);
                    break;
                case 2:
                    vetAux = vet.clone();
                    ordenarPorSelecao(vetAux);
                    break;
                case 3:
                    vetAux = vet.clone();
                    ordenarPorInsercao(vetAux);
                    break;
                case 4:
                    System.out.println("Sair");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private static int[] trocaPosicao(int vetAux[], int primeiraPosicao, int segundoValor, int segundaPosicao,
            int primeiroValor) {
        vetAux[primeiraPosicao] = segundoValor;
        vetAux[segundaPosicao] = primeiroValor;
        return vetAux;
    }

    //Bubble Sort 
    private static void ordenarPorTroca(int vetAux[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Troca ###");
        int atual, prox, index = 0;
        boolean condicaoDeParada;
        while (index < vetAux.length) {
            condicaoDeParada = true;
            for (int i = 0; i < vetAux.length - index; ++i) {
                int posicaoAtual = i, posicaoFutura = i + 1;
                if (!(posicaoAtual == vetAux.length - 1) && (vetAux[posicaoAtual] > vetAux[posicaoFutura])) {
                    atual = vetAux[posicaoAtual];
                    prox = vetAux[posicaoFutura];
                    vetAux = trocaPosicao(vetAux, posicaoFutura, atual, posicaoAtual, prox);
                    tro++;
                    condicaoDeParada = false;
                }
                com++;

            }
            if (condicaoDeParada) {
                break;
            }

            index++;
        }
        listarComplexiade(tro, com);
        listarVetorOrdenado(vetAux);
    }

    private static Integer[] buscaMaioreMenor(int vetAux[], int maiorIndex, int menorIndex, int qtdComparacoes) {
        int maior = vetAux[maiorIndex];
        int menor = vetAux[menorIndex];
        Integer[] maiorEMenor = { maiorIndex, menorIndex, qtdComparacoes };

        for (int index = menorIndex; index < maiorIndex + 1; ++index) {
            if (vetAux[index] > maior) {
                maior = vetAux[index];
                maiorEMenor[0] = index;
            }

            maiorEMenor[2] += 1;
            if (vetAux[index] < menor) {
                menor = vetAux[index];
                maiorEMenor[1] = index;
            }

        }
        return maiorEMenor;
    }

    //Selection 
    private static void ordenarPorSelecao(int vetAux[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        int maior = 0, menor = 0;
        int casoImpar = (vetAux.length / 2) + 1, casoPar = (vetAux.length / 2);
        boolean parOuImpar = (vetAux.length / 2) % 2 == 0, condicaoDeParada;

        System.out.println("### Ordenação por Seleção ###");

        for (int index = 0; parOuImpar
                ? index < casoPar || index < (vetAux.length - index - 1)
                : index < casoImpar; ++index) {
            int primeiraPosicao = index;
            int ultimaPosicao = (vetAux.length - index - 1);
            condicaoDeParada = true;
            Integer[] maiorEMenor = buscaMaioreMenor(vetAux, ultimaPosicao, primeiraPosicao, com);

            maior = maiorEMenor[0];
            menor = maiorEMenor[1];
            com = maiorEMenor[2];

            // SE O MAIOR ELEMENTO ESTÁ NO COMEÇO DO ARRAY E O MENOR NO FINAL
            // E O COMPUTADOR JÁ SABE QUE ELES SÃO O MAIOR E O MENOR
            // E ESTÃO NA POSIÇÃO OPOSTAS, O COMPUTADOR EFETUA A TROCA
            if (maior == primeiraPosicao && menor == ultimaPosicao) {
                int jogaNoFim = vetAux[maior];
                int jogaNoInicio = vetAux[menor];
                vetAux[ultimaPosicao] = jogaNoFim;
                vetAux[primeiraPosicao] = jogaNoInicio;
                condicaoDeParada = false;
                tro++;
            } else {
                int fimMaior = vetAux[maior]; // MAIOR ELEMENTO DO ARRAY QUE IRA PARA A ULTIMA POSIÇÃO
                int inicioMenor = vetAux[menor]; // MENOR ELEMENTO DO ARRAY QUE IRA PARA A PRIMEIRA POSIÇÃO
                if (vetAux[maior] != vetAux[ultimaPosicao]) {
                    int atual = vetAux[ultimaPosicao];
                    vetAux = trocaPosicao(vetAux, ultimaPosicao, fimMaior, maior, atual);
                    condicaoDeParada = false;
                    tro++;
                }
                if (vetAux[menor] != vetAux[primeiraPosicao]) {
                    int atual = vetAux[primeiraPosicao];
                    if (menor == ultimaPosicao) {
                        menor = maior;
                    }
                    vetAux = trocaPosicao(vetAux, primeiraPosicao, inicioMenor, menor, atual);
                    condicaoDeParada = false;
                    tro++;
                }
            }
            if (condicaoDeParada) {
                break;
            }
        }

        listarComplexiade(tro, com);
        listarVetorOrdenado(vetAux);
    }

    //Insertion
    private static void ordenarPorInsercao(int lista[]) {
        int tro = 0; // Variável para contar a quantidade de Trocas desse método
        int com = 0; // Variável para contar a quantidade de Comparações desse método
        System.out.println("### Ordenação por Inserção ###");

        for (int atual = 0; atual < lista.length; atual++) {
            int analise = atual;
            com++;
            while (analise > 0 && lista[analise] < lista[analise - 1]) {
                int itemAnalise = lista[analise];
                int itemAnterior = lista[analise - 1];

                lista = trocaPosicao(lista, analise, itemAnterior, analise - 1, itemAnalise);
                tro++;
                analise--;

            }
        }

        listarComplexiade(tro, com);
        listarVetorOrdenado(lista);
    }

    private static void listarVetorOrdenado(int vetAux[]) {
        System.out.println("### Lista Ordenada ###");
        for (int val : vetAux) {
            System.out.print(val + "-");
        }
        System.out.println("");
    }

    private static void listarComplexiade(int tro, int com) {
        System.out.println("### Complexidade ###");
        System.out.println("Comparações: " + com);
        System.out.println("Trocas: " + tro);
    }
}