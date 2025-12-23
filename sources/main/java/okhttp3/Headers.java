package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import kotlin.text.u;
import okhttp3.internal._HeadersCommonKt;
import okhttp3.internal.http.DateFormattingKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n*L\n1#1,359:1\n246#2:360\n*S KotlinDebug\n*F\n+ 1 Headers.kt\nokhttp3/Headers\n*L\n110#1:360\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, m3.a {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmField
    @NotNull
    public static final Headers EMPTY = new Headers(new String[0]);

    @NotNull
    private final String[] namesAndValues;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nHeaders.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Headers.kt\nokhttp3/Headers$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,359:1\n1#2:360\n*E\n"})
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final Builder add(@NotNull String line) {
            g0.p(line, "line");
            int G3 = u.G3(line, ':', 0, false, 6, null);
            if (G3 == -1) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String substring = line.substring(0, G3);
            g0.o(substring, "substring(...)");
            String obj = u.Z5(substring).toString();
            String substring2 = line.substring(G3 + 1);
            g0.o(substring2, "substring(...)");
            add(obj, substring2);
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            g0.p(line, "line");
            int G3 = u.G3(line, ':', 1, false, 4, null);
            if (G3 != -1) {
                String substring = line.substring(0, G3);
                g0.o(substring, "substring(...)");
                String substring2 = line.substring(G3 + 1);
                g0.o(substring2, "substring(...)");
                addLenient$okhttp(substring, substring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                addLenient$okhttp("", line);
                return this;
            }
            String substring3 = line.substring(1);
            g0.o(substring3, "substring(...)");
            addLenient$okhttp("", substring3);
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            g0.p(name, "name");
            g0.p(value, "value");
            return set(name, DateFormattingKt.toHttpDateString(value));
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            g0.p(headers, "headers");
            return _HeadersCommonKt.commonAddAll(this, headers);
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            _HeadersCommonKt.headersCheckName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @Nullable
        public final String get(@NotNull String name) {
            g0.p(name, "name");
            return _HeadersCommonKt.commonGet(this, name);
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            g0.p(name, "name");
            return _HeadersCommonKt.commonRemoveAll(this, name);
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            Date from;
            g0.p(name, "name");
            g0.p(value, "value");
            from = Date.from(value);
            g0.o(from, "from(...)");
            return set(name, from);
        }

        @NotNull
        public final Headers build() {
            return _HeadersCommonKt.commonBuild(this);
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            return _HeadersCommonKt.commonSet(this, name, value);
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            return _HeadersCommonKt.commonAdd(this, name, value);
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            g0.p(name, "name");
            g0.p(value, "value");
            return add(name, DateFormattingKt.toHttpDateString(value));
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            Date from;
            g0.p(name, "name");
            g0.p(value, "value");
            from = Date.from(value);
            g0.o(from, "from(...)");
            return add(name, from);
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            g0.p(name, "name");
            g0.p(value, "value");
            return _HeadersCommonKt.commonAddLenient(this, name, value);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class Companion {
        public /* synthetic */ Companion(v vVar) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m198deprecated_of(@NotNull String... namesAndValues) {
            g0.p(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull String... namesAndValues) {
            g0.p(namesAndValues, "namesAndValues");
            return _HeadersCommonKt.commonHeadersOf((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m197deprecated_of(@NotNull Map<String, String> headers) {
            g0.p(headers, "headers");
            return of(headers);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final Headers of(@NotNull Map<String, String> map) {
            g0.p(map, "<this>");
            return _HeadersCommonKt.commonToHeaders(map);
        }
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull Map<String, String> map) {
        return Companion.of(map);
    }

    public Headers(@NotNull String[] namesAndValues) {
        g0.p(namesAndValues, "namesAndValues");
        this.namesAndValues = namesAndValues;
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final Headers of(@NotNull String... strArr) {
        return Companion.of(strArr);
    }

    public final long byteCount() {
        String[] strArr = this.namesAndValues;
        long length = strArr.length * 2;
        for (int i6 = 0; i6 < strArr.length; i6++) {
            length += this.namesAndValues[i6].length();
        }
        return length;
    }

    @Nullable
    public final String get(@NotNull String name) {
        g0.p(name, "name");
        return _HeadersCommonKt.commonHeadersGet(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        g0.p(name, "name");
        String str = get(name);
        if (str != null) {
            return DateFormattingKt.toHttpDateOrNull(str);
        }
        return null;
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        Instant instant;
        g0.p(name, "name");
        Date date = getDate(name);
        if (date == null) {
            return null;
        }
        instant = date.toInstant();
        return instant;
    }

    @NotNull
    public final String[] getNamesAndValues$okhttp() {
        return this.namesAndValues;
    }

    @NotNull
    public final Set<String> names() {
        TreeSet treeSet = new TreeSet(u.g2(t0.f44062a));
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            treeSet.add(name(i6));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(treeSet);
        g0.o(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    @JvmName(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap treeMap = new TreeMap(u.g2(t0.f44062a));
        int size = size();
        for (int i6 = 0; i6 < size; i6++) {
            String name = name(i6);
            Locale US = Locale.US;
            g0.o(US, "US");
            String lowerCase = name.toLowerCase(US);
            g0.o(lowerCase, "toLowerCase(...)");
            List list = (List) treeMap.get(lowerCase);
            if (list == null) {
                list = new ArrayList(2);
                treeMap.put(lowerCase, list);
            }
            list.add(value(i6));
        }
        return treeMap;
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        g0.p(name, "name");
        return _HeadersCommonKt.commonValues(this, name);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m196deprecated_size() {
        return size();
    }

    public boolean equals(@Nullable Object obj) {
        return _HeadersCommonKt.commonEquals(this, obj);
    }

    public int hashCode() {
        return _HeadersCommonKt.commonHashCode(this);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        return _HeadersCommonKt.commonIterator(this);
    }

    @NotNull
    public final String name(int i6) {
        return _HeadersCommonKt.commonName(this, i6);
    }

    @NotNull
    public final Builder newBuilder() {
        return _HeadersCommonKt.commonNewBuilder(this);
    }

    @NotNull
    public String toString() {
        return _HeadersCommonKt.commonToString(this);
    }

    @NotNull
    public final String value(int i6) {
        return _HeadersCommonKt.commonValue(this, i6);
    }
}
