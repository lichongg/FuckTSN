package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class j2<T, V> extends p2<V> implements kotlin.reflect.p<T, V> {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<T, V>> f47503o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.s<Member> f47504p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<T, V> extends p2.c<V> implements p.a<T, V> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final j2<T, V> f47505j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull j2<T, ? extends V> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f47505j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public j2<T, V> f0() {
            return this.f47505j;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t5) {
            return f0().get(t5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f47503o = kotlin.t.b(lazyThreadSafetyMode, new h2(this));
        this.f47504p = kotlin.t.b(lazyThreadSafetyMode, new i2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a q0(j2 j2Var) {
        return new a(j2Var);
    }

    @Override // kotlin.reflect.p
    @Nullable
    public Object getDelegate(T t5) {
        return l0(this.f47504p.getValue(), t5, null);
    }

    @Override // kotlin.reflect.jvm.internal.p2
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a<T, V> n0() {
        return this.f47503o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Member t0(j2 j2Var) {
        return j2Var.j0();
    }

    @Override // kotlin.reflect.p
    public V get(T t5) {
        return n0().call(t5);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t5) {
        return get(t5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j2(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f47503o = kotlin.t.b(lazyThreadSafetyMode, new h2(this));
        this.f47504p = kotlin.t.b(lazyThreadSafetyMode, new i2(this));
    }
}
