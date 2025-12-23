package com.kwad.components.core.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.r;
import java.util.List;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.DeviceInfoConstants;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b extends com.kwad.sdk.commercial.c.a {
    public int Qh;
    public boolean Qi;
    public boolean Qj;
    public boolean Ql;
    public String Qm;
    public boolean Qn;
    public long Qp;
    public double Qq;
    public boolean Qr;
    public List<String> Qs;
    public double Qt;
    public int Qu;
    public int Qv;
    public int Qw;
    public int Qx;
    public int defaultType;
    public int Qk = -1;
    public int Qo = -1;
    private boolean Qy = false;
    private boolean Qz = false;
    private boolean QA = false;
    private Context mContext = ServiceProvider.Pp();

    private static void a(b bVar) {
        try {
            String Gs = e.Gs();
            if (TextUtils.isEmpty(Gs)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(Gs);
            if (jSONObject.optBoolean("enableSlidingTrajectory", false)) {
                Pair<List<String>, Double> Eo = com.kwad.sdk.core.e.Eo();
                bVar.Qs = (List) Eo.first;
                bVar.Qt = ((Double) Eo.second).doubleValue();
                bVar.Qy = true;
            }
            if (jSONObject.optBoolean("enableAccessibility", false)) {
                bVar.Qi = ((Boolean) br.ee(bVar.mContext).first).booleanValue();
                bVar.Qj = ((Boolean) br.ee(bVar.mContext).second).booleanValue();
                bVar.Qz = true;
            }
            if (jSONObject.optBoolean("enableKeyguardSecure", false)) {
                bVar.Qr = ar(bVar.mContext);
                bVar.QA = true;
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static boolean ar(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null) {
                return keyguardManager.isKeyguardSecure();
            }
            return false;
        } catch (Throwable th) {
            c.printStackTrace(th);
            return false;
        }
    }

    private static int aq(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    private static int as(@NonNull Context context) {
        if (e.ai(512L)) {
            return -1;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent registerReceiver = context.registerReceiver(null, intentFilter);
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("plugged", -1);
                if (intExtra == 2) {
                    return 2;
                }
                if (intExtra == 1) {
                    return 1;
                }
                if (intExtra == 4) {
                    return 4;
                }
                if (intExtra == 0) {
                    return 0;
                }
            }
            return -1;
        } catch (Exception e6) {
            c.printStackTrace(e6);
            return -1;
        }
    }

    private static JSONObject b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            aa.putValue(jSONObject, "c_batterylevel", bVar.Qh);
            aa.putValue(jSONObject, "c_charging", bVar.Qk);
            aa.putValue(jSONObject, "is_cheat_user", bVar.Ql);
            aa.putValue(jSONObject, "c_operator", bVar.Qm);
            aa.putValue(jSONObject, "t_root", bVar.Qn);
            aa.putValue(jSONObject, "c_screenlight", bVar.Qo);
            aa.putValue(jSONObject, "c_total_memory", bVar.Qp);
            aa.putValue(jSONObject, "c_volume", bVar.Qq);
            aa.putValue(jSONObject, "c_screen_height", bVar.Qv);
            aa.putValue(jSONObject, "c_screen_width", bVar.Qw);
            aa.putValue(jSONObject, "density_dpi", bVar.Qx);
            aa.putValue(jSONObject, "default_type", bVar.defaultType);
            if (bVar.Qy) {
                if (!bVar.Qs.isEmpty()) {
                    aa.putValue(jSONObject, "s_origin_points", bVar.Qs);
                }
                double d6 = bVar.Qt;
                if (d6 != 0.0d) {
                    aa.putValue(jSONObject, "s_swipe_max_curvature", d6);
                }
            }
            if (bVar.Qz) {
                aa.putValue(jSONObject, "t_accessibility_enabled", bVar.Qi);
                aa.putValue(jSONObject, "t_accessibility_service_existed", bVar.Qj);
            }
            if (bVar.QA) {
                aa.putValue(jSONObject, "t_is_keyguard_secure", bVar.Qr);
            }
            return jSONObject;
        } catch (Throwable th) {
            c.printStackTrace(th);
            return jSONObject;
        }
    }

    private static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static b qi() {
        b bVar = new b();
        bVar.Qh = br.dR(bVar.mContext);
        bVar.Qm = ap(bVar.mContext);
        bVar.Qk = as(bVar.mContext);
        bVar.Qn = qj();
        bVar.Qo = SystemUtil.dQ(bVar.mContext);
        bVar.Qp = br.dS(bVar.mContext);
        bVar.Qq = SystemUtil.dP(bVar.mContext);
        bVar.Qx = aq(bVar.mContext);
        bVar.Qv = getScreenHeight(bVar.mContext);
        bVar.Qw = getScreenWidth(bVar.mContext);
        a(bVar);
        bVar.defaultType = 1;
        return bVar;
    }

    public final b aE(boolean z5) {
        this.Ql = z5;
        return this;
    }

    public final b aH(int i6) {
        this.Qu = i6;
        return this;
    }

    private b() {
    }

    private static String ap(Context context) {
        int d6 = ao.d(context, bd.dt(context), bc.useNetworkStateDisable());
        if (d6 != 1) {
            if (d6 != 2) {
                if (d6 != 3) {
                    return "unknown";
                }
                return DeviceInfoConstants.CarrierType.CARRIER_CUCC;
            }
            return DeviceInfoConstants.CarrierType.CARRIER_CTCC;
        }
        return DeviceInfoConstants.CarrierType.CARRIER_CMCC;
    }

    private static boolean qj() {
        d PQ = r.PQ();
        if (PQ == null || PQ.aWI != 1) {
            return false;
        }
        return true;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this);
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                bVar.Qh = jSONObject.optInt("c_batterylevel");
                bVar.Qi = jSONObject.optBoolean("t_accessibility_enabled");
                bVar.Qj = jSONObject.optBoolean("t_accessibility_service_existed");
                bVar.Qk = jSONObject.optInt("c_charging");
                bVar.Ql = jSONObject.optBoolean("is_cheat_user");
                bVar.Qm = jSONObject.optString("c_operator");
                bVar.Qn = jSONObject.optBoolean("t_root");
                bVar.Qo = jSONObject.optInt("c_screenlight");
                bVar.Qp = jSONObject.optLong("c_total_memory");
                bVar.Qq = jSONObject.optDouble("c_volume");
                bVar.Qr = jSONObject.optBoolean("t_is_keyguard_secure");
                bVar.Qs = aa.h(jSONObject.optJSONArray("s_origin_points"));
                bVar.Qt = jSONObject.optDouble("s_swipe_max_curvature");
                bVar.Qx = jSONObject.optInt("density_dpi");
                bVar.Qv = jSONObject.optInt("c_screen_height");
                bVar.Qw = jSONObject.optInt("c_screen_width");
                bVar.defaultType = jSONObject.optInt("default_type");
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }
}
