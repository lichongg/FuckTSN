package com.tencent.open.b;

import com.tencent.open.utils.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f {
    public static int a(String str) {
        int a6;
        if (com.tencent.open.utils.g.a() == null || (a6 = i.a(com.tencent.open.utils.g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a6;
    }

    public static int a() {
        int a6 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
        if (a6 == 0) {
            return 2;
        }
        return a6;
    }
}
