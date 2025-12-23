package com.bytedance.sdk.openadsdk.core.a.j;

import android.os.Message;
import com.bytedance.sdk.component.utils.f;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.oq;
import com.bytedance.sdk.openadsdk.core.v;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends j implements l.j {

    /* renamed from: j, reason: collision with root package name */
    private final l f27813j = new l(tl.j().getLooper(), this);
    private f xt;

    public void j(JSONObject jSONObject, int i6) {
        int j6 = j(i6);
        if (xt(i6)) {
            j(jSONObject, com.bytedance.sdk.openadsdk.core.a.j.j().xt(), j6);
        } else if (cw(i6)) {
            j(jSONObject, com.bytedance.sdk.openadsdk.core.a.j.j().cw(), j6);
        }
    }

    private void j(JSONObject jSONObject, long j6, long j7) {
        if (System.currentTimeMillis() - j6 > j7) {
            this.xt = j();
            this.f27813j.removeCallbacksAndMessages(null);
            this.f27813j.sendEmptyMessage(1);
        }
    }

    private f j() {
        f fVar = new f(v.getContext(), 1, oq.i().up());
        boolean j6 = fVar.j(0);
        vl.xt("csj_sen", "reg res:".concat(String.valueOf(j6)));
        if (j6) {
            return fVar;
        }
        j(0, System.currentTimeMillis(), 0L);
        fVar.xt(0);
        return null;
    }

    @Override // com.bytedance.sdk.component.utils.l.j
    public void j(Message message) {
        int i6 = message.what;
        if (i6 != 1) {
            if (i6 != 2) {
                return;
            }
            f fVar = this.xt;
            if (fVar != null) {
                fVar.xt(0);
            }
            j(3, 0L, System.currentTimeMillis());
            return;
        }
        f fVar2 = this.xt;
        if (fVar2 == null) {
            return;
        }
        fVar2.j(new f.cw() { // from class: com.bytedance.sdk.openadsdk.core.a.j.xt.1
            @Override // com.bytedance.sdk.component.utils.f.cw
            public void j() {
                xt.this.j(1, System.currentTimeMillis(), 0L);
                if (xt.this.f27813j != null) {
                    xt.this.f27813j.removeCallbacksAndMessages(null);
                }
                if (xt.this.xt != null) {
                    xt.this.xt.xt(0);
                }
            }
        });
        this.f27813j.sendEmptyMessageDelayed(2, j(v.xt().wf()));
    }
}
