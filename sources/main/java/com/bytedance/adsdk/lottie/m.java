package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes3.dex */
public class m {
    private SparseArray<com.bytedance.adsdk.lottie.model.r> ae;
    private r av;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.tl>> cw;

    /* renamed from: g, reason: collision with root package name */
    private List<com.bytedance.adsdk.lottie.model.layer.tl> f23325g;
    private float jy;
    private j kt;

    /* renamed from: m, reason: collision with root package name */
    private List<com.bytedance.adsdk.lottie.model.m> f23328m;
    private cw mi;
    private Rect oq;
    private float qv;

    /* renamed from: r, reason: collision with root package name */
    private Map<String, g> f23329r;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.tl> tl;
    private Map<String, com.bytedance.adsdk.lottie.model.cw> up;
    private float vl;

    /* renamed from: w, reason: collision with root package name */
    private xt f23330w;
    private boolean ws;

    /* renamed from: j, reason: collision with root package name */
    private final w f23327j = new w();
    private final HashSet<String> xt = new HashSet<>();
    private int az = 0;

    /* renamed from: i, reason: collision with root package name */
    private String f23326i = "";

    public static class cw {
        public JSONArray cw;

        /* renamed from: j, reason: collision with root package name */
        public String f23332j;
        public int[][] xt;
    }

    public static class j {
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public String f23333j;

        /* renamed from: r, reason: collision with root package name */
        public String f23335r;
        public String xt;
        public float up = -1.0f;

        /* renamed from: m, reason: collision with root package name */
        public float f23334m = -1.0f;
        public float ae = -1.0f;
        public float tl = -1.0f;

        public String toString() {
            return "area[" + this.f23333j + "," + this.xt + "," + this.cw + "," + this.f23335r + "]->[" + this.up + "," + this.f23334m + "," + this.ae + "," + this.tl + "]";
        }
    }

    public static class r {
        public JSONArray ae;
        public String cw;

        /* renamed from: j, reason: collision with root package name */
        public int f23340j;

        /* renamed from: m, reason: collision with root package name */
        public String f23341m;

        /* renamed from: r, reason: collision with root package name */
        public String f23342r;
        public int[] up;
        public String xt;
    }

    public static class xt {
        public JSONArray ae;
        public Map<String, Object> cw;

        /* renamed from: j, reason: collision with root package name */
        public int f23347j;

        /* renamed from: m, reason: collision with root package name */
        public String f23348m;

        /* renamed from: r, reason: collision with root package name */
        public int f23349r;
        public int up;
        public Map<String, Object> xt;
    }

    public w cw() {
        return this.f23327j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void j(Rect rect, float f6, float f7, float f8, List<com.bytedance.adsdk.lottie.model.layer.tl> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.tl> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.tl>> map, Map<String, g> map2, SparseArray<com.bytedance.adsdk.lottie.model.r> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.cw> map3, List<com.bytedance.adsdk.lottie.model.m> list2, r rVar, String str, xt xtVar, cw cwVar, j jVar) {
        this.oq = rect;
        this.qv = f6;
        this.vl = f7;
        this.jy = f8;
        this.f23325g = list;
        this.tl = longSparseArray;
        this.cw = map;
        this.f23329r = map2;
        this.ae = sparseArray;
        this.up = map3;
        this.f23328m = list2;
        this.av = rVar;
        this.f23326i = str;
        this.f23330w = xtVar;
        this.mi = cwVar;
        this.kt = jVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int xt() {
        return this.az;
    }

    public float ae() {
        return this.vl;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.cw> av() {
        return this.up;
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.r> az() {
        return this.ae;
    }

    public com.bytedance.adsdk.lottie.model.m cw(String str) {
        int size = this.f23328m.size();
        for (int i6 = 0; i6 < size; i6++) {
            com.bytedance.adsdk.lottie.model.m mVar = this.f23328m.get(i6);
            if (mVar.j(str)) {
                return mVar;
            }
        }
        return null;
    }

    public String g() {
        return this.f23326i;
    }

    public Map<String, g> i() {
        return this.f23329r;
    }

    public float jy() {
        return this.jy;
    }

    public float m() {
        return this.qv;
    }

    public j oq() {
        return this.kt;
    }

    public cw qv() {
        return this.mi;
    }

    public Rect r() {
        return this.oq;
    }

    public r tl() {
        return this.av;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.tl> it = this.f23325g.iterator();
        while (it.hasNext()) {
            sb.append(it.next().j("\t"));
        }
        return sb.toString();
    }

    public xt vl() {
        return this.f23330w;
    }

    public float w() {
        return this.vl - this.qv;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.tl> ws() {
        return this.f23325g;
    }

    public void xt(boolean z5) {
        this.f23327j.j(z5);
    }

    public float up() {
        return (long) ((w() / this.jy) * 1000.0f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<com.bytedance.adsdk.lottie.model.layer.tl> xt(String str) {
        return this.cw.get(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void j(String str) {
        com.bytedance.adsdk.lottie.up.up.xt(str);
        this.xt.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void j(boolean z5) {
        this.ws = z5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void j(int i6) {
        this.az += i6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean j() {
        return this.ws;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public com.bytedance.adsdk.lottie.model.layer.tl j(long j6) {
        return this.tl.get(j6);
    }

    public float j(float f6) {
        return com.bytedance.adsdk.lottie.up.tl.j(this.qv, this.vl, f6);
    }
}
