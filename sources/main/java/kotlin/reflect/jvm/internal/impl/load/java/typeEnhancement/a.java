package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d;

/* loaded from: D:\Downloads\app\classes8.dex */
class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final d f45739a;

    /* renamed from: b, reason: collision with root package name */
    private final d.a f45740b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        boolean i6;
        i6 = d.i(this.f45739a, this.f45740b, obj);
        return Boolean.valueOf(i6);
    }

    public a(d dVar, d.a aVar) {
        this.f45739a = dVar;
        this.f45740b = aVar;
    }
}
