package com.bytedance.sdk.openadsdk.core.component.reward.cw;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.core.component.reward.cw.xt;
import com.bytedance.sdk.openadsdk.core.tj.e;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.qa;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy extends j {

    /* renamed from: i, reason: collision with root package name */
    j f28170i;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.j, com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public xt.j xt(oq oqVar) {
        ArrayList<qa> kt = e.kt(this.ae);
        if (kt == null) {
            return new xt.j(false, 0, "");
        }
        Iterator<qa> it = kt.iterator();
        while (it.hasNext()) {
            qa next = it.next();
            switch (next.cw()) {
                case 1:
                    this.f28170i = new vl(this.tl, this.ae, next);
                    break;
                case 2:
                    this.f28170i = new qv(this.tl, this.ae, next);
                    break;
                case 3:
                    this.f28170i = new m(this.tl, this.ae, next);
                    break;
                case 4:
                    this.f28170i = new ae(this.tl, this.ae, next);
                    break;
                case 5:
                    this.f28170i = new g(this.tl, this.ae, next);
                    break;
                case 6:
                    this.f28170i = new r(this.tl, this.ae, next);
                    break;
            }
            j jVar = this.f28170i;
            if (jVar != null) {
                jVar.j(this.cw);
                this.f28170i.j(this.f28167j);
                this.f28170i.xt(this.xt);
                this.f28170i.xt(this.f28169r);
                this.f28170i.cw(this.vl);
                this.f28170i.r(this.qv);
                this.f28170i.cw(this.f28168m);
                this.f28170i.r(this.up);
                this.f28170i.j(this.av);
                this.f28170i.xt(g());
                xt.j xt = this.f28170i.xt(oqVar);
                if (xt.cw()) {
                    return xt;
                }
            }
        }
        return new xt.j(false, 0, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public String j() {
        j jVar = this.f28170i;
        if (jVar == null) {
            return null;
        }
        String j6 = jVar.j();
        try {
            JSONObject jSONObject = new JSONObject(j6);
            jSONObject.put("is_need_click", this.up);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return j6;
        }
    }

    public jy(Activity activity, n nVar) {
        super(activity, nVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.cw.xt
    public void xt(String str) {
        super.xt(str);
        j jVar = this.f28170i;
        if (jVar == null) {
            return;
        }
        jVar.xt(str);
    }
}
