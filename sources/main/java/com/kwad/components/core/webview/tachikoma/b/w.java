package com.kwad.components.core.webview.tachikoma.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class w implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c agJ;

    @NonNull
    private CopyOnWriteArrayList<com.kwad.sdk.core.b> agK = new CopyOnWriteArrayList<>();

    @Override // com.kwad.sdk.core.webview.c.a
    public void onDestroy() {
        this.agJ = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.agJ = cVar;
        if (this.agK.size() > 0) {
            Iterator<com.kwad.sdk.core.b> it = this.agK.iterator();
            while (it.hasNext()) {
                com.kwad.sdk.core.b next = it.next();
                b(next);
                this.agK.remove(next);
            }
        }
    }

    public final void b(final com.kwad.sdk.core.b bVar) {
        if (this.agJ != null) {
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.b.w.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (w.this.agJ != null) {
                        w.this.agJ.a(bVar);
                    }
                }
            });
        } else {
            this.agK.add(bVar);
        }
    }
}
