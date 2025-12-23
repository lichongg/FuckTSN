package com.hp.hpl.sparta;

import com.hp.hpl.sparta.xpath.XPathException;
import com.hp.hpl.sparta.xpath.a0;
import com.hp.hpl.sparta.xpath.c0;
import com.hp.hpl.sparta.xpath.t;
import com.hp.hpl.sparta.xpath.v;
import com.hp.hpl.sparta.xpath.w;
import com.hp.hpl.sparta.xpath.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    private e f32806a = null;

    /* renamed from: b, reason: collision with root package name */
    private g f32807b = null;

    /* renamed from: c, reason: collision with root package name */
    private i f32808c = null;

    /* renamed from: d, reason: collision with root package name */
    private i f32809d = null;

    /* renamed from: e, reason: collision with root package name */
    private Object f32810e = null;

    /* renamed from: f, reason: collision with root package name */
    private int f32811f = 0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements com.hp.hpl.sparta.xpath.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f32812a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f32813b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f32814c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f32815d;

        a(g gVar, g gVar2, String str, String str2) {
            this.f32812a = gVar;
            this.f32813b = gVar2;
            this.f32814c = str;
            this.f32815d = str2;
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void b(x xVar) throws XPathException {
            this.f32812a.x(new r("not " + xVar.b()));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void c(com.hp.hpl.sparta.xpath.h hVar) throws XPathException {
            this.f32812a.O(hVar.b(), "not " + hVar.c());
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void g(v vVar) throws XPathException {
            this.f32812a.x(new r(vVar.b()));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void k(w wVar) throws XPathException {
            this.f32812a.x(new r("something"));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void m(com.hp.hpl.sparta.xpath.f fVar) throws XPathException {
            this.f32812a.O(fVar.b(), Long.toString(Long.MAX_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void n(com.hp.hpl.sparta.xpath.c cVar) throws XPathException {
            this.f32812a.O(cVar.b(), cVar.c());
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void o(com.hp.hpl.sparta.xpath.g gVar) throws XPathException {
            this.f32812a.O(gVar.b(), Long.toString(Long.MIN_VALUE));
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void p(com.hp.hpl.sparta.xpath.d dVar) throws XPathException {
            this.f32812a.O(dVar.b(), "something");
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void j(com.hp.hpl.sparta.xpath.r rVar) throws XPathException {
            int b6 = rVar.b();
            if (this.f32813b == null && b6 != 1) {
                throw new XPathException(c0.b(this.f32814c), "Position of root node must be 1");
            }
            for (int i6 = 1; i6 < b6; i6++) {
                this.f32813b.x(new g(this.f32815d));
            }
        }

        @Override // com.hp.hpl.sparta.xpath.l
        public void h(a0 a0Var) {
        }
    }

    protected abstract int a();

    public abstract Object clone();

    void j() {
        this.f32811f = 0;
        e eVar = this.f32806a;
        if (eVar != null) {
            eVar.j();
        }
    }

    abstract void p(Writer writer) throws IOException;

    abstract void r(Writer writer) throws IOException;

    public abstract g s(String str) throws ParseException;

    public abstract Enumeration t(String str) throws ParseException;

    public abstract String u(String str) throws ParseException;

    public abstract Enumeration v(String str) throws ParseException;

    public Object b() {
        return this.f32810e;
    }

    public i c() {
        return this.f32809d;
    }

    public e d() {
        return this.f32806a;
    }

    public g e() {
        return this.f32807b;
    }

    public i f() {
        return this.f32808c;
    }

    void h(i iVar) {
        this.f32808c = iVar;
        if (iVar != null) {
            iVar.f32809d = this;
        }
    }

    public int hashCode() {
        if (this.f32811f == 0) {
            this.f32811f = a();
        }
        return this.f32811f;
    }

    void k() {
        i iVar = this.f32808c;
        if (iVar != null) {
            iVar.f32809d = this.f32809d;
        }
        i iVar2 = this.f32809d;
        if (iVar2 != null) {
            iVar2.f32808c = iVar;
        }
        this.f32809d = null;
        this.f32808c = null;
    }

    void l(i iVar) {
        i iVar2 = this.f32808c;
        if (iVar2 != null) {
            iVar2.f32809d = iVar;
        }
        i iVar3 = this.f32809d;
        if (iVar3 != null) {
            iVar3.f32808c = iVar;
        }
        iVar.f32809d = iVar3;
        iVar.f32808c = this.f32808c;
        this.f32809d = null;
        this.f32808c = null;
    }

    public void m(Object obj) {
        this.f32810e = obj;
    }

    void n(e eVar) {
        this.f32806a = eVar;
    }

    void o(g gVar) {
        this.f32807b = gVar;
    }

    public String q() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        r(outputStreamWriter);
        outputStreamWriter.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public String toString() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
            p(outputStreamWriter);
            outputStreamWriter.flush();
            return new String(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return super.toString();
        }
    }

    public boolean w(String str, String str2) throws ParseException {
        try {
            int lastIndexOf = str.lastIndexOf(47);
            int i6 = lastIndexOf + 1;
            if (!str.substring(i6).equals("text()") && str.charAt(i6) != '@') {
                throw new ParseException("Last step of Xpath expression \"" + str + "\" is not \"text()\" and does not start with a '@'. It starts with a '" + str.charAt(i6) + "'");
            }
            boolean z5 = false;
            String substring = str.substring(0, lastIndexOf);
            if (str.charAt(i6) == '@') {
                String substring2 = str.substring(lastIndexOf + 2);
                if (substring2.length() == 0) {
                    throw new ParseException("Xpath expression \"" + str + "\" specifies zero-length attribute name\"");
                }
                Enumeration t5 = t(substring);
                while (t5.hasMoreElements()) {
                    g gVar = (g) t5.nextElement();
                    if (!str2.equals(gVar.D(substring2))) {
                        gVar.O(substring2, str2);
                        z5 = true;
                    }
                }
                return z5;
            }
            Enumeration t6 = t(substring);
            boolean hasMoreElements = t6.hasMoreElements();
            while (t6.hasMoreElements()) {
                g gVar2 = (g) t6.nextElement();
                Vector vector = new Vector();
                for (i F = gVar2.F(); F != null; F = F.c()) {
                    if (F instanceof r) {
                        vector.addElement((r) F);
                    }
                }
                if (vector.size() == 0) {
                    r rVar = new r(str2);
                    if (rVar.A().length() > 0) {
                        gVar2.x(rVar);
                        hasMoreElements = true;
                    }
                } else {
                    r rVar2 = (r) vector.elementAt(0);
                    if (!rVar2.A().equals(str2)) {
                        vector.removeElementAt(0);
                        rVar2.B(str2);
                        hasMoreElements = true;
                    }
                    int i7 = 0;
                    while (i7 < vector.size()) {
                        gVar2.J((r) vector.elementAt(i7));
                        i7++;
                        hasMoreElements = true;
                    }
                }
            }
            return hasMoreElements;
        } catch (DOMException e6) {
            throw new Error("Assertion failed " + e6);
        } catch (IndexOutOfBoundsException unused) {
            throw new ParseException("Xpath expression \"" + str + "\" is not in the form \"xpathExpression/@attributeName\"");
        }
    }

    protected static void g(Writer writer, String str) throws IOException {
        String str2;
        int length = str.length();
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            char charAt = str.charAt(i7);
            if (charAt >= 128) {
                str2 = "&#" + ((int) charAt) + ";";
            } else if (charAt != '\"') {
                if (charAt != '<') {
                    if (charAt != '>') {
                        if (charAt != '&') {
                            if (charAt != '\'') {
                                str2 = null;
                            } else {
                                str2 = "&#39;";
                            }
                        } else {
                            str2 = "&amp;";
                        }
                    } else {
                        str2 = "&gt;";
                    }
                } else {
                    str2 = "&lt;";
                }
            } else {
                str2 = "&quot;";
            }
            if (str2 != null) {
                writer.write(str, i6, i7 - i6);
                writer.write(str2);
                i6 = i7 + 1;
            }
        }
        if (i6 < length) {
            writer.write(str, i6, length - i6);
        }
    }

    g i(g gVar, t tVar, String str) throws ParseException, XPathException {
        com.hp.hpl.sparta.xpath.o a6 = tVar.a();
        if (a6 instanceof com.hp.hpl.sparta.xpath.m) {
            String c6 = ((com.hp.hpl.sparta.xpath.m) a6).c();
            g gVar2 = new g(c6);
            tVar.b().a(new a(gVar2, gVar, str, c6));
            return gVar2;
        }
        throw new ParseException("\"" + a6 + "\" in \"" + str + "\" is not an element test");
    }
}
