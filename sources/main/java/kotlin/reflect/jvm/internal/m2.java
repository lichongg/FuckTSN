package kotlin.reflect.jvm.internal;

import java.lang.reflect.Member;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.CallableReference;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class m2<D, E, V> extends p2<V> implements kotlin.reflect.q<D, E, V> {

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<D, E, V>> f47530o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    private final kotlin.s<Member> f47531p;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<D, E, V> extends p2.c<V> implements q.a<D, E, V> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final m2<D, E, V> f47532j;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull m2<D, E, ? extends V> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f47532j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public m2<D, E, V> f0() {
            return this.f47532j;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d6, E e6) {
            return f0().get(d6, e6);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m2(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature) {
        super(container, name, signature, CallableReference.NO_RECEIVER);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f47530o = kotlin.t.b(lazyThreadSafetyMode, new k2(this));
        this.f47531p = kotlin.t.b(lazyThreadSafetyMode, new l2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a q0(m2 m2Var) {
        return new a(m2Var);
    }

    @Override // kotlin.reflect.q
    @Nullable
    public Object getDelegate(D d6, E e6) {
        return l0(this.f47531p.getValue(), d6, e6);
    }

    @Override // kotlin.reflect.jvm.internal.p2
    @NotNull
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> n0() {
        return this.f47530o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Member t0(m2 m2Var) {
        return m2Var.j0();
    }

    @Override // kotlin.reflect.q
    public V get(D d6, E e6) {
        return n0().call(d6, e6);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d6, E e6) {
        return get(d6, e6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m2(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        this.f47530o = kotlin.t.b(lazyThreadSafetyMode, new k2(this));
        this.f47531p = kotlin.t.b(lazyThreadSafetyMode, new l2(this));
    }
}
