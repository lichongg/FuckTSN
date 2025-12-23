package com.kwad.components.core.webview.tachikoma.e;

import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c {
    private final Set<g> ahQ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final c ahW = new c(0);
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    public final void b(g gVar) {
        this.ahQ.remove(gVar);
    }

    private c() {
        this.ahQ = new CopyOnWriteArraySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, long j6, long j7, long j8) {
        if (this.ahQ.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.ahQ).iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(str, j6, j7, j8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str, String str2) {
        if (this.ahQ.size() == 0) {
            return;
        }
        Iterator it = new HashSet(this.ahQ).iterator();
        while (it.hasNext()) {
            ((g) it.next()).v(str2);
        }
    }

    public final void c(final String str, final long j6, final long j7, final long j8) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.c.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.b(str, j6, j7, j8);
            }
        });
    }

    public final void t(final String str, final String str2) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.s(str, str2);
            }
        });
    }

    public final void vP() {
        this.ahQ.clear();
    }

    public static c vO() {
        return a.ahW;
    }

    public final void a(g gVar) {
        if (gVar != null) {
            this.ahQ.add(gVar);
        }
    }
}
