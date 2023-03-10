package avltree;

import core.InputReader;
import javax.swing.JFrame;

public class AVLTreeInterface {

    private AVLTree tree;
    private AVLTreeRenderer treeViewer;
    
    public AVLTreeInterface() {
        // Inicializa a classe de renderizacao do grafo
        tree = new AVLTree();
        treeViewer = new AVLTreeRenderer(tree.getRoot());
        JFrame frame = treeViewer;
        frame.setSize(AVLTreeRenderer.CANVAS_WIDTH, AVLTreeRenderer.CANVAS_HEIGHT);
        treeViewer.setVisible(true);
    }
    
    /**
     * Exibe a mensagem de ajuda
     */
    public void help() {
        System.out.println("Comandos:");
        System.out.println("I [chave] - Incluir node");
        System.out.println("R [chave] - Remover node");
        System.out.println("B [chave] - Buscar node");
        System.out.println("E - Imprime os encaminhamentos da arvore");
        System.out.println("X - Sair");
    }
    
    /**
     * Aceita o menu de operacoes com a arvore AVL
     */
    public void accept() {
        help();
        boolean running = true;
        while (running) {
            String line = InputReader.readLineWithMessage("\nComando >> ");
            
            if (line.toUpperCase().equals("X")) {
                // Encerra a visualizacao do grafo
                treeViewer.dispose();
                break;
            } else if (line.toUpperCase().equals("E")) {
                // Imprime todos os tipos de encaminhamento da arvore AVL
                System.out.print("Pre-ordem: ");
                tree.printPreOrder();
                System.out.print("\nPos-ordem: ");
                tree.printPostOrder();
                System.out.print("\nEm ordem: ");
                tree.printInOrder();
                System.out.print("\nPor nível: ");
                tree.printLevelOrder();
                continue;
            }
            // Valida a quantidade de parametros da instrucao
            String[] args = line.split(" ");
            if (args.length != 2) {
                System.out.println("Número de argumentos inválido!");
                continue;
            }
            // Valida se a chave e um inteiro
            int key;
            try {
                key = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Chave inválida!");
                continue;
            }
            // Avalia a operação selecionada
            String op = args[0].toUpperCase();
            switch(op) {
                case "I": // Insercao
                    tree.insert(key);
                    treeViewer.update(tree.getRoot());
                    break;
                case "R": // Remocao
                    tree.remove(key);
                    treeViewer.update(tree.getRoot());
                    break;
                case "B": // Busca
                    if (tree.search(key) != null) {
                        System.out.println("Chave encontrada!");
                    } else {
                        System.out.println("Chave não encontrada!");
                    }
                    break;
                default:
                    System.out.println("Operação inválida!");
                    break;
            }
        }
    }
    
}
