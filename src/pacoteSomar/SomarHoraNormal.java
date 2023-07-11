package pacoteSomar;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class SomarHoraNormal {

    public String calcularIntervaloManha(LocalTime entrada, LocalTime almoco) {
        if (entrada.isAfter(almoco)) {
            LocalTime temp = entrada;
            entrada = almoco;
            almoco = temp;
        }
        long intervalo = ChronoUnit.SECONDS.between(entrada, almoco); // obtém o intervalo em segundos
        long horas = intervalo / 3600; // converte os segundos para horas
        long minutos = (intervalo % 3600) / 60; // obtém os minutos restantes
        return horas + ":" + minutos;
    }

    public String calcularIntervaloTarde(LocalTime retorno, LocalTime saida) {
        if (retorno.isAfter(saida)) {
            LocalTime temp = retorno;
            retorno = saida;
            saida = temp;
        }
        long intervalo = ChronoUnit.SECONDS.between(retorno, saida); // obtém o intervalo em segundos
        long horas = intervalo / 3600; // converte os segundos para horas
        long minutos = (intervalo % 3600) / 60; // obtém os minutos restantes
        return horas + ":" + minutos;
    }

    public String calcularIntervaloDia(String h_manha, String h_tarde) {
        long soma = 0; // variável que armazena a soma dos intervalos em segundos
        // Para cada retorno dos métodos, faz o seguinte:
        for (String retorno : new String[]{h_manha, h_tarde}) {
            // Separa a string em duas partes usando o caractere ":" como separador
            String[] partes = retorno.split(":");
            // Converte a primeira parte da string para um long (horas)
            long horas = Long.parseLong(partes[0]);
            // Converte a segunda parte da string para um long (minutos)
            long minutos = Long.parseLong(partes[1]);
            // Multiplica as horas por 3600 e soma com os minutos multiplicados por 60 (intervalo em segundos)
            long intervalo = horas * 3600 + minutos * 60;
            // Soma esse valor com a variável que armazena a soma dos intervalos
            soma += intervalo;
        }
        // Depois de somar os retornos dos dois métodos, faz o inverso do que foi feito no método calcularIntervaloComHoras
        // Divida a soma dos intervalos por 3600 para obter as horas
        long horas = soma / 3600;
        // Pegue o resto da divisão por 3600 e divida por 60 para obter os minutos
        long minutos = (soma % 3600) / 60;
        // Retorne uma string com as horas e os minutos separados por ":"
        return horas + ":" + minutos;
    }
}
