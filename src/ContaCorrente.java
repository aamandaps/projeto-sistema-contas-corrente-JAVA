public class ContaCorrente {

    int codContaC;
    String nomeClienteC;
    double saldoContaC;
    double limiteContaC;
    int tipoContaC;

    // Construtor
    ContaCorrente()
    {
        this(0, "", 0.0, 0.0, 0); // Inicialização dos atributos
    }

    // Construtor com os parâmetros
    ContaCorrente (int codContaC, String nomeClienteC,
                   Double saldoContaC, Double limiteContaC, int tipoContaC)
    {
        this.codContaC = codContaC;
        this.nomeClienteC = nomeClienteC;
        this.saldoContaC = saldoContaC;
        this.limiteContaC = limiteContaC;
        this.tipoContaC = tipoContaC;
    }
}
