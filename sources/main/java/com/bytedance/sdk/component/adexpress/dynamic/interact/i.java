package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.SlideUpView;

/* loaded from: D:\Downloads\app\classes4.dex */
public class i<E extends SlideUpView> implements ae<E> {
    protected DynamicBaseWidget cw;

    /* renamed from: j, reason: collision with root package name */
    protected SlideUpView f25724j;

    /* renamed from: r, reason: collision with root package name */
    protected com.bytedance.sdk.component.adexpress.dynamic.cw.ae f25725r;
    protected int up;
    protected Context xt;

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, int i6) {
        this.up = i6;
        this.xt = context;
        this.cw = dynamicBaseWidget;
        this.f25725r = aeVar;
        r();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void j() {
        this.f25724j.j();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public E cw() {
        return (E) this.f25724j;
    }

    protected void r() {
        this.f25724j = new SlideUpView(this.xt, this.f25725r.nd());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, 200.0f));
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.r.tl.j(this.xt, 100 - this.up);
        this.f25724j.setLayoutParams(layoutParams);
        try {
            this.f25724j.setGuideText(this.f25725r.q());
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ae
    public void xt() {
        this.f25724j.xt();
    }

    public i(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar) {
        this(context, dynamicBaseWidget, aeVar, 0);
    }
}
