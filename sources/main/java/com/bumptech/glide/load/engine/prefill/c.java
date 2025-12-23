package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<d, Integer> f15339a;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f15340b;

    /* renamed from: c, reason: collision with root package name */
    private int f15341c;

    /* renamed from: d, reason: collision with root package name */
    private int f15342d;

    public int a() {
        return this.f15341c;
    }

    public boolean b() {
        return this.f15341c == 0;
    }

    public d c() {
        d dVar = this.f15340b.get(this.f15342d);
        Integer num = this.f15339a.get(dVar);
        if (num.intValue() == 1) {
            this.f15339a.remove(dVar);
            this.f15340b.remove(this.f15342d);
        } else {
            this.f15339a.put(dVar, Integer.valueOf(num.intValue() - 1));
        }
        this.f15341c--;
        this.f15342d = this.f15340b.isEmpty() ? 0 : (this.f15342d + 1) % this.f15340b.size();
        return dVar;
    }

    public c(Map<d, Integer> map) {
        this.f15339a = map;
        this.f15340b = new ArrayList(map.keySet());
        Iterator<Integer> it = map.values().iterator();
        while (it.hasNext()) {
            this.f15341c += it.next().intValue();
        }
    }
}
