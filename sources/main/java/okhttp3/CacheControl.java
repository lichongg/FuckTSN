package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.time.h;
import okhttp3.internal._CacheControlCommonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class CacheControl {

    @NotNull
    public static final Companion Companion;

    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE;

    @JvmField
    @NotNull
    public static final CacheControl FORCE_NETWORK;

    @Nullable
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCacheControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CacheControl.kt\nokhttp3/CacheControl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,286:1\n1#2:287\n*E\n"})
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public final boolean getImmutable$okhttp() {
            return this.immutable;
        }

        public final int getMaxAgeSeconds$okhttp() {
            return this.maxAgeSeconds;
        }

        public final int getMaxStaleSeconds$okhttp() {
            return this.maxStaleSeconds;
        }

        public final int getMinFreshSeconds$okhttp() {
            return this.minFreshSeconds;
        }

        public final boolean getNoCache$okhttp() {
            return this.noCache;
        }

        public final boolean getNoStore$okhttp() {
            return this.noStore;
        }

        public final boolean getNoTransform$okhttp() {
            return this.noTransform;
        }

        public final boolean getOnlyIfCached$okhttp() {
            return this.onlyIfCached;
        }

        @NotNull
        public final Builder maxAge(int i6, @NotNull TimeUnit timeUnit) {
            g0.p(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + i6).toString());
        }

        @NotNull
        public final Builder maxStale(int i6, @NotNull TimeUnit timeUnit) {
            g0.p(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i6).toString());
        }

        @NotNull
        public final Builder minFresh(int i6, @NotNull TimeUnit timeUnit) {
            g0.p(timeUnit, "timeUnit");
            if (i6 >= 0) {
                this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(timeUnit.toSeconds(i6));
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + i6).toString());
        }

        public final void setImmutable$okhttp(boolean z5) {
            this.immutable = z5;
        }

        public final void setMaxAgeSeconds$okhttp(int i6) {
            this.maxAgeSeconds = i6;
        }

        public final void setMaxStaleSeconds$okhttp(int i6) {
            this.maxStaleSeconds = i6;
        }

        public final void setMinFreshSeconds$okhttp(int i6) {
            this.minFreshSeconds = i6;
        }

        public final void setNoCache$okhttp(boolean z5) {
            this.noCache = z5;
        }

        public final void setNoStore$okhttp(boolean z5) {
            this.noStore = z5;
        }

        public final void setNoTransform$okhttp(boolean z5) {
            this.noTransform = z5;
        }

        public final void setOnlyIfCached$okhttp(boolean z5) {
            this.onlyIfCached = z5;
        }

        @NotNull
        public final CacheControl build() {
            return _CacheControlCommonKt.commonBuild(this);
        }

        @NotNull
        public final Builder immutable() {
            return _CacheControlCommonKt.commonImmutable(this);
        }

        @NotNull
        /* renamed from: maxAge-LRDsOJo, reason: not valid java name */
        public final Builder m167maxAgeLRDsOJo(long j6) {
            long C = h.C(j6);
            if (C >= 0) {
                this.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(C);
                return this;
            }
            throw new IllegalArgumentException(("maxAge < 0: " + C).toString());
        }

        @NotNull
        /* renamed from: maxStale-LRDsOJo, reason: not valid java name */
        public final Builder m168maxStaleLRDsOJo(long j6) {
            long C = h.C(j6);
            if (C >= 0) {
                this.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(C);
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + C).toString());
        }

        @NotNull
        /* renamed from: minFresh-LRDsOJo, reason: not valid java name */
        public final Builder m169minFreshLRDsOJo(long j6) {
            long C = h.C(j6);
            if (C >= 0) {
                this.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(C);
                return this;
            }
            throw new IllegalArgumentException(("minFresh < 0: " + C).toString());
        }

        @NotNull
        public final Builder noCache() {
            return _CacheControlCommonKt.commonNoCache(this);
        }

        @NotNull
        public final Builder noStore() {
            return _CacheControlCommonKt.commonNoStore(this);
        }

        @NotNull
        public final Builder noTransform() {
            return _CacheControlCommonKt.commonNoTransform(this);
        }

        @NotNull
        public final Builder onlyIfCached() {
            return _CacheControlCommonKt.commonOnlyIfCached(this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final CacheControl parse(@NotNull Headers headers) {
            g0.p(headers, "headers");
            return _CacheControlCommonKt.commonParse(this, headers);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        FORCE_NETWORK = _CacheControlCommonKt.commonForceNetwork(companion);
        FORCE_CACHE = _CacheControlCommonKt.commonForceCache(companion);
    }

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return Companion.parse(headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))
    @JvmName(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable, reason: not valid java name */
    public final boolean m157deprecated_immutable() {
        return this.immutable;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds, reason: not valid java name */
    public final int m158deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))
    @JvmName(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds, reason: not valid java name */
    public final int m159deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))
    @JvmName(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds, reason: not valid java name */
    public final int m160deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))
    @JvmName(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate, reason: not valid java name */
    public final boolean m161deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))
    @JvmName(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache, reason: not valid java name */
    public final boolean m162deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))
    @JvmName(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore, reason: not valid java name */
    public final boolean m163deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))
    @JvmName(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform, reason: not valid java name */
    public final boolean m164deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))
    @JvmName(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached, reason: not valid java name */
    public final boolean m165deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))
    @JvmName(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds, reason: not valid java name */
    public final int m166deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Nullable
    public final String getHeaderValue$okhttp() {
        return this.headerValue;
    }

    @JvmName(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final void setHeaderValue$okhttp(@Nullable String str) {
        this.headerValue = str;
    }

    public CacheControl(boolean z5, boolean z6, int i6, int i7, boolean z7, boolean z8, boolean z9, int i8, int i9, boolean z10, boolean z11, boolean z12, @Nullable String str) {
        this.noCache = z5;
        this.noStore = z6;
        this.maxAgeSeconds = i6;
        this.sMaxAgeSeconds = i7;
        this.isPrivate = z7;
        this.isPublic = z8;
        this.mustRevalidate = z9;
        this.maxStaleSeconds = i8;
        this.minFreshSeconds = i9;
        this.onlyIfCached = z10;
        this.noTransform = z11;
        this.immutable = z12;
        this.headerValue = str;
    }

    @NotNull
    public String toString() {
        return _CacheControlCommonKt.commonToString(this);
    }
}
