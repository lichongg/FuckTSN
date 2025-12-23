package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b1;
import y3.y;

/* loaded from: D:\Downloads\app\classes8.dex */
class l implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final m f45689a;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        b1 c6;
        c6 = m.c(this.f45689a, (y) obj);
        return c6;
    }

    public l(m mVar) {
        this.f45689a = mVar;
    }
}
