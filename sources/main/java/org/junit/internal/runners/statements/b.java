package org.junit.internal.runners.statements;

import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b extends h {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f51432a;

    @Override // org.junit.runners.model.h
    public void a() throws Throwable {
        throw this.f51432a;
    }

    public b(Throwable th) {
        this.f51432a = th;
    }
}
