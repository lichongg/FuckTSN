package com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.oq;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import com.bytedance.sdk.openadsdk.core.tj.rh;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends j {
    j xt;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.business.xt.j.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j j(oq oqVar) {
        ArrayList<qa> up = rh.up(this.ae);
        if (up == null) {
            return new xt.j(false, 0, "");
        }
        Iterator<qa> it = up.iterator();
        while (it.hasNext()) {
            qa next = it.next();
            if (next.cw() == 1) {
                this.xt = new cw(this.tl, this.ae, next);
            }
            j jVar = this.xt;
            if (jVar != null) {
                jVar.cw(this.vl);
                this.xt.r(this.qv);
                this.xt.j(this.f28138j);
                this.xt.xt(g());
                this.xt.j(this.av);
                xt.j j6 = this.xt.j(oqVar);
                if (j6.cw()) {
                    return j6;
                }
            }
        }
        return new xt.j(false, 0, "");
    }

    public r(Activity activity, n nVar) {
        super(activity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void xt(String str) {
        super.xt(str);
        j jVar = this.xt;
        if (jVar == null) {
            return;
        }
        jVar.xt(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        j jVar = this.xt;
        if (jVar == null) {
            return null;
        }
        return jVar.j();
    }
}
