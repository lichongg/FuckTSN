package com.bytedance.sdk.openadsdk.core.tj;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    private String ae;
    private String cw;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f30328g;

    /* renamed from: j, reason: collision with root package name */
    private String f30329j;
    private JSONArray jy;

    /* renamed from: m, reason: collision with root package name */
    private String f30330m;
    private String oq;
    private String qv;

    /* renamed from: r, reason: collision with root package name */
    private String f30331r;
    private String tl;
    private String up;
    private float vl;
    private HashMap<String, String> ws = new HashMap<>();
    private String xt;

    public String ae() {
        return this.cw;
    }

    public float cw() {
        return this.vl;
    }

    public String g() {
        return this.f30330m;
    }

    public void j(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ws.put(str, str2);
    }

    public String m() {
        return this.xt;
    }

    public String oq() {
        return this.ae;
    }

    public JSONArray r() {
        return this.jy;
    }

    public String tl() {
        return this.f30331r;
    }

    public String up() {
        return this.f30329j;
    }

    public String xt() {
        return this.up;
    }

    public void ae(String str) {
        this.ae = str;
    }

    public void cw(String str) {
        this.xt = str;
    }

    public void g(String str) {
        this.oq = str;
    }

    public String jy() {
        return this.oq;
    }

    public void m(String str) {
        this.f30330m = str;
    }

    public void oq(String str) {
        this.qv = str;
    }

    public String qv() {
        return this.tl;
    }

    public void r(String str) {
        this.cw = str;
    }

    public void tl(String str) {
        this.tl = str;
    }

    public void up(String str) {
        this.f30331r = str;
    }

    public JSONArray vl() {
        return this.f30328g;
    }

    public String ws() {
        return this.qv;
    }

    public void xt(String str) {
        this.f30329j = str;
    }

    public HashMap<String, String> j() {
        return this.ws;
    }

    public void xt(JSONArray jSONArray) {
        this.f30328g = jSONArray;
    }

    public void j(String str) {
        this.up = str;
    }

    public void j(float f6) {
        this.vl = f6;
    }

    public void j(JSONArray jSONArray) {
        this.jy = jSONArray;
    }
}
