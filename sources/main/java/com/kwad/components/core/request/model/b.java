package com.kwad.components.core.request.model;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bj;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.cd;
import com.kwad.sdk.utils.r;
import com.umeng.analytics.pro.bi;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements com.kwad.sdk.core.b {
    private String LP;
    private int Qh;
    private List<a> XA;
    private f XB;
    private com.kwad.sdk.l.a.d XC;
    private com.kwad.sdk.l.a.b XD;
    private List<e> XE;
    private int Xk;
    private String Xl;
    private Long Xm;
    private Long Xn;
    private Long Xo;
    private Long Xp;
    private String Xq;
    private String Xr;
    private long Xt;
    private String Xu;
    private long Xv;
    private String Xx;
    private String Xy;
    private boolean Xz;
    private List<cd.a> Xs = new CopyOnWriteArrayList();
    private int Xw = -1;
    private float screenBrightness = -1.0f;
    private int Qk = -1;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int XF = -1;
        public int XG = -1;
        public int XH = -1;
        public int streamType;

        private static int aV(int i6) {
            if (i6 == 0) {
                return 0;
            }
            int i7 = 1;
            if (i6 != 1) {
                i7 = 2;
                if (i6 != 2) {
                    i7 = 3;
                    if (i6 != 3) {
                        i7 = 4;
                        if (i6 != 4) {
                            i7 = 5;
                            if (i6 != 5) {
                                return 0;
                            }
                        }
                    }
                }
            }
            return i7;
        }

        public static List<a> aB(Context context) {
            int streamMinVolume;
            ArrayList arrayList = new ArrayList();
            if (context != null && !com.kwad.sdk.core.config.e.ai(256L)) {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                    if (audioManager != null) {
                        for (int i6 = 0; i6 <= 5; i6++) {
                            a aVar = new a(i6);
                            int aV = aV(i6);
                            aVar.XH = audioManager.getStreamVolume(aV);
                            aVar.XF = audioManager.getStreamMaxVolume(aV);
                            if (Build.VERSION.SDK_INT >= 28) {
                                streamMinVolume = audioManager.getStreamMinVolume(aV);
                                aVar.XG = streamMinVolume;
                            }
                            arrayList.add(aVar);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }

        private a(int i6) {
            this.streamType = i6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041 A[Catch: Exception -> 0x0044, TryCatch #0 {Exception -> 0x0044, blocks: (B:5:0x001e, B:7:0x0024, B:13:0x0037, B:15:0x0041, B:19:0x0048, B:23:0x004e, B:26:0x0054), top: B:4:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void aA(@androidx.annotation.NonNull android.content.Context r7) {
        /*
            r6 = this;
            r0 = 512(0x200, double:2.53E-321)
            boolean r0 = com.kwad.sdk.core.config.e.ai(r0)
            if (r0 == 0) goto L9
            goto L56
        L9:
            android.content.IntentFilter r0 = new android.content.IntentFilter
            r0.<init>()
            java.lang.String r1 = "android.intent.action.ACTION_POWER_CONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.ACTION_POWER_DISCONNECTED"
            r0.addAction(r1)
            java.lang.String r1 = "android.intent.action.BATTERY_CHANGED"
            r0.addAction(r1)
            r1 = 0
            android.content.Intent r7 = r7.registerReceiver(r1, r0)     // Catch: java.lang.Exception -> L44
            if (r7 == 0) goto L56
            java.lang.String r0 = "status"
            r1 = -1
            int r0 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            r2 = 0
            r3 = 1
            r4 = 2
            if (r0 == r4) goto L36
            r5 = 5
            if (r0 != r5) goto L34
            goto L36
        L34:
            r0 = 0
            goto L37
        L36:
            r0 = 1
        L37:
            r6.Xz = r0     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = "plugged"
            int r7 = r7.getIntExtra(r0, r1)     // Catch: java.lang.Exception -> L44
            if (r7 != r4) goto L46
            r6.Qk = r3     // Catch: java.lang.Exception -> L44
            return
        L44:
            r7 = move-exception
            goto L57
        L46:
            if (r7 != r3) goto L4b
            r6.Qk = r4     // Catch: java.lang.Exception -> L44
            return
        L4b:
            r0 = 4
            if (r7 != r0) goto L52
            r7 = 3
            r6.Qk = r7     // Catch: java.lang.Exception -> L44
            return
        L52:
            if (r7 != 0) goto L56
            r6.Qk = r2     // Catch: java.lang.Exception -> L44
        L56:
            return
        L57:
            com.kwad.sdk.core.d.c.printStackTrace(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.request.model.b.aA(android.content.Context):void");
    }

    @WorkerThread
    public static b sx() {
        b bVar = new b();
        bVar.Xk = br.RS();
        bVar.Xl = AbiUtil.cp(getContext());
        bVar.Qh = br.dR(getContext());
        bVar.Xm = Long.valueOf(br.dS(getContext()));
        bVar.Xn = Long.valueOf(br.dO(getContext()));
        bVar.Xo = Long.valueOf(br.RP());
        bVar.Xp = Long.valueOf(br.RQ());
        bVar.Xq = bd.dt(getContext());
        bVar.Xr = bd.du(getContext());
        bVar.Xs.addAll(bd.o(getContext(), 15));
        bVar.Xt = br.RX();
        bVar.Xv = br.RY();
        bVar.Xy = br.RZ();
        bVar.Xx = br.Sa();
        bVar.LP = br.Sb();
        bVar.Xu = br.Sc();
        Context context = getContext();
        if (context != null) {
            bVar.Xw = br.dZ(context);
            bVar.XA = new CopyOnWriteArrayList(a.aB(context));
            bVar.aA(context);
        }
        bVar.XC = r.PQ();
        bVar.XD = bd.OO();
        bVar.XE = bj.Ry().Rz();
        bVar.XB = bd.OP();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "cpuCount", this.Xk);
        aa.putValue(jSONObject, "cpuAbi", this.Xl);
        aa.putValue(jSONObject, "batteryPercent", this.Qh);
        aa.putValue(jSONObject, "totalMemorySize", this.Xm.longValue());
        aa.putValue(jSONObject, "availableMemorySize", this.Xn.longValue());
        aa.putValue(jSONObject, "totalDiskSize", this.Xo.longValue());
        aa.putValue(jSONObject, "availableDiskSize", this.Xp.longValue());
        aa.putValue(jSONObject, "imsi", this.Xq);
        aa.putValue(jSONObject, bi.aa, this.Xr);
        aa.putValue(jSONObject, "wifiList", this.Xs);
        aa.putValue(jSONObject, "bootTime", this.Xt);
        aa.putValue(jSONObject, "romName", this.LP);
        aa.putValue(jSONObject, "romVersion", this.Xu);
        aa.putValue(jSONObject, "romBuildTimestamp", this.Xv);
        aa.putValue(jSONObject, "ringerMode", this.Xw);
        aa.putValue(jSONObject, "audioStreamInfo", this.XA);
        aa.putValue(jSONObject, "baseBandVersion", this.Xx);
        aa.putValue(jSONObject, "fingerPrint", this.Xy);
        aa.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        aa.putValue(jSONObject, "isCharging", this.Xz);
        aa.putValue(jSONObject, "chargeType", this.Qk);
        f fVar = this.XB;
        if (fVar != null) {
            aa.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.l.a.d dVar = this.XC;
        if (dVar != null) {
            aa.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.XD;
        if (bVar != null) {
            aa.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.XE;
        if (list != null) {
            aa.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }

    private static Context getContext() {
        return ServiceProvider.Pp();
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }
}
