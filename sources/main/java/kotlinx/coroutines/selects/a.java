package kotlinx.coroutines.selects;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.u0;
import kotlin.n1;
import kotlinx.coroutines.a1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nOnTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n+ 2 Runnable.kt\nkotlinx/coroutines/RunnableKt\n*L\n1#1,66:1\n17#2:67\n*S KotlinDebug\n*F\n+ 1 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n56#1:67\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private final long f49531a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nRunnable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Runnable.kt\nkotlinx/coroutines/RunnableKt$Runnable$1\n+ 2 OnTimeout.kt\nkotlinx/coroutines/selects/OnTimeout\n*L\n1#1,18:1\n57#2,2:19\n*E\n"})
    /* renamed from: kotlinx.coroutines.selects.a$a, reason: collision with other inner class name */
    public static final class RunnableC0956a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f49532a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f49533b;

        public RunnableC0956a(m mVar, a aVar) {
            this.f49532a = mVar;
            this.f49533b = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f49532a.j(this.f49533b, n1.f44123a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* synthetic */ class b extends FunctionReferenceImpl implements Function3<a, m<?>, Object, n1> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f49534a = new b();

        b() {
            super(3, a.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ n1 invoke(a aVar, m<?> mVar, Object obj) {
            c(aVar, mVar, obj);
            return n1.f44123a;
        }

        public final void c(@NotNull a aVar, @NotNull m<?> mVar, @Nullable Object obj) {
            aVar.d(mVar, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(m<?> mVar, Object obj) {
        if (this.f49531a <= 0) {
            mVar.f(n1.f44123a);
            return;
        }
        RunnableC0956a runnableC0956a = new RunnableC0956a(mVar, this);
        g0.n(mVar, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        kotlin.coroutines.i context = mVar.getContext();
        mVar.h(a1.d(context).m(this.f49531a, runnableC0956a, context));
    }

    @NotNull
    public final e b() {
        b bVar = b.f49534a;
        g0.n(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new f(this, (Function3) u0.q(bVar, 3), null, 4, null);
    }

    public a(long j6) {
        this.f49531a = j6;
    }

    public static /* synthetic */ void c() {
    }
}
