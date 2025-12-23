package com.facebook.rebound;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class BaseSpringSystem {

    /* renamed from: c, reason: collision with root package name */
    private final SpringLooper f32448c;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Spring> f32446a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Set<Spring> f32447b = new CopyOnWriteArraySet();

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArraySet<SpringSystemListener> f32449d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f32450e = true;

    void a(String str) {
        Spring spring = this.f32446a.get(str);
        if (spring == null) {
            throw new IllegalArgumentException("springId " + str + " does not reference a registered spring");
        }
        this.f32447b.add(spring);
        if (g()) {
            this.f32450e = false;
            this.f32448c.b();
        }
    }

    public void b(SpringSystemListener springSystemListener) {
        if (springSystemListener == null) {
            throw new IllegalArgumentException("newListener is required");
        }
        this.f32449d.add(springSystemListener);
    }

    void c(double d6) {
        for (Spring spring : this.f32447b) {
            if (spring.D()) {
                spring.b(d6 / 1000.0d);
            } else {
                this.f32447b.remove(spring);
            }
        }
    }

    public Spring d() {
        Spring spring = new Spring(this);
        j(spring);
        return spring;
    }

    void e(Spring spring) {
        if (spring == null) {
            throw new IllegalArgumentException("spring is required");
        }
        this.f32447b.remove(spring);
        this.f32446a.remove(spring.i());
    }

    public List<Spring> f() {
        Collection<Spring> values = this.f32446a.values();
        return Collections.unmodifiableList(values instanceof List ? (List) values : new ArrayList(values));
    }

    public boolean g() {
        return this.f32450e;
    }

    public Spring h(String str) {
        if (str != null) {
            return this.f32446a.get(str);
        }
        throw new IllegalArgumentException("id is required");
    }

    public void i(double d6) {
        Iterator<SpringSystemListener> it = this.f32449d.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
        c(d6);
        if (this.f32447b.isEmpty()) {
            this.f32450e = true;
        }
        Iterator<SpringSystemListener> it2 = this.f32449d.iterator();
        while (it2.hasNext()) {
            it2.next().a(this);
        }
        if (this.f32450e) {
            this.f32448c.c();
        }
    }

    void j(Spring spring) {
        if (spring == null) {
            throw new IllegalArgumentException("spring is required");
        }
        if (this.f32446a.containsKey(spring.i())) {
            throw new IllegalArgumentException("spring is already registered");
        }
        this.f32446a.put(spring.i(), spring);
    }

    public void k() {
        this.f32449d.clear();
    }

    public void l(SpringSystemListener springSystemListener) {
        if (springSystemListener == null) {
            throw new IllegalArgumentException("listenerToRemove is required");
        }
        this.f32449d.remove(springSystemListener);
    }

    public BaseSpringSystem(SpringLooper springLooper) {
        if (springLooper != null) {
            this.f32448c = springLooper;
            springLooper.a(this);
            return;
        }
        throw new IllegalArgumentException("springLooper is required");
    }
}
