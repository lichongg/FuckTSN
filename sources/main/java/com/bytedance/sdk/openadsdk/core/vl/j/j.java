package com.bytedance.sdk.openadsdk.core.vl.j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.interact.az;
import com.bytedance.sdk.component.adexpress.xt.qv;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.qv.cw.cw.m;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.rn.gq;
import com.bytedance.sdk.openadsdk.core.tj.n;
import com.bytedance.sdk.openadsdk.core.tj.x;
import com.bytedance.sdk.openadsdk.core.xt.cw;
import com.bytedance.sdk.openadsdk.core.xt.r;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends r implements com.bytedance.sdk.component.adexpress.dynamic.up.j, cw {
    private n cw;

    /* renamed from: j, reason: collision with root package name */
    private qv f31158j;
    private View oq;
    private az qv;

    /* renamed from: r, reason: collision with root package name */
    private WeakReference<ViewGroup> f31159r;
    private volatile boolean up;
    private int vl;
    private boolean xt;

    public j(n nVar, WeakReference<ViewGroup> weakReference) {
        super(null);
        this.up = false;
        this.vl = Integer.MIN_VALUE;
        this.cw = nVar;
        this.f31159r = weakReference;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
    public void j(qv qvVar) {
        this.f31158j = qvVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
    public void xt(View view) {
        this.ae.j(view);
    }

    private JSONObject r(View view) {
        return new JSONObject();
    }

    private void xt() {
        WeakReference<ViewGroup> weakReference = this.f31159r;
        if (weakReference == null || weakReference.get() == null || !gq.j(this.f31159r.get())) {
            return;
        }
        this.vl = 1;
        cw(this.oq);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
    public void j(boolean z5, az azVar) {
        this.up = true;
        this.xt = z5;
        this.qv = azVar;
        WeakReference<ViewGroup> weakReference = this.f31159r;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        gq.j(this.f31159r, this);
    }

    private void cw(View view) {
        try {
            j(view, ((Integer) view.getTag()).intValue());
        } catch (ArrayIndexOutOfBoundsException e6) {
            vl.j(e6);
            e6.getMessage();
        } catch (Exception e7) {
            vl.r("DynamicClickListener", e7.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.vl = jSONObject.optInt("convertActionType", Integer.MIN_VALUE);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.up.j
    public void j(View view) {
        this.ae.xt(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.r
    public void j(View view, com.bytedance.sdk.openadsdk.core.tj.qv qvVar) {
        this.oq = view;
        if (this.up) {
            this.up = false;
        } else {
            cw(view);
        }
    }

    private void j(View view, int i6) {
        CharSequence text;
        if (this.f31158j != null) {
            if (this.xt && this.cw != null) {
                m.f29897r = true;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            View m6 = this.ae.m();
            if (m6 != null) {
                int[] j6 = ed.j(m6);
                if (j6 != null) {
                    iArr = j6;
                }
                int[] cw = ed.cw(m6);
                if (cw != null) {
                    iArr2 = cw;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null && text.toString().contains("下载")) {
                    jSONObject.put("is_compliant_download", true);
                }
                jSONObject.putOpt("convertActionType", Integer.valueOf(this.vl));
            } catch (Throwable unused) {
            }
            this.f31158j.j(view, i6, new x.j().r(this.ae.ws()).cw(this.ae.az()).xt(this.ae.av()).j(this.ae.i()).xt(this.ae.vl()).j(this.ae.jy()).j(iArr[0]).xt(iArr[1]).cw(iArr2[0]).r(iArr2[1]).j(r(view)).cw(String.valueOf(i6)).xt(String.valueOf(view.getTag(2097610714))).j(String.valueOf(view.getTag(2097610715))).r(String.valueOf(view.getTag(2097610713))).j(this.ae.up()).j(jSONObject).j(this.ae.oq()).j());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.xt.cw
    public void j() {
        xt();
        this.up = false;
        az azVar = this.qv;
        if (azVar != null) {
            azVar.up();
        }
    }
}
