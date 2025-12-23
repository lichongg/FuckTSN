package com.bytedance.sdk.component.tl.xt.up;

import java.util.UUID;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class xt implements Comparable<xt>, Runnable {
    private String cw;

    /* renamed from: j, reason: collision with root package name */
    private int f26802j = 5;
    private String xt = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public void j(int i6) {
        this.f26802j = i6;
    }

    public int j() {
        return this.f26802j;
    }

    public xt(String str) {
        this.cw = str;
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(xt xtVar) {
        if (j() < xtVar.j()) {
            return 1;
        }
        return j() >= xtVar.j() ? -1 : 0;
    }
}
