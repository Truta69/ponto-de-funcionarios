package eventos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;

public class EventosDoMouse {

    public void carregarBotoes(List<JButton> btn) {
        btn.forEach((x) -> {
            x.setBackground(Color.WHITE);//branco
            x.setPreferredSize(new Dimension(150, 40));//tamanho dos botoes
            x.setFont(new Font("Arial", Font.BOLD, 16));//fonte, estilo e tamnaho
        });
    }

    public void pintarBotoes(List<JButton> btn) {
        btn.forEach((jBtn) -> {
            jBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    jBtn.setBackground(Color.WHITE);//quqndo sai volta a cor
                    jBtn.setForeground(Color.BLACK);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    jBtn.setBackground(Color.BLACK);
                    jBtn.setForeground(Color.WHITE);
                }
            });
        });
    }
}
