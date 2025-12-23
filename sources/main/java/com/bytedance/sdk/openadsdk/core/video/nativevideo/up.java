package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.r.xt;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.tj.ln;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.az;
import com.bytedance.sdk.openadsdk.core.widget.ws;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends m {
    private int aq;

    /* renamed from: b, reason: collision with root package name */
    private View f31099b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f31100c;

    /* renamed from: e, reason: collision with root package name */
    private SeekBar f31101e;
    private TextView ed;
    private int ff;
    private View gx;
    private View hh;
    private TextView hl;
    private float ik;
    private int im;

    /* renamed from: k, reason: collision with root package name */
    private boolean f31102k;
    private ColorStateList ka;
    private int kc;
    private ColorStateList ki;
    private boolean ll;
    private boolean ln;

    /* renamed from: n, reason: collision with root package name */
    private TextView f31103n;
    private TextView nd;
    private boolean nt;
    private ImageView ol;
    private boolean oy;
    private float pz;

    /* renamed from: q, reason: collision with root package name */
    private TextView f31104q;
    private final Rect qa;
    private TextView qb;
    private final Rect qo;
    private TextView rh;
    private float ri;
    private final Rect rr;
    private int ry;
    private final l sm;
    private ColorStateList st;

    /* renamed from: t, reason: collision with root package name */
    private float f31105t;

    /* renamed from: u, reason: collision with root package name */
    private float f31106u;
    private final View.OnTouchListener uc;
    private final Rect uq;
    private int wf;
    private final Rect wo;
    private int xp;
    private boolean xq;

    /* renamed from: y, reason: collision with root package name */
    private ws f31107y;
    private ImageView ya;

    /* renamed from: z, reason: collision with root package name */
    private ImageView f31108z;
    private int zz;

    public up(Context context, View view, boolean z5, EnumSet<xt.j> enumSet, n nVar, com.bykv.vk.openvk.component.video.api.r.cw cwVar, boolean z6) {
        super(context, view, z5, enumSet, nVar, cwVar, z6, null);
        this.sm = new l(Looper.getMainLooper(), this);
        this.xq = false;
        this.f31102k = false;
        this.ff = 0;
        this.ry = 0;
        this.zz = 0;
        this.kc = 0;
        this.aq = 0;
        this.rr = new Rect();
        this.qa = new Rect();
        this.wf = 0;
        this.xp = 0;
        this.im = 0;
        this.f31107y = null;
        this.nt = false;
        this.uc = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.7
            private float xt;

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                float x5 = motionEvent.getX();
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    boolean z7 = true;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                view2.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                        } else {
                            view2.getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    } else {
                        up upVar = up.this;
                        if (Math.abs(this.xt - motionEvent.getX()) >= 10.0f) {
                            z7 = false;
                        }
                        upVar.nt = z7;
                    }
                } else {
                    this.xt = x5;
                }
                return false;
            }
        };
        this.uq = new Rect();
        this.wo = new Rect();
        this.qo = new Rect();
        this.f31049s = StubApp.getOrigApplicationContext(v.getContext().getApplicationContext());
        r(z6);
        this.f31041j = view;
        this.tj = z5;
        ws wsVar = new ws(this);
        this.f31107y = wsVar;
        wsVar.j(this.tj);
        DisplayMetrics displayMetrics = this.f31049s.getResources().getDisplayMetrics();
        this.xp = displayMetrics.widthPixels;
        this.im = displayMetrics.heightPixels;
        this.f31052x = enumSet == null ? EnumSet.noneOf(xt.j.class) : enumSet;
        this.la = cwVar;
        this.ch = nVar;
        r(8);
        j(context, this.f31041j, nVar);
        r();
        av();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShapeDrawable xt(int i6, String str) {
        Context context = v.getContext();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        Paint paint = shapeDrawable.getPaint();
        paint.setColor(Color.parseColor("#FFFFFFFF"));
        int cw = ed.cw(context, i6);
        shapeDrawable.setIntrinsicWidth(cw);
        shapeDrawable.setIntrinsicHeight(cw);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ed.cw(context, 1.0f));
        paint.setColor(Color.parseColor(str));
        return shapeDrawable;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean cw(int i6) {
        SeekBar seekBar = this.f31101e;
        return seekBar != null && i6 > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void m() {
        this.sm.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    protected void r() {
        super.r();
        this.f31107y.j(this.f31041j);
        ed.j((View) this.f31100c, (this.tj || this.f31052x.contains(xt.j.hideCloseBtn)) ? 8 : 0);
        this.f31100c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (up.this.tj()) {
                    up upVar = up.this;
                    upVar.f31043l.cw(upVar, view);
                }
            }
        });
        ed.j((View) this.ed, (!this.tj || this.f31052x.contains(xt.j.alwayShowBackBtn)) ? 0 : 8);
        this.ed.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (up.this.tj()) {
                    up upVar = up.this;
                    upVar.f31043l.r(upVar, view);
                }
            }
        });
        this.ol.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (up.this.tj()) {
                    up upVar = up.this;
                    upVar.f31043l.up(upVar, view);
                }
            }
        });
        this.f31108z.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                up.this.xt(false, true);
                up.this.tl();
                up.this.ae();
                up.this.tj();
            }
        });
        this.ya.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (up.this.tj()) {
                    up upVar = up.this;
                    upVar.f31043l.xt(upVar, view);
                }
            }
        });
        this.f31101e.setThumbOffset(0);
        this.f31101e.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
                if (up.this.tj()) {
                    up upVar = up.this;
                    upVar.f31043l.j(upVar, i6, z5);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!up.this.xq && up.this.f31049s != null) {
                    seekBar.setThumb(up.xt(22, "#1E000000"));
                }
                if (up.this.tj()) {
                    seekBar.setThumbOffset(0);
                    up upVar = up.this;
                    upVar.f31043l.xt(upVar, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!up.this.xq && up.this.f31049s != null) {
                    seekBar.setThumb(up.xt(15, "#1E000000"));
                }
                if (up.this.tj()) {
                    seekBar.setThumbOffset(0);
                    up upVar = up.this;
                    upVar.f31043l.j(upVar, seekBar.getProgress());
                }
            }
        });
        this.f31101e.setOnTouchListener(this.uc);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.az.xt
    public void vl() {
        j(true, false);
    }

    private void h() {
        TextView textView = this.qb;
        if (textView != null) {
            textView.setTextSize(0, this.ri);
            ColorStateList colorStateList = this.ki;
            if (colorStateList != null) {
                this.qb.setTextColor(colorStateList);
            }
            this.qb.setAlpha(this.f31105t);
            this.qb.setShadowLayer(ed.cw(this.f31049s, 1.0f), 0.0f, 0.0f, kt.oq(this.f31049s, "tt_video_shadow_color"));
            TextView textView2 = this.qb;
            Rect rect = this.uq;
            ed.xt(textView2, rect.left, rect.top, rect.right, rect.bottom);
        }
        TextView textView3 = this.f31104q;
        if (textView3 != null) {
            textView3.setTextSize(0, this.ik);
            ColorStateList colorStateList2 = this.ka;
            if (colorStateList2 != null) {
                this.f31104q.setTextColor(colorStateList2);
            }
            this.f31104q.setAlpha(this.f31106u);
            this.f31104q.setShadowLayer(ed.cw(this.f31049s, 1.0f), 0.0f, 0.0f, kt.oq(this.f31049s, "tt_video_shadow_color"));
            TextView textView4 = this.f31104q;
            Rect rect2 = this.wo;
            ed.xt(textView4, rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
        ImageView imageView = this.ya;
        if (imageView != null) {
            Rect rect3 = this.qo;
            ed.xt(imageView, rect3.left, rect3.top, rect3.right, rect3.bottom);
        }
        ImageView imageView2 = this.ya;
        if (imageView2 != null) {
            kt.j(this.f31049s, "tt_enlarge_video", imageView2);
        }
        TextView textView5 = this.nd;
        if (textView5 != null) {
            ColorStateList colorStateList3 = this.st;
            if (colorStateList3 != null) {
                textView5.setTextColor(colorStateList3);
            }
            this.nd.setAlpha(this.pz);
            TextView textView6 = this.nd;
            Rect rect4 = this.wo;
            ed.xt(textView6, rect4.left, rect4.top, rect4.right, rect4.bottom);
        }
        View view = this.gx;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.wf;
            this.gx.setLayoutParams(layoutParams);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            gradientDrawable.setColors(new int[]{Color.parseColor("#FF1A1A1A"), Color.parseColor("#00000000")});
            this.gx.setBackground(gradientDrawable);
        }
        xt(this.ln, true);
    }

    private boolean la() {
        n nVar = this.ch;
        if (nVar == null) {
            return false;
        }
        int ff = nVar.ff();
        return ff == 1 || ff == 2;
    }

    private void m(boolean z5) {
        if (z5) {
            p();
        } else {
            h();
        }
    }

    private void p() {
        DisplayMetrics displayMetrics = this.f31049s.getResources().getDisplayMetrics();
        TextView textView = this.qb;
        if (textView != null) {
            this.ri = textView.getTextSize();
            this.qb.setTextSize(2, 14.0f);
            ColorStateList textColors = this.qb.getTextColors();
            this.ki = textColors;
            if (textColors != null) {
                this.qb.setTextColor(kt.oq(this.f31049s, "tt_ssxinzi15"));
            }
            this.f31105t = this.qb.getAlpha();
            this.qb.setAlpha(0.85f);
            this.qb.setShadowLayer(0.0f, ed.cw(this.f31049s, 0.5f), ed.cw(this.f31049s, 0.5f), kt.oq(this.f31049s, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams = this.qb.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.uq.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                ed.xt(this.qb, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.uq.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.uq.bottom);
            }
        }
        TextView textView2 = this.f31104q;
        if (textView2 != null) {
            this.ik = textView2.getTextSize();
            this.f31104q.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.f31104q.getTextColors();
            this.ka = textColors2;
            if (textColors2 != null) {
                this.f31104q.setTextColor(kt.oq(this.f31049s, "tt_ssxinzi15"));
            }
            this.f31106u = this.f31104q.getAlpha();
            this.f31104q.setAlpha(0.85f);
            this.f31104q.setShadowLayer(0.0f, ed.cw(this.f31049s, 0.5f), ed.cw(this.f31049s, 0.5f), kt.oq(this.f31049s, "tt_video_shaoow_color_fullscreen"));
            ViewGroup.LayoutParams layoutParams2 = this.f31104q.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.wo.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                TextView textView3 = this.f31104q;
                int applyDimension = (int) TypedValue.applyDimension(1, 14.0f, displayMetrics);
                Rect rect = this.wo;
                ed.xt(textView3, applyDimension, rect.top, rect.right, rect.bottom);
            }
        }
        ImageView imageView = this.ya;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.qo.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ImageView imageView2 = this.ya;
                Rect rect2 = this.qo;
                ed.xt(imageView2, rect2.left, rect2.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.qo.bottom);
            }
        }
        ImageView imageView3 = this.ya;
        if (imageView3 != null) {
            kt.j(this.f31049s, "tt_shrink_fullscreen", imageView3);
        }
        TextView textView4 = this.nd;
        if (textView4 != null) {
            ColorStateList textColors3 = textView4.getTextColors();
            this.st = textColors3;
            if (textColors3 != null) {
                this.nd.setTextColor(kt.oq(this.f31049s, "tt_ssxinzi15"));
            }
            this.pz = this.nd.getAlpha();
            this.nd.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.nd.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.qa.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                TextView textView5 = this.nd;
                int applyDimension2 = (int) TypedValue.applyDimension(1, 1.0f, displayMetrics);
                Rect rect3 = this.wo;
                ed.xt(textView5, applyDimension2, rect3.top, rect3.right, rect3.bottom);
            }
        }
        View view = this.gx;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.wf = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.gx.setLayoutParams(layoutParams5);
            kt.j(this.f31049s, "tt_shadow_fullscreen_top", this.gx);
        }
        xt(this.ln, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void ae() {
        n nVar;
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(this.ch)) {
            f();
            return;
        }
        ed.m(this.f31048r);
        ed.m(this.up);
        ed.up(this.hh);
        if (this.f31044m != null && (nVar = this.ch) != null && !TextUtils.isEmpty(ln.xt(nVar))) {
            ed.m(this.f31044m);
            com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31044m);
            j(this.f31044m, ln.xt(this.ch));
        }
        if (this.cw.getVisibility() == 0) {
            ed.j((View) this.cw, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.ws.j
    public boolean az() {
        az azVar = this.f31033a;
        return azVar != null && azVar.j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void cw(boolean z5) {
        TextView textView = this.f31103n;
        if (textView != null) {
            ed.j((View) textView, (!this.tj && z5) ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void g() {
        this.f31101e.setProgress(0);
        this.f31101e.setSecondaryProgress(0);
        this.az.setProgress(0);
        this.az.setSecondaryProgress(0);
        this.f31104q.setText(kt.j(this.f31049s, "tt_00_00"));
        this.qb.setText(kt.j(this.f31049s, "tt_00_00"));
        r(8);
        if (l()) {
            this.xt.setVisibility(8);
        }
        ImageView imageView = this.f31044m;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.f31044m.setBackground(null);
        }
        r(8);
        ed.j(this.f31099b, 8);
        ed.j(this.tl, 8);
        ed.j((View) this.f31038g, 8);
        ed.j(this.oq, 8);
        ed.j((View) this.qv, 8);
        ed.j((View) this.vl, 8);
        ed.j((View) this.jy, 8);
        az azVar = this.f31033a;
        if (azVar != null) {
            azVar.j(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bykv.vk.openvk.component.video.api.r.xt
    @SuppressLint({"ClickableViewAccessibility"})
    public /* bridge */ /* synthetic */ void j(n nVar, WeakReference weakReference, boolean z5) {
        j(nVar, (WeakReference<Context>) weakReference, z5);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean jy() {
        return this.f31037f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.az.xt
    public boolean oq() {
        return this.xq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public boolean qv() {
        return this.tj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void tl() {
        ed.up(this.f31048r);
        ed.up(this.hh);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void up() {
        this.sm.removeMessages(1);
        this.sm.sendMessageDelayed(this.sm.obtainMessage(1), 2000L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.ws.j
    public void ws() {
        vl();
        cw(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    protected void j(Context context, View view, n nVar) {
        super.j(context, view, nVar);
        this.ed = (TextView) view.findViewById(2114387765);
        this.f31100c = (ImageView) view.findViewById(2114387684);
        this.gx = view.findViewById(2114387611);
        this.ol = (ImageView) view.findViewById(2114387903);
        this.f31103n = (TextView) view.findViewById(2114387736);
        this.nd = (TextView) view.findViewById(2114387712);
        this.rh = (TextView) view.findViewById(2114387852);
        this.hh = view.findViewById(2114387829);
        this.f31108z = (ImageView) view.findViewById(2114387624);
        this.hl = (TextView) view.findViewById(2114387866);
        this.f31101e = (SeekBar) view.findViewById(2114387878);
        this.f31104q = (TextView) view.findViewById(2114387674);
        this.qb = (TextView) view.findViewById(2114387817);
        this.f31099b = view.findViewById(2114387634);
        this.ya = (ImageView) view.findViewById(2114387667);
        this.ae = (TTViewStub) view.findViewById(2114387750);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void xt(boolean z5) {
        int i6 = oq() ? this.im : this.f31040i;
        int i7 = oq() ? this.xp : this.f31051w;
        if (this.kt <= 0 || this.mi <= 0 || i6 <= 0) {
            return;
        }
        if (!qv() && !oq() && !this.f31052x.contains(xt.j.fixedSize)) {
            i7 = this.f31049s.getResources().getDimensionPixelSize(kt.g(this.f31049s, "tt_video_container_maxheight"));
        }
        int i8 = this.mi;
        int i9 = this.kt;
        int i10 = (int) (i9 * ((i6 * 1.0f) / i8));
        if (i10 > i7) {
            i6 = (int) (i8 * ((i7 * 1.0f) / i9));
        } else {
            i7 = i10;
        }
        if (!z5 && !oq()) {
            i6 = this.f31040i;
            i7 = this.f31051w;
        }
        this.xt.j(i6, i7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void r(int i6) {
        this.f31050v = i6;
        ed.j(this.f31041j, i6);
        if (i6 != 0) {
            this.oy = false;
        } else if (this.ll) {
            this.oy = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(String str) {
        TextView textView = this.f31103n;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.nd;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void xt(int i6) {
        View view = this.f31099b;
        if (view != null && view.getVisibility() == 0) {
            ed.j((View) this.az, 8);
            return;
        }
        ed.j((View) this.az, 0);
        this.f31101e.setProgress(i6);
        this.az.setProgress(i6);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(long j6, long j7) {
        this.f31104q.setText(com.bykv.vk.openvk.component.video.j.up.j.j(j7));
        this.qb.setText(com.bykv.vk.openvk.component.video.j.up.j.j(j6));
        this.f31101e.setProgress(com.bykv.vk.openvk.component.video.j.up.j.j(j6, j7));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void xt(ViewGroup viewGroup) {
        View view;
        vl.r("FullScreen", "Detail exitFullScreen.....");
        if (viewGroup == null || (view = this.f31041j) == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.xq = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f31041j.getLayoutParams();
        marginLayoutParams.width = this.zz;
        marginLayoutParams.height = this.kc;
        marginLayoutParams.leftMargin = this.ry;
        marginLayoutParams.topMargin = this.ff;
        this.f31041j.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.aq);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            Rect rect = this.rr;
            ed.xt(viewGroup, rect.left, rect.top, rect.right, rect.bottom);
        }
        xt(true);
        kt.j(this.f31049s, "tt_enlarge_video", this.ya);
        this.f31101e.setThumb(xt(15, "#1E000000"));
        this.f31101e.setThumbOffset(0);
        com.bykv.vk.openvk.component.video.j.up.j.j(this.f31041j, true);
        m(this.xq);
        ed.j(this.gx, 8);
        if (this.f31052x.contains(xt.j.alwayShowBackBtn)) {
            ed.j((View) this.ed, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bykv.vk.openvk.component.video.api.r.xt
    public void j() {
        j(false, this.tj);
        ch();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(long j6) {
        this.qb.setText(com.bykv.vk.openvk.component.video.j.up.j.j(j6));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    @SuppressLint({"ClickableViewAccessibility"})
    public void j(n nVar, WeakReference<Context> weakReference, boolean z5) {
        n nVar2;
        if (nVar == null) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.video.cw.j.j(nVar)) {
            j(v.getContext(), this.f31041j);
            w();
            return;
        }
        j(this.f31041j, v.getContext());
        j(false, this.tj);
        ed.j(this.tl, 0);
        ed.j((View) this.f31038g, 0);
        ed.j(this.oq, 0);
        if (this.f31038g != null && (nVar2 = this.ch) != null && !TextUtils.isEmpty(ln.xt(nVar2))) {
            com.bytedance.sdk.openadsdk.g.xt.j(ln.xt(this.ch)).j(this.f31038g);
            j(this.f31038g, ln.xt(this.ch));
        }
        ed.j((View) this.ws, 0);
        ed.j((View) this.qv, 8);
        ed.j((View) this.vl, 8);
        ed.j((View) this.jy, 8);
        ed.j(this.ws, kt.j(this.f31049s, "tt_video_dial_replay"));
        ed.j(this.ws, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.up.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xt xtVar = up.this.f31043l;
                if (xtVar != null) {
                    xtVar.j();
                }
            }
        }, "video_ad_button");
        ed.j(this.ws, (View.OnTouchListener) null, "video_ad_button");
        if (la()) {
            ed.j(this.oq, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(ViewGroup viewGroup) {
        if (viewGroup != null && (this.f31041j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.xq = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f31041j.getLayoutParams();
            this.ry = marginLayoutParams.leftMargin;
            this.ff = marginLayoutParams.topMargin;
            this.zz = marginLayoutParams.width;
            this.kc = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.f31041j.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.aq = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.rr.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ed.xt(viewGroup, 0, 0, 0, 0);
            }
            xt(true);
            kt.j(this.f31049s, "tt_shrink_video", this.ya);
            this.f31101e.setThumb(xt(18, "#00000000"));
            this.f31101e.setThumbOffset(0);
            com.bykv.vk.openvk.component.video.j.up.j.j(this.f31041j, false);
            m(this.xq);
            ed.j(this.gx, 8);
            if (!this.tj) {
                ed.j((View) this.f31100c, 8);
                ed.j((View) this.ed, 8);
            } else if (this.f31052x.contains(xt.j.hideCloseBtn)) {
                ed.j((View) this.f31100c, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        if (message.what != 1) {
            return;
        }
        vl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(boolean z5, boolean z6, boolean z7) {
        ed.j(this.f31099b, 0);
        ed.j((View) this.az, 0);
        if (this.xq) {
            ed.j(this.gx, 0);
            ed.j((View) this.nd, 0);
        } else if (z7) {
            ed.j(this.gx, 8);
        }
        ed.j((View) this.cw, (!z5 || this.f31048r.getVisibility() == 0) ? 8 : 0);
        if (!this.tj && !this.xq) {
            if (!this.f31052x.contains(xt.j.hideCloseBtn) && !z7) {
                ed.j((View) this.f31100c, 0);
            }
            ed.j((View) this.ed, z7 ? 8 : 0);
        }
        ed.j((View) this.f31104q, 0);
        ed.j((View) this.qb, 0);
        if (la()) {
            ed.j((View) this.f31101e, 8);
        } else {
            ed.j((View) this.f31101e, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m
    public void j(boolean z5, boolean z6) {
        ed.j(this.f31099b, 8);
        ed.j(this.gx, 8);
        ed.j((View) this.az, z5 ? 0 : 8);
        ed.j((View) this.cw, 8);
        if (!this.tj && !this.xq) {
            ed.j((View) this.f31100c, 8);
            if (!this.f31052x.contains(xt.j.alwayShowBackBtn)) {
                ed.j((View) this.ed, 8);
            }
        } else if (this.f31052x.contains(xt.j.hideCloseBtn)) {
            ed.j((View) this.f31100c, 8);
        }
        if (z6) {
            ed.j((View) this.f31100c, 8);
            ed.j((View) this.ed, 8);
        }
        cw(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.m, com.bytedance.sdk.openadsdk.core.widget.ws.j
    public void j(View view, boolean z5) {
        if (oq()) {
            String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            n nVar = this.ch;
            if (nVar != null && !TextUtils.isEmpty(nVar.hw())) {
                j(this.ch.hw());
            }
            this.rh.setText(format);
        } else {
            j("");
            this.rh.setText("");
        }
        if (this.f31046p) {
            return;
        }
        cw(this.tj && !this.xq);
        if (tj()) {
            this.f31043l.j(this, view, true, this.f31048r.getVisibility() != 0);
        }
    }
}
