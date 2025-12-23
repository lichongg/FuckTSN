package okhttp3.internal;

import kotlin.jvm.internal.g0;
import kotlin.text.u;
import kotlin.time.DurationUnit;
import kotlin.time.h;
import kotlin.time.j;
import okhttp3.CacheControl;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _CacheControlCommonKt {
    @NotNull
    public static final CacheControl commonBuild(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    @NotNull
    public static final CacheControl commonForceCache(@NotNull CacheControl.Companion companion) {
        g0.p(companion, "<this>");
        CacheControl.Builder onlyIfCached = new CacheControl.Builder().onlyIfCached();
        h.a aVar = h.f48019b;
        return onlyIfCached.m168maxStaleLRDsOJo(j.w(Integer.MAX_VALUE, DurationUnit.SECONDS)).build();
    }

    @NotNull
    public static final CacheControl commonForceNetwork(@NotNull CacheControl.Companion companion) {
        g0.p(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    @NotNull
    public static final CacheControl.Builder commonImmutable(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    @NotNull
    public static final CacheControl.Builder commonNoCache(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    @NotNull
    public static final CacheControl.Builder commonNoStore(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    @NotNull
    public static final CacheControl.Builder commonNoTransform(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    @NotNull
    public static final CacheControl.Builder commonOnlyIfCached(@NotNull CacheControl.Builder builder) {
        g0.p(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00df A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final okhttp3.CacheControl commonParse(@org.jetbrains.annotations.NotNull okhttp3.CacheControl.Companion r30, @org.jetbrains.annotations.NotNull okhttp3.Headers r31) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    @NotNull
    public static final String commonToString(@NotNull CacheControl cacheControl) {
        g0.p(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(cacheControl.maxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(cacheControl.sMaxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(cacheControl.maxStaleSeconds());
            sb.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(cacheControl.minFreshSeconds());
            sb.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        g0.o(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
        String sb2 = sb.toString();
        cacheControl.setHeaderValue$okhttp(sb2);
        return sb2;
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i6 = 0;
        }
        return indexOfElement(str, str2, i6);
    }

    public static final int commonClampToInt(long j6) {
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }

    private static final int indexOfElement(String str, String str2, int i6) {
        int length = str.length();
        while (i6 < length) {
            if (u.k3(str2, str.charAt(i6), false, 2, null)) {
                return i6;
            }
            i6++;
        }
        return str.length();
    }
}
