package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
final class k1 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, d1> f45799a = new LinkedHashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f45800a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k1 f45801b;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        @SourceDebugExtension({"SMAP\npredefinedEnhancementInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,347:1\n1222#2,2:348\n1252#2,4:350\n1222#2,2:354\n1252#2,4:356\n1563#2:360\n1634#2,3:361\n1563#2:364\n1634#2,3:365\n*S KotlinDebug\n*F\n+ 1 predefinedEnhancementInfo.kt\norg/jetbrains/kotlin/load/java/typeEnhancement/SignatureEnhancementBuilder$ClassEnhancementBuilder$FunctionEnhancementBuilder\n*L\n319#1:348,2\n319#1:350,4\n330#1:354,2\n330#1:356,4\n338#1:360\n338#1:361,3\n339#1:364\n339#1:365,3\n*E\n"})
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.k1$a$a, reason: collision with other inner class name */
        public final class C0890a {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            private final String f45802a;

            /* renamed from: b, reason: collision with root package name */
            @Nullable
            private final String f45803b;

            /* renamed from: c, reason: collision with root package name */
            @NotNull
            private final List<Pair<String, n1>> f45804c;

            /* renamed from: d, reason: collision with root package name */
            @NotNull
            private Pair<String, n1> f45805d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f45806e;

            public C0890a(@NotNull a aVar, @Nullable String functionName, String str) {
                kotlin.jvm.internal.g0.p(functionName, "functionName");
                this.f45806e = aVar;
                this.f45802a = functionName;
                this.f45803b = str;
                this.f45804c = new ArrayList();
                this.f45805d = kotlin.o0.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            @NotNull
            public final Pair<String, d1> a() {
                kotlin.reflect.jvm.internal.impl.load.kotlin.f0 f0Var = kotlin.reflect.jvm.internal.impl.load.kotlin.f0.f45887a;
                String c6 = this.f45806e.c();
                String str = this.f45802a;
                List<Pair<String, n1>> list = this.f45804c;
                ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String m6 = f0Var.m(c6, f0Var.k(str, arrayList, this.f45805d.getFirst()));
                n1 second = this.f45805d.getSecond();
                List<Pair<String, n1>> list2 = this.f45804c;
                ArrayList arrayList2 = new ArrayList(kotlin.collections.f0.d0(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((n1) ((Pair) it2.next()).getSecond());
                }
                return kotlin.o0.a(m6, new d1(second, arrayList2, this.f45803b));
            }

            public final void b(@NotNull String type, @NotNull h... qualifiers) {
                n1 n1Var;
                kotlin.jvm.internal.g0.p(type, "type");
                kotlin.jvm.internal.g0.p(qualifiers, "qualifiers");
                List<Pair<String, n1>> list = this.f45804c;
                if (qualifiers.length == 0) {
                    n1Var = null;
                } else {
                    Iterable<kotlin.collections.a1> Yz = kotlin.collections.n.Yz(qualifiers);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(kotlin.collections.i1.j(kotlin.collections.f0.d0(Yz, 10)), 16));
                    for (kotlin.collections.a1 a1Var : Yz) {
                        linkedHashMap.put(Integer.valueOf(a1Var.e()), (h) a1Var.f());
                    }
                    n1Var = new n1(linkedHashMap);
                }
                list.add(kotlin.o0.a(type, n1Var));
            }

            public final void c(@NotNull String type, @NotNull h... qualifiers) {
                kotlin.jvm.internal.g0.p(type, "type");
                kotlin.jvm.internal.g0.p(qualifiers, "qualifiers");
                Iterable<kotlin.collections.a1> Yz = kotlin.collections.n.Yz(qualifiers);
                LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.t.u(kotlin.collections.i1.j(kotlin.collections.f0.d0(Yz, 10)), 16));
                for (kotlin.collections.a1 a1Var : Yz) {
                    linkedHashMap.put(Integer.valueOf(a1Var.e()), (h) a1Var.f());
                }
                this.f45805d = kotlin.o0.a(type, new n1(linkedHashMap));
            }

            public final void d(@NotNull JvmPrimitiveType type) {
                kotlin.jvm.internal.g0.p(type, "type");
                String desc = type.getDesc();
                kotlin.jvm.internal.g0.o(desc, "getDesc(...)");
                this.f45805d = kotlin.o0.a(desc, null);
            }
        }

        public a(@NotNull k1 k1Var, String className) {
            kotlin.jvm.internal.g0.p(className, "className");
            this.f45801b = k1Var;
            this.f45800a = className;
        }

        public static /* synthetic */ void b(a aVar, String str, String str2, Function1 function1, int i6, Object obj) {
            if ((i6 & 2) != 0) {
                str2 = null;
            }
            aVar.a(str, str2, function1);
        }

        public final void a(@NotNull String name, @Nullable String str, @NotNull Function1<? super C0890a, kotlin.n1> block) {
            kotlin.jvm.internal.g0.p(name, "name");
            kotlin.jvm.internal.g0.p(block, "block");
            Map map = this.f45801b.f45799a;
            C0890a c0890a = new C0890a(this, name, str);
            block.invoke(c0890a);
            Pair<String, d1> a6 = c0890a.a();
            map.put(a6.getFirst(), a6.getSecond());
        }

        @NotNull
        public final String c() {
            return this.f45800a;
        }
    }

    @NotNull
    public final Map<String, d1> b() {
        return this.f45799a;
    }
}
