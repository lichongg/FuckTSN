package com.bytedance.sdk.openadsdk.core.g.j.xt;

import android.app.Dialog;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.umeng.analytics.pro.d;
import java.util.Map;

@com.bytedance.sdk.component.qv.xt.xt
/* loaded from: D:\Downloads\app\classes4.dex */
public class m implements com.bytedance.sdk.component.qv.j.j.cw {

    @com.bytedance.sdk.component.qv.xt.j(j = d.X)
    private Context cw;

    /* renamed from: j, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "outer_dislike")
    private Dialog f29061j;

    /* renamed from: r, reason: collision with root package name */
    @com.bytedance.sdk.component.qv.xt.j(j = "material_meta")
    private n f29062r;

    @com.bytedance.sdk.component.qv.xt.j(j = "ad_dislike")
    private com.bytedance.sdk.openadsdk.core.dislike.ui.j xt;

    @Override // com.bytedance.sdk.component.qv.j.j.cw
    public boolean j(Map<String, Object> map, Map<String, Object> map2, com.bytedance.sdk.component.qv.j.j jVar) {
        Dialog dialog = this.f29061j;
        if (dialog != null) {
            dialog.show();
            jVar.j(map2);
            return true;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.j jVar2 = this.xt;
        if (jVar2 != null) {
            jVar2.j();
            jVar.j(map2);
            return true;
        }
        TTDelegateActivity.j(this.cw, this.f29062r);
        jVar.j(map2);
        return true;
    }
}
