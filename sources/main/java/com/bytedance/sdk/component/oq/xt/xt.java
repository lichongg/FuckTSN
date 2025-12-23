package com.bytedance.sdk.component.oq.xt;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.l;
import java.lang.ref.WeakReference;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends l implements cw {
    private final HandlerThread xt;

    @Override // com.bytedance.sdk.component.oq.xt.cw
    public void j() {
        removeCallbacksAndMessages(null);
        WeakReference<l.j> weakReference = this.f26890j;
        if (weakReference != null) {
            weakReference.clear();
            this.f26890j = null;
        }
    }

    public void xt() {
        HandlerThread handlerThread = this.xt;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    xt(HandlerThread handlerThread, l.j jVar) {
        super(handlerThread.getLooper(), jVar);
        this.xt = handlerThread;
    }

    public void j(l.j jVar) {
        this.f26890j = new WeakReference<>(jVar);
    }
}
