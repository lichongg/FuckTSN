package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    private AppScoreView Ep;
    private TextProgressBar Eq;
    private View Er;
    private a Eu;
    private KsAppDownloadListener dW;
    private TextView ee;
    private ImageView gw;
    private TextView gy;
    private TextView hE;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private c mApkDownloadHelper;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface a {
        void O(boolean z5);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void d(View view, final boolean z5) {
        int i6 = view == this.Er ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new a.C0616a(view.getContext()).aB(this.mAdTemplate).b(this.mApkDownloadHelper).az(1).aA(i6).aq(view == this.Eq).aB(i6).a(new a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.Eu != null) {
                    ActionBarAppPortrait.this.Eu.O(z5);
                }
            }
        }));
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.dW == null) {
            this.dW = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.cl(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.aE(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.ac(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.Er.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i6) {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.dG(i6), i6);
                    ActionBarAppPortrait.this.Er.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i6) {
                    ActionBarAppPortrait.this.Eq.e(com.kwad.sdk.core.response.b.a.dF(i6), i6);
                    ActionBarAppPortrait.this.Er.setVisibility(8);
                }
            };
        }
        return this.dW;
    }

    private void lq() {
        String az = com.kwad.sdk.core.response.b.a.az(this.mAdInfo);
        boolean isEmpty = TextUtils.isEmpty(az);
        float aA = com.kwad.sdk.core.response.b.a.aA(this.mAdInfo);
        boolean z5 = aA >= 3.0f;
        if (!isEmpty && z5) {
            ((LinearLayout.LayoutParams) this.ee.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.Ep.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.gy.setText(az);
            this.gy.setVisibility(0);
            this.Ep.setVisibility(0);
            this.Ep.setScore(aA);
            this.hE.setVisibility(8);
            return;
        }
        if (!isEmpty) {
            this.gy.setText(az);
            this.gy.setVisibility(0);
            this.Ep.setVisibility(8);
            this.hE.setVisibility(8);
            return;
        }
        if (z5) {
            this.gy.setVisibility(8);
            this.Ep.setScore(aA);
            this.Ep.setVisibility(0);
            this.hE.setVisibility(8);
            return;
        }
        this.hE.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.gy.setVisibility(8);
        this.Ep.setVisibility(8);
        this.hE.setVisibility(0);
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable c cVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo el = e.el(adTemplate);
        this.mAdInfo = el;
        this.Eu = aVar;
        this.mApkDownloadHelper = cVar;
        KSImageLoader.loadAppIcon(this.gw, com.kwad.sdk.core.response.b.a.co(el), adTemplate, 12);
        this.ee.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        lq();
        this.Eq.e(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo), 0);
        c cVar2 = this.mApkDownloadHelper;
        if (cVar2 != null) {
            cVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new h(this, this);
        new h(this.Er, this);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        initView();
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ee = (TextView) findViewById(R.id.ksad_app_title);
        this.hE = (TextView) findViewById(R.id.ksad_app_desc);
        this.Ep = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gy = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.Eq = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.Eq.setTextColor(-1);
        this.Er = findViewById(R.id.ksad_download_bar_cover);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }
}
