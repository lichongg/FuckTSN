package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.f0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.k;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.m;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.n;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.p;
import kotlin.reflect.jvm.internal.impl.km.internal.l;
import kotlin.reflect.jvm.internal.impl.km.j;
import kotlin.reflect.jvm.internal.impl.km.o;
import kotlin.reflect.jvm.internal.impl.km.q;
import kotlin.reflect.jvm.internal.impl.km.r;
import kotlin.reflect.jvm.internal.impl.km.s;
import kotlin.reflect.jvm.internal.impl.km.t;
import kotlin.reflect.jvm.internal.impl.km.u;
import kotlin.reflect.jvm.internal.impl.km.v;
import kotlin.reflect.jvm.internal.impl.km.w;
import kotlin.reflect.jvm.internal.impl.km.y;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nJvmMetadataExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmMetadataExtensions.kt\nkotlin/metadata/jvm/internal/JvmMetadataExtensions\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,301:1\n1634#2,3:302\n1634#2,3:306\n1634#2,3:309\n1634#2,3:312\n1634#2,3:315\n1634#2,3:318\n1634#2,3:321\n1634#2,3:324\n1634#2,3:327\n1634#2,3:330\n1634#2,3:333\n1563#2:336\n1634#2,3:337\n1869#2,2:340\n1869#2,2:342\n1563#2:344\n1634#2,3:345\n1563#2:348\n1634#2,3:349\n1563#2:352\n1634#2,3:353\n1563#2:356\n1634#2,3:357\n1563#2:360\n1634#2,3:361\n1563#2:364\n1634#2,3:365\n1563#2:368\n1634#2,3:369\n1563#2:372\n1634#2,3:373\n1563#2:376\n1634#2,3:377\n1869#2,2:380\n1869#2,2:382\n1869#2,2:384\n1563#2:386\n1634#2,3:387\n1#3:305\n*S KotlinDebug\n*F\n+ 1 JvmMetadataExtensions.kt\nkotlin/metadata/jvm/internal/JvmMetadataExtensions\n*L\n25#1:302,3\n58#1:306,3\n59#1:309,3\n71#1:312,3\n72#1:315,3\n74#1:318,3\n76#1:321,3\n77#1:324,3\n78#1:327,3\n102#1:330,3\n130#1:333,3\n135#1:336\n135#1:337,3\n139#1:340,2\n151#1:342,2\n172#1:344\n172#1:345,3\n174#1:348\n174#1:349,3\n184#1:352\n184#1:353,3\n185#1:356\n185#1:357,3\n187#1:360\n187#1:361,3\n190#1:364\n190#1:365,3\n192#1:368\n192#1:369,3\n193#1:372\n193#1:373,3\n230#1:376\n230#1:377,3\n237#1:380,2\n243#1:382,2\n251#1:384,2\n267#1:386\n267#1:387,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes8.dex */
public final class e implements p {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements kotlin.reflect.jvm.internal.impl.km.internal.extensions.h {

        /* renamed from: a, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.km.internal.extensions.f f45227a = new kotlin.reflect.jvm.internal.impl.km.internal.extensions.f(o0.d(kotlin.reflect.jvm.internal.impl.km.internal.extensions.h.class));

        @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.e
        public kotlin.reflect.jvm.internal.impl.km.internal.extensions.f getType() {
            return this.f45227a;
        }

        a() {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @Nullable
    public k a() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @Nullable
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.d b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @Nullable
    public n k() {
        return null;
    }

    public void B(@NotNull kotlin.reflect.jvm.internal.impl.km.g kmClass, @NotNull ProtoBuf.Class.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmClass, "kmClass");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.a a6 = c.a(kmClass);
        List<kotlin.reflect.jvm.internal.impl.km.d> d6 = kmClass.d();
        ArrayList arrayList = new ArrayList(f0.d0(d6, 10));
        Iterator<T> it = d6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
        proto.x(arrayList);
        String b6 = a6.b();
        if (b6 != null) {
        }
        Iterator<T> it2 = a6.d().iterator();
        while (it2.hasNext()) {
            proto.n(JvmProtoBuf.f46268j, l.c(c6, (s) it2.next()).build());
        }
        String e6 = a6.e();
        if (e6 != null && !g0.g(e6, "main")) {
            proto.u(JvmProtoBuf.f46267i, Integer.valueOf(c6.a(e6)));
        }
        if (a6.c() != 0) {
            proto.u(JvmProtoBuf.f46270l, Integer.valueOf(a6.c()));
        }
    }

    public void C(@NotNull j kmConstructor, @NotNull ProtoBuf.Constructor.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmConstructor, "kmConstructor");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        b b6 = c.b(kmConstructor);
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmConstructor.a();
        ArrayList arrayList = new ArrayList(f0.d0(a6, 10));
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
        proto.x(arrayList);
        w3.d a7 = b6.a();
        if (a7 != null) {
            proto.u(JvmProtoBuf.f46259a, A(a7, c6));
        }
    }

    public void D(@NotNull o enumEntry, @NotNull ProtoBuf.EnumEntry.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(enumEntry, "enumEntry");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        Iterator<T> it = enumEntry.a().iterator();
        while (it.hasNext()) {
            proto.x(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
    }

    public void E(@NotNull q kmFunction, @NotNull ProtoBuf.Function.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmFunction, "kmFunction");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        d c7 = c.c(kmFunction);
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmFunction.a();
        ArrayList arrayList = new ArrayList(f0.d0(a6, 10));
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
        proto.x(arrayList);
        List<kotlin.reflect.jvm.internal.impl.km.d> c8 = kmFunction.c();
        ArrayList arrayList2 = new ArrayList(f0.d0(c8, 10));
        Iterator<T> it2 = c8.iterator();
        while (it2.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it2.next(), c6.d()).build());
        }
        proto.y(arrayList2);
        w3.d b6 = c7.b();
        if (b6 != null) {
        }
        String a7 = c7.a();
        if (a7 != null) {
        }
    }

    public void F(@NotNull v3.a kmModuleFragment, @NotNull ProtoBuf.PackageFragment.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmModuleFragment, "kmModuleFragment");
        g0.p(proto, "proto");
        g0.p(c6, "c");
    }

    public void G(@NotNull r kmPackage, @NotNull ProtoBuf.Package.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmPackage, "kmPackage");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        f d6 = c.d(kmPackage);
        Iterator<T> it = d6.a().iterator();
        while (it.hasNext()) {
            proto.n(JvmProtoBuf.f46272n, l.c(c6, (s) it.next()).build());
        }
        String b6 = d6.b();
        if (b6 == null || g0.g(b6, "main")) {
            return;
        }
        proto.u(JvmProtoBuf.f46271m, Integer.valueOf(c6.a(b6)));
    }

    public void H(@NotNull v typeAlias, @NotNull ProtoBuf.TypeAlias.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(typeAlias, "typeAlias");
        g0.p(proto, "proto");
        g0.p(c6, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void c(@NotNull y valueParameter, @NotNull ProtoBuf.ValueParameter.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(valueParameter, "valueParameter");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        List<kotlin.reflect.jvm.internal.impl.km.d> b6 = valueParameter.b();
        ArrayList arrayList = new ArrayList(f0.d0(b6, 10));
        Iterator<T> it = b6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
        proto.x(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void d(@NotNull w kmTypeParameter, @NotNull ProtoBuf.TypeParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmTypeParameter, "kmTypeParameter");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        i g6 = c.g(kmTypeParameter);
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.f46266h)) {
            List<kotlin.reflect.jvm.internal.impl.km.d> a6 = g6.a();
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.b e() {
        return new kotlin.reflect.jvm.internal.impl.km.jvm.internal.a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.c f() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void g(@NotNull s kmProperty, @NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmProperty, "kmProperty");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        g e6 = c.e(kmProperty);
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmProperty.a();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
        List<ProtoBuf.Annotation> getterAnnotationList = proto.getGetterAnnotationList();
        g0.o(getterAnnotationList, "getGetterAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> a7 = kmProperty.h().a();
        for (ProtoBuf.Annotation annotation2 : getterAnnotationList) {
            g0.m(annotation2);
            a7.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation2, c6.e()));
        }
        t l6 = kmProperty.l();
        if (l6 != null) {
            List<ProtoBuf.Annotation> setterAnnotationList = proto.getSetterAnnotationList();
            g0.o(setterAnnotationList, "getSetterAnnotationList(...)");
            List<kotlin.reflect.jvm.internal.impl.km.d> a8 = l6.a();
            for (ProtoBuf.Annotation annotation3 : setterAnnotationList) {
                g0.m(annotation3);
                a8.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation3, c6.e()));
            }
        }
        List<ProtoBuf.Annotation> extensionReceiverAnnotationList = proto.getExtensionReceiverAnnotationList();
        g0.o(extensionReceiverAnnotationList, "getExtensionReceiverAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> e7 = kmProperty.e();
        for (ProtoBuf.Annotation annotation4 : extensionReceiverAnnotationList) {
            g0.m(annotation4);
            e7.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation4, c6.e()));
        }
        List<ProtoBuf.Annotation> backingFieldAnnotationList = proto.getBackingFieldAnnotationList();
        g0.o(backingFieldAnnotationList, "getBackingFieldAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> b6 = kmProperty.b();
        for (ProtoBuf.Annotation annotation5 : backingFieldAnnotationList) {
            g0.m(annotation5);
            b6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation5, c6.e()));
        }
        List<ProtoBuf.Annotation> delegateFieldAnnotationList = proto.getDelegateFieldAnnotationList();
        g0.o(delegateFieldAnnotationList, "getDelegateFieldAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> d6 = kmProperty.d();
        for (ProtoBuf.Annotation annotation6 : delegateFieldAnnotationList) {
            g0.m(annotation6);
            d6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation6, c6.e()));
        }
        d.a d7 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.d(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a, proto, c6.e(), c6.g(), false, 8, null);
        GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f46262d;
        g0.o(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, propertySignature);
        JvmProtoBuf.JvmMethodSignature getter = (jvmPropertySignature == null || !jvmPropertySignature.hasGetter()) ? null : jvmPropertySignature.getGetter();
        JvmProtoBuf.JvmMethodSignature setter = (jvmPropertySignature == null || !jvmPropertySignature.hasSetter()) ? null : jvmPropertySignature.getSetter();
        Object extension = proto.getExtension(JvmProtoBuf.f46263e);
        g0.o(extension, "getExtension(...)");
        e6.i(((Number) extension).intValue());
        e6.g(d7 != null ? w3.c.a(d7) : null);
        e6.h(getter != null ? new w3.d(c6.b(getter.getName()), c6.b(getter.getDesc())) : null);
        e6.j(setter != null ? new w3.d(c6.b(setter.getName()), c6.b(setter.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature syntheticMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasSyntheticMethod()) ? null : jvmPropertySignature.getSyntheticMethod();
        e6.k(syntheticMethod != null ? new w3.d(c6.b(syntheticMethod.getName()), c6.b(syntheticMethod.getDesc())) : null);
        JvmProtoBuf.JvmMethodSignature delegateMethod = (jvmPropertySignature == null || !jvmPropertySignature.hasDelegateMethod()) ? null : jvmPropertySignature.getDelegateMethod();
        e6.l(delegateMethod != null ? new w3.d(c6.b(delegateMethod.getName()), c6.b(delegateMethod.getDesc())) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.l h() {
        return new h();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void i(@NotNull w kmTypeParameter, @NotNull ProtoBuf.TypeParameter.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(kmTypeParameter, "kmTypeParameter");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        Iterator<T> it = c.g(kmTypeParameter).a().iterator();
        while (it.hasNext()) {
            proto.n(JvmProtoBuf.f46266h, kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public m j() {
        return new i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void l(@NotNull v kmTypeAlias, @NotNull ProtoBuf.TypeAlias proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmTypeAlias, "kmTypeAlias");
        g0.p(proto, "proto");
        g0.p(c6, "c");
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void m(@NotNull o kmEnumEntry, @NotNull ProtoBuf.EnumEntry proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmEnumEntry, "kmEnumEntry");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        for (ProtoBuf.Annotation annotation : proto.getAnnotationList()) {
            List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmEnumEntry.a();
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void n(@NotNull j kmConstructor, @NotNull ProtoBuf.Constructor proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmConstructor, "kmConstructor");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        b b6 = c.b(kmConstructor);
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmConstructor.a();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
        d.b b7 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.b(proto, c6.e(), c6.g());
        b6.b(b7 != null ? w3.c.b(b7) : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void o(@NotNull u type, @NotNull ProtoBuf.Type.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        g0.p(type, "type");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        h f6 = c.f(type);
        if (f6.b()) {
            proto.u(JvmProtoBuf.f46265g, Boolean.TRUE);
        }
        Iterator<T> it = f6.a().iterator();
        while (it.hasNext()) {
            proto.n(JvmProtoBuf.f46264f, kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.j p() {
        return new g();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void q(@NotNull u kmType, @NotNull ProtoBuf.Type proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmType, "kmType");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        h f6 = c.f(kmType);
        Object extension = proto.getExtension(JvmProtoBuf.f46265g);
        g0.o(extension, "getExtension(...)");
        f6.c(((Boolean) extension).booleanValue());
        for (ProtoBuf.Annotation annotation : (List) proto.getExtension(JvmProtoBuf.f46264f)) {
            List<kotlin.reflect.jvm.internal.impl.km.d> a6 = f6.a();
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void r(@NotNull kotlin.reflect.jvm.internal.impl.km.g kmClass, @NotNull ProtoBuf.Class proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        String str;
        g0.p(kmClass, "kmClass");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        kotlin.reflect.jvm.internal.impl.km.jvm.internal.a a6 = c.a(kmClass);
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> d6 = kmClass.d();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            d6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
        GeneratedMessageLite.f<ProtoBuf.Class, Integer> anonymousObjectOriginName = JvmProtoBuf.f46269k;
        g0.o(anonymousObjectOriginName, "anonymousObjectOriginName");
        Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, anonymousObjectOriginName);
        if (num != null) {
            a6.f(c6.b(num.intValue()));
        }
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.f46268j)) {
            List<s> d7 = a6.d();
            g0.m(property);
            d7.add(kotlin.reflect.jvm.internal.impl.km.internal.g.p(property, c6));
        }
        GeneratedMessageLite.f<ProtoBuf.Class, Integer> classModuleName = JvmProtoBuf.f46267i;
        g0.o(classModuleName, "classModuleName");
        Integer num2 = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, classModuleName);
        if (num2 == null || (str = c6.b(num2.intValue())) == null) {
            str = "main";
        }
        a6.h(str);
        GeneratedMessageLite.f<ProtoBuf.Class, Integer> jvmClassFlags = JvmProtoBuf.f46270l;
        g0.o(jvmClassFlags, "jvmClassFlags");
        Integer num3 = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, jvmClassFlags);
        if (num3 != null) {
            a6.g(num3.intValue());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void s(@NotNull s kmProperty, @NotNull ProtoBuf.Property.b proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.h c6) {
        boolean z5;
        g0.p(kmProperty, "kmProperty");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        g e6 = c.e(kmProperty);
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmProperty.a();
        ArrayList arrayList = new ArrayList(f0.d0(a6, 10));
        Iterator<T> it = a6.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it.next(), c6.d()).build());
        }
        proto.x(arrayList);
        List<kotlin.reflect.jvm.internal.impl.km.d> a7 = kmProperty.h().a();
        ArrayList arrayList2 = new ArrayList(f0.d0(a7, 10));
        Iterator<T> it2 = a7.iterator();
        while (it2.hasNext()) {
            arrayList2.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it2.next(), c6.d()).build());
        }
        proto.C(arrayList2);
        t l6 = kmProperty.l();
        if (l6 != null) {
            List<kotlin.reflect.jvm.internal.impl.km.d> a8 = l6.a();
            ArrayList arrayList3 = new ArrayList(f0.d0(a8, 10));
            Iterator<T> it3 = a8.iterator();
            while (it3.hasNext()) {
                arrayList3.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it3.next(), c6.d()).build());
            }
            proto.D(arrayList3);
        }
        List<kotlin.reflect.jvm.internal.impl.km.d> e7 = kmProperty.e();
        ArrayList arrayList4 = new ArrayList(f0.d0(e7, 10));
        Iterator<T> it4 = e7.iterator();
        while (it4.hasNext()) {
            arrayList4.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it4.next(), c6.d()).build());
        }
        proto.B(arrayList4);
        List<kotlin.reflect.jvm.internal.impl.km.d> b6 = kmProperty.b();
        ArrayList arrayList5 = new ArrayList(f0.d0(b6, 10));
        Iterator<T> it5 = b6.iterator();
        while (it5.hasNext()) {
            arrayList5.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it5.next(), c6.d()).build());
        }
        proto.y(arrayList5);
        List<kotlin.reflect.jvm.internal.impl.km.d> d6 = kmProperty.d();
        ArrayList arrayList6 = new ArrayList(f0.d0(d6, 10));
        Iterator<T> it6 = d6.iterator();
        while (it6.hasNext()) {
            arrayList6.add(kotlin.reflect.jvm.internal.impl.km.internal.i.b((kotlin.reflect.jvm.internal.impl.km.d) it6.next(), c6.d()).build());
        }
        proto.A(arrayList6);
        JvmProtoBuf.JvmPropertySignature.b newBuilder = JvmProtoBuf.JvmPropertySignature.newBuilder();
        g0.o(newBuilder, "newBuilder(...)");
        boolean z6 = true;
        if (e6.a() != null) {
            JvmProtoBuf.JvmFieldSignature.b newBuilder2 = JvmProtoBuf.JvmFieldSignature.newBuilder();
            w3.a a9 = e6.a();
            g0.m(a9);
            newBuilder2.x(c6.a(a9.b()));
            w3.a a10 = e6.a();
            g0.m(a10);
            newBuilder2.w(c6.a(a10.a()));
            newBuilder.C(newBuilder2.build());
            z5 = true;
        } else {
            z5 = false;
        }
        if (e6.b() != null) {
            w3.d b7 = e6.b();
            g0.m(b7);
            newBuilder.D(A(b7, c6));
            z5 = true;
        }
        if (e6.d() != null) {
            w3.d d7 = e6.d();
            g0.m(d7);
            newBuilder.E(A(d7, c6));
        } else {
            z6 = z5;
        }
        if (z6 && e6.e() != null) {
            w3.d e8 = e6.e();
            g0.m(e8);
            newBuilder.F(A(e8, c6));
        }
        if (z6 && e6.f() != null) {
            w3.d f6 = e6.f();
            g0.m(f6);
            newBuilder.B(A(f6, c6));
        }
        int c7 = e6.c();
        ProtoBuf.Property defaultInstance = ProtoBuf.Property.getDefaultInstance();
        GeneratedMessageLite.f<ProtoBuf.Property, Integer> fVar = JvmProtoBuf.f46263e;
        Integer num = (Integer) defaultInstance.getExtension(fVar);
        if (num == null || c7 != num.intValue()) {
            proto.u(fVar, Integer.valueOf(e6.c()));
        }
        if (z6) {
            proto.u(JvmProtoBuf.f46262d, newBuilder.build());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void t(@NotNull y kmValueParameter, @NotNull ProtoBuf.ValueParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmValueParameter, "kmValueParameter");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> b6 = kmValueParameter.b();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            b6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.g u() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.p
    public void v(@NotNull q kmFunction, @NotNull ProtoBuf.Function proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmFunction, "kmFunction");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        d c7 = c.c(kmFunction);
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        g0.o(annotationList, "getAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> a6 = kmFunction.a();
        for (ProtoBuf.Annotation annotation : annotationList) {
            g0.m(annotation);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation, c6.e()));
        }
        List<ProtoBuf.Annotation> extensionReceiverAnnotationList = proto.getExtensionReceiverAnnotationList();
        g0.o(extensionReceiverAnnotationList, "getExtensionReceiverAnnotationList(...)");
        List<kotlin.reflect.jvm.internal.impl.km.d> c8 = kmFunction.c();
        for (ProtoBuf.Annotation annotation2 : extensionReceiverAnnotationList) {
            g0.m(annotation2);
            c8.add(kotlin.reflect.jvm.internal.impl.km.internal.f.b(annotation2, c6.e()));
        }
        d.b e6 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.h.f46317a.e(proto, c6.e(), c6.g());
        c7.d(e6 != null ? w3.c.b(e6) : null);
        GeneratedMessageLite.f<ProtoBuf.Function, Integer> lambdaClassOriginName = JvmProtoBuf.f46261c;
        g0.o(lambdaClassOriginName, "lambdaClassOriginName");
        Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, lambdaClassOriginName);
        if (num != null) {
            c7.c(c6.b(num.intValue()));
        }
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.h w() {
        return new a();
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.km.internal.extensions.i x() {
        return new f();
    }

    public void y(@NotNull v3.a kmModuleFragment, @NotNull ProtoBuf.PackageFragment proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        g0.p(kmModuleFragment, "kmModuleFragment");
        g0.p(proto, "proto");
        g0.p(c6, "c");
    }

    public void z(@NotNull r kmPackage, @NotNull ProtoBuf.Package proto, @NotNull kotlin.reflect.jvm.internal.impl.km.internal.e c6) {
        String str;
        g0.p(kmPackage, "kmPackage");
        g0.p(proto, "proto");
        g0.p(c6, "c");
        f d6 = c.d(kmPackage);
        for (ProtoBuf.Property property : (List) proto.getExtension(JvmProtoBuf.f46272n)) {
            List<s> a6 = d6.a();
            g0.m(property);
            a6.add(kotlin.reflect.jvm.internal.impl.km.internal.g.p(property, c6));
        }
        GeneratedMessageLite.f<ProtoBuf.Package, Integer> packageModuleName = JvmProtoBuf.f46271m;
        g0.o(packageModuleName, "packageModuleName");
        Integer num = (Integer) kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, packageModuleName);
        if (num == null || (str = c6.b(num.intValue())) == null) {
            str = "main";
        }
        d6.c(str);
    }

    private final JvmProtoBuf.JvmMethodSignature A(w3.b bVar, kotlin.reflect.jvm.internal.impl.km.internal.h hVar) {
        JvmProtoBuf.JvmMethodSignature.b newBuilder = JvmProtoBuf.JvmMethodSignature.newBuilder();
        newBuilder.x(hVar.a(bVar.b()));
        newBuilder.w(hVar.a(bVar.a()));
        JvmProtoBuf.JvmMethodSignature build = newBuilder.build();
        g0.o(build, "build(...)");
        return build;
    }
}
