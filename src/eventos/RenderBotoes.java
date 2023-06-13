package eventos;

import java.util.List;
import javax.swing.JButton;

public class RenderBotoes {

    List<JButton> btn;
    EventosDoMouse eventos = new EventosDoMouse();

    public RenderBotoes(List<JButton> btn) {
        this.btn = btn;
    }

    public void carregarBotoes() {
        eventos.carregarBotoes(btn);
    }

    public void alterarCorDosBotoesComMouse() {
        eventos.pintarBotoes(btn);
    }
}
