package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.jvm.internal.impl.descriptors.u1;
import kotlin.reflect.jvm.internal.impl.descriptors.v1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s3.a;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nReflectJavaMember.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReflectJavaMember.kt\norg/jetbrains/kotlin/descriptors/runtime/structure/ReflectJavaMember\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public abstract class y extends u implements j, a0, y3.q {
    @NotNull
    public abstract Member N();

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

    @Override // y3.q
    @NotNull
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public q y() {
        Class<?> declaringClass = N().getDeclaringClass();
        kotlin.jvm.internal.g0.o(declaringClass, "getDeclaringClass(...)");
        return new q(declaringClass);
    }

    @NotNull
    protected final List<y3.b0> O(@NotNull Type[] parameterTypes, @NotNull Annotation[][] parameterAnnotations, boolean z5) {
        String str;
        kotlin.jvm.internal.g0.p(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.g0.p(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List<String> b6 = c.f44991a.b(N());
        int size = b6 != null ? b6.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i6 = 0;
        while (i6 < length) {
            e0 a6 = e0.f45001a.a(parameterTypes[i6]);
            if (b6 != null) {
                str = (String) kotlin.collections.f0.b3(b6, i6 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i6 + '+' + size + " (name=" + getName() + " type=" + a6 + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new g0(a6, parameterAnnotations[i6], str, z5 && i6 == kotlin.collections.n.Oe(parameterTypes)));
            i6++;
        }
        return arrayList;
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

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof y) && kotlin.jvm.internal.g0.g(N(), ((y) obj).N());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j, y3.d
    @NotNull
    public List<g> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<g> b6;
        AnnotatedElement element = getElement();
        return (element == null || (declaredAnnotations = element.getDeclaredAnnotations()) == null || (b6 = k.b(declaredAnnotations)) == null) ? kotlin.collections.f0.J() : b6;
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + N();
    }

    @Override // y3.s
    public boolean L() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.j
    @NotNull
    public AnnotatedElement getElement() {
        Member N = N();
        kotlin.jvm.internal.g0.n(N, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) N;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.a0
    public int getModifiers() {
        return N().getModifiers();
    }

    @Override // y3.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f h6;
        String name = N().getName();
        if (name != null && (h6 = kotlin.reflect.jvm.internal.impl.name.f.h(name)) != null) {
            return h6;
        }
        return kotlin.reflect.jvm.internal.impl.name.h.f46356b;
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

    public int hashCode() {
        return N().hashCode();
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
