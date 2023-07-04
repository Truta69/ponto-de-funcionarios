
import java.time.Duration;
import java.time.LocalTime;

public class SomarHoraNormal {

    String intervalo(LocalTime horaInicial, LocalTime horaFinal) {
        if (horaInicial.isAfter(horaFinal)) {
            LocalTime temp = horaInicial;
            horaInicial = horaFinal;
            horaFinal = temp;
        }
        Duration diff = Duration.between(horaInicial, horaFinal);
        long diffHours = diff.toHours();
        long diffMinutes = diff.minusHours(diffHours).toMinutes();
        return String.format("%d:%02d", diffHours, diffMinutes);
    }
}
