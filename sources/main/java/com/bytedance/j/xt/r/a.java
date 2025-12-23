package com.bytedance.j.xt.r;

import android.content.Context;
import com.bytedance.j.xt.a;
import com.bytedance.j.xt.cw;
import com.bytedance.j.xt.tl.k;
import com.bytedance.j.xt.up.j.f;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private Context f24221a;

    @Override // com.bytedance.j.xt.r.c
    public boolean j(Throwable th) {
        return true;
    }

    @Override // com.bytedance.j.xt.r.c
    public void a(long j6, Thread thread, Throwable th) {
        com.bytedance.j.xt.cw.b d6 = com.bytedance.j.xt.cw.b.d(j6, this.f24221a, thread, th);
        Context context = this.f24221a;
        cw cwVar = cw.JAVA;
        k.e(context, cwVar.j(), Thread.currentThread().getName());
        a.d.b().c(f.c().a(cwVar, d6).k());
    }

    public a(Context context) {
        this.f24221a = context;
    }
}
