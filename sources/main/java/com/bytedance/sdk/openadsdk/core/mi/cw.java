package com.bytedance.sdk.openadsdk.core.mi;

import android.content.Context;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.az.tl;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    private tl f29517j;
    private com.bytedance.sdk.openadsdk.az.j xt;

    public tl j(Context context, SSWebView sSWebView, com.bytedance.sdk.openadsdk.az.cw cwVar, com.bytedance.sdk.openadsdk.az.j jVar, Set<String> set, tl.j jVar2) {
        com.bytedance.sdk.openadsdk.az.j jVar3;
        if (this.f29517j == null) {
            jVar3 = jVar;
            tl j6 = tl.j(context, sSWebView, cwVar, jVar3, set, jVar2, true);
            this.f29517j = j6;
            j6.r(false);
        } else {
            jVar3 = jVar;
        }
        this.xt = jVar3;
        return this.f29517j;
    }
}
