package xyz.adscope.ad;

import android.content.Context;
import android.text.TextUtils;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.StrategyFilterModel;
import xyz.adscope.ad.model.impl.resp.cfg.root.strategy.filter.complain.ComplainModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class i1 {
    public static boolean a(Context context, a2 a2Var, StrategyFilterModel strategyFilterModel) {
        if (a2Var != null && strategyFilterModel != null) {
            String spaceID = a2Var.getSpaceID();
            String apiKey = a2Var.getApiKey();
            if (!TextUtils.isEmpty(spaceID)) {
                long a6 = i0.a(context, a(apiKey), a("c_ts_%s", spaceID), 0L);
                if (a6 != 0) {
                    long currentTimeMillis = System.currentTimeMillis() - a6;
                    ComplainModel a7 = strategyFilterModel.a();
                    if (a7 != null && a7.a() > currentTimeMillis) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void a(Context context, a2 a2Var, long j6) {
        if (a2Var != null) {
            String spaceID = a2Var.getSpaceID();
            String apiKey = a2Var.getApiKey();
            if (j6 != 0) {
                i0.b(context, a(apiKey), a("c_ts_%s", spaceID), j6);
            }
        }
    }

    private static String a(String str) {
        return String.format("ansp_complain_%s", str);
    }

    private static String a(String str, String str2) {
        return String.format(str, str2);
    }
}
