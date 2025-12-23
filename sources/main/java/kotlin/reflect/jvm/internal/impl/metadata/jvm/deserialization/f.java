package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.a1;
import kotlin.collections.f0;
import kotlin.collections.i1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.ranges.t;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.u;
import kotlin.text.v0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmNameResolverBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1222#2,2:107\n1252#2,4:109\n*S KotlinDebug\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n*L\n101#1:107,2\n101#1:109,4\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class f implements kotlin.reflect.jvm.internal.impl.metadata.deserialization.d {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f46309d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f46310e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<String> f46311f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Map<String, Integer> f46312g;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final String[] f46313a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final Set<Integer> f46314b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> f46315c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46316a;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f46316a = iArr;
        }
    }

    static {
        String r32 = f0.r3(f0.Q('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);
        f46310e = r32;
        List<String> Q = f0.Q(r32 + "/Any", r32 + "/Nothing", r32 + "/Unit", r32 + "/Throwable", r32 + "/Number", r32 + "/Byte", r32 + "/Double", r32 + "/Float", r32 + "/Int", r32 + "/Long", r32 + "/Short", r32 + "/Boolean", r32 + "/Char", r32 + "/CharSequence", r32 + "/String", r32 + "/Comparable", r32 + "/Enum", r32 + "/Array", r32 + "/ByteArray", r32 + "/DoubleArray", r32 + "/FloatArray", r32 + "/IntArray", r32 + "/LongArray", r32 + "/ShortArray", r32 + "/BooleanArray", r32 + "/CharArray", r32 + "/Cloneable", r32 + "/Annotation", r32 + "/collections/Iterable", r32 + "/collections/MutableIterable", r32 + "/collections/Collection", r32 + "/collections/MutableCollection", r32 + "/collections/List", r32 + "/collections/MutableList", r32 + "/collections/Set", r32 + "/collections/MutableSet", r32 + "/collections/Map", r32 + "/collections/MutableMap", r32 + "/collections/Map.Entry", r32 + "/collections/MutableMap.MutableEntry", r32 + "/collections/Iterator", r32 + "/collections/MutableIterator", r32 + "/collections/ListIterator", r32 + "/collections/MutableListIterator");
        f46311f = Q;
        Iterable<a1> m6 = f0.m6(Q);
        LinkedHashMap linkedHashMap = new LinkedHashMap(t.u(i1.j(f0.d0(m6, 10)), 16));
        for (a1 a1Var : m6) {
            linkedHashMap.put((String) a1Var.f(), Integer.valueOf(a1Var.e()));
        }
        f46312g = linkedHashMap;
    }

    public f(@NotNull String[] strings, @NotNull Set<Integer> localNameIndices, @NotNull List<JvmProtoBuf.StringTableTypes.Record> records) {
        g0.p(strings, "strings");
        g0.p(localNameIndices, "localNameIndices");
        g0.p(records, "records");
        this.f46313a = strings;
        this.f46314b = localNameIndices;
        this.f46315c = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    public boolean b(int i6) {
        return this.f46314b.contains(Integer.valueOf(i6));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    @NotNull
    public String getString(int i6) {
        String str;
        JvmProtoBuf.StringTableTypes.Record record = this.f46315c.get(i6);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = f46311f;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex < size) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.f46313a[i6];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            g0.m(substringIndexList);
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= str.length()) {
                g0.m(str);
                g0.m(num);
                int intValue = num.intValue();
                g0.m(num2);
                str = str.substring(intValue, num2.intValue());
                g0.o(str, "substring(...)");
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            g0.m(replaceCharList);
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            g0.m(str2);
            str2 = u.w2(str2, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i7 = b.f46316a[operation.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                g0.m(str3);
                str3 = u.w2(str3, v0.f47959c, '.', false, 4, null);
            } else {
                if (i7 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (str3.length() >= 2) {
                    g0.m(str3);
                    str3 = str3.substring(1, str3.length() - 1);
                    g0.o(str3, "substring(...)");
                }
                String str4 = str3;
                g0.m(str4);
                str3 = u.w2(str4, v0.f47959c, '.', false, 4, null);
            }
        }
        g0.m(str3);
        return str3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.d
    @NotNull
    public String a(int i6) {
        return getString(i6);
    }
}
