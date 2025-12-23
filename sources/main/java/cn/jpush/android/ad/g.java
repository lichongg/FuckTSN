package cn.jpush.android.ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.google.common.base.Ascii;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    private static String f3446c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f3447d = {84, 85, 108, 72, 90, 107, 49, 66, 77, 69, 100, 68, 85, 51, 70, 72, 85, 48, 108, 105, 77, 48, 82, 82, 82, 85, 74, 66, 85, 86, 86, 66, 81, 84, 82, 72, 84, 107, 70, 69, 81, 48, 74, 112, 85, 85, 116, 67, 90, 49, 70, 68, 99, 108, 108, 108, 81, 122, 78, 81, 90, 69, 120, 122, 89, 88, 90, 77, 90, 106, 104, 69, 90, 84, 108, 71, 89, 122, 81, 51, 78, 50, 104, 78, 83, 119, 112, 110, 100, 108, 90, 68, 78, 72, 104, 85, 99, 50, 53, 89, 87, 71, 86, 78, 99, 85, 104, 111, 87, 85, 120, 68, 98, 88, 108, 77, 82, 72, 85, 51, 81, 122, 90, 82, 78, 70, 107, 120, 77, 71, 82, 49, 100, 106, 100, 76, 98, 108, 112, 105, 99, 105, 116, 110, 98, 51, 100, 90, 82, 87, 81, 53, 85, 122, 82, 78, 77, 48, 108, 72, 98, 122, 100, 110, 90, 106, 66, 118, 99, 85, 112, 117, 67, 107, 120, 77, 100, 107, 90, 54, 83, 69, 116, 54, 90, 70, 74, 106, 99, 87, 115, 49, 99, 88, 112, 117, 89, 87, 57, 118, 90, 50, 120, 68, 81, 122, 65, 48, 82, 109, 104, 74, 97, 108, 74, 80, 87, 72, 104, 50, 81, 108, 90, 54, 79, 71, 100, 66, 98, 51, 90, 104, 90, 107, 53, 90, 99, 109, 120, 76, 78, 109, 104, 105, 90, 85, 82, 79, 84, 107, 49, 78, 84, 50, 57, 73, 83, 108, 65, 75, 82, 50, 100, 112, 85, 71, 82, 87, 97, 50, 70, 109, 89, 108, 82, 107, 81, 108, 78, 89, 97, 110, 112, 51, 83, 85, 82, 66, 85, 85, 70, 67};

    /* renamed from: e, reason: collision with root package name */
    private static final String f3448e = d.b(new byte[]{68, 66, 113, 15, 87, 103, 120, 116, Ascii.US, 112, 82, 75, 69, 32, 96, 65, 125, 108, Byte.MAX_VALUE, Byte.MAX_VALUE, 87});
    private int A;

    /* renamed from: a, reason: collision with root package name */
    private Context f3449a;

    /* renamed from: b, reason: collision with root package name */
    private final String f3450b;

    /* renamed from: f, reason: collision with root package name */
    private final String f3451f;

    /* renamed from: g, reason: collision with root package name */
    private final String f3452g;

    /* renamed from: h, reason: collision with root package name */
    private final String f3453h;

    /* renamed from: i, reason: collision with root package name */
    private final String f3454i;

    /* renamed from: j, reason: collision with root package name */
    private final String f3455j;

    /* renamed from: k, reason: collision with root package name */
    private final String f3456k;

    /* renamed from: l, reason: collision with root package name */
    private final String f3457l;

    /* renamed from: m, reason: collision with root package name */
    private final String f3458m;

    /* renamed from: n, reason: collision with root package name */
    private final String f3459n;

    /* renamed from: o, reason: collision with root package name */
    private final String f3460o;

    /* renamed from: p, reason: collision with root package name */
    private final String f3461p;

    /* renamed from: q, reason: collision with root package name */
    private final String f3462q;

    /* renamed from: r, reason: collision with root package name */
    private final String f3463r;

    /* renamed from: s, reason: collision with root package name */
    private final String f3464s;

    /* renamed from: t, reason: collision with root package name */
    private final String f3465t;

    /* renamed from: u, reason: collision with root package name */
    private final int f3466u;

    /* renamed from: v, reason: collision with root package name */
    private final int f3467v;

    /* renamed from: w, reason: collision with root package name */
    private final int f3468w;

    /* renamed from: x, reason: collision with root package name */
    private final int f3469x;

    /* renamed from: y, reason: collision with root package name */
    private final int f3470y;

    /* renamed from: z, reason: collision with root package name */
    private final int f3471z;

    /* renamed from: cn.jpush.android.ad.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final g f3472a = new g(null);
    }

    private g() {
        this.f3450b = "JPUSH_JUMP";
        this.f3451f = JThirdPlatFormInterface.KEY_MSG_ID;
        this.f3452g = JThirdPlatFormInterface.KEY_ROM_TYPE;
        this.f3453h = "n_title";
        this.f3454i = "n_content";
        this.f3455j = "m_content";
        this.f3456k = "n_extras";
        this.f3457l = "n_intent";
        this.f3458m = "n_url";
        this.f3459n = "n_ssl";
        this.f3460o = "n_fail_handle_type";
        this.f3461p = "n_fail_handle_url";
        this.f3462q = "n_package_name";
        this.f3463r = "notification_id";
        this.f3464s = "_j_data_";
        this.f3465t = "n_type";
        this.f3466u = 1;
        this.f3467v = 2;
        this.f3468w = 3;
        this.f3469x = 1;
        this.f3470y = 2;
        this.f3471z = 3;
        this.A = 0;
    }

    private Intent a(String str) {
        return cn.jpush.android.ad.a.a(str, Build.VERSION.SDK_INT >= 22 ? 4 : 0);
    }

    private String b() {
        return new String(Base64.decode(f3447d, 2));
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return l.b(str, b(), f3448e);
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkJumpConfig rsa=" + th);
            return "";
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a() {
        return a.f3472a;
    }

    private String b(String str) {
        try {
            Intent a6 = a(str);
            a6.setPackage(this.f3449a.getPackageName());
            return this.f3449a.getPackageManager().resolveActivity(a6, 0).activityInfo.name;
        } catch (Throwable unused) {
            return "";
        }
    }

    private void c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
            if (bundle != null) {
                f3446c = bundle.getString("JPUSH_JUMP");
                Logger.d("JumpManager", "getJumpConfig config =" + f3446c);
            }
        } catch (Throwable th) {
            Logger.d("JumpManager", "getJumpConfig =" + th.getMessage());
        }
    }

    private String a(byte b6) {
        if (b6 == 16) {
            return "nio";
        }
        switch (b6) {
            case 1:
                return "xiaomi";
            case 2:
                return "huawei";
            case 3:
                return "meizu";
            case 4:
                return "oppo";
            case 5:
                return "vivo";
            case 6:
                return "asus";
            case 7:
                return "HONOR";
            case 8:
                return "fcm";
            default:
                return "jpush";
        }
    }

    private void b(Context context) {
        if (this.f3449a == null) {
            this.f3449a = context;
        }
    }

    private String a(Intent intent) {
        String str;
        if (intent.getData() != null) {
            str = intent.getData().toString();
            Logger.d("JumpManager", "华为：" + str);
            this.A = 1;
        } else {
            str = null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            str = extras.getString("JMessageExtra");
            Logger.d("JumpManager", "fcm、oppo、vivo、华硕、小米、HONOR：" + str);
            this.A = 2;
        }
        if (TextUtils.isEmpty(str)) {
            str = extras.getString("key_app_data");
            Logger.d("JumpManager", "nio_data：" + str);
            this.A = 2;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String string = extras.getString("asus_data");
        Logger.d("JumpManager", "asus_data：" + string);
        this.A = 3;
        return string;
    }

    private void b(Context context, Intent intent) {
        if ("com.mt.mtxx.mtxx".equals(context.getPackageName())) {
            intent.putExtra("infoProvider", "JPush");
        }
    }

    private void a(int i6, String str, Intent intent) {
        if (i6 == 1) {
            intent.setData(Uri.parse(str));
        } else if (i6 == 2) {
            intent.putExtra("JMessageExtra", str);
            return;
        } else if (i6 != 3) {
            return;
        } else {
            intent.putExtra("asus_data", str);
        }
        intent.putExtra("JMessageExtra", str);
    }

    private boolean b(Context context, int i6, String str, String str2) {
        String str3;
        Intent a6;
        if (TextUtils.isEmpty(str)) {
            Logger.d("JumpManager", "jumpWebUrl link uri is empty");
            return false;
        }
        Logger.d("JumpManager", "jumpWebUrl:" + str);
        try {
            if (cn.jpush.android.ad.a.c(context, "com.android.browser")) {
                Logger.d("JumpManager", "start android default browser ");
                a6 = new Intent();
                a6.setAction("android.intent.action.VIEW");
                a6.setData(Uri.parse(str));
                a6.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
            } else {
                Logger.d("JumpManager", "start browser by android ");
                a6 = cn.jpush.android.ad.a.a(str, 0);
            }
            a(context, a6, i6, str2);
            return true;
        } catch (ActivityNotFoundException e6) {
            try {
                a(context, cn.jpush.android.ad.a.a(str, 0), i6, str2);
                return true;
            } catch (Throwable unused) {
                str3 = "start ActivityNotFoundException  fail=" + e6;
                Logger.d("JumpManager", str3);
                return false;
            }
        } catch (Throwable th) {
            str3 = "start uri fail=" + th;
            Logger.d("JumpManager", str3);
            return false;
        }
    }

    private boolean b(Context context, int i6, String str, String str2, String str3) {
        try {
            Intent a6 = a(str);
            a6.setFlags(268435456);
            if (!TextUtils.isEmpty(str2)) {
                a6.setPackage(str2);
            }
            if (context.getPackageManager().resolveActivity(a6, 0) == null) {
                Logger.d("JumpManager", "deeplink is wrong, " + str);
                return false;
            }
            if (i6 == 1) {
                i6 = 2;
            }
            if (i6 != -1 && !TextUtils.isEmpty(str3)) {
                a(i6, str3, a6);
            }
            b(context, a6);
            context.startActivity(a6);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(Context context) {
        Logger.d("JumpManager", " init config");
        this.f3449a = context;
        c(context);
    }

    public void a(Context context, Intent intent) {
        String str;
        b(context);
        Logger.d("JumpManager", "third user click notification");
        try {
            String a6 = a(intent);
            Logger.d("JumpManager", "handleThirdNotificationClick msg content is= " + String.valueOf(a6));
            if (TextUtils.isEmpty(a6)) {
                cn.jpush.android.x.b.a(context, intent.getAction(), (cn.jpush.android.d.d) null, intent);
                return;
            }
            JSONObject jSONObject = new JSONObject(a6);
            if (jSONObject.has("o-l-l")) {
                Bundle bundle = new Bundle();
                bundle.putString("aes", jSONObject.optString("aes"));
                JCoreHelper.openLog(context, bundle);
                return;
            }
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            byte optInt = (byte) jSONObject.optInt(JThirdPlatFormInterface.KEY_ROM_TYPE);
            Logger.d("JumpManager", "通道：" + a(optInt));
            boolean has = jSONObject.has(JThirdPlatFormInterface.KEY_MSG_ID);
            boolean has2 = jSONObject.has(JThirdPlatFormInterface.KEY_ROM_TYPE);
            boolean has3 = jSONObject.has("n_title");
            boolean has4 = jSONObject.has("n_content");
            Logger.d("JumpManager", "hasMsgid:" + has);
            Logger.d("JumpManager", "hasWhich:" + has2);
            Logger.d("JumpManager", "hasTitle:" + has3);
            Logger.d("JumpManager", "hasContent:" + has4);
            if (has && has2 && has3 && has4) {
                a(context, jSONObject);
                cn.jpush.android.helper.c.a(context, optString, optInt, a6);
                JSONObject optJSONObject = jSONObject.optJSONObject("n_intent");
                jSONObject.remove("n_intent");
                if (optJSONObject == null) {
                    str = "handleThirdNotificationClick n_intent is null,sendToUserReceiver";
                } else {
                    String optString2 = optJSONObject.optString("n_url", "");
                    String optString3 = optJSONObject.optString("n_ssl", "");
                    int optInt2 = optJSONObject.optInt("n_type", 1);
                    Logger.d("JumpManager", "n_url:" + optString2);
                    Logger.d("JumpManager", "n_ssl:" + optString3);
                    Logger.d("JumpManager", "n_type:" + optInt2);
                    if (optInt2 == 3 || !TextUtils.isEmpty(optString2)) {
                        if (cn.jpush.android.cache.a.r(this.f3449a)) {
                            Logger.d("JumpManager", "notification callback enable, sendToUserReceiver");
                            a(context, jSONObject, optInt);
                        }
                        String str2 = new String(Base64.decode(optString2, 0));
                        if (!TextUtils.isEmpty(optString2) && !a(context, optString2, optString3, optInt2)) {
                            Logger.e("JumpManager", "illegal jump,so return url_intent=" + str2);
                            cn.jpush.android.helper.c.a(optString, "", optInt, 1107L, context, a6, null);
                            return;
                        }
                        Logger.d("JumpManager", "url_intent:" + str2);
                        String jSONObject2 = jSONObject.toString();
                        Logger.d("JumpManager", "extraData:" + jSONObject2);
                        a(optInt2, this.A, str2, jSONObject2, "");
                        return;
                    }
                    str = "handleThirdNotificationClick url is null,sendToUserReceiver";
                }
                Logger.d("JumpManager", str);
                a(context, jSONObject, optInt);
                return;
            }
            Logger.d("JumpManager", "参数缺失");
        } catch (Throwable th) {
            Logger.w("JumpManager", "handleThirdNotificationClick  error : " + th.getMessage());
        }
    }

    private void a(Context context, Intent intent, int i6, String str) {
        intent.setFlags(268435456);
        if (i6 == 1) {
            i6 = 2;
        }
        if (i6 != -1 && !TextUtils.isEmpty(str)) {
            a(i6, str, intent);
        }
        b(context, intent);
        context.startActivity(intent);
    }

    public void a(Context context, cn.jpush.android.d.d dVar) {
        b(context);
        try {
            Logger.d("JumpManager", "Notification to InApp click notification");
            cn.jpush.android.helper.c.a(dVar.f3588d, 1601L, context);
            cn.jpush.android.k.a.a(context, dVar);
            cn.jpush.android.x.b.a(this.f3449a, JPushInterface.ACTION_IN_APP_MSG_CLICK, dVar, (Intent) null, (String) null);
            cn.jpush.android.helper.c.a(dVar.f3588d, a(dVar, (Intent) null, true) ? 1605L : 1606L, context);
        } catch (Throwable th) {
            Logger.w("JumpManager", "handleNotificationToInAppClick  error : " + th.getMessage());
        }
    }

    public void a(Context context, cn.jpush.android.d.d dVar, Intent intent) {
        b(context);
        try {
            Logger.d("JumpManager", "JG user click notification");
            if (dVar.f3597m != 1) {
                byte b6 = dVar.ai;
                if (b6 == 0) {
                    cn.jpush.android.helper.c.a(dVar.f3588d, 1000L, context);
                } else {
                    cn.jpush.android.helper.c.a(context, dVar.f3588d, b6, (String) null);
                }
            }
            cn.jpush.android.k.a.a(context, dVar);
            a(dVar, intent, false);
        } catch (Throwable th) {
            Logger.w("JumpManager", "handleNotificationClick  error : " + th.getMessage());
        }
    }

    private void a(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID);
            String optString2 = jSONObject.optString("n_title");
            String optString3 = jSONObject.optString("n_content");
            String optString4 = jSONObject.optString("n_extras");
            JSONArray optJSONArray = jSONObject.optJSONArray("n_target_event");
            cn.jpush.android.d.d dVar = new cn.jpush.android.d.d();
            dVar.f3606v = optString2;
            dVar.f3588d = optString;
            dVar.f3609y = optString3;
            dVar.G = optString4;
            dVar.f3607w = optJSONArray;
            cn.jpush.android.k.a.a(context, dVar);
        } catch (Throwable unused) {
        }
    }

    private void a(Context context, JSONObject jSONObject, byte b6) {
        Objects.toString(jSONObject);
        Bundle bundle = new Bundle();
        bundle.putByte("platform", b6);
        bundle.putString("data", jSONObject.toString());
        JThirdPlatFormInterface.doAction(context, JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED, bundle);
    }

    private boolean a(int i6, int i7, String str, String str2, String str3) {
        if (i6 == 1) {
            return str.contains("android.intent.action.MAIN") ? a(this.f3449a, i7, str2) : a(this.f3449a, i7, str, str2);
        }
        if (i6 == 2) {
            return a(this.f3449a, i7, str, str3, str2);
        }
        if (i6 != 3) {
            return false;
        }
        return a(this.f3449a, i7, str2);
    }

    private boolean a(Context context, int i6, String str) {
        Intent g6 = cn.jpush.android.ad.a.g(context);
        if (g6 == null) {
            return false;
        }
        try {
            a(i6, str, g6);
            context.startActivity(g6);
            return true;
        } catch (Throwable th) {
            Logger.ww("JumpManager", "start main intent error:" + th.getMessage());
            return false;
        }
    }

    private boolean a(Context context, int i6, String str, String str2) {
        try {
            Intent a6 = a(str);
            a6.setFlags(268435456);
            a6.setPackage(context.getPackageName());
            a(i6, str2, a6);
            context.startActivity(a6);
            return true;
        } catch (Throwable th) {
            Logger.ww("JumpManager", "jumpIntent Throwable:" + th.getMessage());
            return false;
        }
    }

    public boolean a(Context context, int i6, String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "jumpDeepLink link uri is empty";
        } else {
            try {
                Logger.d("JumpManager", "jumpDeepLink url:" + str);
                if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    return b(context, i6, str, str3);
                }
                Logger.d("JumpManager", "jumpDeepLink intent:" + str);
                return b(context, i6, str, str2, str3);
            } catch (Throwable th) {
                str4 = "jumpDeepLink start fail uri error:" + th.getMessage();
            }
        }
        Logger.d("JumpManager", str4);
        return false;
    }

    private boolean a(Context context, String str, String str2, int i6) {
        b(context);
        Logger.d("JumpManager", "checkConfig url=" + str + " ssl=" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("checkConfig user jump Config=");
        sb.append(f3446c);
        Logger.d("JumpManager", sb.toString());
        try {
            String d6 = cn.jpush.android.ad.a.d(str);
            Logger.d("JumpManager", "checkConfig url hash=" + d6);
            String c6 = c(str2);
            Logger.d("JumpManager", "checkConfig decodeData=" + c6);
            if (!TextUtils.isEmpty(c6) && !TextUtils.isEmpty(d6) && c6.equalsIgnoreCase(d6)) {
                return a(new String(Base64.decode(str.getBytes(), 2)), i6);
            }
            Logger.dd("JumpManager", "checkConfig fail, so return");
            return false;
        } catch (Throwable th) {
            Logger.dd("JumpManager", "checkConfig Throwable=" + th);
            return false;
        }
    }

    private boolean a(cn.jpush.android.d.d dVar, Intent intent, boolean z5) {
        boolean z6;
        int i6;
        try {
            String str = dVar.f3593i;
            Logger.d("JumpManager", "handleOriginalMessage msg content is= " + String.valueOf(str));
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("m_content");
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("n_intent");
            Logger.d("JumpManager", "handleOriginalMessage n_intent=" + optJSONObject2);
            if (optJSONObject2 != null || z5) {
                int optInt = optJSONObject2.optInt("n_type");
                String optString = optJSONObject2.optString("n_url");
                Logger.d("JumpManager", "handleOriginalMessage url=" + optString);
                Logger.d("JumpManager", "handleOriginalMessage jumpType=" + optInt);
                if (!a(optString, optInt)) {
                    Logger.e("JumpManager", "illegal jump,so return");
                    cn.jpush.android.helper.c.a(dVar.f3588d, 1107L, this.f3449a);
                    return false;
                }
                String optString2 = optJSONObject2.optString("n_package_name", "");
                z6 = false;
                if (optInt == 0) {
                    try {
                        if (!TextUtils.isEmpty(optString)) {
                            optInt = optString.startsWith("intent") ? 1 : 2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        Logger.d("JumpManager", "handleOriginalMessage throwable " + th);
                        return z6;
                    }
                }
                if (optInt == 3 || !TextUtils.isEmpty(optString) || z5) {
                    if (cn.jpush.android.cache.a.r(this.f3449a) && !z5) {
                        cn.jpush.android.x.b.a(this.f3449a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
                        Logger.d("JumpManager", "notification callback enable, sendToUserReceiver");
                    }
                    Logger.d("JumpManager", "handleOriginalMessage targetPkgName=" + optString2);
                    optJSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, dVar.f3588d);
                    optJSONObject.put(JThirdPlatFormInterface.KEY_ROM_TYPE, "0");
                    optJSONObject.put("notification_id", cn.jpush.android.x.b.a(dVar));
                    optJSONObject.put("_j_data_", jSONObject.optString("_j_data_"));
                    optJSONObject.remove("n_intent");
                    String jSONObject2 = optJSONObject.toString();
                    Logger.d("JumpManager", "handleOriginalMessage extraData=" + jSONObject2);
                    boolean a6 = a(optInt, 2, optString, jSONObject2, optString2);
                    if (a6 || !z5) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("handleOriginalMessage jump ");
                        sb.append(a6 ? "success" : CommonNetImpl.FAIL);
                        Logger.d("JumpManager", sb.toString());
                        return a6;
                    }
                    int optInt2 = optJSONObject2.optInt("n_fail_handle_type", 3);
                    String optString3 = optJSONObject2.optString("n_fail_handle_url", "");
                    if (optInt2 == 0) {
                        i6 = 3;
                    } else {
                        if (optInt2 != 1 && optInt2 != 2) {
                            i6 = optInt2;
                        }
                        i6 = 2;
                    }
                    Logger.d("JumpManager", "handleOriginalMessage inapp jump  failed use failedJumpUrl= " + optString3 + " failedJumpType=" + i6);
                    return a(i6, 2, optString3, jSONObject2, optString2);
                }
                cn.jpush.android.x.b.a(this.f3449a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
                Logger.d("JumpManager", "handleOriginalMessage url is null, sendToUserReceiver");
                return false;
            }
            cn.jpush.android.x.b.a(this.f3449a, JPushInterface.ACTION_NOTIFICATION_OPENED, dVar, intent);
            Logger.d("JumpManager", "handleOriginalMessage n_intent is null, sendToUserReceiver");
            return false;
        } catch (Throwable th2) {
            th = th2;
            z6 = false;
        }
    }

    private boolean a(String str, int i6) {
        if (i6 == 2) {
            return true;
        }
        if (f3446c == null) {
            Logger.dd("JumpManager", "jumpConfig is null goto get config");
            c(this.f3449a);
        }
        String str2 = f3446c;
        if (str2 == null) {
            Logger.dd("JumpManager", "jumpConfig is null,return true");
            return true;
        }
        try {
            String[] split = str2.split("/");
            Logger.d("JumpManager", "jumpConfig =" + Arrays.toString(split));
            String b6 = b(str);
            Logger.d("JumpManager", " origin className=" + b6);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(b6) && str3.equals(b6)) {
                    Logger.d("JumpManager", " match user config className");
                    return true;
                }
            }
        } catch (Throwable th) {
            Logger.dd("JumpManager", "jumpConfig Throwable=" + th);
        }
        return false;
    }
}
