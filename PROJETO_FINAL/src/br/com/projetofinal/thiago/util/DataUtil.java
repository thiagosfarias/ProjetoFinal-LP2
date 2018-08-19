package br.com.projetofinal.thiago.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DataUtil {
    public static Date getCurrentDate() {
        Date data = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
