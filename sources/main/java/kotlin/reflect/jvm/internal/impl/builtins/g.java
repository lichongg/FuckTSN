package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.v;
import kotlin.s;
import kotlin.t;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class g extends j {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f44434i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final s<g> f44435j = t.c(f.f44404a);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final g a() {
            return (g) g.f44435j.getValue();
        }
    }

    public g() {
        this(false, 1, null);
    }

    public g(boolean z5) {
        super(new kotlin.reflect.jvm.internal.impl.storage.f("DefaultBuiltIns"));
        if (z5) {
            f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g G0() {
        return new g(false, 1, null);
    }

    public /* synthetic */ g(boolean z5, int i6, v vVar) {
        this((i6 & 1) != 0 ? true : z5);
    }
}
