package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface i0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f44751a = a.f44752a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f44752a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final kotlin.reflect.jvm.internal.impl.descriptors.e0<i0> f44753b = new kotlin.reflect.jvm.internal.impl.descriptors.e0<>("PackageViewDescriptorFactory");

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.e0<i0> a() {
            return f44753b;
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements i0 {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f44754b = new b();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.i0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.s0 a(@NotNull f0 module, @NotNull kotlin.reflect.jvm.internal.impl.name.c fqName, @NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager) {
            kotlin.jvm.internal.g0.p(module, "module");
            kotlin.jvm.internal.g0.p(fqName, "fqName");
            kotlin.jvm.internal.g0.p(storageManager, "storageManager");
            return new x(module, fqName, storageManager);
        }

        private b() {
        }
    }

    @NotNull
    kotlin.reflect.jvm.internal.impl.descriptors.s0 a(@NotNull f0 f0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.c cVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar);
}
