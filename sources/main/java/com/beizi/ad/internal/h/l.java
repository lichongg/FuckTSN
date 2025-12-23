package com.beizi.ad.internal.h;

import android.text.TextUtils;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l {
    public static void a(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6);
            com.beizi.ad.lance.a.m.a("ReportEventUtil", "ReportEventUtil:" + str);
            if (!TextUtils.isEmpty(str)) {
                new com.beizi.ad.internal.i(q.a(str, "", "", "", "", "", "", "")).executeOnExecutor(com.beizi.ad.lance.a.c.b().f(), new Void[0]);
            }
        }
    }
}
