package kotlinx.coroutines.internal;

import kotlin.coroutines.i;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.e3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final s0 f49325a = new s0("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Function2<Object, i.b, Object> f49326b = a.f49329a;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Function2<e3<?>, i.b, e3<?>> f49327c = b.f49330a;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Function2<e1, i.b, e1> f49328d = c.f49331a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function2<Object, i.b, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49329a = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@Nullable Object obj, @NotNull i.b bVar) {
            if (!(bVar instanceof e3)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num != null ? num.intValue() : 1;
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class b extends Lambda implements Function2<e3<?>, i.b, e3<?>> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f49330a = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e3<?> invoke(@Nullable e3<?> e3Var, @NotNull i.b bVar) {
            if (e3Var != null) {
                return e3Var;
            }
            if (bVar instanceof e3) {
                return (e3) bVar;
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class c extends Lambda implements Function2<e1, i.b, e1> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f49331a = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final e1 invoke(@NotNull e1 e1Var, @NotNull i.b bVar) {
            if (bVar instanceof e3) {
                e3<?> e3Var = (e3) bVar;
                e1Var.a(e3Var, e3Var.U(e1Var.f49252a));
            }
            return e1Var;
        }
    }

    @NotNull
    public static final Object b(@NotNull kotlin.coroutines.i iVar) {
        Object fold = iVar.fold(0, f49326b);
        kotlin.jvm.internal.g0.m(fold);
        return fold;
    }

    public static final void a(@NotNull kotlin.coroutines.i iVar, @Nullable Object obj) {
        if (obj == f49325a) {
            return;
        }
        if (obj instanceof e1) {
            ((e1) obj).b(iVar);
            return;
        }
        Object fold = iVar.fold(null, f49327c);
        kotlin.jvm.internal.g0.n(fold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((e3) fold).n(iVar, obj);
    }

    @Nullable
    public static final Object c(@NotNull kotlin.coroutines.i iVar, @Nullable Object obj) {
        if (obj == null) {
            obj = b(iVar);
        }
        if (obj == 0) {
            return f49325a;
        }
        if (obj instanceof Integer) {
            return iVar.fold(new e1(iVar, ((Number) obj).intValue()), f49328d);
        }
        kotlin.jvm.internal.g0.n(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((e3) obj).U(iVar);
    }
}
