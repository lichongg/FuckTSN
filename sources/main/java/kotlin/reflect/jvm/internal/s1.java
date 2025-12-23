package kotlin.reflect.jvm.internal;

import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class s1<D, E, V> extends m2<D, E, V> implements kotlin.reflect.m<D, E, V> {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<D, E, V>> f47583q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<D, E, V> extends p2.d<V> implements m.a<D, E, V> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final s1<D, E, V> f47584j;

        public a(@NotNull s1<D, E, V> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f47584j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public s1<D, E, V> f0() {
            return this.f47584j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Object obj, Object obj2, Object obj3) {
            m0(obj, obj2, obj3);
            return kotlin.n1.f44123a;
        }

        public void m0(D d6, E e6, V v5) {
            f0().set(d6, e6, v5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature) {
        super(container, name, signature);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        this.f47583q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new r1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a v0(s1 s1Var) {
        return new a(s1Var);
    }

    @Override // kotlin.reflect.m, kotlin.reflect.j
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a<D, E, V> getSetter() {
        return this.f47583q.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        this.f47583q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new r1(this));
    }

    @Override // kotlin.reflect.m
    public void set(D d6, E e6, V v5) {
        getSetter().call(d6, e6, v5);
    }
}
