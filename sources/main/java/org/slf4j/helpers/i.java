package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i implements org.slf4j.a {

    /* renamed from: a, reason: collision with root package name */
    boolean f51758a = false;

    /* renamed from: b, reason: collision with root package name */
    final Map<String, h> f51759b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<org.slf4j.event.d> f51760c = new LinkedBlockingQueue<>();

    @Override // org.slf4j.a
    public synchronized org.slf4j.c a(String str) {
        h hVar;
        hVar = this.f51759b.get(str);
        if (hVar == null) {
            hVar = new h(str, this.f51760c, this.f51758a);
            this.f51759b.put(str, hVar);
        }
        return hVar;
    }

    public void f() {
        this.f51758a = true;
    }

    public void b() {
        this.f51759b.clear();
        this.f51760c.clear();
    }

    public LinkedBlockingQueue<org.slf4j.event.d> c() {
        return this.f51760c;
    }

    public List<String> d() {
        return new ArrayList(this.f51759b.keySet());
    }

    public List<h> e() {
        return new ArrayList(this.f51759b.values());
    }
}
