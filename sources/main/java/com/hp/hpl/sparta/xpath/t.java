package com.hp.hpl.sparta.xpath;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class t {

    /* renamed from: d, reason: collision with root package name */
    public static t f32901d = new t(z.f32908a, a0.f32874a);

    /* renamed from: a, reason: collision with root package name */
    private final o f32902a;

    /* renamed from: b, reason: collision with root package name */
    private final k f32903b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f32904c;

    t(o oVar, k kVar) {
        this.f32902a = oVar;
        this.f32903b = kVar;
        this.f32904c = false;
    }

    public o a() {
        return this.f32902a;
    }

    public k b() {
        return this.f32903b;
    }

    public boolean c() {
        return this.f32904c;
    }

    public boolean d() {
        return this.f32902a.b();
    }

    public String toString() {
        return this.f32902a.toString() + this.f32903b.toString();
    }

    t(c0 c0Var, boolean z5, s sVar) throws XPathException, IOException {
        this.f32904c = z5;
        int i6 = sVar.f32892a;
        if (i6 != -3) {
            if (i6 == 42) {
                this.f32902a = a.f32873a;
            } else if (i6 != 46) {
                if (i6 == 64) {
                    if (sVar.a() == -3) {
                        this.f32902a = new j(sVar.f32894c);
                    } else {
                        throw new XPathException(c0Var, "after @ in node test", sVar, CommonNetImpl.NAME);
                    }
                } else {
                    throw new XPathException(c0Var, "at begininning of step", sVar, "'.' or '*' or name");
                }
            } else if (sVar.a() == 46) {
                this.f32902a = q.f32885a;
            } else {
                sVar.c();
                this.f32902a = z.f32908a;
            }
        } else if (sVar.f32894c.equals(com.baidu.mobads.sdk.internal.a.f10501b)) {
            if (sVar.a() == 40 && sVar.a() == 41) {
                this.f32902a = y.f32907a;
            } else {
                throw new XPathException(c0Var, "after text", sVar, "()");
            }
        } else {
            this.f32902a = new m(sVar.f32894c);
        }
        if (sVar.a() == 91) {
            sVar.a();
            this.f32903b = n.a(c0Var, sVar);
            if (sVar.f32892a == 93) {
                sVar.a();
                return;
            }
            throw new XPathException(c0Var, "after predicate expression", sVar, "]");
        }
        this.f32903b = a0.f32874a;
    }
}
