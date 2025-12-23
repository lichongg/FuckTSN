package com.beizi.ad.lance.a;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class n {
    public static String a(Context context) {
        String b6;
        if (context == null) {
            return "";
        }
        String d6 = com.beizi.ad.f.a() != null ? com.beizi.ad.f.a().d() : null;
        return !TextUtils.isEmpty(d6) ? d6 : ((com.beizi.ad.f.a() == null || (!com.beizi.ad.f.b() && com.beizi.ad.f.a().c())) && (b6 = com.beizi.ad.internal.h.m.b(context, "__OAID__")) != null) ? b6 : "";
    }

    public static String b(Context context) {
        String b6;
        return context == null ? "" : ((com.beizi.ad.f.a() == null || (!com.beizi.ad.f.b() && com.beizi.ad.f.a().c())) && (b6 = com.beizi.ad.internal.h.m.b(context, "__HONOROAID__")) != null) ? b6 : "";
    }
}
