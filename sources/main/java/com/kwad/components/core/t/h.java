package com.kwad.components.core.t;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class h {
    private long Ek;
    private a YN;
    private long YL = 100;
    private long YM = 0;
    private boolean QC = false;

    @Nullable
    private Handler YO = new Handler(Looper.getMainLooper());
    private Runnable YP = new Runnable() { // from class: com.kwad.components.core.t.h.1
        @Override // java.lang.Runnable
        public final void run() {
            if (h.this.YO == null) {
                return;
            }
            if (h.this.QC) {
                h.this.YO.postDelayed(this, h.this.YL / 2);
                return;
            }
            h.this.td();
            if (h.this.YO != null) {
                h.this.YO.postDelayed(this, h.this.YL);
            }
        }
    };

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void onProgress(long j6, long j7);
    }

    public final void pause() {
        this.QC = true;
    }

    public final void resume() {
        this.QC = false;
    }

    public final void a(a aVar) {
        this.YN = aVar;
    }

    public final void start() {
        Handler handler = this.YO;
        if (handler == null) {
            return;
        }
        handler.post(this.YP);
    }

    public final void stop() {
        Handler handler = this.YO;
        if (handler != null) {
            handler.removeCallbacks(this.YP);
            this.YO = null;
        }
    }

    protected final void td() {
        a aVar = this.YN;
        if (aVar != null) {
            long j6 = this.Ek;
            long j7 = j6 - this.YM;
            aVar.onProgress(j7, j6);
            if (j7 <= 0) {
                stop();
            }
        }
        this.YM += this.YL;
    }

    public h(long j6) {
        this.Ek = j6;
    }
}
