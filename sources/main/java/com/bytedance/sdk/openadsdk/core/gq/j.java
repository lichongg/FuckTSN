package com.bytedance.sdk.openadsdk.core.gq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.amap.api.services.district.DistrictSearchQuery;
import com.bytedance.sdk.component.utils.tl;
import com.bytedance.sdk.component.utils.up;
import com.bytedance.sdk.openadsdk.core.cw.r;
import com.bytedance.sdk.openadsdk.core.gq.j.cw;
import com.bytedance.sdk.openadsdk.core.gq.j.xt;
import com.bytedance.sdk.openadsdk.core.rn.oq;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.st;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j {

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile j f29105j;
    private static final List<String> jy = Arrays.asList("-10001", "-10008", "103111", "105002", "-5", "-2", "-15", "-10", "-11");
    private final cw cw;

    /* renamed from: r, reason: collision with root package name */
    private final st f29108r;
    private String[] tl;
    private final r up;
    private final Context xt;
    private final AtomicBoolean ae = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    private long f29106g = 0;
    private long oq = 0;
    private long qv = 0;
    private long vl = 0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f29107m = true;

    private void cw() {
        r rVar = this.up;
        if (rVar != null) {
            this.oq = rVar.xt("uni_fir_ts", 0L);
            if (uf.j(System.currentTimeMillis(), this.oq)) {
                this.qv = this.up.xt("uni_times", 0L);
                this.vl = this.up.xt("uni_ts", 0L);
            } else {
                this.qv = 0L;
                this.vl = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.ae.set(false);
        this.cw.xt();
    }

    private boolean xt() {
        r rVar = this.up;
        if (rVar != null) {
            String cw = rVar.cw("cr", 3300000L);
            if (!TextUtils.isEmpty(cw) && !TextUtils.isEmpty(this.up.cw("tk", j(cw)))) {
                return true;
            }
        }
        return false;
    }

    private j(Context context) {
        this.xt = context;
        this.cw = cw.j(context);
        r j6 = r.j();
        this.up = j6;
        if (j6 != null) {
            String cw = j6.cw("cr", 3300000L);
            if (!TextUtils.isEmpty(cw)) {
                this.f29108r = new st(j6.cw("vd", j(cw)), j6.cw(NotificationCompat.CATEGORY_ERROR, j(cw)), j6.cw("tk", j(cw)), j6.cw("cr", j(cw)));
            } else {
                this.f29108r = new st("", "", "", "");
            }
            cw();
            return;
        }
        this.f29108r = new st("", "-1", "", "");
    }

    private long j(String str) {
        String str2;
        switch (str.hashCode()) {
            case 49:
                str2 = "1";
                break;
            case 50:
                return str.equals("2") ? 50000L : 3300000L;
            case 51:
                str2 = "3";
                break;
            default:
                return 3300000L;
        }
        str.equals(str2);
        return 3300000L;
    }

    public static j j(Context context) {
        if (f29105j == null) {
            synchronized (j.class) {
                try {
                    if (f29105j == null) {
                        f29105j = new j(context);
                    }
                } finally {
                }
            }
        }
        return f29105j;
    }

    public st j() {
        if (!xt() && this.f29107m) {
            if (!this.ae.compareAndSet(false, true)) {
                return this.f29108r;
            }
            tl.j().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gq.j.1
                /* JADX WARN: Removed duplicated region for block: B:10:0x00cf  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x00e2  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instructions count: 294
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.gq.j.AnonymousClass1.run():void");
                }
            });
            return this.f29108r;
        }
        return this.f29108r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0101 A[EDGE_INSN: B:53:0x0101->B:43:0x0101 BREAK  A[LOOP:0: B:2:0x0006->B:28:0x0006], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(android.net.Network r15, java.util.List<java.lang.String> r16) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.gq.j.j(android.net.Network, java.util.List):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void j(Network network, String str, String str2, String str3, String str4, String str5) {
        String str6;
        String string;
        String str7;
        JSONObject j6 = ("1".equals(str3) && TextUtils.isEmpty(str2)) ? null : xt.j(network, str, str2);
        String str8 = "";
        if (j6 == null) {
            this.f29108r.j(str4, "6", "", str3);
            return;
        }
        try {
            switch (str3.hashCode()) {
                case 49:
                    if (str3.equals("1")) {
                        JSONObject jSONObject = j6.getJSONObject("body");
                        String string2 = jSONObject.getString("resultCode");
                        if (!"103000".equals(string2)) {
                            str6 = "";
                            str8 = string2;
                            break;
                        } else {
                            string = jSONObject.getString(JThirdPlatFormInterface.KEY_TOKEN);
                            str6 = string;
                            str8 = "0";
                            break;
                        }
                    }
                    str6 = "";
                    break;
                case 50:
                    if (str3.equals("2")) {
                        if (!j6.has("code")) {
                            str7 = "";
                        } else {
                            str7 = j6.optString("code");
                        }
                        if (j6.has("authurl")) {
                            String string3 = j6.getString("authurl");
                            if (!TextUtils.isEmpty(string3)) {
                                Pair<String, String> j7 = j(network, string3 + "/api?appid=1554778161154", str3, str4);
                                Object obj = j7.first;
                                if (obj != null) {
                                    str7 = (String) obj;
                                }
                                Object obj2 = j7.second;
                                if (obj2 != null) {
                                    str8 = (String) obj2;
                                }
                            }
                        }
                        str6 = str8;
                        str8 = str7;
                        break;
                    }
                    str6 = "";
                    break;
                case 51:
                    if (str3.equals("3")) {
                        String valueOf = String.valueOf(j6.getInt("result"));
                        if (!"0".equals(valueOf)) {
                            str8 = valueOf;
                            str6 = "";
                            break;
                        } else {
                            string = new JSONObject(com.bytedance.sdk.openadsdk.core.gq.j.j.j(false, up.j(j6.getString("data")), str5)).getString("accessCode");
                            str6 = string;
                            str8 = "0";
                            break;
                        }
                    }
                    str6 = "";
                    break;
                default:
                    str6 = "";
                    break;
            }
            this.f29108r.j(str4, str8, str6, str3);
            if (this.up == null || TextUtils.isEmpty(str6)) {
                return;
            }
            this.up.r("vd", str4);
            this.up.r("cr", str3);
            this.up.r(NotificationCompat.CATEGORY_ERROR, str8);
            this.up.r("tk", str6);
        } catch (Exception unused) {
        }
    }

    private Pair<String, String> j(Network network, String str, String str2, String str3) {
        String str4;
        JSONObject j6 = xt.j(network, str, null);
        try {
            if (j6 == null) {
                this.f29108r.j(str3, "6", "", str2);
                return new Pair<>("6", "");
            }
            String string = j6.has("err_code") ? j6.getString("err_code") : "6";
            if (this.tl == null || System.currentTimeMillis() - this.f29106g > 3600000) {
                this.tl = oq.g();
                this.f29106g = System.currentTimeMillis();
            }
            String[] strArr = this.tl;
            if (strArr.length == 2 && !TextUtils.isEmpty(strArr[1])) {
                this.f29108r.j(this.tl[1]);
            }
            if (j6.has(DistrictSearchQuery.KEYWORDS_PROVINCE)) {
                this.f29108r.xt(j6.getString(DistrictSearchQuery.KEYWORDS_PROVINCE));
            }
            if (!j6.has("code")) {
                str4 = "";
            } else {
                string = "0";
                str4 = j6.getString("code");
            }
            return new Pair<>(string, str4);
        } catch (Throwable unused) {
            return new Pair<>("6", "");
        }
    }
}
