package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class b extends q {
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void H(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = 3
            goto L18
        L17:
            r5 = 2
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.H(int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w, kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    /* renamed from: I */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.d c();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar);
        if (nVar == null) {
            H(0);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w
    protected boolean g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (fVar == null) {
            H(2);
        }
        return (fVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && e(c(), fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.w1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.j p() {
        kotlin.reflect.jvm.internal.impl.builtins.j m6 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.e.m(c());
        if (m6 == null) {
            H(1);
        }
        return m6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q
    @Nullable
    protected t0 s() {
        if (kotlin.reflect.jvm.internal.impl.builtins.j.v0(c())) {
            return null;
        }
        return p().i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.q
    @NotNull
    protected Collection<t0> t(boolean z5) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b6 = c().b();
        if (!(b6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                H(3);
            }
            return list;
        }
        kotlin.reflect.jvm.internal.impl.utils.j jVar = new kotlin.reflect.jvm.internal.impl.utils.j();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b6;
        jVar.add(dVar.s());
        kotlin.reflect.jvm.internal.impl.descriptors.d s02 = dVar.s0();
        if (z5 && s02 != null) {
            jVar.add(s02.s());
        }
        return jVar;
    }
}
