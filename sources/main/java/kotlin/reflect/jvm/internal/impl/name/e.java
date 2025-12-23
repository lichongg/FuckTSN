package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nFqNamesUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n536#2:87\n521#2,6:88\n1#3:94\n*S KotlinDebug\n*F\n+ 1 FqNamesUtil.kt\norg/jetbrains/kotlin/name/FqNamesUtilKt\n*L\n73#1:87\n73#1:88,6\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e {
    private static final boolean c(String str, String str2) {
        return u.H2(str, str2, false, 2, null) && str.charAt(str2.length()) == '.';
    }

    public static final boolean e(@Nullable String str) {
        if (str == null) {
            return false;
        }
        k kVar = k.f46429a;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char charAt = str.charAt(i6);
            int i7 = a.f46349a[kVar.ordinal()];
            if (i7 == 1 || i7 == 2) {
                if (!Character.isJavaIdentifierStart(charAt)) {
                    return false;
                }
                kVar = k.f46430b;
            } else {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (charAt == '.') {
                    kVar = k.f46431c;
                } else if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
            }
        }
        return kVar != k.f46431c;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46349a;

        static {
            int[] iArr = new int[k.values().length];
            try {
                iArr[k.f46429a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[k.f46431c.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[k.f46430b.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f46349a = iArr;
        }
    }

    @Nullable
    public static final <V> V a(@NotNull c cVar, @NotNull Map<c, ? extends V> values) {
        Object next;
        g0.p(cVar, "<this>");
        g0.p(values, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<c, ? extends V> entry : values.entrySet()) {
            c key = entry.getKey();
            if (g0.g(cVar, key) || b(cVar, key)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (linkedHashMap.isEmpty()) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int length = g((c) ((Map.Entry) next).getKey(), cVar).a().length();
                do {
                    Object next2 = it.next();
                    int length2 = g((c) ((Map.Entry) next2).getKey(), cVar).a().length();
                    if (length > length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry2 = (Map.Entry) next;
        if (entry2 != null) {
            return (V) entry2.getValue();
        }
        return null;
    }

    public static final boolean b(@NotNull c cVar, @NotNull c packageName) {
        g0.p(cVar, "<this>");
        g0.p(packageName, "packageName");
        return g0.g(f(cVar), packageName);
    }

    public static final boolean d(@NotNull c cVar, @NotNull c packageName) {
        g0.p(cVar, "<this>");
        g0.p(packageName, "packageName");
        if (g0.g(cVar, packageName) || packageName.c()) {
            return true;
        }
        return c(cVar.a(), packageName.a());
    }

    @Nullable
    public static final c f(@NotNull c cVar) {
        g0.p(cVar, "<this>");
        if (cVar.c()) {
            return null;
        }
        return cVar.d();
    }

    @NotNull
    public static final c g(@NotNull c cVar, @NotNull c prefix) {
        g0.p(cVar, "<this>");
        g0.p(prefix, "prefix");
        if (!d(cVar, prefix) || prefix.c()) {
            return cVar;
        }
        if (g0.g(cVar, prefix)) {
            return c.f46339d;
        }
        String substring = cVar.a().substring(prefix.a().length() + 1);
        g0.o(substring, "substring(...)");
        return new c(substring);
    }
}
