package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class zzc {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String str) {
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = zza.matcher(str);
            StringBuilder sb = null;
            int i6 = 0;
            while (matcher.find()) {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                int start = matcher.start();
                int i7 = start;
                while (i7 >= 0 && str.charAt(i7) == '\\') {
                    i7--;
                }
                if ((start - i7) % 2 != 0) {
                    int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                    sb.append((CharSequence) str, i6, matcher.start());
                    if (parseInt == 92) {
                        sb.append("\\\\");
                    } else {
                        sb.append(Character.toChars(parseInt));
                    }
                    i6 = matcher.end();
                }
            }
            if (sb != null) {
                if (i6 < matcher.regionEnd()) {
                    sb.append((CharSequence) str, i6, matcher.regionEnd());
                }
                return sb.toString();
            }
            return str;
        }
        return str;
    }
}
