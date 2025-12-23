package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.c.r;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final Set<com.kwad.components.ad.reward.e.m> rj;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final c rm = new c(0);
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    public final void b(com.kwad.components.ad.reward.e.m mVar) {
        this.rj.remove(mVar);
    }

    private c() {
        this.rj = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@Nullable r rVar) {
        if (this.rj.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.m> it = this.rj.iterator();
        while (it.hasNext()) {
            it.next().a(rVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.e.m mVar) {
        if (mVar != null) {
            this.rj.add(mVar);
        }
    }

    public final void c(@Nullable final r rVar) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.b(rVar);
            }
        });
    }

    public static c gn() {
        return a.rm;
    }
}
