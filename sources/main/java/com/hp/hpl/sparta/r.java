package com.hp.hpl.sparta;

import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class r extends i {

    /* renamed from: g, reason: collision with root package name */
    private StringBuffer f32859g;

    public r(String str) {
        this.f32859g = new StringBuffer(str);
    }

    public String A() {
        return this.f32859g.toString();
    }

    public void B(String str) {
        this.f32859g = new StringBuffer(str);
        j();
    }

    @Override // com.hp.hpl.sparta.i
    protected int a() {
        return this.f32859g.toString().hashCode();
    }

    @Override // com.hp.hpl.sparta.i
    public Object clone() {
        return new r(this.f32859g.toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            return this.f32859g.toString().equals(((r) obj).f32859g.toString());
        }
        return false;
    }

    @Override // com.hp.hpl.sparta.i
    void p(Writer writer) throws IOException {
        writer.write(this.f32859g.toString());
    }

    @Override // com.hp.hpl.sparta.i
    void r(Writer writer) throws IOException {
        String stringBuffer = this.f32859g.toString();
        if (stringBuffer.length() < 50) {
            i.g(writer, stringBuffer);
            return;
        }
        writer.write("<![CDATA[");
        writer.write(stringBuffer);
        writer.write("]]>");
    }

    @Override // com.hp.hpl.sparta.i
    public g s(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration t(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public String u(String str) {
        throw new Error("Sorry, not implemented");
    }

    @Override // com.hp.hpl.sparta.i
    public Enumeration v(String str) {
        throw new Error("Sorry, not implemented");
    }

    public void x(char c6) {
        this.f32859g.append(c6);
        j();
    }

    public void y(String str) {
        this.f32859g.append(str);
        j();
    }

    public void z(char[] cArr, int i6, int i7) {
        this.f32859g.append(cArr, i6, i7);
        j();
    }

    public r(char c6) {
        StringBuffer stringBuffer = new StringBuffer();
        this.f32859g = stringBuffer;
        stringBuffer.append(c6);
    }
}
