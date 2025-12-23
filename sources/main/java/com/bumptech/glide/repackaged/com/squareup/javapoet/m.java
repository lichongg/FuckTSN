package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class m extends l {

    /* renamed from: w, reason: collision with root package name */
    public final String f16124w;

    /* renamed from: x, reason: collision with root package name */
    public final List<l> f16125x;

    private m(String str, List<l> list) {
        this(str, list, new ArrayList());
    }

    private m(String str, List<l> list, List<a> list2) {
        super(list2);
        this.f16124w = (String) n.c(str, "name == null", new Object[0]);
        this.f16125x = list;
        Iterator<l> it = list.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.p() || next == l.f16100d) ? false : true, "invalid bound: %s", next);
        }
    }

    public static m t(String str) {
        return y(str, Collections.EMPTY_LIST);
    }

    private static m y(String str, List<l> list) {
        ArrayList arrayList = new ArrayList(list);
        arrayList.remove(l.f16109m);
        return new m(str, Collections.unmodifiableList(arrayList));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    e h(e eVar) throws IOException {
        return eVar.d(this.f16124w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l r() {
        return new m(this.f16124w, this.f16125x);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public m a(List<a> list) {
        return new m(this.f16124w, this.f16125x, list);
    }

    static m u(TypeVariable<?> typeVariable, Map<Type, m> map) {
        m mVar = map.get(typeVariable);
        if (mVar == null) {
            ArrayList arrayList = new ArrayList();
            m mVar2 = new m(typeVariable.getName(), Collections.unmodifiableList(arrayList));
            map.put(typeVariable, mVar2);
            for (Type type : typeVariable.getBounds()) {
                arrayList.add(l.k(type, map));
            }
            arrayList.remove(l.f16109m);
            return mVar2;
        }
        return mVar;
    }

    public static m v(TypeParameterElement typeParameterElement) {
        String obj = typeParameterElement.getSimpleName().toString();
        List bounds = typeParameterElement.getBounds();
        ArrayList arrayList = new ArrayList();
        Iterator it = bounds.iterator();
        while (it.hasNext()) {
            arrayList.add(l.l((TypeMirror) it.next()));
        }
        return y(obj, arrayList);
    }

    public static m w(javax.lang.model.type.TypeVariable typeVariable) {
        return v(typeVariable.asElement());
    }

    static m x(javax.lang.model.type.TypeVariable typeVariable, Map<TypeParameterElement, m> map) {
        TypeParameterElement typeParameterElement = (TypeParameterElement) typeVariable.asElement();
        m mVar = map.get(typeParameterElement);
        if (mVar == null) {
            ArrayList arrayList = new ArrayList();
            m mVar2 = new m(typeParameterElement.getSimpleName().toString(), Collections.unmodifiableList(arrayList));
            map.put(typeParameterElement, mVar2);
            Iterator it = typeParameterElement.getBounds().iterator();
            while (it.hasNext()) {
                arrayList.add(l.m((TypeMirror) it.next(), map));
            }
            arrayList.remove(l.f16109m);
            return mVar2;
        }
        return mVar;
    }
}
