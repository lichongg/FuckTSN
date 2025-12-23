package com.bytedance.sdk.openadsdk.core.tj;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.xt.r;
import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f30367a;
    private final float ae;
    private final float av;
    private final int az;
    private String ch;
    private final int[] cw;

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<r.j> f30368f;

    /* renamed from: g, reason: collision with root package name */
    private final long f30369g;

    /* renamed from: i, reason: collision with root package name */
    private final int f30370i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f30371j;
    private final int jy;
    private final String kt;

    /* renamed from: m, reason: collision with root package name */
    private final float f30372m;
    private final String mi;
    private final long oq;
    private final int qv;

    /* renamed from: r, reason: collision with root package name */
    private final int[] f30373r;

    /* renamed from: s, reason: collision with root package name */
    private int f30374s;
    private final String tj;
    private final float tl;
    private final float up;

    /* renamed from: v, reason: collision with root package name */
    private int f30375v;
    private final int vl;

    /* renamed from: w, reason: collision with root package name */
    private final String f30376w;
    private final float ws;

    /* renamed from: x, reason: collision with root package name */
    private int f30377x;
    private final int[] xt;

    /* renamed from: com.bytedance.sdk.openadsdk.core.tj.oq$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class j {
        private String ch;
        float cw;

        /* renamed from: f, reason: collision with root package name */
        private String f30379f;

        /* renamed from: i, reason: collision with root package name */
        private SparseArray<r.j> f30381i;

        /* renamed from: j, reason: collision with root package name */
        float f30382j;
        private int[] jy;
        private String kt;
        private String mi;
        private int[] oq;
        private int[] qv;
        private String tj;
        private int[] vl;

        /* renamed from: w, reason: collision with root package name */
        private int f30387w;
        int xt;

        /* renamed from: r, reason: collision with root package name */
        private long f30384r = -1;
        private long up = -1;

        /* renamed from: m, reason: collision with root package name */
        private float f30383m = -1.0f;
        private float ae = -1.0f;
        private float tl = -1.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f30380g = -1.0f;
        private int ws = -1;
        private int az = -1;
        private int av = -1024;

        /* renamed from: v, reason: collision with root package name */
        private int f30386v = -1;

        /* renamed from: x, reason: collision with root package name */
        private int f30388x = -1;

        /* renamed from: s, reason: collision with root package name */
        private int f30385s = -1;

        /* renamed from: a, reason: collision with root package name */
        private boolean f30378a = false;

        public j ae(int i6) {
            this.f30388x = i6;
            return this;
        }

        public j cw(float f6) {
            this.f30383m = f6;
            return this;
        }

        public j j(float f6) {
            this.f30382j = f6;
            return this;
        }

        public j m(float f6) {
            this.f30380g = f6;
            return this;
        }

        public j r(float f6) {
            this.ae = f6;
            return this;
        }

        public j tl(int i6) {
            this.f30385s = i6;
            return this;
        }

        public j up(float f6) {
            this.tl = f6;
            return this;
        }

        public j xt(float f6) {
            this.cw = f6;
            return this;
        }

        public j cw(int[] iArr) {
            this.vl = iArr;
            return this;
        }

        public j j(int i6) {
            this.xt = i6;
            return this;
        }

        public j m(int i6) {
            this.f30386v = i6;
            return this;
        }

        public j r(int[] iArr) {
            this.jy = iArr;
            return this;
        }

        public j up(int i6) {
            this.av = i6;
            return this;
        }

        public j xt(int i6) {
            this.f30387w = i6;
            return this;
        }

        public j cw(int i6) {
            this.ws = i6;
            return this;
        }

        public j j(SparseArray<r.j> sparseArray) {
            this.f30381i = sparseArray;
            return this;
        }

        public j r(int i6) {
            this.az = i6;
            return this;
        }

        public j up(String str) {
            this.ch = str;
            return this;
        }

        public j xt(long j6) {
            this.up = j6;
            return this;
        }

        public j cw(String str) {
            this.tj = str;
            return this;
        }

        public j j(long j6) {
            this.f30384r = j6;
            return this;
        }

        public j r(String str) {
            this.f30379f = str;
            return this;
        }

        public j xt(int[] iArr) {
            this.qv = iArr;
            return this;
        }

        public j j(int[] iArr) {
            this.oq = iArr;
            return this;
        }

        public j xt(String str) {
            this.kt = str;
            return this;
        }

        public j j(String str) {
            this.mi = str;
            return this;
        }

        public j j(boolean z5) {
            this.f30378a = z5;
            return this;
        }

        public oq j() {
            return new oq(this, null);
        }
    }

    /* synthetic */ oq(j jVar, AnonymousClass1 anonymousClass1) {
        this(jVar);
    }

    private oq(j jVar) {
        this.f30377x = -1;
        this.f30374s = -1;
        this.f30371j = jVar.qv;
        this.xt = jVar.vl;
        this.f30373r = jVar.jy;
        this.cw = jVar.oq;
        this.up = jVar.f30380g;
        this.f30372m = jVar.tl;
        this.ae = jVar.ae;
        this.tl = jVar.f30383m;
        this.f30369g = jVar.up;
        this.oq = jVar.f30384r;
        this.qv = jVar.ws;
        this.vl = jVar.az;
        this.jy = jVar.av;
        this.ws = jVar.f30382j;
        this.f30376w = jVar.mi;
        this.mi = jVar.kt;
        this.tj = jVar.f30379f;
        this.kt = jVar.tj;
        this.az = jVar.xt;
        this.av = jVar.cw;
        this.f30370i = jVar.f30387w;
        this.f30368f = jVar.f30381i;
        this.f30375v = jVar.f30386v;
        this.f30377x = jVar.f30388x;
        this.ch = jVar.ch;
        this.f30374s = jVar.f30385s;
        this.f30367a = jVar.f30378a;
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            int[] iArr = this.f30371j;
            if (iArr != null && iArr.length == 2) {
                jSONObject.putOpt("ad_x", Integer.valueOf(iArr[0])).putOpt("ad_y", Integer.valueOf(this.f30371j[1]));
            }
            int[] iArr2 = this.xt;
            if (iArr2 != null && iArr2.length == 2) {
                jSONObject.putOpt("width", Integer.valueOf(iArr2[0])).putOpt("height", Integer.valueOf(this.xt[1]));
            }
            int[] iArr3 = this.cw;
            if (iArr3 != null && iArr3.length == 2) {
                jSONObject.putOpt("button_x", Integer.valueOf(iArr3[0])).putOpt("button_y", Integer.valueOf(this.cw[1]));
            }
            int[] iArr4 = this.f30373r;
            if (iArr4 != null && iArr4.length == 2) {
                jSONObject.putOpt("button_width", Integer.valueOf(iArr4[0])).putOpt("button_height", Integer.valueOf(this.f30373r[1]));
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (this.f30368f != null) {
                for (int i6 = 0; i6 < this.f30368f.size(); i6++) {
                    r.j valueAt = this.f30368f.valueAt(i6);
                    if (valueAt != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.putOpt("force", Double.valueOf(valueAt.cw)).putOpt("mr", Double.valueOf(valueAt.xt)).putOpt("phase", Integer.valueOf(valueAt.f31362j)).putOpt("ts", Long.valueOf(valueAt.f31363r));
                        jSONArray.put(jSONObject3);
                    }
                }
            }
            jSONObject2.putOpt("ftc", Integer.valueOf(this.f30370i)).putOpt("info", jSONArray);
            jSONObject.putOpt("down_x", Float.toString(this.up)).putOpt("down_y", Float.toString(this.f30372m)).putOpt("up_x", Float.toString(this.ae)).putOpt("up_y", Float.toString(this.tl)).putOpt("down_time", Long.valueOf(this.f30369g)).putOpt("up_time", Long.valueOf(this.oq)).putOpt("toolType", Integer.valueOf(this.qv)).putOpt("deviceId", Integer.valueOf(this.vl)).putOpt(SocialConstants.PARAM_SOURCE, Integer.valueOf(this.jy)).putOpt("density", Float.valueOf(this.ws)).putOpt("densityDpi", Integer.valueOf(this.az)).putOpt("scaleDensity", Float.valueOf(this.av)).putOpt(SocializeProtocolConstants.PROTOCOL_KEY_FRIST_TIME, jSONObject2).putOpt("click_area_type", this.f30376w).putOpt("areaType", this.mi).putOpt("rectInfo", this.tj).putOpt("click_area_id", this.kt);
            int i7 = this.f30375v;
            if (i7 != -1) {
                jSONObject.putOpt("if_shake", Integer.valueOf(i7));
            }
            int i8 = this.f30377x;
            if (i8 != -1) {
                jSONObject.putOpt("if_twist", Integer.valueOf(i8));
            }
            int i9 = this.f30374s;
            if (i9 != -1) {
                jSONObject.putOpt("dpa_position", Integer.valueOf(i9)).putOpt("dpa_pid", this.ch);
            }
            if (this.f30367a) {
                jSONObject.put("referer", "directDownload");
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
