package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,33:1\n55#2,8:34\n*S KotlinDebug\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n*L\n31#1:34,8\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {41}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt$whileSelect$1\n*L\n1#1,33:1\n*E\n"})
    static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f49587a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f49588b;

        /* renamed from: c, reason: collision with root package name */
        int f49589c;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f49588b = obj;
            this.f49589c |= Integer.MIN_VALUE;
            return t.a(null, this);
        }

        a(kotlin.coroutines.e<? super a> eVar) {
            super(eVar);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004c -> B:10:0x004f). Please report as a decompilation issue!!! */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.selects.c<? super java.lang.Boolean>, kotlin.n1> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.e<? super kotlin.n1> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.selects.t.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.selects.t$a r0 = (kotlinx.coroutines.selects.t.a) r0
            int r1 = r0.f49589c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49589c = r1
            goto L18
        L13:
            kotlinx.coroutines.selects.t$a r0 = new kotlinx.coroutines.selects.t$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f49588b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.l()
            int r2 = r0.f49589c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f49587a
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.g0.n(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.g0.n(r5)
        L38:
            kotlinx.coroutines.selects.l r5 = new kotlinx.coroutines.selects.l
            kotlin.coroutines.i r2 = r0.getContext()
            r5.<init>(r2)
            r4.invoke(r5)
            r0.f49587a = r4
            r0.f49589c = r3
            java.lang.Object r5 = r5.y(r0)
            if (r5 != r1) goto L4f
            return r1
        L4f:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L38
            kotlin.n1 r4 = kotlin.n1.f44123a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.t.a(kotlin.jvm.functions.Function1, kotlin.coroutines.e):java.lang.Object");
    }

    @ExperimentalCoroutinesApi
    private static final Object b(Function1<? super c<? super Boolean>, n1> function1, kotlin.coroutines.e<? super n1> eVar) {
        d0.e(3);
        throw null;
    }
}
