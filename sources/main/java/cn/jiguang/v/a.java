package cn.jiguang.v;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.al.g;
import cn.jiguang.bb.f;
import cn.jiguang.bi.i;
import cn.jiguang.bz.s;
import cn.jiguang.bz.v;
import cn.jiguang.i.e;
import cn.jiguang.m.c;
import cn.jpush.android.service.PushReceiver;
import com.amap.api.services.core.AMapException;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.kwad.library.solder.lib.ext.PluginError;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f3290a = ".permission.JPUSH_MESSAGE";

    /* renamed from: b, reason: collision with root package name */
    private static long f3291b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f3292c;

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Object obj) {
        return ((obj instanceof Bundle) && ((Bundle) obj).getBoolean("login")) ? 2 : 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Object a(final Context context, String str, final Object obj) {
        String action;
        String str2;
        String str3;
        try {
        } catch (Throwable th) {
            f.i("JCommonActionHelper", "onEvent throwable:" + th.getMessage());
        }
        if (context == null) {
            f.i("JCommonActionHelper", "context is null,give up continue");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            f.i("JCommonActionHelper", "action is null,give up continue");
            return null;
        }
        if (TextUtils.isEmpty(c.a.f3098b)) {
            c.a.f3098b = cn.jiguang.bz.a.a().B(context);
        }
        switch (str.hashCode()) {
            case -1677912609:
                if (str.equals("get_installed_pkg_list")) {
                    return cn.jiguang.common.app.helper.b.a(context, false, obj);
                }
                break;
            case -879126258:
                if (str.equals("tcp_a1")) {
                    f.c("JCommonActionHelper", "action service  create..");
                    cn.jiguang.q.c.b().a(context, 5);
                    break;
                }
                break;
            case -24181482:
                if (str.equals("get_loc_info")) {
                    return cn.jiguang.aj.a.a().g(context);
                }
                break;
            case 385278662:
                if (str.equals("periodtask")) {
                    f.c("JCommonActionHelper", "action period task..");
                    cn.jiguang.q.c.b().a(context, new cn.jiguang.q.b() { // from class: cn.jiguang.v.a.1
                        @Override // cn.jiguang.q.b
                        public void a() {
                            f.c("JCommonActionHelper", "data config is prepare finished");
                            cn.jiguang.bw.a.a().b();
                            a.b(context, obj);
                        }
                    });
                    cn.jiguang.aq.a.a().b(context);
                    break;
                }
                break;
            case 781805572:
                if (str.equals("deviceinfo")) {
                    if (cn.jiguang.g.a.a().a(1000)) {
                        return cn.jiguang.r.b.a().g(context);
                    }
                    return null;
                }
                break;
            case 805881853:
                if (str.equals("getwakeenable")) {
                    return cn.jiguang.ar.a.c(context);
                }
                break;
            case 1282759650:
                if (str.equals("on_logged")) {
                    f.c("JCommonActionHelper", "action on logged...");
                    a(context);
                    break;
                }
                break;
            case 1567409176:
                if (str.equals("filter_pkg_list")) {
                    return cn.jiguang.ar.a.a(context, obj);
                }
                break;
            case 1660517635:
                if (str.equals("on_register")) {
                    if (cn.jiguang.g.a.a().a(1000)) {
                        cn.jiguang.r.b.a().b(context, cn.jiguang.g.a.a().b(1000));
                    }
                    g.a().b(context, cn.jiguang.aj.a.a().b(true));
                    cn.jiguang.aq.a.a().a(context);
                    if (cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING)) {
                        cn.jiguang.am.a.a(context, 1);
                        break;
                    }
                }
                break;
            case 1976348689:
                if (str.equals("get_imei")) {
                    cn.jiguang.q.c.b().a(context, 1);
                    return cn.jiguang.g.a.a().e(PluginError.ERROR_UPD_EXTRACT) ? cn.jiguang.u.c.a(context, "") : "";
                }
                break;
            case 1979938307:
                if (str.equals("uid_switch")) {
                    return Boolean.valueOf(cn.jiguang.g.a.a().a(2300));
                }
                break;
        }
        Bundle bundle = obj instanceof Bundle ? (Bundle) obj : null;
        if (bundle != null) {
            switch (str.hashCode()) {
                case -1921540966:
                    if (str.equals("foreground_state_change")) {
                        cn.jiguang.au.f.a().a(context, bundle.getBoolean("foreground"));
                        break;
                    }
                    break;
                case -1485564867:
                    if (str.equals("notification_state") && cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING)) {
                        cn.jiguang.am.a.a(context, bundle.getInt("scence"));
                        break;
                    }
                    break;
                case -955011762:
                    str2 = "init_local_ctrl";
                    str.equals(str2);
                    break;
                case -955005568:
                    if (str.equals("lbsenable") && cn.jiguang.g.a.a().a(1500)) {
                        boolean z5 = bundle.getBoolean("enable");
                        f.c("JCommonActionHelper", "[setLBSEnable] " + z5);
                        cn.jiguang.m.b.b(context, "JLocation", z5);
                        break;
                    }
                    break;
                case -691876648:
                    if (str.equals("set_ctrl_url")) {
                        cn.jiguang.au.b.a(a(bundle.getString("test_wake_controll_url")));
                        cn.jiguang.q.c.a(a(bundle.getString("test_all_cfg_url")));
                        cn.jiguang.al.f.a(a(bundle.getString("test_lv2_url")));
                        e.a(a(bundle.getString("test_active_conf_url")));
                        cn.jiguang.aq.a.f1657a = bundle.getString("test_uaid_url");
                        cn.jiguang.r.f.f3216a = bundle.getString("test_ipv6_url");
                        cn.jiguang.g.a.a(bundle);
                        break;
                    }
                    break;
                case -504314929:
                    if (str.equals("open_log")) {
                        cn.jiguang.d.a.a(context, new JSONObject(v.b(bundle.getString("aes"), c.a.f3106j)), true);
                        break;
                    }
                    break;
                case -50423372:
                    if (str.equals("GET_ANDROID_ID") && bundle.getInt("s_a_id") == 2000) {
                        cn.jiguang.bz.a.a().c(context, true);
                        break;
                    }
                    break;
                case 98618:
                    if (str.equals("cmd")) {
                        a(context, bundle);
                        break;
                    }
                    break;
                case 112894784:
                    if (str.equals("waked")) {
                        int i6 = bundle.getInt("type", -1);
                        if (!TextUtils.isEmpty(bundle.getString("from_package"))) {
                            if (i6 != -1) {
                                cn.jiguang.au.g.a(context, bundle, i6);
                                break;
                            } else {
                                str3 = "[waked]wrong waked type";
                            }
                        } else {
                            str3 = "[waked]empty packageName waked from ";
                        }
                        f.i("JCommonActionHelper", str3);
                        break;
                    }
                    break;
                case 1196294537:
                    if (str.equals("action_net_changed") && bundle.getBoolean("connected")) {
                        cn.jiguang.bz.a.a().a(context, true);
                        cn.jiguang.bz.a.a().b(context, true);
                        break;
                    }
                    break;
                case 1391522972:
                    str2 = "lbsforenry";
                    str.equals(str2);
                    break;
                case 1995819041:
                    if (str.equals("set_wake_enable")) {
                        cn.jiguang.m.b.a(context, bundle.getBoolean("enable"));
                        break;
                    }
                    break;
                case 2063320150:
                    if (str.equals("set_sdktype_info")) {
                        new cn.jiguang.ap.a().a(context, bundle);
                        break;
                    }
                    break;
            }
        }
        Intent intent = obj instanceof Intent ? (Intent) obj : null;
        if (intent != null && str.hashCode() == 1563192504 && str.equals("get_receiver") && (action = intent.getAction()) != null && ((c.a.f3108l.equals(action) || c.a.f3109m.equals(action)) && cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR))) {
            cn.jiguang.h.c.a().a(context, intent);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(final android.content.Context r6, final java.lang.Object r7) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.v.a.b(android.content.Context, java.lang.Object):void");
    }

    private static LinkedList<String> a(String str) {
        try {
            LinkedList<String> linkedList = new LinkedList<>();
            if (str != null && str.length() > 0) {
                for (String str2 : str.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        linkedList.add(str2);
                    }
                }
            }
            return linkedList;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String a6 = cn.jiguang.bv.d.a();
        if (TextUtils.isEmpty(a6) || !str.equalsIgnoreCase(a6)) {
            cn.jiguang.bv.c.b();
        }
    }

    private static JSONObject a(Bundle bundle) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bundle.getByteArray("RESPONSE_BODY"));
            f3291b = wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            f.c("JCommonActionHelper", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e6) {
            f.i("JCommonActionHelper", "parseBundle2Json exception:" + e6.getMessage());
            return null;
        }
    }

    private static void a(Context context) {
        try {
            if (f3292c != null) {
                return;
            }
            f3292c = Boolean.TRUE;
            boolean b6 = cn.jiguang.bz.b.b(context);
            boolean a6 = cn.jiguang.g.c.a().a(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR);
            boolean z5 = false;
            boolean a7 = cn.jiguang.g.a.a().a(AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR, false);
            f.c("JCommonActionHelper", "registerPushReceiver enableAutoWakeup=" + b6);
            f.c("JCommonActionHelper", "registerPushReceiver containEnableDatas=" + a6);
            f.c("JCommonActionHelper", "registerPushReceiver configEnable=" + a7);
            if ((b6 || a6) && a7) {
                z5 = true;
            }
            f.c("JCommonActionHelper", "registerPushReceiver enable=" + z5);
            if (z5) {
                PushReceiver pushReceiver = new PushReceiver();
                String str = context.getPackageName() + f3290a;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(c.a.f3108l);
                intentFilter.addAction(c.a.f3109m);
                intentFilter.addDataScheme(WiseOpenHianalyticsData.UNION_PACKAGE);
                s.a(context, pushReceiver, intentFilter, str, null, false);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i6) {
        i.a().a(context, b.a(), 25, 1, b.a(f3291b, cn.jiguang.u.a.a(context, i6)), "JCOMMON");
    }

    private static void a(Context context, Bundle bundle) {
        a(context, a(bundle));
    }

    public static void a(Context context, JSONObject jSONObject) {
        Integer valueOf = Integer.valueOf(PluginError.ERROR_UPD_EXTRACT);
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("cmd");
        a(context, optInt);
        if (optInt == 4) {
            if (!cn.jiguang.g.a.a().h(1100)) {
                cn.jiguang.bw.a.a().f(valueOf);
                return;
            }
            cn.jiguang.bw.a.a().f((Object) 2081);
            cn.jiguang.h.b.a().a(true);
            cn.jiguang.h.b.a().d(context);
            return;
        }
        if (optInt != 5) {
            if (optInt == 9) {
                if (cn.jiguang.g.a.a().e(1300)) {
                    cn.jiguang.h.d.a().d(context);
                    return;
                }
                return;
            }
            if (optInt == 50) {
                cn.jiguang.ar.b.a(context, jSONObject);
                return;
            }
            if (optInt == 52) {
                if (!cn.jiguang.g.a.a().h(1600)) {
                    cn.jiguang.bw.a.a().g(valueOf);
                    return;
                } else {
                    cn.jiguang.bw.a.a().g(2081);
                    cn.jiguang.j.a.a().b(context, jSONObject);
                    return;
                }
            }
            if (optInt == 54) {
                if (cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT)) {
                    cn.jiguang.h.f.a().a(context, jSONObject);
                    return;
                }
                return;
            }
            if (optInt == 70) {
                cn.jiguang.ar.a.a(context);
                return;
            }
            if (optInt == 74) {
                if (cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT)) {
                    cn.jiguang.h.g.a().d(context);
                    return;
                }
                return;
            }
            if (optInt == 79) {
                g.a().b(context, 0);
                return;
            }
            if (optInt == 86) {
                a(jSONObject);
                return;
            }
            if (optInt == 44) {
                if (cn.jiguang.g.a.a().e(AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT)) {
                    cn.jiguang.h.f.a().d(context);
                    return;
                }
                return;
            } else if (optInt != 45) {
                switch (optInt) {
                    case 81:
                        if (cn.jiguang.g.a.a().h(2400)) {
                            if (!cn.jiguang.ba.c.d()) {
                                f.i("JCommonActionHelper", "not contain jpush sdk, give up collect bluetooth");
                                break;
                            } else {
                                cn.jiguang.n.a.a().a(context, jSONObject);
                                break;
                            }
                        }
                        break;
                    case 82:
                        cn.jiguang.d.a.a(context, jSONObject, true);
                        break;
                    case 83:
                        cn.jiguang.r.f.a().a(true);
                        cn.jiguang.r.f.a().d(context);
                        break;
                }
                return;
            }
        }
        if (!cn.jiguang.g.a.a().h(AVMDLDataLoader.KeyIsIsTestSpeedVersion)) {
            cn.jiguang.bw.a.a().c(valueOf);
            return;
        }
        cn.jiguang.bw.a.a().c((Object) 2081);
        cn.jiguang.aj.a.a().a(true);
        cn.jiguang.aj.a.a().b(context, jSONObject);
    }

    public static void a(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("content");
            if (jSONObject2 == null) {
                return;
            }
            int optInt = jSONObject2.optInt("code");
            if (160 == optInt) {
                optString = jSONObject2.optString("s_c");
                int optInt2 = jSONObject2.optInt("e_n", 0);
                f.c("JCommonActionHelper", "update enable: " + optInt2);
                if (optInt2 == 1) {
                    r5 = true;
                }
            } else {
                if (163 == optInt) {
                    String optString2 = jSONObject2.optString("s_c");
                    f.c("JCommonActionHelper", "update url: " + optString2);
                    cn.jiguang.bv.d.d(cn.jiguang.bv.d.a(optString2));
                    return;
                }
                if (159 == optInt) {
                    cn.jiguang.bv.d.a(jSONObject2.optInt("e_n", 0) == 1);
                    return;
                }
                if (157 != optInt) {
                    cn.jiguang.bv.e.a(cn.jiguang.ba.a.a(cn.jiguang.bz.d.a()), cn.jiguang.d.a.f(cn.jiguang.bz.d.a()), optInt, jSONObject2.optString("s_c"));
                    return;
                }
                optString = jSONObject2.optString("zm");
                int optInt3 = jSONObject2.optInt("en");
                int optInt4 = jSONObject2.optInt("dy");
                String optString3 = jSONObject2.optString("ul");
                if (!TextUtils.isEmpty(optString3)) {
                    cn.jiguang.bv.d.d(cn.jiguang.bv.d.a(optString3));
                }
                cn.jiguang.bv.d.a(optInt3 == 1);
                if (optInt4 == 1) {
                    r5 = true;
                }
            }
            cn.jiguang.bv.d.b(r5);
            b(optString);
        } catch (Throwable unused) {
        }
    }
}
