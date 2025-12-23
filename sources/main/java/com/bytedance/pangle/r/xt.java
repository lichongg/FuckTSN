package com.bytedance.pangle.r;

import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {
    public static String ae = "7z_unzip_finish";
    public static String cw = "download_finish";

    /* renamed from: g, reason: collision with root package name */
    public static String f25452g = "load_finish";

    /* renamed from: j, reason: collision with root package name */
    public static String f25453j = "request_finish";

    /* renamed from: m, reason: collision with root package name */
    public static String f25454m = "7z_unzip_start";
    public static String oq = "rm_entry_finish";
    private static volatile xt qv = null;

    /* renamed from: r, reason: collision with root package name */
    public static String f25455r = "install_start";
    public static String tl = "load_start";
    public static String up = "install_finish";
    public static String xt = "download_start";
    private final List<com.bytedance.pangle.r.j> vl = new ArrayList();

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public static int f25456a = 32007;
        public static int ae = 12002;
        public static int av = 22002;
        public static int az = 22001;
        public static int ch = 32005;
        public static int cw = -1;

        /* renamed from: f, reason: collision with root package name */
        public static int f25457f = 32002;

        /* renamed from: g, reason: collision with root package name */
        public static int f25458g = 12004;
        public static int gq = 42000;

        /* renamed from: h, reason: collision with root package name */
        public static int f25459h = 40000;

        /* renamed from: i, reason: collision with root package name */
        public static int f25460i = 22999;

        /* renamed from: j, reason: collision with root package name */
        public static int f25461j = 1;
        public static int jy = 21002;
        public static int kt = 32000;

        /* renamed from: l, reason: collision with root package name */
        public static int f25462l = 32008;
        public static int la = 41000;

        /* renamed from: m, reason: collision with root package name */
        public static int f25463m = 12001;
        public static int mi = 31000;
        public static int oq = 20000;

        /* renamed from: p, reason: collision with root package name */
        public static int f25464p = 32999;
        public static int qv = 21000;

        /* renamed from: r, reason: collision with root package name */
        public static int f25465r = -2;
        public static int rn = 50000;

        /* renamed from: s, reason: collision with root package name */
        public static int f25466s = 32006;
        public static int tj = 32001;
        public static int tl = 12003;
        public static int up = 12000;

        /* renamed from: v, reason: collision with root package name */
        public static int f25467v = 32003;
        public static int vl = 21001;

        /* renamed from: w, reason: collision with root package name */
        public static int f25468w = 30000;
        public static int wq = 50004;
        public static int ws = 22000;

        /* renamed from: x, reason: collision with root package name */
        public static int f25469x = 32004;
        public static int xt = 2;
    }

    public static xt j() {
        if (qv == null) {
            synchronized (xt.class) {
                qv = new xt();
            }
        }
        return qv;
    }

    private xt() {
    }

    public void j(@NonNull com.bytedance.pangle.r.j jVar) {
        synchronized (this.vl) {
            this.vl.add(jVar);
        }
    }

    public void j(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.vl) {
            try {
                Iterator<com.bytedance.pangle.r.j> it = this.vl.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().j(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (Throwable th) {
                        m.j(th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
