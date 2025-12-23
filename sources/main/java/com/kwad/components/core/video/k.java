package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.al;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class k {
    private static Map<String, Integer> abh = new ConcurrentHashMap();

    public static boolean a(@NonNull String str, String str2, a.C0688a c0688a) {
        String md5 = al.md5(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "start cache video key:" + md5 + "--url:" + str);
        boolean b6 = com.kwad.sdk.core.diskcache.b.a.GP().b(str, str2, c0688a);
        com.kwad.sdk.core.d.c.i("VideoCacheHelper", "finish cache video key:" + md5 + "--cache time:" + (System.currentTimeMillis() - currentTimeMillis) + "--success:" + b6);
        return b6;
    }

    private static int aM(String str) {
        Integer num = abh.get(str);
        return num != null ? num.intValue() : com.kwad.sdk.core.config.e.BQ();
    }

    public static void m(String str, int i6) {
        abh.put(str, Integer.valueOf(i6));
    }

    public static boolean aL(@NonNull AdTemplate adTemplate) {
        File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        if (cf != null && cf.exists()) {
            return true;
        }
        return false;
    }

    public static String g(Context context, @NonNull AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.eB(adTemplate), com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate)));
    }

    public static String h(Context context, String str) {
        return a(context, aM(str), str);
    }

    private static String a(Context context, int i6, String str) {
        if (i6 < 0) {
            File cf = com.kwad.sdk.core.diskcache.b.a.GP().cf(str);
            if (cf != null && cf.exists()) {
                return cf.getAbsolutePath();
            }
        } else if (i6 > 0) {
            return com.kwad.sdk.core.videocache.c.a.bR(context).eJ(str);
        }
        return str;
    }
}
