package com.bytedance.j.cw.j.xt;

import com.bytedance.j.cw.j.xt.xt;
import java.util.UUID;

/* loaded from: D:\Downloads\app\classes3.dex */
public abstract class a implements xt, Comparable<a>, Runnable {

    /* renamed from: a, reason: collision with root package name */
    private xt.j f24115a = xt.j.NORMAL;

    /* renamed from: b, reason: collision with root package name */
    private String f24116b = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public xt.j b() {
        return this.f24115a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (b().j() < aVar.b().j()) {
            return 1;
        }
        if (b().j() > aVar.b().j()) {
            return -1;
        }
        return 0;
    }
}
