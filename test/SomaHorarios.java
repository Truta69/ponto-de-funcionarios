
import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class SomaHorarios {

      @Test
    public void tesIntervaloHoraNormal() {
        SomarHoraNormal horaNormal = new SomarHoraNormal();
        LocalTime horaInicial = LocalTime.of(9, 0);
        LocalTime horaFinal = LocalTime.of(8, 0);
        String result =horaNormal.intervalo(horaInicial, horaFinal);
        assertEquals("1:00", result);
    }
    
    @Test
    public void testIntervaloHoraInicialMenorQueHoraFinal () {
        SomarHoraNormal horaNormal = new SomarHoraNormal();
        LocalTime horaInicial = LocalTime.of(7, 0);
        LocalTime horaFinal = LocalTime.of(11, 0);
        String result =horaNormal.intervalo(horaInicial, horaFinal);
        assertEquals("4:00", result);
    }
}
