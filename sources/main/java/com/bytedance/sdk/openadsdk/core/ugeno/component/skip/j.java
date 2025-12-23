package com.bytedance.sdk.openadsdk.core.ugeno.component.skip;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.adsdk.ugeno.xt.cw;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends cw<CycleSkipView> {
    @Override // com.bytedance.adsdk.ugeno.xt.cw
    public void xt() {
        super.xt();
    }

    @Override // com.bytedance.adsdk.ugeno.xt.cw
    /* renamed from: ae, reason: merged with bridge method [inline-methods] */
    public CycleSkipView j() {
        return new CycleSkipView(this.xt);
    }

    public void xt(int i6, int i7) {
        T t5 = this.up;
        if (t5 != 0) {
            ((CycleSkipView) t5).j(i6, i7);
        }
    }

    public j(@NonNull Context context) {
        super(context);
    }
}
