package com.bytedance.sdk.component.xt.j.j.j;

import com.bytedance.sdk.component.cw.xt.p;
import com.bytedance.sdk.component.xt.j.av;
import java.io.IOException;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r implements com.bytedance.sdk.component.xt.j.xt {

    /* renamed from: j, reason: collision with root package name */
    com.bytedance.sdk.component.cw.xt.up f27277j;

    @Override // com.bytedance.sdk.component.xt.j.xt
    public av j() throws IOException {
        return new g(this.f27277j.xt());
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public boolean cw() {
        return this.f27277j.r();
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public void j(final com.bytedance.sdk.component.xt.j.cw cwVar) {
        this.f27277j.j(new com.bytedance.sdk.component.cw.xt.m() { // from class: com.bytedance.sdk.component.xt.j.j.j.r.1
            @Override // com.bytedance.sdk.component.cw.xt.m
            public void j(com.bytedance.sdk.component.cw.xt.up upVar, IOException iOException) {
                cwVar.onFailure(new r(upVar), iOException);
            }

            @Override // com.bytedance.sdk.component.cw.xt.m
            public void j(com.bytedance.sdk.component.cw.xt.up upVar, p pVar) throws IOException {
                cwVar.onResponse(new r(upVar), new g(pVar));
            }
        });
    }

    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.xt.j.xt clone() {
        return new r(this.f27277j.up());
    }

    @Override // com.bytedance.sdk.component.xt.j.xt
    public void xt() {
        this.f27277j.cw();
    }

    public r(com.bytedance.sdk.component.cw.xt.up upVar) {
        this.f27277j = upVar;
    }
}
