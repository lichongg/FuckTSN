package com.bytedance.embedapplog;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
class x extends kt {
    private static final long[] xt = {60000};
    private long cw;

    /* renamed from: r, reason: collision with root package name */
    private boolean f24099r;

    public void j(boolean z5) {
        this.f24099r = z5;
    }

    @Override // com.bytedance.embedapplog.kt
    long j() {
        long x5 = this.f24007j.r().x();
        if (x5 > 60000 || x5 <= 0) {
            x5 = 60000;
        }
        xt[0] = x5;
        return this.cw + x5;
    }

    @Override // com.bytedance.embedapplog.kt
    String r() {
        return "s";
    }

    @Override // com.bytedance.embedapplog.kt
    long[] xt() {
        return xt;
    }

    x(f fVar) {
        super(fVar);
        this.f24099r = true;
    }

    @Override // com.bytedance.embedapplog.kt
    public boolean cw() {
        Bundle j6;
        long currentTimeMillis = System.currentTimeMillis();
        ch ae = this.f24007j.ae();
        if (ae != null && (j6 = ae.j(currentTimeMillis, 50000L)) != null) {
            j.j("play_session", j6, 1);
            j.xt();
        }
        sm cw = this.f24007j.cw();
        wq up = this.f24007j.up();
        if (up.qv() != 0) {
            JSONObject xt2 = ri.xt(up.j());
            if (xt2 != null) {
                j(cw.j(xt2));
                this.cw = System.currentTimeMillis();
                return true;
            }
            uc.xt((Throwable) null);
        }
        return false;
    }

    private void j(ArrayList<zz> arrayList) {
        int i6;
        sm cw = this.f24007j.cw();
        ArrayList<zz> arrayList2 = new ArrayList<>();
        ArrayList<zz> arrayList3 = new ArrayList<>();
        rn r5 = this.f24007j.r();
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<zz> j6 = cw.j();
        if (!j6.isEmpty()) {
            arrayList4.addAll(j6);
        }
        if (arrayList4.size() > 0) {
            Iterator it = arrayList4.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                zz zzVar = (zz) it.next();
                byte[] bArr = zzVar.vl;
                if (bArr != null && bArr.length > 0) {
                    if (this.f24099r) {
                        f fVar = this.f24007j;
                        i6 = q.j(qb.j(fVar, fVar.xt(), this.f24007j.up().j()), zzVar.vl, r5);
                    } else {
                        i6 = 200;
                    }
                    if (q.j(i6)) {
                        if (arrayList.contains(zzVar)) {
                            zzVar.ws = i6;
                            arrayList3.add(zzVar);
                        }
                    } else if (i6 == 200) {
                        arrayList2.add(zzVar);
                    } else {
                        zzVar.ws = i6;
                        arrayList3.add(zzVar);
                    }
                } else {
                    arrayList2.add(zzVar);
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                cw.j(arrayList2, arrayList3, arrayList);
            }
            uc.r(r() + " " + arrayList2.size() + " " + arrayList4.size(), null);
        }
    }
}
