package com.bytedance.embedapplog;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ch {
    private static j az;

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicLong f23980m = new AtomicLong(1000);
    private long ae;
    private kc cw;

    /* renamed from: g, reason: collision with root package name */
    private long f23981g = -1;

    /* renamed from: j, reason: collision with root package name */
    private final rn f23982j;
    private String jy;
    private volatile boolean oq;
    private long qv;

    /* renamed from: r, reason: collision with root package name */
    private kc f23983r;
    private int tl;
    private String up;
    private int vl;
    private ry ws;
    private final wq xt;

    /* renamed from: com.bytedance.embedapplog.ch$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static class j extends aq {
        private j() {
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public String j() {
        return this.up;
    }

    public boolean xt() {
        return this.oq;
    }

    public static long r() {
        return f23980m.incrementAndGet();
    }

    static j up() {
        if (az == null) {
            az = new j(null);
        }
        az.xt = System.currentTimeMillis();
        return az;
    }

    synchronized Bundle j(long j6, long j7) {
        Bundle bundle;
        if (this.f23982j.up() && cw()) {
            long j8 = this.ae;
            if (j8 > 0 && j6 - j8 > j7) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.vl);
                int i6 = this.tl + 1;
                this.tl = i6;
                bundle.putInt("send_times", i6);
                bundle.putLong("current_duration", (j6 - this.ae) / 1000);
                bundle.putString(com.umeng.analytics.pro.u.f41448a, ya.xt(this.f23981g));
                this.ae = j6;
            }
        }
        bundle = null;
        return bundle;
    }

    public void xt(ya yaVar) {
        if (yaVar != null) {
            if (this.f23982j.tj()) {
                yaVar.tl = com.bytedance.embedapplog.j.up();
            }
            yaVar.f24106m = com.bytedance.embedapplog.j.oq();
            yaVar.ae = com.bytedance.embedapplog.j.g();
            yaVar.f24107r = this.up;
            yaVar.cw = r();
        }
    }

    ch(wq wqVar, rn rnVar) {
        this.xt = wqVar;
        this.f23982j = rnVar;
    }

    boolean cw() {
        if (xt() && this.qv == 0) {
            return true;
        }
        return false;
    }

    private synchronized void j(ya yaVar, ArrayList<ya> arrayList, boolean z5) {
        try {
            long j6 = yaVar instanceof j ? -1L : yaVar.xt;
            this.up = UUID.randomUUID().toString();
            f23980m.set(1000L);
            this.f23981g = j6;
            this.oq = z5;
            this.qv = 0L;
            this.ae = 0L;
            if (uc.xt) {
                uc.j("startSession, " + this.up + ", hadUi:" + z5 + " data:" + yaVar, null);
            }
            if (z5) {
                Calendar calendar = Calendar.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append(calendar.get(1));
                sb.append(calendar.get(2));
                sb.append(calendar.get(5));
                String sb2 = sb.toString();
                if (TextUtils.isEmpty(this.jy)) {
                    this.jy = this.f23982j.xt();
                    this.vl = this.f23982j.cw();
                }
                if (!sb2.equals(this.jy)) {
                    this.jy = sb2;
                    this.vl = 1;
                } else {
                    this.vl++;
                }
                this.f23982j.j(sb2, this.vl);
                this.tl = 0;
                this.ae = yaVar.xt;
            }
            if (j6 != -1) {
                ry ryVar = new ry(false);
                ryVar.f24107r = this.up;
                ryVar.cw = r();
                ryVar.xt = this.f23981g;
                ryVar.ws = !this.oq;
                ryVar.jy = this.xt.cw();
                ryVar.vl = this.xt.xt();
                ryVar.f24106m = com.bytedance.embedapplog.j.oq();
                ryVar.ae = com.bytedance.embedapplog.j.g();
                if (this.f23982j.tj()) {
                    ryVar.tl = com.bytedance.embedapplog.j.up();
                }
                arrayList.add(ryVar);
                this.ws = ryVar;
                if (uc.xt) {
                    uc.j("gen launch, " + ryVar.f24107r + ", hadUi:" + z5, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean j(ya yaVar) {
        if (yaVar instanceof kc) {
            return ((kc) yaVar).oq();
        }
        return false;
    }

    boolean j(ya yaVar, ArrayList<ya> arrayList) {
        boolean z5 = yaVar instanceof kc;
        boolean j6 = j(yaVar);
        boolean z6 = true;
        if (this.f23981g == -1) {
            j(yaVar, arrayList, j(yaVar));
        } else if (!this.oq && j6) {
            j(yaVar, arrayList, true);
        } else {
            long j7 = this.qv;
            if (j7 == 0 || yaVar.xt <= j7 + this.f23982j.v()) {
                if (this.f23981g > yaVar.xt + 7200000) {
                    j(yaVar, arrayList, j6);
                } else {
                    z6 = false;
                }
            } else if (!ri.xt() && ri.j()) {
                j(yaVar, arrayList, j6);
            }
        }
        if (z5) {
            kc kcVar = (kc) yaVar;
            if (kcVar.oq()) {
                this.qv = 0L;
                arrayList.add(yaVar);
                if (TextUtils.isEmpty(kcVar.jy)) {
                    kc kcVar2 = this.f23983r;
                    if (kcVar2 != null && (kcVar.xt - kcVar2.xt) - kcVar2.vl < 500) {
                        kcVar.jy = kcVar2.ws;
                    } else {
                        kc kcVar3 = this.cw;
                        if (kcVar3 != null && (kcVar.xt - kcVar3.xt) - kcVar3.vl < 500) {
                            kcVar.jy = kcVar3.ws;
                        }
                    }
                }
            } else {
                Bundle j8 = j(yaVar.xt, 0L);
                if (j8 != null) {
                    com.bytedance.embedapplog.j.j("play_session", j8);
                }
                this.qv = kcVar.xt;
                arrayList.add(yaVar);
                if (kcVar.qv()) {
                    this.cw = kcVar;
                } else {
                    this.f23983r = kcVar;
                    this.cw = null;
                }
            }
        } else if (!(yaVar instanceof j)) {
            arrayList.add(yaVar);
        }
        xt(yaVar);
        return z6;
    }
}
