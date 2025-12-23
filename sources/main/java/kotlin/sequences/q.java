package kotlin.sequences;

import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static final int f47776a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static final int f47777b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f47778c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f47779d = 3;

    /* renamed from: e, reason: collision with root package name */
    private static final int f47780e = 4;

    /* renamed from: f, reason: collision with root package name */
    private static final int f47781f = 5;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SequenceBuilder.kt\nkotlin/sequences/SequencesKt__SequenceBuilderKt\n*L\n1#1,731:1\n26#2:732\n*E\n"})
    public static final class a<T> implements m<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2 f47782a;

        public a(Function2 function2) {
            this.f47782a = function2;
        }

        @Override // kotlin.sequences.m
        public Iterator<T> iterator() {
            return q.a(this.f47782a);
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> Iterator<T> a(@BuilderInference @NotNull Function2<? super o<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        n nVar = new n();
        nVar.m(kotlin.coroutines.intrinsics.a.c(block, nVar, nVar));
        return nVar;
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static <T> m<T> b(@BuilderInference @NotNull Function2<? super o<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> block) {
        kotlin.jvm.internal.g0.p(block, "block");
        return new a(block);
    }
}
