package org.junit.experimental.results;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.internal.h;
import org.junit.runner.Result;
import org.junit.runner.e;
import org.junit.runner.f;
import org.junit.runner.notification.Failure;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private Result f51352a;

    public b(List<Failure> list) {
        this(new a(list).a());
    }

    private b(Result result) {
        this.f51352a = result;
    }

    public static b c(f fVar) {
        return new b(new e().h(fVar));
    }

    public int a() {
        return this.f51352a.getFailures().size();
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new h(new PrintStream(byteArrayOutputStream)).e(this.f51352a);
        return byteArrayOutputStream.toString();
    }

    public static b b(Class<?> cls) {
        return c(f.a(cls));
    }
}
