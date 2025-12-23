package com.kwad.components.ad.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends com.kwad.components.core.video.a implements ca.a {
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;
    private boolean bS;
    private boolean bT;
    private final KsAdVideoPlayConfig bU;

    private void aa() {
        if (this.bR.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewAttached");
            this.bQ.sendEmptyMessage(1);
        }
    }

    private void ab() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onViewDetached");
        this.bQ.removeCallbacksAndMessages(null);
        if (this.bT) {
            release();
        } else {
            this.aKI.pause();
        }
    }

    private boolean ad() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.bU;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return ao.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return ao.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? ao.isNetworkConnected(this.mContext) : ao.isWifiConnected(this.mContext);
            }
        }
        if (com.kwad.sdk.core.response.b.a.bY(this.mAdInfo)) {
            return ao.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.bZ(this.mAdInfo)) {
            return ao.isWifiConnected(this.mContext);
        }
        return false;
    }

    @Override // com.kwad.sdk.utils.ca.a
    public final void a(Message message) {
        if (!this.Zn && message.what == 1) {
            if (!bz.o(this.bP, 30)) {
                tw();
            } else if (!this.bS) {
                ac();
            }
            this.bQ.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.kwad.components.core.video.a
    public final void ac() {
        if (!this.aKI.isIdle()) {
            if (this.aKI.isPaused() || this.aKI.Ke()) {
                tv();
                this.aKI.restart();
                return;
            }
            return;
        }
        com.kwad.components.core.video.a.a aVar = this.ZC;
        if (aVar != null) {
            aVar.onStart();
        }
        if (!ao.isNetworkConnected(this.mContext)) {
            tr();
            return;
        }
        ts();
        if (this.Zn) {
            tv();
            this.aKI.start();
            return;
        }
        if (ad()) {
            tv();
            this.aKI.start();
        } else {
            if (this.Zl) {
                tv();
                this.aKI.start();
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(60, 60);
            layoutParams.addRule(13, -1);
            this.pA.setVisibility(8);
            this.pz.setLayoutParams(layoutParams);
            tt();
        }
    }

    public e(Context context, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.video.videoview.c cVar, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(context, adTemplate, cVar);
        this.bQ = new ca(this);
        this.bR = new AtomicBoolean(true);
        this.bT = true;
        this.bP = this;
        this.bU = ksAdVideoPlayConfig;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onAttachedToWindow");
        aa();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onDetachedFromWindow");
        ab();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onFinishTemporaryDetach");
        aa();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("BannerVideoPlayerController", "onStartTemporaryDetach");
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
}
