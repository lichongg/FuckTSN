package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;
import kotlin.ExperimentalStdlibApi;
import kotlin.coroutines.i;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class t1 extends m0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f49659a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @ExperimentalStdlibApi
    public static final class a extends kotlin.coroutines.b<m0, t1> {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlinx.coroutines.t1$a$a, reason: collision with other inner class name */
        static final class C0961a extends Lambda implements Function1<i.b, t1> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0961a f49660a = new C0961a();

            C0961a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final t1 invoke(@NotNull i.b bVar) {
                if (bVar instanceof t1) {
                    return (t1) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
            super(m0.Key, C0961a.f49660a);
        }
    }

    public abstract void close();

    @NotNull
    public abstract Executor t();
}
