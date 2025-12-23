package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class p extends a implements View.OnClickListener, com.kwad.sdk.widget.d {
    private TextView hA;
    private ImageView hC;
    private DownloadProgressView hH;
    private RoundAngleImageView iq;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private KsLogoView mLogoView;

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d(adResultData);
        this.hA.setText(com.kwad.components.ad.feed.f.l(this.mAdTemplate));
        List<String> ba = com.kwad.sdk.core.response.b.a.ba(this.mAdInfo);
        if (ba.size() > 0) {
            this.ht = SystemClock.elapsedRealtime();
            KSImageLoader.loadFeeImage(this.iq, ba.get(0), this.mAdTemplate, this.hy);
        } else {
            com.kwad.sdk.core.d.c.e("FeedTextRightImageView", "getImageUrlList size less than one");
        }
        cn();
        com.kwad.sdk.c.a.a.a(this, this.hA, this.iq, this.hH, this.hC);
        new com.kwad.sdk.widget.h(getContext(), this.hA, this);
        new com.kwad.sdk.widget.h(getContext(), this.iq, this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        new com.kwad.sdk.widget.h(getContext(), this.hC, this);
        setOnClickListener(this);
    }

    private void cn() {
        this.mLogoView.aP(this.mAdTemplate);
        this.hH.at(this.mAdTemplate);
        this.hH.setOnClickListener(this);
        new com.kwad.sdk.widget.h(getContext(), this.hH, this);
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate, null, this.hH.getAppDownloadListener());
            this.mApkDownloadHelper = cVar;
            cVar.d(this.hH.getAppDownloadListener());
            this.mApkDownloadHelper.setOnShowListener(this);
            this.mApkDownloadHelper.setOnDismissListener(this);
            ck();
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, 153);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bw() {
        this.hA = (TextView) findViewById(R.id.ksad_ad_desc);
        ((RatioFrameLayout) findViewById(R.id.ksad_image_container)).setRatio(0.6600000262260437d);
        RoundAngleImageView roundAngleImageView = (RoundAngleImageView) findViewById(R.id.ksad_ad_image);
        this.iq = roundAngleImageView;
        roundAngleImageView.setRadius(com.kwad.sdk.c.a.a.a(getContext(), 3.0f));
        this.hC = (ImageView) findViewById(R.id.ksad_ad_dislike);
        this.hH = (DownloadProgressView) findViewById(R.id.ksad_app_download_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_feed_logo);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_text_right_image;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        d(view, view == this.hA ? 25 : view == this.iq ? 100 : view == this.hH ? 1 : 35);
    }

    public p(@NonNull Context context) {
        super(context);
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

    private void d(View view, final int i6) {
        if (view == this.hC) {
            vW();
        } else {
            com.kwad.components.core.e.d.a.a(new a.C0616a(getContext()).aB(this.mAdTemplate).az(5).aA(i6).b(this.mApkDownloadHelper).aB(view == this.hH ? 1 : 2).aq(view == this.hH).a(new a.b() { // from class: com.kwad.components.ad.feed.widget.p.1
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    p.this.ba(i6);
                }
            }));
        }
    }
}
