package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class k extends l {

    /* renamed from: w, reason: collision with root package name */
    private final k f16097w;

    /* renamed from: x, reason: collision with root package name */
    public final c f16098x;

    /* renamed from: y, reason: collision with root package name */
    public final List<l> f16099y;

    k(k kVar, c cVar, List<l> list) {
        this(kVar, cVar, list, new ArrayList());
    }

    public k v(String str, List<l> list) {
        n.c(str, "name == null", new Object[0]);
        return new k(this, this.f16098x.D(str), list, new ArrayList());
    }

    private k(k kVar, c cVar, List<l> list, List<a> list2) {
        super(list2);
        this.f16098x = (c) n.c(cVar, "rawType == null", new Object[0]);
        this.f16097w = kVar;
        List<l> f6 = n.f(list);
        this.f16099y = f6;
        n.b((f6.isEmpty() && kVar == null) ? false : true, "no type arguments: %s", cVar);
        Iterator<l> it = f6.iterator();
        while (it.hasNext()) {
            l next = it.next();
            n.b((next.p() || next == l.f16100d) ? false : true, "invalid type parameter: %s", next);
        }
    }

    public static k t(c cVar, l... lVarArr) {
        return new k(null, cVar, Arrays.asList(lVarArr));
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    e h(e eVar) throws IOException {
        k kVar = this.f16097w;
        if (kVar != null) {
            kVar.i(eVar);
            this.f16097w.h(eVar);
            eVar.b("." + this.f16098x.I());
        } else {
            this.f16098x.i(eVar);
            this.f16098x.h(eVar);
        }
        if (!this.f16099y.isEmpty()) {
            eVar.d("<");
            boolean z5 = true;
            for (l lVar : this.f16099y) {
                if (!z5) {
                    eVar.d(", ");
                }
                lVar.i(eVar);
                lVar.h(eVar);
                z5 = false;
            }
            eVar.d(">");
        }
        return eVar;
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l r() {
        return new k(this.f16097w, this.f16098x, this.f16099y, new ArrayList());
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public k a(List<a> list) {
        return new k(this.f16097w, this.f16098x, this.f16099y, d(list));
    }

    static k u(ParameterizedType parameterizedType, Map<Type, m> map) {
        ParameterizedType parameterizedType2;
        c w5 = c.w((Class) parameterizedType.getRawType());
        if ((parameterizedType.getOwnerType() instanceof ParameterizedType) && !Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers())) {
            parameterizedType2 = (ParameterizedType) parameterizedType.getOwnerType();
        } else {
            parameterizedType2 = null;
        }
        List<l> q5 = l.q(parameterizedType.getActualTypeArguments(), map);
        if (parameterizedType2 != null) {
            return u(parameterizedType2, map).v(w5.I(), q5);
        }
        return new k(null, w5, q5);
    }
}
