package com.kwad.sdk.crash.online.monitor.block;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static List<String> aPK = null;
    private static List<String> aPL = null;
    private static int aPM = 5;

    public static void a(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        aPK = new ArrayList();
        List<String> list = aVar.aPX;
        if (list == null || list.isEmpty()) {
            aPK.add("com.kwad");
            aPK.add("com.kwai");
            aPK.add("com.ksad");
            aPK.add("tkruntime");
            aPK.add("tachikoma");
            aPK.add("kuaishou");
        } else {
            aPK.addAll(aVar.aPX);
        }
        aPM = aVar.aQc;
        aPL = new ArrayList();
        List<String> list2 = aVar.aPW;
        if (list2 != null && !list2.isEmpty()) {
            aPL.addAll(aVar.aPW);
            return;
        }
        aPL.add("android.");
        aPL.add("androidx.");
        aPL.add("org.");
        aPL.add("java.");
    }

    private static boolean fG(String str) {
        List<String> list = aPL;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean fH(String str) {
        List<String> list = aPK;
        if (list == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String fI(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(com.snail.antifake.deviceid.e.f37542d);
        com.kwad.sdk.core.d.c.d("perfMonitor.Filter", "stacks after split:" + split.length);
        boolean z5 = false;
        int i6 = 0;
        for (String str2 : split) {
            if (z5 || !fG(str2)) {
                if (i6 >= aPM) {
                    return "";
                }
                if (fH(str2)) {
                    return str;
                }
                i6++;
                z5 = true;
            }
        }
        return "";
    }
}
