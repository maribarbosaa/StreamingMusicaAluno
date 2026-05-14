package br.com.streaming.util;

public class FormatadorTempo {

    public static String formatarSegundos(int segundos) {
        int minutos = segundos / 60;
        int segs = segundos % 60;
        return minutos + ":" + String.format("%02d", segs);
    }

    public static String formatarPorExtenso(int segundos) {
        int minutos = segundos / 60;
        int segs = segundos % 60;

        if (minutos == 0) {
            return segs + " segundo(s)";
        } else if (segs == 0) {
            return minutos + " minuto(s)";
        } else {
            return minutos + " minuto(s) e " + segs + " segundo(s)";
        }
    }


    public static String formatarDuracaoPlaylist(int totalSegundos) {
        int horas = totalSegundos / 3600;
        int minutos = (totalSegundos % 3600) / 60;
        int segs = totalSegundos % 60;

        if (horas > 0) {
            return horas + "h " + minutos + "min " + segs + "s";
        } else {
            return minutos + "min " + segs + "s";
        }
    }
}