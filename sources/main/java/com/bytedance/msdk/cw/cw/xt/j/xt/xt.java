package com.bytedance.msdk.cw.cw.xt.j.xt;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cm;
import com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.gq;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class xt extends com.bytedance.msdk.cw.cw.xt.j.xt {
    public gq j(Context context) {
        gq csjLoader = DispatchAdSdkInitializerHolder.getCsjLoader(context);
        if (csjLoader == null) {
            j(new com.bytedance.msdk.api.j("ClassCastException：load ad fail loader is null"));
        }
        return csjLoader;
    }

    public xt(com.bytedance.msdk.cw.j.xt xtVar) {
        super(xtVar);
    }

    @Override // com.bytedance.msdk.cw.j.j
    public String j(String str) {
        try {
            return com.bytedance.sdk.gromore.init.j.cw();
        } catch (Exception unused) {
            return cm.f10901d;
        }
    }
}
