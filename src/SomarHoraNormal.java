
public class SomarHoraNormal {
    
    public String somar(String h1, String h2) {
        String retorno = "";
        double d1 = Double.parseDouble(h1);
        double d2 = Double.parseDouble(h2);
        double result = d2 - d1;
        retorno = String.valueOf(result);
        return retorno;
    }
}
