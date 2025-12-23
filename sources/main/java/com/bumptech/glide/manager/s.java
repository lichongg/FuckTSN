package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class s {

    /* renamed from: d, reason: collision with root package name */
    private static final String f15825d = "RequestTracker";

    /* renamed from: a, reason: collision with root package name */
    private final Set<com.bumptech.glide.request.e> f15826a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final List<com.bumptech.glide.request.e> f15827b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private boolean f15828c;

    public boolean b(@Nullable com.bumptech.glide.request.e eVar) {
        boolean z5 = true;
        if (eVar == null) {
            return true;
        }
        boolean remove = this.f15826a.remove(eVar);
        if (!this.f15827b.remove(eVar) && !remove) {
            z5 = false;
        }
        if (z5) {
            eVar.clear();
        }
        return z5;
    }

    public void e() {
        this.f15828c = true;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.k(this.f15826a)) {
            if (eVar.isRunning() || eVar.isComplete()) {
                eVar.clear();
                this.f15827b.add(eVar);
            }
        }
    }

    public void f() {
        this.f15828c = true;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.k(this.f15826a)) {
            if (eVar.isRunning()) {
                eVar.pause();
                this.f15827b.add(eVar);
            }
        }
    }

    public void h() {
        this.f15828c = false;
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.k(this.f15826a)) {
            if (!eVar.isComplete() && !eVar.isRunning()) {
                eVar.h();
            }
        }
        this.f15827b.clear();
    }

    @VisibleForTesting
    void a(com.bumptech.glide.request.e eVar) {
        this.f15826a.add(eVar);
    }

    public void c() {
        Iterator it = com.bumptech.glide.util.l.k(this.f15826a).iterator();
        while (it.hasNext()) {
            b((com.bumptech.glide.request.e) it.next());
        }
        this.f15827b.clear();
    }

    public boolean d() {
        return this.f15828c;
    }

    public void g() {
        for (com.bumptech.glide.request.e eVar : com.bumptech.glide.util.l.k(this.f15826a)) {
            if (!eVar.isComplete() && !eVar.e()) {
                eVar.clear();
                if (this.f15828c) {
                    this.f15827b.add(eVar);
                } else {
                    eVar.h();
                }
            }
        }
    }

    public void i(@NonNull com.bumptech.glide.request.e eVar) {
        this.f15826a.add(eVar);
        if (!this.f15828c) {
            eVar.h();
            return;
        }
        eVar.clear();
        Log.isLoggable(f15825d, 2);
        this.f15827b.add(eVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f15826a.size() + ", isPaused=" + this.f15828c + "}";
    }
}
