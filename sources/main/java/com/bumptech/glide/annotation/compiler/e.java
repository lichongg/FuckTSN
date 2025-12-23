package com.bumptech.glide.annotation.compiler;

import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class e {

    /* renamed from: a, reason: collision with root package name */
    private final ProcessingEnvironment f14587a;

    /* renamed from: b, reason: collision with root package name */
    private final i f14588b;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.bumptech.glide.repackaged.com.google.common.base.a<AnnotationMirror, String> {
        a() {
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.base.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(AnnotationMirror annotationMirror) {
            return annotationMirror.getAnnotationType().asElement().toString();
        }
    }

    private String c(ExecutableElement executableElement) {
        return this.f14588b.j(executableElement, GlideType.class).iterator().next();
    }

    private static String e(ExecutableElement executableElement) {
        return b(executableElement) + "#" + d(executableElement);
    }

    private boolean g(ExecutableElement executableElement) {
        TypeElement typeElement = this.f14587a.getElementUtils().getTypeElement("com.bumptech.glide.request.BaseRequestOptions");
        List<String> a6 = a(executableElement, true);
        String obj = executableElement.getSimpleName().toString();
        for (ExecutableElement executableElement2 : typeElement.getEnclosedElements()) {
            if (executableElement2.getKind() == ElementKind.METHOD) {
                ExecutableElement executableElement3 = executableElement2;
                if (obj.equals(executableElement3.getSimpleName().toString()) && a(executableElement3, false).equals(a6)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean h(TypeMirror typeMirror) {
        return this.f14587a.getTypeUtils().erasure(typeMirror).toString().equals("com.bumptech.glide.RequestBuilder");
    }

    private boolean i(TypeMirror typeMirror, ExecutableElement executableElement) {
        if (!(typeMirror instanceof DeclaredType)) {
            return false;
        }
        List typeArguments = ((DeclaredType) typeMirror).getTypeArguments();
        if (typeArguments.size() != 1) {
            return false;
        }
        TypeMirror typeMirror2 = (TypeMirror) typeArguments.get(0);
        return typeMirror2.toString().equals(c(executableElement));
    }

    private void o(ExecutableElement executableElement) {
        int x5 = this.f14588b.x(executableElement);
        boolean g6 = g(executableElement);
        if (g6 && x5 == 0) {
            throw new IllegalArgumentException("Accidentally attempting to override a method in BaseRequestOptions. Add an 'override' value in the @GlideOption annotation if this is intentional. Offending method: " + e(executableElement));
        }
        if (g6 || x5 == 0) {
            return;
        }
        throw new IllegalArgumentException("Requested to override an existing method in BaseRequestOptions, but no such method was found. Offending method: " + e(executableElement));
    }

    e(ProcessingEnvironment processingEnvironment, i iVar) {
        this.f14587a = processingEnvironment;
        this.f14588b = iVar;
    }

    private static List<String> a(ExecutableElement executableElement, boolean z5) {
        List parameters = executableElement.getParameters();
        if (z5) {
            parameters = parameters.subList(1, parameters.size());
        }
        ArrayList arrayList = new ArrayList(parameters.size());
        Iterator it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((VariableElement) it.next()).asType().toString());
        }
        return arrayList;
    }

    private static String b(Element element) {
        return element.getEnclosingElement().toString();
    }

    private static String d(Element element) {
        return element.toString();
    }

    private static boolean f(TypeMirror typeMirror) {
        return typeMirror.toString().equals("com.bumptech.glide.request.BaseRequestOptions<?>");
    }

    private void j(ExecutableElement executableElement) {
        ImmutableSet j6 = com.bumptech.glide.repackaged.com.google.common.collect.j.e(executableElement.getAnnotationMirrors()).m(new a()).j();
        Iterator<com.bumptech.glide.repackaged.com.squareup.javapoet.c> it = i.K().iterator();
        while (it.hasNext()) {
            if (j6.contains(it.next().F())) {
                return;
            }
        }
        this.f14587a.getMessager().printMessage(Diagnostic.Kind.WARNING, e(executableElement) + " is missing the " + this.f14588b.J().F() + " annotation, please add it to ensure that your extension methods are always returning non-null values");
    }

    private static void l(Element element) {
        if (element.getModifiers().contains(Modifier.PRIVATE)) {
            if (((ExecutableElement) element).getParameters().isEmpty()) {
                return;
            }
            throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found parameters in the constructor of: " + b(element));
        }
        throw new IllegalArgumentException("RequestOptionsExtensions must be public, with private constructors and only static methods. Found a non-private constructor in: " + b(element));
    }

    private void m(ExecutableElement executableElement) {
        n(executableElement);
        p(executableElement);
        TypeMirror returnType = executableElement.getReturnType();
        if (f(returnType)) {
            o(executableElement);
            return;
        }
        throw new IllegalArgumentException("@GlideOption methods should return a BaseRequestOptions<?> object, but " + e(executableElement) + " returns " + returnType + ". If you're using old style @GlideOption methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void n(ExecutableElement executableElement) {
        j(executableElement);
    }

    private static void p(ExecutableElement executableElement) {
        if (!executableElement.getParameters().isEmpty()) {
            TypeMirror asType = ((VariableElement) executableElement.getParameters().get(0)).asType();
            if (f(asType)) {
                return;
            }
            throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but the first parameter in " + e(executableElement) + " is " + asType);
        }
        throw new IllegalArgumentException("@GlideOption methods must take a BaseRequestOptions<?> object as their first parameter, but " + e(executableElement) + " has none");
    }

    private void q(ExecutableElement executableElement) {
        TypeMirror returnType = executableElement.getReturnType();
        r(executableElement);
        if (h(returnType) && i(returnType, executableElement)) {
            s(executableElement);
            return;
        }
        throw new IllegalArgumentException("@GlideType methods should return a RequestBuilder<" + c(executableElement) + "> object, but " + e(executableElement) + " returns: " + returnType + ". If you're using old style @GlideType methods, your method may have a void return type, but doing so is deprecated and support will be removed in a future version");
    }

    private void r(ExecutableElement executableElement) {
        j(executableElement);
    }

    private static void s(ExecutableElement executableElement) {
        if (executableElement.getParameters().size() == 1) {
            TypeMirror asType = ((VariableElement) executableElement.getParameters().get(0)).asType();
            if (asType.toString().startsWith("com.bumptech.glide.RequestBuilder")) {
                return;
            }
            throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given: " + asType + " for: " + e(executableElement));
        }
        throw new IllegalArgumentException("@GlideType methods must take a RequestBuilder object as their first and only parameter, but given multiple for: " + e(executableElement));
    }

    void k(TypeElement typeElement) {
        if (typeElement.getModifiers().contains(Modifier.PUBLIC)) {
            for (Element element : typeElement.getEnclosedElements()) {
                if (element.getKind() == ElementKind.CONSTRUCTOR) {
                    l(element);
                } else if (element.getKind() == ElementKind.METHOD) {
                    ExecutableElement executableElement = (ExecutableElement) element;
                    if (executableElement.getAnnotation(GlideOption.class) != null) {
                        m(executableElement);
                    } else if (executableElement.getAnnotation(GlideType.class) != null) {
                        q(executableElement);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("RequestOptionsExtensions must be public, including: " + d(typeElement));
    }
}
