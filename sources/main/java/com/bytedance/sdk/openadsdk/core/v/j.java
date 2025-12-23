package com.bytedance.sdk.openadsdk.core.v;

import android.os.SystemClock;
import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.i;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    private static volatile long f30950j = 0;
    private static volatile String xt = "0";

    /* renamed from: com.bytedance.sdk.openadsdk.core.v.j$j, reason: collision with other inner class name */
    public static class C0488j implements g {
        @Override // com.bytedance.sdk.component.xt.j.g
        public av j(g.j jVar) throws IOException {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ws j6 = jVar.j();
            av j7 = jVar.j(j6);
            if ("GET".equalsIgnoreCase(j6.cw())) {
                i m6 = j7.m();
                if (m6 == null) {
                    return j7;
                }
                long j8 = m6.j();
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (elapsedRealtime2 > 0 && j8 > 10240) {
                    String unused = j.xt = String.format("%.2f", Double.valueOf(((j8 / 1024.0d) / elapsedRealtime2) * 1000.0d));
                    long unused2 = j.f30950j = System.currentTimeMillis();
                    String unused3 = j.xt;
                }
            }
            return j7;
        }
    }

    public static String j() {
        if (System.currentTimeMillis() - f30950j < 7200000) {
            return xt;
        }
        return "0";
    }
}
