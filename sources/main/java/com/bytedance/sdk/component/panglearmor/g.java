package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    private static AtomicInteger cw = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    private static volatile g f26687j;
    private static volatile boolean xt;

    public static g j() {
        if (f26687j == null) {
            synchronized (g.class) {
                try {
                    if (f26687j == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            com.bytedance.sdk.openadsdk.l.m.j("panglearmor");
                            xt = true;
                            cw.set(1);
                        } catch (Throwable unused) {
                            xt = false;
                            cw.set(2);
                        }
                        f26687j = new g();
                        long currentTimeMillis2 = System.currentTimeMillis();
                        tl ae = m.ae();
                        if (ae != null) {
                            ae.j(currentTimeMillis2 - currentTimeMillis, xt);
                        }
                    }
                } finally {
                }
            }
        }
        return f26687j;
    }

    public static boolean xt() {
        return xt;
    }

    public static int cw() {
        return cw.get();
    }

    public byte[] xt(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && xt) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private g() {
    }

    public byte[] j(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && xt) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String j(String str) {
        if (str != null && str.length() != 0 && xt) {
            try {
                byte[] xt2 = xt(Base64.decode(str, 0));
                if (xt2 != null) {
                    return new String(xt2);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
