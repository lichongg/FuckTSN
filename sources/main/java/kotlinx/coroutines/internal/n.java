package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,116:1\n1#2:117\n11335#3:118\n11670#3,3:119\n12904#3,3:136\n1963#4,14:122\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n45#1:118\n45#1:119,3\n82#1:136,3\n63#1:122,14\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final int f49284a = e(Throwable.class, -1);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final k f49285b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f49286a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Constructor<?> constructor) {
            super(1);
            this.f49286a = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable th) {
            Object newInstance = this.f49286a.newInstance(th.getMessage(), th);
            kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) newInstance;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt$createConstructor$1$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
    static final class b extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f49287a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Constructor<?> constructor) {
            super(1);
            this.f49287a = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable th) {
            Object newInstance = this.f49287a.newInstance(th.getMessage());
            kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable th2 = (Throwable) newInstance;
            th2.initCause(th);
            return th2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f49288a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Constructor<?> constructor) {
            super(1);
            this.f49288a = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable th) {
            Object newInstance = this.f49288a.newInstance(th);
            kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
            return (Throwable) newInstance;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt$createConstructor$1$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,116:1\n1#2:117\n*E\n"})
    static final class d extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor<?> f49289a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Constructor<?> constructor) {
            super(1);
            this.f49289a = constructor;
        }

        @Override // kotlin.jvm.functions.Function1
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable th) {
            Object newInstance = this.f49289a.newInstance(null);
            kotlin.jvm.internal.g0.n(newInstance, "null cannot be cast to non-null type kotlin.Throwable");
            Throwable th2 = (Throwable) newInstance;
            th2.initCause(th);
            return th2;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class e extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final e f49290a = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(@NotNull Throwable th) {
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class f extends Lambda implements Function1<Throwable, Throwable> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Throwable, Throwable> f49291a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(Function1<? super Throwable, ? extends Throwable> function1) {
            super(1);
            this.f49291a = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Throwable invoke(@NotNull Throwable th) {
            Object m130constructorimpl;
            Function1<Throwable, Throwable> function1 = this.f49291a;
            try {
                Result.a aVar = Result.Companion;
                Throwable invoke = function1.invoke(th);
                if (!kotlin.jvm.internal.g0.g(th.getMessage(), invoke.getMessage()) && !kotlin.jvm.internal.g0.g(invoke.getMessage(), th.toString())) {
                    invoke = null;
                }
                m130constructorimpl = Result.m130constructorimpl(invoke);
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th2));
            }
            return (Throwable) (Result.m136isFailureimpl(m130constructorimpl) ? null : m130constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> b(Class<E> cls) {
        Object obj;
        Function1<Throwable, Throwable> function1;
        Pair a6;
        e eVar = e.f49290a;
        if (f49284a == e(cls, 0)) {
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            int length = constructors.length;
            int i6 = 0;
            while (true) {
                obj = null;
                if (i6 >= length) {
                    break;
                }
                Constructor<?> constructor = constructors[i6];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length2 = parameterTypes.length;
                if (length2 == 0) {
                    a6 = kotlin.o0.a(f(new d(constructor)), 0);
                } else if (length2 != 1) {
                    a6 = length2 != 2 ? kotlin.o0.a(null, -1) : (kotlin.jvm.internal.g0.g(parameterTypes[0], String.class) && kotlin.jvm.internal.g0.g(parameterTypes[1], Throwable.class)) ? kotlin.o0.a(f(new a(constructor)), 3) : kotlin.o0.a(null, -1);
                } else {
                    Class<?> cls2 = parameterTypes[0];
                    a6 = kotlin.jvm.internal.g0.g(cls2, String.class) ? kotlin.o0.a(f(new b(constructor)), 2) : kotlin.jvm.internal.g0.g(cls2, Throwable.class) ? kotlin.o0.a(f(new c(constructor)), 1) : kotlin.o0.a(null, -1);
                }
                arrayList.add(a6);
                i6++;
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int intValue = ((Number) ((Pair) obj).getSecond()).intValue();
                    do {
                        Object next = it.next();
                        int intValue2 = ((Number) ((Pair) next).getSecond()).intValue();
                        if (intValue < intValue2) {
                            obj = next;
                            intValue = intValue2;
                        }
                    } while (it.hasNext());
                }
            }
            Pair pair = (Pair) obj;
            if (pair != null && (function1 = (Function1) pair.getFirst()) != null) {
                return function1;
            }
        }
        return eVar;
    }

    static {
        k kVar;
        try {
            kVar = p.a() ? f1.f49260a : kotlinx.coroutines.internal.d.f49244a;
        } catch (Throwable unused) {
            kVar = f1.f49260a;
        }
        f49285b = kVar;
    }

    static /* synthetic */ int d(Class cls, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i6 = 0;
        }
        return c(cls, i6);
    }

    private static final Function1<Throwable, Throwable> f(Function1<? super Throwable, ? extends Throwable> function1) {
        return new f(function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final <E extends Throwable> E g(@NotNull E e6) {
        Object m130constructorimpl;
        if (!(e6 instanceof kotlinx.coroutines.k0)) {
            return (E) f49285b.a(e6.getClass()).invoke(e6);
        }
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(((kotlinx.coroutines.k0) e6).createCopy());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        if (Result.m136isFailureimpl(m130constructorimpl)) {
            m130constructorimpl = null;
        }
        return (E) m130constructorimpl;
    }

    private static final int c(Class<?> cls, int i6) {
        do {
            int i7 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i7++;
                }
            }
            i6 += i7;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i6;
    }

    private static final int e(Class<?> cls, int i6) {
        Object m130constructorimpl;
        l3.a.i(cls);
        try {
            Result.a aVar = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(Integer.valueOf(d(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m130constructorimpl = Result.m130constructorimpl(kotlin.g0.a(th));
        }
        Integer valueOf = Integer.valueOf(i6);
        if (Result.m136isFailureimpl(m130constructorimpl)) {
            m130constructorimpl = valueOf;
        }
        return ((Number) m130constructorimpl).intValue();
    }
}
