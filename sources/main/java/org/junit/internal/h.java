package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends RunListener {

    /* renamed from: a, reason: collision with root package name */
    private final PrintStream f51386a;

    public h(e eVar) {
        this(eVar.b());
    }

    public h(PrintStream printStream) {
        this.f51386a = printStream;
    }

    private PrintStream i() {
        return this.f51386a;
    }

    @Override // org.junit.runner.notification.RunListener
    public void b(Failure failure) {
        this.f51386a.append('E');
    }

    @Override // org.junit.runner.notification.RunListener
    public void d(Description description) {
        this.f51386a.append('I');
    }

    @Override // org.junit.runner.notification.RunListener
    public void g(Description description) {
        this.f51386a.append('.');
    }

    @Override // org.junit.runner.notification.RunListener
    public void e(Result result) {
        m(result.getRunTime());
        k(result);
        l(result);
    }

    protected String h(long j6) {
        return NumberFormat.getInstance().format(j6 / 1000.0d);
    }

    protected void j(Failure failure, String str) {
        PrintStream i6 = i();
        failure.getTestHeader();
        i6.getClass();
        PrintStream i7 = i();
        failure.getTrace();
        i7.getClass();
    }

    protected void k(Result result) {
        List<Failure> failures = result.getFailures();
        if (failures.size() != 0) {
            int i6 = 1;
            if (failures.size() == 1) {
                PrintStream i7 = i();
                failures.size();
                i7.getClass();
            } else {
                PrintStream i8 = i();
                failures.size();
                i8.getClass();
            }
            Iterator<Failure> it = failures.iterator();
            while (it.hasNext()) {
                j(it.next(), "" + i6);
                i6++;
            }
        }
    }

    protected void l(Result result) {
        if (result.wasSuccessful()) {
            i().getClass();
            i().getClass();
            PrintStream i6 = i();
            result.getRunCount();
            result.getRunCount();
            i6.getClass();
        } else {
            i().getClass();
            i().getClass();
            PrintStream i7 = i();
            result.getRunCount();
            result.getFailureCount();
            i7.getClass();
        }
        i().getClass();
    }

    protected void m(long j6) {
        i().getClass();
        PrintStream i6 = i();
        h(j6);
        i6.getClass();
    }
}
