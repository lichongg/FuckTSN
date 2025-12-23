package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.CircleLongPressView;
import com.bytedance.sdk.component.adexpress.widget.RippleView;
import com.tencent.connect.common.Constants;

/* loaded from: D:\Downloads\app\classes4.dex */
public class InteractViewContainer extends FrameLayout implements tl {
    private RippleView ae;
    private com.bytedance.sdk.component.adexpress.dynamic.cw.ae cw;

    /* renamed from: g, reason: collision with root package name */
    private int f25714g;

    /* renamed from: j, reason: collision with root package name */
    private Context f25715j;

    /* renamed from: m, reason: collision with root package name */
    private String f25716m;
    private boolean oq;
    private com.bytedance.sdk.component.adexpress.dynamic.cw.oq qv;

    /* renamed from: r, reason: collision with root package name */
    private View f25717r;
    private View.OnTouchListener tl;
    private ae up;
    private com.bytedance.sdk.component.adexpress.xt.jy vl;
    private DynamicBaseWidget xt;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        super(context);
        this.f25715j = context;
        this.xt = dynamicBaseWidget;
        this.cw = aeVar;
        ae();
    }

    private void ae() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f25716m = this.cw.nd();
        this.f25714g = this.cw.hh();
        this.oq = this.cw.sm();
        ae j6 = g.j(this.f25715j, this.xt, this.cw, this.qv, this.vl);
        this.up = j6;
        if (j6 != null) {
            this.f25717r = j6.cw();
            if (this.cw.rh()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.f25716m, "6")) {
                if (!this.cw.xq() || TextUtils.isEmpty(this.cw.k())) {
                    this.ae = new RippleView(this.f25715j, Color.parseColor("#99000000"));
                } else {
                    this.ae = new RippleView(this.f25715j, com.bytedance.sdk.component.adexpress.dynamic.cw.ae.j(this.cw.k()));
                }
                FrameLayout frameLayout = new FrameLayout(this.f25715j);
                frameLayout.addView(this.ae, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.ae.xt();
                    }
                });
            }
            if (j(this.f25716m) && com.bytedance.sdk.component.adexpress.r.j()) {
                int parseColor = Color.parseColor("#99000000");
                if (this.cw.xq() && !TextUtils.isEmpty(this.cw.k())) {
                    try {
                        parseColor = com.bytedance.sdk.component.adexpress.dynamic.cw.ae.j(this.cw.k());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.f25715j);
                view.setBackgroundColor(parseColor);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.up.cw());
            j(this.up.cw());
            setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.tl != null) {
            setOnClickListener((View.OnClickListener) this.xt.getDynamicClickListener());
            performClick();
            if (this.cw.xp()) {
                return;
            }
            setVisibility(8);
        }
    }

    private boolean j(String str) {
        return TextUtils.equals(str, Constants.VIA_REPORT_TYPE_CHAT_AIO) || TextUtils.equals(str, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR) || TextUtils.equals(str, Constants.VIA_REPORT_TYPE_CHAT_AUDIO) || TextUtils.equals(str, Constants.VIA_REPORT_TYPE_DATALINE) || TextUtils.equals(str, "1");
    }

    private boolean tl() {
        return (this.cw.sm() || TextUtils.equals("9", this.f25716m) || TextUtils.equals(Constants.VIA_REPORT_TYPE_START_WAP, this.f25716m) || TextUtils.equals(Constants.VIA_REPORT_TYPE_START_GROUP, this.f25716m) || TextUtils.equals("18", this.f25716m) || TextUtils.equals("20", this.f25716m) || TextUtils.equals("29", this.f25716m) || TextUtils.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, this.f25716m)) ? false : true;
    }

    public void cw() {
        ae aeVar = this.up;
        if (aeVar != null) {
            aeVar.j();
        }
    }

    public void m() {
        if (this.f25717r != null && TextUtils.equals(this.f25716m, "2")) {
            View view = this.f25717r;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).r();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.tl instanceof com.bytedance.sdk.component.adexpress.dynamic.interact.j.cw) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void r() {
        ae aeVar = this.up;
        if (aeVar != null) {
            aeVar.xt();
        }
    }

    public void up() {
        if (this.f25717r != null && TextUtils.equals(this.f25716m, "2")) {
            View view = this.f25717r;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).cw();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.tl
    public void xt() {
        if (tl()) {
            setOnClickListener((View.OnClickListener) this.xt.getDynamicClickListener());
            performClick();
            if (this.cw.xp()) {
                return;
            }
            setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            ae aeVar = this.up;
            if (aeVar != null) {
                aeVar.xt();
            }
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.cw(e6.getMessage());
        }
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, com.bytedance.sdk.component.adexpress.xt.jy jyVar) {
        super(context);
        this.f25715j = context;
        this.xt = dynamicBaseWidget;
        this.cw = aeVar;
        this.qv = oqVar;
        this.vl = jyVar;
        ae();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0117, code lost:
    
        if (r2.equals("2") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(android.view.ViewGroup r8) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.j(android.view.ViewGroup):void");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.tl
    public void j() {
        if (TextUtils.equals(this.f25716m, "6")) {
            RippleView rippleView = this.ae;
            if (rippleView != null) {
                rippleView.cw();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.g();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.f25716m, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer.3
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.g();
                }
            }, 400L);
        } else {
            g();
        }
    }
}
