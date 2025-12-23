package e4;

import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;

/* loaded from: D:\Downloads\app\classes7.dex */
public /* synthetic */ class m {
    public static /* synthetic */ TypeCheckerState a(n nVar, boolean z5, boolean z6, boolean z7, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: newTypeCheckerState");
        }
        if ((i6 & 4) != 0) {
            z7 = false;
        }
        return nVar.Y(z5, z6, z7);
    }
}
