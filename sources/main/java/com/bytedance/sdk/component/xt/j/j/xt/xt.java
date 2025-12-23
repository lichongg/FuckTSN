package com.bytedance.sdk.component.xt.j.j.xt;

import com.bytedance.sdk.component.xt.j.av;
import com.bytedance.sdk.component.xt.j.g;
import com.bytedance.sdk.component.xt.j.ws;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements g.j {
    int cw = 0;

    /* renamed from: j, reason: collision with root package name */
    List<g> f27293j;
    ws xt;

    @Override // com.bytedance.sdk.component.xt.j.g.j
    public ws j() {
        return this.xt;
    }

    @Override // com.bytedance.sdk.component.xt.j.g.j
    public av j(ws wsVar) throws IOException {
        this.xt = wsVar;
        int i6 = this.cw + 1;
        this.cw = i6;
        return this.f27293j.get(i6).j(this);
    }

    xt(List<g> list, ws wsVar) {
        this.f27293j = list;
        this.xt = wsVar;
    }
}
