package kotlinx.coroutines;

import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1454:1\n341#2,6:1455\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/NodeList\n*L\n1364#1:1455,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q2 extends kotlinx.coroutines.internal.w implements y1 {
    @Override // kotlinx.coroutines.y1
    public boolean isActive() {
        return true;
    }

    @NotNull
    public final String D(@NotNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object n6 = n();
        kotlin.jvm.internal.g0.n(n6, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        boolean z5 = true;
        for (kotlinx.coroutines.internal.y yVar = (kotlinx.coroutines.internal.y) n6; !kotlin.jvm.internal.g0.g(yVar, this); yVar = yVar.o()) {
            if (yVar instanceof k2) {
                k2 k2Var = (k2) yVar;
                if (z5) {
                    z5 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(k2Var);
            }
        }
        sb.append("]");
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // kotlinx.coroutines.internal.y
    @NotNull
    public String toString() {
        return super.toString();
    }

    @Override // kotlinx.coroutines.y1
    @NotNull
    public q2 a() {
        return this;
    }
}
