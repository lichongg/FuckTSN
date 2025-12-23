package com.kwad.components.ad.reward.c;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class a {
    private static volatile a uf;
    private g tm;

    @Nullable
    private b ug;
    private volatile boolean uh = false;
    private volatile boolean ui = false;
    private List<WeakReference<j>> uj = new CopyOnWriteArrayList();

    private synchronized boolean hX() {
        b bVar = this.ug;
        if (bVar != null) {
            if (bVar.un == b.uk) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void a(AdTemplate adTemplate, b bVar) {
        if (adTemplate == null) {
            return;
        }
        try {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + bVar.toJson().toString());
            this.ug = bVar;
            if (bVar.un == b.uk && !this.uh) {
                this.uh = true;
                c.a(this.ug, com.kwad.components.ad.reward.e.f.N(adTemplate.getUniqueId()));
                com.kwad.sdk.core.adlog.c.j(adTemplate, isNeoScan());
            }
            for (WeakReference<j> weakReference : this.uj) {
                if (weakReference.get() == null) {
                    this.uj.remove(weakReference);
                } else {
                    b hW = hW();
                    com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "GetNativeDataHandler callback: " + hW.toJson().toString());
                    weakReference.get().a(hW);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(AdTemplate adTemplate, int i6) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: " + i6);
        g gVar = this.tm;
        if (gVar != null && gVar.gW() && i6 == b.STATUS_NONE) {
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "updateExtraReward: cant update to status 2");
            return;
        }
        b hW = hV().hW();
        hW.aa(i6);
        hV().a(adTemplate, hW);
    }

    @NonNull
    public final synchronized b hW() {
        try {
            if (this.ug == null) {
                b hZ = c.hZ();
                this.ug = hZ;
                hZ.un = 0;
            }
            com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "getCurrentExtraReward: " + this.ug.un);
        } catch (Throwable th) {
            throw th;
        }
        return this.ug;
    }

    public final synchronized void reset() {
        this.ug = null;
        this.ui = false;
        this.uh = false;
        this.tm = null;
    }

    public static a hV() {
        if (uf == null) {
            synchronized (a.class) {
                try {
                    if (uf == null) {
                        uf = new a();
                    }
                } finally {
                }
            }
        }
        return uf;
    }

    private boolean isNeoScan() {
        AdGlobalConfigInfo adGlobalConfigInfo = this.tm.mAdResultData.adGlobalConfigInfo;
        return adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1;
    }

    public final void setCallerContext(g gVar) {
        this.tm = gVar;
    }

    private a() {
    }

    public final void R(Context context) {
        boolean hX = hX();
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "checkStatusAndToast isCurrentHadExtra: " + hX + ", hadToast: " + this.ui);
        if (!this.ui && hX) {
            this.ui = true;
            ac.Q(context, "恭喜获得第2份奖励");
        }
    }

    public final void a(j jVar) {
        com.kwad.sdk.core.d.c.d("CurrentExtraRewardHolder", "addGetNativeHandler: " + jVar);
        if (jVar != null) {
            this.uj.add(new WeakReference<>(jVar));
        }
    }
}
