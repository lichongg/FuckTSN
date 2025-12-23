package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public enum zzdm {
    TIME_HOUR_OF_DAY_PADDED('H'),
    TIME_HOUR_OF_DAY('k'),
    TIME_HOUR_12H_PADDED('I'),
    TIME_HOUR_12H('l'),
    TIME_MINUTE_OF_HOUR_PADDED('M'),
    TIME_SECONDS_OF_MINUTE_PADDED('S'),
    TIME_MILLIS_OF_SECOND_PADDED('L'),
    TIME_NANOS_OF_SECOND_PADDED('N'),
    TIME_AM_PM('p'),
    TIME_TZ_NUMERIC('z'),
    TIME_TZ_SHORT('Z'),
    TIME_EPOCH_SECONDS('s'),
    TIME_EPOCH_MILLIS('Q'),
    DATE_MONTH_FULL('B'),
    DATE_MONTH_SHORT('b'),
    DATE_MONTH_SHORT_ALT('h'),
    DATE_DAY_FULL('A'),
    DATE_DAY_SHORT('a'),
    DATE_CENTURY_PADDED('C'),
    DATE_YEAR_PADDED('Y'),
    DATE_YEAR_OF_CENTURY_PADDED('y'),
    DATE_DAY_OF_YEAR_PADDED('j'),
    DATE_MONTH_PADDED('m'),
    DATE_DAY_OF_MONTH_PADDED('d'),
    DATE_DAY_OF_MONTH('e'),
    DATETIME_HOURS_MINUTES('R'),
    DATETIME_HOURS_MINUTES_SECONDS('T'),
    DATETIME_HOURS_MINUTES_SECONDS_12H('r'),
    DATETIME_MONTH_DAY_YEAR('D'),
    DATETIME_YEAR_MONTH_DAY('F'),
    DATETIME_FULL('c');

    private static final Map zzF;
    private final char zzH;

    static {
        HashMap hashMap = new HashMap();
        for (zzdm zzdmVar : values()) {
            if (hashMap.put(Character.valueOf(zzdmVar.zzH), zzdmVar) != null) {
                throw new IllegalStateException("duplicate format character: ".concat(String.valueOf(zzdmVar)));
            }
        }
        zzF = Collections.unmodifiableMap(hashMap);
    }

    public static final zzdm zzb(char c6) {
        return (zzdm) zzF.get(Character.valueOf(c6));
    }

    public final char zza() {
        return this.zzH;
    }

    zzdm(char c6) {
        this.zzH = c6;
    }
}
