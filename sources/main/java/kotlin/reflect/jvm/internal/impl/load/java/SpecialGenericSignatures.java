package kotlin.reflect.jvm.internal.impl.load.java;

import androidx.exifinterface.media.ExifInterface;
import com.acse.ottn.l3;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.i1;
import kotlin.collections.u1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSpecialGenericSignatures.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SignatureBuildingComponents.kt\norg/jetbrains/kotlin/load/kotlin/SignatureBuildingComponentsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,194:1\n1563#2:195\n1634#2,3:196\n1563#2:199\n1634#2,3:200\n1563#2:203\n1634#2,3:204\n1252#2,4:210\n1563#2:214\n1634#2,3:215\n1563#2:218\n1634#2,3:219\n1252#2,4:225\n1634#2,3:232\n1563#2:235\n1634#2,3:236\n1222#2,2:239\n1252#2,4:241\n13#3:207\n13#3:222\n478#4:208\n424#4:209\n478#4:223\n424#4:224\n153#5,3:229\n*S KotlinDebug\n*F\n+ 1 SpecialGenericSignatures.kt\norg/jetbrains/kotlin/load/java/SpecialGenericSignatures\n*L\n57#1:195\n57#1:196,3\n59#1:199\n59#1:200,3\n60#1:203\n60#1:204,3\n98#1:210,4\n104#1:214\n104#1:215,3\n105#1:218\n105#1:219,3\n168#1:225,4\n176#1:232,3\n180#1:235\n180#1:236,3\n181#1:239,2\n181#1:241,4\n63#1:207\n114#1:222\n98#1:208\n98#1:209\n168#1:223\n168#1:224\n172#1:229,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public class SpecialGenericSignatures {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f45335a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<a.C0886a> f45336b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final List<String> f45337c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<String> f45338d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Map<a.C0886a, TypeSafeBarrierDescription> f45339e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<String, TypeSafeBarrierDescription> f45340f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f45341g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Set<String> f45342h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a.C0886a f45343i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final Map<a.C0886a, kotlin.reflect.jvm.internal.impl.name.f> f45344j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Map<String, kotlin.reflect.jvm.internal.impl.name.f> f45345k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Set<String> f45346l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f45347m;

    /* renamed from: n, reason: collision with root package name */
    @NotNull
    private static final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.name.f> f45348n;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class SpecialSignatureInfo {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ SpecialSignatureInfo[] $VALUES;
        private final boolean isObjectReplacedWithTypeParameter;

        @Nullable
        private final String valueParametersSignature;
        public static final SpecialSignatureInfo ONE_COLLECTION_PARAMETER = new SpecialSignatureInfo("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);
        public static final SpecialSignatureInfo OBJECT_PARAMETER_NON_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);
        public static final SpecialSignatureInfo OBJECT_PARAMETER_GENERIC = new SpecialSignatureInfo("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);

        private static final /* synthetic */ SpecialSignatureInfo[] $values() {
            return new SpecialSignatureInfo[]{ONE_COLLECTION_PARAMETER, OBJECT_PARAMETER_NON_GENERIC, OBJECT_PARAMETER_GENERIC};
        }

        static {
            SpecialSignatureInfo[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        public static SpecialSignatureInfo valueOf(String str) {
            return (SpecialSignatureInfo) Enum.valueOf(SpecialSignatureInfo.class, str);
        }

        public static SpecialSignatureInfo[] values() {
            return (SpecialSignatureInfo[]) $VALUES.clone();
        }

        private SpecialSignatureInfo(String str, int i6, String str2, boolean z5) {
            this.valueParametersSignature = str2;
            this.isObjectReplacedWithTypeParameter = z5;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class TypeSafeBarrierDescription {
        private static final /* synthetic */ kotlin.enums.a $ENTRIES;
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;

        @Nullable
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new a("MAP_GET_OR_DEFAULT", 3);

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        static final class a extends TypeSafeBarrierDescription {
            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            a(java.lang.String r2, int r3) {
                /*
                    r1 = this;
                    r0 = 0
                    r1.<init>(r2, r3, r0, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures.TypeSafeBarrierDescription.a.<init>(java.lang.String, int):void");
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i6, Object obj, kotlin.jvm.internal.v vVar) {
            this(str, i6, obj);
        }

        static {
            TypeSafeBarrierDescription[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.c.c($values);
        }

        private TypeSafeBarrierDescription(String str, int i6, Object obj) {
            this.defaultValue = obj;
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a, reason: collision with other inner class name */
        public static final class C0886a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final String f45349a;

            /* renamed from: b, reason: collision with root package name */
            @NotNull
            private final kotlin.reflect.jvm.internal.impl.name.f f45350b;

            /* renamed from: c, reason: collision with root package name */
            @NotNull
            private final String f45351c;

            /* renamed from: d, reason: collision with root package name */
            @NotNull
            private final String f45352d;

            /* renamed from: e, reason: collision with root package name */
            @NotNull
            private final String f45353e;

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0886a)) {
                    return false;
                }
                C0886a c0886a = (C0886a) obj;
                return kotlin.jvm.internal.g0.g(this.f45349a, c0886a.f45349a) && kotlin.jvm.internal.g0.g(this.f45350b, c0886a.f45350b) && kotlin.jvm.internal.g0.g(this.f45351c, c0886a.f45351c) && kotlin.jvm.internal.g0.g(this.f45352d, c0886a.f45352d);
            }

            public C0886a(@NotNull String classInternalName, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull String parameters, @NotNull String returnType) {
                kotlin.jvm.internal.g0.p(classInternalName, "classInternalName");
                kotlin.jvm.internal.g0.p(name, "name");
                kotlin.jvm.internal.g0.p(parameters, "parameters");
                kotlin.jvm.internal.g0.p(returnType, "returnType");
                this.f45349a = classInternalName;
                this.f45350b = name;
                this.f45351c = parameters;
                this.f45352d = returnType;
                this.f45353e = kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a.m(classInternalName, name + '(' + parameters + ')' + returnType);
            }

            public static /* synthetic */ C0886a b(C0886a c0886a, String str, kotlin.reflect.jvm.internal.impl.name.f fVar, String str2, String str3, int i6, Object obj) {
                if ((i6 & 1) != 0) {
                    str = c0886a.f45349a;
                }
                if ((i6 & 2) != 0) {
                    fVar = c0886a.f45350b;
                }
                if ((i6 & 4) != 0) {
                    str2 = c0886a.f45351c;
                }
                if ((i6 & 8) != 0) {
                    str3 = c0886a.f45352d;
                }
                return c0886a.a(str, fVar, str2, str3);
            }

            @NotNull
            public final C0886a a(@NotNull String classInternalName, @NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull String parameters, @NotNull String returnType) {
                kotlin.jvm.internal.g0.p(classInternalName, "classInternalName");
                kotlin.jvm.internal.g0.p(name, "name");
                kotlin.jvm.internal.g0.p(parameters, "parameters");
                kotlin.jvm.internal.g0.p(returnType, "returnType");
                return new C0886a(classInternalName, name, parameters, returnType);
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.name.f c() {
                return this.f45350b;
            }

            @NotNull
            public final String d() {
                return this.f45353e;
            }

            public int hashCode() {
                return (((((this.f45349a.hashCode() * 31) + this.f45350b.hashCode()) * 31) + this.f45351c.hashCode()) * 31) + this.f45352d.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(classInternalName=" + this.f45349a + ", name=" + this.f45350b + ", parameters=" + this.f45351c + ", returnType=" + this.f45352d + ')';
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0886a m(String str, String str2, String str3, String str4) {
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(str2);
            kotlin.jvm.internal.g0.o(h6, "identifier(...)");
            return new C0886a(str, h6, str3, str4);
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.name.f b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.g0.p(name, "name");
            return f().get(name);
        }

        public final boolean k(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.jvm.internal.g0.p(fVar, "<this>");
            return g().contains(fVar);
        }

        @NotNull
        public final SpecialSignatureInfo l(@NotNull String builtinSignature) {
            kotlin.jvm.internal.g0.p(builtinSignature, "builtinSignature");
            return c().contains(builtinSignature) ? SpecialSignatureInfo.ONE_COLLECTION_PARAMETER : ((TypeSafeBarrierDescription) i1.K(i(), builtinSignature)) == TypeSafeBarrierDescription.NULL ? SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC : SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        @NotNull
        public final List<String> c() {
            return SpecialGenericSignatures.f45337c;
        }

        @NotNull
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return SpecialGenericSignatures.f45341g;
        }

        @NotNull
        public final Set<String> e() {
            return SpecialGenericSignatures.f45342h;
        }

        @NotNull
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.name.f> f() {
            return SpecialGenericSignatures.f45348n;
        }

        @NotNull
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            return SpecialGenericSignatures.f45347m;
        }

        @NotNull
        public final C0886a h() {
            return SpecialGenericSignatures.f45343i;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> i() {
            return SpecialGenericSignatures.f45340f;
        }

        @NotNull
        public final Map<String, kotlin.reflect.jvm.internal.impl.name.f> j() {
            return SpecialGenericSignatures.f45345k;
        }
    }

    static {
        Set<String> u5 = u1.u("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(u5, 10));
        for (String str : u5) {
            a aVar = f45335a;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            kotlin.jvm.internal.g0.o(desc, "getDesc(...)");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f45336b = arrayList;
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(kotlin.collections.f0.d0(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((a.C0886a) it.next()).d());
        }
        f45337c = arrayList3;
        List<a.C0886a> list = f45336b;
        ArrayList arrayList4 = new ArrayList(kotlin.collections.f0.d0(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((a.C0886a) it2.next()).c().b());
        }
        f45338d = arrayList4;
        kotlin.reflect.jvm.internal.impl.load.kotlin.f0 f0Var = kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a;
        a aVar2 = f45335a;
        String i6 = f0Var.i("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        kotlin.jvm.internal.g0.o(desc2, "getDesc(...)");
        a.C0886a m6 = aVar2.m(i6, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        Pair a6 = kotlin.o0.a(m6, typeSafeBarrierDescription);
        String i7 = f0Var.i("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        kotlin.jvm.internal.g0.o(desc3, "getDesc(...)");
        Pair a7 = kotlin.o0.a(aVar2.m(i7, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription);
        String i8 = f0Var.i("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        kotlin.jvm.internal.g0.o(desc4, "getDesc(...)");
        Pair a8 = kotlin.o0.a(aVar2.m(i8, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription);
        String i9 = f0Var.i("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        kotlin.jvm.internal.g0.o(desc5, "getDesc(...)");
        Pair a9 = kotlin.o0.a(aVar2.m(i9, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription);
        String i10 = f0Var.i("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        kotlin.jvm.internal.g0.o(desc6, "getDesc(...)");
        Pair a10 = kotlin.o0.a(aVar2.m(i10, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription);
        Pair a11 = kotlin.o0.a(aVar2.m(f0Var.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
        a.C0886a m7 = aVar2.m(f0Var.i("Map"), l3.f4736f, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        Pair a12 = kotlin.o0.a(m7, typeSafeBarrierDescription2);
        Pair a13 = kotlin.o0.a(aVar2.m(f0Var.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2);
        String i11 = f0Var.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        kotlin.jvm.internal.g0.o(desc7, "getDesc(...)");
        a.C0886a m8 = aVar2.m(i11, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        Pair a14 = kotlin.o0.a(m8, typeSafeBarrierDescription3);
        String i12 = f0Var.i("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        kotlin.jvm.internal.g0.o(desc8, "getDesc(...)");
        Map<a.C0886a, TypeSafeBarrierDescription> W = i1.W(a6, a7, a8, a9, a10, a11, a12, a13, a14, kotlin.o0.a(aVar2.m(i12, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        f45339e = W;
        LinkedHashMap linkedHashMap = new LinkedHashMap(i1.j(W.size()));
        Iterator<T> it3 = W.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0886a) entry.getKey()).d(), entry.getValue());
        }
        f45340f = linkedHashMap;
        Set C = u1.C(f45339e.keySet(), f45336b);
        ArrayList arrayList5 = new ArrayList(kotlin.collections.f0.d0(C, 10));
        Iterator it4 = C.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((a.C0886a) it4.next()).c());
        }
        f45341g = kotlin.collections.f0.f6(arrayList5);
        ArrayList arrayList6 = new ArrayList(kotlin.collections.f0.d0(C, 10));
        Iterator it5 = C.iterator();
        while (it5.hasNext()) {
            arrayList6.add(((a.C0886a) it5.next()).d());
        }
        f45342h = kotlin.collections.f0.f6(arrayList6);
        a aVar3 = f45335a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        kotlin.jvm.internal.g0.o(desc9, "getDesc(...)");
        a.C0886a m9 = aVar3.m("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        f45343i = m9;
        kotlin.reflect.jvm.internal.impl.load.kotlin.f0 f0Var2 = kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a;
        String h6 = f0Var2.h("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        kotlin.jvm.internal.g0.o(desc10, "getDesc(...)");
        Pair a15 = kotlin.o0.a(aVar3.m(h6, "toByte", "", desc10), kotlin.reflect.jvm.internal.impl.name.f.h("byteValue"));
        String h7 = f0Var2.h("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        kotlin.jvm.internal.g0.o(desc11, "getDesc(...)");
        Pair a16 = kotlin.o0.a(aVar3.m(h7, "toShort", "", desc11), kotlin.reflect.jvm.internal.impl.name.f.h("shortValue"));
        String h8 = f0Var2.h("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        kotlin.jvm.internal.g0.o(desc12, "getDesc(...)");
        Pair a17 = kotlin.o0.a(aVar3.m(h8, "toInt", "", desc12), kotlin.reflect.jvm.internal.impl.name.f.h("intValue"));
        String h9 = f0Var2.h("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        kotlin.jvm.internal.g0.o(desc13, "getDesc(...)");
        Pair a18 = kotlin.o0.a(aVar3.m(h9, "toLong", "", desc13), kotlin.reflect.jvm.internal.impl.name.f.h("longValue"));
        String h10 = f0Var2.h("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        kotlin.jvm.internal.g0.o(desc14, "getDesc(...)");
        Pair a19 = kotlin.o0.a(aVar3.m(h10, "toFloat", "", desc14), kotlin.reflect.jvm.internal.impl.name.f.h("floatValue"));
        String h11 = f0Var2.h("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        kotlin.jvm.internal.g0.o(desc15, "getDesc(...)");
        Pair a20 = kotlin.o0.a(aVar3.m(h11, "toDouble", "", desc15), kotlin.reflect.jvm.internal.impl.name.f.h("doubleValue"));
        Pair a21 = kotlin.o0.a(m9, kotlin.reflect.jvm.internal.impl.name.f.h("remove"));
        String h12 = f0Var2.h("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        kotlin.jvm.internal.g0.o(desc16, "getDesc(...)");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        kotlin.jvm.internal.g0.o(desc17, "getDesc(...)");
        Map<a.C0886a, kotlin.reflect.jvm.internal.impl.name.f> W2 = i1.W(a15, a16, a17, a18, a19, a20, a21, kotlin.o0.a(aVar3.m(h12, l3.f4736f, desc16, desc17), kotlin.reflect.jvm.internal.impl.name.f.h("charAt")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicInteger"), "load", "", "I"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicInteger"), "store", "I", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicInteger"), "exchange", "I", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicInteger"), "fetchAndAdd", "I", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndAdd")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicInteger"), "addAndFetch", "I", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("addAndGet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLong"), "load", "", "J"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLong"), "store", "J", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLong"), "exchange", "J", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLong"), "fetchAndAdd", "J", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndAdd")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLong"), "addAndFetch", "J", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("addAndGet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicBoolean"), "load", "", "Z"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicBoolean"), "store", "Z", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicBoolean"), "exchange", "Z", "Z"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReference"), "load", "", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReference"), "store", "Ljava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReference"), "exchange", "Ljava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "loadAt", "I", "I"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "storeAt", "II", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "exchangeAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "compareAndSetAt", "III", "Z"), kotlin.reflect.jvm.internal.impl.name.f.h("compareAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "fetchAndAddAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndAdd")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicIntegerArray"), "addAndFetchAt", "II", "I"), kotlin.reflect.jvm.internal.impl.name.f.h("addAndGet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "loadAt", "I", "J"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "storeAt", "IJ", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "exchangeAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "compareAndSetAt", "IJJ", "Z"), kotlin.reflect.jvm.internal.impl.name.f.h("compareAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "fetchAndAddAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndAdd")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicLongArray"), "addAndFetchAt", "IJ", "J"), kotlin.reflect.jvm.internal.impl.name.f.h("addAndGet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReferenceArray"), "loadAt", "I", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4736f)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReferenceArray"), "storeAt", "ILjava/lang/Object;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED), kotlin.reflect.jvm.internal.impl.name.f.h(l3.f4738h)), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReferenceArray"), "exchangeAt", "ILjava/lang/Object;", "Ljava/lang/Object;"), kotlin.reflect.jvm.internal.impl.name.f.h("getAndSet")), kotlin.o0.a(aVar3.m(f0Var2.j("AtomicReferenceArray"), "compareAndSetAt", "ILjava/lang/Object;Ljava/lang/Object;", "Z"), kotlin.reflect.jvm.internal.impl.name.f.h("compareAndSet")));
        f45344j = W2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(i1.j(W2.size()));
        Iterator<T> it6 = W2.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0886a) entry2.getKey()).d(), entry2.getValue());
        }
        f45345k = linkedHashMap2;
        Map<a.C0886a, kotlin.reflect.jvm.internal.impl.name.f> map = f45344j;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<a.C0886a, kotlin.reflect.jvm.internal.impl.name.f> entry3 : map.entrySet()) {
            linkedHashSet.add(a.C0886a.b(entry3.getKey(), null, entry3.getValue(), null, null, 13, null).d());
        }
        f45346l = linkedHashSet;
        Set<a.C0886a> keySet = f45344j.keySet();
        HashSet hashSet = new HashSet();
        Iterator<T> it7 = keySet.iterator();
        while (it7.hasNext()) {
            hashSet.add(((a.C0886a) it7.next()).c());
        }
        f45347m = hashSet;
        Set<Map.Entry<a.C0886a, kotlin.reflect.jvm.internal.impl.name.f>> entrySet = f45344j.entrySet();
        ArrayList<Pair> arrayList7 = new ArrayList(kotlin.collections.f0.d0(entrySet, 10));
        Iterator<T> it8 = entrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C0886a) entry4.getKey()).c(), entry4.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(kotlin.ranges.t.u(i1.j(kotlin.collections.f0.d0(arrayList7, 10)), 16));
        for (Pair pair : arrayList7) {
            linkedHashMap3.put((kotlin.reflect.jvm.internal.impl.name.f) pair.getSecond(), (kotlin.reflect.jvm.internal.impl.name.f) pair.getFirst());
        }
        f45348n = linkedHashMap3;
    }
}
