package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.f0;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f46297a = new b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f46298b = f0.r3(f0.Q('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f46299c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List Q = f0.Q("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int c6 = kotlin.internal.c.c(0, Q.size() - 1, 2);
        if (c6 >= 0) {
            int i6 = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f46298b;
                sb.append(str);
                sb.append('/');
                sb.append((String) Q.get(i6));
                int i7 = i6 + 1;
                linkedHashMap.put(sb.toString(), Q.get(i7));
                linkedHashMap.put(str + '/' + ((String) Q.get(i6)) + "Array", '[' + ((String) Q.get(i7)));
                if (i6 == c6) {
                    break;
                } else {
                    i6 += 2;
                }
            }
        }
        linkedHashMap.put(f46298b + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : f0.Q("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : f0.Q("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i8 = 0; i8 < 23; i8++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f46298b;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i8);
            a(linkedHashMap, "Function" + i8, sb2.toString());
            a(linkedHashMap, "reflect/KFunction" + i8, str4 + "/reflect/KFunction");
        }
        for (String str5 : f0.Q("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", f46298b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f46299c = linkedHashMap;
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(f46298b + '/' + str, 'L' + str2 + ';');
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String classId) {
        g0.p(classId, "classId");
        String str = f46299c.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + u.w2(classId, '.', v0.f47959c, false, 4, null) + ';';
    }

    private b() {
    }
}
