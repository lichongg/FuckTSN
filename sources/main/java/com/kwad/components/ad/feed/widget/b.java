package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class b extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    protected TextView ee;
    protected TextView gD;
    protected ImageView gw;
    protected TextView hA;
    protected ImageView hB;
    protected ImageView hC;
    protected RatioFrameLayout hD;
    protected TextView hE;
    protected TextView hF;
    protected View hG;
    protected DownloadProgressView hH;
    protected boolean hI;
    protected int hJ;
    protected com.kwad.components.core.e.d.c mApkDownloadHelper;
    protected KsLogoView mLogoView;

    private void cm() {
        this.hF = (TextView) findViewById(R.id.ksad_h5_desc);
        this.gD = (TextView) findViewById(R.id.ksad_h5_open_btn);
        this.hG = findViewById(R.id.ksad_h5_open_cover);
        this.hF.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.hG.setOnClickListener(this);
        this.hF.setOnClickListener(this);
        this.gD.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hG, this);
        new com.kwad.sdk.widget.h(getContext(), this.hF, this);
        new com.kwad.sdk.widget.h(getContext(), this.gD, this);
    }

    private void cn() {
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_title);
        TextView textView = (TextView) findViewById(R.id.ksad_app_desc);
        this.hE = textView;
        com.kwad.sdk.c.a.a.a(this, this.gw, this.ee, textView);
        new com.kwad.sdk.widget.h(getContext(), this.gw, this);
        new com.kwad.sdk.widget.h(getContext(), this.ee, this);
        new com.kwad.sdk.widget.h(getContext(), this.hE, this);
        if (co()) {
            this.ee.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        } else {
            this.ee.setText(com.kwad.sdk.core.response.b.a.av(this.mAdInfo));
        }
        this.gw.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, this.hJ);
        this.hE.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        if (this.hI) {
            ck();
        }
    }

    private boolean co() {
        if (FeedType.isNewVerticalType(com.kwad.sdk.core.response.b.e.eG(this.mAdTemplate))) {
            return com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_NOVEL_DEFAULT.getDefaultType() || com.kwad.sdk.core.response.b.e.eH(this.mAdTemplate) == FeedType.FeedDefaultType.FEED_VERTICAL_BISERIAL_DEFAULT.getDefaultType();
        }
        return false;
    }

    private void cp() {
        this.hH.at(this.mAdTemplate);
        this.hH.setOnClickListener(this);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.hH.getAppDownloadListener());
        this.mApkDownloadHelper = cVar;
        cVar.d(this.hH.getAppDownloadListener());
        this.mApkDownloadHelper.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            b(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public void bw() {
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        RatioFrameLayout ratioFrameLayout = (RatioFrameLayout) findViewById(R.id.ksad_image_container);
        this.hD = ratioFrameLayout;
        ratioFrameLayout.setRatio(0.5600000023841858d);
        this.hB = (ImageView) findViewById(R.id.ksad_ad_image);
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_dislike_logo);
        this.hH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
    }

    public void cl() {
        this.hB.post(new bg() { // from class: com.kwad.components.ad.feed.widget.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                AdInfo el = com.kwad.sdk.core.response.b.e.el(b.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.aU(el).height > com.kwad.sdk.core.response.b.a.aU(el).width) {
                    ViewGroup.LayoutParams layoutParams = b.this.hD.getLayoutParams();
                    layoutParams.width = b.this.getWidth() / 2;
                    b.this.hD.setRatio(1.7857142686843872d);
                    b.this.hD.setLayoutParams(layoutParams);
                }
                List<String> ba = com.kwad.sdk.core.response.b.a.ba(b.this.mAdInfo);
                if (ba.size() <= 0) {
                    com.kwad.sdk.core.d.c.e("BaseFeedTextImageView", "getImageUrlList size less than one");
                    return;
                }
                b.this.ht = SystemClock.elapsedRealtime();
                KSImageLoader.loadFeeImage(b.this.hB, ba.get(0), b.this.mAdTemplate, b.this.hy);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b(view, view == this.hA ? 25 : view == this.hB ? 100 : (view == this.hH || view == this.gD || view == this.hG) ? 1 : view == this.gw ? 13 : view == this.ee ? 14 : (view == this.hE || view == this.hF) ? 101 : 35);
    }

    public void setRadiusDp(int i6) {
        this.hJ = i6;
    }

    public void setmIsShowComplianceView(boolean z5) {
        this.hI = z5;
    }

    public b(@NonNull Context context) {
        super(context);
        this.hI = true;
        this.hJ = 8;
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        DownloadProgressView downloadProgressView;
        super.aa();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null && (downloadProgressView = this.hH) != null) {
            cVar.b(downloadProgressView.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void cq() {
        super.cq();
        com.kwad.components.core.e.d.c cVar = this.mApkDownloadHelper;
        if (cVar != null) {
            cVar.c(this.hH.getAppDownloadListener());
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d(adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        this.mLogoView.aP(this.mAdTemplate);
        cl();
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            findViewById(R.id.ksad_ad_download_container).setVisibility(0);
            findViewById(R.id.ksad_ad_h5_container).setVisibility(8);
            cn();
            cp();
        } else {
            findViewById(R.id.ksad_ad_h5_container).setVisibility(0);
            findViewById(R.id.ksad_ad_download_container).setVisibility(8);
            if (co()) {
                cn();
            }
            cm();
        }
        com.kwad.sdk.c.a.a.a(this, this.hA, this.hB, this.hC);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.hB, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
    }

    private void b(View view, final int i6) {
        if (view == this.hC) {
            vW();
        } else {
            cj();
            com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).az(5).aA(i6).b(this.mApkDownloadHelper).aB(view == this.hH ? 1 : 2).aq(view == this.hH).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.b.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    b.this.ba(i6);
                }
            }));
        }
    }
}
