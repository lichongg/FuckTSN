package com.kwad.sdk.core.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.LocaleList;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.m;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b implements c {
    private static Locale aKg;
    private String aFk;
    private boolean aKe = true;
    private Map<String, String> aKf = new LinkedHashMap();

    private StringBuilder JT() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.aKf.entrySet()) {
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append("/");
            sb.append(entry.getValue());
        }
        return sb;
    }

    private static String JU() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            localeList = LocaleList.getDefault();
            locale = localeList.get(0);
            aKg = locale;
        } else {
            aKg = Locale.getDefault();
        }
        if (aKg == null) {
            aKg = Locale.CHINESE;
        }
        return aKg.getLanguage();
    }

    private void bK(Context context) {
        this.aKf.put("Yoda", "3.2.11-rc1");
        this.aKf.put("Kwai", "11.8.10");
        this.aKf.put("OS_PRO_BIT", String.valueOf(AbiUtil.isArm64(context) ? 1 : 0));
        this.aKf.put("MAX_PHY_MEM", String.valueOf(br.dS(context) >> 20));
        this.aKf.put("KDT", "PHONE");
        this.aKf.put("AZPREFIX", "az4");
        this.aKf.put("ICFO", "0");
        this.aKf.put("StatusHT", String.valueOf(com.kwad.sdk.c.a.a.bh(context)));
        this.aKf.put("TitleHT", "44");
        this.aKf.put("NetType", bM(context));
        this.aKf.put("ISLP", String.valueOf(bN(context)));
        this.aKf.put("ISDM", String.valueOf(bO(context)));
        int dR = br.dR(context);
        this.aKf.put("ISLB", String.valueOf((dR <= 0 || dR >= 15) ? 0 : 1));
        this.aKf.put("locale", JU());
        this.aKf.put("SHP", String.valueOf(m.getScreenHeight(context)));
        this.aKf.put("SWP", String.valueOf(m.getScreenWidth(context)));
        this.aKf.put("SD", String.valueOf(m.cK(context)));
        this.aKf.put("CD", "0");
        this.aKf.put("ISLM", String.valueOf(bP(context)));
    }

    private String bL(Context context) {
        if (!TextUtils.isEmpty(this.aFk)) {
            return this.aFk;
        }
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception e6) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e6);
        }
        if (!TextUtils.isEmpty(this.aFk)) {
            return this.aFk;
        }
        this.aFk = WebSettings.getDefaultUserAgent(context);
        return this.aFk;
    }

    private static String bM(Context context) {
        String str = "DISABLE";
        if (context == null) {
            return "DISABLE";
        }
        NetworkInfo de = ao.de(context);
        if (de != null) {
            int type = de.getType();
            if (type != 0) {
                return type != 1 ? "unknown" : "WIFI";
            }
            str = de.getSubtypeName();
            if (TextUtils.isEmpty(str)) {
                return de.getTypeName();
            }
        }
        return str;
    }

    private static int bP(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.lowMemory || memoryInfo.availMem <= aH(memoryInfo.threshold) + aI(Debug.getPss())) ? 1 : 0;
    }

    @Override // com.kwad.sdk.core.i.c
    public final String JS() {
        return this.aKe ? "kwai-android aegon/4.6.3.1" : "kwai-android aegon/4.6.3";
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bJ(Context context) {
        try {
            if (this.aKf.isEmpty()) {
                bK(context);
            }
            StringBuilder JT = JT();
            if (this.aKe) {
                JT.insert(0, " KRN/3.6.6");
            }
            return JT.toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("KwaiUAGetter", "getWebViewUASuffix: " + th.getMessage());
            return "";
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public final void bt(boolean z5) {
        this.aKe = z5;
    }

    private static long aH(long j6) {
        if (j6 > 524288000) {
            return 524288000L;
        }
        return j6;
    }

    private static long aI(long j6) {
        long j7;
        long j8 = j6 / 512000;
        if (j8 == 0) {
            return 524288000L;
        }
        if (j8 == 1) {
            j7 = j6 / 2;
        } else {
            j7 = j6 / 3;
        }
        return j7 * 1024;
    }

    private static int bN(Context context) {
        long dS = br.dS(context) >> 20;
        if (AbiUtil.isArm64(context) && dS > 4096) {
            return 0;
        }
        return 1;
    }

    private static int bO(Context context) {
        try {
            if ((context.getResources().getConfiguration().uiMode & 48) == 32) {
                return 1;
            }
            return 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return 0;
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bI(Context context) {
        return bL(context);
    }
}
