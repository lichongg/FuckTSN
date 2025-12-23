package com.bytedance.j.xt.up.j;

import android.content.Context;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.tl.j;
import com.bytedance.pangle.provider.ContentProviderManager;

/* loaded from: D:\Downloads\app\classes3.dex */
class c extends b {
    c(Context context, h hVar, e eVar) {
        super(cw.ANR, context, hVar, eVar);
    }

    @Override // com.bytedance.j.xt.up.j.b
    public com.bytedance.j.xt.cw.b b(com.bytedance.j.xt.cw.b bVar) {
        com.bytedance.j.xt.cw.b b6 = super.b(bVar);
        com.bytedance.j.xt.cw.c d6 = com.bytedance.j.xt.cw.c.d(this.f24278b);
        d6.g(com.bytedance.j.xt.e.d().b());
        d6.f(com.bytedance.j.xt.e.b().a());
        d6.m(this.f24279c.cw());
        b6.e(d6);
        b6.l(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.j.xt.tl.f.j(this.f24278b));
        j.b(b6, d6, this.f24277a);
        return b6;
    }
}
