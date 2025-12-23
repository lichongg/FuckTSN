package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.cw.oq;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ClickSlideUpShakeView extends SlideUpView {

    /* renamed from: j, reason: collision with root package name */
    private ShakeClickView f25890j;

    private void j(Context context, oq oqVar, boolean z5, int i6) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.cw.j.cw(context), oqVar, z5, i6);
        this.f25890j = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f25890j.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.f25890j;
    }

    public void setShakeText(String str) {
        if (this.f25890j == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f25890j.setShakeText("");
        } else {
            this.f25890j.setShakeText(str);
        }
    }

    public ClickSlideUpShakeView(Context context, oq oqVar, boolean z5, int i6) {
        super(context);
        j(context, oqVar, z5, i6);
    }
}
