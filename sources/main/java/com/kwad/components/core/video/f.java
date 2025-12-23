package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class f extends com.kwad.components.core.video.a implements ca.a {
    private boolean HY;
    private boolean aaI;
    private boolean aaJ;
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a extends a.c {
        void onVideoPlayError(int i6, int i7);
    }

    private void tV() {
        this.HY = false;
    }

    private void aa() {
        if (this.bR.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewAttached");
            this.bQ.sendEmptyMessage(1);
        }
    }

    private void ab() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onViewDetached");
        this.bQ.removeCallbacksAndMessages(null);
        release();
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (!this.HY && message.what == 1) {
            if (this.aaJ) {
                this.bQ.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            if (bz.o(this.bP, 70)) {
                ac();
            } else {
                tw();
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    protected final void fA() {
        if (this.aaI) {
            super.fA();
        }
    }

    public final void setShowLandingPage(boolean z5) {
        this.aaJ = z5;
    }

    public f(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar) {
        super(context, adTemplate, cVar);
        this.bQ = new ca(this);
        this.bR = new AtomicBoolean(true);
        this.HY = false;
        this.aaI = false;
        this.aaJ = false;
        this.bP = this;
    }

    @Override // com.kwad.components.core.video.a
    public final void ac() {
        super.ac();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onAttachedToWindow");
        tV();
        aa();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onDetachedFromWindow");
        ab();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onFinishTemporaryDetach");
        aa();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("InterstitialVideoPlayerController", "onStartTemporaryDetach");
        ab();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
    }

    @Override // com.kwad.components.core.video.a
    public final void release() {
        super.release();
        this.HY = true;
    }

    @Override // com.kwad.components.core.video.a
    protected final void tq() {
        super.tq();
        ImageView imageView = this.pz;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ksad_interstitial_video_play);
        }
        TextView textView = this.pA;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void tw() {
        super.tw();
    }
}
