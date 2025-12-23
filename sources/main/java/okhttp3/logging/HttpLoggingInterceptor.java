package okhttp3.logging;

import java.util.Set;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.enums.a;
import kotlin.enums.c;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.internal.platform.Platform;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public final class HttpLoggingInterceptor implements Interceptor {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private volatile Set<String> headersToRedact;

    @NotNull
    private volatile Level level;

    @NotNull
    private final Logger logger;

    @NotNull
    private volatile Set<String> queryParamsNameToRedact;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Level {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Level[] $VALUES;
        public static final Level NONE = new Level("NONE", 0);
        public static final Level BASIC = new Level("BASIC", 1);
        public static final Level HEADERS = new Level("HEADERS", 2);
        public static final Level BODY = new Level("BODY", 3);

        private static final /* synthetic */ Level[] $values() {
            return new Level[]{NONE, BASIC, HEADERS, BODY};
        }

        static {
            Level[] $values = $values();
            $VALUES = $values;
            $ENTRIES = c.c($values);
        }

        @NotNull
        public static a<Level> getEntries() {
            return $ENTRIES;
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        private Level(String str, int i6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface Logger {

        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;

        @JvmField
        @NotNull
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(@NotNull String str);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(@NotNull String message) {
                    g0.p(message, "message");
                    Platform.log$default(Platform.Companion.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }
    }

    @JvmOverloads
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public HttpLoggingInterceptor(@NotNull Logger logger) {
        g0.p(logger, "logger");
        this.logger = logger;
        this.headersToRedact = u1.k();
        this.queryParamsNameToRedact = u1.k();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || u.a2(str, "identity", true) || u.a2(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i6) {
        String value = this.headersToRedact.contains(headers.name(i6)) ? "██" : headers.value(i6);
        this.logger.log(headers.name(i6) + ": " + value);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    @JvmName(name = "-deprecated_level")
    @NotNull
    /* renamed from: -deprecated_level, reason: not valid java name */
    public final Level m295deprecated_level() {
        return this.level;
    }

    @NotNull
    public final Level getLevel() {
        return this.level;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x010b A[LOOP:0: B:35:0x0109->B:36:0x010b, LOOP_END] */
    @Override // okhttp3.Interceptor
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r23) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.logging.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    @JvmName(name = "level")
    public final void level(@NotNull Level level) {
        g0.p(level, "<set-?>");
        this.level = level;
    }

    public final void redactHeader(@NotNull String name) {
        g0.p(name, "name");
        TreeSet treeSet = new TreeSet(u.g2(t0.f44062a));
        f0.s0(treeSet, this.headersToRedact);
        treeSet.add(name);
        this.headersToRedact = treeSet;
    }

    public final void redactQueryParams(@NotNull String... name) {
        g0.p(name, "name");
        TreeSet treeSet = new TreeSet(u.g2(t0.f44062a));
        f0.s0(treeSet, this.queryParamsNameToRedact);
        f0.u0(treeSet, name);
        this.queryParamsNameToRedact = treeSet;
    }

    @NotNull
    public final String redactUrl$logging_interceptor(@NotNull HttpUrl url) {
        g0.p(url, "url");
        if (this.queryParamsNameToRedact.isEmpty() || url.querySize() == 0) {
            return url.toString();
        }
        HttpUrl.Builder query = url.newBuilder().query(null);
        int querySize = url.querySize();
        for (int i6 = 0; i6 < querySize; i6++) {
            String queryParameterName = url.queryParameterName(i6);
            query.addEncodedQueryParameter(queryParameterName, this.queryParamsNameToRedact.contains(queryParameterName) ? "██" : url.queryParameterValue(i6));
        }
        return query.toString();
    }

    @NotNull
    public final HttpLoggingInterceptor setLevel(@NotNull Level level) {
        g0.p(level, "level");
        this.level = level;
        return this;
    }

    private final boolean bodyIsStreaming(Response response) {
        MediaType contentType = response.body().contentType();
        if (contentType != null && g0.g(contentType.type(), com.baidu.mobads.sdk.internal.a.f10501b) && g0.g(contentType.subtype(), "event-stream")) {
            return true;
        }
        return false;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i6, v vVar) {
        this((i6 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
