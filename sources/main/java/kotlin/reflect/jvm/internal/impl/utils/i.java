package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function1<Object, Object> f47480a = d.f47475a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function1<Object, Boolean> f47481b = e.f47476a;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Function1<Object, Object> f47482c = a.f47486a;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Function1<Object, n1> f47483d = f.f47477a;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Function2<Object, Object, n1> f47484e = g.f47478a;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Function3<Object, Object, Object, n1> f47485f = h.f47479a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Object obj) {
        return true;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f47486a = new a();

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 b(Object obj) {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 c(Object obj, Object obj2) {
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 d(Object obj, Object obj2, Object obj3) {
        return n1.f44123a;
    }

    @NotNull
    public static final <T> Function1<T, Boolean> k() {
        return (Function1<T, Boolean>) f47481b;
    }

    @NotNull
    public static final Function3<Object, Object, Object, n1> l() {
        return f47485f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object e(Object obj) {
        return obj;
    }
}
