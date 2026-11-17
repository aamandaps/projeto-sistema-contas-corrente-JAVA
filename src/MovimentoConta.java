public class MovimentoConta {

    int codContaM;
    double valorMovimentoM;
    int tipoMovimentoM;
    int statusM;

    // Construtor
    MovimentoConta()
    {
        this(0, 0.0, 0, 0);
    }

    // Construtor com os parâmetros
    MovimentoConta (int codContaM, Double valorMovimentoM,
                    int tipoMovimentoM, int statusM)
    {
        this.codContaM = codContaM;
        this.valorMovimentoM = valorMovimentoM;
        this.tipoMovimentoM = tipoMovimentoM;
        this.statusM = statusM;
    }
}
