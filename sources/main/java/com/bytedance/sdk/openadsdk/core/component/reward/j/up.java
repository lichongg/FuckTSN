package com.bytedance.sdk.openadsdk.core.component.reward.j;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends xt {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile up xt;

    public static up j() {
        if (xt == null) {
            synchronized (up.class) {
                try {
                    if (xt == null) {
                        xt = new up(v.getContext());
                    }
                } finally {
                }
            }
        }
        return xt;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.j.xt
    protected boolean xt() {
        return true;
    }

    private up(Context context) {
        super(context);
    }

    public void j(com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar, String str, int i6, cw cwVar) {
        com.bytedance.sdk.openadsdk.core.component.reward.business.xt.cw cwVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.business.xt.cw();
        cwVar2.j(str);
        cwVar2.j(i6 + 1);
        j(xtVar, cwVar, cwVar2);
    }
}
