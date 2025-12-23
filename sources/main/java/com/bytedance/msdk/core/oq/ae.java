package com.bytedance.msdk.core.oq;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ae {
    private List<tl> ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private double f24623g;

    /* renamed from: j, reason: collision with root package name */
    private String f24624j;

    /* renamed from: m, reason: collision with root package name */
    private List<m> f24625m;
    private int oq;
    private double qv;

    /* renamed from: r, reason: collision with root package name */
    private tl f24626r;
    private JSONObject tl;
    private j up;
    private String xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        private String f24627j;
        private List<oq> xt = new ArrayList();

        public void j(String str) {
            this.f24627j = str;
        }

        public void j(List<oq> list) {
            this.xt = list;
        }
    }

    public double cw() {
        return this.qv;
    }

    public double j() {
        return this.f24623g;
    }

    public List<tl> r() {
        return this.ae;
    }

    public List<m> up() {
        return this.f24625m;
    }

    public int xt() {
        return this.oq;
    }

    public JSONObject ae() {
        return this.tl;
    }

    public void cw(String str) {
        this.f24624j = str;
    }

    public List<oq> g() {
        j jVar = this.up;
        if (jVar == null) {
            return null;
        }
        return jVar.xt;
    }

    public void j(String str) {
        try {
            this.f24623g = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public String m() {
        return this.cw;
    }

    public void r(String str) {
        this.xt = str;
    }

    public boolean tl() {
        j jVar = this.up;
        return (jVar == null || TextUtils.isEmpty(jVar.f24627j)) ? false : true;
    }

    public void up(String str) {
        this.cw = str;
    }

    public void xt(String str) {
        try {
            this.qv = Double.valueOf(str).doubleValue();
        } catch (Throwable unused) {
        }
    }

    public void j(int i6) {
        this.oq = i6;
    }

    public void xt(List<m> list) {
        this.f24625m = list;
    }

    public void j(List<tl> list) {
        this.ae = list;
    }

    public void j(tl tlVar) {
        this.f24626r = tlVar;
    }

    public void j(j jVar) {
        this.up = jVar;
    }

    public void j(JSONObject jSONObject) {
        this.tl = jSONObject;
    }
}
