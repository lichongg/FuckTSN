package kotlin.reflect.jvm.internal;

import kotlin.LazyThreadSafetyMode;
import kotlin.reflect.jvm.internal.p2;
import kotlin.reflect.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q1<T, V> extends j2<T, V> implements kotlin.reflect.l<T, V> {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    private final kotlin.s<a<T, V>> f47562q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a<T, V> extends p2.d<V> implements l.a<T, V> {

        /* renamed from: j, reason: collision with root package name */
        @NotNull
        private final q1<T, V> f47563j;

        public a(@NotNull q1<T, V> property) {
            kotlin.jvm.internal.g0.p(property, "property");
            this.f47563j = property;
        }

        @Override // kotlin.reflect.jvm.internal.p2.a
        @NotNull
        /* renamed from: l0, reason: merged with bridge method [inline-methods] */
        public q1<T, V> f0() {
            return this.f47563j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ kotlin.n1 invoke(Object obj, Object obj2) {
            m0(obj, obj2);
            return kotlin.n1.f44123a;
        }

        public void m0(T t5, V v5) {
            f0().set(t5, v5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        super(container, name, signature, obj);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(name, "name");
        kotlin.jvm.internal.g0.p(signature, "signature");
        this.f47562q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new p1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a v0(q1 q1Var) {
        return new a(q1Var);
    }

    @Override // kotlin.reflect.l, kotlin.reflect.j
    @NotNull
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public a<T, V> getSetter() {
        return this.f47562q.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(@NotNull KDeclarationContainerImpl container, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor) {
        super(container, descriptor);
        kotlin.jvm.internal.g0.p(container, "container");
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        this.f47562q = kotlin.t.b(LazyThreadSafetyMode.PUBLICATION, new p1(this));
    }

    @Override // kotlin.reflect.l
    public void set(T t5, V v5) {
        getSetter().call(t5, v5);
    }
}
