package kotlin.reflect.jvm.internal;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KVariance;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class g3 extends kotlin.jvm.internal.p0 {
    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.d a(Class cls) {
        return new h0(cls);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.d b(Class cls, String str) {
        return new h0(cls);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.i c(FunctionReference functionReference) {
        return new m1(v(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.k h(MutablePropertyReference0 mutablePropertyReference0) {
        return new o1(v(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.l i(MutablePropertyReference1 mutablePropertyReference1) {
        return new q1(v(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.m j(MutablePropertyReference2 mutablePropertyReference2) {
        return new s1(v(mutablePropertyReference2), mutablePropertyReference2.getName(), mutablePropertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.o m(PropertyReference0 propertyReference0) {
        return new g2(v(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.p n(PropertyReference1 propertyReference1) {
        return new j2(v(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.q o(PropertyReference2 propertyReference2) {
        return new m2(v(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.r s(kotlin.reflect.g gVar, List<kotlin.reflect.t> list, boolean z5) {
        return gVar instanceof kotlin.jvm.internal.s ? h.l(((kotlin.jvm.internal.s) gVar).c(), list, z5) : kotlin.reflect.full.i.b(gVar, list, z5, Collections.EMPTY_LIST);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.s t(Object obj, String str, KVariance kVariance, boolean z5) {
        List<kotlin.reflect.s> typeParameters;
        if (obj instanceof kotlin.reflect.d) {
            typeParameters = ((kotlin.reflect.d) obj).getTypeParameters();
        } else {
            if (!(obj instanceof kotlin.reflect.c)) {
                throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
            }
            typeParameters = ((kotlin.reflect.c) obj).getTypeParameters();
        }
        for (kotlin.reflect.s sVar : typeParameters) {
            if (sVar.getName().equals(str)) {
                return sVar;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }

    public static void u() {
        h.k();
        e3.a();
    }

    private static KDeclarationContainerImpl v(CallableReference callableReference) {
        kotlin.reflect.h owner = callableReference.getOwner();
        if (owner instanceof KDeclarationContainerImpl) {
            return (KDeclarationContainerImpl) owner;
        }
        return o.f47537d;
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.d d(Class cls) {
        return h.n(cls);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.d e(Class cls, String str) {
        return h.n(cls);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.h f(Class cls, String str) {
        return h.o(cls);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.r g(kotlin.reflect.r rVar) {
        return n3.a(rVar);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.r k(kotlin.reflect.r rVar) {
        return n3.b(rVar);
    }

    @Override // kotlin.jvm.internal.p0
    public kotlin.reflect.r l(kotlin.reflect.r rVar, kotlin.reflect.r rVar2) {
        return n3.c(rVar, rVar2);
    }

    @Override // kotlin.jvm.internal.p0
    public String p(kotlin.jvm.internal.c0 c0Var) {
        m1 c6;
        kotlin.reflect.i a6 = kotlin.reflect.jvm.e.a(c0Var);
        if (a6 != null && (c6 = p3.c(a6)) != null) {
            return j3.f47506a.h(c6.e0());
        }
        return super.p(c0Var);
    }

    @Override // kotlin.jvm.internal.p0
    public String q(Lambda lambda) {
        return p(lambda);
    }

    @Override // kotlin.jvm.internal.p0
    public void r(kotlin.reflect.s sVar, List<kotlin.reflect.r> list) {
    }
}
