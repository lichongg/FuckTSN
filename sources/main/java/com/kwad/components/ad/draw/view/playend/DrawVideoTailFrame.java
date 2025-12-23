package com.kwad.components.ad.draw.view.playend;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.core.download.a.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.o.m;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DrawVideoTailFrame extends FrameLayout implements View.OnClickListener {

    @Nullable
    private KsAppDownloadListener dW;
    private KsDrawAd.AdInteractionListener dh;
    private TextView ee;
    private DrawDownloadProgressBar gA;
    private ViewGroup gB;
    private TextView gC;
    private TextView gD;
    private AdBaseFrameLayout gt;
    private ImageView gu;
    private ViewGroup gv;
    private ImageView gw;
    private AppScoreView gx;
    private TextView gy;
    private TextView gz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private c mApkDownloadHelper;
    private KsLogoView mLogoView;

    public DrawVideoTailFrame(@NonNull Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_video_tailframe, this);
        this.gu = (ImageView) findViewById(R.id.ksad_video_cover);
        this.gv = (ViewGroup) findViewById(R.id.ksad_app_container);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_name);
        this.gx = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gy = (TextView) findViewById(R.id.ksad_app_download_count);
        this.gz = (TextView) findViewById(R.id.ksad_app_ad_desc);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.gA = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(15);
        this.gB = (ViewGroup) findViewById(R.id.ksad_h5_container);
        this.gC = (TextView) findViewById(R.id.ksad_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_tailframe_logo);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        return new a() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.1
            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                DrawVideoTailFrame.this.gA.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                DrawVideoTailFrame.this.gA.e(com.kwad.sdk.core.response.b.a.cl(DrawVideoTailFrame.this.mAdTemplate), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                DrawVideoTailFrame.this.gA.e(com.kwad.sdk.core.response.b.a.aE(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                DrawVideoTailFrame.this.gA.e(com.kwad.sdk.core.response.b.a.ac(DrawVideoTailFrame.this.mAdInfo), DrawVideoTailFrame.this.gA.getMax());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i6) {
                DrawVideoTailFrame.this.gA.e(i6 + "%", i6);
            }

            @Override // com.kwad.sdk.core.download.a.a
            public final void onPaused(int i6) {
                super.onPaused(i6);
                DrawVideoTailFrame.this.gA.e(com.kwad.sdk.core.response.b.a.IQ(), i6);
            }
        };
    }

    public final void bW() {
        c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            KsAppDownloadListener ksAppDownloadListener = this.dW;
            if (ksAppDownloadListener != null) {
                cVar.d(ksAppDownloadListener);
                return;
            }
            KsAppDownloadListener appDownloadListener = getAppDownloadListener();
            this.dW = appDownloadListener;
            this.mApkDownloadHelper.b(appDownloadListener);
        }
    }

    public final void j(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo el = e.el(adTemplate);
        this.mAdInfo = el;
        AdInfo.AdMaterialInfo.MaterialFeature aV = com.kwad.sdk.core.response.b.a.aV(el);
        String str = aV.coverUrl;
        this.mLogoView.aP(adTemplate);
        if (!TextUtils.isEmpty(str)) {
            int i6 = aV.width;
            int i7 = aV.height;
            if (i6 > 0 && i6 > i7) {
                int screenWidth = com.kwad.sdk.c.a.a.getScreenWidth(getContext());
                if (getWidth() != 0) {
                    screenWidth = getWidth();
                }
                int i8 = (int) (screenWidth * (i7 / i6));
                ViewGroup.LayoutParams layoutParams = this.gu.getLayoutParams();
                layoutParams.width = screenWidth;
                layoutParams.height = i8;
            }
            KSImageLoader.loadImage(this.gu, str, this.mAdTemplate);
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, 11);
            this.ee.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
            float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
            if (aA >= 3.0f) {
                this.gx.setScore(aA);
                this.gx.setVisibility(0);
            }
            this.gy.setText(com.kwad.sdk.core.response.b.a.az(this.mAdInfo));
            this.gz.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.gv.setVisibility(0);
            this.gB.setVisibility(8);
        } else {
            this.gC.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
            this.gD.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
            this.gv.setVisibility(8);
            this.gB.setVisibility(0);
        }
        this.gA.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).aB(view == this.gA ? 1 : 2).aq(view == this.gA).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playend.DrawVideoTailFrame.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (DrawVideoTailFrame.this.dh != null) {
                    DrawVideoTailFrame.this.dh.onAdClicked();
                }
                com.kwad.sdk.core.adlog.c.a(DrawVideoTailFrame.this.mAdTemplate, 2, DrawVideoTailFrame.this.gt.getTouchCoords());
            }
        }));
    }

    public final void release() {
        KsAppDownloadListener ksAppDownloadListener;
        c cVar = this.mApkDownloadHelper;
        if (cVar == null || (ksAppDownloadListener = this.dW) == null) {
            return;
        }
        cVar.c(ksAppDownloadListener);
    }

    public void setAdBaseFrameLayout(AdBaseFrameLayout adBaseFrameLayout) {
        this.gt = adBaseFrameLayout;
    }

    public void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dh = adInteractionListener;
    }

    public void setApkDownloadHelper(@Nullable c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawVideoTailFrame(@NonNull Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        B(context);
    }
}
