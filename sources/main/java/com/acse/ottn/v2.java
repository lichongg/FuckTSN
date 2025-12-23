package com.acse.ottn;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class v2 extends n4 {
    public static final boolean Q = false;
    public static final Map<String, g3> R;
    public Object N;
    public String O;
    public g3 P;

    public v2() {
    }

    public void b(String str) {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null) {
            h3 h3Var = h3VarArr[0];
            String c6 = h3Var.c();
            h3Var.a(str);
            this.f4956t.remove(c6);
            this.f4956t.put(str, h3Var);
        }
        this.O = str;
        this.f4948l = false;
    }

    static {
        HashMap hashMap = new HashMap();
        R = hashMap;
        hashMap.put("alpha", f3.f4518a);
        hashMap.put("pivotX", f3.f4519b);
        hashMap.put("pivotY", f3.f4520c);
        hashMap.put("translationX", f3.f4521d);
        hashMap.put("translationY", f3.f4522e);
        hashMap.put("rotation", f3.f4523f);
        hashMap.put("rotationX", f3.f4524g);
        hashMap.put("rotationY", f3.f4525h);
        hashMap.put("scaleX", f3.f4526i);
        hashMap.put("scaleY", f3.f4527j);
        hashMap.put("scrollX", f3.f4528k);
        hashMap.put("scrollY", f3.f4529l);
        hashMap.put("x", f3.f4530m);
        hashMap.put("y", f3.f4531n);
    }

    public v2(Object obj, String str) {
        this.N = obj;
        b(str);
    }

    @Override // com.acse.ottn.n4
    public void D() {
        if (this.f4948l) {
            return;
        }
        if (this.P == null && l.f4710q && (this.N instanceof View)) {
            Map<String, g3> map = R;
            if (map.containsKey(this.O)) {
                a(map.get(this.O));
            }
        }
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].c(this.N);
        }
        super.D();
    }

    public String I() {
        return this.O;
    }

    public Object J() {
        return this.N;
    }

    @Override // com.acse.ottn.n4
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.N;
        if (this.f4955s != null) {
            for (int i6 = 0; i6 < this.f4955s.length; i6++) {
                str = str + "\n    " + this.f4955s[i6].toString();
            }
        }
        return str;
    }

    @Override // com.acse.ottn.n4
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public v2 clone() {
        return (v2) super.clone();
    }

    public void a(g3 g3Var) {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null) {
            h3 h3Var = h3VarArr[0];
            String c6 = h3Var.c();
            h3Var.a(g3Var);
            this.f4956t.remove(c6);
            this.f4956t.put(this.O, h3Var);
        }
        if (this.P != null) {
            this.O = g3Var.a();
        }
        this.P = g3Var;
        this.f4948l = false;
    }

    @Override // com.acse.ottn.n4
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public v2 a(long j6) {
        super.a(j6);
        return this;
    }

    @Override // com.acse.ottn.i
    public void i() {
        D();
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].b(this.N);
        }
    }

    @Override // com.acse.ottn.i
    public void j() {
        D();
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].d(this.N);
        }
    }

    @Override // com.acse.ottn.n4, com.acse.ottn.i
    public void k() {
        super.k();
    }

    public <T> v2(T t5, g3<T, ?> g3Var) {
        this.N = t5;
        a((g3) g3Var);
    }

    @Override // com.acse.ottn.n4
    public void b(int... iArr) {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null && h3VarArr.length != 0) {
            super.b(iArr);
            return;
        }
        g3 g3Var = this.P;
        if (g3Var != null) {
            b(h3.a((g3<?, Integer>) g3Var, iArr));
        } else {
            b(h3.a(this.O, iArr));
        }
    }

    public static v2 a(Object obj, String str, int... iArr) {
        v2 v2Var = new v2(obj, str);
        v2Var.b(iArr);
        return v2Var;
    }

    @Override // com.acse.ottn.n4
    public void b(float... fArr) {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null && h3VarArr.length != 0) {
            super.b(fArr);
            return;
        }
        g3 g3Var = this.P;
        if (g3Var != null) {
            b(h3.a((g3<?, Float>) g3Var, fArr));
        } else {
            b(h3.a(this.O, fArr));
        }
    }

    public static <T> v2 a(T t5, g3<T, Integer> g3Var, int... iArr) {
        v2 v2Var = new v2(t5, g3Var);
        v2Var.b(iArr);
        return v2Var;
    }

    public static v2 a(Object obj, String str, float... fArr) {
        v2 v2Var = new v2(obj, str);
        v2Var.b(fArr);
        return v2Var;
    }

    public static <T> v2 a(T t5, g3<T, Float> g3Var, float... fArr) {
        v2 v2Var = new v2(t5, g3Var);
        v2Var.b(fArr);
        return v2Var;
    }

    public static v2 a(Object obj, String str, m4 m4Var, Object... objArr) {
        v2 v2Var = new v2(obj, str);
        v2Var.a(objArr);
        v2Var.a(m4Var);
        return v2Var;
    }

    public static <T, V> v2 a(T t5, g3<T, V> g3Var, m4<V> m4Var, V... vArr) {
        v2 v2Var = new v2(t5, g3Var);
        v2Var.a((Object[]) vArr);
        v2Var.a((m4) m4Var);
        return v2Var;
    }

    public static v2 a(Object obj, h3... h3VarArr) {
        v2 v2Var = new v2();
        v2Var.N = obj;
        v2Var.b(h3VarArr);
        return v2Var;
    }

    @Override // com.acse.ottn.n4
    public void a(Object... objArr) {
        h3[] h3VarArr = this.f4955s;
        if (h3VarArr != null && h3VarArr.length != 0) {
            super.a(objArr);
            return;
        }
        g3 g3Var = this.P;
        if (g3Var != null) {
            b(h3.a(g3Var, (m4) null, objArr));
        } else {
            b(h3.a(this.O, (m4) null, objArr));
        }
    }

    @Override // com.acse.ottn.i
    public void a(Object obj) {
        Object obj2 = this.N;
        if (obj2 != obj) {
            this.N = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.f4948l = false;
            }
        }
    }

    @Override // com.acse.ottn.n4
    public void a(float f6) {
        super.a(f6);
        int length = this.f4955s.length;
        for (int i6 = 0; i6 < length; i6++) {
            this.f4955s[i6].a(this.N);
        }
    }
}
