package org.slf4j.event;

import org.slf4j.Marker;
import org.slf4j.helpers.h;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class d implements c {

    /* renamed from: a, reason: collision with root package name */
    Level f51730a;

    /* renamed from: b, reason: collision with root package name */
    Marker f51731b;

    /* renamed from: c, reason: collision with root package name */
    String f51732c;

    /* renamed from: d, reason: collision with root package name */
    h f51733d;

    /* renamed from: e, reason: collision with root package name */
    String f51734e;

    /* renamed from: f, reason: collision with root package name */
    String f51735f;

    /* renamed from: g, reason: collision with root package name */
    Object[] f51736g;

    /* renamed from: h, reason: collision with root package name */
    long f51737h;

    /* renamed from: i, reason: collision with root package name */
    Throwable f51738i;

    @Override // org.slf4j.event.c
    public Object[] a() {
        return this.f51736g;
    }

    @Override // org.slf4j.event.c
    public Marker b() {
        return this.f51731b;
    }

    @Override // org.slf4j.event.c
    public String c() {
        return this.f51734e;
    }

    @Override // org.slf4j.event.c
    public long d() {
        return this.f51737h;
    }

    @Override // org.slf4j.event.c
    public String e() {
        return this.f51732c;
    }

    @Override // org.slf4j.event.c
    public Level f() {
        return this.f51730a;
    }

    @Override // org.slf4j.event.c
    public Throwable g() {
        return this.f51738i;
    }

    @Override // org.slf4j.event.c
    public String getMessage() {
        return this.f51735f;
    }

    public h h() {
        return this.f51733d;
    }

    public void i(Object[] objArr) {
        this.f51736g = objArr;
    }

    public void j(Level level) {
        this.f51730a = level;
    }

    public void k(h hVar) {
        this.f51733d = hVar;
    }

    public void l(String str) {
        this.f51732c = str;
    }

    public void m(Marker marker) {
        this.f51731b = marker;
    }

    public void n(String str) {
        this.f51735f = str;
    }

    public void o(String str) {
        this.f51734e = str;
    }

    public void p(Throwable th) {
        this.f51738i = th;
    }

    public void q(long j6) {
        this.f51737h = j6;
    }
}
