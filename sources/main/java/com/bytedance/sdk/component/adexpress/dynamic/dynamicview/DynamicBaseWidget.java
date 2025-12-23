package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.sdk.component.adexpress.dynamic.cw.ae;
import com.bytedance.sdk.component.adexpress.dynamic.cw.m;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.xt.jy;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.vl;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class DynamicBaseWidget extends FrameLayout implements com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt, r, up {

    /* renamed from: v, reason: collision with root package name */
    private static final View.OnTouchListener f25653v = new View.OnTouchListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.1
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private static final View.OnClickListener f25654x = new View.OnClickListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    };
    protected int ae;
    protected boolean av;
    protected View az;
    protected float cw;

    /* renamed from: f, reason: collision with root package name */
    private boolean f25655f;

    /* renamed from: g, reason: collision with root package name */
    protected int f25656g;

    /* renamed from: i, reason: collision with root package name */
    protected com.bytedance.sdk.component.adexpress.dynamic.animation.j.xt f25657i;

    /* renamed from: j, reason: collision with root package name */
    private float f25658j;
    protected tl jy;
    private float kt;

    /* renamed from: m, reason: collision with root package name */
    protected float f25659m;
    private float mi;
    protected int oq;
    protected Context qv;

    /* renamed from: r, reason: collision with root package name */
    protected float f25660r;
    private f tj;
    protected int tl;
    protected float up;
    protected ae vl;

    /* renamed from: w, reason: collision with root package name */
    com.bytedance.sdk.component.adexpress.dynamic.animation.view.j f25661w;
    protected DynamicRootView ws;
    private float xt;

    protected Drawable getBackgroundDrawable() {
        return j(false, "");
    }

    protected void xt(View view) {
        m up;
        tl tlVar = this.jy;
        if (tlVar == null || (up = tlVar.oq().up()) == null) {
            return;
        }
        view.setTag(2097610716, Boolean.valueOf(up.nu()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq() {
        try {
            View view = this.az;
            if (view == null) {
                view = this;
            }
            view.setOnClickListener((View.OnClickListener) getDynamicClickListener());
            view.performClick();
            view.setOnClickListener(f25654x);
        } catch (Exception unused) {
        }
    }

    protected boolean ae() {
        tl tlVar = this.jy;
        return tlVar == null || tlVar.oq() == null || this.jy.oq().up() == null || this.jy.oq().up().qe() == null;
    }

    protected boolean cw() {
        View.OnTouchListener onTouchListener;
        View.OnClickListener onClickListener;
        View view = this.az;
        if (view == null) {
            view = this;
        }
        if (r()) {
            onTouchListener = (View.OnTouchListener) getDynamicClickListener();
            onClickListener = (View.OnClickListener) getDynamicClickListener();
        } else {
            onTouchListener = f25653v;
            onClickListener = f25654x;
        }
        if (onTouchListener != null && onClickListener != null) {
            view.setOnTouchListener(onTouchListener);
            view.setOnClickListener(onClickListener);
            int j6 = com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(this.vl);
            if (j6 == 2 || j6 == 3) {
                view.setOnClickListener(f25654x);
            } else {
                view.setOnClickListener(onClickListener);
            }
        }
        j(view);
        xt(view);
        return true;
    }

    public boolean getBeginInvisibleAndShow() {
        return this.av;
    }

    public int getClickArea() {
        return this.vl.a();
    }

    protected GradientDrawable getDrawable() {
        return new GradientDrawable();
    }

    public com.bytedance.sdk.component.adexpress.dynamic.up.j getDynamicClickListener() {
        return this.ws.getDynamicClickListener();
    }

    public int getDynamicHeight() {
        return this.tl;
    }

    public m getDynamicLayoutBrickValue() {
        com.bytedance.sdk.component.adexpress.dynamic.cw.up oq;
        tl tlVar = this.jy;
        if (tlVar == null || (oq = tlVar.oq()) == null) {
            return null;
        }
        return oq.up();
    }

    public int getDynamicWidth() {
        return this.ae;
    }

    public String getImageObjectFit() {
        return this.vl.qb();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getMarqueeValue() {
        return this.mi;
    }

    protected Drawable getMutilBackgroundDrawable() {
        try {
            return new LayerDrawable(j(xt(this.vl.uf().replaceAll("/\\*.*\\*/", ""))));
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getRippleValue() {
        return this.f25658j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xt
    public float getShineValue() {
        return this.xt;
    }

    public float getStretchValue() {
        return this.kt;
    }

    public boolean j() {
        tl();
        up();
        cw();
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z5) {
        if (this.tj != null) {
            DynamicRootView dynamicRootView = this.ws;
            if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null) {
                if (z5) {
                    this.tj.j(0);
                    return;
                } else {
                    this.tj.xt(0);
                    return;
                }
            }
            if (z5) {
                this.tj.j(this.ws.getRenderRequest().p());
            } else {
                this.tj.xt(this.ws.getRenderRequest().p());
            }
        }
    }

    public boolean r() {
        ae aeVar = this.vl;
        return (aeVar == null || aeVar.a() == 0) ? false : true;
    }

    public void setCanUseSensor(boolean z5) {
        this.f25655f = z5;
    }

    public void setMarqueeValue(float f6) {
        this.mi = f6;
        postInvalidate();
    }

    public void setRippleValue(float f6) {
        this.f25658j = f6;
        postInvalidate();
    }

    public void setShineValue(float f6) {
        this.xt = f6;
        postInvalidate();
    }

    public void setShouldInvisible(boolean z5) {
        this.av = z5;
    }

    public void setStretchValue(float f6) {
        this.kt = f6;
        this.f25661w.j(this, f6);
    }

    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ae, this.tl);
        layoutParams.topMargin = this.oq;
        int i6 = this.f25656g;
        layoutParams.leftMargin = i6;
        layoutParams.setMarginStart(i6);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicBaseWidget(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context);
        this.f25655f = true;
        this.qv = context;
        this.ws = dynamicRootView;
        this.jy = tlVar;
        this.cw = tlVar.m();
        this.f25660r = tlVar.ae();
        this.up = tlVar.tl();
        this.f25659m = tlVar.g();
        this.f25656g = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.cw);
        this.oq = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.f25660r);
        this.ae = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.up);
        this.tl = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.f25659m);
        ae aeVar = new ae(tlVar.oq());
        this.vl = aeVar;
        if (aeVar.w() > 0) {
            this.ae += this.vl.w() * 2;
            this.tl += this.vl.w() * 2;
            this.f25656g -= this.vl.w();
            this.oq -= this.vl.w();
            List<tl> qv = tlVar.qv();
            if (qv != null) {
                for (tl tlVar2 : qv) {
                    tlVar2.cw(tlVar2.m() + com.bytedance.sdk.component.adexpress.r.tl.xt(this.qv, this.vl.w()));
                    tlVar2.r(tlVar2.ae() + com.bytedance.sdk.component.adexpress.r.tl.xt(this.qv, this.vl.w()));
                    tlVar2.j(com.bytedance.sdk.component.adexpress.r.tl.xt(this.qv, this.vl.w()));
                    tlVar2.xt(com.bytedance.sdk.component.adexpress.r.tl.xt(this.qv, this.vl.w()));
                }
            }
        }
        this.av = this.vl.ws() > 0.0d;
        this.f25661w = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.j();
    }

    private void g() {
        if (isShown()) {
            int j6 = com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(this.vl);
            if (j6 == 2) {
                if (this.tj == null) {
                    this.tj = new f(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 1, this.f25655f);
                }
                this.tj.j(new f.j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.3
                    @Override // com.bytedance.sdk.component.utils.f.j
                    public void j(int i6) {
                        if (i6 == 1 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.oq();
                        }
                    }
                });
                jy renderRequest = this.ws.getRenderRequest();
                if (renderRequest != null) {
                    this.tj.j(renderRequest.w());
                    this.tj.up(renderRequest.x());
                    this.tj.cw(renderRequest.f());
                    this.tj.xt(renderRequest.kt());
                    this.tj.m(renderRequest.ch());
                    this.tj.j(renderRequest.tj());
                    this.tj.xt(renderRequest.v());
                }
            } else if (j6 == 3) {
                if (this.tj == null) {
                    this.tj = new f(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 2, this.f25655f);
                }
                this.tj.j(new f.j() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget.4
                    @Override // com.bytedance.sdk.component.utils.f.j
                    public void j(int i6) {
                        if (i6 == 2 && DynamicBaseWidget.this.isShown()) {
                            DynamicBaseWidget.this.oq();
                        }
                    }
                });
                jy renderRequest2 = this.ws.getRenderRequest();
                if (renderRequest2 != null) {
                    this.tj.xt(renderRequest2.kt());
                    this.tj.m(renderRequest2.ch());
                    this.tj.j(renderRequest2.tj());
                    this.tj.xt(renderRequest2.v());
                }
            }
            f fVar = this.tj;
            if (fVar != null) {
                DynamicRootView dynamicRootView = this.ws;
                if (dynamicRootView != null) {
                    jy renderRequest3 = dynamicRootView.getRenderRequest();
                    if (renderRequest3 != null) {
                        this.tj.j(renderRequest3.p());
                        return;
                    }
                    return;
                }
                fVar.j(0);
            }
        }
    }

    public void m() {
        if (ae()) {
            return;
        }
        View view = this.az;
        if (view == null) {
            view = this;
        }
        com.bytedance.sdk.component.adexpress.dynamic.animation.j.xt xtVar = new com.bytedance.sdk.component.adexpress.dynamic.animation.j.xt(view, this.jy.oq().up().qe());
        this.f25657i = xtVar;
        xtVar.j();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        xt();
        super.onDetachedFromWindow();
        if (this.tj != null) {
            DynamicRootView dynamicRootView = this.ws;
            if (dynamicRootView != null && dynamicRootView.getRenderRequest() != null) {
                this.tj.xt(this.ws.getRenderRequest().p());
            } else {
                this.tj.xt(0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f25661w.j(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.j jVar = this.f25661w;
        View view = this.az;
        if (view == null) {
            view = this;
        }
        jVar.j(view, i6, i7);
    }

    private List<String> xt(String str) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        boolean z5 = false;
        int i7 = 0;
        for (int i8 = 0; i8 < str.length(); i8++) {
            if (str.charAt(i8) == '(') {
                i6++;
                z5 = true;
            } else if (str.charAt(i8) == ')' && i6 - 1 == 0 && z5) {
                int i9 = i8 + 1;
                arrayList.add(str.substring(i7, i9));
                i7 = i9;
                z5 = false;
            }
        }
        return arrayList;
    }

    public void j(int i6) {
        ae aeVar = this.vl;
        if (aeVar != null && aeVar.j(i6)) {
            tl();
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt != null && (getChildAt(i7) instanceof DynamicBaseWidget)) {
                    ((DynamicBaseWidget) childAt).j(i6);
                }
            }
        }
    }

    public void xt() {
        com.bytedance.sdk.component.adexpress.dynamic.animation.j.xt xtVar = this.f25657i;
        if (xtVar != null) {
            xtVar.xt();
        }
    }

    protected void j(View view) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.jy.tl());
            jSONObject.put("height", this.jy.g());
            if (com.bytedance.sdk.component.adexpress.r.j()) {
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.j.kt, this.vl.ed());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.j.tj, this.jy.oq().getType());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.j.f25770f, this.jy.cw());
                view.setTag(com.bytedance.sdk.component.adexpress.dynamic.j.f25776v, jSONObject.toString());
                return;
            }
            view.setTag(2097610717, this.vl.ed());
            view.setTag(2097610715, this.jy.oq().getType());
            view.setTag(2097610714, this.jy.cw());
            view.setTag(2097610713, jSONObject.toString());
            int j6 = com.bytedance.sdk.component.adexpress.dynamic.xt.j.j(this.vl);
            if (j6 == 1) {
                view.setTag(2097610707, new Pair(this.vl.ch(), Long.valueOf(this.vl.s())));
                view.setTag(2097610708, Integer.valueOf(j6));
            }
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }

    protected Drawable j(boolean z5, String str) {
        String[] split;
        int[] iArr;
        int l6;
        if (!TextUtils.isEmpty(this.vl.uf())) {
            try {
                String uf = this.vl.uf();
                String substring = uf.substring(uf.indexOf("(") + 1, uf.length() - 1);
                if (substring.contains("rgba") && substring.contains("%")) {
                    split = new String[]{substring.substring(0, substring.indexOf(",")).trim(), substring.substring(substring.indexOf(",") + 1, substring.indexOf("%") + 1).trim(), substring.substring(substring.indexOf("%") + 2).trim()};
                    iArr = new int[]{ae.j(split[1]), ae.j(split[2])};
                } else {
                    split = substring.split(", ");
                    iArr = new int[]{ae.j(split[1].substring(0, 7)), ae.j(split[2].substring(0, 7))};
                }
                try {
                    double parseDouble = Double.parseDouble(substring.substring(substring.indexOf("linear-gradient(") + 1, substring.indexOf("deg")));
                    if (parseDouble > 225.0d && parseDouble < 315.0d) {
                        int i6 = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = i6;
                    }
                } catch (Exception unused) {
                }
                GradientDrawable j6 = j(j(split[0]), iArr);
                j6.setShape(0);
                j6.setCornerRadius(com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.az()));
                return j6;
            } catch (Exception unused2) {
                Drawable mutilBackgroundDrawable = getMutilBackgroundDrawable();
                if (mutilBackgroundDrawable != null) {
                    return mutilBackgroundDrawable;
                }
            }
        }
        GradientDrawable drawable = getDrawable();
        drawable.setShape(0);
        float j7 = com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.az());
        drawable.setCornerRadius(j7);
        if (j7 < 1.0f) {
            float j8 = com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.h());
            float j9 = com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.la());
            float j10 = com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.gq());
            float j11 = com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.rn());
            float[] fArr = new float[8];
            if (j8 > 0.0f) {
                fArr[0] = j8;
                fArr[1] = j8;
            }
            if (j9 > 0.0f) {
                fArr[2] = j9;
                fArr[3] = j9;
            }
            if (j10 > 0.0f) {
                fArr[4] = j10;
                fArr[5] = j10;
            }
            if (j11 > 0.0f) {
                fArr[6] = j11;
                fArr[7] = j11;
            }
            drawable.setCornerRadii(fArr);
        }
        if (z5) {
            l6 = Color.parseColor(str);
        } else {
            l6 = this.vl.l();
        }
        drawable.setColor(l6);
        if (this.vl.i() > 0.0f) {
            drawable.setStroke((int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.i()), this.vl.av());
        } else if (this.vl.w() > 0) {
            drawable.setStroke(this.vl.w(), this.vl.av());
            drawable.setAlpha(50);
            if (TextUtils.equals(this.jy.oq().getType(), "video-vd")) {
                setLayerType(1, null);
                return new cw((int) j7, this.vl.w());
            }
        }
        return drawable;
    }

    protected xt j(Bitmap bitmap) {
        return new j(bitmap, null);
    }

    private Drawable[] j(List<String> list) {
        Drawable[] drawableArr = new Drawable[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            String str = list.get(i6);
            if (str.contains("linear-gradient")) {
                String[] split = str.substring(str.indexOf("(") + 1, str.length() - 1).split(", ");
                int length = split.length - 1;
                int[] iArr = new int[length];
                int i7 = 0;
                while (i7 < length) {
                    int i8 = i7 + 1;
                    iArr[i7] = ae.j(split[i8].substring(0, 7));
                    i7 = i8;
                }
                GradientDrawable j6 = j(j(split[0]), iArr);
                j6.setShape(0);
                j6.setCornerRadius(com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, this.vl.az()));
                drawableArr[(list.size() - 1) - i6] = j6;
            }
        }
        return drawableArr;
    }

    protected GradientDrawable j(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            if (iArr.length == 1) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(iArr[0]);
                return gradientDrawable;
            }
            return new GradientDrawable(orientation, iArr);
        }
        return new GradientDrawable();
    }

    protected GradientDrawable.Orientation j(String str) {
        try {
            int parseFloat = (int) Float.parseFloat(str.substring(0, str.length() - 3));
            if (parseFloat <= 90) {
                return GradientDrawable.Orientation.LEFT_RIGHT;
            }
            if (parseFloat <= 180) {
                return GradientDrawable.Orientation.TOP_BOTTOM;
            }
            if (parseFloat <= 270) {
                return GradientDrawable.Orientation.RIGHT_LEFT;
            }
            return GradientDrawable.Orientation.BOTTOM_TOP;
        } catch (Exception unused) {
            return GradientDrawable.Orientation.LEFT_RIGHT;
        }
    }
}
