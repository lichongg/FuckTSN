package com.kwad.components.ad.reward;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private final Set<com.kwad.components.ad.reward.e.j> rb;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.reward.a$a, reason: collision with other inner class name */
    static class C0578a {
        private static final a rf = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    public final void b(com.kwad.components.ad.reward.e.j jVar) {
        this.rb.remove(jVar);
    }

    public final void c(final PlayableSource playableSource, @Nullable final com.kwad.components.ad.reward.e.n nVar) {
        if (isMainThread()) {
            b(playableSource, nVar);
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.b(playableSource, nVar);
                }
            });
        }
    }

    private a() {
        this.rb = new HashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().a(playableSource, nVar);
        }
    }

    private void gi() {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().dk();
        }
    }

    public static a gg() {
        return C0578a.rf;
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public final void a(com.kwad.components.ad.reward.e.j jVar) {
        if (jVar != null) {
            this.rb.add(jVar);
        }
    }

    public final void gh() {
        if (isMainThread()) {
            gi();
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.2
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.gh();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(PlayableSource playableSource) {
        if (this.rb.size() == 0) {
            return;
        }
        Iterator<com.kwad.components.ad.reward.e.j> it = this.rb.iterator();
        while (it.hasNext()) {
            it.next().dl();
        }
    }

    public final void a(PlayableSource playableSource) {
        c(playableSource, null);
    }

    public final void b(final PlayableSource playableSource) {
        if (isMainThread()) {
            c(playableSource);
        } else {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.reward.a.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.c(playableSource);
                }
            });
        }
    }
}
