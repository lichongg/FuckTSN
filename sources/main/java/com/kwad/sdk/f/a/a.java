package com.kwad.sdk.f.a;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static volatile a aRe;
    private Activity mActivity;
    private int aRf = 3;
    private int aRg = 3;
    private int aRh = 3;
    private int aRi = 3;
    private AtomicBoolean aRj = new AtomicBoolean(false);
    private boolean aRk = false;
    private AtomicBoolean aRl = new AtomicBoolean(false);
    private AtomicBoolean mHasInit = new AtomicBoolean(false);

    private static boolean dW(int i6) {
        return (i6 & 1) != 0;
    }

    private static boolean dY(int i6) {
        return i6 == 1;
    }

    private static int k(Activity activity) {
        Display display;
        try {
            if (Build.VERSION.SDK_INT < 34) {
                return 3;
            }
            display = activity.getDisplay();
            return display != null ? ((Boolean) z.f(display, "isHdrSdrRatioAvailable", new Object[0])).booleanValue() : false ? 1 : 2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("HdrHelper", "getScreenHdrAvailable error", th);
            return 3;
        }
    }

    public static a Mq() {
        if (aRe == null) {
            synchronized (a.class) {
                try {
                    if (aRe == null) {
                        aRe = new a();
                    }
                } finally {
                }
            }
        }
        return aRe;
    }

    private void Mr() {
        this.aRf = Build.VERSION.SDK_INT;
        com.kwad.sdk.core.c.b.Ho();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.f.a.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                a.this.mActivity = null;
                com.kwad.sdk.core.c.b.Ho();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                super.b(activity);
            }

            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.this.mActivity = activity;
                    if (a.this.aRl.get()) {
                        return;
                    }
                    a aVar = a.this;
                    aVar.aRh = a.b(aVar, activity);
                    a aVar2 = a.this;
                    aVar2.aRg = a.c(aVar2, activity);
                    a.this.Ms();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.e("HdrHelper", "collectHdrAbility error", th);
                }
            }
        });
    }

    private boolean Mt() {
        if (this.aRl.get()) {
            return true;
        }
        this.aRl.set(ag.m("ksadsdk_pref", "hdr_has_reported", false));
        return this.aRl.get();
    }

    static /* synthetic */ int b(a aVar, Activity activity) {
        return k(activity);
    }

    private static boolean dX(int i6) {
        return (i6 & 2) != 0;
    }

    private static int j(Activity activity) {
        int colorMode;
        int colorMode2;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                return 3;
            }
            colorMode = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(2);
            colorMode2 = activity.getWindow().getColorMode();
            activity.getWindow().setColorMode(colorMode);
            return colorMode2 == 2 ? 1 : 2;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e("HdrHelper", "getColorModeSupport error", th);
            return 3;
        }
    }

    private void report() {
        this.aRi = z(this.aRg, this.aRh);
        this.aRf = Build.VERSION.SDK_INT;
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(1.0d).O("ad_sdk_hdr", "stats_ranger").z(new com.kwad.sdk.f.a.a.a(this.aRf, this.aRg, this.aRh, this.aRi)).a(com.kwai.adclient.kscommerciallogger.model.a.bez));
    }

    private static int z(int i6, int i7) {
        return (Build.VERSION.SDK_INT >= 34 && dY(i6) && dY(i7)) ? 1 : 2;
    }

    public final void Ms() {
        if (!this.aRk || Mt()) {
            return;
        }
        report();
        ag.l("ksadsdk_pref", "hdr_has_reported", true);
        this.aRl.set(true);
    }

    public final void init(int i6) {
        if (this.mHasInit.get() || i6 == 0) {
            return;
        }
        Mr();
        if (dW(i6)) {
            this.aRk = true;
        }
        if (dX(i6)) {
            this.aRj.set(true);
        }
        this.mHasInit.set(true);
    }

    static /* synthetic */ int c(a aVar, Activity activity) {
        return j(activity);
    }
}
