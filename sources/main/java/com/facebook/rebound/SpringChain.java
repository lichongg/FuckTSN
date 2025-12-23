package com.facebook.rebound;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SpringChain implements SpringListener {

    /* renamed from: h, reason: collision with root package name */
    private static final int f32491h = 40;

    /* renamed from: i, reason: collision with root package name */
    private static final int f32492i = 6;

    /* renamed from: j, reason: collision with root package name */
    private static final int f32493j = 70;

    /* renamed from: k, reason: collision with root package name */
    private static final int f32494k = 10;

    /* renamed from: a, reason: collision with root package name */
    private final SpringSystem f32496a;

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<SpringListener> f32497b;

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<Spring> f32498c;

    /* renamed from: d, reason: collision with root package name */
    private int f32499d;

    /* renamed from: e, reason: collision with root package name */
    private final SpringConfig f32500e;

    /* renamed from: f, reason: collision with root package name */
    private final SpringConfig f32501f;

    /* renamed from: g, reason: collision with root package name */
    private static final SpringConfigRegistry f32490g = SpringConfigRegistry.c();

    /* renamed from: l, reason: collision with root package name */
    private static int f32495l = 0;

    private SpringChain() {
        this(40, 6, 70, 10);
    }

    private SpringChain(int i6, int i7, int i8, int i9) {
        this.f32496a = SpringSystem.m();
        this.f32497b = new CopyOnWriteArrayList<>();
        this.f32498c = new CopyOnWriteArrayList<>();
        this.f32499d = -1;
        SpringConfig b6 = SpringConfig.b(i6, i7);
        this.f32500e = b6;
        SpringConfig b7 = SpringConfig.b(i8, i9);
        this.f32501f = b7;
        SpringConfigRegistry springConfigRegistry = f32490g;
        StringBuilder sb = new StringBuilder();
        sb.append("main spring ");
        int i10 = f32495l;
        f32495l = i10 + 1;
        sb.append(i10);
        springConfigRegistry.a(b6, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachment spring ");
        int i11 = f32495l;
        f32495l = i11 + 1;
        sb2.append(i11);
        springConfigRegistry.a(b7, sb2.toString());
    }

    public static SpringChain b() {
        return new SpringChain();
    }

    public static SpringChain c(int i6, int i7, int i8, int i9) {
        return new SpringChain(i6, i7, i8, i9);
    }

    public SpringChain a(SpringListener springListener) {
        this.f32498c.add(this.f32496a.d().a(this).B(this.f32501f));
        this.f32497b.add(springListener);
        return this;
    }

    public List<Spring> d() {
        return this.f32498c;
    }

    public SpringConfig e() {
        return this.f32501f;
    }

    public Spring f() {
        return this.f32498c.get(this.f32499d);
    }

    public SpringConfig g() {
        return this.f32500e;
    }

    public SpringChain h(int i6) {
        this.f32499d = i6;
        if (this.f32498c.get(i6) == null) {
            return null;
        }
        Iterator<Spring> it = this.f32496a.f().iterator();
        while (it.hasNext()) {
            it.next().B(this.f32501f);
        }
        f().B(this.f32500e);
        return this;
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringActivate(Spring spring) {
        this.f32497b.get(this.f32498c.indexOf(spring)).onSpringActivate(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringAtRest(Spring spring) {
        this.f32497b.get(this.f32498c.indexOf(spring)).onSpringAtRest(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringEndStateChange(Spring spring) {
        this.f32497b.get(this.f32498c.indexOf(spring)).onSpringEndStateChange(spring);
    }

    @Override // com.facebook.rebound.SpringListener
    public void onSpringUpdate(Spring spring) {
        int i6;
        int i7;
        int indexOf = this.f32498c.indexOf(spring);
        SpringListener springListener = this.f32497b.get(indexOf);
        int i8 = this.f32499d;
        if (indexOf == i8) {
            i7 = indexOf - 1;
            i6 = indexOf + 1;
        } else if (indexOf < i8) {
            i7 = indexOf - 1;
            i6 = -1;
        } else {
            i6 = indexOf > i8 ? indexOf + 1 : -1;
            i7 = -1;
        }
        if (i6 > -1 && i6 < this.f32498c.size()) {
            this.f32498c.get(i6).x(spring.f());
        }
        if (i7 > -1 && i7 < this.f32498c.size()) {
            this.f32498c.get(i7).x(spring.f());
        }
        springListener.onSpringUpdate(spring);
    }
}
