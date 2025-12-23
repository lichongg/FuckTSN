package com.bykv.vk.openvk.component.video.api.cw;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements Serializable {
    private int ae;
    private long av;
    private String az;

    /* renamed from: i, reason: collision with root package name */
    private boolean f22958i;

    /* renamed from: j, reason: collision with root package name */
    public String f22959j;
    private int jy;
    private int kt;

    /* renamed from: m, reason: collision with root package name */
    private String f22960m;
    private int mi;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private cw f22961r;
    private cw up;
    private int vl;

    /* renamed from: w, reason: collision with root package name */
    private boolean f22963w;
    private List<String> ws;
    public int xt;
    private int tl = 204800;

    /* renamed from: g, reason: collision with root package name */
    private int f22957g = 0;
    private int oq = 0;
    public final HashMap<String, Object> cw = new HashMap<>();
    private int tj = 10000;

    /* renamed from: f, reason: collision with root package name */
    private int f22956f = 10000;

    /* renamed from: v, reason: collision with root package name */
    private int f22962v = 10000;

    /* renamed from: x, reason: collision with root package name */
    private int f22964x = 0;
    private JSONObject ch = new JSONObject();

    public boolean ae() {
        return this.f22963w;
    }

    public int cw() {
        return this.ch.optInt("pitaya_code", 0);
    }

    public int g() {
        return this.jy;
    }

    public JSONObject j() {
        return this.ch;
    }

    public int m() {
        if (ws()) {
            return this.up.av();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.av();
        }
        return 0;
    }

    public String r() {
        return this.ch.optString("pitaya_msg");
    }

    public int tl() {
        return this.vl;
    }

    public String up() {
        return this.f22960m;
    }

    public int xt() {
        return this.ch.optInt("pitaya_cache_size", 0);
    }

    public void ae(int i6) {
        this.f22956f = i6;
    }

    public void cw(int i6) {
        this.jy = i6;
    }

    public int f() {
        return this.f22964x;
    }

    public void g(int i6) {
        this.f22964x = i6;
    }

    public void j(String str) {
        this.f22960m = str;
    }

    public int kt() {
        return this.f22956f;
    }

    public int mi() {
        return this.tj;
    }

    public long oq() {
        return this.av;
    }

    public boolean qv() {
        return this.f22958i;
    }

    public void r(String str) {
        this.f22959j = str;
    }

    public int tj() {
        return this.f22962v;
    }

    public void tl(int i6) {
        this.f22962v = i6;
    }

    public void up(int i6) {
        this.mi = i6;
    }

    public cw v() {
        return this.f22961r;
    }

    public int w() {
        return this.mi;
    }

    public boolean ws() {
        cw cwVar;
        if (this.kt != 1 || (cwVar = this.up) == null || TextUtils.isEmpty(cwVar.vl())) {
            return false;
        }
        return com.bykv.vk.openvk.component.video.api.cw.up() == 2 ? Build.VERSION.SDK_INT >= 26 : this.mi == 1;
    }

    public cw x() {
        return this.up;
    }

    public void xt(String str) {
        this.qv = str;
    }

    public r(String str, cw cwVar, cw cwVar2, int i6, int i7) {
        this.mi = 0;
        this.kt = 0;
        this.f22960m = str;
        this.f22961r = cwVar;
        this.up = cwVar2;
        this.mi = i6;
        this.kt = i7;
    }

    public String av() {
        if (ws()) {
            return this.up.vl();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.vl();
        }
        return null;
    }

    public float az() {
        if (ws()) {
            return this.up.tl();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.tl();
        }
        return -1.0f;
    }

    public cw ch() {
        if (ws()) {
            return this.up;
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar;
        }
        return null;
    }

    public void cw(String str) {
        this.az = str;
    }

    public String i() {
        if (ws()) {
            return this.up.az();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.az();
        }
        return null;
    }

    public void j(int i6) {
        this.ae = i6;
    }

    public boolean jy() {
        if (ws()) {
            return this.up.v();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.v();
        }
        return true;
    }

    public void r(int i6) {
        this.xt = i6;
    }

    public synchronized Object up(String str) {
        return this.cw.get(str);
    }

    public long vl() {
        if (ws()) {
            return this.up.up();
        }
        cw cwVar = this.f22961r;
        if (cwVar != null) {
            return cwVar.up();
        }
        return 0L;
    }

    public void xt(int i6) {
        this.vl = i6;
    }

    public void j(boolean z5) {
        this.f22963w = z5;
    }

    public void xt(boolean z5) {
        this.f22958i = z5;
    }

    public void j(List<String> list) {
        this.ws = list;
    }

    public void m(int i6) {
        this.tj = i6;
    }

    public void j(long j6) {
        this.av = j6;
    }

    public synchronized void j(String str, Object obj) {
        this.cw.put(str, obj);
    }
}
