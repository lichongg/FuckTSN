package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.tl;
import com.bytedance.sdk.component.adexpress.r.ae;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.cw {

    /* renamed from: f, reason: collision with root package name */
    private boolean f25700f;

    /* renamed from: j, reason: collision with root package name */
    int f25701j;
    private int kt;
    private int tj;
    boolean xt;

    private void g() {
        List<tl> qv = this.jy.qv();
        if (qv == null || qv.size() <= 0) {
            return;
        }
        Iterator<tl> it = qv.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            tl next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.oq().getType())) {
                int j6 = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.qv, next.tl() + (com.bytedance.sdk.component.adexpress.r.j() ? next.jy() : 0));
                this.kt = j6;
                this.f25701j = this.ae - j6;
            }
        }
        this.tj = this.ae - this.f25701j;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.cw
    public void j(CharSequence charSequence, boolean z5, int i6, boolean z6) {
        if (z6 && this.f25700f != z6) {
            this.f25700f = z6;
            up();
            return;
        }
        if (z5 && this.xt != z5) {
            this.xt = z5;
            up();
        }
        this.xt = z5;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.r
    public boolean tl() {
        if (ae.xt(this.ws.getRenderRequest().m())) {
            return true;
        }
        super.tl();
        setPadding((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.xt()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r()), (int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.j()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void up() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.xt) {
            layoutParams.leftMargin = this.f25656g;
        } else {
            layoutParams.leftMargin = this.f25656g + this.tj;
        }
        if (this.f25700f && this.vl != null) {
            layoutParams.leftMargin = ((this.f25656g + this.tj) - ((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw()))) - ((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r()));
        }
        if (com.bytedance.sdk.component.adexpress.r.j()) {
            layoutParams.topMargin = this.oq - ((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.xt()));
        } else {
            layoutParams.topMargin = this.oq;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, tl tlVar) {
        super(context, dynamicRootView, tlVar);
        this.tj = 0;
        setTag(Integer.valueOf(getClickArea()));
        g();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().l()) {
            View view = this.az;
            if (view != null) {
                view.setVisibility(8);
            }
            setVisibility(8);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i6, int i7) {
        super.onMeasure(i6, i7);
        if (this.f25700f && this.vl != null) {
            setMeasuredDimension(this.kt + ((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.cw())) + ((int) com.bytedance.sdk.component.adexpress.r.tl.j(com.bytedance.sdk.component.adexpress.r.getContext(), this.vl.r())), this.tl);
        } else if (this.xt) {
            setMeasuredDimension(this.ae, this.tl);
        } else {
            setMeasuredDimension(this.f25701j, this.tl);
        }
    }
}
