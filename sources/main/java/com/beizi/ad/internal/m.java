package com.beizi.ad.internal;

import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class m implements f {

    /* renamed from: a, reason: collision with root package name */
    private LinkedList<com.beizi.ad.internal.d.a> f12277a;

    /* renamed from: b, reason: collision with root package name */
    private long f12278b = -1;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f12279c = new ArrayList<>();

    @Override // com.beizi.ad.internal.f
    public long a(long j6) {
        long j7 = this.f12278b;
        if (j7 > 0) {
            return j6 - j7;
        }
        return -1L;
    }

    public abstract void e();

    protected void a(LinkedList<com.beizi.ad.internal.d.a> linkedList) {
        this.f12277a = linkedList;
    }

    @Override // com.beizi.ad.internal.f
    public LinkedList<com.beizi.ad.internal.d.a> b() {
        return this.f12277a;
    }

    protected void h() {
        this.f12279c.clear();
    }

    protected com.beizi.ad.internal.d.a i() {
        LinkedList<com.beizi.ad.internal.d.a> linkedList = this.f12277a;
        if (linkedList == null || linkedList.getFirst() == null) {
            return null;
        }
        this.f12279c.add(this.f12277a.getFirst().a());
        return this.f12277a.removeFirst();
    }

    public void g() {
        this.f12278b = System.currentTimeMillis();
    }
}
