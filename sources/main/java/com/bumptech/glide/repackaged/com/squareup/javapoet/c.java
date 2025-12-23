package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import kotlin.text.v0;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c extends l implements Comparable<c> {

    /* renamed from: y, reason: collision with root package name */
    public static final c f16011y = w(Object.class);

    /* renamed from: w, reason: collision with root package name */
    final List<String> f16012w;

    /* renamed from: x, reason: collision with root package name */
    final String f16013x;

    private c(List<String> list) {
        this(list, new ArrayList());
    }

    public static c w(Class<?> cls) {
        n.c(cls, "clazz == null", new Object[0]);
        n.b(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        n.b(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        n.b(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (cls.isAnonymousClass()) {
                int lastIndexOf = cls.getName().lastIndexOf(46);
                if (lastIndexOf != -1) {
                    String substring = cls.getName().substring(lastIndexOf + 1);
                    arrayList.add(substring.substring(substring.lastIndexOf(36)));
                }
            } else {
                arrayList.add(cls.getSimpleName());
            }
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                break;
            }
            cls = enclosingClass;
        }
        int lastIndexOf2 = cls.getName().lastIndexOf(46);
        if (lastIndexOf2 != -1) {
            arrayList.add(cls.getName().substring(0, lastIndexOf2));
        }
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    public static c y(TypeElement typeElement) {
        n.c(typeElement, "element == null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (TypeElement typeElement2 = typeElement; C(typeElement2); typeElement2 = typeElement2.getEnclosingElement()) {
            n.b(typeElement.getNestingKind() == NestingKind.TOP_LEVEL || typeElement.getNestingKind() == NestingKind.MEMBER, "unexpected type testing", new Object[0]);
            arrayList.add(typeElement2.getSimpleName().toString());
        }
        arrayList.add(z(typeElement).getQualifiedName().toString());
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    public c D(String str) {
        n.c(str, "name == null", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f16012w.size() + 1);
        arrayList.addAll(this.f16012w);
        arrayList.add(str);
        return new c(arrayList);
    }

    private c(List<String> list, List<a> list2) {
        super(list2);
        for (int i6 = 1; i6 < list.size(); i6++) {
            n.b(SourceVersion.isName(list.get(i6)), "part '%s' is keyword", list.get(i6));
        }
        this.f16012w = n.f(list);
        this.f16013x = (list.get(0).isEmpty() ? n.j(".", list.subList(1, list.size())) : n.j(".", list)).replace(".$", "$");
    }

    public static c t(String str) {
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i6 < str.length() && Character.isLowerCase(str.codePointAt(i6))) {
            i6 = str.indexOf(46, i6) + 1;
            n.b(i6 != 0, "couldn't make a guess for %s", str);
        }
        arrayList.add(i6 != 0 ? str.substring(0, i6 - 1) : "");
        for (String str2 : str.substring(i6).split("\\.", -1)) {
            n.b(!str2.isEmpty() && Character.isUpperCase(str2.codePointAt(0)), "couldn't make a guess for %s", str);
            arrayList.add(str2);
        }
        n.b(arrayList.size() >= 2, "couldn't make a guess for %s", str);
        return new c(arrayList);
    }

    public static c x(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        Collections.addAll(arrayList, strArr);
        return new c(arrayList);
    }

    public String E() {
        return this.f16012w.get(0);
    }

    public String F() {
        if (this.f16012w.size() == 2) {
            String E = E();
            if (E.isEmpty()) {
                return this.f16012w.get(1);
            }
            return E + "." + this.f16012w.get(1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(K());
        for (String str : J().subList(1, J().size())) {
            sb.append(v0.f47959c);
            sb.append(str);
        }
        return sb.toString();
    }

    public String I() {
        return this.f16012w.get(r0.size() - 1);
    }

    public List<String> J() {
        List<String> list = this.f16012w;
        return list.subList(1, list.size());
    }

    public c K() {
        return new c(this.f16012w.subList(0, 2));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l r() {
        return new c(this.f16012w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c a(List<a> list) {
        return new c(this.f16012w, d(list));
    }

    @Override // java.lang.Comparable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return this.f16013x.compareTo(cVar.f16013x);
    }

    public c v() {
        if (this.f16012w.size() == 2) {
            return null;
        }
        return new c(this.f16012w.subList(0, r1.size() - 1));
    }

    private static boolean C(Element element) {
        if (!element.getKind().isClass() && !element.getKind().isInterface()) {
            return false;
        }
        return true;
    }

    private static PackageElement z(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    e h(e eVar) throws IOException {
        return eVar.d(eVar.t(this));
    }
}
