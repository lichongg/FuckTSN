package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f47393a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends g {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final a f47394b = new a();

        private a() {
            super(false, null);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends g {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f47395b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull String error) {
            super(false, null);
            g0.p(error, "error");
            this.f47395b = error;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends g {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f47396b = new c();

        private c() {
            super(true, null);
        }
    }

    public /* synthetic */ g(boolean z5, kotlin.jvm.internal.v vVar) {
        this(z5);
    }

    private g(boolean z5) {
        this.f47393a = z5;
    }

    public final boolean a() {
        return this.f47393a;
    }
}
