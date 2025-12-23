package com.bytedance.sdk.component.cw.xt.j.xt;

import com.bytedance.sdk.component.cw.xt.la;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    private final Set<la> f26318j = new LinkedHashSet();

    public synchronized boolean cw(la laVar) {
        return this.f26318j.contains(laVar);
    }

    public synchronized void j(la laVar) {
        this.f26318j.add(laVar);
    }

    public synchronized void xt(la laVar) {
        this.f26318j.remove(laVar);
    }
}
