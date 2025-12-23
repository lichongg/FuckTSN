package com.bytedance.sdk.openadsdk.core.xt.j;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.tj.qv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    private final com.bytedance.sdk.openadsdk.core.xt.r ae;
    private qv cw;

    /* renamed from: r, reason: collision with root package name */
    private View f31320r;
    private volatile int up;

    /* renamed from: j, reason: collision with root package name */
    private List<j> f31318j = new ArrayList();
    private Map<String, Object> xt = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private volatile int f31319m = 0;

    private void xt() {
        this.up = 0;
        this.f31319m = 0;
    }

    public void j(View view) {
        this.f31320r = view;
    }

    public void j(j jVar) {
        this.f31318j.add(jVar);
    }

    public cw(com.bytedance.sdk.openadsdk.core.xt.r rVar) {
        this.ae = rVar;
    }

    public void j(qv qvVar) {
        this.cw = qvVar;
        Iterator<j> it = this.f31318j.iterator();
        while (it.hasNext()) {
            it.next().j(this.cw);
        }
    }

    public void j() {
        ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.ae.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(false);
        xt();
        j(0);
    }

    private void j(int i6) {
        int size = this.f31318j.size();
        while (i6 < size) {
            int i7 = i6 + 1;
            this.up = i7;
            j jVar = this.f31318j.get(i6);
            jVar.j(this.f31320r);
            this.f31319m = jVar.j(this.xt, this);
            if (this.f31319m != 0) {
                if (this.f31319m == 2) {
                    ((com.bytedance.sdk.openadsdk.core.xt.j.cw.j) this.ae.j(com.bytedance.sdk.openadsdk.core.xt.j.cw.j.class)).j(this.xt, this);
                    return;
                }
                return;
            }
            i6 = i7;
        }
    }

    public <T extends j> T j(Class<T> cls) {
        return (T) this.ae.j(cls);
    }
}
