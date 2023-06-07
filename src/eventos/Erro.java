package eventos;

public class Erro extends Exception {

    String msg;

    public Erro(String msg) {
        this.msg = msg;
    }

    public void avisoCadErro() {
    }
}
