package kotlin.coroutines;

import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nContinuation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Continuation.kt\nkotlin/coroutines/ContinuationKt$Continuation$1\n*L\n1#1,161:1\n*E\n"})
    public static final class a<T> implements e<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f43767a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Result<? extends T>, n1> f43768b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i iVar, Function1<? super Result<? extends T>, n1> function1) {
            this.f43767a = iVar;
            this.f43768b = function1;
        }

        @Override // kotlin.coroutines.e
        public i getContext() {
            return this.f43767a;
        }

        @Override // kotlin.coroutines.e
        public void resumeWith(Object obj) {
            this.f43768b.invoke(Result.m129boximpl(obj));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Object j(Function1<? super e<? super T>, n1> function1, e<? super T> eVar) {
        d0.e(0);
        k kVar = new k(kotlin.coroutines.intrinsics.a.e(eVar));
        function1.invoke(kVar);
        Object b6 = kVar.b();
        if (b6 == kotlin.coroutines.intrinsics.a.l()) {
            kotlin.coroutines.jvm.internal.e.c(eVar);
        }
        d0.e(1);
        return b6;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> e<T> a(i context, Function1<? super Result<? extends T>, n1> resumeWith) {
        g0.p(context, "context");
        g0.p(resumeWith, "resumeWith");
        return new a(context, resumeWith);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> e<n1> b(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> completion) {
        g0.p(function1, "<this>");
        g0.p(completion, "completion");
        return new k(kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.b(function1, completion)), kotlin.coroutines.intrinsics.a.l());
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <R, T> e<n1> c(@NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, @NotNull e<? super T> completion) {
        g0.p(function2, "<this>");
        g0.p(completion, "completion");
        return new k(kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.c(function2, r5, completion)), kotlin.coroutines.intrinsics.a.l());
    }

    private static final i d() {
        throw new NotImplementedError("Implemented as intrinsic");
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void f(e<? super T> eVar, T t5) {
        g0.p(eVar, "<this>");
        Result.a aVar = Result.Companion;
        eVar.resumeWith(Result.m130constructorimpl(t5));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> void g(e<? super T> eVar, Throwable exception) {
        g0.p(eVar, "<this>");
        g0.p(exception, "exception");
        Result.a aVar = Result.Companion;
        eVar.resumeWith(Result.m130constructorimpl(kotlin.g0.a(exception)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> void h(@NotNull Function1<? super e<? super T>, ? extends Object> function1, @NotNull e<? super T> completion) {
        g0.p(function1, "<this>");
        g0.p(completion, "completion");
        e e6 = kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.b(function1, completion));
        n1 n1Var = n1.f44123a;
        Result.a aVar = Result.Companion;
        e6.resumeWith(Result.m130constructorimpl(n1Var));
    }

    @SinceKotlin(version = "1.3")
    public static final <R, T> void i(@NotNull Function2<? super R, ? super e<? super T>, ? extends Object> function2, R r5, @NotNull e<? super T> completion) {
        g0.p(function2, "<this>");
        g0.p(completion, "completion");
        e e6 = kotlin.coroutines.intrinsics.a.e(kotlin.coroutines.intrinsics.a.c(function2, r5, completion));
        n1 n1Var = n1.f44123a;
        Result.a aVar = Result.Companion;
        e6.resumeWith(Result.m130constructorimpl(n1Var));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    public static /* synthetic */ void e() {
    }
}
