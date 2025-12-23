package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class n {
    private static /* synthetic */ void a(int i6) {
        Object[] objArr = new Object[3];
        if (i6 == 1 || i6 == 2) {
            objArr[0] = "companionObject";
        } else if (i6 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i6 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i6 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i6 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar == null) {
            a(1);
        }
        return kotlin.reflect.jvm.internal.impl.resolve.i.x(kVar) && kotlin.reflect.jvm.internal.impl.resolve.i.w(kVar.b()) && !d((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
    }

    public static boolean e(@NotNull w0 w0Var) {
        if (w0Var == null) {
            a(0);
        }
        if (w0Var.h() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(w0Var.b())) {
            return true;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.i.x(w0Var.b()) && b(w0Var);
    }

    public static boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.descriptors.v O;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if ((callableMemberDescriptor instanceof w0) && (O = ((w0) callableMemberDescriptor).O()) != null && O.getAnnotations().l(h0.f45436b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().l(h0.f45436b);
    }

    public static boolean d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (dVar == null) {
            a(2);
        }
        return kotlin.reflect.jvm.internal.impl.builtins.e.a(kotlin.reflect.jvm.internal.impl.builtins.d.f44402a, dVar);
    }
}
