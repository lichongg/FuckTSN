package com.kwad.components.ad.reward;

import android.os.Looper;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private final Set<com.kwad.components.ad.reward.e.l> rg;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final b ri = new b(0);
    }

    /* synthetic */ b(byte b6) {
        this();
    }

    private b() {
        this.rg = new HashSet();
    }

    private void gl() {
        if (this.rg.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.l> it = this.rg.iterator();
        while (it.hasNext()) {
            it.next().onRewardVerify();
        }
    }

    public final void a(com.kwad.components.ad.reward.e.l lVar) {
        if (lVar != null) {
            this.rg.add(lVar);
        }
    }

    public final void b(com.kwad.components.ad.reward.e.l lVar) {
        this.rg.remove(lVar);
    }

    public static b gk() {
        return a.ri;
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void notifyRewardVerify() {
        if (isMainThread()) {
            gl();
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.b.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.this.notifyRewardVerify();
                }
            });
        }
    }
}
