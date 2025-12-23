package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class TlsVersion {
    private static final /* synthetic */ kotlin.enums.a $ENTRIES;
    private static final /* synthetic */ TlsVersion[] $VALUES;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private final String javaName;
    public static final TlsVersion TLS_1_3 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
    public static final TlsVersion TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
    public static final TlsVersion TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
    public static final TlsVersion TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
    public static final TlsVersion SSL_3_0 = new TlsVersion("SSL_3_0", 4, "SSLv3");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @JvmStatic
        @NotNull
        public final TlsVersion forJavaName(@NotNull String javaName) {
            g0.p(javaName, "javaName");
            int hashCode = javaName.hashCode();
            if (hashCode != 79201641) {
                if (hashCode != 79923350) {
                    switch (hashCode) {
                        case -503070503:
                            if (javaName.equals("TLSv1.1")) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals("TLSv1.2")) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (javaName.equals("TLSv1")) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (javaName.equals("SSLv3")) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException("Unexpected TLS version: " + javaName);
        }
    }

    private static final /* synthetic */ TlsVersion[] $values() {
        return new TlsVersion[]{TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, SSL_3_0};
    }

    static {
        TlsVersion[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.c.c($values);
        Companion = new Companion(null);
    }

    @JvmStatic
    @NotNull
    public static final TlsVersion forJavaName(@NotNull String str) {
        return Companion.forJavaName(str);
    }

    @NotNull
    public static kotlin.enums.a<TlsVersion> getEntries() {
        return $ENTRIES;
    }

    public static TlsVersion valueOf(String str) {
        return (TlsVersion) Enum.valueOf(TlsVersion.class, str);
    }

    public static TlsVersion[] values() {
        return (TlsVersion[]) $VALUES.clone();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))
    @JvmName(name = "-deprecated_javaName")
    @NotNull
    /* renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m287deprecated_javaName() {
        return this.javaName;
    }

    @JvmName(name = "javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    private TlsVersion(String str, int i6, String str2) {
        this.javaName = str2;
    }
}
