package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ai {
    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(bd.dq(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.m125do(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bd.getOaid())) {
            if (str2.contains("__OAID__")) {
                arrayList.add("__OAID__");
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (TextUtils.isEmpty(bd.dp(context))) {
            return;
        }
        if (str2.contains("__ANDROIDID__")) {
            arrayList.add("__ANDROIDID__");
        }
        if (str2.contains("__ANDROIDID2__")) {
            arrayList.add("__ANDROIDID2__");
        }
        if (str2.contains("__ANDROIDID3__")) {
            arrayList.add("__ANDROIDID3__");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.kwad.sdk.commercial.j.a.a(adTemplate, "ANDROID", str, str2, (String) it4.next());
        }
        arrayList.clear();
    }

    @WorkerThread
    public static String a(Context context, String str, aj.a aVar, boolean z5) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String ao = aj.ao(context, aj.a(str, aVar));
        String dq = bd.dq(context);
        if (!TextUtils.isEmpty(dq)) {
            ao = ao.replace("__MAC__", dq).replace("__MAC2__", al.md5(dq)).replace("__MAC3__", al.md5(dq.replace(":", "")));
        }
        String m125do = bd.m125do(context);
        if (!TextUtils.isEmpty(m125do)) {
            ao = ao.replace("__IMEI__", m125do).replace("__IMEI2__", al.md5(m125do)).replace("__IMEI3__", al.sha1(m125do));
        }
        String oaid = bd.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            ao = ao.replace("__OAID__", oaid).replace("__OAID2__", al.md5(oaid));
        }
        String dp = bd.dp(context);
        if (!TextUtils.isEmpty(dp)) {
            ao = ao.replace("__ANDROIDID2__", al.md5(dp)).replace("__ANDROIDID3__", al.sha1(dp)).replace("__ANDROIDID__", dp);
        }
        return aj.c(context, ao, z5);
    }
}
