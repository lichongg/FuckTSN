package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u1;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s3.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaClass.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,209:1\n183#2,2:210\n1#3:212\n1563#4:213\n1634#4,3:214\n11228#5:217\n11563#5,3:218\n11228#5:221\n11563#5,3:222\n11228#5:225\n11563#5,3:226\n*S KotlinDebug\n*F\n+ 1 ReflectJavaClass.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaClass\n*L\n51#1:210,2\n64#1:213\n64#1:214,3\n118#1:217\n118#1:218,3\n131#1:221\n131#1:222,3\n138#1:225\n138#1:226,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class q extends u implements j, a0, y3.g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f45026a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Member, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f45027a = new a();

        a() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Constructor<?>, t> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f45028a = new b();

        b() {
            super(1, t.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final t invoke(Constructor<?> p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return new t(p02);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<Member, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f45029a = new c();

        c() {
            super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Member p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return Boolean.valueOf(p02.isSynthetic());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<Field, w> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f45030a = new d();

        d() {
            super(1, w.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final w invoke(Field p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return new w(p02);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final /* synthetic */ class e extends FunctionReferenceImpl implements Function1<Method, z> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f45031a = new e();

        e() {
            super(1, z.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final z invoke(Method p02) {
            kotlin.jvm.internal.g0.p(p02, "p0");
            return new z(p02);
        }
    }

    @Override // y3.g
    public boolean B() {
        return false;
    }

    @Override // y3.d
    public /* bridge */ /* synthetic */ y3.a b(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return b(cVar);
    }

    @Override // y3.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // y3.d
    public boolean s() {
        return false;
    }

    @Override // y3.g
    @Nullable
    public LightClassOriginKind w() {
        return null;
    }

    public q(@NotNull Class<?> klass) {
        kotlin.jvm.internal.g0.p(klass, "klass");
        this.f45026a = klass;
    }

    @Override // y3.g
    public boolean A() {
        Boolean e6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f44984a.e(this.f45026a);
        if (e6 != null) {
            return e6.booleanValue();
        }
        return false;
    }

    @Override // y3.g
    public boolean E() {
        return this.f45026a.isEnum();
    }

    @Override // y3.g
    public boolean I() {
        return this.f45026a.isInterface();
    }

    @Override // y3.g
    @NotNull
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<t> f() {
        Constructor<?>[] declaredConstructors = this.f45026a.getDeclaredConstructors();
        kotlin.jvm.internal.g0.o(declaredConstructors, "getDeclaredConstructors(...)");
        return kotlin.sequences.p.I3(kotlin.sequences.p.N1(kotlin.sequences.p.W0(kotlin.collections.n.T5(declaredConstructors), a.f45027a), b.f45028a));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j
    @NotNull
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Class<?> getElement() {
        return this.f45026a;
    }

    @Override // y3.g
    @NotNull
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public List<w> F() {
        Field[] declaredFields = this.f45026a.getDeclaredFields();
        kotlin.jvm.internal.g0.o(declaredFields, "getDeclaredFields(...)");
        return kotlin.sequences.p.I3(kotlin.sequences.p.N1(kotlin.sequences.p.W0(kotlin.collections.n.T5(declaredFields), c.f45029a), d.f45030a));
    }

    @Override // y3.g
    @NotNull
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.name.f> q() {
        Class<?>[] declaredClasses = this.f45026a.getDeclaredClasses();
        kotlin.jvm.internal.g0.o(declaredClasses, "getDeclaredClasses(...)");
        return kotlin.sequences.p.I3(kotlin.sequences.p.S1(kotlin.sequences.p.W0(kotlin.collections.n.T5(declaredClasses), n.f45023a), o.f45024a));
    }

    @Override // y3.g
    @NotNull
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public List<z> r() {
        Method[] declaredMethods = this.f45026a.getDeclaredMethods();
        kotlin.jvm.internal.g0.o(declaredMethods, "getDeclaredMethods(...)");
        return kotlin.sequences.p.I3(kotlin.sequences.p.N1(kotlin.sequences.p.P0(kotlin.collections.n.T5(declaredMethods), new p(this)), e.f45031a));
    }

    @Override // y3.g
    @Nullable
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public q h() {
        Class<?> declaringClass = this.f45026a.getDeclaringClass();
        if (declaringClass != null) {
            return new q(declaringClass);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j, y3.d
    @Nullable
    public g b(kotlin.reflect.jvm.internal.impl.name.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.g0.p(fqName, "fqName");
        AnnotatedElement element = getElement();
        if (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // y3.g
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.c d() {
        return f.e(this.f45026a).a();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof q) && kotlin.jvm.internal.g0.g(this.f45026a, ((q) obj).f45026a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j, y3.d
    @NotNull
    public List<g> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<g> b6;
        AnnotatedElement element = getElement();
        return (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (b6 = k.b(declaredAnnotations)) == null) ? kotlin.collections.f0.J() : b6;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a0
    public int getModifiers() {
        return this.f45026a.getModifiers();
    }

    @Override // y3.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        if (!this.f45026a.isAnonymousClass()) {
            kotlin.reflect.jvm.internal.impl.name.f h6 = kotlin.reflect.jvm.internal.impl.name.f.h(this.f45026a.getSimpleName());
            kotlin.jvm.internal.g0.m(h6);
            return h6;
        }
        String name = this.f45026a.getName();
        kotlin.jvm.internal.g0.o(name, "getName(...)");
        kotlin.reflect.jvm.internal.impl.name.f h7 = kotlin.reflect.jvm.internal.impl.name.f.h(kotlin.text.u.O5(name, ".", null, 2, null));
        kotlin.jvm.internal.g0.m(h7);
        return h7;
    }

    @Override // y3.z
    @NotNull
    public List<f0> getTypeParameters() {
        TypeVariable<Class<?>>[] typeParameters = this.f45026a.getTypeParameters();
        kotlin.jvm.internal.g0.o(typeParameters, "getTypeParameters(...)");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new f0(typeVariable));
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f45026a.hashCode();
    }

    @Override // y3.g
    @NotNull
    public Collection<y3.j> i() {
        Class cls;
        cls = Object.class;
        if (kotlin.jvm.internal.g0.g(this.f45026a, cls)) {
            return kotlin.collections.f0.J();
        }
        s0 s0Var = new s0(2);
        Object genericSuperclass = this.f45026a.getGenericSuperclass();
        s0Var.a(genericSuperclass != null ? genericSuperclass : Object.class);
        s0Var.b(this.f45026a.getGenericInterfaces());
        List Q = kotlin.collections.f0.Q(s0Var.d(new Type[s0Var.c()]));
        ArrayList arrayList = new ArrayList(kotlin.collections.f0.d0(Q, 10));
        Iterator it = Q.iterator();
        while (it.hasNext()) {
            arrayList.add(new s((Type) it.next()));
        }
        return arrayList;
    }

    @Override // y3.g
    public boolean k() {
        return this.f45026a.isAnnotation();
    }

    @Override // y3.g
    public boolean m() {
        Boolean f6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f44984a.f(this.f45026a);
        if (f6 != null) {
            return f6.booleanValue();
        }
        return false;
    }

    @NotNull
    public String toString() {
        return q.class.getName() + ": " + this.f45026a;
    }

    @Override // y3.g
    @NotNull
    public Collection<y3.w> z() {
        Object[] d6 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.b.f44984a.d(this.f45026a);
        if (d6 == null) {
            d6 = new Object[0];
        }
        ArrayList arrayList = new ArrayList(d6.length);
        for (Object obj : d6) {
            arrayList.add(new d0(obj));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M(Class cls) {
        String simpleName = cls.getSimpleName();
        kotlin.jvm.internal.g0.o(simpleName, "getSimpleName(...)");
        if (simpleName.length() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.reflect.jvm.internal.impl.name.f N(Class cls) {
        String simpleName = cls.getSimpleName();
        if (!kotlin.reflect.jvm.internal.impl.name.f.j(simpleName)) {
            simpleName = null;
        }
        if (simpleName == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.name.f.h(simpleName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean O(q qVar, Method method) {
        if (method.isSynthetic()) {
            return false;
        }
        if (!qVar.E()) {
            return true;
        }
        kotlin.jvm.internal.g0.m(method);
        if (qVar.Y(method)) {
            return false;
        }
        return true;
    }

    private final boolean Y(Method method) {
        String name = method.getName();
        if (kotlin.jvm.internal.g0.g(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            kotlin.jvm.internal.g0.o(parameterTypes, "getParameterTypes(...)");
            if (parameterTypes.length == 0) {
                return true;
            }
            return false;
        }
        if (!kotlin.jvm.internal.g0.g(name, "valueOf")) {
            return false;
        }
        return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
    }

    @Override // y3.s
    public boolean L() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // y3.s
    @NotNull
    public v1 getVisibility() {
        int modifiers = getModifiers();
        if (Modifier.isPublic(modifiers)) {
            return u1.h.f45054c;
        }
        if (Modifier.isPrivate(modifiers)) {
            return u1.e.f45051c;
        }
        if (Modifier.isProtected(modifiers)) {
            if (Modifier.isStatic(modifiers)) {
                return a.c.f54600c;
            }
            return a.b.f54599c;
        }
        return a.C1081a.f54598c;
    }

    @Override // y3.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // y3.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }
}
