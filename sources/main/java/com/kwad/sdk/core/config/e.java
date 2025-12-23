package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.config.item.o;
import com.kwad.sdk.core.config.item.r;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    private static volatile SdkConfigData aCh;
    private static final AtomicBoolean aCg = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static boolean Bi() {
        return false;
    }

    public static JSONObject a(com.kwad.sdk.core.config.item.e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.Gu();
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context Pp = ServiceProvider.Pp();
            b.a(Pp, bVar);
            h.execute(new bg() { // from class: com.kwad.sdk.core.config.e.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    e.bs(Pp);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.Gu();
    }

    public static String BA() {
        return c.azS.getOaid();
    }

    public static List<String> BB() {
        return c.azm.getValue();
    }

    public static boolean BC() {
        return c.aAe.getValue().intValue() == 1;
    }

    public static boolean BD() {
        return c.aAf.getValue().booleanValue();
    }

    public static boolean BE() {
        return c.aAh.getValue().intValue() == 1;
    }

    public static boolean BG() {
        return c.aAE.getValue().booleanValue();
    }

    public static boolean BH() {
        return c.aAF.getValue().booleanValue();
    }

    public static int BI() {
        if (aCh != null) {
            return aCh.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int BJ() {
        return c.aAH.getValue().intValue();
    }

    public static double BK() {
        return c.aAp.getValue().floatValue();
    }

    public static boolean BL() {
        return c.aBb.getValue().booleanValue();
    }

    public static boolean BP() {
        return c.aBr.getValue().booleanValue();
    }

    @Deprecated
    public static int BQ() {
        return c.azb.getValue().intValue();
    }

    public static boolean BR() {
        return c.aBv.Gz();
    }

    public static boolean BX() {
        return c.aBO.getValue().booleanValue();
    }

    public static int BY() {
        return c.aBP.getValue().intValue();
    }

    public static boolean BZ() {
        int intValue = c.aBQ.getValue().intValue();
        return intValue == 2 || intValue == 3;
    }

    public static int Bh() {
        return c.ayE.getValue().intValue();
    }

    public static boolean Bj() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return c.ayJ.getValue().intValue() == 1;
    }

    public static boolean Bv() {
        return c.azF.getValue().intValue() == 1;
    }

    public static boolean Bx() {
        return c.azG.getValue().intValue() == 1;
    }

    public static boolean By() {
        return c.azE.getValue().intValue() == 1;
    }

    public static String Bz() {
        return c.azS.getImei();
    }

    public static int Ca() {
        return c.aCb.getValue().intValue();
    }

    public static boolean Cg() {
        return c.aBG.Gz();
    }

    public static boolean EO() {
        return c.ayO.getValue().intValue() == 1;
    }

    public static int EP() {
        return c.ayP.getValue().intValue();
    }

    public static int EQ() {
        return c.ayQ.getValue().intValue();
    }

    public static boolean ER() {
        return c.ayS.getValue().intValue() > 0;
    }

    public static boolean ES() {
        return c.ayQ.getValue().intValue() == 2;
    }

    public static int ET() {
        return c.ayR.getValue().intValue();
    }

    public static boolean EU() {
        return c.ayW.getValue().intValue() > 0;
    }

    public static boolean EV() {
        return c.ayX.getValue().intValue() == 1;
    }

    public static int EW() {
        return c.ayW.getValue().intValue();
    }

    public static List<String> EY() {
        return c.azo.getValue();
    }

    @NonNull
    public static List<String> EZ() {
        return c.azn.getValue();
    }

    public static boolean FA() {
        return c.azc.getValue().booleanValue();
    }

    public static boolean FB() {
        return c.aAD.getValue().intValue() == 1;
    }

    public static int FC() {
        return c.aza.getValue().intValue();
    }

    public static int FD() {
        return c.aAj.getValue().intValue();
    }

    public static int FE() {
        return c.aAi.getValue().intValue();
    }

    public static boolean FF() {
        return c.aAk.getValue().intValue() == 1;
    }

    public static boolean FG() {
        return c.aAl.getValue().booleanValue();
    }

    public static float FH() {
        float floatValue = c.aAm.getValue().floatValue();
        if (floatValue <= 0.0f || floatValue > 1.0f) {
            return 0.3f;
        }
        return floatValue;
    }

    public static float FI() {
        return c.aAo.getValue().floatValue();
    }

    public static float FJ() {
        return c.aAn.getValue().floatValue();
    }

    public static boolean FK() {
        return c.aAq.getValue().booleanValue();
    }

    public static boolean FL() {
        return c.aAu.getValue().booleanValue();
    }

    public static boolean FM() {
        return c.aAv.getValue().intValue() > 0;
    }

    public static boolean FN() {
        return c.aAC.getValue().intValue() == 1;
    }

    public static long FO() {
        return c.aAA.getValue().longValue();
    }

    public static boolean FP() {
        return c.aAG.Gz();
    }

    public static com.kwad.sdk.core.network.idc.a.b FQ() {
        return c.aAI.getValue();
    }

    public static int FR() {
        return c.aAJ.getValue().intValue();
    }

    public static long FS() {
        return c.aAK.getValue().longValue();
    }

    public static int FT() {
        return c.aAL.getValue().intValue();
    }

    public static boolean FU() {
        return c.aAM.getValue().floatValue() == 1.0f;
    }

    public static boolean FV() {
        return c.aAN.Gz();
    }

    public static boolean FW() {
        return c.aAQ.Gz();
    }

    public static String FX() {
        return c.aAR.getValue();
    }

    public static String FY() {
        return c.aAS.getValue();
    }

    public static String FZ() {
        return c.aAT.getValue();
    }

    public static int Fa() {
        return c.aAO.getValue().intValue();
    }

    public static int Fb() {
        return c.aAP.getValue().intValue();
    }

    public static String Fc() {
        return c.azi.getValue();
    }

    public static String Fd() {
        return c.azj.getValue();
    }

    public static boolean Fe() {
        return c.ayK.getValue().intValue() == 1;
    }

    public static int Ff() {
        return c.ayL.getValue().intValue();
    }

    public static boolean Fg() {
        return c.ayM.getValue().intValue() == 1;
    }

    public static int Fh() {
        return c.ayN.getValue().intValue();
    }

    public static int Fi() {
        return c.azw.getValue().intValue();
    }

    public static int Fj() {
        return c.azx.getValue().intValue();
    }

    public static int Fk() {
        return c.azy.getValue().intValue();
    }

    public static long Fl() {
        return c.azz.getValue().intValue() * 60000;
    }

    public static boolean Fm() {
        return c.azI.getValue().intValue() == 1;
    }

    public static boolean Fn() {
        return c.azJ.getValue().intValue() == 1;
    }

    public static int Fo() {
        return c.azQ.getValue().intValue();
    }

    public static boolean Fp() {
        return c.azR.getValue().booleanValue();
    }

    public static boolean Fr() {
        return a(c.azX);
    }

    public static boolean Fs() {
        return !c.azY.getValue().booleanValue();
    }

    public static boolean Ft() {
        return a(c.azW);
    }

    public static boolean Fu() {
        return c.aAa.getValue().intValue() == 1;
    }

    public static int Fv() {
        return c.aAb.getValue().intValue();
    }

    @NonNull
    public static SdkConfigData Fw() {
        if (aCh != null) {
            return aCh;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            aCh = Fx();
        } else {
            synchronized (mLock) {
                try {
                    if (aCh == null) {
                        return Fx();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return aCh;
    }

    private static SdkConfigData Fx() {
        aCh = new SdkConfigData();
        String db = ag.db(ServiceProvider.Pp());
        if (TextUtils.isEmpty(db)) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "configCache is empty");
        } else {
            try {
                aCh.parseJson(new JSONObject(db));
            } catch (Exception e6) {
                com.kwad.sdk.core.d.c.printStackTrace(e6);
            }
        }
        return aCh;
    }

    public static boolean Fy() {
        return c.ayY.getValue().intValue() == 1;
    }

    public static boolean Fz() {
        return c.ayZ.getValue().intValue() == 1;
    }

    public static boolean Ga() {
        return c.aAV.getValue().booleanValue();
    }

    public static int Gb() {
        return c.aAW.getValue().intValue();
    }

    public static int Gc() {
        return c.aAY.getValue().intValue();
    }

    public static boolean Gd() {
        return c.aBd.getValue().booleanValue();
    }

    public static int Ge() {
        return c.aBe.getValue().intValue();
    }

    public static boolean Gf() {
        return c.aBD.Gz();
    }

    public static boolean Gg() {
        return c.aBF.Gz();
    }

    public static boolean Gh() {
        return c.aBK.getValue().booleanValue();
    }

    public static int Gi() {
        return c.aBM.getValue().intValue();
    }

    public static int Gj() {
        return c.aBL.getValue().intValue();
    }

    public static long Gk() {
        return c.ayU.getValue().longValue();
    }

    public static long Gl() {
        return c.ayV.getValue().longValue();
    }

    public static boolean Gm() {
        return c.ayC.getValue().booleanValue();
    }

    public static Long Gn() {
        return c.ayD.getValue();
    }

    public static boolean Go() {
        int intValue = c.aBQ.getValue().intValue();
        return intValue == 1 || intValue == 3;
    }

    public static long Gp() {
        return c.aBR.getValue().longValue();
    }

    public static String Gq() {
        return c.aBU.getValue();
    }

    public static String Gr() {
        return c.aBX.getValue();
    }

    public static String Gs() {
        return c.aBY.getValue();
    }

    public static boolean Gt() {
        return c.aBZ.Gz();
    }

    public static boolean ai(long j6) {
        return (j6 & c.azd.getValue().longValue()) != 0;
    }

    @WorkerThread
    public static synchronized void bs(Context context) {
        synchronized (e.class) {
            AtomicBoolean atomicBoolean = aCg;
            if (atomicBoolean.get()) {
                return;
            }
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "loadCache");
            c.init();
            EX();
            b.br(context);
            Fw();
            atomicBoolean.set(true);
        }
    }

    public static int ch(String str) {
        return c.aBJ.dA(str);
    }

    public static int ci(String str) {
        Integer value = c.azt.getValue(str);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            aCh = sdkConfigData;
        }
    }

    public static String getLogObiwanData() {
        return c.aAz.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.aBE.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.aBA.getValue();
    }

    public static String getUserAgent() {
        return c.aAg.getValue();
    }

    public static boolean hC() {
        return c.aAt.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return aCg.get();
    }

    public static boolean zx() {
        return c.aAU.getValue().booleanValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void EX() {
        com.kwad.components.ad.e.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static boolean Fq() {
        return com.kwad.sdk.core.h.a.JO();
    }

    public static int a(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        if (num == null) {
            num = kVar.Gu();
        }
        return num.intValue();
    }

    public static long a(o oVar) {
        Long l6 = (Long) b(oVar);
        if (l6 == null) {
            l6 = oVar.Gu();
        }
        return l6.longValue();
    }

    public static boolean b(k kVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) kVar);
        return num != null ? num.intValue() > 0 : kVar.Gu().intValue() > 0;
    }

    public static double a(f fVar) {
        Double d6 = (Double) b(fVar);
        if (d6 == null) {
            d6 = fVar.Gu();
        }
        return d6.doubleValue();
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean bool = (Boolean) b(dVar);
        if (bool == null) {
            bool = dVar.Gu();
        }
        return bool.booleanValue();
    }

    public static String a(r rVar) {
        String str = (String) b(rVar);
        return str != null ? str : rVar.Gu();
    }
}
