package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g extends kotlin.reflect.jvm.internal.impl.types.s {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends g {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f47170a = new a();

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
            g0.p(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @NotNull
        public <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.k> S c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull Function0<? extends S> compute) {
            g0.p(classDescriptor, "classDescriptor");
            g0.p(compute, "compute");
            return compute.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean d(@NotNull f0 moduleDescriptor) {
            g0.p(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean e(@NotNull w1 typeConstructor) {
            g0.p(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @NotNull
        public Collection<t0> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            Collection<t0> i6 = classDescriptor.o().i();
            g0.o(i6, "getSupertypes(...)");
            return i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.s
        @NotNull
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public t0 a(@NotNull e4.g type) {
            g0.p(type, "type");
            return (t0) type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @Nullable
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor) {
            g0.p(descriptor, "descriptor");
            return null;
        }

        private a() {
        }
    }

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

    @NotNull
    public abstract <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.k> S c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull Function0<? extends S> function0);

    public abstract boolean d(@NotNull f0 f0Var);

    public abstract boolean e(@NotNull w1 w1Var);

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.f f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar);

    @NotNull
    public abstract Collection<t0> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    /* renamed from: h */
    public abstract t0 a(@NotNull e4.g gVar);
}
