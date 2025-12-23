package com.bumptech.glide.repackaged.com.squareup.javapoet;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b extends l {

    /* renamed from: w, reason: collision with root package name */
    public final l f16010w;

    private b(l lVar) {
        this(lVar, new ArrayList());
    }

    private b(l lVar, List<a> list) {
        super(list);
        this.f16010w = (l) n.c(lVar, "rawType == null", new Object[0]);
    }

    static b u(ArrayType arrayType, Map<TypeParameterElement, m> map) {
        return new b(l.m(arrayType.getComponentType(), map));
    }

    public static b v(l lVar) {
        return new b(lVar);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    e h(e eVar) throws IOException {
        return eVar.c("$T[]", this.f16010w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    public l r() {
        return new b(this.f16010w);
    }

    @Override // com.bumptech.glide.repackaged.com.squareup.javapoet.l
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public b a(List<a> list) {
        return new b(this.f16010w, d(list));
    }

    static b t(GenericArrayType genericArrayType, Map<Type, m> map) {
        return v(l.k(genericArrayType.getGenericComponentType(), map));
    }
}
