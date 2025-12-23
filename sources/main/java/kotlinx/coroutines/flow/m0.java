package kotlinx.coroutines.flow;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.List;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class m0<T> implements x<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final x<T> f49065a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Function2<j<? super T>, kotlin.coroutines.e<? super n1>, Object> f49066b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedSharedFlow", f = "Share.kt", i = {}, l = {TTAdConstant.IMAGE_LIST_CODE}, m = "collect", n = {}, s = {})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f49067a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m0<T> f49068b;

        /* renamed from: c, reason: collision with root package name */
        int f49069c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m0<T> m0Var, kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
            this.f49068b = m0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49067a = obj;
            this.f49069c |= Integer.MIN_VALUE;
            return this.f49068b.collect(null, this);
        }
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> a() {
        return this.f49065a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.x, kotlinx.coroutines.flow.i
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.j<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<?> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.m0.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.m0$a r0 = (kotlinx.coroutines.flow.m0.a) r0
            int r1 = r0.f49069c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49069c = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.m0$a r0 = new kotlinx.coroutines.flow.m0$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f49067a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49069c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2d:
            kotlin.g0.n(r7)
            goto L46
        L31:
            kotlin.g0.n(r7)
            kotlinx.coroutines.flow.x<T> r7 = r5.f49065a
            kotlinx.coroutines.flow.l0 r2 = new kotlinx.coroutines.flow.l0
            kotlin.jvm.functions.Function2<kotlinx.coroutines.flow.j<? super T>, kotlin.coroutines.e<? super kotlin.n1>, java.lang.Object> r4 = r5.f49066b
            r2.<init>(r6, r4)
            r0.f49069c = r3
            java.lang.Object r6 = r7.collect(r2, r0)
            if (r6 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.m0.collect(kotlinx.coroutines.flow.j, kotlin.coroutines.e):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m0(@NotNull x<? extends T> xVar, @NotNull Function2<? super j<? super T>, ? super kotlin.coroutines.e<? super n1>, ? extends Object> function2) {
        this.f49065a = xVar;
        this.f49066b = function2;
    }
}
