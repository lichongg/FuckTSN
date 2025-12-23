package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.xt.kt;
import com.bytedance.sdk.component.cw.xt.l;
import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.cw.xt.s;
import com.bytedance.sdk.component.cw.xt.v;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class j implements kt {

    /* renamed from: j, reason: collision with root package name */
    public final v f26313j;

    @Override // com.bytedance.sdk.component.cw.xt.kt
    public p j(kt.j jVar) throws IOException {
        l lVar;
        com.bytedance.sdk.component.cw.xt.j.cw.ae aeVar = (com.bytedance.sdk.component.cw.xt.j.cw.ae) jVar;
        s j6 = aeVar.j();
        if (j6 != null && (lVar = j6.f26363m) != null) {
            lVar.xt();
        }
        ae m6 = aeVar.m();
        com.bytedance.sdk.component.cw.xt.j.cw.cw j7 = m6.j(this.f26313j, jVar, !j6.xt().equals("GET"));
        cw xt = m6.xt();
        l lVar2 = j6.f26363m;
        if (lVar2 != null) {
            lVar2.cw();
        }
        return aeVar.j(j6, m6, j7, xt);
    }

    public j(v vVar) {
        this.f26313j = vVar;
    }
}
