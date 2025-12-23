package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlin.n1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class o {

    /* renamed from: b, reason: collision with root package name */
    private static final int f49573b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final int f49574c = 1;

    /* renamed from: d, reason: collision with root package name */
    private static final int f49575d = 2;

    /* renamed from: e, reason: collision with root package name */
    private static final int f49576e = 3;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Function3<Object, Object, Object, Object> f49572a = a.f49582a;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final s0 f49577f = new s0("STATE_REG");

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final s0 f49578g = new s0("STATE_COMPLETED");

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final s0 f49579h = new s0("STATE_CANCELLED");

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final s0 f49580i = new s0("NO_RESULT");

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final s0 f49581j = new s0("PARAM_CLAUSE_0");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class a extends Lambda implements Function3 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f49582a = new a();

        a() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(@NotNull Object obj, @Nullable Object obj2, @Nullable Object obj3) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrySelectDetailedResult d(int i6) {
        if (i6 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i6 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i6 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i6 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i6).toString());
    }

    @NotNull
    public static final s0 l() {
        return f49581j;
    }

    @Nullable
    public static final <R> Object m(@NotNull Function1<? super c<? super R>, n1> function1, @NotNull kotlin.coroutines.e<? super R> eVar) {
        l lVar = new l(eVar.getContext());
        function1.invoke(lVar);
        return lVar.y(eVar);
    }

    private static final <R> Object n(Function1<? super c<? super R>, n1> function1, kotlin.coroutines.e<? super R> eVar) {
        d0.e(3);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(kotlinx.coroutines.p<? super n1> pVar, Function1<? super Throwable, n1> function1) {
        Object O = pVar.O(n1.f44123a, null, function1);
        if (O == null) {
            return false;
        }
        pVar.B(O);
        return true;
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void a() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void b() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void c() {
    }
}
