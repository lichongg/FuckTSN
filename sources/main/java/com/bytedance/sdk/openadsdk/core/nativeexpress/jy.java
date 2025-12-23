package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: D:\Downloads\app\classes4.dex */
class jy extends BackupView {
    private static w[] jy = {new w(2, 3.0241935f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 124), new w(3, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new w(4, 1.4044944f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME), new w(16, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new w(5, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300), new w(15, 1.25f, MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS, 300)};
    private NativeExpressView av;
    private View az;

    /* renamed from: i, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw f29676i;
    private ImageView kt;
    private TextView mi;

    /* renamed from: w, reason: collision with root package name */
    private TextView f29677w;
    private int ws;

    private void cw(int i6) {
        w r5 = r(this.xt.ve());
        this.f29587m = ed.cw(this.f29586j, this.av.getExpectExpressWidth());
        this.ae = ed.cw(this.f29586j, this.av.getExpectExpressHeight());
        if (this.f29587m <= 0) {
            this.f29587m = ed.r(this.f29586j);
        }
        if (this.ae <= 0) {
            this.ae = Float.valueOf(this.f29587m / r5.cw).intValue();
        }
        int i7 = this.f29587m;
        if (i7 > 0 && i7 > ed.r(this.f29586j)) {
            this.f29587m = ed.r(this.f29586j);
            this.ae = Float.valueOf(this.ae * (ed.r(this.f29586j) / this.f29587m)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f29587m, this.ae);
        }
        layoutParams.width = this.f29587m;
        layoutParams.height = this.ae;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (i6 == 9) {
            this.up = "draw_ad";
            if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.xt)) {
                qv();
                return;
            } else {
                tl();
                return;
            }
        }
        this.up = "embeded_ad";
        int ve = this.xt.ve();
        if (ve == 2) {
            cw();
            return;
        }
        if (ve == 3) {
            m();
            return;
        }
        if (ve == 4) {
            r();
            return;
        }
        if (ve == 5) {
            g();
            return;
        }
        if (ve == 15) {
            ae();
            return;
        }
        if (ve == 16) {
            oq();
            return;
        }
        if (ve == 131) {
            oq();
        } else if (ve != 166) {
            oq();
        } else {
            vl();
        }
    }

    private w r(int i6) {
        w[] wVarArr = jy;
        w wVar = wVarArr[0];
        try {
            for (w wVar2 : wVarArr) {
                if (wVar2.f29751j == i6) {
                    return wVar2;
                }
            }
        } catch (Throwable unused) {
        }
        return wVar;
    }

    private void up(int i6) {
        if (i6 == 1) {
            xt();
            this.az.setBackgroundColor(0);
            if (this.kt != null) {
                com.bytedance.sdk.component.utils.kt.j(getContext(), "tt_dislike_icon_night", this.kt);
                return;
            }
            return;
        }
        j();
        this.az.setBackgroundColor(-1);
        if (this.kt != null) {
            com.bytedance.sdk.component.utils.kt.j(getContext(), "tt_dislike_icon2", this.kt);
        }
    }

    void j(n nVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar) {
        setBackgroundColor(-1);
        this.xt = nVar;
        this.av = nativeExpressView;
        this.f29676i = cwVar;
        int g6 = uf.g(nVar);
        this.ws = g6;
        xt(g6);
        int tl = uf.tl(this.xt);
        cw(tl);
        up(com.bytedance.sdk.openadsdk.core.oq.i().q());
        int i6 = tl != 9 ? -2 : -1;
        this.av.addView(this, new ViewGroup.LayoutParams(i6, i6));
    }

    private void ae() {
        View qb = com.bytedance.sdk.openadsdk.res.up.qb(this.f29586j);
        this.az = qb;
        addView(qb);
        this.az.findViewById(2114387740).setVisibility(0);
        this.az.findViewById(2114387955).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.az.findViewById(2114387965);
        ImageView imageView = (ImageView) this.az.findViewById(2114387919);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        TextView textView = (TextView) this.az.findViewById(2114387861);
        TextView textView2 = (TextView) this.az.findViewById(2114387862);
        TextView textView3 = (TextView) this.az.findViewById(2114387639);
        TextView textView4 = (TextView) this.az.findViewById(2114387914);
        TTRatingBar tTRatingBar = (TTRatingBar) this.az.findViewById(2114387880);
        ed.j((TextView) this.az.findViewById(2114387623), this.xt);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.ig()).j(imageView);
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        int up = this.xt.by() != null ? this.xt.by().up() : 4;
        textView4.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(up)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(up);
        tTRatingBar.setStarImageWidth(ed.cw(this.f29586j, 15.0f));
        tTRatingBar.setStarImageHeight(ed.cw(this.f29586j, 14.0f));
        tTRatingBar.setStarImagePadding(ed.cw(this.f29586j, 4.0f));
        tTRatingBar.j();
        textView.setText(getNameOrSource());
        textView2.setText(getTitle());
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView3.setText(this.xt.sf());
        }
        View j6 = j(this.av);
        if (j6 != null) {
            int i6 = (this.f29587m * 123) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            frameLayout.removeAllViews();
            frameLayout.addView(j6, new ViewGroup.LayoutParams(i6, (i6 * 16) / 9));
        }
        j(this, false);
        j(textView3, true);
    }

    private void g() {
        View hl = com.bytedance.sdk.openadsdk.res.up.hl(this.f29586j);
        this.az = hl;
        addView(hl);
        FrameLayout frameLayout = (FrameLayout) this.az.findViewById(2114387740);
        frameLayout.setVisibility(0);
        this.az.findViewById(2114387955).setVisibility(8);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        TextView textView = (TextView) this.az.findViewById(2114387639);
        ed.j((TextView) this.az.findViewById(2114387664), this.xt);
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView.setText(this.xt.sf());
        }
        View j6 = j(this.av);
        if (j6 != null) {
            frameLayout.removeAllViews();
            int i6 = this.f29587m;
            frameLayout.addView(j6, new ViewGroup.LayoutParams(i6, (i6 * 9) / 16));
        }
        j(this, false);
        j(textView, true);
    }

    private com.bytedance.sdk.openadsdk.core.xt.j jy() {
        Context context = this.f29586j;
        n nVar = this.xt;
        String str = this.up;
        final com.bytedance.sdk.openadsdk.core.xt.j jVar = new com.bytedance.sdk.openadsdk.core.xt.j(context, nVar, str, uf.xt(str)) { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.8
            @Override // com.bytedance.sdk.openadsdk.core.xt.xt, com.bytedance.sdk.openadsdk.core.xt.r
            public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
                if (view == null) {
                    super.j(view, qvVar);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("click_live_element", view.getTag());
                ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(hashMap);
                super.j(view, qvVar);
            }
        };
        cw cwVar = new cw() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.9
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.cw
            public void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
                try {
                    xVar.j().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).up());
                } catch (JSONException unused) {
                }
                jy.this.j(view, i6, xVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.xt.j.xt.j jVar2 = (com.bytedance.sdk.openadsdk.core.xt.j.xt.j) jVar.j(com.bytedance.sdk.openadsdk.core.xt.j.xt.j.class);
        if (jVar2 != null) {
            jVar2.j(cwVar);
            jVar2.j(2);
        }
        return jVar;
    }

    private void m() {
        View hl = com.bytedance.sdk.openadsdk.res.up.hl(this.f29586j);
        this.az = hl;
        addView(hl);
        this.az.findViewById(2114387740).setVisibility(8);
        this.az.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.az.findViewById(2114387942);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        TextView textView = (TextView) this.az.findViewById(2114387639);
        ed.j((TextView) this.az.findViewById(2114387664), this.xt);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.ae);
        j(imageView);
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView.setText(this.xt.sf());
        }
        j(this, false);
        j(textView, true);
    }

    private void oq() {
        View qb = com.bytedance.sdk.openadsdk.res.up.qb(this.f29586j);
        this.az = qb;
        addView(qb);
        this.az.findViewById(2114387740).setVisibility(8);
        this.az.findViewById(2114387955).setVisibility(0);
        ImageView imageView = (ImageView) this.az.findViewById(2114387942);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        TextView textView = (TextView) this.az.findViewById(2114387639);
        ed.j((TextView) this.az.findViewById(2114387664), this.xt);
        j(imageView);
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView.setText(this.xt.sf());
        }
        j(this, false);
        j(textView, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qv() {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.qv():void");
    }

    private void tl() {
        View hh = com.bytedance.sdk.openadsdk.res.up.hh(this.f29586j);
        this.az = hh;
        addView(hh);
        FrameLayout frameLayout = (FrameLayout) this.az.findViewById(2114387740);
        ImageView imageView = (ImageView) this.az.findViewById(2114387942);
        TextView textView = (TextView) this.az.findViewById(2114387926);
        TextView textView2 = (TextView) this.az.findViewById(2114387946);
        TextView textView3 = (TextView) this.az.findViewById(2114387639);
        TextView textView4 = (TextView) this.az.findViewById(2114387664);
        textView.setText(getDescription());
        textView2.setText(getTitle());
        ed.j(textView4, this.xt);
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView3.setText(this.xt.sf());
        }
        if (n.xt(this.xt)) {
            imageView.setVisibility(8);
        } else {
            j(imageView);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        View j6 = j(this.av);
        NativeExpressView nativeExpressView = this.av;
        if ((nativeExpressView instanceof NativeExpressVideoView) && (j6 instanceof NativeVideoTsView)) {
            NativeExpressVideoView nativeExpressVideoView = (NativeExpressVideoView) nativeExpressView;
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) j6;
            nativeVideoTsView.setVideoAdLoadListener(nativeExpressVideoView);
            nativeVideoTsView.setVideoAdInteractionListener(nativeExpressVideoView);
        }
        if (j6 != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(j6, new ViewGroup.LayoutParams(-1, -1));
        } else {
            this.az.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        j(textView2, false);
        j(textView, false);
        j(textView3, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void vl() {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.vl():void");
    }

    public void xt() {
        TextView textView = this.f29677w;
        if (textView == null || this.mi == null) {
            return;
        }
        textView.setTextColor(-1);
        this.mi.setTextColor(-1);
    }

    jy(Context context) {
        super(context);
        this.f29586j = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.j
    public void b_(int i6) {
        super.b_(i6);
        up(i6);
    }

    private void r() {
        View e6 = com.bytedance.sdk.openadsdk.res.up.e(this.f29586j);
        this.az = e6;
        addView(e6);
        ImageView imageView = (ImageView) this.az.findViewById(2114387701);
        ImageView imageView2 = (ImageView) this.az.findViewById(2114387698);
        ImageView imageView3 = (ImageView) this.az.findViewById(2114387696);
        ImageView imageView4 = (ImageView) this.az.findViewById(2114387937);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        TextView textView = (TextView) this.az.findViewById(2114387639);
        ed.j((TextView) this.az.findViewById(2114387664), this.xt);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(0)).j(imageView);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(1)).j(imageView2);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(2)).j(imageView3);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.ig()).j(imageView4);
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView.setText(this.xt.sf());
        }
        j(this, false);
        j(textView, true);
    }

    private void j(ImageView imageView) {
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(0)).j(imageView);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.xt)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.xt), com.bytedance.sdk.openadsdk.up.j.oq(this.xt));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.up.j.j(imageView, upieImageView);
        }
    }

    private void j(View view, TextView textView, n nVar) {
        if (view == null || textView == null) {
            return;
        }
        if (nVar == null) {
            view.setVisibility(0);
            return;
        }
        if (TextUtils.isEmpty(nVar.ek())) {
            view.setVisibility(0);
            textView.setVisibility(8);
            ed.j(view, nVar);
        } else {
            view.setVisibility(8);
            textView.setVisibility(0);
            ed.j(textView, nVar);
        }
    }

    private void j(View view, com.bytedance.sdk.openadsdk.core.xt.xt xtVar, String str) {
        if (view == null || xtVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        view.setTag(str);
        view.setOnClickListener(xtVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void j(View view, int i6, com.bytedance.sdk.openadsdk.core.tj.x xVar) {
        NativeExpressView nativeExpressView = this.av;
        if (nativeExpressView != null) {
            if (i6 == 1 && nativeExpressView.getClickListener() != null) {
                this.av.getClickListener().xt(this.kt);
            }
            if (i6 == 2 && this.av.getClickCreativeListener() != null) {
                this.av.getClickCreativeListener().xt(this.kt);
            }
            this.av.j(view, i6, xVar);
        }
    }

    private void cw() {
        View n6 = com.bytedance.sdk.openadsdk.res.up.n(this.f29586j);
        this.az = n6;
        addView(n6);
        ImageView imageView = (ImageView) this.az.findViewById(2114387942);
        this.kt = (ImageView) this.az.findViewById(2114387860);
        this.mi = (TextView) this.az.findViewById(2114387926);
        this.f29677w = (TextView) this.az.findViewById(2114387946);
        j((LinearLayout) this.az.findViewById(2114387666), (TextView) this.az.findViewById(2114387664), this.xt);
        j(imageView);
        this.mi.setText(getDescription());
        this.f29677w.setText(getTitle());
        this.kt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.jy.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                jy.this.up();
            }
        });
        j(this, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected NativeVideoTsView j(Context context, n nVar, String str, boolean z5, boolean z6) {
        if ("draw_ad".equals(str)) {
            return new NativeDrawVideoTsView(context, nVar, str, z5, z6);
        }
        return new NativeVideoTsView(context, nVar, str, z5, z6);
    }

    public void j() {
        if (this.f29677w == null || this.mi == null) {
            return;
        }
        int ve = this.xt.ve();
        if (ve != 2) {
            if (ve != 3) {
                if (ve == 4) {
                    this.f29677w.setTextColor(Color.parseColor("#FF3E3E3E"));
                    this.mi.setTextColor(Color.parseColor("#FF3E3E3E"));
                    return;
                } else if (ve != 5 && ve != 15 && ve != 16) {
                    return;
                }
            }
            this.f29677w.setTextColor(Color.parseColor("#FF222222"));
            this.mi.setTextColor(Color.parseColor("#FF505050"));
            return;
        }
        this.f29677w.setTextColor(Color.parseColor("#FFBCBCBC"));
        this.mi.setTextColor(Color.parseColor("#FF999999"));
    }
}
