package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.q1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.r;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f45405a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements o {
        private static /* synthetic */ void c(int i6) {
            Object[] objArr = new Object[3];
            switch (i6) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i6 == 5 || i6 == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.o
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list) {
            if (callableMemberDescriptor == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.o
        @NotNull
        public b b(@NotNull r rVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull t0 t0Var, @Nullable t0 t0Var2, @NotNull List<q1> list, @NotNull List<j1> list2) {
            if (rVar == null) {
                c(0);
            }
            if (dVar == null) {
                c(1);
            }
            if (t0Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(t0Var, t0Var2, list, list2, Collections.EMPTY_LIST, false);
        }

        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final t0 f45406a;

        /* renamed from: b, reason: collision with root package name */
        private final t0 f45407b;

        /* renamed from: c, reason: collision with root package name */
        private final List<q1> f45408c;

        /* renamed from: d, reason: collision with root package name */
        private final List<j1> f45409d;

        /* renamed from: e, reason: collision with root package name */
        private final List<String> f45410e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f45411f;

        private static /* synthetic */ void a(int i6) {
            String str = (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) ? 2 : 3];
            switch (i6) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i6 == 4) {
                objArr[1] = "getReturnType";
            } else if (i6 == 5) {
                objArr[1] = "getValueParameters";
            } else if (i6 == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i6 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
            }
            if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i6 != 4 && i6 != 5 && i6 != 6 && i6 != 7) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public b(@NotNull t0 t0Var, @Nullable t0 t0Var2, @NotNull List<q1> list, @NotNull List<j1> list2, @NotNull List<String> list3, boolean z5) {
            if (t0Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.f45406a = t0Var;
            this.f45407b = t0Var2;
            this.f45408c = list;
            this.f45409d = list2;
            this.f45410e = list3;
            this.f45411f = z5;
        }

        @NotNull
        public List<String> b() {
            List<String> list = this.f45410e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        @Nullable
        public t0 c() {
            return this.f45407b;
        }

        @NotNull
        public t0 d() {
            t0 t0Var = this.f45406a;
            if (t0Var == null) {
                a(4);
            }
            return t0Var;
        }

        @NotNull
        public List<j1> e() {
            List<j1> list = this.f45409d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        @NotNull
        public List<q1> f() {
            List<q1> list = this.f45408c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f45411f;
        }
    }

    void a(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull List<String> list);

    @NotNull
    b b(@NotNull r rVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull t0 t0Var, @Nullable t0 t0Var2, @NotNull List<q1> list, @NotNull List<j1> list2);
}
