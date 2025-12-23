package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class g extends i {

    /* renamed from: l, reason: collision with root package name */
    private static final boolean f32800l = false;

    /* renamed from: g, reason: collision with root package name */
    private i f32801g;

    /* renamed from: h, reason: collision with root package name */
    private i f32802h;

    /* renamed from: i, reason: collision with root package name */
    private Hashtable f32803i;

    /* renamed from: j, reason: collision with root package name */
    private Vector f32804j;

    /* renamed from: k, reason: collision with root package name */
    private String f32805k;

    public g(String str) {
        this.f32801g = null;
        this.f32802h = null;
        this.f32803i = null;
        this.f32804j = null;
        this.f32805k = null;
        this.f32805k = q.a(str);
    }

    public g C() {
        return B(false);
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        return B(true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!this.f32805k.equals(gVar.f32805k)) {
            return false;
        }
        Hashtable hashtable = this.f32803i;
        int size = hashtable == null ? 0 : hashtable.size();
        Hashtable hashtable2 = gVar.f32803i;
        if (size != (hashtable2 == null ? 0 : hashtable2.size())) {
            return false;
        }
        Hashtable hashtable3 = this.f32803i;
        if (hashtable3 != null) {
            Enumeration keys = hashtable3.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                if (!((String) this.f32803i.get(str)).equals((String) gVar.f32803i.get(str))) {
                    return false;
                }
            }
        }
        i iVar = this.f32801g;
        i iVar2 = gVar.f32801g;
        while (iVar != null) {
            if (!iVar.equals(iVar2)) {
                return false;
            }
            iVar = iVar.c();
            iVar2 = iVar2.c();
        }
        return true;
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) throws ParseException {
        try {
            return Q(str, false).u();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) throws ParseException {
        try {
            return Q(str, false).w();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) throws ParseException {
        try {
            return Q(str, true).v();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) throws ParseException {
        try {
            return Q(str, true).w();
        } catch (XPathException e6) {
            throw new ParseException("XPath problem", e6);
        }
    }

    private boolean K(i iVar) {
        for (i iVar2 = this.f32801g; iVar2 != null; iVar2 = iVar2.c()) {
            if (iVar2.equals(iVar)) {
                if (this.f32801g == iVar2) {
                    this.f32801g = iVar2.c();
                }
                if (this.f32802h == iVar2) {
                    this.f32802h = iVar2.f();
                }
                iVar2.k();
                iVar2.o(null);
                iVar2.n(null);
                return true;
            }
        }
        return false;
    }

    private void N(i iVar, i iVar2) throws DOMException {
        for (i iVar3 = this.f32801g; iVar3 != null; iVar3 = iVar3.c()) {
            if (iVar3 == iVar2) {
                if (this.f32801g == iVar2) {
                    this.f32801g = iVar;
                }
                if (this.f32802h == iVar2) {
                    this.f32802h = iVar;
                }
                iVar2.l(iVar);
                iVar.o(this);
                iVar2.o(null);
                return;
            }
        }
        throw new DOMException((short) 8, "Cannot find " + iVar2 + " in " + this);
    }

    public g B(boolean z5) {
        g gVar = new g(this.f32805k);
        Vector vector = this.f32804j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                gVar.O(str, (String) this.f32803i.get(str));
            }
        }
        if (z5) {
            for (i iVar = this.f32801g; iVar != null; iVar = iVar.c()) {
                gVar.x((i) iVar.clone());
            }
        }
        return gVar;
    }

    public String D(String str) {
        Hashtable hashtable = this.f32803i;
        if (hashtable == null) {
            return null;
        }
        return (String) hashtable.get(str);
    }

    public Enumeration E() {
        Vector vector = this.f32804j;
        return vector == null ? e.f32790n : vector.elements();
    }

    public i F() {
        return this.f32801g;
    }

    public i G() {
        return this.f32802h;
    }

    public String H() {
        return this.f32805k;
    }

    public void I(String str) {
        Hashtable hashtable = this.f32803i;
        if (hashtable == null) {
            return;
        }
        hashtable.remove(str);
        this.f32804j.removeElement(str);
        j();
    }

    public void O(String str, String str2) {
        if (this.f32803i == null) {
            this.f32803i = new Hashtable();
            this.f32804j = new Vector();
        }
        if (this.f32803i.get(str) == null) {
            this.f32804j.addElement(str);
        }
        this.f32803i.put(str, str2);
        j();
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        int hashCode = this.f32805k.hashCode();
        Hashtable hashtable = this.f32803i;
        if (hashtable != null) {
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                hashCode = (((hashCode * 31) + str.hashCode()) * 31) + ((String) this.f32803i.get(str)).hashCode();
            }
        }
        for (i iVar = this.f32801g; iVar != null; iVar = iVar.c()) {
            hashCode = (hashCode * 31) + iVar.hashCode();
        }
        return hashCode;
    }

    @Override // com.hp.hpl.sparta.i
    void p(Writer writer) throws IOException {
        for (i iVar = this.f32801g; iVar != null; iVar = iVar.c()) {
            iVar.p(writer);
        }
    }

    @Override // com.hp.hpl.sparta.i
    public void r(Writer writer) throws IOException {
        writer.write("<" + this.f32805k);
        Vector vector = this.f32804j;
        if (vector != null) {
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                String str = (String) elements.nextElement();
                String str2 = (String) this.f32803i.get(str);
                writer.write(" " + str + "=\"");
                i.g(writer, str2);
                writer.write("\"");
            }
        }
        if (this.f32801g == null) {
            writer.write("/>");
            return;
        }
        writer.write(">");
        for (i iVar = this.f32801g; iVar != null; iVar = iVar.c()) {
            iVar.r(writer);
        }
        writer.write("</" + this.f32805k + ">");
    }

    boolean z(i iVar) {
        if (iVar == this) {
            return false;
        }
        g e6 = e();
        if (e6 == null) {
            return true;
        }
        return e6.z(iVar);
    }

    private s Q(String str, boolean z5) throws XPathException {
        String str2;
        c0 b6 = c0.b(str);
        if (b6.h() != z5) {
            if (z5) {
                str2 = "evaluates to element not string";
            } else {
                str2 = "evaluates to string not element";
            }
            throw new XPathException(b6, "\"" + b6 + "\" evaluates to " + str2);
        }
        return new s(this, b6);
    }

    public void J(i iVar) throws DOMException {
        if (K(iVar)) {
            j();
            return;
        }
        throw new DOMException((short) 8, "Cannot find " + iVar + " in " + this);
    }

    public void L(g gVar, i iVar) throws DOMException {
        N(gVar, iVar);
        j();
    }

    public void M(r rVar, i iVar) throws DOMException {
        N(rVar, iVar);
        j();
    }

    public void P(String str) {
        this.f32805k = q.a(str);
        j();
    }

    public boolean R(String str) throws ParseException {
        g s5;
        try {
            if (s(str) != null) {
                return false;
            }
            c0 b6 = c0.b(str);
            Enumeration f6 = b6.f();
            int i6 = 0;
            while (f6.hasMoreElements()) {
                f6.nextElement();
                i6++;
            }
            int i7 = i6 - 1;
            t[] tVarArr = new t[i7];
            Enumeration f7 = b6.f();
            for (int i8 = 0; i8 < i7; i8++) {
                tVarArr[i8] = (t) f7.nextElement();
            }
            t tVar = (t) f7.nextElement();
            if (i7 == 0) {
                s5 = this;
            } else {
                String c0Var = c0.c(b6.g(), tVarArr).toString();
                R(c0Var.toString());
                s5 = s(c0Var);
            }
            s5.y(i(s5, tVar, str));
            return true;
        } catch (XPathException e6) {
            throw new ParseException(str, e6);
        }
    }

    public void x(i iVar) {
        if (!z(iVar)) {
            iVar = (g) iVar.clone();
        }
        y(iVar);
        j();
    }

    void y(i iVar) {
        g e6 = iVar.e();
        if (e6 != null) {
            e6.K(iVar);
        }
        iVar.h(this.f32802h);
        if (this.f32801g == null) {
            this.f32801g = iVar;
        }
        iVar.o(this);
        this.f32802h = iVar;
        iVar.n(d());
    }

    g() {
        this.f32801g = null;
        this.f32802h = null;
        this.f32803i = null;
        this.f32804j = null;
        this.f32805k = null;
    }

    private void A() {
    }
}
