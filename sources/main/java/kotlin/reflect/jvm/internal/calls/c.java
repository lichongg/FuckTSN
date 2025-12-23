package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.s;

/* loaded from: D:\Downloads\app\classes8.dex */
class c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Class f44282a;

    /* renamed from: b, reason: collision with root package name */
    private final Map f44283b;

    /* renamed from: c, reason: collision with root package name */
    private final s f44284c;

    /* renamed from: d, reason: collision with root package name */
    private final s f44285d;

    /* renamed from: e, reason: collision with root package name */
    private final List f44286e;

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        Object o5;
        o5 = e.o(this.f44282a, this.f44283b, this.f44284c, this.f44285d, this.f44286e, obj, method, objArr);
        return o5;
    }

    public c(Class cls, Map map, s sVar, s sVar2, List list) {
        this.f44282a = cls;
        this.f44283b = map;
        this.f44284c = sVar;
        this.f44285d = sVar2;
        this.f44286e = list;
    }
}
