package org.junit.experimental.results;

import java.util.Iterator;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<Failure> f51351a;

    public Result a() {
        Result result = new Result();
        RunListener createListener = result.createListener();
        Iterator<Failure> it = this.f51351a.iterator();
        while (it.hasNext()) {
            try {
                createListener.b(it.next());
            } catch (Exception unused) {
                throw new RuntimeException("I can't believe this happened");
            }
        }
        return result;
    }

    public a(List<Failure> list) {
        this.f51351a = list;
    }
}
