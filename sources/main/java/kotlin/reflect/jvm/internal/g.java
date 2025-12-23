package kotlin.reflect.jvm.internal;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\Downloads\app\classes8.dex */
class g implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g f44350a = new g();

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object obj) {
        ConcurrentHashMap b6;
        b6 = h.b((Class) obj);
        return b6;
    }
}
