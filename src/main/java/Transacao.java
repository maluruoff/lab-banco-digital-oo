import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Transacao {
    private Date data;
    private String tipo;
    private double valor;
    private double saldoAposTransacao;

    public Transacao(Date data, String tipo, double valor, double saldoAposTransacao) {
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.saldoAposTransacao = saldoAposTransacao;
    }

}
