
import pacoteSomar.SomarHoraNormal;
import java.time.LocalTime;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

public class TesSomaHorarios {

    @Test
    public void testarIntervaloManha() {
        SomarHoraNormal somar = new SomarHoraNormal();
        LocalTime inicio = LocalTime.of(10, 30); // 10:30
        LocalTime fim = LocalTime.of(11, 02); // 11:15
        String resultado = somar.calcularIntervaloManha(inicio, fim);
        assertEquals("0:32", resultado);
    }

    @Test
    public void testarIntervaloTarde() {
        SomarHoraNormal somar = new SomarHoraNormal();
        LocalTime inicio = LocalTime.of(12, 59); // 10:30
        LocalTime fim = LocalTime.of(17, 02); // 11:15
        String resultado = somar.calcularIntervaloTarde(inicio, fim);
        assertEquals("4:3", resultado);//4:03
    }

    @Test
    public void testarIntervaloDia() {
        SomarHoraNormal somar = new SomarHoraNormal();
        String h_manha="0:32";
        String h_tarde="4:3";//4:03
        String resultado = somar.calcularIntervaloDia(h_manha, h_tarde);
        assertEquals("4:35", resultado);//4:03
    }
}
