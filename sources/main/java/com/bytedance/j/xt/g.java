package com.bytedance.j.xt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private Map<cw, List<b>> f24191a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f24192b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final List<Object> f24193c = new CopyOnWriteArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final List<Object> f24194d = new CopyOnWriteArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final List<Object> f24195e = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<Object> f24196f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private c f24197g = null;

    @NonNull
    public List<Object> a() {
        return this.f24196f;
    }

    @Nullable
    public List<b> b(cw cwVar) {
        return this.f24191a.get(cwVar);
    }

    public Map<String, String> c() {
        return this.f24192b;
    }

    void d(c cVar) {
        this.f24197g = cVar;
    }

    void e(Map<? extends String, ? extends String> map) {
        this.f24192b.putAll(map);
    }

    @Nullable
    public c f() {
        return this.f24197g;
    }

    @NonNull
    public List<Object> g() {
        return this.f24194d;
    }
}
