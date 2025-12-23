package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class t extends c {

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f44888c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e f44889d;

    private static /* synthetic */ void T(int i6) {
        String str = (i6 == 1 || i6 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i6 == 1 || i6 == 2) ? 2 : 3];
        if (i6 == 1 || i6 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i6 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i6 == 1) {
            objArr[1] = "getValue";
        } else if (i6 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i6 != 1 && i6 != 2) {
            if (i6 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i6 != 1 && i6 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0.b());
        if (dVar == null) {
            T(0);
        }
        this.f44888c = dVar;
        this.f44889d = new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e(dVar, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = this.f44888c;
        if (dVar == null) {
            T(2);
        }
        return dVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.h getValue() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.e eVar = this.f44889d;
        if (eVar == null) {
            T(1);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m
    public String toString() {
        return "class " + this.f44888c.getName() + "::this";
    }
}
