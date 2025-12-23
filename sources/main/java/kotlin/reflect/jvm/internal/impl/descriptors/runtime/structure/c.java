package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,105:1\n1#2:106\n11228#3:107\n11563#3,3:108\n*S KotlinDebug\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/Java8ParameterNamesLoader\n*L\n100#1:107\n100#1:108,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f44991a = new c();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static a f44992b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        private final Method f44993a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private final Method f44994b;

        @Nullable
        public final Method a() {
            return this.f44994b;
        }

        @Nullable
        public final Method b() {
            return this.f44993a;
        }

        public a(@Nullable Method method, @Nullable Method method2) {
            this.f44993a = method;
            this.f44994b = method2;
        }
    }

    @NotNull
    public final a a(@NotNull Member member) {
        kotlin.jvm.internal.g0.p(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", null), f.j(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    @Nullable
    public final List<String> b(@NotNull Member member) {
        Method a6;
        kotlin.jvm.internal.g0.p(member, "member");
        a aVar = f44992b;
        if (aVar == null) {
            synchronized (this) {
                aVar = f44992b;
                if (aVar == null) {
                    aVar = f44991a.a(member);
                    f44992b = aVar;
                }
            }
        }
        Method b6 = aVar.b();
        if (b6 == null || (a6 = aVar.a()) == null) {
            return null;
        }
        Object invoke = b6.invoke(member, null);
        kotlin.jvm.internal.g0.n(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a6.invoke(obj, null);
            kotlin.jvm.internal.g0.n(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }

    private c() {
    }
}
