import javax.swing.JOptionPane;
import java.io.*;

public class Metodos {

    // Menu 2 - Consulta os cadastros
    public void menuConsultaCadastros() throws IOException
    {
        int opcConsulta=0;
        while (opcConsulta!=9)
        {
            opcConsulta = Integer.parseInt(JOptionPane.showInputDialog("""
                    CONSULTA CADASTROS - Digite o número de acordo com o cadastro que deseja visualizar
                    1 - Contas Correntes;
                    2 - Movimentações das Contas;
                    3 - Contas Atualizadas com os valores após as movimentações;
                    9 - Finalizar a execução.
                    """));

            switch (opcConsulta)
            {
                case 1:
                    ContaCorrente[] contaC = lerContaC();
                    StringBuilder listaC = new StringBuilder("=== CONTAS CORRENTES ===\n\n");

                    for (int i = 0; i < 5; i++)
                    {
                        if (contaC[i].nomeClienteC != null)
                        {
                            listaC.append("Conta: ").append(contaC[i].codContaC)
                                    .append(" | Cliente: ").append(contaC[i].nomeClienteC)
                                    .append(" | Saldo: R$ ").append(contaC[i].saldoContaC)
                                    .append(" | Limite: R$ ").append(contaC[i].limiteContaC)
                                    .append(" | Tipo: ").append(contaC[i].tipoContaC)
                                    .append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, listaC.toString());
                break;

                case 2:
                    MovimentoConta[] movimentacao = lerMovimentoC();
                    StringBuilder listaM = new StringBuilder("=== MOVIMENTAÇÕES ===\n\n");

                    for (int i = 0; i < 10; i++)
                    {
                        if (movimentacao[i].codContaM != 0)
                        {
                            listaM.append("Conta: ").append(movimentacao[i].codContaM)
                                    .append(" | Valor: R$ ").append(movimentacao[i].valorMovimentoM)
                                    .append(" | Tipo: ").append(movimentacao[i].tipoMovimentoM)
                                    .append(" | Status: ").append(movimentacao[i].statusM)
                                    .append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, listaM.toString());
                break;

                case 3:
                    ContaAtualizada[] contaA = lerContaA();
                    StringBuilder listaA = new StringBuilder("=== CONTAS ATUALIZADAS ===\n\n");

                    for (int i = 0; i < 5; i++)
                    {
                        if (contaA[i].nomeClienteA != null)
                        {
                            listaA.append("Conta: ").append(contaA[i].codContaA)
                                    .append(" | Cliente: ").append(contaA[i].nomeClienteA)
                                    .append(" | Saldo: R$ ").append(contaA[i].saldoContaA)
                                    .append(" | Limite: R$ ").append(contaA[i].limiteContaA)
                                    .append(" | Tipo: ").append(contaA[i].tipoContaA)
                                    .append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, listaA.toString());
                break;

                case 9:
                    JOptionPane.showMessageDialog(null, "FIM");
                    System.exit(0);
                break;

                default: JOptionPane.showMessageDialog(null, "Opção Inválida.");
            }
        }
    }

    // Function que cadastra correntes
    public ContaCorrente[] cadastroContaC(ContaCorrente[] contaC) throws IOException
    {
        // Percorrendo registro e cadastrando as contas
        for (int i=0; i<5; i++)
        {
            contaC[i].codContaC = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da conta corrente: "));
            contaC[i].nomeClienteC = JOptionPane.showInputDialog("Digite o nome do cliente: ");
            contaC[i].saldoContaC = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta: "));
            contaC[i].limiteContaC = Double.parseDouble(JOptionPane.showInputDialog("Digite o limite da conta: "));
            contaC[i].tipoContaC = Integer.parseInt(JOptionPane.showInputDialog("""
                     Digite o número correspondente ao tipo de conta corrente:
                     1 ----------- Física
                     2 ----------- Conjunta
                     3 ----------- Jurídica
                     4 ----------- Especial
                    """));
        } // Fim Loop

        // Chamada da procedure de ordenação
        ordenaContaC(contaC);

        // Chamada da gravação de ContaC
        gravarContaC(contaC);

        return contaC;
    } // Fim Function cadastroContaC


        // Procedure que ordena o conteúdo de ContaCorrente[] em ordem crescente antes da gravação
        // Algoritmo de Ordenação utilizado -> Bubble Sort
        public void ordenaContaC (ContaCorrente[] contaC)
        {
            ContaCorrente aux; // Auxiliar do tipo ContaCorrente para a ordenação

            for(int i=0; i<4; i++)
            {
                for(int j=i+1; j<5; j++)
                {
                    // Comparação
                    if(contaC[i].codContaC > contaC[j].codContaC)
                    {
                        aux = contaC[i];
                        contaC[i] = contaC[j];
                        contaC[j] = aux;
                    } // Fim Comparação
                } // Fim Loop j
            } // Fim Loop i
        } // Fim Procedure OrdenaContaC


        // Procedure que grava os cadastros de contas corrente
        public void gravarContaC (ContaCorrente[] contaC) throws IOException
        {
            String fileName = "CadastroContaC.txt";

            BufferedWriter gravar = new BufferedWriter (new FileWriter(fileName)); // Variável responsável pelo buffer que vai gerar a gravação

            for(int i=0; i<5; i++)
            {
                // Gravação CodContaC
                gravar.write(String.valueOf(contaC[i].codContaC)); // Convertendo antes de gravar no arquivo
                gravar.newLine(); // Gravação

                // Gravação NomeCliente
                gravar.write(contaC[i].nomeClienteC);
                gravar.newLine();

                // Gravação SaldoContaC
                gravar.write(String.valueOf(contaC[i].saldoContaC));
                gravar.newLine();

                // Gravação LimteContaC
                gravar.write(String.valueOf(contaC[i].limiteContaC));
                gravar.newLine();

                // Gravação TipoContaC
                gravar.write(String.valueOf(contaC[i].tipoContaC));
                gravar.newLine();
            } // Fim Loop Gravação

            gravar.close(); // Encerrando a gravação
        } // Fim Procedure GravaContaC

        // Function que realiza a leitura do CadastroContaC.txt
        public ContaCorrente[] lerContaC () throws IOException
        {
            // Instância da classe ContaCorrente
            ContaCorrente[] contaC =  new ContaCorrente[5];

            // Execução do metodo construtor da classe
            for (int i=0; i<5; i++)
            {
                contaC [i] = new ContaCorrente();
            }

            String fileName = "CadastroContaC.txt";

            BufferedReader ler = new BufferedReader(new FileReader(fileName)); // Variável 'ler' contém o buffer que realiza a leitura do arquivo

            for(int i=0; i<5; i++)
            {
                String linhaID = ler.readLine(); // Vai armazenar a operação de leitura APENAS para o primeiro atributo

                // Se a linha estiver vazia, encerra a leitura
                if(linhaID == null)
                {
                    break;
                }

                // Leitura de cada linha gravada
                contaC[i].codContaC = Integer.parseInt(linhaID); // Apenas o primeiro atributo recebe o linhaID pois ele serve de parâmetro para a verificação
                contaC[i].nomeClienteC = ler.readLine();
                contaC[i].saldoContaC = Double.parseDouble(ler.readLine());
                contaC[i].limiteContaC = Double.parseDouble(ler.readLine());
                contaC[i].tipoContaC = Integer.parseInt(ler.readLine());
            } // Fim Loop Leitura

            ler.close(); // Encerra a leitura

            return contaC;
        } // Fim Function lerContaC


    // Function que cadastra a movimentação
    public MovimentoConta[] cadastroMovimento (MovimentoConta[] movimentacao) throws IOException
    {
        // Percorrendo o registro e cadastrando as movimentações
        for(int i=0; i<10; i++)
        {
            movimentacao[i].codContaM = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta da movimentação: "));
            movimentacao[i].valorMovimentoM = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da movimentação: "));
            movimentacao[i].tipoMovimentoM = Integer.parseInt(JOptionPane.showInputDialog("""
                     Digite o tipo de movimentação:
                     1 - Crédito;
                     2 - Débito."""));
            movimentacao[i].statusM = Integer.parseInt(JOptionPane.showInputDialog("""
                     Digite o status da movimentação:
                     1 - Pendente/não efetivado;
                     2 - Efetuado/ativo."""));
        }

        // Chamanda da procedure de ordenação
        ordenaMovimentoC(movimentacao);

        // Chamada da procedure de gravação
        gravarMovimentoC(movimentacao);

        return movimentacao;
    } // Fim Function cadastroMovimento

        // Procedure que ordena o conteúdo de MovimentoConta[] em ordem crescente antes da gravação
        // Algoritmo de Ordenação utilizado -> Bubble Sort
        public void ordenaMovimentoC(MovimentoConta[] movimentacao)
        {
            MovimentoConta aux; // Auxiliar do tipo MovimentoConta para a ordenação

            for (int i=0; i<9; i++)
            {
                for (int j=i+1; j<10; j++)
                {
                    // Comparação
                    if (movimentacao[i].codContaM > movimentacao[j].codContaM)
                    {
                        aux = movimentacao[i];
                        movimentacao[i] = movimentacao[j];
                        movimentacao[j] = aux;
                    } // Fim Comparação
                } // Fim Loop j
            } // Fim Loop i
        } // Fim Procedure ordenaMovimentoC

        // Procedure que grava os cadastros de movimentações
        public void gravarMovimentoC (MovimentoConta[] movimentacao) throws IOException
        {
            String fileName = "MovimentoConta.txt";

            BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

            for (int i=0; i<10;  i++)
            {
                // Gravando codContaM
                gravar.write(String.valueOf(movimentacao[i].codContaM)); // Convertendo para string
                gravar.newLine();

                // Gravando valorMovimento
                gravar.write(String.valueOf(movimentacao[i].valorMovimentoM));
                gravar.newLine();

                // Gravando tipoMovimento
                gravar.write(String.valueOf(movimentacao[i].tipoMovimentoM));
                gravar.newLine();

                // Gravando statusM
                gravar.write(String.valueOf(movimentacao[i].statusM));
                gravar.newLine();
            } // Fim Loop Gravação

            gravar.close(); // Encerrando a gravação
        } // Fim Procedure gravarMovimentoC

        // Function que realiza a leitura do MovimentoConta.txt
        public MovimentoConta[] lerMovimentoC () throws IOException
        {
            // Instância da classe MovimentoConta
            MovimentoConta[] movimentacao = new MovimentoConta[10];

            // Execução do metodo construtor da classe
            for(int i=0; i<10; i++)
            {
                movimentacao[i] = new MovimentoConta();
            }

            String fileName = "MovimentoConta.txt";

            BufferedReader ler = new BufferedReader(new FileReader(fileName)); // Variável 'ler' contém o buffer que realiza a leitura do arquivo

            for (int i=0; i<10; i++)
            {
                String linhaID = ler.readLine(); // Vai armazenar a operação de leitura APENAS para o primeiro atributo

                // Se a linha estiver vazia, encerra a leitura
                if(linhaID == null)
                {
                    break;
                }

                movimentacao[i].codContaM = Integer.parseInt(linhaID); // Apenas o primeiro atributo recebe o linhaID pois ele serve de parâmetro para a verificação
                movimentacao[i].valorMovimentoM = Double.parseDouble(ler.readLine());
                movimentacao[i].tipoMovimentoM = Integer.parseInt(ler.readLine());
                movimentacao[i].statusM = Integer.parseInt(ler.readLine());
            } // Fim Loop Leitura

            ler.close(); // Encerra a leitura

            return movimentacao;
        } // Fim Function lerMovimentoC


    // Function que processa balance-line e gera cadastro de contas atualizadas
    public ContaAtualizada[] cadastroContaA (ContaAtualizada[] contaA) throws IOException
    {
        // Leitura dos arquivos já ordenados
        // Vetores ContaCorrente[] e MovimentoConta[] vão armazenar os dados da leitura
        ContaCorrente[] contaC = lerContaC();
        MovimentoConta[] movimentacao = lerMovimentoC();

        int i=0; // Contador para contaC (5 registros)
        int j=0; // Contador para movimentacao (10 registros)
        int k=0; // Contador para contaA (5 registros)

        // Saldo e Limite temporários para acumlar os valores que vão para a ContaAtualizada(contaA)
        double saldoTemp = contaC[0].saldoContaC;
        double limiteTemp = contaC[0].limiteContaC;

        // Loop que vai percorrer e comparar as duas pilhas
        while (i<5 && j<10)
        {
            // Se o índice de contaC bater com o índice de movimentacao, quer dizer que o movimento foi realizado naquela conta
            if(contaC[i].codContaC == movimentacao[j].codContaM)
            {
                // Verificando se há movimento
                if(movimentacao[j].statusM == 2)
                {
                    // Switch para verificar o tipo de movimento - 1 (crédito), 2 (débito)
                    switch (movimentacao[j].tipoMovimentoM)
                    {
                        case 1:
                            // Crédito - apenas recebe o saldo
                            saldoTemp += movimentacao[j].valorMovimentoM;
                        break;

                        case 2:
                            // Débito

                            // Se o saldo for menor que o valor da movimentação
                            if (saldoTemp < movimentacao[j].valorMovimentoM)
                            {
                                limiteTemp = calcularNovoLimite(contaC[i].tipoContaC, saldoTemp, limiteTemp);
                            } // Fim verificação dos saldos

                            saldoTemp -= movimentacao[j].valorMovimentoM;

                    } // Fim Switch para o tipo de movimento
                } // Fim Verificação do status da movimentação

                j++; // Avançando apenas a movimentação


            }
            // Verificando se ainda há movimentação para a conta do índice atual
            else if(contaC[i].codContaC < movimentacao[j].codContaM)
            {
                // Atualizando a conta com os valores após as movimentações
                contaA[k].codContaA = contaC[i].codContaC;
                contaA[k].nomeClienteA = contaC[i].nomeClienteC;
                contaA[k].saldoContaA = saldoTemp;
                contaA[k].limiteContaA = limiteTemp;
                contaA[k].tipoContaA = contaC[i].tipoContaC;

                // Incrementando as contas
                k++;
                i++;

                // Zerando o acumulador para o próximo cliente
                if (i<5)
                {
                    saldoTemp = contaC[i].saldoContaC;
                    limiteTemp = contaC[i].limiteContaC;
                }
            }
            else
            {
                j++; // Ignora a movimentação se a conta não corresponder
            }

        }

        // Salva a conta que estava em aberto e as contas restantes sem movimento
        while (i < 5)
        {
            contaA[k].codContaA = contaC[i].codContaC;
            contaA[k].nomeClienteA = contaC[i].nomeClienteC;
            contaA[k].saldoContaA = saldoTemp;
            contaA[k].limiteContaA = limiteTemp;
            contaA[k].tipoContaA = contaC[i].tipoContaC;

            k++;
            i++;

            if (i < 5)
            {
                saldoTemp = contaC[i].saldoContaC;
                limiteTemp = contaC[i].limiteContaC;
            }
        }

        // Chamada da procedure que gravaContaA
        gravarContaA(contaA);

        return contaA;
    } // Fim Function cadastroContaA

        // Function que calcula o novo limite caso o saldo da conta seja menor que o valor da movimentação
        public double calcularNovoLimite (int tipoConta, double saldoAtual, double limiteAtual)
        {
            // Novo limite conforme o tipo de conta
            switch (tipoConta)
            {
                case 1: // pessoa física
                    return 0.0;

                case 2: // conta conjunta
                    return limiteAtual;

                case 3: // pessoa jurídica
                    return limiteAtual + (0.50*saldoAtual);

                case 4:
                    return limiteAtual + saldoAtual;

                default: return limiteAtual;
            } // Fim Switch
        } // Fim Function calcularNovoLimite

        public void gravarContaA(ContaAtualizada[] contaA) throws IOException
        {
            String fileName = "ContasAtualizadas.txt";

            BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName)); // Variável responsável pelo buffer que vai gerar a gravação

            for (int i=0; i<5; i++)
            {
                // Gravando codContaA
                gravar.write(String.valueOf(contaA[i].codContaA));
                gravar.newLine();

                // Gravando nomeClienteA
                gravar.write(String.valueOf(contaA[i].nomeClienteA));
                gravar.newLine();

                // Gravando saldoContaA
                gravar.write(String.valueOf(contaA[i].saldoContaA));
                gravar.newLine();

                // Gravando limiteContaA
                gravar.write(String.valueOf(contaA[i].limiteContaA));
                gravar.newLine();

                // Gravando tipoContaA
                gravar.write(String.valueOf(contaA[i].tipoContaA));
                gravar.newLine();
            } // Fim Loop Gravação

            gravar.close(); // Encerrando a gravação
        } // Fim Procedure gravarContaA

        public ContaAtualizada[] lerContaA () throws IOException
        {
            // Instância da classe ContaAtualizada
            ContaAtualizada[] contaA = new ContaAtualizada[5];

            // Execução do metodo construtor
            for(int i=0; i<5; i++)
            {
                contaA[i] = new ContaAtualizada();
            }

            String fileName = "ContasAtualizadas.txt";

            BufferedReader ler = new BufferedReader(new FileReader(fileName)); // Variável 'ler' contém o buffer que realiza a leitura do arquivo

            for(int i=0; i<5; i++)
            {
                String linhaID = ler.readLine(); // Vai armazenar a operação de leitura APENAS para o primeiro atributo

                // Se a linha estiver vazia, encerra a leitura
                if (linhaID == null)
                {
                    break;
                }

                // Leitura de cada linha gravada
                contaA[i].codContaA = Integer.parseInt(linhaID); // Apenas o primeiro atributo recebe o linhaID pois ele serve de parâmetro para a verificação
                contaA[i].nomeClienteA = ler.readLine();
                contaA[i].saldoContaA = Double.parseDouble(ler.readLine());
                contaA[i].limiteContaA = Double.parseDouble(ler.readLine());
                contaA[i].tipoContaA = Integer.parseInt(ler.readLine());
            }

            ler.close(); // Encerra a leitura

            return contaA;
        } // Fim Function lerContaA

} // Fim Classe Metodos
