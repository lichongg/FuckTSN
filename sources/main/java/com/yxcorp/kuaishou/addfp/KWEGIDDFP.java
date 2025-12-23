package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.kuaishou.weapon.p0.g;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.a.e;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class KWEGIDDFP {
    private static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    private static int PROCESSALLOW = -1;
    private ResponseDfpCallback mCallBack;
    private String mEgid;
    private String mLocal;
    private Context mParamContext;
    private String mPkgName;
    private boolean mUserAgree;

    private KWEGIDDFP() {
        this.mPkgName = "";
        this.mEgid = "";
        this.mLocal = "";
        this.mUserAgree = false;
    }

    /* synthetic */ KWEGIDDFP(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        try {
            getEGidImpl(new e(this.mParamContext).a());
            this.mLocal = c.c().a(this.mParamContext, responseDfpCallback, TextUtils.isEmpty(this.mEgid));
            if (responseDfpCallback == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.mEgid) || (!TextUtils.isEmpty(this.mLocal) && !this.mLocal.startsWith("KWE"))) {
                responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
                return;
            }
            if (this.mLocal.equals("KWE_PE")) {
                return;
            }
            responseDfpCallback.onFailed(-2, "need check");
        } catch (Throwable th) {
            if (responseDfpCallback != null) {
                try {
                    responseDfpCallback.onFailed(-1, f.a(th));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void getEGidImpl(boolean z5) {
        Object obj;
        try {
            Pair a6 = d.a(this.mParamContext).a();
            if (a6 != null && (obj = a6.second) != null) {
                String str = (String) ((ConcurrentHashMap) obj).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.mEgid = str;
                }
            }
            if (TextUtils.isEmpty(this.mEgid)) {
                try {
                    String a7 = Build.VERSION.SDK_INT < 29 ? com.yxcorp.kuaishou.addfp.c.a.a.a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                    String a8 = (TextUtils.isEmpty(a7) && !d.a(this.mParamContext).b() && f.a(this.mParamContext, new String[]{g.f36049i, g.f36050j})) ? d.a(this.mParamContext).a("Lm91a2R0ZnQ=") : "";
                    if (TextUtils.isEmpty(a7) && TextUtils.isEmpty(a8)) {
                        return;
                    }
                    LinkedHashMap b6 = d.a(this.mParamContext).b(a7);
                    if (b6 == null || b6.size() == 0) {
                        b6 = d.a(this.mParamContext).b(a8);
                    }
                    if (b6 == null || b6.size() <= 0) {
                        return;
                    }
                    String str2 = (String) b6.get(c.c().a());
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.mEgid = str2;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void getEGidByCallback(Context context, boolean z5, ResponseDfpCallback responseDfpCallback) {
        try {
            this.mCallBack = responseDfpCallback;
            this.mParamContext = context;
            this.mUserAgree = z5;
            Thread thread = new Thread(new a(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String a6 = f.a(th);
            if (responseDfpCallback != null) {
                responseDfpCallback.onFailed(-1, a6);
            }
        }
    }

    public String getEGidLocal(Context context, String str, boolean z5) {
        if (TextUtils.isEmpty(this.mEgid)) {
            return null;
        }
        return this.mEgid;
    }

    public Context getParamContext() {
        return this.mParamContext;
    }

    public static String doSign(Context context, String str) {
        return Orange.getInstance().getClockWrapper(context, str.getBytes(), 20);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        c.a(jSONObject);
    }

    public static KWEGIDDFP instance() {
        KWEGIDDFP kwegiddfp;
        kwegiddfp = b.f42936a;
        return kwegiddfp;
    }

    public boolean setEgid(Context context, String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("DFP") && str.length() == 64) {
            d.a(context).a(str, "");
            return true;
        }
        return false;
    }

    public void setLog(boolean z5) {
        f.a(z5);
    }
}
