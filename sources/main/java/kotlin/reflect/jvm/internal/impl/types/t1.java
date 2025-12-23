package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,133:1\n105#1,9:134\n105#1,9:143\n105#1,9:152\n774#2:161\n865#2,2:162\n*S KotlinDebug\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes\n*L\n74#1:134,9\n78#1:143,9\n82#1:152,9\n99#1:161\n99#1:162,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class t1 extends kotlin.reflect.jvm.internal.impl.util.e<r1<?>, r1<?>> implements Iterable<r1<?>>, m3.a {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f47332b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final t1 f47333c = new t1((List<? extends r1<?>>) kotlin.collections.f0.J());

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nTypeAttributes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeAttributes.kt\norg/jetbrains/kotlin/types/TypeAttributes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    public static final class a extends kotlin.reflect.jvm.internal.impl.util.z<r1<?>, r1<?>> {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.z
        public int c(@NotNull ConcurrentHashMap<String, Integer> concurrentHashMap, @NotNull String key, @NotNull Function1<? super String, Integer> compute) {
            int intValue;
            kotlin.jvm.internal.g0.p(concurrentHashMap, "<this>");
            kotlin.jvm.internal.g0.p(key, "key");
            kotlin.jvm.internal.g0.p(compute, "compute");
            Integer num = concurrentHashMap.get(key);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                try {
                    Integer num2 = concurrentHashMap.get(key);
                    if (num2 != null) {
                        intValue = num2.intValue();
                    } else {
                        Integer invoke = compute.invoke(key);
                        concurrentHashMap.putIfAbsent(key, Integer.valueOf(invoke.intValue()));
                        intValue = invoke.intValue();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return intValue;
        }

        @NotNull
        public final t1 j(@NotNull List<? extends r1<?>> attributes) {
            kotlin.jvm.internal.g0.p(attributes, "attributes");
            return attributes.isEmpty() ? k() : new t1(attributes, null);
        }

        @NotNull
        public final t1 k() {
            return t1.f47333c;
        }
    }

    public /* synthetic */ t1(List list, kotlin.jvm.internal.v vVar) {
        this((List<? extends r1<?>>) list);
    }

    private t1(List<? extends r1<?>> list) {
        for (r1<?> r1Var : list) {
            f(r1Var.b(), r1Var);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.a
    @NotNull
    protected kotlin.reflect.jvm.internal.impl.util.z<r1<?>, r1<?>> d() {
        return f47332b;
    }

    @NotNull
    public final t1 m(@NotNull t1 other) {
        kotlin.jvm.internal.g0.p(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f47332b.h().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            r1<?> r1Var = a().get(intValue);
            r1<?> r1Var2 = other.a().get(intValue);
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, r1Var == null ? r1Var2 != null ? r1Var2.a(r1Var) : null : r1Var.a(r1Var2));
        }
        return f47332b.j(arrayList);
    }

    public final boolean n(@NotNull r1<?> attribute) {
        kotlin.jvm.internal.g0.p(attribute, "attribute");
        return a().get(f47332b.f(attribute.b())) != null;
    }

    @NotNull
    public final t1 o(@NotNull t1 other) {
        kotlin.jvm.internal.g0.p(other, "other");
        if (isEmpty() && other.isEmpty()) {
            return this;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = f47332b.h().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            r1<?> r1Var = a().get(intValue);
            r1<?> r1Var2 = other.a().get(intValue);
            kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, r1Var == null ? r1Var2 != null ? r1Var2.c(r1Var) : null : r1Var.c(r1Var2));
        }
        return f47332b.j(arrayList);
    }

    @NotNull
    public final t1 p(@NotNull r1<?> attribute) {
        kotlin.jvm.internal.g0.p(attribute, "attribute");
        if (n(attribute)) {
            return this;
        }
        if (isEmpty()) {
            return new t1(attribute);
        }
        return f47332b.j(kotlin.collections.f0.J4(kotlin.collections.f0.a6(this), attribute));
    }

    @NotNull
    public final t1 q(@NotNull r1<?> attribute) {
        kotlin.jvm.internal.g0.p(attribute, "attribute");
        if (!isEmpty()) {
            kotlin.reflect.jvm.internal.impl.util.c<r1<?>> a6 = a();
            ArrayList arrayList = new ArrayList();
            for (r1<?> r1Var : a6) {
                if (!kotlin.jvm.internal.g0.g(r1Var, attribute)) {
                    arrayList.add(r1Var);
                }
            }
            if (arrayList.size() != a().a()) {
                return f47332b.j(arrayList);
            }
        }
        return this;
    }

    private t1(r1<?> r1Var) {
        this((List<? extends r1<?>>) kotlin.collections.f0.l(r1Var));
    }
}
