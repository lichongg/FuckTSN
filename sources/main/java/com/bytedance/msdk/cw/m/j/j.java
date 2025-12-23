package com.bytedance.msdk.cw.m.j;

import android.text.TextUtils;
import com.bytedance.msdk.core.oq.oq;
import com.bytedance.msdk.cw.tl.m;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.msdk.tl.p;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private List<Integer> qv;
    private AtomicInteger cw = new AtomicInteger(-1);

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f25010r = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    public final Map<Integer, Boolean> f25008j = new HashMap();
    public final Map<Integer, Boolean> xt = new HashMap();
    private final Map<Integer, AtomicInteger> up = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    private final AtomicInteger f25009m = new AtomicInteger();
    private final AtomicInteger ae = new AtomicInteger();
    private final AtomicInteger tl = new AtomicInteger();

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f25007g = new CopyOnWriteArrayList();
    private final AtomicInteger oq = new AtomicInteger(-1000);

    public synchronized boolean ae() {
        AtomicInteger atomicInteger = this.up.get(0);
        if (atomicInteger != null) {
            if (atomicInteger.get() != 0) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean cw() {
        return xt() > 0;
    }

    public synchronized boolean g() {
        return this.ae.get() == 0;
    }

    public List<Integer> j() {
        return this.qv;
    }

    public synchronized boolean m() {
        AtomicInteger atomicInteger = this.up.get(-100);
        if (atomicInteger != null) {
            if (atomicInteger.get() != 0) {
                return false;
            }
        }
        return true;
    }

    public synchronized boolean oq() {
        return this.tl.get() == 0;
    }

    public synchronized int qv() {
        return this.oq.get();
    }

    public synchronized void r(int i6) {
        this.xt.put(Integer.valueOf(i6), Boolean.TRUE);
    }

    public synchronized boolean tl() {
        return this.f25009m.get() == 0;
    }

    public synchronized boolean up(int i6) {
        Boolean bool = this.xt.get(Integer.valueOf(i6));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void vl() {
        this.cw.set(-1);
        this.f25010r.set(false);
        this.f25008j.clear();
        this.xt.clear();
        this.up.clear();
        this.f25009m.set(0);
        this.f25007g.clear();
        this.oq.set(-1000);
    }

    public synchronized int xt() {
        return this.cw.get();
    }

    public synchronized boolean cw(int i6) {
        Boolean bool = this.f25008j.get(Integer.valueOf(i6));
        if (bool != null) {
            if (bool.booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void g(int i6) {
        this.tl.set(i6);
    }

    public void j(List<Integer> list) {
        this.qv = list;
    }

    public synchronized void tl(int i6) {
        this.ae.set(i6);
    }

    public synchronized void xt(int i6) {
        try {
            if (this.oq.get() < i6) {
                this.oq.set(i6);
            }
            this.f25008j.put(Integer.valueOf(i6), Boolean.TRUE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(int i6) {
        this.cw.set(i6);
    }

    public synchronized void r() {
        this.f25010r.set(true);
    }

    public synchronized void ae(int i6) {
        this.f25009m.set(i6);
    }

    public synchronized void j(int i6, int i7) {
        this.up.put(Integer.valueOf(i6), new AtomicInteger(i7));
    }

    public synchronized int m(int i6) {
        AtomicInteger atomicInteger = this.up.get(Integer.valueOf(i6));
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public synchronized boolean up() {
        return this.f25010r.get();
    }

    public synchronized void j(int i6, String str) {
        try {
            AtomicInteger atomicInteger = this.up.get(Integer.valueOf(i6));
            if (atomicInteger != null && atomicInteger.get() != 0) {
                atomicInteger.decrementAndGet();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f25007g.add(str);
            if (i6 < -100 && this.ae.get() != 0) {
                this.ae.decrementAndGet();
            }
            if (i6 > 0 && this.tl.get() != 0) {
                this.tl.decrementAndGet();
            }
            if (this.f25009m.get() != 0) {
                this.f25009m.decrementAndGet();
            } else {
                cw.r(MediationConstant.TAG, "decrementTotalWaterFall--waterfall数量减少一个 ---不用再减了不然就变成-1了");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void j(List<oq> list, List<oq> list2, List<oq> list3) {
        int i6;
        if (list != null) {
            try {
                if (list.size() != 0) {
                    List<oq> xt = m.xt(list);
                    int i7 = 0;
                    if (p.j(xt)) {
                        i6 = 0;
                    } else {
                        i6 = xt.size();
                        for (oq oqVar : xt) {
                            Iterator<String> it = this.f25007g.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String next = it.next();
                                    if (!TextUtils.isEmpty(next) && oqVar != null && next.equals(oqVar.w())) {
                                        i6--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (i6 < 0) {
                        i6 = 0;
                    }
                    this.tl.set(i6);
                    int size = list.size();
                    if (list2 != null) {
                        size += list2.size();
                    }
                    if (list3 != null) {
                        size += list3.size();
                    }
                    for (oq oqVar2 : list) {
                        Iterator<String> it2 = this.f25007g.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                String next2 = it2.next();
                                if (!TextUtils.isEmpty(next2) && oqVar2 != null && next2.equals(oqVar2.w())) {
                                    size--;
                                    break;
                                }
                            }
                        }
                    }
                    if (!p.j(list2)) {
                        for (oq oqVar3 : list2) {
                            Iterator<String> it3 = this.f25007g.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    String next3 = it3.next();
                                    if (!TextUtils.isEmpty(next3) && oqVar3 != null && next3.equals(oqVar3.w())) {
                                        size--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (!p.j(list3)) {
                        for (oq oqVar4 : list3) {
                            Iterator<String> it4 = this.f25007g.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    String next4 = it4.next();
                                    if (!TextUtils.isEmpty(next4) && oqVar4 != null && next4.equals(oqVar4.w())) {
                                        size--;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (size >= 0) {
                        i7 = size;
                    }
                    this.f25009m.set(i7);
                }
            } finally {
            }
        }
    }
}
