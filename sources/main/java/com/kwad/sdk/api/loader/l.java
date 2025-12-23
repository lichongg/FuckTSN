package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class l {
    public static int aum;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private int aun;
        private int auo;
        private String aup;
        private String auq;
        private long aur;
        private int aus;
        private String aut;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cs(String str) {
            this.aup = str;
            return this;
        }

        /* synthetic */ a(byte b6) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ap(long j6) {
            this.aur = j6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cq(int i6) {
            this.aun = i6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cr(int i6) {
            this.auo = i6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cs(int i6) {
            this.aus = i6;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ct(String str) {
            this.auq = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cu(String str) {
            this.aut = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.aun));
                jSONObject.putOpt("update_count", Integer.valueOf(this.auo));
                jSONObject.putOpt("dynamic_version", this.aup);
                jSONObject.putOpt("download_url", this.auq);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.aur));
                jSONObject.putOpt("error_code", Integer.valueOf(this.aus));
                jSONObject.putOpt("error_msg", this.aut);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.aun + ", update_count=" + this.auo + ", dynamic_version='" + this.aup + "', download_url='" + this.auq + "', duration_ms=" + this.aur + ", error_code=" + this.aus + ", error_msg='" + this.aut + "'}";
        }
    }

    public static void a(a.C0668a c0668a) {
        aum++;
        a(1, c0668a, 0L, 0, "");
    }

    public static void b(a.C0668a c0668a) {
        a(5, c0668a, 0L, 0, "");
    }

    public static void b(a.C0668a c0668a, long j6) {
        a(6, c0668a, j6, 0, "");
    }

    public static void a(a.C0668a c0668a, long j6) {
        a(2, c0668a, j6, 0, "");
    }

    public static void b(a.C0668a c0668a, int i6, String str) {
        a(7, c0668a, 0L, i6, str);
    }

    public static void a(a.C0668a c0668a, long j6, String str) {
        a(3, c0668a, j6, 0, str);
    }

    public static void a(a.C0668a c0668a, int i6, String str) {
        a(4, c0668a, 0L, i6, str);
    }

    private static void a(int i6, a.C0668a c0668a, long j6, int i7, String str) {
        if (c0668a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).cq(i6).cr(aum).cs(c0668a.sdkVersion).ct(c0668a.atC).ap(j6).cs(i7).cu(str).toJson();
            Objects.toString(json);
            com.kwad.sdk.api.c.g("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
