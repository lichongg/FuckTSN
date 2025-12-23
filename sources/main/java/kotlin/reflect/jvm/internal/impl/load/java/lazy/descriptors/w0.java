package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class w0 implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f45655a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection o02;
        o02 = z0.o0(this.f45655a, (kotlin.reflect.jvm.internal.impl.resolve.scopes.k) obj);
        return o02;
    }

    public w0(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        this.f45655a = fVar;
    }
}
