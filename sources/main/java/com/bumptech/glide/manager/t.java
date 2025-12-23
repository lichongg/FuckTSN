package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class t implements m {

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.target.p<?>> f15829a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f15829a.clear();
    }

    @NonNull
    public List<com.bumptech.glide.request.target.p<?>> c() {
        return com.bumptech.glide.util.l.k(this.f15829a);
    }

    public void e(@NonNull com.bumptech.glide.request.target.p<?> pVar) {
        this.f15829a.add(pVar);
    }

    public void f(@NonNull com.bumptech.glide.request.target.p<?> pVar) {
        this.f15829a.remove(pVar);
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
        Iterator it = com.bumptech.glide.util.l.k(this.f15829a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.p) it.next()).onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        Iterator it = com.bumptech.glide.util.l.k(this.f15829a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.p) it.next()).onStart();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
        Iterator it = com.bumptech.glide.util.l.k(this.f15829a).iterator();
        while (it.hasNext()) {
            ((com.bumptech.glide.request.target.p) it.next()).onStop();
        }
    }
}
