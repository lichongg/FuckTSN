package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f47070a = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a implements v {
        private static /* synthetic */ void c(int i6) {
            Object[] objArr = new Object[3];
            if (i6 != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i6 != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.v
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                c(2);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.v
        public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<String> list) {
            if (dVar == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }

        a() {
        }
    }

    void a(@NotNull CallableMemberDescriptor callableMemberDescriptor);

    void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull List<String> list);
}
