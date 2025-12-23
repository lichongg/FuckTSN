package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.q;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f45398a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements j {
        private static /* synthetic */ void f(int i6) {
            Object[] objArr = new Object[3];
            switch (i6) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i6) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void a(@NotNull q qVar, @NotNull d1 d1Var) {
            if (qVar == null) {
                f(1);
            }
            if (d1Var == null) {
                f(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void b(@NotNull y3.l lVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j jVar) {
            if (lVar == null) {
                f(3);
            }
            if (jVar == null) {
                f(4);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void c(@NotNull y3.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            if (gVar == null) {
                f(7);
            }
            if (dVar == null) {
                f(8);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
            if (cVar != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.j
        public void e(@NotNull y3.n nVar, @NotNull w0 w0Var) {
            if (nVar == null) {
                f(5);
            }
            if (w0Var == null) {
                f(6);
            }
        }

        a() {
        }
    }

    void a(@NotNull q qVar, @NotNull d1 d1Var);

    void b(@NotNull y3.l lVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.j jVar);

    void c(@NotNull y3.g gVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @Nullable
    kotlin.reflect.jvm.internal.impl.descriptors.d d(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar);

    void e(@NotNull y3.n nVar, @NotNull w0 w0Var);
}
