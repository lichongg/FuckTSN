package kotlin.time;

import kotlin.time.Instant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalTime
/* loaded from: D:\Downloads\app\classes8.dex */
interface w {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f48050a;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        private final CharSequence f48051b;

        @Override // kotlin.time.w
        @Nullable
        public Instant a() {
            return null;
        }

        public a(@NotNull String error, @NotNull CharSequence input) {
            kotlin.jvm.internal.g0.p(error, "error");
            kotlin.jvm.internal.g0.p(input, "input");
            this.f48050a = error;
            this.f48051b = input;
        }

        @NotNull
        public final String b() {
            return this.f48050a;
        }

        @NotNull
        public final CharSequence c() {
            return this.f48051b;
        }

        @Override // kotlin.time.w
        @NotNull
        public Instant toInstant() {
            String D;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f48050a);
            sb.append(" when parsing an Instant from \"");
            D = v.D(this.f48051b, 64);
            sb.append(D);
            sb.append('\"');
            throw new n(sb.toString());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements w {

        /* renamed from: a, reason: collision with root package name */
        private final long f48052a;

        /* renamed from: b, reason: collision with root package name */
        private final int f48053b;

        @Override // kotlin.time.w
        @Nullable
        public Instant a() {
            long j6 = this.f48052a;
            Instant.a aVar = Instant.Companion;
            if (j6 < aVar.h().getEpochSeconds() || this.f48052a > aVar.g().getEpochSeconds()) {
                return null;
            }
            return aVar.b(this.f48052a, this.f48053b);
        }

        public final long b() {
            return this.f48052a;
        }

        public final int c() {
            return this.f48053b;
        }

        @Override // kotlin.time.w
        @NotNull
        public Instant toInstant() {
            long j6 = this.f48052a;
            Instant.a aVar = Instant.Companion;
            if (j6 >= aVar.h().getEpochSeconds() && this.f48052a <= aVar.g().getEpochSeconds()) {
                return aVar.b(this.f48052a, this.f48053b);
            }
            throw new n("The parsed date is outside the range representable by Instant (Unix epoch second " + this.f48052a + ')');
        }

        public b(long j6, int i6) {
            this.f48052a = j6;
            this.f48053b = i6;
        }
    }

    @Nullable
    Instant a();

    @NotNull
    Instant toInstant();
}
