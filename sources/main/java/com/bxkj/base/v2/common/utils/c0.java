package com.bxkj.base.v2.common.utils;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJsonGet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonGet.kt\ncom/bxkj/base/v2/common/utils/JsonGet\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,575:1\n11561#2:576\n11896#2,3:577\n37#3,2:580\n1#4:582\n*S KotlinDebug\n*F\n+ 1 JsonGet.kt\ncom/bxkj/base/v2/common/utils/JsonGet\n*L\n60#1:576\n60#1:577,3\n60#1:580,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c0 f16887a = new c0();

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nJsonGet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonGet.kt\ncom/bxkj/base/v2/common/utils/JsonGet$jsonToObject$1\n*L\n1#1,575:1\n*E\n"})
    public static final class d<T> extends TypeToken<T> {
    }

    private final void a(StringBuilder sb, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append('\t');
        }
    }

    public final boolean d(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return e(map, str, false);
    }

    public final float i(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return j(map, str, 0.0f);
    }

    public final int k(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return l(map, str, 0);
    }

    public final boolean w(@Nullable String str) {
        return str == null || kotlin.jvm.internal.g0.g(str, "") || kotlin.text.u.a2(str, "null", true);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a extends TypeToken<List<? extends List<? extends Map<String, ? extends Object>>>> {
        a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b extends TypeToken<List<? extends Map<String, ? extends Object>>> {
        b() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c extends TypeToken<Map<String, ? extends Object>> {
        c() {
        }
    }

    @NotNull
    public final Map<String, Object> A(@Nullable String str) {
        Object fromJson = new Gson().fromJson(str, new c().getType());
        kotlin.jvm.internal.g0.o(fromJson, "fromJson(...)");
        return (Map) fromJson;
    }

    public final /* synthetic */ <T> T B(String str) {
        try {
            Gson gson = new Gson();
            kotlin.jvm.internal.g0.w();
            return (T) gson.fromJson(str, new d().getType());
        } catch (Exception unused) {
            return null;
        }
    }

    public final /* synthetic */ <T> T C(Object... params) {
        kotlin.jvm.internal.g0.p(params, "params");
        kotlin.jvm.internal.g0.y(4, ExifInterface.GPS_DIRECTION_TRUE);
        ArrayList arrayList = new ArrayList(params.length);
        for (Object obj : params) {
            arrayList.add(obj.getClass());
        }
        Class[] clsArr = (Class[]) arrayList.toArray(new Class[0]);
        Constructor declaredConstructor = Object.class.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
        declaredConstructor.setAccessible(true);
        T t5 = (T) declaredConstructor.newInstance(Arrays.copyOf(params, params.length));
        kotlin.jvm.internal.g0.o(t5, "newInstance(...)");
        return t5;
    }

    @NotNull
    public final String b(@Nullable String str) {
        if (str == null || kotlin.jvm.internal.g0.g("", str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i6 = 0;
        char c6 = 0;
        int i7 = 0;
        while (i6 < length) {
            char charAt = str.charAt(i6);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    sb.append('\n');
                    i7--;
                    a(sb, i7);
                    sb.append(charAt);
                }
                sb.append(charAt);
                sb.append('\n');
                i7++;
                a(sb, i7);
            } else {
                sb.append(charAt);
                if (c6 != '\\') {
                    sb.append('\n');
                    a(sb, i7);
                }
            }
            i6++;
            c6 = charAt;
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.g0.o(sb2, "toString(...)");
        return sb2;
    }

    @NotNull
    public final String c(double d6) {
        String format = new DecimalFormat("0.00").format(d6);
        kotlin.jvm.internal.g0.o(format, "format(...)");
        return format;
    }

    public final double f(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return g(map, str, 0.0d);
    }

    @NotNull
    public final List<Double> h(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty() && !w(str) && map.containsKey(str) && (obj = map.get(str)) != null) {
            if (obj instanceof List) {
                return (List) obj;
            }
            if (obj instanceof double[]) {
                return kotlin.collections.n.Zy((double[]) obj);
            }
            if (obj instanceof String) {
                Object fromJson = new Gson().fromJson(((String) obj).toString(), (Class<Object>) double[].class);
                kotlin.jvm.internal.g0.o(fromJson, "fromJson(...)");
                return kotlin.collections.n.Zy((double[]) fromJson);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Integer> m(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty() && !w(str) && map.containsKey(str) && (obj = map.get(str)) != null) {
            if (obj instanceof List) {
                return (List) obj;
            }
            if (obj instanceof int[]) {
                return kotlin.collections.n.bz((int[]) obj);
            }
            if (obj instanceof String) {
                Object fromJson = new Gson().fromJson(((String) obj).toString(), (Class<Object>) int[].class);
                kotlin.jvm.internal.g0.o(fromJson, "fromJson(...)");
                return kotlin.collections.n.bz((int[]) fromJson);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Map<String, Object>> n(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        return (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? new ArrayList() : (List) obj;
    }

    public final long o(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return p(map, str, 0L);
    }

    @NotNull
    public final Map<String, Object> q(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        return (map == null || map.size() == 0 || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Map)) ? new HashMap() : (Map) obj;
    }

    @NotNull
    public final List<Map<String, Object>> s(@Nullable Map<String, Object> map, @Nullable String str) {
        Object obj;
        return (map == null || map.isEmpty() || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !u0.F(obj)) ? new ArrayList() : u0.g(obj);
    }

    @NotNull
    public final String t(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        return u(map, str, "");
    }

    @NotNull
    public final String u(@Nullable Map<String, ? extends Object> map, @Nullable String str, @NotNull String defaultValue) {
        kotlin.jvm.internal.g0.p(defaultValue, "defaultValue");
        if (map != null && !map.isEmpty() && !w(str) && map.containsKey(str)) {
            Object obj = map.get(str);
            if (obj == null) {
                return "";
            }
            String obj2 = obj.toString();
            if (obj instanceof Float) {
                Number number = (Number) obj;
                if (number.floatValue() == ((long) number.floatValue())) {
                    obj2 = String.valueOf((long) number.floatValue());
                }
            } else if (obj instanceof Double) {
                Number number2 = (Number) obj;
                if (number2.doubleValue() == ((long) number2.doubleValue())) {
                    obj2 = String.valueOf((long) number2.doubleValue());
                }
            } else if (obj instanceof BigDecimal) {
                BigDecimal bigDecimal = (BigDecimal) obj;
                if (bigDecimal.compareTo(new BigDecimal((long) bigDecimal.doubleValue())) == 0) {
                    obj2 = String.valueOf(bigDecimal.longValue());
                }
            }
            if (!w(obj2)) {
                return obj2;
            }
        }
        return defaultValue;
    }

    @NotNull
    public final List<String> v(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Object obj;
        return (map == null || map.size() == 0 || w(str) || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof List)) ? new ArrayList() : (List) obj;
    }

    public final boolean x(@Nullable String str) {
        return str == null || kotlin.jvm.internal.g0.g(str, "");
    }

    @NotNull
    public final List<List<Map<String, Object>>> y(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new a().getType());
        kotlin.jvm.internal.g0.o(fromJson, "fromJson(...)");
        return (List) fromJson;
    }

    @NotNull
    public final List<Map<String, Object>> z(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        Object fromJson = new Gson().fromJson(str, new b().getType());
        kotlin.jvm.internal.g0.o(fromJson, "fromJson(...)");
        return (List) fromJson;
    }

    private c0() {
    }

    public final boolean e(@Nullable Map<String, ? extends Object> map, @Nullable String str, boolean z5) {
        try {
            return Boolean.parseBoolean(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return z5;
        }
    }

    public final double g(@Nullable Map<String, ? extends Object> map, @Nullable String str, double d6) {
        try {
            return Double.parseDouble(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return d6;
        }
    }

    public final float j(@Nullable Map<String, ? extends Object> map, @Nullable String str, float f6) {
        try {
            return Float.parseFloat(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return 0.0f;
        }
    }

    public final int l(@Nullable Map<String, ? extends Object> map, @Nullable String str, int i6) {
        try {
            return Integer.parseInt(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return i6;
        }
    }

    public final long p(@Nullable Map<String, ? extends Object> map, @Nullable String str, long j6) {
        try {
            return Long.parseLong(t(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return j6;
        }
    }

    @NotNull
    public final String r(@Nullable Map<String, ? extends Object> map, @Nullable String str) {
        try {
            return c(f(map, str));
        } catch (NullPointerException | NumberFormatException | Exception unused) {
            return "0.00";
        }
    }
}
