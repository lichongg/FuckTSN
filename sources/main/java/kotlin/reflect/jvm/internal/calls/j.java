package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.reflect.jvm.internal.calls.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class j implements g<Method> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Method f44303a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<Type> f44304b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final Type f44305c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends j implements f {

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        private final Object f44306d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Method unboxMethod, @Nullable Object obj) {
            super(unboxMethod, f0.J(), null);
            g0.p(unboxMethod, "unboxMethod");
            this.f44306d = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            e(args);
            return d(this.f44306d, args);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nInternalUnderlyingValOfInlineClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 InternalUnderlyingValOfInlineClass.kt\nkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound\n+ 2 CallerImpl.kt\nkotlin/reflect/jvm/internal/calls/CallerImpl$Companion\n*L\n1#1,45:1\n270#2:46\n*S KotlinDebug\n*F\n+ 1 InternalUnderlyingValOfInlineClass.kt\nkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound\n*L\n31#1:46\n*E\n"})
    public static final class b extends j {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Method unboxMethod) {
            super(unboxMethod, f0.l(unboxMethod.getDeclaringClass()), null);
            g0.p(unboxMethod, "unboxMethod");
        }

        @Override // kotlin.reflect.jvm.internal.calls.g
        @Nullable
        public Object call(@NotNull Object[] args) {
            g0.p(args, "args");
            e(args);
            Object obj = args[0];
            h.d dVar = h.f44288e;
            return d(obj, args.length <= 1 ? new Object[0] : kotlin.collections.n.l1(args, 1, args.length));
        }
    }

    public /* synthetic */ j(Method method, List list, v vVar) {
        this(method, list);
    }

    public boolean g() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @Nullable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Method c() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private j(Method method, List<? extends Type> list) {
        this.f44303a = method;
        this.f44304b = list;
        Class<?> returnType = method.getReturnType();
        g0.o(returnType, "getReturnType(...)");
        this.f44305c = returnType;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public final List<Type> b() {
        return this.f44304b;
    }

    @Nullable
    protected final Object d(@Nullable Object obj, @NotNull Object[] args) {
        g0.p(args, "args");
        return this.f44303a.invoke(obj, Arrays.copyOf(args, args.length));
    }

    public void f(Object[] args) {
        g0.p(args, "args");
        if (i.a(this) == args.length) {
            return;
        }
        throw new IllegalArgumentException("Callable expects " + i.a(this) + " arguments, but " + args.length + " were provided.");
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    @NotNull
    public final Type getReturnType() {
        return this.f44305c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.g
    public boolean a() {
        return g();
    }

    public void e(@NotNull Object[] objArr) {
        f(objArr);
    }
}
