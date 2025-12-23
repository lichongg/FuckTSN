package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final l f16005a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<d>> f16006b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final l f16007a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, List<d>> f16008b;

        /* synthetic */ b(l lVar, C0174a c0174a) {
            this(lVar);
        }

        b e(String str, Object obj) {
            n.c(str, "memberName == null", new Object[0]);
            n.c(obj, "value == null, constant non-null value expected for %s", str);
            return obj instanceof Class ? d(str, "$T.class", obj) : obj instanceof Enum ? d(str, "$T.$L", obj.getClass(), ((Enum) obj).name()) : obj instanceof String ? d(str, "$S", obj) : obj instanceof Float ? d(str, "$Lf", obj) : obj instanceof Character ? d(str, "'$L'", n.a(((Character) obj).charValue())) : d(str, "$L", obj);
        }

        private b(l lVar) {
            this.f16008b = new LinkedHashMap();
            this.f16007a = lVar;
        }

        public b c(String str, d dVar) {
            List<d> list = this.f16008b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.f16008b.put(str, list);
            }
            list.add(dVar);
            return this;
        }

        public a f() {
            return new a(this, null);
        }

        public b d(String str, String str2, Object... objArr) {
            return c(str, d.c(str2, objArr));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends SimpleAnnotationValueVisitor7<b, String> {

        /* renamed from: a, reason: collision with root package name */
        final b f16009a;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b b(Object obj, String str) {
            return this.f16009a.e(str, obj);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b d(AnnotationMirror annotationMirror, String str) {
            return this.f16009a.d(str, "$L", a.e(annotationMirror));
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public b h(VariableElement variableElement, String str) {
            return this.f16009a.d(str, "$T.$L", variableElement.asType(), variableElement.getSimpleName());
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public b j(TypeMirror typeMirror, String str) {
            return this.f16009a.d(str, "$T.class", typeMirror);
        }

        c(b bVar) {
            super(bVar);
            this.f16009a = bVar;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b f(List<? extends AnnotationValue> list, String str) {
            Iterator<? extends AnnotationValue> it = list.iterator();
            while (it.hasNext()) {
                it.next().accept(this, str);
            }
            return this.f16009a;
        }
    }

    /* synthetic */ a(b bVar, C0174a c0174a) {
        this(bVar);
    }

    public static b a(com.bumptech.glide.repackaged.com.squareup.javapoet.c cVar) {
        n.c(cVar, "type == null", new Object[0]);
        return new b(cVar, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bumptech.glide.repackaged.com.squareup.javapoet.a$a, reason: collision with other inner class name */
    final class C0174a implements Comparator<Method> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            return method.getName().compareTo(method2.getName());
        }
    }

    private a(b bVar) {
        this.f16005a = bVar.f16007a;
        this.f16006b = n.h(bVar.f16008b);
    }

    void c(e eVar, boolean z5) throws IOException {
        String str = z5 ? "" : com.snail.antifake.deviceid.e.f37542d;
        String str2 = z5 ? ", " : ",\n";
        if (this.f16006b.isEmpty()) {
            eVar.c("@$T", this.f16005a);
            return;
        }
        if (this.f16006b.size() == 1 && this.f16006b.containsKey("value")) {
            eVar.c("@$T(", this.f16005a);
            d(eVar, str, str2, this.f16006b.get("value"));
            eVar.b(")");
            return;
        }
        eVar.c("@$T(" + str, this.f16005a);
        eVar.s(2);
        Iterator<Map.Entry<String, List<d>>> it = this.f16006b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<d>> next = it.next();
            eVar.c("$L = ", next.getKey());
            d(eVar, str, str2, next.getValue());
            if (it.hasNext()) {
                eVar.b(str2);
            }
        }
        eVar.C(2);
        eVar.b(str + ")");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).c("$L", this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public static b b(Class<?> cls) {
        return a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.w(cls));
    }

    private void d(e eVar, String str, String str2, List<d> list) throws IOException {
        boolean z5 = true;
        if (list.size() == 1) {
            eVar.s(2);
            eVar.a(list.get(0));
            eVar.C(2);
            return;
        }
        eVar.b("{" + str);
        eVar.s(2);
        for (d dVar : list) {
            if (!z5) {
                eVar.b(str2);
            }
            eVar.a(dVar);
            z5 = false;
        }
        eVar.C(2);
        eVar.b(str + "}");
    }

    public static a e(AnnotationMirror annotationMirror) {
        b a6 = a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(annotationMirror.getAnnotationType().asElement()));
        c cVar = new c(a6);
        for (ExecutableElement executableElement : annotationMirror.getElementValues().keySet()) {
            ((AnnotationValue) annotationMirror.getElementValues().get(executableElement)).accept(cVar, executableElement.getSimpleName().toString());
        }
        return a6.f();
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
