package com.kwad.sdk.o;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.l3;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Resources bdQ;
    private Resources bdR;
    private i bdS;
    private boolean bdT;
    private ClassLoader bdU;
    private boolean bdV;
    private final AtomicBoolean mHasInit;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final f bdW = new f(0);
    }

    /* synthetic */ f(byte b6) {
        this();
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.bdV = com.kwad.framework.a.a.alb.booleanValue();
    }

    private boolean BM() {
        boolean Bk = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk();
        if (!this.bdV || Bk) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BM();
        }
        return false;
    }

    private static boolean BN() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BN();
    }

    private boolean SV() {
        Context Pp;
        Object a6;
        try {
            Pp = ServiceProvider.Pp();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!m.eo(Pp)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Resources resources = null;
        Object invoke = cls.getDeclaredMethod(l3.f4736f, null).invoke(null, null);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (a6 = z.a(field, invoke)) != null) {
                for (Field field2 : a6.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        String v5 = com.kwad.sdk.o.a.v(Pp, u.aX(Pp));
                        if (TextUtils.isEmpty(v5)) {
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                        } else {
                            resources = com.kwad.library.b.b.a.a(Pp, Pp.getResources(), v5);
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                        }
                        if (resources == null) {
                            resources = (Resources) field2.get(a6);
                        }
                        Resources resources2 = Pp.getResources();
                        i iVar = new i(resources, resources2);
                        z.a(field2, a6, iVar);
                        this.bdQ = resources2;
                        this.bdR = resources;
                        this.bdS = iVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean Rw() {
        return this.mHasInit.get();
    }

    public final boolean ST() {
        return this.bdV;
    }

    public final ClassLoader getClassLoader() {
        return this.bdU;
    }

    public final Resources getResources() {
        boolean Bk = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.bdV + ", mHostResources: " + this.bdQ + ", isExternal: " + Bk);
        return (!this.bdV || Bk) ? this.bdS : this.bdQ;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Bk()) {
                if (BM() && SV()) {
                    this.bdU = getClass().getClassLoader();
                    j.ct(BN());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.bdT = true;
                } else {
                    this.bdT = false;
                }
            } else if (this.bdV) {
                j.ct(true);
                SU();
                this.bdU = getClass().getClassLoader();
                this.bdT = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    @NonNull
    public String toString() {
        return "KSPlugin{mHostResources=" + this.bdQ + ", mResResources=" + this.bdR + ", mPluginResources=" + this.bdS + ", mEnable=" + this.bdT + '}';
    }

    public static f SS() {
        return a.bdW;
    }

    private boolean SU() {
        Context Pp = ServiceProvider.Pp();
        if (!m.eo(Pp)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        this.bdQ = Pp.getResources();
        return true;
    }
}
