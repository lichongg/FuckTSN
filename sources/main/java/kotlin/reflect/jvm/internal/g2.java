package kotlin.reflect.jvm.internal;

import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g2<V> extends p2<V> implements kotlin.reflect.o<V> {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<V>> f44353o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.s<Object> f44354p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<R> extends p2.c<R> implements o.a<R> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final g2<R> f44355j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull g2<? extends R> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f44355j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public g2<R> f0() {
            return this.f44355j;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return c().get();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f44353o = kotlin.t.b(lazyThreadSafetyMode, new e2(this));
        this.f44354p = kotlin.t.b(lazyThreadSafetyMode, new f2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a q0(g2 g2Var) {
        return new a(g2Var);
    }

    @Override // kotlin.reflect.o
    @Nullable
    public Object getDelegate() {
        return this.f44354p.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.p2
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public a<V> n0() {
        return this.f44353o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object t0(g2 g2Var) {
        return g2Var.l0(g2Var.j0(), null, null);
    }

    @Override // kotlin.reflect.o
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f44353o = kotlin.t.b(lazyThreadSafetyMode, new e2(this));
        this.f44354p = kotlin.t.b(lazyThreadSafetyMode, new f2(this));
    }
}
