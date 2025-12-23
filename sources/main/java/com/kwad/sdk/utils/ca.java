package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ca extends Handler {
    private WeakReference<a> bbJ;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void a(Message message);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        WeakReference<a> weakReference;
        a aVar;
        try {
            weakReference = this.bbJ;
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTrace(e6);
        }
        if (weakReference == null || (aVar = weakReference.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }

    public ca(a aVar) {
        this.bbJ = new WeakReference<>(aVar);
    }
}
