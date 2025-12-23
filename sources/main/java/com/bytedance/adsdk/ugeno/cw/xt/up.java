package com.bytedance.adsdk.ugeno.cw.xt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.adsdk.ugeno.cw.av;
import com.bytedance.adsdk.ugeno.cw.w;
import com.bytedance.adsdk.ugeno.m.tl;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes3.dex */
public class up {
    private av ae;

    /* renamed from: g, reason: collision with root package name */
    private String f23634g;
    private j jy;
    private Context oq;
    private boolean qv;
    private av tl;
    private boolean vl;

    /* renamed from: j, reason: collision with root package name */
    private float f23635j = Float.MIN_VALUE;
    private float xt = Float.MIN_VALUE;
    private int cw = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f23637r = Integer.MAX_VALUE;
    private int up = Integer.MAX_VALUE;

    /* renamed from: m, reason: collision with root package name */
    private AtomicBoolean f23636m = new AtomicBoolean(true);

    public up(Context context, av avVar, boolean z5, boolean z6) {
        this.oq = context;
        this.ae = avVar;
        this.qv = z5;
        this.vl = z6;
        cw();
    }

    public void xt() {
        this.f23635j = Float.MIN_VALUE;
        this.xt = Float.MIN_VALUE;
    }

    private void cw() {
        if (this.vl) {
            this.jy = new j();
        }
        av avVar = this.ae;
        if (avVar == null) {
            return;
        }
        this.cw = avVar.cw().optInt("slideThreshold");
        this.f23634g = this.ae.cw().optString("slideDirection");
        this.f23637r = this.ae.cw().optInt("frequency", Integer.MAX_VALUE);
        this.up = this.ae.cw().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.f23636m.get();
    }

    public void j() {
        if (this.up == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.cw.xt.up.1
            @Override // java.lang.Runnable
            public void run() {
                up.this.f23636m.set(false);
            }
        }, this.up);
    }

    public boolean j(w wVar, com.bytedance.adsdk.ugeno.xt.cw cwVar, MotionEvent motionEvent, boolean z5) {
        j jVar = this.jy;
        if (jVar != null) {
            if (jVar.j(motionEvent)) {
                return false;
            }
            this.jy.j(cwVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 3) {
                    if (this.f23635j == Float.MIN_VALUE || this.xt == Float.MIN_VALUE) {
                        return false;
                    }
                }
            }
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            if (this.qv && Math.abs(x5 - this.f23635j) <= 10.0f && Math.abs(y5 - this.xt) <= 10.0f && wVar != null) {
                xt();
                wVar.j(this.tl, cwVar, cwVar);
                return true;
            }
            if (this.cw == 0 && wVar != null) {
                xt();
                j(wVar, this.ae, cwVar);
                return true;
            }
            int xt = tl.xt(this.oq, x5 - this.f23635j);
            int xt2 = tl.xt(this.oq, y5 - this.xt);
            if (TextUtils.equals(this.f23634g, "up")) {
                xt = -xt2;
            } else if (TextUtils.equals(this.f23634g, ScrollClickView.DIR_DOWN)) {
                xt = xt2;
            } else if (TextUtils.equals(this.f23634g, ScrollClickView.DIR_LEFT)) {
                xt = -xt;
            } else if (!TextUtils.equals(this.f23634g, "right")) {
                xt = (int) Math.abs(Math.sqrt(Math.pow(xt, 2.0d) + Math.pow(xt2, 2.0d)));
            }
            if (xt < this.cw) {
                xt();
                j(cwVar);
                return false;
            }
            if (wVar != null) {
                xt();
                j(wVar, this.ae, cwVar);
                return true;
            }
            xt();
        } else {
            this.f23635j = motionEvent.getX();
            this.xt = motionEvent.getY();
        }
        return true;
    }

    public up(Context context, av avVar, av avVar2, boolean z5, boolean z6) {
        this.oq = context;
        this.ae = avVar;
        this.tl = avVar2;
        this.qv = z5;
        this.vl = z6;
        cw();
    }

    private void j(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        j jVar = this.jy;
        if (jVar != null) {
            jVar.j(cwVar);
        }
    }

    private void j(w wVar, av avVar, com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (this.f23637r <= 0) {
            j(cwVar);
            return;
        }
        if (!this.f23636m.get()) {
            j(cwVar);
            return;
        }
        wVar.j(avVar, cwVar, cwVar);
        int i6 = this.f23637r;
        if (i6 != Integer.MAX_VALUE) {
            this.f23637r = i6 - 1;
        }
    }
}
