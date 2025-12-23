package com.bytedance.sdk.component.oq;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* loaded from: D:\Downloads\app\classes4.dex */
public class tl<V> extends FutureTask<V> implements Comparable<tl<V>> {

    /* renamed from: j, reason: collision with root package name */
    private int f26667j;
    private int xt;

    public tl(Callable<V> callable, int i6, int i7) {
        super(callable);
        this.f26667j = i6 == -1 ? 5 : i6;
        this.xt = i7;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(tl tlVar) {
        if (j() < tlVar.j()) {
            return 1;
        }
        return j() > tlVar.j() ? -1 : 0;
    }

    public int j() {
        return this.f26667j;
    }

    public tl(Runnable runnable, V v5, int i6, int i7) {
        super(runnable, v5);
        this.f26667j = i6 == -1 ? 5 : i6;
        this.xt = i7;
    }
}
