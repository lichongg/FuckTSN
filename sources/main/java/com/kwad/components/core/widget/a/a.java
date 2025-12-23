package com.kwad.components.core.widget.a;

import android.os.Message;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.ca;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class a implements com.kwad.sdk.core.j.a, ca.a {
    private Set<c> ajp;
    private final int ajq;
    private final View mRootView;
    private final AtomicBoolean ajo = new AtomicBoolean(false);
    protected final ca bQ = new ca(this);

    public void a(Message message) {
        if (message.what == 666) {
            wh();
            this.bQ.sendEmptyMessageDelayed(TTAdConstant.STYLE_SIZE_RADIO_2_3, 500L);
        }
    }

    public abstract boolean ae();

    private void bc(boolean z5) {
        Set<c> set = this.ajp;
        if (set == null) {
            return;
        }
        for (c cVar : set) {
            if (cVar != null) {
                if (z5) {
                    cVar.bt();
                } else {
                    cVar.bu();
                }
            }
        }
    }

    private void ki() {
        if (this.ajo.getAndSet(true)) {
            return;
        }
        bc(true);
    }

    private void wk() {
        if (this.ajo.getAndSet(false)) {
            bc(false);
        }
    }

    public final void wi() {
        this.bQ.removeMessages(TTAdConstant.STYLE_SIZE_RADIO_2_3);
        this.bQ.sendEmptyMessage(TTAdConstant.STYLE_SIZE_RADIO_2_3);
    }

    @Override // com.kwad.sdk.core.j.a
    @MainThread
    public final boolean wl() {
        return this.ajo.get();
    }

    public a(@NonNull View view, int i6) {
        this.mRootView = view;
        this.ajq = i6;
    }

    @Override // com.kwad.sdk.core.j.a
    @MainThread
    public final void b(c cVar) {
        Set<c> set;
        ap.checkUiThread();
        if (cVar != null && (set = this.ajp) != null) {
            set.remove(cVar);
        }
    }

    @Override // com.kwad.sdk.core.j.a
    @CallSuper
    public final void release() {
        wj();
        Set<c> set = this.ajp;
        if (set != null) {
            set.clear();
        }
    }

    public final void wh() {
        if (ae()) {
            ki();
        } else {
            wk();
        }
    }

    public final void wj() {
        wh();
        this.bQ.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.j.a
    @MainThread
    public final void a(final c cVar) {
        ap.checkUiThread();
        if (cVar == null) {
            return;
        }
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.core.widget.a.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.this.ae()) {
                    cVar.bt();
                } else {
                    cVar.bu();
                }
            }
        });
        if (this.ajp == null) {
            this.ajp = new HashSet();
        }
        this.ajp.add(cVar);
    }
}
