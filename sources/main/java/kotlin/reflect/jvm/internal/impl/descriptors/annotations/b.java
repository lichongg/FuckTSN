package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final g f44645a;

    private static /* synthetic */ void T(int i6) {
        String str = i6 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i6 != 1 ? 3 : 2];
        if (i6 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i6 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i6 != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i6 == 1) {
            throw new IllegalStateException(format);
        }
    }

    public b(@NotNull g gVar) {
        if (gVar == null) {
            T(0);
        }
        this.f44645a = gVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public g getAnnotations() {
        g gVar = this.f44645a;
        if (gVar == null) {
            T(1);
        }
        return gVar;
    }
}
