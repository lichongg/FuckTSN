package com.bytedance.sdk.openadsdk.core.component.reward.j.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.rn.a;
import com.bytedance.sdk.openadsdk.core.rn.h;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private static final com.bytedance.sdk.component.r.j.xt f28289j = h.j("full_reward_adslot");

    public com.bytedance.sdk.openadsdk.i.cw.cw.xt j(String str) {
        try {
            return a.j(f28289j.xt(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public void j(String str, com.bytedance.sdk.openadsdk.i.cw.cw.xt xtVar) {
        if (xtVar != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                f28289j.j(str, a.j(xtVar, str).toString());
            } catch (Throwable unused) {
            }
        }
    }
}
