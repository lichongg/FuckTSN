package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class c1<T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.k> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f44678a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function1<kotlin.reflect.jvm.internal.impl.types.checker.g, T> f44679b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f44680c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.storage.i f44681d;

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f44677f = {kotlin.jvm.internal.o0.u(new PropertyReference1Impl(c1.class, "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0))};

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f44676e = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final <T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.k> c1<T> a(@NotNull d classDescriptor, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefinerForOwnerModule, @NotNull Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> scopeFactory) {
            kotlin.jvm.internal.g0.p(classDescriptor, "classDescriptor");
            kotlin.jvm.internal.g0.p(storageManager, "storageManager");
            kotlin.jvm.internal.g0.p(kotlinTypeRefinerForOwnerModule, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.g0.p(scopeFactory, "scopeFactory");
            return new c1<>(classDescriptor, storageManager, scopeFactory, kotlinTypeRefinerForOwnerModule, null);
        }
    }

    public /* synthetic */ c1(d dVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, Function1 function1, kotlin.reflect.jvm.internal.impl.types.checker.g gVar, kotlin.jvm.internal.v vVar) {
        this(dVar, nVar, function1, gVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private c1(d dVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends T> function1, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        this.f44678a = dVar;
        this.f44679b = function1;
        this.f44680c = gVar;
        this.f44681d = nVar.e(new a1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k d(c1 c1Var, kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        return c1Var.f44679b.invoke(gVar);
    }

    private final T e() {
        return (T) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f44681d, this, f44677f[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.resolve.scopes.k f(c1 c1Var) {
        return c1Var.f44679b.invoke(c1Var.f44680c);
    }

    @NotNull
    public final T c(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.d(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.s(this.f44678a))) {
            return e();
        }
        w1 o5 = this.f44678a.o();
        kotlin.jvm.internal.g0.o(o5, "getTypeConstructor(...)");
        return !kotlinTypeRefiner.e(o5) ? e() : (T) kotlinTypeRefiner.c(this.f44678a, new b1(this, kotlinTypeRefiner));
    }
}
