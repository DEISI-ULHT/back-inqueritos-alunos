package com.deisi.inqueritos.utils;


import java.time.LocalDate;

public class AnoLetivoUtils {

    public static int getAnoLetivoAtual() {
        LocalDate now = LocalDate.now();
        if (now.getMonthValue() > 3 && now.getMonthValue() < 9) { // 2º semestre
            return now.getYear() - 1;
        } else {
            return now.getYear();
        }
    }
}
