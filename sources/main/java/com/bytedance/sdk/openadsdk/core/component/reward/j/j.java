package com.bytedance.sdk.openadsdk.core.component.reward.j;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends xt {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile j xt;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.j.xt
    protected boolean xt() {
        return false;
    }

    public static j j() {
        if (xt == null) {
            synchronized (j.class) {
                try {
                    if (xt == null) {
                        xt = new j(v.getContext());
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    private j(Context context) {
        super(context);
    }
}
