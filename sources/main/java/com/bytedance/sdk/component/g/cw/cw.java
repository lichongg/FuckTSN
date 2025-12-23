package com.bytedance.sdk.component.g.cw;

import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {

    /* renamed from: j, reason: collision with root package name */
    public boolean f26420j = false;
    public boolean xt = true;
    public Map<String, Integer> cw = null;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f26422r = null;
    public int up = 10;

    /* renamed from: m, reason: collision with root package name */
    public int f26421m = 1;
    public int ae = 1;
    public int tl = 10;

    /* renamed from: g, reason: collision with root package name */
    public int f26419g = 1;
    public int oq = 1;
    public int qv = 900;
    public int vl = 120;
    public String jy = null;
    public int ws = 0;
    public long az = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.f26420j);
        sb.append(" probeEnable: ");
        sb.append(this.xt);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.cw;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.f26422r;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.up);
        sb.append("#");
        sb.append(this.f26421m);
        sb.append("#");
        sb.append(this.ae);
        sb.append(" reqErr: ");
        sb.append(this.tl);
        sb.append("#");
        sb.append(this.f26419g);
        sb.append("#");
        sb.append(this.oq);
        sb.append(" updateInterval: ");
        sb.append(this.qv);
        sb.append(" updateRandom: ");
        sb.append(this.vl);
        sb.append(" httpBlack: ");
        sb.append(this.jy);
        return sb.toString();
    }
}
