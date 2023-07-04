package eventos;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class ConfigurarCampos {

    public void configurar(List<JTextField> txt) {
        txt.get(0).setEnabled(false);
        txt.forEach((x) -> {
            x.setFont(new Font("Arial", Font.BOLD, 12));
        });
    }

    public void limparCampos(List<JFormattedTextField> jTxt) {
        jTxt.forEach((x) -> {
            x.setText("");
        });
    }

    public void mascararHora(List<JFormattedTextField> mascara) {
        List<JFormattedTextField> camposHora = new ArrayList<>();
        try {
            MaskFormatter mask = new MaskFormatter("##:##");
            mascara.forEach((campo) -> {
                JFormattedTextField campoHora = new JFormattedTextField(mask);
                //x = new JFormattedTextField(mask);
                campoHora.setEditable(false);
                campoHora.setFormatterFactory(new DefaultFormatterFactory(mask));
                camposHora.add(campoHora);
            });
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido!\n" + ex, "Alerta", JOptionPane.ERROR_MESSAGE);
        }
    }
}
