package org.junit.rules;

import java.util.Iterator;
import org.junit.runner.Description;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class h extends org.junit.runners.model.h {

    /* renamed from: a, reason: collision with root package name */
    private final org.junit.runners.model.h f51467a;

    @Override // org.junit.runners.model.h
    public void a() throws Throwable {
        this.f51467a.a();
    }

    public h(org.junit.runners.model.h hVar, Iterable<l> iterable, Description description) {
        this.f51467a = b(hVar, iterable, description);
    }

    private static org.junit.runners.model.h b(org.junit.runners.model.h hVar, Iterable<l> iterable, Description description) {
        Iterator<l> it = iterable.iterator();
        while (it.hasNext()) {
            hVar = it.next().a(hVar, description);
        }
        return hVar;
    }
}
