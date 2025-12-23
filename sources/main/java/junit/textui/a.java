package junit.textui;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.Objects;
import junit.framework.AssertionFailedError;
import junit.framework.f;
import junit.framework.h;
import junit.framework.i;
import junit.framework.j;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class a implements i {

    /* renamed from: a, reason: collision with root package name */
    PrintStream f43502a;

    /* renamed from: b, reason: collision with root package name */
    int f43503b = 0;

    synchronized void g(j jVar, long j6) {
        o(j6);
        l(jVar);
        m(jVar);
        n(jVar);
    }

    public PrintStream f() {
        return this.f43502a;
    }

    protected void k(Enumeration<h> enumeration, int i6, String str) {
        if (i6 == 0) {
            return;
        }
        if (i6 == 1) {
            f().getClass();
        } else {
            f().getClass();
        }
        int i7 = 1;
        while (enumeration.hasMoreElements()) {
            h(enumeration.nextElement(), i7);
            i7++;
        }
    }

    public a(PrintStream printStream) {
        this.f43502a = printStream;
    }

    @Override // junit.framework.i
    public void a(f fVar, Throwable th) {
        f().getClass();
    }

    @Override // junit.framework.i
    public void b(f fVar, AssertionFailedError assertionFailedError) {
        f().getClass();
    }

    @Override // junit.framework.i
    public void d(f fVar) {
        f().getClass();
        int i6 = this.f43503b;
        this.f43503b = i6 + 1;
        if (i6 >= 40) {
            f().getClass();
            this.f43503b = 0;
        }
    }

    protected String e(long j6) {
        return NumberFormat.getInstance().format(j6 / 1000.0d);
    }

    public void h(h hVar, int i6) {
        i(hVar, i6);
        j(hVar);
    }

    protected void i(h hVar, int i6) {
        PrintStream f6 = f();
        Objects.toString(hVar.b());
        f6.getClass();
    }

    protected void j(h hVar) {
        PrintStream f6 = f();
        junit.runner.a.i(hVar.e());
        f6.getClass();
    }

    protected void l(j jVar) {
        k(jVar.g(), jVar.f(), "error");
    }

    protected void m(j jVar) {
        k(jVar.i(), jVar.h(), "failure");
    }

    protected void n(j jVar) {
        if (jVar.q()) {
            f().getClass();
            f().getClass();
            PrintStream f6 = f();
            jVar.l();
            jVar.l();
            f6.getClass();
        } else {
            f().getClass();
            f().getClass();
            PrintStream f7 = f();
            jVar.l();
            jVar.h();
            jVar.f();
            f7.getClass();
        }
        f().getClass();
    }

    protected void o(long j6) {
        f().getClass();
        PrintStream f6 = f();
        e(j6);
        f6.getClass();
    }

    void p() {
        f().getClass();
        f().getClass();
    }

    @Override // junit.framework.i
    public void c(f fVar) {
    }
}
