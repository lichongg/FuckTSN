package org.junit.internal.runners.statements;

import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class f extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h f51448a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f51449b;

    /* renamed from: c, reason: collision with root package name */
    private final List<org.junit.runners.model.d> f51450c;

    @Override // org.junit.runners.model.h
    public void a() throws Throwable {
        Iterator<org.junit.runners.model.d> it = this.f51450c.iterator();
        while (it.hasNext()) {
            it.next().l(this.f51449b, new Object[0]);
        }
        this.f51448a.a();
    }

    public f(h hVar, List<org.junit.runners.model.d> list, Object obj) {
        this.f51448a = hVar;
        this.f51450c = list;
        this.f51449b = obj;
    }
}
