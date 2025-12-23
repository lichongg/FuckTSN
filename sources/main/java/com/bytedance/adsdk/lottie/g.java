package com.bytedance.adsdk.lottie;

import android.graphics.Bitmap;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g {
    private final String ae;
    private final String cw;

    /* renamed from: g, reason: collision with root package name */
    private final List<xt> f23225g;

    /* renamed from: j, reason: collision with root package name */
    private final int f23226j;
    private final j jy;

    /* renamed from: m, reason: collision with root package name */
    private final String f23227m;
    private final String oq;
    private final int[][] qv;

    /* renamed from: r, reason: collision with root package name */
    private final String f23228r;
    private final String tl;
    private final String up;
    private final JSONArray vl;
    private Bitmap ws;
    private final int xt;

    public static class j {

        /* renamed from: j, reason: collision with root package name */
        public C0314j f23229j = null;
        public boolean xt;

        /* renamed from: com.bytedance.adsdk.lottie.g$j$j, reason: collision with other inner class name */
        public static class C0314j {

            /* renamed from: j, reason: collision with root package name */
            public float f23230j = 5.0f;
        }
    }

    public static class xt {
        public int ae;
        public String cw;

        /* renamed from: g, reason: collision with root package name */
        public String f23231g;

        /* renamed from: j, reason: collision with root package name */
        public int f23232j;

        /* renamed from: m, reason: collision with root package name */
        public int f23233m;

        /* renamed from: r, reason: collision with root package name */
        public String f23234r;
        public int tl;
        public String up;
        public int xt;
    }

    public int j() {
        return this.f23226j;
    }

    public String ae() {
        return this.oq;
    }

    public List<xt> cw() {
        return this.f23225g;
    }

    public JSONArray g() {
        return this.vl;
    }

    public void j(Bitmap bitmap) {
        this.ws = bitmap;
    }

    public String jy() {
        return this.up;
    }

    public String m() {
        return this.tl;
    }

    public j oq() {
        return this.jy;
    }

    public String qv() {
        return this.cw;
    }

    public String r() {
        return this.f23227m;
    }

    public int[][] tl() {
        return this.qv;
    }

    public String up() {
        return this.ae;
    }

    public String vl() {
        return this.f23228r;
    }

    public Bitmap ws() {
        return this.ws;
    }

    public int xt() {
        return this.xt;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i6, int i7, String str, String str2, String str3, String str4, List<xt> list, String str5, int[][] iArr, JSONArray jSONArray, String str6, String str7, j jVar) {
        this.f23226j = i6;
        this.xt = i7;
        this.cw = str;
        this.f23228r = str2;
        this.up = str3;
        this.f23227m = str4;
        this.ae = str6;
        this.tl = str7;
        this.f23225g = list;
        this.oq = str5;
        this.qv = iArr;
        this.vl = jSONArray;
        this.jy = jVar;
    }
}
