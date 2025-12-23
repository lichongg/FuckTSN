package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface e1 {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f44683a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements e1 {
        private static /* synthetic */ void d(int i6) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
        @NotNull
        public f1 b() {
            f1 f1Var = f1.f44684a;
            if (f1Var == null) {
                d(0);
            }
            return f1Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }

        a() {
        }
    }

    @NotNull
    f1 b();
}
