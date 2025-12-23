package com.bytedance.adsdk.ugeno.widget.scroll;

import android.content.Context;
import android.widget.ScrollView;
import com.bytedance.adsdk.ugeno.widget.frame.j;
import com.bytedance.adsdk.ugeno.xt.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends com.bytedance.adsdk.ugeno.xt.j<ScrollView> {
    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: qb, reason: merged with bridge method [inline-methods] */
    public ScrollView j() {
        UGScrollView uGScrollView = new UGScrollView(this.xt);
        uGScrollView.j(this);
        return uGScrollView;
    }

    @Override // com.bytedance.adsdk.ugeno.xt.j
    public j.C0328j tl() {
        return new j.C0325j(this);
    }

    public j(Context context) {
        super(context);
    }
}
