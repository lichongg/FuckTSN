package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class w implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final z f45654a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        Collection B0;
        B0 = z.B0(this.f45654a, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return B0;
    }

    public w(z zVar) {
        this.f45654a = zVar;
    }
}
