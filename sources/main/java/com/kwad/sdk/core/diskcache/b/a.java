package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.be;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aDg;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    static final class C0680a {
        static final a aDh = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    private synchronized void init(Context context) {
        if (this.aDg != null || context == null) {
            return;
        }
        try {
            this.aDg = com.kwad.sdk.core.diskcache.a.a.a(be.dE(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    private a() {
    }

    public static a GP() {
        return C0680a.aDh;
    }

    private boolean GQ() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aDg == null;
    }

    @Nullable
    private File dH(String str) {
        if (!GQ() && !TextUtils.isEmpty(str)) {
            return b.a(this.aDg, str);
        }
        return null;
    }

    public final boolean a(String str, a.C0688a c0688a) {
        File dH;
        if (!GQ() && !TextUtils.isEmpty(str)) {
            String dI = c.dI(str);
            if (b.a(this.aDg, str, dI, c0688a) && (dH = dH(dI)) != null && dH.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0688a c0688a) {
        File dH;
        if (!GQ() && !TextUtils.isEmpty(str)) {
            String dI = c.dI(str2);
            if (b.a(this.aDg, str, dI, c0688a) && (dH = dH(dI)) != null && dH.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File cf(String str) {
        if (!GQ() && !TextUtils.isEmpty(str)) {
            return dH(c.dI(str));
        }
        return null;
    }

    public final void dG(String str) {
        if (!GQ() && !TextUtils.isEmpty(str)) {
            b.a(this.aDg, str, c.dI(str));
        }
    }

    public final void delete() {
        if (!GQ()) {
            try {
                this.aDg.delete();
            } catch (IOException unused) {
            }
        }
    }

    public final boolean remove(String str) {
        if (GQ()) {
            return false;
        }
        try {
            ax.ax(str, "cacheKey is not allowed empty");
            return this.aDg.remove(c.dI(str));
        } catch (IOException unused) {
            return false;
        }
    }
}
