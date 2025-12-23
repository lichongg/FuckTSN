package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableBiMap;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList;
import com.bumptech.glide.repackaged.com.google.common.collect.w;
import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import com.bumptech.glide.repackaged.com.squareup.javapoet.i;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Type;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class i {

    /* renamed from: e, reason: collision with root package name */
    private static final String f14600e = com.bumptech.glide.annotation.compiler.d.class.getPackage().getName();

    /* renamed from: f, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14601f = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.support.annotation", "NonNull", new String[0]);

    /* renamed from: g, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14602g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("org.jetbrains.annotations", "NotNull", new String[0]);

    /* renamed from: h, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14603h = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("androidx.annotation", "NonNull", new String[0]);

    /* renamed from: i, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14604i = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.support.annotation", "CheckResult", new String[0]);

    /* renamed from: j, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14605j = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("androidx.annotation", "CheckResult", new String[0]);

    /* renamed from: k, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14606k = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.support.annotation", "VisibleForTesting", new String[0]);

    /* renamed from: l, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14607l = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("androidx.annotation", "VisibleForTesting", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14608a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeElement f14609b;

    /* renamed from: c, reason: collision with root package name */
    private final TypeElement f14610c;

    /* renamed from: d, reason: collision with root package name */
    private int f14611d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<VariableElement, Object> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(VariableElement variableElement) {
            return i.this.w(variableElement);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, Object> {
        b() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f16092d;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class c implements com.bumptech.glide.repackaged.com.google.common.base.a<com.bumptech.glide.repackaged.com.squareup.javapoet.j, String> {
        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar) {
            return jVar.f16089a;
        }

        c() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private enum e {
        STATIC,
        INSTANCE
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class f implements com.bumptech.glide.repackaged.com.google.common.base.a<Element, ExecutableElement> {
        private f() {
        }

        /* synthetic */ f(a aVar) {
            this();
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExecutableElement apply(Element element) {
            return (ExecutableElement) element;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean H(ExecutableElement executableElement, TypeMirror typeMirror) {
        return this.f14608a.getTypeUtils().isAssignable(executableElement.getReturnType(), typeMirror);
    }

    static List<com.bumptech.glide.repackaged.com.squareup.javapoet.c> K() {
        return ImmutableList.of(f14601f, f14602g, f14603h);
    }

    private static String c(String str) {
        return str.replace("[]", "s").replace(Class.class.getSimpleName(), "clazz").replace(Object.class.getSimpleName(), "o");
    }

    private static List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> g(List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> list) {
        HashSet hashSet = new HashSet();
        Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.j> it = list.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            String str = it.next().f16089a;
            if (hashSet.contains(str)) {
                z5 = true;
            } else {
                hashSet.add(str);
            }
        }
        if (!z5) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < list.size(); i6++) {
            com.bumptech.glide.repackaged.com.squareup.javapoet.j jVar = list.get(i6);
            arrayList.add(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(jVar.f16092d, jVar.f16089a + i6, new Modifier[0]).g(jVar.f16091c).f(jVar.f16090b).i());
        }
        return arrayList;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.c i(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar, com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar2) {
        return this.f14608a.getElementUtils().getTypeElement(cVar.F()) != null ? cVar : cVar2;
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.d s(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, String str, List<Object> list) {
        StringBuilder sb = new StringBuilder("@see $T#$L(");
        ArrayList arrayList = new ArrayList();
        arrayList.add(lVar);
        arrayList.add(str);
        for (Object obj : list) {
            sb.append("$T, ");
            arrayList.add(obj);
        }
        if (arrayList.size() > 2) {
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        }
        sb.append(")\n");
        return com.bumptech.glide.repackaged.com.squareup.javapoet.d.c(sb.toString(), arrayList.toArray(new Object[0]));
    }

    private List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> t(VariableElement variableElement) {
        ArrayList arrayList = new ArrayList();
        Iterator it = variableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            arrayList.add(I((AnnotationMirror) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bumptech.glide.repackaged.com.squareup.javapoet.l w(Element element) {
        Types typeUtils = this.f14608a.getTypeUtils();
        TypeMirror asType = element.asType();
        return typeUtils.asElement(asType) == null ? com.bumptech.glide.repackaged.com.squareup.javapoet.l.l(element.asType()) : com.bumptech.glide.repackaged.com.squareup.javapoet.c.t(typeUtils.asElement(asType).getSimpleName().toString());
    }

    void C(String str) {
        this.f14608a.getMessager().printMessage(Diagnostic.Kind.NOTE, "[" + this.f14611d + "] " + str);
    }

    boolean D(TypeElement typeElement) {
        return this.f14608a.getTypeUtils().isAssignable(typeElement.asType(), this.f14609b.asType());
    }

    boolean E(TypeElement typeElement) {
        return typeElement.getAnnotation(GlideExtension.class) != null;
    }

    boolean F(TypeElement typeElement) {
        return this.f14608a.getTypeUtils().isAssignable(typeElement.asType(), this.f14610c.asType());
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.c J() {
        return i(f14603h, f14601f);
    }

    void M() {
        this.f14611d++;
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.c N() {
        return i(f14607l, f14606k);
    }

    void O(String str, TypeSpec typeSpec) {
        try {
            f("Writing class:\n" + typeSpec);
            com.bumptech.glide.repackaged.com.squareup.javapoet.g.a(str, typeSpec).h(true).g().d(this.f14608a.getFiler());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    void P(TypeSpec typeSpec) {
        O(f14600e, typeSpec);
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.c d() {
        return i(f14605j, f14604i);
    }

    List<ExecutableElement> h(Set<String> set, Class<? extends Annotation> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            for (ExecutableElement executableElement : this.f14608a.getElementUtils().getTypeElement(it.next()).getEnclosedElements()) {
                if (executableElement.getAnnotation(cls) != null) {
                    arrayList.add(executableElement);
                }
            }
        }
        return arrayList;
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.d p(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return s(lVar, iVar.f16067a, w.i(iVar.f16073g, new b()));
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.d q(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, String str, List<? extends VariableElement> list) {
        return s(lVar, str, w.i(list, new a()));
    }

    int x(ExecutableElement executableElement) {
        return ((GlideOption) executableElement.getAnnotation(GlideOption.class)).override();
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> z(List<? extends VariableElement> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends VariableElement> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(y(it.next()));
        }
        return g(arrayList);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private final class d implements com.bumptech.glide.repackaged.com.google.common.base.e<Element> {

        /* renamed from: a, reason: collision with root package name */
        private final TypeMirror f14614a;

        /* renamed from: b, reason: collision with root package name */
        private final e f14615b;

        d(TypeMirror typeMirror, e eVar) {
            this.f14614a = typeMirror;
            this.f14615b = eVar;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(Element element) {
            if (element == null || element.getKind() != ElementKind.METHOD || !element.getModifiers().contains(Modifier.PUBLIC)) {
                return false;
            }
            boolean contains = element.getModifiers().contains(Modifier.STATIC);
            e eVar = this.f14615b;
            if (eVar == e.STATIC && !contains) {
                return false;
            }
            if (eVar == e.INSTANCE && contains) {
                return false;
            }
            ExecutableElement executableElement = (ExecutableElement) element;
            TypeMirror typeMirror = this.f14614a;
            return typeMirror == null || i.this.H(executableElement, typeMirror);
        }

        d(i iVar, TypeElement typeElement, e eVar) {
            this(typeElement != null ? typeElement.asType() : null, eVar);
        }
    }

    i(ProcessingEnvironment processingEnvironment) {
        this.f14608a = processingEnvironment;
        this.f14609b = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.module.AppGlideModule");
        this.f14610c = processingEnvironment.getElementUtils().getTypeElement("com.bumptech.glide.module.LibraryGlideModule");
    }

    private static String B(VariableElement variableElement) {
        Iterator it = variableElement.getAnnotationMirrors().iterator();
        while (it.hasNext()) {
            String upperCase = ((AnnotationMirror) it.next()).getAnnotationType().toString().toUpperCase();
            if (upperCase.endsWith("RES")) {
                return "id";
            }
            if (upperCase.endsWith("RANGE")) {
                return "value";
            }
        }
        return variableElement.getSimpleName().toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.repackaged.com.squareup.javapoet.a I(AnnotationMirror annotationMirror) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar;
        String obj = annotationMirror.getAnnotationType().asElement().toString();
        com.bumptech.glide.repackaged.com.squareup.javapoet.c N = N();
        com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar2 = f14607l;
        boolean equals = N.equals(cVar2);
        ImmutableBiMap c6 = ImmutableBiMap.builder().b(f14601f, f14603h).b(f14604i, f14605j).b(f14606k, cVar2).c();
        if (equals && obj.startsWith("android.support.annotation")) {
            cVar = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(annotationMirror.getAnnotationType().asElement());
        } else if (!equals && obj.startsWith("androidx.annotation")) {
            cVar = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(annotationMirror.getAnnotationType().asElement());
        } else {
            cVar = null;
        }
        if (cVar != null && c6.containsKey(cVar)) {
            return com.bumptech.glide.repackaged.com.squareup.javapoet.a.a((com.bumptech.glide.repackaged.com.squareup.javapoet.c) c6.get(cVar)).f();
        }
        return com.bumptech.glide.repackaged.com.squareup.javapoet.a.e(annotationMirror);
    }

    private static String e(VariableElement variableElement, com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar) {
        String lVar2 = lVar.r().toString();
        if (!lVar.p() && !lVar.o()) {
            if (lVar2.contains("<") && lVar2.contains(">")) {
                String str = lVar2.split("<")[0];
                String[] split = lVar2.split(">");
                lVar2 = split.length > 1 ? str + split[split.length - 1] : str;
            }
            String[] split2 = lVar2.split("\\.");
            String c6 = c(split2[split2.length - 1]);
            for (char c7 : c6.toCharArray()) {
                if (Character.isLowerCase(c7)) {
                    char[] charArray = c6.toCharArray();
                    int length = charArray.length;
                    int i6 = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        if (Character.isUpperCase(charArray[i7])) {
                            i6 = i7;
                        }
                    }
                    String substring = c6.substring(i6, c6.length());
                    return Character.toLowerCase(substring.charAt(0)) + substring.substring(1, substring.length());
                }
            }
            return c6.toLowerCase();
        }
        return B(variableElement);
    }

    static com.bumptech.glide.repackaged.com.squareup.javapoet.d o(com.bumptech.glide.repackaged.com.squareup.javapoet.l lVar, com.bumptech.glide.repackaged.com.squareup.javapoet.i iVar) {
        return com.bumptech.glide.repackaged.com.squareup.javapoet.d.a().b("return ($T) super.$N(", lVar, iVar.f16067a).b(com.bumptech.glide.repackaged.com.google.common.collect.j.e(iVar.f16073g).m(new c()).f(com.bumptech.glide.repackaged.com.google.common.base.b.g(",")), new Object[0]).b(");\n", new Object[0]).j();
    }

    private static String v(Element element, Object obj) {
        if (!obj.getClass().getSimpleName().equals("UnresolvedClass")) {
            Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            if (declaredMethods != null && declaredMethods.length != 0) {
                for (Method method : declaredMethods) {
                    if (method.getName().equals("getValue")) {
                        try {
                            return method.invoke(obj, null).toString();
                        } catch (IllegalAccessException | InvocationTargetException e6) {
                            throw new IllegalArgumentException("Failed to parse @Excludes for: " + element, e6);
                        }
                    }
                }
                throw new IllegalArgumentException("Failed to parse @Excludes for: " + element);
            }
            throw new IllegalArgumentException("Failed to parse @Excludes for: " + element + ", invalid exclude: " + obj);
        }
        throw new IllegalArgumentException("Failed to parse @Excludes for: " + element + ", one or more excluded Modules could not be found at compile time. Ensure that allexcluded Modules are included in your classpath.");
    }

    private com.bumptech.glide.repackaged.com.squareup.javapoet.j y(VariableElement variableElement) {
        com.bumptech.glide.repackaged.com.squareup.javapoet.l l6 = com.bumptech.glide.repackaged.com.squareup.javapoet.l.l(variableElement.asType());
        return com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(l6, e(variableElement, l6), new Modifier[0]).g(variableElement.getModifiers()).f(t(variableElement)).i();
    }

    List<com.bumptech.glide.repackaged.com.squareup.javapoet.j> A(ExecutableElement executableElement) {
        return z(executableElement.getParameters());
    }

    boolean G(ExecutableElement executableElement, TypeElement typeElement) {
        return H(executableElement, typeElement.asType());
    }

    i.b L(ExecutableElement executableElement) {
        Modifier modifier;
        i.b n6 = com.bumptech.glide.repackaged.com.squareup.javapoet.i.f(executableElement.getSimpleName().toString()).n(Override.class);
        LinkedHashSet linkedHashSet = new LinkedHashSet(executableElement.getModifiers());
        linkedHashSet.remove(Modifier.ABSTRACT);
        try {
            modifier = Modifier.valueOf("DEFAULT");
        } catch (IllegalArgumentException unused) {
            modifier = null;
        }
        linkedHashSet.remove(modifier);
        i.b t5 = n6.t(linkedHashSet);
        Iterator it = executableElement.getTypeParameters().iterator();
        while (it.hasNext()) {
            t5 = t5.z(com.bumptech.glide.repackaged.com.squareup.javapoet.m.w(((TypeParameterElement) it.next()).asType()));
        }
        i.b H = t5.F(com.bumptech.glide.repackaged.com.squareup.javapoet.l.l(executableElement.getReturnType())).x(A(executableElement)).H(executableElement.isVarArgs());
        Iterator it2 = executableElement.getThrownTypes().iterator();
        while (it2.hasNext()) {
            H = H.r(com.bumptech.glide.repackaged.com.squareup.javapoet.l.l((TypeMirror) it2.next()));
        }
        return H;
    }

    Set<String> j(Element element, Class<? extends Annotation> cls) {
        String name = cls.getName();
        AnnotationValue annotationValue = null;
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            if (name.equals(annotationMirror.getAnnotationType().toString())) {
                Set entrySet = annotationMirror.getElementValues().entrySet();
                if (entrySet.size() == 1) {
                    annotationValue = (AnnotationValue) ((Map.Entry) entrySet.iterator().next()).getValue();
                    if (annotationValue == null || (annotationValue instanceof Attribute.UnresolvedClass)) {
                        throw new IllegalArgumentException("Failed to find value for: " + cls + " from mirrors: " + element.getAnnotationMirrors());
                    }
                } else {
                    throw new IllegalArgumentException("Expected single value, but found: " + entrySet);
                }
            }
        }
        if (annotationValue == null) {
            return Collections.EMPTY_SET;
        }
        Object value = annotationValue.getValue();
        if (value instanceof List) {
            List list = (List) value;
            HashSet hashSet = new HashSet(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(v(element, it.next()));
            }
            return hashSet;
        }
        return Collections.singleton(((Type.ClassType) value).toString());
    }

    List<ExecutableElement> k(TypeElement typeElement, TypeElement typeElement2) {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(typeElement.getEnclosedElements()).d(new d(this, typeElement2, e.INSTANCE)).m(new f(null)).g();
    }

    List<ExecutableElement> l(TypeElement typeElement, TypeMirror typeMirror) {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(typeElement.getEnclosedElements()).d(new d(typeMirror, e.INSTANCE)).m(new f(null)).g();
    }

    List<ExecutableElement> m(TypeElement typeElement) {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(typeElement.getEnclosedElements()).d(new d((TypeMirror) null, e.STATIC)).m(new f(null)).g();
    }

    List<ExecutableElement> n(TypeElement typeElement, TypeElement typeElement2) {
        return com.bumptech.glide.repackaged.com.google.common.collect.j.e(typeElement.getEnclosedElements()).d(new d(this, typeElement2, e.STATIC)).m(new f(null)).g();
    }

    com.bumptech.glide.repackaged.com.squareup.javapoet.d r(ExecutableElement executableElement) {
        return q(w(executableElement.getEnclosingElement()), executableElement.getSimpleName().toString(), executableElement.getParameters());
    }

    List<TypeElement> u(Class<? extends Annotation> cls, RoundEnvironment roundEnvironment) {
        return ElementFilter.typesIn(roundEnvironment.getElementsAnnotatedWith(cls));
    }

    void f(String str) {
    }
}
