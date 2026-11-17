# 🏦 Sistema de Contas Correntes em Java

![Java](https://img.shields.io/badge/JAVA-D8BFD8?style=for-the-badge&logo=openjdk&logoColor=111111)
![IntelliJ IDEA](https://img.shields.io/badge/INTELLIJ_IDEA-D8BFD8?style=for-the-badge&logo=intellijidea&logoColor=111111)

## Sobre o Projeto

Projeto de um **Sistema de Contas Correntes** desenvolvido em **Java**, focado em consolidar a prática de Programação Orientada a Objetos, manipulação e persistência de arquivos `.txt`, algoritmos de ordenação (*Bubble Sort*) e processamento sequencial utilizando a lógica de **Balance-Line** para atualização de saldos e limites bancários.

<br>
 
## Funcionalidades

- **Cadastro de Contas Correntes:** Registro de até 5 contas (código, nome do cliente, saldo, limite e tipo de conta: *Física, Conjunta, Jurídica ou Especial*), com ordenação automática por código e gravação em `CadastroContaC.txt`.
- **Cadastro de Movimentações:** Registro de até 10 movimentações financeiras (código da conta, valor, tipo de movimentação: *Crédito ou Débito*, e status: *Pendente ou Efetivado*), ordenadas e salvas em `MovimentoConta.txt`.
- **Atualização de Contas (Balance-Line):** Cruzamento dos arquivos ordenados de contas e movimentações para calcular os novos saldos, aplicar regras específicas de recálculo de limite conforme o tipo de conta em casos de débito acima do saldo, e gerar o arquivo `CadastroContaA.txt`.
- **Consulta de Cadastros:** Submenu interativo via `JOptionPane` para leitura e exibição dos registros gravados nos arquivos de Contas Correntes, Movimentações e Contas Atualizadas.

<br>

## ╰┈➤ Estrutura do Projeto

- `ContaCorrente.java` — Classe modelo que representa os dados iniciais das contas bancárias.
- `MovimentoConta.java` — Classe modelo que representa os lançamentos de crédito e débito.
- `ContaAtualizada.java` — Classe modelo que armazena o resultado consolidado após o processamento.
- `Metodos.java` — Classe responsável pelas operações de cadastro, ordenação (*Bubble Sort*), leitura/gravação de arquivos (`BufferedReader` / `BufferedWriter`), lógica de *Balance-Line* e menus de consulta.
- `Main.java` (ou `Principal.java`) — Classe principal contendo o menu de navegação do sistema.



