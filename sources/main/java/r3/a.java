package r3;

import java.util.Collection;
import kotlin.collections.f0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface a {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: r3.a$a, reason: collision with other inner class name */
    public static final class C1006a implements a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C1006a f51989a = new C1006a();

        @Override // r3.a
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            return f0.J();
        }

        @Override // r3.a
        @NotNull
        public Collection<t0> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            return f0.J();
        }

        @Override // r3.a
        @NotNull
        public Collection<d1> d(@NotNull f name, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            g0.p(name, "name");
            g0.p(classDescriptor, "classDescriptor");
            return f0.J();
        }

        @Override // r3.a
        @NotNull
        public Collection<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            return f0.J();
        }

        private C1006a() {
        }
    }

    @NotNull
    Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<t0> c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<d1> d(@NotNull f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    Collection<f> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);
}
