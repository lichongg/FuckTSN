package org.junit.rules;

import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class p implements l {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends org.junit.runners.model.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ org.junit.runners.model.h f51489a;

        a(org.junit.runners.model.h hVar) throws Throwable {
            this.f51489a = hVar;
        }

        @Override // org.junit.runners.model.h
        public void a() throws Throwable {
            this.f51489a.a();
            p.this.b();
        }
    }

    @Override // org.junit.rules.l
    public org.junit.runners.model.h a(org.junit.runners.model.h hVar, Description description) {
        return new a(hVar);
    }

    protected void b() throws Throwable {
    }
}
