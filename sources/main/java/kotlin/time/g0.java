package kotlin.time;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tencent.mmkv.MMKV;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@ExperimentalTime
/* loaded from: D:\Downloads\app\classes8.dex */
final class g0 {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f48011h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f48012a;

    /* renamed from: b, reason: collision with root package name */
    private final int f48013b;

    /* renamed from: c, reason: collision with root package name */
    private final int f48014c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48015d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48016e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48017f;

    /* renamed from: g, reason: collision with root package name */
    private final int f48018g;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @NotNull
        public final g0 a(@NotNull Instant instant) {
            long j6;
            kotlin.jvm.internal.g0.p(instant, "instant");
            long epochSeconds = instant.getEpochSeconds();
            long j7 = epochSeconds / 86400;
            if ((epochSeconds ^ 86400) < 0 && j7 * 86400 != epochSeconds) {
                j7--;
            }
            long j8 = epochSeconds % 86400;
            int i6 = (int) (j8 + (86400 & (((j8 ^ 86400) & ((-j8) | j8)) >> 63)));
            long j9 = (j7 + 719528) - 60;
            if (j9 < 0) {
                long j10 = 146097;
                long j11 = ((j9 + 1) / j10) - 1;
                j6 = 400 * j11;
                j9 += (-j11) * j10;
            } else {
                j6 = 0;
            }
            long j12 = 400;
            long j13 = ((j12 * j9) + 591) / 146097;
            long j14 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME;
            long j15 = 4;
            long j16 = 100;
            long j17 = j9 - ((((j14 * j13) + (j13 / j15)) - (j13 / j16)) + (j13 / j12));
            if (j17 < 0) {
                j13--;
                j17 = j9 - ((((j14 * j13) + (j13 / j15)) - (j13 / j16)) + (j13 / j12));
            }
            int i7 = (int) j17;
            int i8 = ((i7 * 5) + 2) / 153;
            int i9 = i6 / 3600;
            int i10 = i6 - (i9 * 3600);
            int i11 = i10 / 60;
            return new g0((int) (j13 + j6 + (i8 / 10)), ((i8 + 2) % 12) + 1, (i7 - (((i8 * MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY) + 5) / 10)) + 1, i9, i11, i10 - (i11 * 60), instant.getNanosecondsOfSecond());
        }
    }

    public final int a() {
        return this.f48014c;
    }

    public final int b() {
        return this.f48015d;
    }

    public final int c() {
        return this.f48016e;
    }

    public final int d() {
        return this.f48013b;
    }

    public final int e() {
        return this.f48018g;
    }

    public final int f() {
        return this.f48017f;
    }

    public final int g() {
        return this.f48012a;
    }

    public final <T> T h(int i6, @NotNull Function2<? super Long, ? super Integer, ? extends T> buildInstant) {
        kotlin.jvm.internal.g0.p(buildInstant, "buildInstant");
        long g6 = g();
        long j6 = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME * g6;
        long d6 = (g6 >= 0 ? j6 + (((3 + g6) / 4) - ((99 + g6) / 100)) + ((g6 + 399) / 400) : j6 - (((g6 / (-4)) - (g6 / (-100))) + (g6 / (-400)))) + (((d() * MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME) - 362) / 12) + (a() - 1);
        if (d() > 2) {
            d6 = !v.p(g()) ? d6 - 2 : (-1) + d6;
        }
        return buildInstant.invoke(Long.valueOf((((d6 - 719528) * MMKV.ExpireInDay) + (((b() * 3600) + (c() * 60)) + f())) - i6), Integer.valueOf(e()));
    }

    @NotNull
    public String toString() {
        return "UnboundLocalDateTime(" + this.f48012a + '-' + this.f48013b + '-' + this.f48014c + ' ' + this.f48015d + ':' + this.f48016e + ':' + this.f48017f + '.' + this.f48018g + ')';
    }

    public g0(int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f48012a = i6;
        this.f48013b = i7;
        this.f48014c = i8;
        this.f48015d = i9;
        this.f48016e = i10;
        this.f48017f = i11;
        this.f48018g = i12;
    }
}
