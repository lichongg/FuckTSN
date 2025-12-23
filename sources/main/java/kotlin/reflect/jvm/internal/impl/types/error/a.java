package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k;
import kotlin.reflect.jvm.internal.impl.types.f2;
import kotlin.reflect.jvm.internal.impl.types.h2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a extends k {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.f r14) {
        /*
            r13 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.g0.p(r14, r0)
            kotlin.reflect.jvm.internal.impl.types.error.i r0 = kotlin.reflect.jvm.internal.impl.types.error.i.f47232a
            kotlin.reflect.jvm.internal.impl.descriptors.f0 r2 = r0.i()
            kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.OPEN
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.CLASS
            java.util.List r1 = kotlin.collections.f0.J()
            r6 = r1
            java.util.Collection r6 = (java.util.Collection) r6
            kotlin.reflect.jvm.internal.impl.descriptors.e1 r7 = kotlin.reflect.jvm.internal.impl.descriptors.e1.f44683a
            r8 = 0
            kotlin.reflect.jvm.internal.impl.storage.n r9 = kotlin.reflect.jvm.internal.impl.storage.f.f47092e
            r1 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a r14 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f44655q0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.g r14 = r14.b()
            r2 = 1
            kotlin.reflect.jvm.internal.impl.descriptors.impl.i r14 = kotlin.reflect.jvm.internal.impl.descriptors.impl.i.i1(r13, r14, r2, r7)
            java.util.List r2 = kotlin.collections.f0.J()
            kotlin.reflect.jvm.internal.impl.descriptors.s r3 = kotlin.reflect.jvm.internal.impl.descriptors.r.f44947d
            r14.l1(r2, r3)
            java.lang.String r2 = "apply(...)"
            kotlin.jvm.internal.g0.o(r14, r2)
            kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind r2 = kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind.SCOPE_FOR_ERROR_CLASS
            kotlin.reflect.jvm.internal.impl.name.f r3 = r14.getName()
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = ""
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}
            kotlin.reflect.jvm.internal.impl.types.error.f r6 = kotlin.reflect.jvm.internal.impl.types.error.i.b(r2, r3)
            kotlin.reflect.jvm.internal.impl.types.error.g r4 = new kotlin.reflect.jvm.internal.impl.types.error.g
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r7 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.ERROR_CLASS
            r2 = 0
            java.lang.String[] r3 = new java.lang.String[r2]
            kotlin.reflect.jvm.internal.impl.types.error.h r5 = r0.e(r7, r3)
            java.lang.String[] r10 = new java.lang.String[r2]
            r11 = 24
            r12 = 0
            r8 = 0
            r9 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r14.b1(r4)
            java.util.Set r0 = kotlin.collections.u1.f(r14)
            r13.F0(r6, r0, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.a.<init>(kotlin.reflect.jvm.internal.impl.name.f):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.g1
    @NotNull
    /* renamed from: E0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull h2 substitutor) {
        g0.p(substitutor, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.impl.z
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.k T(@NotNull f2 typeSubstitution, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        g0.p(typeSubstitution, "typeSubstitution");
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return i.b(ErrorScopeKind.SCOPE_FOR_ERROR_CLASS, getName().toString(), typeSubstitution.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    public String toString() {
        String b6 = getName().b();
        g0.o(b6, "asString(...)");
        return b6;
    }
}
