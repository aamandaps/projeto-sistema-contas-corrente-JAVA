import javax.swing.JOptionPane;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        // Instância dos métodos
        Metodos m = new Metodos();

        // Instância das classes: ContaCorrente, MovimentoConta, ContaAtualizada
        ContaCorrente[] contaC = new ContaCorrente[5];
        MovimentoConta[] movimentacao = new MovimentoConta[10];
        ContaAtualizada[] contaA = new ContaAtualizada[5];

        // Execução dos metodos construtores das classes
        for (int i=0; i<5; i++)
        {
            contaC [i] = new ContaCorrente();
        }

        for (int i=0; i<10; i++)
        {
            movimentacao[i] = new MovimentoConta();
        }

        for (int i=0; i<5; i++)
        {
            contaA[i] = new ContaAtualizada();
        }

        // Loop do Menu Principal
        int opcMain=0;
        while (opcMain!=9)
        {
            // Menu Principal
            opcMain = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU PRINCIPAL - Digite o número de acordo com a ação que deseja realizar
                    1 - Cadastra Contas Correntes;
                    2 - Cadastra movimentação na conta;
                    3 - Gera Contas Atualizadas (com as movimentações);
                    4 - Consulta de Cadastros;
                    9 - Finaliza a execução.
                    """));

            switch (opcMain)
            {
                case 1:
                    contaC = m.cadastroContaC(contaC); // Function
                break;

                case 2:
                    movimentacao = m.cadastroMovimento(movimentacao); // Function
                break;

                case 3:
                    contaA = m.cadastroContaA(contaA); // Function
                break;

                case 4:
                    m.menuConsultaCadastros(); // Procedure
                break;

                case 9:
                    JOptionPane.showMessageDialog(null, "FIM");
                    System.exit(0);
                break;

                default: JOptionPane.showMessageDialog(null, "Opção Inválida");

            } // Fim SwitchCase
        } // Fim Loop Menu
    } // Fim Metodo Main
} // Fim Classe
