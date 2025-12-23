package com.github.aachartmodel.aainfographics.aatools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import kotlin.jvm.internal.g0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class AADate {
    public static final AADate INSTANCE = new AADate();

    public final long AADateUTC(int i6, int i7, int i8) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(i6);
            sb.append('-');
            sb.append(i7);
            sb.append('-');
            sb.append(i8);
            date = simpleDateFormat.parse(sb.toString());
        } catch (ParseException e6) {
            e6.printStackTrace();
            date = null;
        }
        g0.m(date);
        return date.getTime();
    }

    private AADate() {
    }
}
