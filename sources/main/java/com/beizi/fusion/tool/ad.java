package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.d.a.b;
import com.beizi.fusion.model.RequestInfo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    static String f13584a = "OaidUtil";

    /* renamed from: c, reason: collision with root package name */
    private static String f13586c;

    /* renamed from: b, reason: collision with root package name */
    public static b.a f13585b = new b.a() { // from class: com.beizi.fusion.tool.ad.1
        @Override // com.beizi.fusion.d.a.b.a
        public void a(@NonNull String str) {
            String str2 = ad.f13584a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String unused = ad.f13586c = str;
            Context e6 = com.beizi.fusion.c.b.a().e();
            an.a(e6, "__OAID__", (Object) ad.f13586c);
            an.a(e6, "__CNOAID__", (Object) ad.f13586c);
            if (RequestInfo.getInstance(e6).getDevInfo() != null) {
                if (ae.b() && BeiZis.isLimitPersonalAds()) {
                    return;
                }
                RequestInfo.getInstance(e6).getDevInfo().setOaid(ad.f13586c);
                RequestInfo.getInstance(e6).getDevInfo().setCnOaid(ad.f13586c);
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private static boolean f13587d = true;
}
