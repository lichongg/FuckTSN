package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final b f45528a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean h6;
        h6 = b.h(this.f45528a, (y3.r) obj);
        return Boolean.valueOf(h6);
    }

    public a(b bVar) {
        this.f45528a = bVar;
    }
}
