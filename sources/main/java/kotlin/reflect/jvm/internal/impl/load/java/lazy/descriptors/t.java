package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class t implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    private final z f45627a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.lazy.k f45628b;

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        kotlin.reflect.jvm.internal.impl.descriptors.d j12;
        j12 = z.j1(this.f45627a, this.f45628b, (kotlin.reflect.jvm.internal.impl.name.f) obj);
        return j12;
    }

    public t(z zVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.k kVar) {
        this.f45627a = zVar;
        this.f45628b = kVar;
    }
}
