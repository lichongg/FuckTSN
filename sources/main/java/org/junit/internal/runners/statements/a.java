package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a extends h {

    /* renamed from: a, reason: collision with root package name */
    private final h f51430a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<? extends Throwable> f51431b;

    @Override // org.junit.runners.model.h
    public void a() throws Exception {
        try {
            this.f51430a.a();
            throw new AssertionError("Expected exception: " + this.f51431b.getName());
        } catch (AssumptionViolatedException e6) {
            throw e6;
        } catch (Throwable th) {
            if (this.f51431b.isAssignableFrom(th.getClass())) {
                return;
            }
            throw new Exception("Unexpected exception, expected<" + this.f51431b.getName() + "> but was<" + th.getClass().getName() + ">", th);
        }
    }

    public a(h hVar, Class<? extends Throwable> cls) {
        this.f51430a = hVar;
        this.f51431b = cls;
    }
}
