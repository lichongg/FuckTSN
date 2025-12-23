package org.junit.runner.notification;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.Description;
import org.junit.runner.Result;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class RunListener {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ThreadSafe {
    }

    public void a(Failure failure) {
    }

    public void b(Failure failure) throws Exception {
    }

    public void c(Description description) throws Exception {
    }

    public void d(Description description) throws Exception {
    }

    public void e(Result result) throws Exception {
    }

    public void f(Description description) throws Exception {
    }

    public void g(Description description) throws Exception {
    }
}
