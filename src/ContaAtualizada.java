public class ContaAtualizada {

    int codContaA;
    String nomeClienteA;
    double saldoContaA;
    double limiteContaA;
    int tipoContaA;

    // Construtor
    ContaAtualizada()
    {
        this(0, "", 0.0, 0.0, 0);
    }

    // Construtor com os parâmetros
    ContaAtualizada(int codContaA, String nomeClienteA,
                    Double saldoContaA, Double limiteContaA, int tipoContaA)
    {
        this.codContaA = codContaA;
        this.nomeClienteA = nomeClienteA;
        this.saldoContaA = saldoContaA;
        this.limiteContaA = limiteContaA;
        this.tipoContaA = tipoContaA;
    }

}
