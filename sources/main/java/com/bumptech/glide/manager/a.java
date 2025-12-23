package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
class a implements l {

    /* renamed from: a, reason: collision with root package name */
    private final Set<m> f15790a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private boolean f15791b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f15792c;

    void c() {
        this.f15792c = true;
        Iterator it = com.bumptech.glide.util.l.k(this.f15790a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onDestroy();
        }
    }

    void d() {
        this.f15791b = true;
        Iterator it = com.bumptech.glide.util.l.k(this.f15790a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    void e() {
        this.f15791b = false;
        Iterator it = com.bumptech.glide.util.l.k(this.f15790a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.l
    public void a(@NonNull m mVar) {
        this.f15790a.remove(mVar);
    }

    @Override // com.bumptech.glide.manager.l
    public void b(@NonNull m mVar) {
        this.f15790a.add(mVar);
        if (this.f15792c) {
            mVar.onDestroy();
        } else if (this.f15791b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    a() {
    }
}
