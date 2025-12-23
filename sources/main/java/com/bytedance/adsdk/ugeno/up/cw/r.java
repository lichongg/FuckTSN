package com.bytedance.adsdk.ugeno.up.cw;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r extends xt {
    private AtomicBoolean av;
    private int az;

    /* renamed from: i, reason: collision with root package name */
    private String f23740i;
    private int jy;
    private float qv;
    private float vl;

    /* renamed from: w, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.cw.xt.j f23741w;
    private int ws;

    @Override // com.bytedance.adsdk.ugeno.up.cw.xt
    public boolean j(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.up;
        if (map != null) {
            this.f23740i = TextUtils.isEmpty(map.get("direction")) ? "all" : this.up.get("direction");
            this.jy = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("distance"), 0);
            if (this.ws == Integer.MAX_VALUE) {
                this.ws = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.az == Integer.MAX_VALUE) {
                this.az = com.bytedance.adsdk.ugeno.m.cw.j(this.up.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.av.get();
        }
        com.bytedance.adsdk.ugeno.xt.cw cwVar = this.xt;
        if (cwVar != null && cwVar.q() && this.f23741w == null) {
            this.f23741w = new com.bytedance.adsdk.ugeno.cw.xt.j();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        j();
        return j(this.xt, motionEvent);
    }

    private void cw(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        if (this.ws <= 0) {
            xt(cwVar);
            return;
        }
        if (!this.av.get()) {
            xt(cwVar);
            return;
        }
        this.f23743j.j(cwVar, this.f23744m, this.cw.xt());
        int i6 = this.ws;
        if (i6 != Integer.MAX_VALUE) {
            this.ws = i6 - 1;
        }
    }

    private void xt(com.bytedance.adsdk.ugeno.xt.cw cwVar) {
        com.bytedance.adsdk.ugeno.cw.xt.j jVar = this.f23741w;
        if (jVar != null) {
            jVar.j(cwVar);
        }
    }

    public r(Context context) {
        super(context);
        this.jy = 0;
        this.ws = Integer.MAX_VALUE;
        this.az = Integer.MAX_VALUE;
        this.av = new AtomicBoolean(true);
        this.f23740i = "up";
    }

    private void j() {
        if (this.az == Integer.MAX_VALUE || this.xt == null || System.currentTimeMillis() - this.xt.v() < this.az) {
            return;
        }
        this.av.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r3.equals("right") != false) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean j(com.bytedance.adsdk.ugeno.xt.cw r10, android.view.MotionEvent r11) {
        /*
            r9 = this;
            com.bytedance.adsdk.ugeno.cw.xt.j r0 = r9.f23741w
            r1 = 0
            if (r0 == 0) goto L11
            boolean r0 = r0.j(r11)
            if (r0 == 0) goto Lc
            return r1
        Lc:
            com.bytedance.adsdk.ugeno.cw.xt.j r0 = r9.f23741w
            r0.j(r10, r11)
        L11:
            int r0 = r11.getAction()
            r2 = 1
            if (r0 == 0) goto La8
            if (r0 == r2) goto L1f
            r3 = 3
            if (r0 == r3) goto L1f
            goto Lb4
        L1f:
            float r0 = r11.getX()
            float r11 = r11.getY()
            int r3 = r9.jy
            if (r3 != 0) goto L33
            com.bytedance.adsdk.ugeno.up.qv r3 = r9.f23743j
            if (r3 == 0) goto L33
            r9.cw(r10)
            return r2
        L33:
            android.content.Context r3 = r9.oq
            float r4 = r9.qv
            float r0 = r0 - r4
            int r0 = com.bytedance.adsdk.ugeno.m.tl.xt(r3, r0)
            android.content.Context r3 = r9.oq
            float r4 = r9.vl
            float r11 = r11 - r4
            int r11 = com.bytedance.adsdk.ugeno.m.tl.xt(r3, r11)
            java.lang.String r3 = r9.f23740i
            int r4 = r3.hashCode()
            switch(r4) {
                case 3739: goto L73;
                case 96673: goto L6c;
                case 3089570: goto L62;
                case 3317767: goto L58;
                case 108511772: goto L4f;
                default: goto L4e;
            }
        L4e:
            goto L7d
        L4f:
            java.lang.String r4 = "right"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L7d
            goto L93
        L58:
            java.lang.String r4 = "left"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L7d
            int r0 = -r0
            goto L93
        L62:
            java.lang.String r4 = "down"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L7d
            r0 = r11
            goto L93
        L6c:
            java.lang.String r4 = "all"
            boolean r3 = r3.equals(r4)
            goto L7d
        L73:
            java.lang.String r4 = "up"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L7d
            int r0 = -r11
            goto L93
        L7d:
            double r3 = (double) r0
            r5 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = java.lang.Math.pow(r3, r5)
            double r7 = (double) r11
            double r5 = java.lang.Math.pow(r7, r5)
            double r3 = r3 + r5
            double r3 = java.lang.Math.sqrt(r3)
            double r3 = java.lang.Math.abs(r3)
            int r0 = (int) r3
        L93:
            int r11 = r9.jy
            if (r0 < r11) goto La4
            com.bytedance.adsdk.ugeno.up.qv r11 = r9.f23743j
            if (r11 == 0) goto Lb4
            r11 = 0
            r9.qv = r11
            r9.vl = r11
            r9.cw(r10)
            return r2
        La4:
            r9.xt(r10)
            return r1
        La8:
            float r10 = r11.getX()
            r9.qv = r10
            float r10 = r11.getY()
            r9.vl = r10
        Lb4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.up.cw.r.j(com.bytedance.adsdk.ugeno.xt.cw, android.view.MotionEvent):boolean");
    }
}
