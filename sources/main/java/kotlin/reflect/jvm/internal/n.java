package kotlin.reflect.jvm.internal;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nutil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 util.kt\nkotlin/reflect/jvm/internal/CreateKCallableVisitor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,333:1\n1#2:334\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class n extends kotlin.reflect.jvm.internal.impl.descriptors.impl.o<e0<?>, kotlin.n1> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final KDeclarationContainerImpl f47533a;

    public n(@NotNull KDeclarationContainerImpl container) {
        kotlin.jvm.internal.g0.p(container, "container");
        this.f47533a = container;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o, kotlin.reflect.jvm.internal.impl.descriptors.m
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public e0<?> l(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.y descriptor, @NotNull kotlin.n1 data) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(data, "data");
        return new m1(this.f47533a, descriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.o, kotlin.reflect.jvm.internal.impl.descriptors.m
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public e0<?> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w0 descriptor, @NotNull kotlin.n1 data) {
        kotlin.jvm.internal.g0.p(descriptor, "descriptor");
        kotlin.jvm.internal.g0.p(data, "data");
        int i6 = (descriptor.c0() != null ? 1 : 0) + (descriptor.f0() != null ? 1 : 0);
        if (descriptor.C()) {
            if (i6 == 0) {
                return new o1(this.f47533a, descriptor);
            }
            if (i6 == 1) {
                return new q1(this.f47533a, descriptor);
            }
            if (i6 == 2) {
                return new s1(this.f47533a, descriptor);
            }
        } else {
            if (i6 == 0) {
                return new g2(this.f47533a, descriptor);
            }
            if (i6 == 1) {
                return new j2(this.f47533a, descriptor);
            }
            if (i6 == 2) {
                return new m2(this.f47533a, descriptor);
            }
        }
        throw new KotlinReflectionInternalError("Unsupported property: " + descriptor);
    }
}
