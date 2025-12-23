package com.bumptech.glide.repackaged.com.squareup.javapoet;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class l {

    /* renamed from: d, reason: collision with root package name */
    public static final l f16100d = new l("void");

    /* renamed from: e, reason: collision with root package name */
    public static final l f16101e = new l("boolean");

    /* renamed from: f, reason: collision with root package name */
    public static final l f16102f = new l("byte");

    /* renamed from: g, reason: collision with root package name */
    public static final l f16103g = new l("short");

    /* renamed from: h, reason: collision with root package name */
    public static final l f16104h = new l(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);

    /* renamed from: i, reason: collision with root package name */
    public static final l f16105i = new l("long");

    /* renamed from: j, reason: collision with root package name */
    public static final l f16106j = new l("char");

    /* renamed from: k, reason: collision with root package name */
    public static final l f16107k = new l("float");

    /* renamed from: l, reason: collision with root package name */
    public static final l f16108l = new l("double");

    /* renamed from: m, reason: collision with root package name */
    public static final c f16109m = c.x("java.lang", "Object", new String[0]);

    /* renamed from: n, reason: collision with root package name */
    private static final c f16110n = c.x("java.lang", "Void", new String[0]);

    /* renamed from: o, reason: collision with root package name */
    private static final c f16111o = c.x("java.lang", "Boolean", new String[0]);

    /* renamed from: p, reason: collision with root package name */
    private static final c f16112p = c.x("java.lang", "Byte", new String[0]);

    /* renamed from: q, reason: collision with root package name */
    private static final c f16113q = c.x("java.lang", "Short", new String[0]);

    /* renamed from: r, reason: collision with root package name */
    private static final c f16114r = c.x("java.lang", "Integer", new String[0]);

    /* renamed from: s, reason: collision with root package name */
    private static final c f16115s = c.x("java.lang", "Long", new String[0]);

    /* renamed from: t, reason: collision with root package name */
    private static final c f16116t = c.x("java.lang", "Character", new String[0]);

    /* renamed from: u, reason: collision with root package name */
    private static final c f16117u = c.x("java.lang", "Float", new String[0]);

    /* renamed from: v, reason: collision with root package name */
    private static final c f16118v = c.x("java.lang", "Double", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    private final String f16119a;

    /* renamed from: b, reason: collision with root package name */
    public final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> f16120b;

    /* renamed from: c, reason: collision with root package name */
    private String f16121c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    final class a extends SimpleTypeVisitor7<l, Void> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f16122a;

        a(Map map) {
            this.f16122a = map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public l b(TypeMirror typeMirror, Void r42) {
            throw new IllegalArgumentException("Unexpected type mirror: " + typeMirror);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.repackaged.com.squareup.javapoet.b d(ArrayType arrayType, Void r22) {
            return com.bumptech.glide.repackaged.com.squareup.javapoet.b.u(arrayType, this.f16122a);
        }

        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public l l(PrimitiveType primitiveType, Void r22) {
            switch (b.f16123a[primitiveType.getKind().ordinal()]) {
                case 1:
                    return l.f16101e;
                case 2:
                    return l.f16102f;
                case 3:
                    return l.f16103g;
                case 4:
                    return l.f16104h;
                case 5:
                    return l.f16105i;
                case 6:
                    return l.f16106j;
                case 7:
                    return l.f16107k;
                case 8:
                    return l.f16108l;
                default:
                    throw new AssertionError();
            }
        }

        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public l n(TypeVariable typeVariable, Void r22) {
            return m.x(typeVariable, this.f16122a);
        }

        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public l p(WildcardType wildcardType, Void r22) {
            return o.u(wildcardType, this.f16122a);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public l f(DeclaredType declaredType, Void r7) {
            l lVar;
            c y5 = c.y(declaredType.asElement());
            TypeMirror enclosingType = declaredType.getEnclosingType();
            if (enclosingType.getKind() != TypeKind.NONE && !declaredType.asElement().getModifiers().contains(Modifier.STATIC)) {
                lVar = (l) enclosingType.accept(this, (Object) null);
            } else {
                lVar = null;
            }
            if (declaredType.getTypeArguments().isEmpty() && !(lVar instanceof k)) {
                return y5;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                arrayList.add(l.m((TypeMirror) it.next(), this.f16122a));
            }
            if (lVar instanceof k) {
                return ((k) lVar).v(y5.I(), arrayList);
            }
            return new k(null, y5, arrayList);
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public l h(ErrorType errorType, Void r22) {
            return f(errorType, r22);
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public l j(NoType noType, Void r42) {
            if (noType.getKind() == TypeKind.VOID) {
                return l.f16100d;
            }
            return (l) super.visitUnknown(noType, r42);
        }
    }

    private l(String str) {
        this(str, new ArrayList());
    }

    public l a(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        n.c(list, "annotations == null", new Object[0]);
        return new l(this.f16119a, d(list));
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16123a;

        static {
            int[] iArr = new int[TypeKind.values().length];
            f16123a = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16123a[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16123a[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16123a[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16123a[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16123a[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16123a[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16123a[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private l(String str, List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        this.f16119a = str;
        this.f16120b = n.f(list);
    }

    static l c(l lVar) {
        if (lVar instanceof com.bumptech.glide.repackaged.com.squareup.javapoet.b) {
            return ((com.bumptech.glide.repackaged.com.squareup.javapoet.b) lVar).f16010w;
        }
        return null;
    }

    public static l j(Type type) {
        return k(type, new LinkedHashMap());
    }

    static l k(Type type, Map<Type, m> map) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return type == Void.TYPE ? f16100d : type == Boolean.TYPE ? f16101e : type == Byte.TYPE ? f16102f : type == Short.TYPE ? f16103g : type == Integer.TYPE ? f16104h : type == Long.TYPE ? f16105i : type == Character.TYPE ? f16106j : type == Float.TYPE ? f16107k : type == Double.TYPE ? f16108l : cls.isArray() ? com.bumptech.glide.repackaged.com.squareup.javapoet.b.v(k(cls.getComponentType(), map)) : c.w(cls);
        }
        if (type instanceof ParameterizedType) {
            return k.u((ParameterizedType) type, map);
        }
        if (type instanceof java.lang.reflect.WildcardType) {
            return o.t((java.lang.reflect.WildcardType) type, map);
        }
        if (type instanceof java.lang.reflect.TypeVariable) {
            return m.u((java.lang.reflect.TypeVariable) type, map);
        }
        if (type instanceof GenericArrayType) {
            return com.bumptech.glide.repackaged.com.squareup.javapoet.b.t((GenericArrayType) type, map);
        }
        throw new IllegalArgumentException("unexpected type: " + type);
    }

    public static l l(TypeMirror typeMirror) {
        return m(typeMirror, new LinkedHashMap());
    }

    static l m(TypeMirror typeMirror, Map<TypeParameterElement, m> map) {
        return (l) typeMirror.accept(new a(map), (Object) null);
    }

    static List<l> q(Type[] typeArr, Map<Type, m> map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(k(type, map));
        }
        return arrayList;
    }

    protected final List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> d(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        ArrayList arrayList = new ArrayList(this.f16120b);
        arrayList.addAll(list);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    e h(e eVar) throws IOException {
        String str = this.f16119a;
        if (str != null) {
            return eVar.d(str);
        }
        throw new AssertionError();
    }

    e i(e eVar) throws IOException {
        Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.a> it = this.f16120b.iterator();
        while (it.hasNext()) {
            it.next().c(eVar, true);
            eVar.b(" ");
        }
        return eVar;
    }

    public boolean n() {
        return !this.f16120b.isEmpty();
    }

    public boolean o() {
        return equals(f16111o) || equals(f16112p) || equals(f16113q) || equals(f16114r) || equals(f16115s) || equals(f16116t) || equals(f16117u) || equals(f16118v);
    }

    public boolean p() {
        return (this.f16119a == null || this == f16100d) ? false : true;
    }

    public l r() {
        return new l(this.f16119a);
    }

    public final String toString() {
        String str = this.f16121c;
        if (str != null) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            e eVar = new e(sb);
            i(eVar);
            h(eVar);
            String sb2 = sb.toString();
            this.f16121c = sb2;
            return sb2;
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    public final l b(com.bumptech.glide.repackaged.com.squareup.javapoet.a... aVarArr) {
        return a(Arrays.asList(aVarArr));
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    l(List<com.bumptech.glide.repackaged.com.squareup.javapoet.a> list) {
        this(null, list);
    }
}
