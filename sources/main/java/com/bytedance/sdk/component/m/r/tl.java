package com.bytedance.sdk.component.m.r;

import com.bytedance.sdk.component.m.av;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl extends j {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private Throwable f26603j;
    private int xt;

    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        cwVar.j(new com.bytedance.sdk.component.m.cw.j(this.xt, this.cw, this.f26603j));
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

    public tl(int i6, String str, Throwable th) {
        this.xt = i6;
        this.cw = str;
        this.f26603j = th;
    }

    private void xt(com.bytedance.sdk.component.m.cw.cw cwVar) {
        av qv = cwVar.qv();
        if (qv != null) {
            qv.j(this.xt, this.cw, this.f26603j);
        }
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "failed";
    }
}
