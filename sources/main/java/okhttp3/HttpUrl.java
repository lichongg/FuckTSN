package okhttp3;

import com.acse.ottn.l3;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.google.android.gms.actions.SearchIntents;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.collections.f0;
import kotlin.collections.u1;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.k;
import kotlin.ranges.t;
import kotlin.text.Regex;
import kotlin.text.u;
import kotlin.text.v0;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHttpUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,1810:1\n246#2:1811\n242#2:1812\n*S KotlinDebug\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl\n*L\n624#1:1811\n648#1:1812\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class HttpUrl {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final String fragment;

    @NotNull
    private final String host;

    @NotNull
    private final String password;

    @NotNull
    private final List<String> pathSegments;
    private final int port;

    @Nullable
    private final List<String> queryNamesAndValues;

    @NotNull
    private final String scheme;

    @NotNull
    private final String url;

    @NotNull
    private final String username;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHttpUrl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1810:1\n1#2:1811\n1563#3:1812\n1634#3,3:1813\n1563#3:1816\n1634#3,3:1817\n*S KotlinDebug\n*F\n+ 1 HttpUrl.kt\nokhttp3/HttpUrl$Builder\n*L\n1265#1:1812\n1265#1:1813,3\n1266#1:1816\n1266#1:1817,3\n*E\n"})
    public static final class Builder {

        @Nullable
        private String encodedFragment;

        @Nullable
        private List<String> encodedQueryNamesAndValues;

        @Nullable
        private String host;

        @Nullable
        private String scheme;

        @NotNull
        private String encodedUsername = "";

        @NotNull
        private String encodedPassword = "";
        private int port = -1;

        @NotNull
        private final List<String> encodedPathSegments = f0.U("");

        private final int parsePort(String str, int i6, int i7) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(_UrlKt.canonicalize$default(str, i6, i7, "", false, false, false, false, 120, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > parseInt || parseInt >= 65536) {
                return -1;
            }
            return parseInt;
        }

        private final int slashCount(String str, int i6, int i7) {
            int i8 = 0;
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (charAt != '/' && charAt != '\\') {
                    break;
                }
                i8++;
                i6++;
            }
            return i8;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String pathSegments) {
            g0.p(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @NotNull
        public final Builder port(int i6) {
            if (1 <= i6 && i6 < 65536) {
                this.port = i6;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i6).toString());
        }

        private final Builder addPathSegments(String str, boolean z5) {
            int i6 = 0;
            while (true) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i6, str.length());
                String str2 = str;
                boolean z6 = z5;
                push(str2, i6, delimiterOffset, delimiterOffset < str.length(), z6);
                i6 = delimiterOffset + 1;
                if (i6 > str2.length()) {
                    return this;
                }
                str = str2;
                z5 = z6;
            }
        }

        private final int effectivePort() {
            int i6 = this.port;
            if (i6 != -1) {
                return i6;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            g0.m(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return g0.g(str, ".") || u.a2(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return g0.g(str, "..") || u.a2(str, "%2e.", true) || u.a2(str, ".%2e", true) || u.a2(str, "%2e%2e", true);
        }

        private final void pop() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r0.size() - 1, "");
            }
        }

        private final int portColonOffset(String str, int i6, int i7) {
            while (i6 < i7) {
                char charAt = str.charAt(i6);
                if (charAt == ':') {
                    return i6;
                }
                if (charAt == '[') {
                    do {
                        i6++;
                        if (i6 < i7) {
                        }
                    } while (str.charAt(i6) != ']');
                }
                i6++;
            }
            return i7;
        }

        private final void push(String str, int i6, int i7, boolean z5, boolean z6) {
            String canonicalize$default = _UrlKt.canonicalize$default(str, i6, i7, _UrlKt.PATH_SEGMENT_ENCODE_SET, z6, false, false, false, 112, null);
            if (isDot(canonicalize$default)) {
                return;
            }
            if (isDotDot(canonicalize$default)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(r12.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r12.size() - 1, canonicalize$default);
            } else {
                this.encodedPathSegments.add(canonicalize$default);
            }
            if (z5) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            g0.m(list);
            int size = list.size() - 2;
            int c6 = kotlin.internal.c.c(size, 0, -2);
            if (c6 > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                g0.m(list2);
                if (g0.g(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    g0.m(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    g0.m(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    g0.m(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == c6) {
                    return;
                } else {
                    size -= 2;
                }
            }
        }

        private final void resolvePath(String str, int i6, int i7) {
            if (i6 == i7) {
                return;
            }
            char charAt = str.charAt(i6);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i6++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i8 = i6;
            while (i8 < i7) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i8, i7);
                boolean z5 = delimiterOffset < i7;
                String str2 = str;
                push(str2, i8, delimiterOffset, z5, true);
                if (z5) {
                    i8 = delimiterOffset + 1;
                    str = str2;
                } else {
                    str = str2;
                    i8 = delimiterOffset;
                }
            }
        }

        private final int schemeDelimiterOffset(String str, int i6, int i7) {
            if (i7 - i6 < 2) {
                return -1;
            }
            char charAt = str.charAt(i6);
            if ((g0.t(charAt, 97) >= 0 && g0.t(charAt, 122) <= 0) || (g0.t(charAt, 65) >= 0 && g0.t(charAt, 90) <= 0)) {
                while (true) {
                    i6++;
                    if (i6 >= i7) {
                        break;
                    }
                    char charAt2 = str.charAt(i6);
                    if ('a' > charAt2 || charAt2 >= '{') {
                        if ('A' > charAt2 || charAt2 >= '[') {
                            if ('0' > charAt2 || charAt2 >= ':') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i6;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private final List<String> toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 <= str.length()) {
                String str2 = str;
                int G3 = u.G3(str2, v0.f47960d, i6, false, 4, null);
                if (G3 == -1) {
                    G3 = str2.length();
                }
                int G32 = u.G3(str2, '=', i6, false, 4, null);
                if (G32 == -1 || G32 > G3) {
                    String substring = str2.substring(i6, G3);
                    g0.o(substring, "substring(...)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = str2.substring(i6, G32);
                    g0.o(substring2, "substring(...)");
                    arrayList.add(substring2);
                    String substring3 = str2.substring(G32 + 1, G3);
                    g0.o(substring3, "substring(...)");
                    arrayList.add(substring3);
                }
                i6 = G3 + 1;
                str = str2;
            }
            return arrayList;
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String encodedPathSegment) {
            g0.p(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String encodedPathSegments) {
            g0.p(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String encodedName, @Nullable String str) {
            g0.p(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            g0.m(list);
            list.add(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            g0.m(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String pathSegment) {
            g0.p(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String name, @Nullable String str) {
            g0.p(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            g0.m(list);
            list.add(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            g0.m(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String percentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(f0.d0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(_UrlKt.percentDecode$default((String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                ArrayList arrayList3 = new ArrayList(f0.d0(list3, 10));
                for (String str3 : list3) {
                    arrayList3.add(str3 != null ? _UrlKt.percentDecode$default(str3, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$default, percentDecode$default2, str2, effectivePort, arrayList2, arrayList, str4 != null ? _UrlKt.percentDecode$default(str4, 0, 0, false, 7, null) : null, toString(), null);
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", true, false, false, true, 51, null) : null;
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String encodedPassword) {
            g0.p(encodedPassword, "encodedPassword");
            this.encodedPassword = _UrlKt.canonicalize$default(encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String encodedPath) {
            g0.p(encodedPath, "encodedPath");
            if (u.H2(encodedPath, "/", false, 2, null)) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String encodedUsername) {
            g0.p(encodedUsername, "encodedUsername");
            this.encodedUsername = _UrlKt.canonicalize$default(encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        @NotNull
        public final Builder fragment(@Nullable String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", false, false, false, true, 59, null) : null;
            return this;
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String host) {
            g0.p(host, "host");
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl httpUrl, @NotNull String str) {
            int delimiterOffset;
            int i6;
            int i7;
            char c6;
            String input = str;
            g0.p(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int schemeDelimiterOffset = schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            if (schemeDelimiterOffset != -1) {
                if (u.E2(input, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = master.flame.danmaku.danmaku.parser.b.f50155b;
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!u.E2(input, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input.substring(0, schemeDelimiterOffset);
                        g0.o(substring, "substring(...)");
                        sb.append(substring);
                        sb.append('\'');
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.scheme = master.flame.danmaku.danmaku.parser.b.f50154a;
                    indexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    if (input.length() > 6) {
                        input = u.y9(input, 6) + "...";
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + input);
                }
                this.scheme = httpUrl.scheme();
            }
            int slashCount = slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c7 = '?';
            char c8 = '#';
            if (slashCount >= 2 || httpUrl == null || !g0.g(httpUrl.scheme(), this.scheme)) {
                int i8 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z5 = false;
                boolean z6 = false;
                while (true) {
                    delimiterOffset = _UtilCommonKt.delimiterOffset(input, "@/\\?#", i8, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c8 || charAt == '/' || charAt == '\\' || charAt == c7) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z5) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(this.encodedPassword);
                            sb2.append("%40");
                            input = str;
                            i6 = delimiterOffset;
                            sb2.append(_UrlKt.canonicalize$default(input, i8, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                            this.encodedPassword = sb2.toString();
                        } else {
                            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(input, ':', i8, delimiterOffset);
                            String canonicalize$default = _UrlKt.canonicalize$default(input, i8, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            if (z6) {
                                canonicalize$default = this.encodedUsername + "%40" + canonicalize$default;
                            }
                            this.encodedUsername = canonicalize$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i7 = delimiterOffset;
                                this.encodedPassword = _UrlKt.canonicalize$default(str, delimiterOffset2 + 1, i7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                z5 = true;
                            } else {
                                i7 = delimiterOffset;
                            }
                            input = str;
                            i6 = i7;
                            z6 = true;
                        }
                        i8 = i6 + 1;
                        c8 = '#';
                        c7 = '?';
                    }
                }
                int portColonOffset = portColonOffset(input, i8, delimiterOffset);
                int i9 = portColonOffset + 1;
                if (i9 < delimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i8, portColonOffset, false, 4, null));
                    int parsePort = parsePort(input, i9, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Invalid URL port: \"");
                        String substring2 = input.substring(i9, delimiterOffset);
                        g0.o(substring2, "substring(...)");
                        sb3.append(substring2);
                        sb3.append('\"');
                        throw new IllegalArgumentException(sb3.toString().toString());
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i8, portColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str2 = this.scheme;
                    g0.m(str2);
                    this.port = companion.defaultPort(str2);
                }
                if (this.host == null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Invalid URL host: \"");
                    String substring3 = input.substring(i8, portColonOffset);
                    g0.o(substring3, "substring(...)");
                    sb4.append(substring3);
                    sb4.append('\"');
                    throw new IllegalArgumentException(sb4.toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = _UtilCommonKt.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 >= indexOfLastNonAsciiWhitespace$default || input.charAt(delimiterOffset3) != '?') {
                c6 = '#';
            } else {
                c6 = '#';
                int delimiterOffset4 = _UtilCommonKt.delimiterOffset(input, '#', delimiterOffset3, indexOfLastNonAsciiWhitespace$default);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(input, delimiterOffset3 + 1, delimiterOffset4, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < indexOfLastNonAsciiWhitespace$default && input.charAt(delimiterOffset3) == c6) {
                this.encodedFragment = _UrlKt.canonicalize$default(input, delimiterOffset3 + 1, indexOfLastNonAsciiWhitespace$default, "", true, false, false, true, 48, null);
            }
            return this;
        }

        @NotNull
        public final Builder password(@NotNull String password) {
            g0.p(password, "password");
            this.encodedPassword = _UrlKt.canonicalize$default(password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        @NotNull
        public final Builder query(@Nullable String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i6 = 0; i6 < size; i6++) {
                List<String> list = this.encodedPathSegments;
                list.set(i6, _UrlKt.canonicalize$default(list.get(i6), 0, 0, "[]", true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i7 = 0; i7 < size2; i7++) {
                    String str2 = list2.get(i7);
                    list2.set(i7, str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String encodedName) {
            g0.p(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String name) {
            g0.p(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int i6) {
            this.encodedPathSegments.remove(i6);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @NotNull
        public final Builder scheme(@NotNull String scheme) {
            g0.p(scheme, "scheme");
            if (u.a2(scheme, master.flame.danmaku.danmaku.parser.b.f50154a, true)) {
                this.scheme = master.flame.danmaku.danmaku.parser.b.f50154a;
                return this;
            }
            if (u.a2(scheme, master.flame.danmaku.danmaku.parser.b.f50155b, true)) {
                this.scheme = master.flame.danmaku.danmaku.parser.b.f50155b;
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + scheme);
        }

        public final void setEncodedFragment$okhttp(@Nullable String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@NotNull String str) {
            g0.p(str, "<set-?>");
            this.encodedPassword = str;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int i6, @NotNull String encodedPathSegment) {
            g0.p(encodedPathSegment, "encodedPathSegment");
            String canonicalize$default = _UrlKt.canonicalize$default(encodedPathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, 115, null);
            this.encodedPathSegments.set(i6, canonicalize$default);
            if (!isDot(canonicalize$default) && !isDotDot(canonicalize$default)) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String encodedName, @Nullable String str) {
            g0.p(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String str) {
            g0.p(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@Nullable String str) {
            this.host = str;
        }

        @NotNull
        public final Builder setPathSegment(int i6, @NotNull String pathSegment) {
            g0.p(pathSegment, "pathSegment");
            String canonicalize$default = _UrlKt.canonicalize$default(pathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, 123, null);
            if (!isDot(canonicalize$default) && !isDotDot(canonicalize$default)) {
                this.encodedPathSegments.set(i6, canonicalize$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i6) {
            this.port = i6;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String name, @Nullable String str) {
            g0.p(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0083, code lost:
        
            if (r1 != r4.defaultPort(r3)) goto L29;
         */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L22
                goto L2a
            L22:
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L44
            L2a:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L3f
                r0.append(r2)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L3f:
                r1 = 64
                r0.append(r1)
            L44:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L69
                kotlin.jvm.internal.g0.m(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = kotlin.text.u.k3(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L64
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L69
            L64:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L69:
                int r1 = r6.port
                r3 = -1
                if (r1 != r3) goto L72
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L8b
            L72:
                int r1 = r6.effectivePort()
                java.lang.String r3 = r6.scheme
                if (r3 == 0) goto L85
                okhttp3.HttpUrl$Companion r4 = okhttp3.HttpUrl.Companion
                kotlin.jvm.internal.g0.m(r3)
                int r3 = r4.defaultPort(r3)
                if (r1 == r3) goto L8b
            L85:
                r0.append(r2)
                r0.append(r1)
            L8b:
                java.util.List<java.lang.String> r1 = r6.encodedPathSegments
                r6.toPathString(r1, r0)
                java.util.List<java.lang.String> r1 = r6.encodedQueryNamesAndValues
                if (r1 == 0) goto La3
                r1 = 63
                r0.append(r1)
                okhttp3.HttpUrl$Companion r1 = okhttp3.HttpUrl.Companion
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.g0.m(r2)
                okhttp3.HttpUrl.Companion.access$toQueryString(r1, r2, r0)
            La3:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lb1
                r1 = 35
                r0.append(r1)
                java.lang.String r1 = r6.encodedFragment
                r0.append(r1)
            Lb1:
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.HttpUrl.Builder.toString():java.lang.String");
        }

        @NotNull
        public final Builder username(@NotNull String username) {
            g0.p(username, "username");
            this.encodedUsername = _UrlKt.canonicalize$default(username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        private final void toPathString(List<String> list, StringBuilder sb) {
            int size = list.size();
            for (int i6 = 0; i6 < size; i6++) {
                sb.append('/');
                sb.append(list.get(i6));
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toQueryString(List<String> list, StringBuilder sb) {
            k B1 = t.B1(t.W1(0, list.size()), 2);
            int e6 = B1.e();
            int f6 = B1.f();
            int g6 = B1.g();
            if ((g6 <= 0 || e6 > f6) && (g6 >= 0 || f6 > e6)) {
                return;
            }
            while (true) {
                String str = list.get(e6);
                String str2 = list.get(e6 + 1);
                if (e6 > 0) {
                    sb.append(v0.f47960d);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (e6 == f6) {
                    return;
                } else {
                    e6 += g6;
                }
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m218deprecated_get(@NotNull String url) {
            g0.p(url, "url");
            return get(url);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @NotNull
        public final HttpUrl get(@NotNull String str) {
            g0.p(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m220deprecated_get(@NotNull URL url) {
            g0.p(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m221deprecated_parse(@NotNull String url) {
            g0.p(url, "url");
            return parse(url);
        }

        @JvmStatic
        public final int defaultPort(@NotNull String scheme) {
            g0.p(scheme, "scheme");
            if (g0.g(scheme, master.flame.danmaku.danmaku.parser.b.f50154a)) {
                return 80;
            }
            return g0.g(scheme, master.flame.danmaku.danmaku.parser.b.f50155b) ? 443 : -1;
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @Nullable
        public final HttpUrl get(@NotNull URL url) {
            g0.p(url, "<this>");
            String url2 = url.toString();
            g0.o(url2, "toString(...)");
            return parse(url2);
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final HttpUrl parse(@NotNull String str) {
            g0.p(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m219deprecated_get(@NotNull URI uri) {
            g0.p(uri, "uri");
            return get(uri);
        }

        @JvmStatic
        @JvmName(name = l3.f4736f)
        @Nullable
        public final HttpUrl get(@NotNull URI uri) {
            g0.p(uri, "<this>");
            String uri2 = uri.toString();
            g0.o(uri2, "toString(...)");
            return parse(uri2);
        }
    }

    public /* synthetic */ HttpUrl(String str, String str2, String str3, String str4, int i6, List list, List list2, String str5, String str6, v vVar) {
        this(str, str2, str3, str4, i6, list, list2, str5, str6);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @NotNull
    public static final HttpUrl get(@NotNull String str) {
        return Companion.get(str);
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    private HttpUrl(String str, String str2, String str3, String str4, int i6, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i6;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }

    @JvmStatic
    public static final int defaultPort(@NotNull String str) {
        return Companion.defaultPort(str);
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @Nullable
    public static final HttpUrl get(@NotNull URI uri) {
        return Companion.get(uri);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final HttpUrl parse(@NotNull String str) {
        return Companion.parse(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    @JvmName(name = "-deprecated_fragment")
    @Nullable
    /* renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m205deprecated_fragment() {
        return this.fragment;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    @JvmName(name = "-deprecated_host")
    @NotNull
    /* renamed from: -deprecated_host, reason: not valid java name */
    public final String m206deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))
    @JvmName(name = "-deprecated_password")
    @NotNull
    /* renamed from: -deprecated_password, reason: not valid java name */
    public final String m207deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    @JvmName(name = "-deprecated_pathSegments")
    @NotNull
    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m208deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    @JvmName(name = "-deprecated_port")
    /* renamed from: -deprecated_port, reason: not valid java name */
    public final int m210deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m214deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    @JvmName(name = "-deprecated_username")
    @NotNull
    /* renamed from: -deprecated_username, reason: not valid java name */
    public final String m217deprecated_username() {
        return this.username;
    }

    @JvmName(name = "encodedFragment")
    @Nullable
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(u.G3(this.url, '#', 0, false, 6, null) + 1);
        g0.o(substring, "substring(...)");
        return substring;
    }

    @JvmName(name = "encodedPassword")
    @NotNull
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        String substring = this.url.substring(u.G3(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, u.G3(this.url, '@', 0, false, 6, null));
        g0.o(substring, "substring(...)");
        return substring;
    }

    @JvmName(name = "encodedPath")
    @NotNull
    public final String encodedPath() {
        int G3 = u.G3(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String substring = this.url.substring(G3, _UtilCommonKt.delimiterOffset(str, "?#", G3, str.length()));
        g0.o(substring, "substring(...)");
        return substring;
    }

    @JvmName(name = "encodedPathSegments")
    @NotNull
    public final List<String> encodedPathSegments() {
        int G3 = u.G3(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", G3, str.length());
        ArrayList arrayList = new ArrayList();
        while (G3 < delimiterOffset) {
            int i6 = G3 + 1;
            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(this.url, '/', i6, delimiterOffset);
            String substring = this.url.substring(i6, delimiterOffset2);
            g0.o(substring, "substring(...)");
            arrayList.add(substring);
            G3 = delimiterOffset2;
        }
        return arrayList;
    }

    @JvmName(name = "encodedQuery")
    @Nullable
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int G3 = u.G3(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        String substring = this.url.substring(G3, _UtilCommonKt.delimiterOffset(str, '#', G3, str.length()));
        g0.o(substring, "substring(...)");
        return substring;
    }

    @JvmName(name = "encodedUsername")
    @NotNull
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
        g0.o(substring, "substring(...)");
        return substring;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof HttpUrl) && g0.g(((HttpUrl) obj).url, this.url);
    }

    @JvmName(name = "fragment")
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @JvmName(name = "host")
    @NotNull
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return g0.g(this.scheme, master.flame.danmaku.danmaku.parser.b.f50155b);
    }

    @JvmName(name = "password")
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName(name = "pathSegments")
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName(name = "port")
    public final int port() {
        return this.port;
    }

    @JvmName(name = SearchIntents.EXTRA_QUERY)
    @Nullable
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String name) {
        g0.p(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        k B1 = t.B1(t.W1(0, list.size()), 2);
        int e6 = B1.e();
        int f6 = B1.f();
        int g6 = B1.g();
        if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
            while (!g0.g(name, this.queryNamesAndValues.get(e6))) {
                if (e6 != f6) {
                    e6 += g6;
                }
            }
            return this.queryNamesAndValues.get(e6 + 1);
        }
        return null;
    }

    @NotNull
    public final String queryParameterName(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i6 * 2);
        g0.m(str);
        return str;
    }

    @JvmName(name = "queryParameterNames")
    @NotNull
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return u1.k();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        k B1 = t.B1(t.W1(0, this.queryNamesAndValues.size()), 2);
        int e6 = B1.e();
        int f6 = B1.f();
        int g6 = B1.g();
        if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
            while (true) {
                String str = this.queryNamesAndValues.get(e6);
                g0.m(str);
                linkedHashSet.add(str);
                if (e6 == f6) {
                    break;
                }
                e6 += g6;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        g0.o(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    @Nullable
    public final String queryParameterValue(int i6) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i6 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String name) {
        g0.p(name, "name");
        if (this.queryNamesAndValues == null) {
            return f0.J();
        }
        ArrayList arrayList = new ArrayList(4);
        k B1 = t.B1(t.W1(0, this.queryNamesAndValues.size()), 2);
        int e6 = B1.e();
        int f6 = B1.f();
        int g6 = B1.g();
        if ((g6 > 0 && e6 <= f6) || (g6 < 0 && f6 <= e6)) {
            while (true) {
                if (g0.g(name, this.queryNamesAndValues.get(e6))) {
                    arrayList.add(this.queryNamesAndValues.get(e6 + 1));
                }
                if (e6 == f6) {
                    break;
                }
                e6 += g6;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        g0.o(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    @JvmName(name = "querySize")
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @NotNull
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        g0.m(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String link) {
        g0.p(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @JvmName(name = "url")
    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e6) {
            throw new RuntimeException(e6);
        }
    }

    @JvmName(name = "username")
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmStatic
    @JvmName(name = l3.f4736f)
    @Nullable
    public static final HttpUrl get(@NotNull URL url) {
        return Companion.get(url);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    @JvmName(name = "-deprecated_encodedFragment")
    @Nullable
    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m199deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    @JvmName(name = "-deprecated_encodedPassword")
    @NotNull
    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m200deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    @JvmName(name = "-deprecated_encodedPath")
    @NotNull
    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m201deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    @JvmName(name = "-deprecated_encodedPathSegments")
    @NotNull
    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m202deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    @JvmName(name = "-deprecated_encodedQuery")
    @Nullable
    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m203deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    @JvmName(name = "-deprecated_encodedUsername")
    @NotNull
    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m204deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    @JvmName(name = "-deprecated_pathSize")
    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m209deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SearchIntents.EXTRA_QUERY, imports = {}))
    @JvmName(name = "-deprecated_query")
    @Nullable
    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m211deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    @JvmName(name = "-deprecated_queryParameterNames")
    @NotNull
    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m212deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    @JvmName(name = "-deprecated_querySize")
    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m213deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    @JvmName(name = "-deprecated_uri")
    @NotNull
    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m215deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m216deprecated_url() {
        return url();
    }

    @JvmName(name = ContentProviderManager.PROVIDER_URI)
    @NotNull
    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e6) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                g0.m(create);
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e6);
            }
        }
    }

    @Nullable
    public final Builder newBuilder(@NotNull String link) {
        g0.p(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
