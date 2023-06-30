
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class SomaHorarios {

    @Test
    public void testSomarHoraNormal() {
        SomarHoraNormal horaNormal=new SomarHoraNormal();
        LocalTime horaInicial = LocalTime.of(10, 30); // 10:30
        LocalTime horaSomar = LocalTime.of(0, 30); // 00:30
        String valor=horaNormal.somar("7", "11");
        assertEquals("4.0",valor);
    }
}
