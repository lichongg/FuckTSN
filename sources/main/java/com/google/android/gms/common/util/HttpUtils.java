package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.common.zzo;
import com.google.android.gms.internal.common.zzx;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.text.v0;
import org.apache.commons.net.ftp.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@KeepForSdk
/* loaded from: D:\Downloads\app\classes5.dex */
public class HttpUtils {
    private static final Pattern zza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern zzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern zzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    @NonNull
    @KeepForSdk
    public static Map<String, String> parse(@NonNull URI uri, @NonNull String str) {
        Map<String, String> map = Collections.EMPTY_MAP;
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && rawQuery.length() > 0) {
            map = new HashMap<>();
            zzx zzc2 = zzx.zzc(zzo.zzb('='));
            Iterator it = zzx.zzc(zzo.zzb(v0.f47960d)).zzb().zzd(rawQuery).iterator();
            while (it.hasNext()) {
                List zzf = zzc2.zzf((String) it.next());
                if (zzf.isEmpty() || zzf.size() > 2) {
                    throw new IllegalArgumentException("bad parameter");
                }
                map.put(zza((String) zzf.get(0), str), zzf.size() == 2 ? zza((String) zzf.get(1), str) : null);
            }
        }
        return map;
    }

    private static String zza(String str, String str2) {
        if (str2 == null) {
            str2 = b.T;
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e6) {
            throw new IllegalArgumentException(e6);
        }
    }

    private HttpUtils() {
    }
}
