package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.i1;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nChallenge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Challenge.kt\nokhttp3/Challenge\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,124:1\n250#2:125\n*S KotlinDebug\n*F\n+ 1 Challenge.kt\nokhttp3/Challenge\n*L\n68#1:125\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Challenge {

    @NotNull
    private final Map<String, String> authParams;

    @NotNull
    private final String scheme;

    public Challenge(@NotNull String scheme, @NotNull Map<String, String> authParams) {
        String str;
        g0.p(scheme, "scheme");
        g0.p(authParams, "authParams");
        this.scheme = scheme;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : authParams.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale US = Locale.US;
                g0.o(US, "US");
                str = key.toLowerCase(US);
                g0.o(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            linkedHashMap.put(str, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        g0.o(unmodifiableMap, "unmodifiableMap(...)");
        this.authParams = unmodifiableMap;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}))
    @JvmName(name = "-deprecated_authParams")
    @NotNull
    /* renamed from: -deprecated_authParams, reason: not valid java name */
    public final Map<String, String> m170deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m173deprecated_scheme() {
        return this.scheme;
    }

    @JvmName(name = "authParams")
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName(name = "charset")
    @NotNull
    public final Charset charset() {
        String str = this.authParams.get("charset");
        if (str != null) {
            try {
                Charset forName = Charset.forName(str);
                g0.o(forName, "forName(...)");
                return forName;
            } catch (Exception unused) {
            }
        }
        return kotlin.text.e.f47856g;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Challenge)) {
            return false;
        }
        Challenge challenge = (Challenge) obj;
        return g0.g(challenge.scheme, this.scheme) && g0.g(challenge.authParams, this.authParams);
    }

    public int hashCode() {
        return ((899 + this.scheme.hashCode()) * 31) + this.authParams.hashCode();
    }

    @JvmName(name = "realm")
    @Nullable
    public final String realm() {
        return this.authParams.get("realm");
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        g0.p(charset, "charset");
        Map J0 = i1.J0(this.authParams);
        J0.put("charset", charset.name());
        return new Challenge(this.scheme, (Map<String, String>) J0);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}))
    @JvmName(name = "-deprecated_charset")
    @NotNull
    /* renamed from: -deprecated_charset, reason: not valid java name */
    public final Charset m171deprecated_charset() {
        return charset();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}))
    @JvmName(name = "-deprecated_realm")
    @Nullable
    /* renamed from: -deprecated_realm, reason: not valid java name */
    public final String m172deprecated_realm() {
        return realm();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Challenge(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "scheme"
            kotlin.jvm.internal.g0.p(r2, r0)
            java.lang.String r0 = "realm"
            kotlin.jvm.internal.g0.p(r3, r0)
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r0 = "singletonMap(...)"
            kotlin.jvm.internal.g0.o(r3, r0)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }
}
