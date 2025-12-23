package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    protected f f43483a;

    /* renamed from: b, reason: collision with root package name */
    protected Throwable f43484b;

    public f b() {
        return this.f43483a;
    }

    public Throwable d() {
        return this.f43484b;
    }

    public String e() {
        StringWriter stringWriter = new StringWriter();
        d().printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public String toString() {
        return this.f43483a + ": " + this.f43484b.getMessage();
    }

    public h(f fVar, Throwable th) {
        this.f43483a = fVar;
        this.f43484b = th;
    }

    public String a() {
        return d().getMessage();
    }

    public boolean c() {
        return d() instanceof AssertionFailedError;
    }
}
