package okhttp3;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.text.Regex;
import kotlin.text.u;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Cookie {

    @NotNull
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;

    @NotNull
    private final String name;

    @NotNull
    private final String path;
    private final boolean persistent;

    @Nullable
    private final String sameSite;
    private final boolean secure;

    @NotNull
    private final String value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,727:1\n1#2:728\n*E\n"})
    public static final class Builder {

        @Nullable
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;

        @Nullable
        private String name;

        @NotNull
        private String path;
        private boolean persistent;

        @Nullable
        private String sameSite;
        private boolean secure;

        @Nullable
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = "/";
        }

        @NotNull
        public final Builder domain(@NotNull String domain) {
            g0.p(domain, "domain");
            return domain(domain, false);
        }

        @NotNull
        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        @NotNull
        public final Builder secure() {
            this.secure = true;
            return this;
        }

        private final Builder domain(String str, boolean z5) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z5;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        @NotNull
        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j6 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j6, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        @NotNull
        public final Builder expiresAt(long j6) {
            if (j6 <= 0) {
                j6 = Long.MIN_VALUE;
            }
            if (j6 > DateFormattingKt.MAX_DATE) {
                j6 = 253402300799999L;
            }
            this.expiresAt = j6;
            this.persistent = true;
            return this;
        }

        @NotNull
        public final Builder hostOnlyDomain(@NotNull String domain) {
            g0.p(domain, "domain");
            return domain(domain, true);
        }

        @NotNull
        public final Builder name(@NotNull String name) {
            g0.p(name, "name");
            if (!g0.g(u.Z5(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        @NotNull
        public final Builder path(@NotNull String path) {
            g0.p(path, "path");
            if (!u.H2(path, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        @NotNull
        public final Builder sameSite(@NotNull String sameSite) {
            g0.p(sameSite, "sameSite");
            if (!g0.g(u.Z5(sameSite).toString(), sameSite)) {
                throw new IllegalArgumentException("sameSite is not trimmed");
            }
            this.sameSite = sameSite;
            return this;
        }

        @NotNull
        public final Builder value(@NotNull String value) {
            g0.p(value, "value");
            if (!g0.g(u.Z5(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull Cookie cookie) {
            this();
            g0.p(cookie, "cookie");
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nCookie.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Companion\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,727:1\n242#2:728\n*S KotlinDebug\n*F\n+ 1 Cookie.kt\nokhttp3/Cookie$Companion\n*L\n723#1:728\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        private final String parseDomain(String str) {
            if (u.Z1(str, ".", false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(u.v4(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i6, int i7, boolean z5) {
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && charAt < ':') || (('a' <= charAt && charAt < '{') || (('A' <= charAt && charAt < '[') || charAt == ':'))) == (!z5)) {
                    return i6;
                }
                i6++;
            }
            return i7;
        }

        private final long parseExpires(String str, int i6, int i7) {
            int dateCharacterOffset = dateCharacterOffset(str, i6, i7, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            while (dateCharacterOffset < i7) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i7, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i9 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String group = matcher.group(1);
                    g0.o(group, "group(...)");
                    i9 = Integer.parseInt(group);
                    String group2 = matcher.group(2);
                    g0.o(group2, "group(...)");
                    i12 = Integer.parseInt(group2);
                    String group3 = matcher.group(3);
                    g0.o(group3, "group(...)");
                    i13 = Integer.parseInt(group3);
                } else if (i10 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String group4 = matcher.group(1);
                    g0.o(group4, "group(...)");
                    i10 = Integer.parseInt(group4);
                } else if (i11 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String group5 = matcher.group(1);
                    g0.o(group5, "group(...)");
                    Locale US = Locale.US;
                    g0.o(US, "US");
                    String lowerCase = group5.toLowerCase(US);
                    g0.o(lowerCase, "toLowerCase(...)");
                    String pattern = Cookie.MONTH_PATTERN.pattern();
                    g0.o(pattern, "pattern(...)");
                    i11 = u.H3(pattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i8 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String group6 = matcher.group(1);
                    g0.o(group6, "group(...)");
                    i8 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i7, false);
            }
            if (70 <= i8 && i8 < 100) {
                i8 += 1900;
            }
            if (i8 >= 0 && i8 < 70) {
                i8 += 2000;
            }
            if (i8 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i11 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i10 || i10 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i9 < 0 || i9 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i12 < 0 || i12 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i13 < 0 || i13 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i8);
            gregorianCalendar.set(2, i11 - 1);
            gregorianCalendar.set(5, i10);
            gregorianCalendar.set(11, i9);
            gregorianCalendar.set(12, i12);
            gregorianCalendar.set(13, i13);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e6) {
                if (new Regex("-?\\d+").matches(str)) {
                    return u.H2(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e6;
            }
        }

        @JvmStatic
        @Nullable
        public final Cookie parse(@NotNull HttpUrl url, @NotNull String setCookie) {
            g0.p(url, "url");
            g0.p(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        @Nullable
        public final Cookie parse$okhttp(long j6, @NotNull HttpUrl url, @NotNull String setCookie) {
            long j7;
            g0.p(url, "url");
            g0.p(setCookie, "setCookie");
            int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, (Object) null);
            Cookie cookie = null;
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = _UtilCommonKt.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
            if (trimSubstring$default.length() == 0 || _UtilCommonKt.indexOfControlOrNonAscii(trimSubstring$default) != -1) {
                return null;
            }
            String trimSubstring = _UtilCommonKt.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
            if (_UtilCommonKt.indexOfControlOrNonAscii(trimSubstring) != -1) {
                return null;
            }
            int i6 = delimiterOffset$default + 1;
            int length = setCookie.length();
            String str = null;
            String str2 = null;
            String str3 = null;
            long j8 = -1;
            boolean z5 = false;
            boolean z6 = true;
            boolean z7 = false;
            long j9 = DateFormattingKt.MAX_DATE;
            boolean z8 = false;
            while (i6 < length) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(setCookie, ';', i6, length);
                int delimiterOffset2 = _UtilCommonKt.delimiterOffset(setCookie, '=', i6, delimiterOffset);
                String trimSubstring2 = _UtilCommonKt.trimSubstring(setCookie, i6, delimiterOffset2);
                String trimSubstring3 = delimiterOffset2 < delimiterOffset ? _UtilCommonKt.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset) : "";
                Cookie cookie2 = cookie;
                if (u.a2(trimSubstring2, "expires", true)) {
                    try {
                        j9 = parseExpires(trimSubstring3, 0, trimSubstring3.length());
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (u.a2(trimSubstring2, "max-age", true)) {
                    j8 = parseMaxAge(trimSubstring3);
                } else {
                    if (u.a2(trimSubstring2, "domain", true)) {
                        str = parseDomain(trimSubstring3);
                        z6 = false;
                    } else if (u.a2(trimSubstring2, "path", true)) {
                        str2 = trimSubstring3;
                    } else if (u.a2(trimSubstring2, "secure", true)) {
                        z8 = true;
                    } else if (u.a2(trimSubstring2, "httponly", true)) {
                        z5 = true;
                    } else if (u.a2(trimSubstring2, "samesite", true)) {
                        str3 = trimSubstring3;
                    }
                    i6 = delimiterOffset + 1;
                    cookie = cookie2;
                }
                z7 = true;
                i6 = delimiterOffset + 1;
                cookie = cookie2;
            }
            Cookie cookie3 = cookie;
            if (j8 == Long.MIN_VALUE) {
                j7 = Long.MIN_VALUE;
            } else if (j8 != -1) {
                long j10 = j6 + (j8 <= 9223372036854775L ? j8 * 1000 : Long.MAX_VALUE);
                j7 = (j10 < j6 || j10 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j10;
            } else {
                j7 = j9;
            }
            String host = url.host();
            if (str == null) {
                str = host;
            } else if (!domainMatch(host, str)) {
                return cookie3;
            }
            if (host.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                return cookie3;
            }
            String str4 = "/";
            if (str2 == null || !u.H2(str2, "/", false, 2, cookie3)) {
                String encodedPath = url.encodedPath();
                int V3 = u.V3(encodedPath, '/', 0, false, 6, null);
                if (V3 != 0) {
                    str4 = encodedPath.substring(0, V3);
                    g0.o(str4, "substring(...)");
                }
                str2 = str4;
            }
            return new Cookie(trimSubstring$default, trimSubstring, j7, str, str2, z8, z5, z7, z6, str3, null);
        }

        @JvmStatic
        @NotNull
        public final List<Cookie> parseAll(@NotNull HttpUrl url, @NotNull Headers headers) {
            g0.p(url, "url");
            g0.p(headers, "headers");
            List<String> values = headers.values("Set-Cookie");
            int size = values.size();
            List<Cookie> list = null;
            ArrayList arrayList = null;
            for (int i6 = 0; i6 < size; i6++) {
                Cookie parse = parse(url, values.get(i6));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                list = Collections.unmodifiableList(arrayList);
                g0.o(list, "unmodifiableList(...)");
            }
            return list == null ? f0.J() : list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (g0.g(str, str2)) {
                return true;
            }
            if (u.Z1(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (g0.g(encodedPath, str)) {
                return true;
            }
            if (u.H2(encodedPath, str, false, 2, null) && (u.Z1(str, "/", false, 2, null) || encodedPath.charAt(str.length()) == '/')) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8, String str5, v vVar) {
        this(str, str2, j6, str3, str4, z5, z6, z7, z8, str5);
    }

    @NotNull
    public String toString() {
        return toString$okhttp(false);
    }

    private Cookie(String str, String str2, long j6, String str3, String str4, boolean z5, boolean z6, boolean z7, boolean z8, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j6;
        this.domain = str3;
        this.path = str4;
        this.secure = z5;
        this.httpOnly = z6;
        this.persistent = z7;
        this.hostOnly = z8;
        this.sameSite = str5;
    }

    @JvmStatic
    @Nullable
    public static final Cookie parse(@NotNull HttpUrl httpUrl, @NotNull String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    @NotNull
    public static final List<Cookie> parseAll(@NotNull HttpUrl httpUrl, @NotNull Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    @JvmName(name = "-deprecated_domain")
    @NotNull
    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m178deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    @JvmName(name = "-deprecated_expiresAt")
    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m179deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    @JvmName(name = "-deprecated_hostOnly")
    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m180deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    @JvmName(name = "-deprecated_httpOnly")
    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m181deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = CommonNetImpl.NAME, imports = {}))
    @JvmName(name = "-deprecated_name")
    @NotNull
    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m182deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    @JvmName(name = "-deprecated_path")
    @NotNull
    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m183deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    @JvmName(name = "-deprecated_persistent")
    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m184deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    @JvmName(name = "-deprecated_secure")
    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m185deprecated_secure() {
        return this.secure;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    @JvmName(name = "-deprecated_value")
    @NotNull
    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m186deprecated_value() {
        return this.value;
    }

    @JvmName(name = "domain")
    @NotNull
    public final String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return g0.g(cookie.name, this.name) && g0.g(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && g0.g(cookie.domain, this.domain) && g0.g(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && g0.g(cookie.sameSite, this.sameSite);
    }

    @JvmName(name = "expiresAt")
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        int hashCode = (((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + androidx.camera.camera2.internal.compat.params.e.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.secure)) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.httpOnly)) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.persistent)) * 31) + kotlin.reflect.jvm.internal.impl.km.f.a(this.hostOnly)) * 31;
        String str = this.sameSite;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @JvmName(name = "hostOnly")
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName(name = "httpOnly")
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(@NotNull HttpUrl url) {
        g0.p(url, "url");
        if ((this.hostOnly ? g0.g(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    @JvmName(name = CommonNetImpl.NAME)
    @NotNull
    public final String name() {
        return this.name;
    }

    @NotNull
    public final Builder newBuilder() {
        return new Builder(this);
    }

    @JvmName(name = "path")
    @NotNull
    public final String path() {
        return this.path;
    }

    @JvmName(name = "persistent")
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName(name = "sameSite")
    @Nullable
    public final String sameSite() {
        return this.sameSite;
    }

    @JvmName(name = "secure")
    public final boolean secure() {
        return this.secure;
    }

    @NotNull
    public final String toString$okhttp(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z5) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        if (this.sameSite != null) {
            sb.append("; samesite=");
            sb.append(this.sameSite);
        }
        String sb2 = sb.toString();
        g0.o(sb2, "toString(...)");
        return sb2;
    }

    @JvmName(name = "value")
    @NotNull
    public final String value() {
        return this.value;
    }
}
