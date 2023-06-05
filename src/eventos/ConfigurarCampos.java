package eventos;

import java.awt.Font;
import java.util.List;
import javax.swing.JTextField;

public class ConfigurarCampos {

    public void configurar(List<JTextField> txt) {
        txt.get(0).setEnabled(false);
        txt.forEach((x) -> {
            x.setFont(new Font("Arial", Font.BOLD, 12));
        });
    }

    public void limparCampos(List<JTextField> jTxt) {
        jTxt.forEach((x) -> {
            x.setText("");
        });
    }
}
