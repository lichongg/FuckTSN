package com.kwad.components.core.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.ca;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e extends a implements ca.a {
    private View bP;
    private final ca bQ;
    private final AtomicBoolean bR;
    private boolean bS;
    private boolean bT;
    private final KsAdVideoPlayConfig bU;

    public final void tU() {
        this.bS = false;
    }

    private void aa() {
        if (this.bR.getAndSet(false)) {
            com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewAttached");
            this.bQ.sendEmptyMessage(1);
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
        if (com.kwad.sdk.core.response.b.a.cc(this.mAdInfo)) {
            return ao.isNetworkConnected(this.mContext);
        }
        if (com.kwad.sdk.core.response.b.a.cd(this.mAdInfo)) {
            return ao.isWifiConnected(this.mContext);
        }
        return false;
    }

    private boolean tR() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.type != 21) {
            return false;
        }
        int i6 = adTemplate.defaultType;
        return i6 == 1 || i6 == 2;
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

    public final void ab() {
        if (this.bR.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onViewDetached");
        this.bQ.removeCallbacksAndMessages(null);
        if (this.bT) {
            release();
        } else {
            this.aKI.pause();
        }
    }

    @Override // com.kwad.components.core.video.a
    protected final void ac() {
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
        } else if (ad()) {
            tv();
            this.aKI.start();
        } else if (!this.Zl) {
            tt();
        } else {
            tv();
            this.aKI.start();
        }
    }

    @Override // com.kwad.components.core.video.a
    protected final void fA() {
        try {
            View inflate = com.kwad.sdk.o.m.inflate(this.mContext, R.layout.ksad_feed_video_palyer_controller, null);
            this.ZD = inflate;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ksad_video_complete_app_container);
            this.Dh = (ImageView) this.ZD.findViewById(R.id.ksad_video_complete_app_icon);
            this.Di = (TextView) this.ZD.findViewById(R.id.ksad_app_name);
            this.Zz = (TextView) this.ZD.findViewById(R.id.ksad_app_download);
            KSImageLoader.loadAppIcon(this.Dh, com.kwad.sdk.core.response.b.e.eq(this.mAdTemplate), this.mAdTemplate, 12);
            this.Di.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
            this.Zz.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.Zy = linearLayout;
            this.Dh.setOnClickListener(this);
            this.Di.setOnClickListener(this);
            this.Zz.setOnClickListener(this);
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
            this.mApkDownloadHelper = cVar;
            cVar.b(this.ZE);
            if (tR()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.Dh.getLayoutParams();
                layoutParams.width = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, 67.0f);
                this.Dh.setLayoutParams(layoutParams);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.Di.getLayoutParams();
                layoutParams2.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 10.0f);
                this.Di.setLayoutParams(layoutParams2);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.Zz.getLayoutParams();
                layoutParams3.topMargin = com.kwad.sdk.c.a.a.a(this.mContext, 26.0f);
                layoutParams3.height = com.kwad.sdk.c.a.a.a(this.mContext, 32.0f);
                layoutParams3.width = com.kwad.sdk.c.a.a.a(this.mContext, 72.0f);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(Color.parseColor("#FE3666"));
                gradientDrawable.setCornerRadius(com.kwad.sdk.c.a.a.a(this.mContext, 8.0f));
                gradientDrawable.setShape(0);
                this.Zz.setTextSize(2, 12.0f);
                this.Zz.setLayoutParams(layoutParams3);
                this.Zz.setBackground(gradientDrawable);
            }
            this.Zy.setOnClickListener(this);
            this.Zy.setVisibility(0);
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
    }

    public final void setAutoRelease(boolean z5) {
        this.bT = z5;
    }

    public final void tQ() {
        this.bQ.removeCallbacksAndMessages(null);
        if (this.bT) {
            release();
        } else {
            this.aKI.pause();
        }
    }

    public final void tS() {
        this.aKI.pause();
        this.bS = true;
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
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onAttachedToWindow");
        aa();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onDetachedFromWindow");
        ab();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onFinishTemporaryDetach");
        aa();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.d.c.i("FeedVideoPlayerController", "onStartTemporaryDetach");
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

    public final void tT() {
        ac();
        this.bS = false;
    }
}
