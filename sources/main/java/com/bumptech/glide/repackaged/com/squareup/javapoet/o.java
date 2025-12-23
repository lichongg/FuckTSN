package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class o extends l {

    /* renamed from: w, reason: collision with root package name */
    public final List<l> f16127w;

    /* renamed from: x, reason: collision with root package name */
    public final List<l> f16128x;

    private o(List<l> list, List<l> list2) {
        this(list, list2, new ArrayList());
    }

    private o(List<l> list, List<l> list2, List<a> list3) {
        super(list3);
        List<l> f6 = n.f(list);
        this.f16127w = f6;
        this.f16128x = n.f(list2);
        n.b(f6.size() == 1, "unexpected extends bounds: %s", list);
        Iterator<l> it = f6.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.p() || next == l.f16100d) ? false : true, "invalid upper bound: %s", next);
        }
        Iterator<l> it2 = this.f16128x.iterator();
        while (it2.hasNext()) {
            l next2 = it2.next();
            n.b((next2.p() || next2 == l.f16100d) ? false : true, "invalid lower bound: %s", next2);
        }
    }

    static l t(WildcardType wildcardType, Map<Type, m> map) {
        return new o(l.q(wildcardType.getUpperBounds(), map), l.q(wildcardType.getLowerBounds(), map));
    }

    public static o v(l lVar) {
        return new o(Arrays.asList(lVar), Collections.EMPTY_LIST);
    }

    public static o x(l lVar) {
        return new o(Arrays.asList(l.f16109m), Arrays.asList(lVar));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    e h(e eVar) throws IOException {
        return this.f16128x.size() == 1 ? eVar.c("? super $T", this.f16128x.get(0)) : this.f16127w.get(0).equals(l.f16109m) ? eVar.b("?") : eVar.c("? extends $T", this.f16127w.get(0));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l r() {
        return new o(this.f16127w, this.f16128x);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public o a(List<a> list) {
        return new o(this.f16127w, this.f16128x, d(list));
    }

    static l u(javax.lang.model.type.WildcardType wildcardType, Map<TypeParameterElement, m> map) {
        TypeMirror extendsBound = wildcardType.getExtendsBound();
        if (extendsBound == null) {
            TypeMirror superBound = wildcardType.getSuperBound();
            if (superBound == null) {
                return w(Object.class);
            }
            return x(l.m(superBound, map));
        }
        return v(l.m(extendsBound, map));
    }

    public static o w(Type type) {
        return v(l.j(type));
    }
}
