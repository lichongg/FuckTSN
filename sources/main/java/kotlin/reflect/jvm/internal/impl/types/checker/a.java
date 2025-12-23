package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.g0;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class a {
    @NotNull
    public static final TypeCheckerState a(boolean z5, boolean z6, @NotNull b typeSystemContext, @NotNull f kotlinTypePreparator, @NotNull g kotlinTypeRefiner) {
        g0.p(typeSystemContext, "typeSystemContext");
        g0.p(kotlinTypePreparator, "kotlinTypePreparator");
        g0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeCheckerState(z5, z6, false, true, typeSystemContext, kotlinTypePreparator, kotlinTypeRefiner);
    }

    public static /* synthetic */ TypeCheckerState b(boolean z5, boolean z6, b bVar, f fVar, g gVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z6 = true;
        }
        if ((i6 & 4) != 0) {
            bVar = u.f47196a;
        }
        if ((i6 & 8) != 0) {
            fVar = f.a.f47169a;
        }
        if ((i6 & 16) != 0) {
            gVar = g.a.f47170a;
        }
        return a(z5, z6, bVar, fVar, gVar);
    }
}
