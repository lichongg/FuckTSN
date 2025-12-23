package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.stub.StubApp;
import java.io.File;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    private static int ae = 0;
    private static boolean cw = true;

    /* renamed from: g, reason: collision with root package name */
    private static com.bytedance.adsdk.lottie.cw.m f23547g = null;

    /* renamed from: j, reason: collision with root package name */
    public static boolean f23548j = false;

    /* renamed from: m, reason: collision with root package name */
    private static long[] f23549m = null;
    private static com.bytedance.adsdk.lottie.cw.up oq = null;
    private static volatile com.bytedance.adsdk.lottie.cw.tl qv = null;

    /* renamed from: r, reason: collision with root package name */
    private static boolean f23550r = true;
    private static int tl;
    private static String[] up;
    private static volatile com.bytedance.adsdk.lottie.cw.ae vl;
    private static boolean xt;

    public static void j(String str) {
        if (xt) {
            int i6 = ae;
            if (i6 == 20) {
                tl++;
                return;
            }
            up[i6] = str;
            f23549m[i6] = System.nanoTime();
            Trace.beginSection(str);
            ae++;
        }
    }

    public static float xt(String str) {
        int i6 = tl;
        if (i6 > 0) {
            tl = i6 - 1;
            return 0.0f;
        }
        if (!xt) {
            return 0.0f;
        }
        int i7 = ae - 1;
        ae = i7;
        if (i7 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(up[i7])) {
            Trace.endSection();
            return (System.nanoTime() - f23549m[ae]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + up[ae] + ".");
    }

    public static com.bytedance.adsdk.lottie.cw.tl j(Context context) {
        com.bytedance.adsdk.lottie.cw.tl tlVar;
        com.bytedance.adsdk.lottie.cw.tl tlVar2 = qv;
        if (tlVar2 != null) {
            return tlVar2;
        }
        synchronized (com.bytedance.adsdk.lottie.cw.tl.class) {
            try {
                tlVar = qv;
                if (tlVar == null) {
                    com.bytedance.adsdk.lottie.cw.ae xt2 = xt(context);
                    com.bytedance.adsdk.lottie.cw.m mVar = f23547g;
                    if (mVar == null) {
                        mVar = new com.bytedance.adsdk.lottie.cw.xt();
                    }
                    tlVar = new com.bytedance.adsdk.lottie.cw.tl(xt2, mVar);
                    qv = tlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tlVar;
    }

    public static com.bytedance.adsdk.lottie.cw.ae xt(Context context) {
        com.bytedance.adsdk.lottie.cw.ae aeVar;
        if (!cw) {
            return null;
        }
        final Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.bytedance.adsdk.lottie.cw.ae aeVar2 = vl;
        if (aeVar2 != null) {
            return aeVar2;
        }
        synchronized (com.bytedance.adsdk.lottie.cw.ae.class) {
            try {
                aeVar = vl;
                if (aeVar == null) {
                    com.bytedance.adsdk.lottie.cw.up upVar = oq;
                    if (upVar == null) {
                        upVar = new com.bytedance.adsdk.lottie.cw.up() { // from class: com.bytedance.adsdk.lottie.up.1
                            @Override // com.bytedance.adsdk.lottie.cw.up
                            public File j() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.xt.xt(origApplicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    aeVar = new com.bytedance.adsdk.lottie.cw.ae(upVar);
                    vl = aeVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return aeVar;
    }

    public static boolean j() {
        return f23550r;
    }
}
