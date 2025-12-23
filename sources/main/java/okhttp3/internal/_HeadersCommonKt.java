package okhttp3.internal;

import com.snail.antifake.deviceid.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.h;
import kotlin.o0;
import kotlin.text.u;
import okhttp3.Headers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\n-HeadersCommon.kt\nKotlin\n*S Kotlin\n*F\n+ 1 -HeadersCommon.kt\nokhttp3/internal/_HeadersCommonKt\n+ 2 -UtilJvm.kt\nokhttp3/internal/_UtilJvmKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n242#2:208\n37#3,2:209\n1#4:211\n*S KotlinDebug\n*F\n+ 1 -HeadersCommon.kt\nokhttp3/internal/_HeadersCommonKt\n*L\n36#1:208\n136#1:209,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class _HeadersCommonKt {
    private static final String charCode(char c6) {
        String num = Integer.toString(c6, kotlin.text.b.a(16));
        g0.o(num, "toString(...)");
        if (num.length() >= 2) {
            return num;
        }
        return '0' + num;
    }

    @NotNull
    public static final Headers.Builder commonAdd(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        g0.p(builder, "<this>");
        g0.p(name, "name");
        g0.p(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonAddAll(@NotNull Headers.Builder builder, @NotNull Headers headers) {
        g0.p(builder, "<this>");
        g0.p(headers, "headers");
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            commonAddLenient(builder, headers.name(i6), headers.value(i6));
        }
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonAddLenient(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        g0.p(builder, "<this>");
        g0.p(name, "name");
        g0.p(value, "value");
        builder.getNamesAndValues$okhttp().add(name);
        builder.getNamesAndValues$okhttp().add(u.Z5(value).toString());
        return builder;
    }

    @NotNull
    public static final Headers commonBuild(@NotNull Headers.Builder builder) {
        g0.p(builder, "<this>");
        return new Headers((String[]) builder.getNamesAndValues$okhttp().toArray(new String[0]));
    }

    public static final boolean commonEquals(@NotNull Headers headers, @Nullable Object obj) {
        g0.p(headers, "<this>");
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    @Nullable
    public static final String commonGet(@NotNull Headers.Builder builder, @NotNull String name) {
        g0.p(builder, "<this>");
        g0.p(name, "name");
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int c6 = kotlin.internal.c.c(size, 0, -2);
        if (c6 > size) {
            return null;
        }
        while (!u.a2(name, builder.getNamesAndValues$okhttp().get(size), true)) {
            if (size == c6) {
                return null;
            }
            size -= 2;
        }
        return builder.getNamesAndValues$okhttp().get(size + 1);
    }

    public static final int commonHashCode(@NotNull Headers headers) {
        g0.p(headers, "<this>");
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    @Nullable
    public static final String commonHeadersGet(@NotNull String[] namesAndValues, @NotNull String name) {
        g0.p(namesAndValues, "namesAndValues");
        g0.p(name, "name");
        int length = namesAndValues.length - 2;
        int c6 = kotlin.internal.c.c(length, 0, -2);
        if (c6 > length) {
            return null;
        }
        while (!u.a2(name, namesAndValues[length], true)) {
            if (length == c6) {
                return null;
            }
            length -= 2;
        }
        return namesAndValues[length + 1];
    }

    @NotNull
    public static final Headers commonHeadersOf(@NotNull String... inputNamesAndValues) {
        g0.p(inputNamesAndValues, "inputNamesAndValues");
        if (inputNamesAndValues.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = strArr.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            if (strArr[i7] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i7] = u.Z5(inputNamesAndValues[i7]).toString();
        }
        int c6 = kotlin.internal.c.c(0, strArr.length - 1, 2);
        if (c6 >= 0) {
            while (true) {
                String str = strArr[i6];
                String str2 = strArr[i6 + 1];
                headersCheckName(str);
                headersCheckValue(str2, str);
                if (i6 == c6) {
                    break;
                }
                i6 += 2;
            }
        }
        return new Headers(strArr);
    }

    @NotNull
    public static final Iterator<Pair<String, String>> commonIterator(@NotNull Headers headers) {
        g0.p(headers, "<this>");
        int size = headers.size();
        Pair[] pairArr = new Pair[size];
        for (int i6 = 0; i6 < size; i6++) {
            pairArr[i6] = o0.a(headers.name(i6), headers.value(i6));
        }
        return h.a(pairArr);
    }

    @NotNull
    public static final String commonName(@NotNull Headers headers, int i6) {
        g0.p(headers, "<this>");
        String str = (String) n.hf(headers.getNamesAndValues$okhttp(), i6 * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i6 + ']');
    }

    @NotNull
    public static final Headers.Builder commonNewBuilder(@NotNull Headers headers) {
        g0.p(headers, "<this>");
        Headers.Builder builder = new Headers.Builder();
        f0.u0(builder.getNamesAndValues$okhttp(), headers.getNamesAndValues$okhttp());
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonRemoveAll(@NotNull Headers.Builder builder, @NotNull String name) {
        g0.p(builder, "<this>");
        g0.p(name, "name");
        int i6 = 0;
        while (i6 < builder.getNamesAndValues$okhttp().size()) {
            if (u.a2(name, builder.getNamesAndValues$okhttp().get(i6), true)) {
                builder.getNamesAndValues$okhttp().remove(i6);
                builder.getNamesAndValues$okhttp().remove(i6);
                i6 -= 2;
            }
            i6 += 2;
        }
        return builder;
    }

    @NotNull
    public static final Headers.Builder commonSet(@NotNull Headers.Builder builder, @NotNull String name, @NotNull String value) {
        g0.p(builder, "<this>");
        g0.p(name, "name");
        g0.p(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        builder.removeAll(name);
        commonAddLenient(builder, name, value);
        return builder;
    }

    @NotNull
    public static final Headers commonToHeaders(@NotNull Map<String, String> map) {
        g0.p(map, "<this>");
        String[] strArr = new String[map.size() * 2];
        int i6 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String obj = u.Z5(key).toString();
            String obj2 = u.Z5(value).toString();
            headersCheckName(obj);
            headersCheckValue(obj2, obj);
            strArr[i6] = obj;
            strArr[i6 + 1] = obj2;
            i6 += 2;
        }
        return new Headers(strArr);
    }

    @NotNull
    public static final String commonToString(@NotNull Headers headers) {
        g0.p(headers, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i6 = 0; i6 < size; i6++) {
            String name = headers.name(i6);
            String value = headers.value(i6);
            sb.append(name);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append(e.f37542d);
        }
        return sb.toString();
    }

    @NotNull
    public static final String commonValue(@NotNull Headers headers, int i6) {
        g0.p(headers, "<this>");
        String str = (String) n.hf(headers.getNamesAndValues$okhttp(), (i6 * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i6 + ']');
    }

    @NotNull
    public static final List<String> commonValues(@NotNull Headers headers, @NotNull String name) {
        g0.p(headers, "<this>");
        g0.p(name, "name");
        int size = headers.size();
        List<String> list = null;
        ArrayList arrayList = null;
        for (int i6 = 0; i6 < size; i6++) {
            if (u.a2(name, headers.name(i6), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.value(i6));
            }
        }
        if (arrayList != null) {
            list = Collections.unmodifiableList(arrayList);
            g0.o(list, "unmodifiableList(...)");
        }
        return list == null ? f0.J() : list;
    }

    public static final void headersCheckName(@NotNull String name) {
        g0.p(name, "name");
        if (name.length() <= 0) {
            throw new IllegalArgumentException("name is empty");
        }
        int length = name.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = name.charAt(i6);
            if ('!' > charAt || charAt >= 127) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(charAt) + " at " + i6 + " in header name: " + name).toString());
            }
        }
    }

    public static final void headersCheckValue(@NotNull String value, @NotNull String name) {
        g0.p(value, "value");
        g0.p(name, "name");
        int length = value.length();
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = value.charAt(i6);
            if (charAt != '\t' && (' ' > charAt || charAt >= 127)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected char 0x");
                sb.append(charCode(charAt));
                sb.append(" at ");
                sb.append(i6);
                sb.append(" in ");
                sb.append(name);
                sb.append(" value");
                sb.append(_UtilCommonKt.isSensitiveHeader(name) ? "" : ": " + value);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }
}
