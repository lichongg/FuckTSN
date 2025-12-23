package com.kwad.sdk.core.response.b;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    private static volatile f aIO;
    private String aIP = IU();

    public static f IS() {
        if (aIO == null) {
            synchronized (f.class) {
                try {
                    if (aIO == null) {
                        aIO = new f();
                    }
                } finally {
                }
            }
        }
        return aIO;
    }

    @Nullable
    @WorkerThread
    private static String IU() {
        try {
            return w.a(new File(be.dJ(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), Charset.forName("UTF-8"));
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
            return null;
        }
    }

    @WorkerThread
    private static void eA(String str) {
        try {
            w.a(new File(be.dJ(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())), str, Charset.forName("UTF-8"), false);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    @Nullable
    @WorkerThread
    public final String IT() {
        return this.aIP;
    }

    @WorkerThread
    public final void ez(String str) {
        if (bp.isEquals(this.aIP, str)) {
            return;
        }
        this.aIP = str;
        eA(str);
    }

    private f() {
    }
}
