package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class i {
    public static d a(Context context, String str, JSONObject jSONObject, cw cwVar) {
        if (cwVar != null && context != null && jSONObject != null) {
            String qv = cwVar.qv();
            if (!TextUtils.isEmpty(qv) && !TextUtils.isEmpty(str)) {
                File file = new File(qv);
                com.ss.android.socialbase.downloader.jy.j j6 = com.ss.android.socialbase.downloader.jy.j.j(cwVar);
                if (str.equals("v1")) {
                    return new g(context, j6, cwVar.ws());
                }
                if (str.equals("v2")) {
                    return new h(context, j6, file.getAbsolutePath());
                }
                if (str.equals(com.huawei.hms.feature.dynamic.b.f33222u)) {
                    return new l(context, j6, file.getAbsolutePath());
                }
                if (str.equals("o1")) {
                    return new a(context, j6, file.getAbsolutePath());
                }
                if (str.equals("o2")) {
                    return new j(context, j6, file.getAbsolutePath());
                }
                if (str.equals("o3")) {
                    String ws = cwVar.ws("file_content_uri");
                    if (!TextUtils.isEmpty(ws)) {
                        return new c(context, j6, file.getAbsolutePath(), ws, cwVar.tl());
                    }
                } else {
                    if (str.equals("custom")) {
                        return new b(context, j6, file.getAbsolutePath(), jSONObject);
                    }
                    if (str.equals("vbi")) {
                        return new e(context, j6, com.ss.android.socialbase.appdownloader.b.n(cwVar.ae(), ae.xt(context).vl(cwVar.ae()), context, com.ss.android.socialbase.appdownloader.f.L().P(), new File(cwVar.qv() + File.separator + cwVar.tl())).toString());
                    }
                }
            }
        }
        return null;
    }

    public static boolean b(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.jy.j jVar) {
        if (context != null && str != null) {
            String L = com.ss.android.socialbase.appdownloader.b.L();
            if (!TextUtils.isEmpty(L) && !TextUtils.isEmpty(str)) {
                d gVar = (com.ss.android.socialbase.appdownloader.m.e.p() && str.equals("v1")) ? new g(context, jVar, L) : (com.ss.android.socialbase.appdownloader.m.e.p() && str.equals("v2")) ? new h(context, jVar, L) : (com.ss.android.socialbase.appdownloader.m.e.p() && str.equals(com.huawei.hms.feature.dynamic.b.f33222u)) ? new l(context, jVar, L) : (com.ss.android.socialbase.appdownloader.m.e.r() && str.equals("o1")) ? new a(context, jVar, L) : (com.ss.android.socialbase.appdownloader.m.e.r() && str.equals("o2")) ? new j(context, jVar, L) : (com.ss.android.socialbase.appdownloader.m.e.r() && str.equals("o3")) ? new c(context, jVar, L, L, L) : (com.ss.android.socialbase.appdownloader.m.e.p() && str.equals("custom")) ? new b(context, jVar, L, jSONObject) : (com.ss.android.socialbase.appdownloader.m.e.p() && str.equals("vbi")) ? new e(context, jVar, L) : null;
                if (gVar != null && gVar.a()) {
                    return true;
                }
            }
        }
        return false;
    }
}
