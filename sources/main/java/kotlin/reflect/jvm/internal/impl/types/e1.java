package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class e1 extends m2 implements e4.i, e4.k {
    public e1() {
        super(null);
    }

    @NotNull
    public abstract e1 P0(boolean z5);

    @NotNull
    public abstract e1 Q0(@NotNull t1 t1Var);

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            kotlin.text.u.s0(sb, "[", kotlin.reflect.jvm.internal.impl.renderer.m.P(kotlin.reflect.jvm.internal.impl.renderer.m.f46584k, it.next(), null, 2, null), "] ");
        }
        sb.append(I0());
        if (!G0().isEmpty()) {
            kotlin.collections.r0.o3(G0(), sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "<", (r14 & 8) == 0 ? ">" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
        if (J0()) {
            sb.append("?");
        }
        return sb.toString();
    }
}
