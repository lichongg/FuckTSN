package r3;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f51990a = new a();

        @Override // r3.c
        public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull d1 functionDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            g0.p(functionDescriptor, "functionDescriptor");
            return true;
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f51991a = new b();

        @Override // r3.c
        public boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull d1 functionDescriptor) {
            g0.p(classDescriptor, "classDescriptor");
            g0.p(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().l(d.a());
        }

        private b() {
        }
    }

    boolean a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull d1 d1Var);
}
