package com.zhy.view.flowlayout;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name */
    private List<T> f42964a;

    /* renamed from: b, reason: collision with root package name */
    private a f42965b;

    /* renamed from: c, reason: collision with root package name */
    private HashSet<Integer> f42966c = new HashSet<>();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface a {
        void a();
    }

    public b(List<T> list) {
        this.f42964a = list;
    }

    public abstract View d(FlowLayout flowLayout, int i6, T t5);

    public boolean g(int i6, T t5) {
        return false;
    }

    public void i(int... iArr) {
        for (int i6 : iArr) {
            this.f42966c.add(Integer.valueOf(i6));
        }
        e();
    }

    public int a() {
        List<T> list = this.f42964a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T b(int i6) {
        return this.f42964a.get(i6);
    }

    HashSet<Integer> c() {
        return this.f42966c;
    }

    public void e() {
        this.f42965b.a();
    }

    void f(a aVar) {
        this.f42965b = aVar;
    }

    public void h(Set<Integer> set) {
        this.f42966c.clear();
        if (set != null) {
            this.f42966c.addAll(set);
        }
        e();
    }

    public b(T[] tArr) {
        this.f42964a = new ArrayList(Arrays.asList(tArr));
    }
}
