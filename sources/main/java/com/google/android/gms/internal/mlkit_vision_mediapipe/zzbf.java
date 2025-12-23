package com.google.android.gms.internal.mlkit_vision_mediapipe;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zzbf {
    static final Locale zza = Locale.ROOT;

    public static String zza(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            if (obj.getClass().isArray()) {
                return obj instanceof int[] ? Arrays.toString((int[]) obj) : obj instanceof long[] ? Arrays.toString((long[]) obj) : obj instanceof byte[] ? Arrays.toString((byte[]) obj) : obj instanceof char[] ? Arrays.toString((char[]) obj) : obj instanceof short[] ? Arrays.toString((short[]) obj) : obj instanceof float[] ? Arrays.toString((float[]) obj) : obj instanceof double[] ? Arrays.toString((double[]) obj) : obj instanceof boolean[] ? Arrays.toString((boolean[]) obj) : Arrays.toString((Object[]) obj);
            }
            String obj2 = obj.toString();
            return obj2 != null ? obj2 : zzd(obj, "toString() returned null");
        } catch (RuntimeException e6) {
            return zze(obj, e6);
        }
    }

    private static void zzf(StringBuilder sb, long j6, boolean z5) {
        if (j6 == 0) {
            sb.append("0");
            return;
        }
        String str = true != z5 ? "0123456789abcdef" : "0123456789ABCDEF";
        for (int numberOfLeadingZeros = (63 - Long.numberOfLeadingZeros(j6)) & (-4); numberOfLeadingZeros >= 0; numberOfLeadingZeros -= 4) {
            sb.append(str.charAt((int) ((j6 >>> numberOfLeadingZeros) & 15)));
        }
    }

    static void zzb(StringBuilder sb, Number number, zzay zzayVar) {
        boolean zzk = zzayVar.zzk();
        long longValue = number.longValue();
        if (number instanceof Long) {
            zzf(sb, longValue, zzk);
            return;
        }
        if (number instanceof Integer) {
            zzf(sb, longValue & 4294967295L, zzk);
            return;
        }
        if (number instanceof Byte) {
            zzf(sb, longValue & 255, zzk);
            return;
        }
        if (number instanceof Short) {
            zzf(sb, longValue & WebSocketProtocol.PAYLOAD_SHORT_MAX, zzk);
        } else {
            if (number instanceof BigInteger) {
                String bigInteger = ((BigInteger) number).toString(16);
                if (zzk) {
                    bigInteger = bigInteger.toUpperCase(zza);
                }
                sb.append(bigInteger);
                return;
            }
            throw new IllegalStateException("unsupported number type: ".concat(String.valueOf(number.getClass())));
        }
    }

    public static void zzc(Formattable formattable, StringBuilder sb, zzay zzayVar) {
        int i6;
        int i7;
        int zza2 = zzayVar.zza();
        int i8 = zza2 & 162;
        if (i8 != 0) {
            int i9 = 0;
            if ((zza2 & 32) != 0) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if ((zza2 & 128) != 0) {
                i7 = 2;
            } else {
                i7 = 0;
            }
            if ((zza2 & 2) != 0) {
                i9 = 4;
            }
            i8 = i6 | i7 | i9;
        }
        int length = sb.length();
        Formatter formatter = new Formatter(sb, zza);
        try {
            formattable.formatTo(formatter, i8, zzayVar.zzc(), zzayVar.zzb());
        } catch (RuntimeException e6) {
            sb.setLength(length);
            try {
                formatter.out().append(zze(formattable, e6));
            } catch (IOException unused) {
            }
        }
    }

    private static String zzd(Object obj, String str) {
        return "{" + obj.getClass().getName() + "@" + System.identityHashCode(obj) + ": " + str + "}";
    }

    private static String zze(Object obj, RuntimeException runtimeException) {
        String simpleName;
        try {
            simpleName = runtimeException.toString();
        } catch (RuntimeException e6) {
            simpleName = e6.getClass().getSimpleName();
        }
        return zzd(obj, simpleName);
    }
}
