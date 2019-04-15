package com.salinas.elias.codechallenge.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ConstantUtil {
    public static String ISSUER_INFO="NAVIMVP2018";

    public static long TOKEN_EXPIRATION_TIME=3000000;

    public static String SUPER_SECRET_KEY="n@v!sv2018";

    public static String HEADER_AUTHORIZACION_KEY="Authorization";

    public static String TOKEN_BEARER_PREFIX="Bearer";

    public static String CODE_KEY = "code";
    public static String CODE_VALUE_SUCCESS = "0";
    public static String CODE_VALUE_ERROR = "9";

    public static String MESSAGE_KEY  = "message";
    public static String MESSAGE_VALUE_SUCCESS  = "Transaction done";
    public static String MESSAGE_VALUE_ERROR  = "Transaction fatal error";

    public static String RESPONSE_KEY = "response";

    public static Date getDate(int hora, int minutos, int segundo){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-6:00"));
        cal.set(Calendar.HOUR_OF_DAY,hora);
        cal.set(Calendar.MINUTE,minutos);
        cal.set(Calendar.SECOND,segundo);
        cal.set(Calendar.MILLISECOND,0);
        return  cal.getTime();
    }

    public static Date addMinutes(Date hora, int minutos){
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT-6:00"));
        cal.setTime(hora);
        cal.set(Calendar.MINUTE,cal.get(Calendar.MINUTE)+minutos);
        return  cal.getTime();
    }
}
