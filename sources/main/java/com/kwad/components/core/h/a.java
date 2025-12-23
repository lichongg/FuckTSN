package com.kwad.components.core.h;

import android.os.Handler;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a implements Runnable {
    private InterfaceC0617a QE;

    @Nullable
    private volatile Handler iK;
    private long QB = 1000;
    private boolean QC = true;
    private long QD = 0;
    private float mSpeed = 1.0f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    public interface InterfaceC0617a {
        void D(long j6);
    }

    public final void pause() {
        this.QC = true;
    }

    public final void resume() {
        this.QC = false;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        InterfaceC0617a interfaceC0617a;
        try {
            if (this.iK != null) {
                if (!this.QC && (interfaceC0617a = this.QE) != null) {
                    interfaceC0617a.D(this.QD);
                    this.QD += this.QB;
                }
                if (this.iK != null) {
                    this.iK.postDelayed(this, (long) (this.QB / this.mSpeed));
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setSpeed(float f6) {
        if (f6 > 0.0f) {
            this.mSpeed = f6;
        }
    }

    public final void start() {
        this.QC = false;
        if (this.iK != null) {
            this.iK.post(this);
        }
    }

    public final void a(InterfaceC0617a interfaceC0617a) {
        this.QE = interfaceC0617a;
    }

    public final void stop() {
        if (this.iK != null) {
            this.iK.removeCallbacks(this);
        }
    }

    public a(Handler handler) {
        this.iK = handler;
    }

    public final void destroy() {
        stop();
        this.iK = null;
    }
}
