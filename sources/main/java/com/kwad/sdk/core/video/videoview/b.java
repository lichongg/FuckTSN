package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b extends RelativeLayout {
    private Runnable ZM;

    @NonNull
    protected final c aKI;

    protected abstract void onPlayStateChanged(int i6);

    protected abstract void reset();

    protected abstract void tx();

    protected final void tE() {
        Runnable runnable = this.ZM;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.ZM = null;
        }
    }

    public b(Context context, @NonNull c cVar) {
        super(context);
        this.aKI = cVar;
    }

    protected final void tD() {
        tE();
        if (this.ZM == null) {
            this.ZM = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.tx();
                    if (b.this.ZM != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.ZM, 1000L);
                    }
                }
            };
        }
        post(this.ZM);
    }

    public void o(int i6, int i7) {
    }
}
