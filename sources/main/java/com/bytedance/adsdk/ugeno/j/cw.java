package com.bytedance.adsdk.ugeno.j;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw {
    private String ae;
    private int cw;

    /* renamed from: g, reason: collision with root package name */
    private int f23668g = 1;

    /* renamed from: j, reason: collision with root package name */
    private Map<String, TreeMap<Float, String>> f23669j;

    /* renamed from: m, reason: collision with root package name */
    private j f23670m;
    private JSONObject oq;

    /* renamed from: r, reason: collision with root package name */
    private String f23671r;
    private String tl;
    private long up;
    private long xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public String f23672j;
        public String xt;
    }

    public long cw() {
        return this.xt;
    }

    public JSONObject j() {
        return this.oq;
    }

    public Map<String, TreeMap<Float, String>> xt() {
        return this.f23669j;
    }

    public j ae() {
        return this.f23670m;
    }

    public void cw(String str) {
        this.tl = str;
    }

    public String g() {
        return this.tl;
    }

    public void j(JSONObject jSONObject) {
        this.oq = jSONObject;
    }

    public long m() {
        return this.up;
    }

    public int oq() {
        return this.f23668g;
    }

    public int r() {
        return this.cw;
    }

    public String tl() {
        return this.ae;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.f23669j + ", mDuration=" + this.xt + ", mPlayCount=" + this.cw + ", mPlayDirection=" + this.f23671r + ", mDelay=" + this.up + ", mName=" + this.tl + ", mPlayState=" + this.f23668g + ", mTransformOrigin='" + this.f23670m + "', mTimingFunction='" + this.ae + "'}";
    }

    public String up() {
        return this.f23671r;
    }

    public void xt(long j6) {
        this.up = j6;
    }

    public void j(Map<String, TreeMap<Float, String>> map) {
        this.f23669j = map;
    }

    public void xt(String str) {
        this.ae = str;
    }

    public void j(long j6) {
        this.xt = j6;
    }

    public void xt(int i6) {
        this.f23668g = i6;
    }

    public void j(int i6) {
        this.cw = i6;
    }

    public void j(String str) {
        this.f23671r = str;
    }

    public void j(j jVar) {
        this.f23670m = jVar;
    }
}
