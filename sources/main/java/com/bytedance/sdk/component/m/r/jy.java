package com.bytedance.sdk.component.m.r;

import com.bytedance.sdk.component.m.av;
import com.bytedance.sdk.component.m.mi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class jy<T> extends j {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private T f26598j;

    /* renamed from: r, reason: collision with root package name */
    private byte[] f26599r;
    private com.bytedance.sdk.component.m.m xt;

    private Map<String, String> xt() {
        com.bytedance.sdk.component.m.m mVar = this.xt;
        if (mVar != null) {
            return mVar.up();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        String x5 = cwVar.x();
        Map<String, List<com.bytedance.sdk.component.m.cw.cw>> ae = cwVar.kt().ae();
        List<com.bytedance.sdk.component.m.cw.cw> list = ae.get(x5);
        if (list == null) {
            xt(cwVar);
            return;
        }
        synchronized (list) {
            try {
                Iterator<com.bytedance.sdk.component.m.cw.cw> it = list.iterator();
                while (it.hasNext()) {
                    xt(it.next());
                }
                list.clear();
                ae.remove(x5);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public jy(T t5, byte[] bArr, com.bytedance.sdk.component.m.m mVar, boolean z5) {
        this.f26598j = t5;
        this.xt = mVar;
        this.cw = z5;
        this.f26599r = bArr;
    }

    private void xt(com.bytedance.sdk.component.m.cw.cw cwVar) {
        av qv = cwVar.qv();
        int jy = cwVar.jy();
        if (qv != null) {
            T t5 = this.f26598j;
            if (jy == 3) {
                com.bytedance.sdk.component.m.xt tj = cwVar.tj();
                if (this.f26599r == null && tj.ae()) {
                    this.f26599r = cwVar.kt().xt(tj).j((mi) cwVar.m());
                }
                T t6 = (T) this.f26599r;
                if (t6 == null) {
                    t6 = this.f26598j;
                }
                t5 = (T) t6;
                if (!(t5 instanceof byte[])) {
                    qv.j(2000, "final data is not raw", new RuntimeException("final data is not raw"));
                }
            } else if (jy == 2 && (t5 instanceof byte[])) {
                try {
                    t5 = (T) cwVar.kt().j(cwVar).j((byte[]) t5);
                } catch (Throwable th) {
                    qv.j(2000, "decode failed", th);
                    return;
                }
            }
            qv.j(new com.bytedance.sdk.component.m.cw.r().j(cwVar, t5, xt(), this.cw));
        }
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "success";
    }
}
