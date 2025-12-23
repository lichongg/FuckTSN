package com.bytedance.adsdk.ugeno.cw;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv implements ae {
    private vl ae;
    private AtomicInteger cw;

    /* renamed from: g, reason: collision with root package name */
    private mi f23617g;

    /* renamed from: j, reason: collision with root package name */
    private AtomicInteger f23618j;

    /* renamed from: m, reason: collision with root package name */
    private float f23619m;

    /* renamed from: r, reason: collision with root package name */
    private AtomicInteger f23620r;
    private f tl;
    private AtomicInteger up;
    private AtomicInteger xt;

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if ((TextUtils.equals(str, "src") || TextUtils.equals(str, "backgroundImage")) && str2.startsWith(b.f50154a)) {
            this.xt.incrementAndGet();
        }
    }

    public int xt() {
        int i6 = (int) (this.f23619m * this.xt.get());
        this.f23618j.set(i6);
        return i6;
    }

    public boolean cw() {
        return this.f23618j.get() > 0;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.ae
    public void xt(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str) {
        int incrementAndGet = this.up.incrementAndGet();
        if (incrementAndGet > this.xt.get() - this.f23618j.get()) {
            synchronized (this) {
                try {
                    if (incrementAndGet > this.xt.get() - this.f23618j.get() && this.f23617g != null) {
                        tj tjVar = new tj();
                        tjVar.j(-3);
                        tjVar.j("image download fail");
                        tjVar.j(cwVar.xt(cwVar));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void j(mi miVar) {
        this.f23617g = miVar;
    }

    public void j(f fVar) {
        this.tl = fVar;
    }

    @Override // com.bytedance.adsdk.ugeno.cw.ae
    public void j() {
        this.f23620r.incrementAndGet();
        if (this.f23620r.get() == 1) {
            synchronized (this) {
                this.f23620r.get();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.cw.ae
    public void j(com.bytedance.adsdk.ugeno.xt.cw cwVar, String str) {
        if (this.cw.incrementAndGet() == this.f23618j.get()) {
            synchronized (this) {
                try {
                    if (this.cw.get() == this.f23618j.get()) {
                        if (this.ae != null) {
                            this.xt.get();
                        }
                        if (this.f23617g != null) {
                            tj tjVar = new tj();
                            tjVar.j(0);
                            tjVar.j(cwVar.xt(cwVar));
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
