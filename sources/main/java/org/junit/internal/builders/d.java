package org.junit.internal.builders;

import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d extends org.junit.runner.g {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f51382a;

    @Override // org.junit.runner.g, org.junit.runner.b
    public Description getDescription() {
        return Description.createSuiteDescription(this.f51382a);
    }

    public d(Class<?> cls) {
        this.f51382a = cls;
    }

    @Override // org.junit.runner.g
    public void a(org.junit.runner.notification.a aVar) {
        aVar.i(getDescription());
    }
}
