package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.e1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.util.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class v implements f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f47457a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.builtins.j, t0> f47458b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f47459c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends v {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final a f47460d = new a();

        private a() {
            super("Boolean", u.f47456a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t0 c(kotlin.reflect.jvm.internal.impl.builtins.j jVar) {
            g0.p(jVar, "<this>");
            e1 o5 = jVar.o();
            g0.o(o5, "getBooleanType(...)");
            return o5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends v {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final b f47461d = new b();

        private b() {
            super("Int", w.f47463a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t0 c(kotlin.reflect.jvm.internal.impl.builtins.j jVar) {
            g0.p(jVar, "<this>");
            e1 E = jVar.E();
            g0.o(E, "getIntType(...)");
            return E;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends v {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final c f47462d = new c();

        private c() {
            super("Unit", x.f47464a, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final t0 c(kotlin.reflect.jvm.internal.impl.builtins.j jVar) {
            g0.p(jVar, "<this>");
            e1 a02 = jVar.a0();
            g0.o(a02, "getUnitType(...)");
            return a02;
        }
    }

    public /* synthetic */ v(String str, Function1 function1, kotlin.jvm.internal.v vVar) {
        this(str, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private v(String str, Function1<? super kotlin.reflect.jvm.internal.impl.builtins.j, ? extends t0> function1) {
        this.f47457a = str;
        this.f47458b = function1;
        this.f47459c = "must return " + str;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y functionDescriptor) {
        g0.p(functionDescriptor, "functionDescriptor");
        return g0.g(functionDescriptor.getReturnType(), this.f47458b.invoke(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @NotNull
    public String getDescription() {
        return this.f47459c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.f
    @Nullable
    public String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y yVar) {
        return f.a.a(this, yVar);
    }
}
