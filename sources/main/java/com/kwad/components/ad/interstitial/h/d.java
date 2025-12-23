package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bp;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class d extends KSFrameLayout implements com.kwad.sdk.widget.d {
    private KSFrameLayout fC;
    private ImageView gw;
    private TextView hE;
    private ImageView hM;
    private AdTemplate mAdTemplate;
    private KsLogoView mLogoView;
    private KSFrameLayout mO;
    private String oa;

    @Nullable
    private View ob;
    private ImageView oc;
    private TextProgressBar od;
    private ViewGroup oe;
    private ViewGroup of;
    private ImageView og;
    private View oh;
    private View oi;
    private TextView oj;
    private ImageView ok;
    private TextView ol;
    private TextView om;
    private TextView on;
    private TextProgressBar oo;
    private TextView op;
    private e oq;
    private final a or;
    private boolean os;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private boolean ou = false;
        private boolean ov = false;
        private int ow = 0;
        private boolean ox = true;

        public final void R(int i6) {
            this.ow = i6;
        }

        public final int fk() {
            return this.ow;
        }

        public final boolean fl() {
            return this.ox;
        }

        public final void w(boolean z5) {
            this.ou = z5;
        }

        public final void x(boolean z5) {
            this.ov = z5;
        }

        public final void y(boolean z5) {
            this.ox = z5;
        }
    }

    private void t(boolean z5) {
        setClickable(true);
        this.mO = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_container);
        this.fC = (KSFrameLayout) findViewById(R.id.ksad_interstitial_native_video_container);
        this.ob = findViewById(R.id.ksad_interstitial_full_bg);
        this.oc = (ImageView) findViewById(R.id.ksad_interstitial_tail_frame);
        this.hM = (ImageView) findViewById(R.id.ksad_video_first_frame_container);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_interstitial_logo);
        this.oe = (ViewGroup) findViewById(R.id.ksad_interstitial_playing);
        this.of = (ViewGroup) findViewById(R.id.ksad_interstitial_play_end);
        this.od = (TextProgressBar) findViewById(R.id.ksad_interstitial_download_btn);
        this.oh = findViewById(R.id.ksad_interstitial_close_outer);
        TextProgressBar textProgressBar = this.od;
        if (textProgressBar != null) {
            textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 10.0f));
            this.od.setTextColor(-1);
        }
        this.og = (ImageView) findViewById(R.id.ksad_interstitial_mute);
        this.oj = (TextView) findViewById(R.id.ksad_interstitial_count_down);
        this.ok = (ImageView) findViewById(R.id.ksad_interstitial_logo);
        this.om = (TextView) findViewById(R.id.ksad_interstitial_name);
        this.on = (TextView) findViewById(R.id.ksad_interstitial_desc);
        this.oo = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.oi = findViewById(R.id.ksad_ad_download_container);
        this.gw = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ol = (TextView) findViewById(R.id.ksad_app_title);
        this.hE = (TextView) findViewById(R.id.ksad_app_desc);
        new h(this, this);
        new h(this.hM, this);
        new h(this.od, this);
        new h(this.oo, this);
        new h(this.oh, this);
        new h(this.of, this);
        new h(this.oj, this);
        new h(this.oi, this);
        new h(this.gw, this);
        new h(this.ol, this);
        new h(this.hE, this);
        new h(this.ok, this);
        new h(this.om, this);
        new h(this.on, this);
        this.og.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.interstitial.h.d.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.this.og.setSelected(!d.this.og.isSelected());
                if (d.this.oq != null) {
                    d.this.oq.p(d.this.og.isSelected());
                }
            }
        });
        this.op = (TextView) findViewById(R.id.ksad_interstitial_playable_timer);
        a(this.fC, z5);
        if (aq.isOrientationPortrait()) {
            return;
        }
        fe();
    }

    public final void c(String str, AdTemplate adTemplate) {
        if (bp.isNullString(str)) {
            return;
        }
        this.hM.setImageDrawable(null);
        KSImageLoader.loadImage(this.hM, str, adTemplate);
    }

    public final void f(String str, int i6) {
        TextProgressBar textProgressBar = this.od;
        if (textProgressBar != null) {
            textProgressBar.e(str, 0);
        }
        TextProgressBar textProgressBar2 = this.oo;
        if (textProgressBar2 != null) {
            textProgressBar2.e(str, 0);
        }
    }

    public final void fh() {
        u(false);
        this.of.setVisibility(0);
        this.oc.setVisibility(0);
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z5) {
        kSFrameLayout.setClickable(true);
        new h(kSFrameLayout, this);
        this.fC.setWidthBasedRatio(!z5);
    }

    private void d(View view, boolean z5) {
        e eVar;
        e eVar2;
        e eVar3 = this.oq;
        if (eVar3 != null) {
            eVar3.q(z5);
            this.oq.a(this.mO);
        }
        if (view.equals(this)) {
            e eVar4 = this.oq;
            if (eVar4 != null) {
                eVar4.ei();
                return;
            }
            return;
        }
        if (view.equals(this.oh)) {
            if (1 != this.or.fk() || (eVar2 = this.oq) == null) {
                return;
            }
            eVar2.eh();
            return;
        }
        if (view.equals(this.oo)) {
            e eVar5 = this.oq;
            if (eVar5 != null) {
                eVar5.ej();
                return;
            }
            return;
        }
        if (view.equals(this.of)) {
            e eVar6 = this.oq;
            if (eVar6 != null) {
                eVar6.eu();
                return;
            }
            return;
        }
        if (view.equals(this.od)) {
            e eVar7 = this.oq;
            if (eVar7 != null) {
                eVar7.ek();
                return;
            }
            return;
        }
        if (view.equals(this.oi)) {
            e eVar8 = this.oq;
            if (eVar8 != null) {
                eVar8.en();
                return;
            }
            return;
        }
        if (view.equals(this.fC)) {
            e eVar9 = this.oq;
            if (eVar9 != null) {
                eVar9.el();
                return;
            }
            return;
        }
        if (view.equals(this.hM)) {
            e eVar10 = this.oq;
            if (eVar10 != null) {
                eVar10.em();
                return;
            }
            return;
        }
        if (view.equals(this.gw)) {
            e eVar11 = this.oq;
            if (eVar11 != null) {
                eVar11.eo();
                return;
            }
            return;
        }
        if (view.equals(this.ol)) {
            e eVar12 = this.oq;
            if (eVar12 != null) {
                eVar12.ep();
                return;
            }
            return;
        }
        if (view.equals(this.hE)) {
            e eVar13 = this.oq;
            if (eVar13 != null) {
                eVar13.eq();
                return;
            }
            return;
        }
        if (view.equals(this.ok)) {
            e eVar14 = this.oq;
            if (eVar14 != null) {
                eVar14.er();
                return;
            }
            return;
        }
        if (view.equals(this.om)) {
            e eVar15 = this.oq;
            if (eVar15 != null) {
                eVar15.es();
                return;
            }
            return;
        }
        if (!view.equals(this.on) || (eVar = this.oq) == null) {
            return;
        }
        eVar.et();
    }

    private void fe() {
        a(this.ok, 40, 40);
        a(this.oo, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 30);
        this.om.setTextSize(14.0f);
        e(this.oo, 11);
        e(this.om, 7);
        e(this.on, 7);
    }

    public final void A(String str) {
        TextView textView = this.oj;
        if (textView == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.or.ov || this.os || this.oj.getVisibility() == 0) {
            return;
        }
        this.oj.setVisibility(0);
    }

    public final void H(AdTemplate adTemplate) {
        this.mLogoView.aP(adTemplate);
    }

    public final void b(boolean z5, int i6) {
        TextView textView = this.op;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
        if (i6 >= 0) {
            this.op.setText(String.format(this.oa, String.valueOf(i6)));
        }
    }

    public final void ff() {
        TextView textView = this.oj;
        if (textView != null) {
            textView.setVisibility(8);
            this.os = true;
        }
    }

    public final void fg() {
        View view = this.oh;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void fi() {
        this.of.setVisibility(8);
        this.oc.setVisibility(8);
        u(true);
    }

    public final boolean fj() {
        ViewGroup viewGroup = this.of;
        return viewGroup != null && viewGroup.getVisibility() == 0;
    }

    @Nullable
    public final View getBlurBgView() {
        return this.ob;
    }

    public final ImageView getTailFrameView() {
        return this.oc;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final void setViewListener(e eVar) {
        this.oq = eVar;
    }

    public final void u(boolean z5) {
        ViewGroup viewGroup = this.oe;
        if (viewGroup != null) {
            viewGroup.setVisibility(z5 ? 0 : 8);
        }
    }

    public final void v(boolean z5) {
        ImageView imageView = this.og;
        if (imageView != null) {
            imageView.setSelected(z5);
        }
    }

    public d(@NonNull Context context, a aVar) {
        super(context);
        int i6;
        this.oa = "%s秒后进入试玩页";
        this.os = false;
        this.or = aVar;
        if (aVar.fl()) {
            i6 = R.layout.ksad_interstitial_native_above;
        } else {
            i6 = R.layout.ksad_interstitial_native;
        }
        m.inflate(context, i6, this);
        t(aVar.ou);
    }

    private void e(View view, int i6) {
        com.kwad.sdk.c.a.a.b(view, 0, com.kwad.sdk.c.a.a.a(getContext(), i6), 0, 0);
    }

    public final void c(boolean z5, boolean z6) {
        ImageView imageView = this.hM;
        if (imageView != null) {
            imageView.setVisibility(z5 ? 0 : 8);
            this.hM.setClickable(z6);
        }
    }

    private void a(View view, int i6, int i7) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), i6);
        layoutParams.height = com.kwad.sdk.c.a.a.a(getContext(), i7);
        view.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            d(view, false);
        }
    }

    public final void f(int i6, int i7) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.width = i6;
        marginLayoutParams.height = i7;
        setLayoutParams(marginLayoutParams);
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        ImageView imageView = this.ok;
        int i6 = R.drawable.ksad_default_app_icon;
        imageView.setImageResource(i6);
        if (com.kwad.sdk.core.response.b.a.ci(adInfo) == 2) {
            KSImageLoader.loadCircleIcon(this.ok, com.kwad.sdk.core.response.b.a.cO(adInfo), getContext().getResources().getDrawable(i6));
            this.om.setText(com.kwad.sdk.core.response.b.a.cn(adInfo));
            this.on.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            if (com.kwad.sdk.core.response.b.a.cK(adInfo)) {
                this.oo.e(com.kwad.components.ad.e.b.aC(), 0);
                return;
            } else {
                this.oo.e(com.kwad.components.ad.e.b.aF(), 0);
                return;
            }
        }
        if (com.kwad.components.ad.interstitial.b.b.dN() && com.kwad.sdk.core.response.b.a.ci(adInfo) == 3) {
            AdProductInfo cV = com.kwad.sdk.core.response.b.a.cV(adInfo);
            KSImageLoader.loadWithRadius(this.ok, cV.icon, adTemplate, 4);
            this.om.setText(cV.name);
            this.on.setVisibility(8);
            this.oo.e(com.kwad.components.ad.e.b.aD(), 0);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            KSImageLoader.loadWithRadius(this.ok, com.kwad.sdk.core.response.b.a.co(adInfo), adTemplate, 4);
            this.om.setText(com.kwad.sdk.core.response.b.a.av(adInfo));
            this.on.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
            this.oo.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
            return;
        }
        KSImageLoader.loadWithRadius(this.ok, com.kwad.sdk.core.response.b.e.eq(adTemplate), adTemplate, 4);
        this.om.setText(com.kwad.sdk.core.response.b.a.cl(adInfo));
        this.on.setText(com.kwad.sdk.core.response.b.a.au(adInfo));
        this.oo.e(com.kwad.sdk.core.response.b.a.aE(adInfo), 0);
    }

    public final void a(float f6, com.kwad.sdk.core.video.videoview.a aVar) {
        this.fC.setRatio(f6);
        this.fC.addView(aVar);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.gravity = 17;
        aVar.setLayoutParams(layoutParams);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }
}
