package kotlin.reflect.jvm.internal.impl.storage;

import com.tencent.open.SocialConstants;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.n1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class f implements kotlin.reflect.jvm.internal.impl.storage.n {

    /* renamed from: d, reason: collision with root package name */
    private static final String f47091d = u.U5(f.class.getCanonicalName(), ".", "");

    /* renamed from: e, reason: collision with root package name */
    public static final kotlin.reflect.jvm.internal.impl.storage.n f47092e = new a("NO_LOCKS", InterfaceC0918f.f47103a, kotlin.reflect.jvm.internal.impl.storage.e.f47090b);

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ boolean f47093f = false;

    /* renamed from: a, reason: collision with root package name */
    protected final kotlin.reflect.jvm.internal.impl.storage.k f47094a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0918f f47095b;

    /* renamed from: c, reason: collision with root package name */
    private final String f47096c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a extends f {
        a(String str, InterfaceC0918f interfaceC0918f, kotlin.reflect.jvm.internal.impl.storage.k kVar) {
            super(str, interfaceC0918f, kVar, null);
        }

        private static /* synthetic */ void j(int i6) {
            String str = i6 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 1 ? 3 : 2];
            if (i6 != 1) {
                objArr[0] = SocialConstants.PARAM_SOURCE;
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i6 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i6 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i6 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f
        @NotNull
        protected <K, V> o<V> p(@NotNull String str, K k6) {
            if (str == null) {
                j(0);
            }
            o<V> a6 = o.a();
            if (a6 == null) {
                j(1);
            }
            return a6;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b<T> extends j<T> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f47097e;

        private static /* synthetic */ void a(int i6) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, Function0 function0, Object obj) {
            super(fVar, function0);
            this.f47097e = obj;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        @NotNull
        protected o<T> c(boolean z5) {
            o<T> d6 = o.d(this.f47097e);
            if (d6 == null) {
                a(0);
            }
            return d6;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c<T> extends k<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f47099f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1 f47100g;

        private static /* synthetic */ void a(int i6) {
            String str = i6 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i6 != 2 ? 2 : 3];
            if (i6 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i6 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i6 == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i6 == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, Function0 function0, Function1 function1, Function1 function12) {
            super(fVar, function0);
            this.f47099f = function1;
            this.f47100g = function12;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        @NotNull
        protected o<T> c(boolean z5) {
            Function1 function1 = this.f47099f;
            if (function1 == null) {
                o<T> c6 = super.c(z5);
                if (c6 == null) {
                    a(0);
                }
                return c6;
            }
            o<T> d6 = o.d(function1.invoke(Boolean.valueOf(z5)));
            if (d6 == null) {
                a(1);
            }
            return d6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.i
        protected void d(@NotNull T t5) {
            if (t5 == null) {
                a(2);
            }
            this.f47100g.invoke(t5);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class d<K, V> extends e<K, V> implements kotlin.reflect.jvm.internal.impl.storage.a<K, V> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f47102d = false;

        /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i6) {
            String str = i6 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 3 ? 3 : 2];
            if (i6 == 1) {
                objArr[0] = "map";
            } else if (i6 == 2) {
                objArr[0] = "computation";
            } else if (i6 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i6 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i6 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i6 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(@NotNull f fVar, @NotNull ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.e, kotlin.reflect.jvm.internal.impl.storage.a
        @NotNull
        public V a(K k6, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                b(2);
            }
            V v5 = (V) super.a(k6, function0);
            if (v5 == null) {
                b(3);
            }
            return v5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class e<K, V> extends l<g<K, V>, V> implements kotlin.reflect.jvm.internal.impl.storage.b<K, V> {
        /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void b(int i6) {
            Object[] objArr = new Object[3];
            if (i6 == 1) {
                objArr[0] = "map";
            } else if (i6 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i6 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Function1<g<K, V>, V> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public V invoke(g<K, V> gVar) {
                return (V) ((g) gVar).f47105b.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(@NotNull f fVar, @NotNull ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
        }

        @Nullable
        public V a(K k6, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                b(2);
            }
            return invoke(new g(k6, function0));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: kotlin.reflect.jvm.internal.impl.storage.f$f, reason: collision with other inner class name */
    public interface InterfaceC0918f {

        /* renamed from: a, reason: collision with root package name */
        public static final InterfaceC0918f f47103a = new a();

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.storage.f$f$a */
        static class a implements InterfaceC0918f {
            private static /* synthetic */ void a(int i6) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.f.InterfaceC0918f
            @NotNull
            public RuntimeException handleException(@NotNull Throwable th) {
                if (th == null) {
                    a(0);
                }
                throw kotlin.reflect.jvm.internal.impl.utils.c.b(th);
            }

            a() {
            }
        }

        @NotNull
        RuntimeException handleException(@NotNull Throwable th);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class g<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final K f47104a;

        /* renamed from: b, reason: collision with root package name */
        private final Function0<? extends V> f47105b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.f47104a.equals(((g) obj).f47104a);
        }

        public int hashCode() {
            return this.f47104a.hashCode();
        }

        public g(K k6, Function0<? extends V> function0) {
            this.f47104a = k6;
            this.f47105b = function0;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class h<T> implements kotlin.reflect.jvm.internal.impl.storage.j<T> {

        /* renamed from: a, reason: collision with root package name */
        private final f f47106a;

        /* renamed from: b, reason: collision with root package name */
        private final Function0<? extends T> f47107b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private volatile Object f47108c;

        private static /* synthetic */ void a(int i6) {
            String str = (i6 == 2 || i6 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i6 == 2 || i6 == 3) ? 2 : 3];
            if (i6 == 1) {
                objArr[0] = "computable";
            } else if (i6 == 2 || i6 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i6 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i6 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i6 != 2 && i6 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 != 2 && i6 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public h(@NotNull f fVar, @NotNull Function0<? extends T> function0) {
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.f47108c = n.NOT_COMPUTED;
            this.f47106a = fVar;
            this.f47107b = function0;
        }

        @NotNull
        protected o<T> c(boolean z5) {
            o<T> p5 = this.f47106a.p("in a lazy value", null);
            if (p5 == null) {
                a(2);
            }
            return p5;
        }

        public boolean e() {
            return (this.f47108c == n.NOT_COMPUTED || this.f47108c == n.COMPUTING) ? false : true;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.f47108c;
            if (!(obj instanceof n)) {
                return (T) WrappedValues.f(obj);
            }
            this.f47106a.f47094a.lock();
            try {
                Object obj2 = this.f47108c;
                if (obj2 instanceof n) {
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        this.f47108c = n.RECURSION_WAS_DETECTED;
                        o<T> c6 = c(true);
                        if (!c6.c()) {
                            invoke = c6.b();
                        }
                    }
                    if (obj2 == n.RECURSION_WAS_DETECTED) {
                        o<T> c7 = c(false);
                        if (!c7.c()) {
                            invoke = c7.b();
                        }
                    }
                    this.f47108c = nVar;
                    try {
                        invoke = this.f47107b.invoke();
                        b(invoke);
                        this.f47108c = invoke;
                    } catch (Throwable th) {
                        if (kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                            this.f47108c = n.NOT_COMPUTED;
                            throw th;
                        }
                        if (this.f47108c == n.COMPUTING) {
                            this.f47108c = WrappedValues.c(th);
                        }
                        throw this.f47106a.f47095b.handleException(th);
                    }
                } else {
                    invoke = (T) WrappedValues.f(obj2);
                }
                return invoke;
            } finally {
                this.f47106a.f47094a.unlock();
            }
        }

        protected void b(T t5) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class i<T> extends h<T> {

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private volatile kotlin.reflect.jvm.internal.impl.storage.l<T> f47109d;

        private static /* synthetic */ void a(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        protected abstract void d(T t5);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull f fVar, @NotNull Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.f47109d = null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h
        protected final void b(T t5) {
            this.f47109d = new kotlin.reflect.jvm.internal.impl.storage.l<>(t5);
            try {
                d(t5);
            } finally {
                this.f47109d = null;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            kotlin.reflect.jvm.internal.impl.storage.l<T> lVar = this.f47109d;
            return (lVar == null || !lVar.b()) ? (T) super.invoke() : lVar.a();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class j<T> extends h<T> implements kotlin.reflect.jvm.internal.impl.storage.i<T> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f47110d = false;

        private static /* synthetic */ void a(int i6) {
            String str = i6 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 2 ? 3 : 2];
            if (i6 == 1) {
                objArr[0] = "computable";
            } else if (i6 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i6 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i6 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@NotNull f fVar, @NotNull Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.h, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t5 = (T) super.invoke();
            if (t5 == null) {
                a(2);
            }
            return t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static abstract class k<T> extends i<T> implements kotlin.reflect.jvm.internal.impl.storage.i<T> {

        /* renamed from: e, reason: collision with root package name */
        static final /* synthetic */ boolean f47111e = false;

        private static /* synthetic */ void a(int i6) {
            String str = i6 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 2 ? 3 : 2];
            if (i6 == 1) {
                objArr[0] = "computable";
            } else if (i6 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i6 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i6 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 2) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(@NotNull f fVar, @NotNull Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.i, kotlin.reflect.jvm.internal.impl.storage.f.h, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t5 = (T) super.invoke();
            if (t5 == null) {
                a(2);
            }
            return t5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class l<K, V> implements kotlin.reflect.jvm.internal.impl.storage.h<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final f f47112a;

        /* renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<K, Object> f47113b;

        /* renamed from: c, reason: collision with root package name */
        private final Function1<? super K, ? extends V> f47114c;

        private static /* synthetic */ void b(int i6) {
            String str = (i6 == 3 || i6 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i6 == 3 || i6 == 4) ? 2 : 3];
            if (i6 == 1) {
                objArr[0] = "map";
            } else if (i6 == 2) {
                objArr[0] = "compute";
            } else if (i6 == 3 || i6 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i6 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i6 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i6 != 3 && i6 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 != 3 && i6 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public l(@NotNull f fVar, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (function1 == null) {
                b(2);
            }
            this.f47112a = fVar;
            this.f47113b = concurrentMap;
            this.f47114c = function1;
        }

        private AssertionError d(K k6, Object obj) {
            return (AssertionError) f.q(new AssertionError("Inconsistent key detected. " + n.COMPUTING + " is expected, was: " + obj + ", most probably race condition detected on input " + k6 + " under " + this.f47112a));
        }

        @NotNull
        private AssertionError f(K k6, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k6 + ". Old value is " + obj + " under " + this.f47112a));
            if (assertionError == null) {
                b(4);
            }
            return assertionError;
        }

        private AssertionError i(K k6, Throwable th) {
            return (AssertionError) f.q(new AssertionError("Unable to remove " + k6 + " under " + this.f47112a, th));
        }

        protected f c() {
            return this.f47112a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.h
        public boolean g(K k6) {
            Object obj = this.f47113b.get(k6);
            return (obj == null || obj == n.COMPUTING) ? false : true;
        }

        @NotNull
        protected o<V> h(K k6, boolean z5) {
            o<V> p5 = this.f47112a.p("", k6);
            if (p5 == null) {
                b(3);
            }
            return p5;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public V invoke(K k6) {
            AssertionError i6;
            AssertionError i7;
            V v5;
            Object obj = this.f47113b.get(k6);
            if (obj != null && obj != n.COMPUTING) {
                return (V) WrappedValues.d(obj);
            }
            this.f47112a.f47094a.lock();
            try {
                Object obj2 = this.f47113b.get(k6);
                n nVar = n.COMPUTING;
                if (obj2 == nVar) {
                    obj2 = n.RECURSION_WAS_DETECTED;
                    o<V> h6 = h(k6, true);
                    if (!h6.c()) {
                        v5 = h6.b();
                        return v5;
                    }
                }
                if (obj2 == n.RECURSION_WAS_DETECTED) {
                    o<V> h7 = h(k6, false);
                    if (!h7.c()) {
                        v5 = h7.b();
                        return v5;
                    }
                }
                if (obj2 != null) {
                    v5 = (V) WrappedValues.d(obj2);
                    return v5;
                }
                AssertionError assertionError = null;
                try {
                    this.f47113b.put(k6, nVar);
                    V invoke = this.f47114c.invoke(k6);
                    Object put = this.f47113b.put(k6, WrappedValues.b(invoke));
                    if (put == nVar) {
                        return invoke;
                    }
                    assertionError = f(k6, put);
                    throw assertionError;
                } catch (Throwable th) {
                    if (kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                        try {
                            Object remove = this.f47113b.remove(k6);
                            if (remove != n.COMPUTING) {
                                throw d(k6, remove);
                            }
                            throw th;
                        } finally {
                        }
                    }
                    if (th == assertionError) {
                        try {
                            this.f47113b.remove(k6);
                            throw this.f47112a.f47095b.handleException(th);
                        } finally {
                        }
                    }
                    Object put2 = this.f47113b.put(k6, WrappedValues.c(th));
                    if (put2 != n.COMPUTING) {
                        throw f(k6, put2);
                    }
                    throw this.f47112a.f47095b.handleException(th);
                }
            } finally {
                this.f47112a.f47094a.unlock();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class m<K, V> extends l<K, V> implements kotlin.reflect.jvm.internal.impl.storage.g<K, V> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ boolean f47115d = false;

        private static /* synthetic */ void b(int i6) {
            String str = i6 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i6 != 3 ? 3 : 2];
            if (i6 == 1) {
                objArr[0] = "map";
            } else if (i6 == 2) {
                objArr[0] = "compute";
            } else if (i6 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i6 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i6 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 == 3) {
                throw new IllegalStateException(format);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(@NotNull f fVar, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(fVar, concurrentMap, function1);
            if (fVar == null) {
                b(0);
            }
            if (concurrentMap == null) {
                b(1);
            }
            if (function1 == null) {
                b(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.f.l, kotlin.jvm.functions.Function1
        @NotNull
        public V invoke(K k6) {
            V v5 = (V) super.invoke(k6);
            if (v5 == null) {
                b(3);
            }
            return v5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class o<T> {

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ boolean f47120c = false;

        /* renamed from: a, reason: collision with root package name */
        private final T f47121a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f47122b;

        @NotNull
        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        @NotNull
        public static <T> o<T> d(T t5) {
            return new o<>(t5, false);
        }

        public T b() {
            return this.f47121a;
        }

        public boolean c() {
            return this.f47122b;
        }

        private o(T t5, boolean z5) {
            this.f47121a = t5;
            this.f47122b = z5;
        }

        public String toString() {
            if (c()) {
                return "FALL_THROUGH";
            }
            return String.valueOf(this.f47121a);
        }
    }

    /* synthetic */ f(String str, InterfaceC0918f interfaceC0918f, kotlin.reflect.jvm.internal.impl.storage.k kVar, a aVar) {
        this(str, interfaceC0918f, kVar);
    }

    private f(@NotNull String str, @NotNull InterfaceC0918f interfaceC0918f, @NotNull kotlin.reflect.jvm.internal.impl.storage.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0918f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f47094a = kVar;
        this.f47095b = interfaceC0918f;
        this.f47096c = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void j(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.f.j(int):void");
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T q(@NotNull T t5) {
        if (t5 == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t5.getStackTrace();
        int length = stackTrace.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                i6 = -1;
                break;
            }
            if (!stackTrace[i6].getClassName().startsWith(f47091d)) {
                break;
            }
            i6++;
        }
        List subList = Arrays.asList(stackTrace).subList(i6, length);
        t5.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> a(@NotNull Function0<? extends T> function0, @NotNull T t5) {
        if (function0 == null) {
            j(26);
        }
        if (t5 == null) {
            j(27);
        }
        return new b(this, function0, t5);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> b(@NotNull Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, n1> function12) {
        if (function0 == null) {
            j(28);
        }
        if (function12 == null) {
            j(29);
        }
        return new c(this, function0, function1, function12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.h<K, V> c(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            j(19);
        }
        kotlin.reflect.jvm.internal.impl.storage.h<K, V> o5 = o(function1, m());
        if (o5 == null) {
            j(20);
        }
        return o5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.a<K, V> d() {
        return new d(this, m(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.i<T> e(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            j(23);
        }
        return new j(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    public <T> T f(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            j(34);
        }
        this.f47094a.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <T> kotlin.reflect.jvm.internal.impl.storage.j<T> g(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            j(30);
        }
        return new h(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.b<K, V> h() {
        return new e(this, m(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.n
    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.g<K, V> i(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            j(9);
        }
        kotlin.reflect.jvm.internal.impl.storage.g<K, V> n6 = n(function1, m());
        if (n6 == null) {
            j(10);
        }
        return n6;
    }

    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.g<K, V> n(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, function1);
    }

    @NotNull
    public <K, V> kotlin.reflect.jvm.internal.impl.storage.h<K, V> o(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, function1);
    }

    @NotNull
    protected <K, V> o<V> p(@NotNull String str, K k6) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k6 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k6;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f47096c + ")";
    }

    public f(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, n1>) null);
    }

    public f(String str, @Nullable Runnable runnable, @Nullable Function1<InterruptedException, n1> function1) {
        this(str, InterfaceC0918f.f47103a, kotlin.reflect.jvm.internal.impl.storage.k.f47123a.a(runnable, function1));
    }
}
