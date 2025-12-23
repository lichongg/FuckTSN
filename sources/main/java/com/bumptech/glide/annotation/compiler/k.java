package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.repackaged.com.squareup.javapoet.TypeSpec;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class k {

    /* renamed from: g, reason: collision with root package name */
    private static final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14639g = com.bumptech.glide.repackaged.com.squareup.javapoet.c.x("android.content", "Context", new String[0]);

    /* renamed from: a, reason: collision with root package name */
    private final TypeElement f14640a;

    /* renamed from: b, reason: collision with root package name */
    private final TypeElement f14641b;

    /* renamed from: c, reason: collision with root package name */
    private final TypeElement f14642c;

    /* renamed from: d, reason: collision with root package name */
    private final TypeElement f14643d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.repackaged.com.squareup.javapoet.c f14644e;

    /* renamed from: f, reason: collision with root package name */
    private final i f14645f;

    TypeSpec a(String str, TypeSpec typeSpec) {
        return TypeSpec.a("GeneratedRequestManagerFactory").x(Modifier.FINAL).y(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14643d)).u("Generated code, do not modify\n", new Object[0]).v(com.bumptech.glide.repackaged.com.squareup.javapoet.i.f("build").u(Modifier.PUBLIC).n(Override.class).m(this.f14645f.J()).F(this.f14644e).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14640a), "glide", new Modifier[0]).e(this.f14645f.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14641b), "lifecycle", new Modifier[0]).e(this.f14645f.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(this.f14642c), "treeNode", new Modifier[0]).e(this.f14645f.J()).i()).v(com.bumptech.glide.repackaged.com.squareup.javapoet.j.a(f14639g, com.umeng.analytics.pro.d.X, new Modifier[0]).e(this.f14645f.J()).i()).y("return new $T(glide, lifecycle, treeNode, context)", com.bumptech.glide.repackaged.com.squareup.javapoet.c.x(str, typeSpec.f15974b, new String[0])).C()).B();
    }

    k(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14645f = iVar;
        Elements elementUtils = processingEnvironment.getElementUtils();
        this.f14640a = elementUtils.getTypeElement("com.bumptech.glide.Glide");
        this.f14641b = elementUtils.getTypeElement("com.bumptech.glide.manager.Lifecycle");
        this.f14642c = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerTreeNode");
        this.f14643d = elementUtils.getTypeElement("com.bumptech.glide.manager.RequestManagerRetriever.RequestManagerFactory");
        this.f14644e = com.bumptech.glide.repackaged.com.squareup.javapoet.c.y(elementUtils.getTypeElement("com.bumptech.glide.RequestManager"));
    }
}
