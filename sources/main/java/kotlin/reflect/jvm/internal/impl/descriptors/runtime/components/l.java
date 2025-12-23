package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.u;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class l implements x3.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f44977a = new l();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements x3.a {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final u f44978b;

        public a(@NotNull u javaElement) {
            g0.p(javaElement, "javaElement");
            this.f44978b = javaElement;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
        @NotNull
        public f1 b() {
            f1 NO_SOURCE_FILE = f1.f44684a;
            g0.o(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // x3.a
        @NotNull
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public u c() {
            return this.f44978b;
        }

        @NotNull
        public String toString() {
            return a.class.getName() + ": " + c();
        }
    }

    @Override // x3.b
    @NotNull
    public x3.a a(@NotNull y3.l javaElement) {
        g0.p(javaElement, "javaElement");
        return new a((u) javaElement);
    }

    private l() {
    }
}
