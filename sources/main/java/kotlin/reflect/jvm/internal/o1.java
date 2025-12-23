package kotlin.reflect.jvm.internal;

import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1<V> extends g2<V> implements kotlin.reflect.k<V> {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<V>> f47539q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<R> extends p2.d<R> implements k.a<R> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final o1<R> f47540j;

        public a(@NotNull o1<R> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f47540j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public o1<R> f0() {
            return this.f47540j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Object obj) {
            m0(obj);
            return kotlin.n1.f44123a;
        }

        public void m0(R r5) {
            f0().set(r5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        this.f47539q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new n1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a v0(o1 o1Var) {
        return new a(o1Var);
    }

    @Override // kotlin.reflect.k, kotlin.reflect.j
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a<V> getSetter() {
        return this.f47539q.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        this.f47539q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new n1(this));
    }

    @Override // kotlin.reflect.k
    public void set(V v5) {
        getSetter().call(v5);
    }
}
