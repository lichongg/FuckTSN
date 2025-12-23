package kotlinx.coroutines;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCancellableContinuationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CancellableContinuationImpl.kt\nkotlinx/coroutines/CompletedContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,662:1\n1#2:663\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class c0 {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Object f48105a;

    /* renamed from: b, reason: collision with root package name */
    @JvmField
    @Nullable
    public final n f48106b;

    /* renamed from: c, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Function1<Throwable, kotlin.n1> f48107c;

    /* renamed from: d, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Object f48108d;

    /* renamed from: e, reason: collision with root package name */
    @JvmField
    @Nullable
    public final Throwable f48109e;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@Nullable Object obj, @Nullable n nVar, @Nullable Function1<? super Throwable, kotlin.n1> function1, @Nullable Object obj2, @Nullable Throwable th) {
        this.f48105a = obj;
        this.f48106b = nVar;
        this.f48107c = function1;
        this.f48108d = obj2;
        this.f48109e = th;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return kotlin.jvm.internal.g0.g(this.f48105a, c0Var.f48105a) && kotlin.jvm.internal.g0.g(this.f48106b, c0Var.f48106b) && kotlin.jvm.internal.g0.g(this.f48107c, c0Var.f48107c) && kotlin.jvm.internal.g0.g(this.f48108d, c0Var.f48108d) && kotlin.jvm.internal.g0.g(this.f48109e, c0Var.f48109e);
    }

    public static /* synthetic */ c0 g(c0 c0Var, Object obj, n nVar, Function1 function1, Object obj2, Throwable th, int i6, Object obj3) {
        if ((i6 & 1) != 0) {
            obj = c0Var.f48105a;
        }
        if ((i6 & 2) != 0) {
            nVar = c0Var.f48106b;
        }
        if ((i6 & 4) != 0) {
            function1 = c0Var.f48107c;
        }
        if ((i6 & 8) != 0) {
            obj2 = c0Var.f48108d;
        }
        if ((i6 & 16) != 0) {
            th = c0Var.f48109e;
        }
        Throwable th2 = th;
        Function1 function12 = function1;
        return c0Var.f(obj, nVar, function12, obj2, th2);
    }

    @Nullable
    public final Object a() {
        return this.f48105a;
    }

    @Nullable
    public final n b() {
        return this.f48106b;
    }

    @Nullable
    public final Function1<Throwable, kotlin.n1> c() {
        return this.f48107c;
    }

    @Nullable
    public final Object d() {
        return this.f48108d;
    }

    @Nullable
    public final Throwable e() {
        return this.f48109e;
    }

    @NotNull
    public final c0 f(@Nullable Object obj, @Nullable n nVar, @Nullable Function1<? super Throwable, kotlin.n1> function1, @Nullable Object obj2, @Nullable Throwable th) {
        return new c0(obj, nVar, function1, obj2, th);
    }

    public final boolean h() {
        return this.f48109e != null;
    }

    public int hashCode() {
        Object obj = this.f48105a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        n nVar = this.f48106b;
        int hashCode2 = (hashCode + (nVar == null ? 0 : nVar.hashCode())) * 31;
        Function1<Throwable, kotlin.n1> function1 = this.f48107c;
        int hashCode3 = (hashCode2 + (function1 == null ? 0 : function1.hashCode())) * 31;
        Object obj2 = this.f48108d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f48109e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final void i(@NotNull q<?> qVar, @NotNull Throwable th) {
        n nVar = this.f48106b;
        if (nVar != null) {
            qVar.m(nVar, th);
        }
        Function1<Throwable, kotlin.n1> function1 = this.f48107c;
        if (function1 != null) {
            qVar.p(function1, th);
        }
    }

    @NotNull
    public String toString() {
        return "CompletedContinuation(result=" + this.f48105a + ", cancelHandler=" + this.f48106b + ", onCancellation=" + this.f48107c + ", idempotentResume=" + this.f48108d + ", cancelCause=" + this.f48109e + ')';
    }

    public /* synthetic */ c0(Object obj, n nVar, Function1 function1, Object obj2, Throwable th, int i6, kotlin.jvm.internal.v vVar) {
        this(obj, (i6 & 2) != 0 ? null : nVar, (i6 & 4) != 0 ? null : function1, (i6 & 8) != 0 ? null : obj2, (i6 & 16) != 0 ? null : th);
    }
}
