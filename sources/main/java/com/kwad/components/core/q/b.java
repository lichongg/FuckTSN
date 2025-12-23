package com.kwad.components.core.q;

import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.api.core.SpeedLimitApi;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class b {
    private static volatile b XJ = null;
    private static volatile int XK = 204800;
    static volatile boolean XL = true;
    static volatile boolean XM;
    static volatile Set<c> XN = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    public final synchronized int sB() {
        int i6;
        i6 = 0;
        try {
            Iterator<c> it = XN.iterator();
            while (it.hasNext()) {
                i6 += (int) it.next().sC();
            }
        } catch (Exception unused) {
        }
        return i6;
    }

    public static synchronized void a(c cVar) {
        synchronized (b.class) {
            if (XN.contains(cVar)) {
                XN.remove(cVar);
            }
        }
    }

    public static void f(boolean z5, int i6) {
        if (i6 > 0) {
            XK = i6 * 1024;
        }
        XL = z5;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initModeImplForInvoker")
    public static void register() {
        try {
            com.kwad.sdk.service.c.b(SpeedLimitApi.class, a.class);
        } catch (Throwable unused) {
        }
    }

    public static int sA() {
        return XK / 1024;
    }

    public static b sy() {
        if (XJ == null) {
            synchronized (b.class) {
                try {
                    if (XJ == null) {
                        XJ = new b();
                    }
                } finally {
                }
            }
        }
        return XJ;
    }

    public static boolean sz() {
        return XL;
    }

    private static synchronized InputStream wrap(@NonNull InputStream inputStream) {
        c cVar;
        synchronized (b.class) {
            cVar = new c(inputStream, XK / (XN.size() + 1));
            XN.add(cVar);
        }
        return cVar;
    }

    public static InputStream wrapInputStream(InputStream inputStream) {
        return wrap(inputStream);
    }
}
