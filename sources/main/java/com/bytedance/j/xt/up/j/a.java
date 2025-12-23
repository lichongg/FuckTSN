package com.bytedance.j.xt.up.j;

import android.content.Context;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.tl.j;

/* loaded from: D:\Downloads\app\classes3.dex */
class a extends b {
    a(Context context, h hVar, e eVar) {
        super(cw.JAVA, context, hVar, eVar);
    }

    @Override // com.bytedance.j.xt.up.j.b
    public com.bytedance.j.xt.cw.b b(com.bytedance.j.xt.cw.b bVar) {
        com.bytedance.j.xt.cw.b b6 = super.b(bVar);
        b6.l("app_count", 1);
        b6.l("magic_tag", "ss_app_log");
        a(b6);
        com.bytedance.j.xt.cw.c d6 = com.bytedance.j.xt.cw.c.d(this.f24278b);
        d6.g(com.bytedance.j.xt.e.d().b());
        d6.f(com.bytedance.j.xt.e.b().a());
        d6.m(this.f24279c.cw());
        b6.e(d6);
        j.b(b6, d6, this.f24277a);
        return b6;
    }
}
