package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class c {
    private static final String TAG = "c";
    public final String LQ;
    public final String aOA;
    public final String aOB;
    public final String aOC;
    public final List<com.kwad.sdk.crash.a> aOD;
    public final double aOe;
    public final boolean aOj;
    public final boolean aOk;
    public final com.kwad.sdk.crash.model.c aOn;
    public final com.kwad.sdk.crash.model.a aOo;
    public final h aOp;
    public final String[] aOq;
    public final String[] aOr;
    public final boolean aOs;
    public final f aOt;
    public final String aOu;
    public final String aOv;
    public final String aOw;
    public final String aOx;
    public final String aOy;
    public final String aOz;
    public final boolean asv;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private String LQ;
        private int aHI;
        private String aOE;
        private h aOF;
        private String[] aOG;
        public String[] aOH;
        private f aOt;
        private String aOu;
        private String aOv;
        private String aOw;
        private String aOx;
        private String aOy;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private String channel;
        private Context context;
        private String platform;
        private String sdkApiVersion;
        private int sdkApiVersionCode;
        public int sdkType;
        private String sdkVersion;
        private boolean aOs = false;
        private boolean aOj = false;
        private boolean aOk = false;
        private boolean asv = false;
        private String aOz = "";
        private String aOA = "";
        private String aOB = "";
        private String aOC = "";
        private List<com.kwad.sdk.crash.a> aOD = new ArrayList();
        private double aOe = 1.0d;

        public final a dV(int i6) {
            this.sdkType = 1;
            return this;
        }

        public final c Lq() {
            return new c(this, (byte) 0);
        }

        public final a a(f fVar) {
            this.aOt = fVar;
            return this;
        }

        public final a bE(boolean z5) {
            this.aOj = z5;
            return this;
        }

        public final a bF(boolean z5) {
            this.aOk = z5;
            return this;
        }

        public final a bG(boolean z5) {
            this.asv = z5;
            return this;
        }

        public final a cb(Context context) {
            this.context = context;
            return this;
        }

        public final a d(String[] strArr) {
            this.aOG = strArr;
            return this;
        }

        public final a dT(int i6) {
            this.aHI = i6;
            return this;
        }

        public final a dU(int i6) {
            this.sdkApiVersionCode = i6;
            return this;
        }

        public final a e(String[] strArr) {
            this.aOH = strArr;
            return this;
        }

        public final a fi(String str) {
            this.aOz = str;
            return this;
        }

        public final a fj(String str) {
            this.aOA = str;
            return this;
        }

        public final a fk(String str) {
            this.platform = str;
            return this;
        }

        public final a fl(String str) {
            this.aOu = str;
            return this;
        }

        public final a fm(String str) {
            this.LQ = str;
            return this;
        }

        public final a fn(String str) {
            this.channel = str;
            return this;
        }

        public final a fo(String str) {
            this.aOy = str;
            return this;
        }

        public final a fp(String str) {
            this.aOE = str;
            return this;
        }

        public final a fq(String str) {
            this.sdkVersion = str;
            return this;
        }

        public final a fr(String str) {
            this.sdkApiVersion = str;
            return this;
        }

        public final a fs(String str) {
            this.appPackageName = str;
            return this;
        }

        public final a ft(String str) {
            this.appId = str;
            return this;
        }

        public final a fu(String str) {
            this.appName = str;
            return this;
        }

        public final a fv(String str) {
            this.appVersion = str;
            return this;
        }

        public final a fw(String str) {
            this.aOv = str;
            return this;
        }

        public final a fx(String str) {
            this.aOw = str;
            return this;
        }

        public final a fy(String str) {
            this.aOB = str;
            return this;
        }

        public final a fz(String str) {
            this.aOC = str;
            return this;
        }

        public final a m(double d6) {
            this.aOe = d6;
            return this;
        }

        public final a H(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        com.kwad.sdk.crash.a aVar = new com.kwad.sdk.crash.a();
                        aVar.parseJson(jSONObject);
                        this.aOD.add(aVar);
                    } catch (Exception e6) {
                        com.kwad.sdk.core.d.c.w(c.TAG, Log.getStackTraceString(e6));
                    }
                }
            }
            return this;
        }

        public final a a(h hVar) {
            this.aOF = hVar;
            return this;
        }
    }

    /* synthetic */ c(a aVar, byte b6) {
        this(aVar);
    }

    private c(a aVar) {
        com.kwad.sdk.crash.model.c cVar = new com.kwad.sdk.crash.model.c();
        this.aOn = cVar;
        com.kwad.sdk.crash.model.a aVar2 = new com.kwad.sdk.crash.model.a();
        this.aOo = aVar2;
        ArrayList arrayList = new ArrayList();
        this.aOD = arrayList;
        this.aOs = aVar.aOs;
        this.aOj = aVar.aOj;
        this.aOk = aVar.aOk;
        this.asv = aVar.asv;
        this.aOz = aVar.aOz;
        this.aOA = aVar.aOA;
        this.aOB = aVar.aOB;
        this.aOC = aVar.aOC;
        this.context = aVar.context;
        this.aOt = aVar.aOt;
        this.platform = aVar.platform;
        this.aOu = aVar.aOu;
        this.aOv = aVar.aOv;
        this.aOw = aVar.aOw;
        this.sdkVersion = aVar.sdkVersion;
        this.LQ = aVar.LQ;
        this.channel = aVar.channel;
        this.aOx = aVar.aOx;
        this.aOy = aVar.aOy;
        aVar2.mAppId = aVar.appId;
        aVar2.mAppName = aVar.appName;
        aVar2.aPl = aVar.appVersion;
        aVar2.aPk = aVar.appPackageName;
        cVar.aPv = aVar.sdkApiVersion;
        cVar.aPw = aVar.sdkApiVersionCode;
        cVar.mSdkVersion = aVar.sdkVersion;
        cVar.aPu = aVar.aHI;
        cVar.aPt = aVar.aOE;
        cVar.aPx = aVar.sdkType;
        this.aOp = aVar.aOF;
        this.aOq = aVar.aOG;
        this.aOr = aVar.aOH;
        arrayList.addAll(aVar.aOD);
        this.aOe = aVar.aOe;
    }

    public final f Ln() {
        return this.aOt;
    }

    public final boolean Lo() {
        return this.aOs;
    }
}
