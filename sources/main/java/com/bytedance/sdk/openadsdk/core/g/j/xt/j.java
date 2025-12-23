package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.umeng.analytics.pro.d;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "url")
    private String f29056j;

    @com.bytedance.sdk.component.qv.xt.j(j = "title")
    private String xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        TTDelegateActivity.r(this.cw, this.f29056j, this.xt);
        jVar.j(map2);
        return true;
    }
}
