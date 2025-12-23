package kotlinx.coroutines.flow.internal;

import kotlin.BuilderInference;
import kotlin.PublishedApi;
import kotlin.coroutines.i;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class SafeCollector_commonKt {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function2<Integer, i.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SafeCollector<?> f48901a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SafeCollector<?> safeCollector) {
            super(2);
            this.f48901a = safeCollector;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, i.b bVar) {
            return a(num.intValue(), bVar);
        }

        @NotNull
        public final Integer a(int i6, @NotNull i.b bVar) {
            int i7;
            i.c<?> key = bVar.getKey();
            i.b bVar2 = this.f48901a.collectContext.get(key);
            if (key != e2.f48569s0) {
                if (bVar != bVar2) {
                    i7 = Integer.MIN_VALUE;
                } else {
                    i7 = i6 + 1;
                }
                return Integer.valueOf(i7);
            }
            e2 e2Var = (e2) bVar2;
            g0.n(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            e2 b6 = SafeCollector_commonKt.b((e2) bVar, e2Var);
            if (b6 == e2Var) {
                if (e2Var != null) {
                    i6++;
                }
                return Integer.valueOf(i6);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b6 + ", expected child of " + e2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }
    }

    @JvmName(name = "checkContext")
    public static final void a(@NotNull SafeCollector<?> safeCollector, @NotNull kotlin.coroutines.i iVar) {
        if (((Number) iVar.fold(0, new a(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + iVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    public static final e2 b(@Nullable e2 e2Var, @Nullable e2 e2Var2) {
        while (e2Var != null) {
            if (e2Var == e2Var2 || !(e2Var instanceof o0)) {
                return e2Var;
            }
            e2Var = e2Var.getParent();
        }
        return null;
    }

    @PublishedApi
    @NotNull
    public static final <T> kotlinx.coroutines.flow.i<T> c(@BuilderInference @NotNull Function2<? super kotlinx.coroutines.flow.j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        return new SafeCollector_commonKt$unsafeFlow$1(function2);
    }
}
