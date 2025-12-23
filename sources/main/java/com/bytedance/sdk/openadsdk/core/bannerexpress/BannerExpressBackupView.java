package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.w;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.res.up;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BannerExpressBackupView extends BackupView {
    private static w[] jy = {new w(1, 6.4f, 640, 100), new w(3, 1.2f, 600, 500)};
    private com.bytedance.sdk.openadsdk.core.qv.xt.cw av;
    private NativeExpressView az;

    /* renamed from: i, reason: collision with root package name */
    private int f27970i;
    private TextView kt;
    private TextView mi;
    private ImageView tj;

    /* renamed from: w, reason: collision with root package name */
    private w f27971w;
    private View ws;

    private void cw(int i6) {
        if (i6 == 1) {
            r();
            this.ws.setBackgroundColor(0);
        } else {
            cw();
            this.ws.setBackgroundColor(-1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void j(View view, int i6, x xVar) {
        if (this.az != null) {
            if (i6 == 1 || i6 == 2) {
                View findViewById = this.ws.findViewById(2114387860);
                if (i6 == 1) {
                    this.az.getClickListener().xt(findViewById);
                } else {
                    this.az.getClickCreativeListener().xt(findViewById);
                }
            }
            this.az.j(view, i6, xVar);
        }
    }

    private void r() {
        int i6 = this.f27971w.f29751j;
        if (i6 == 2 || i6 == 3) {
            TextView textView = this.mi;
            if (textView != null) {
                textView.setTextColor(-1);
            }
            TextView textView2 = this.kt;
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        } else {
            TextView textView3 = this.mi;
            if (textView3 != null) {
                textView3.setTextColor(-1);
            }
        }
        if (this.tj != null) {
            kt.j(getContext(), "tt_dislike_icon_night", this.tj);
        }
    }

    private void xt() {
        float cw = (this.ae * 1.0f) / ed.cw(this.f29586j, 50.0f);
        float f6 = this.ae * 1.0f;
        int i6 = this.f29587m;
        if (f6 / i6 > 0.21875f) {
            cw = (i6 * 1.0f) / ed.cw(this.f29586j, 320.0f);
        }
        View nd = up.nd(this.f29586j);
        this.ws = nd;
        addView(nd);
        this.tj = (ImageView) this.ws.findViewById(2114387860);
        ImageView imageView = (ImageView) this.ws.findViewById(2114387937);
        this.mi = (TextView) this.ws.findViewById(2114387946);
        TextView textView = (TextView) this.ws.findViewById(2114387800);
        TTRatingBar tTRatingBar = (TTRatingBar) this.ws.findViewById(2114387897);
        TextView textView2 = (TextView) this.ws.findViewById(2114387639);
        this.mi.setTextSize(2, ed.xt(this.f29586j, r5.getTextSize()) * cw);
        textView.setTextSize(2, ed.xt(this.f29586j, textView.getTextSize()) * cw);
        textView2.setTextSize(2, ed.xt(this.f29586j, textView2.getTextSize()) * cw);
        TextView textView3 = (TextView) this.ws.findViewById(2114387664);
        this.tj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.up();
            }
        });
        ed.j(textView3, this.xt, 27, 11);
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.ig()).j(imageView);
        this.mi.setText(getTitle());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (ed.cw(this.f29586j, 45.0f) * cw);
            layoutParams.height = (int) (ed.cw(this.f29586j, 45.0f) * cw);
        }
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView2.setText(this.xt.sf());
        }
        int up = this.xt.by() != null ? this.xt.by().up() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(up)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(up);
        tTRatingBar.setStarImageWidth(ed.cw(this.f29586j, 15.0f) * cw);
        tTRatingBar.setStarImageHeight(ed.cw(this.f29586j, 14.0f) * cw);
        tTRatingBar.setStarImagePadding(ed.cw(this.f29586j, 4.0f));
        tTRatingBar.j();
        j((View) this, true);
        j((View) textView2, true);
    }

    public BannerExpressBackupView(Context context) {
        super(context);
        this.f27970i = 1;
        this.f29586j = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView, com.bytedance.sdk.component.adexpress.theme.j
    public void b_(int i6) {
        super.b_(i6);
        cw(i6);
    }

    private void cw() {
        int i6 = this.f27971w.f29751j;
        if (i6 != 2 && i6 != 3) {
            TextView textView = this.mi;
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#FF333333"));
            }
            if (this.tj != null) {
                kt.j(getContext(), "tt_dislike_icon", this.tj);
                return;
            }
            return;
        }
        TextView textView2 = this.mi;
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#FFAEAEAE"));
        }
        TextView textView3 = this.kt;
        if (textView3 != null) {
            textView3.setTextColor(Color.parseColor("#3E3E3E"));
        }
        if (this.tj != null) {
            this.tj.setImageDrawable(up.ol(this.f29586j));
        }
    }

    void j(n nVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.core.qv.xt.cw cwVar) {
        setBackgroundColor(-1);
        this.xt = nVar;
        this.az = nativeExpressView;
        this.av = cwVar;
        this.up = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        int g6 = uf.g(this.xt);
        this.tl = g6;
        xt(g6);
        j();
        cw(oq.i().q());
    }

    private void j() {
        this.f27971w = j(this.az.getExpectExpressWidth(), this.az.getExpectExpressHeight());
        if (this.az.getExpectExpressWidth() > 0 && this.az.getExpectExpressHeight() > 0) {
            this.f29587m = ed.cw(this.f29586j, this.az.getExpectExpressWidth());
            this.ae = ed.cw(this.f29586j, this.az.getExpectExpressHeight());
        } else {
            int r5 = ed.r(this.f29586j);
            this.f29587m = r5;
            this.ae = Float.valueOf(r5 / this.f27971w.cw).intValue();
        }
        int i6 = this.f29587m;
        if (i6 > 0 && i6 > ed.r(this.f29586j)) {
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
        w wVar = this.f27971w;
        int i7 = wVar.f29751j;
        if (i7 != 1 && i7 == 3) {
            j(wVar);
        } else {
            xt();
        }
    }

    private void j(ImageView imageView) {
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.fp().get(0)).j(imageView);
        if (com.bytedance.sdk.openadsdk.up.j.r(this.xt)) {
            UpieImageView upieImageView = new UpieImageView(imageView.getContext(), com.bytedance.sdk.openadsdk.up.j.g(this.xt), com.bytedance.sdk.openadsdk.up.j.oq(this.xt));
            upieImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            com.bytedance.sdk.openadsdk.up.j.j(imageView, upieImageView);
        }
    }

    private void j(w wVar) {
        float cw = (this.ae * 1.0f) / ed.cw(this.f29586j, 250.0f);
        View rh = up.rh(this.f29586j);
        this.ws = rh;
        addView(rh);
        FrameLayout frameLayout = (FrameLayout) this.ws.findViewById(2114387778);
        this.tj = (ImageView) this.ws.findViewById(2114387860);
        ImageView imageView = (ImageView) this.ws.findViewById(2114387942);
        ImageView imageView2 = (ImageView) this.ws.findViewById(2114387937);
        this.mi = (TextView) this.ws.findViewById(2114387946);
        this.kt = (TextView) this.ws.findViewById(2114387926);
        TextView textView = (TextView) this.ws.findViewById(2114387933);
        TextView textView2 = (TextView) this.ws.findViewById(2114387639);
        ed.j((TextView) this.ws.findViewById(2114387664), this.xt);
        LinearLayout linearLayout = (LinearLayout) this.ws.findViewById(2114387877);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) (ed.cw(this.f29586j, 45.0f) * cw);
            layoutParams.height = (int) (ed.cw(this.f29586j, 45.0f) * cw);
        }
        this.mi.setTextSize(2, ed.xt(this.f29586j, r8.getTextSize()) * cw);
        this.kt.setTextSize(2, ed.xt(this.f29586j, r8.getTextSize()) * cw);
        textView.setTextSize(2, ed.xt(this.f29586j, textView.getTextSize()) * cw);
        textView2.setTextSize(2, ed.xt(this.f29586j, textView2.getTextSize()) * cw);
        try {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            float f6 = cw - 1.0f;
            if (f6 > 0.0f) {
                layoutParams2.topMargin = ed.cw(this.f29586j, f6 * 8.0f);
            }
            ((RelativeLayout.LayoutParams) textView2.getLayoutParams()).setMargins(0, (int) (ed.cw(this.f29586j, 16.0f) * cw), 0, 0);
        } catch (Throwable unused) {
        }
        this.tj.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.up();
            }
        });
        int cw2 = ed.cw(this.f29586j, 15.0f);
        ed.j(this.tj, cw2, cw2, cw2, cw2);
        if (ln.ws(this.xt) != null) {
            View j6 = j(this.az);
            if (j6 != null) {
                int i6 = (this.f29587m * 406) / 600;
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i6, (i6 * 9) / 16);
                int i7 = wVar.xt;
                if (i7 == 1) {
                    int i8 = (this.f29587m * 406) / 600;
                    layoutParams3 = new FrameLayout.LayoutParams(i8, (i8 * 9) / 16);
                } else if (i7 == 2) {
                    layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
                } else if (i7 == 3) {
                    int i9 = (this.ae * 188) / MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME;
                    layoutParams3 = new FrameLayout.LayoutParams((i9 * 16) / 9, i9);
                } else if (i7 == 4) {
                    int i10 = (this.f29587m * 480) / 690;
                    layoutParams3 = new FrameLayout.LayoutParams(i10, (i10 * 9) / 16);
                }
                layoutParams3.gravity = 17;
                frameLayout.addView(j6, 0, layoutParams3);
                ed.j((View) imageView, 8);
            } else {
                j(imageView);
                ed.j((View) imageView, 0);
            }
        } else {
            j(imageView);
            ed.j((View) imageView, 0);
        }
        com.bytedance.sdk.openadsdk.g.xt.j(this.xt.ig()).j(imageView2);
        textView.setText(getNameOrSource());
        this.mi.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        this.kt.setText(getDescription());
        if (!TextUtils.isEmpty(this.xt.sf())) {
            textView2.setText(this.xt.sf());
        }
        j((View) this, true);
        j((View) textView2, true);
        j(frameLayout);
    }

    private w j(int i6, int i7) {
        try {
            return ((double) i7) >= Math.floor((((double) i6) * 300.0d) / 600.0d) ? jy[1] : jy[0];
        } catch (Throwable unused) {
            return jy[0];
        }
    }
}
