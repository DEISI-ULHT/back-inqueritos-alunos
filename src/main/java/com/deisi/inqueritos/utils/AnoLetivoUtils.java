package com.deisi.inqueritos.utils;


import java.time.LocalDate;

public class AnoLetivoUtils {

    public static int getAnoLetivoAtual() {
        LocalDate now = LocalDate.now();
        if (now.getMonthValue() > 4 && now.getMonthValue() < 9 ||   // 2º semestre
            now.getMonthValue() <= 2 // 1º semestre do ano anterior
        ) {
            return now.getYear() - 1;
        } else {
            return now.getYear();
        }
    }
}
