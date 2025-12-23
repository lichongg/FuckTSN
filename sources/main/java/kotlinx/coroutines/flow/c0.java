package kotlinx.coroutines.flow;

import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public interface c0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f48851a = a.f48852a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f48852a = new a();

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private static final c0 f48853b = new e0();

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        private static final c0 f48854c = new f0();

        public static /* synthetic */ c0 b(a aVar, long j6, long j7, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                j6 = 0;
            }
            if ((i6 & 2) != 0) {
                j7 = Long.MAX_VALUE;
            }
            return aVar.a(j6, j7);
        }

        @NotNull
        public final c0 a(long j6, long j7) {
            return new g0(j6, j7);
        }

        @NotNull
        public final c0 c() {
            return f48853b;
        }

        @NotNull
        public final c0 d() {
            return f48854c;
        }

        private a() {
        }
    }

    @NotNull
    i<SharingCommand> a(@NotNull h0<Integer> h0Var);
}
