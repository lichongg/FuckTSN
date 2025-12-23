package cn.jpush.android.ac;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.data.JPushConfig;
import cn.jpush.android.data.JPushConfigEx;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import com.acse.ottn.l3;
import com.google.common.primitives.SignedBytes;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f3386a = "exception_type";

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, Byte> f3387c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, Bundle> f3388d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static Map<JThirdPlatFormInterface, Long> f3389e = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private static final Object f3390h = new Object();

    /* renamed from: b, reason: collision with root package name */
    private List<JThirdPlatFormInterface> f3391b;

    /* renamed from: f, reason: collision with root package name */
    private Bundle f3392f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f3393g;

    /* renamed from: i, reason: collision with root package name */
    private long f3394i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f3395j;

    /* renamed from: k, reason: collision with root package name */
    private byte[] f3396k;

    /* renamed from: l, reason: collision with root package name */
    private Boolean f3397l;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f3398m;

    /* renamed from: n, reason: collision with root package name */
    private Boolean f3399n;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f3419a = new e();
    }

    class b {

        /* renamed from: a, reason: collision with root package name */
        String f3420a;

        /* renamed from: b, reason: collision with root package name */
        int f3421b;

        /* renamed from: c, reason: collision with root package name */
        String f3422c;

        /* renamed from: d, reason: collision with root package name */
        byte f3423d;

        b() {
        }

        public String toString() {
            return "ThirdMessage{msgid='" + this.f3420a + "', notiId=" + this.f3421b + ", content='" + this.f3422c + "', platform=" + ((int) this.f3423d) + '}';
        }
    }

    private e() {
        this.f3393g = false;
        this.f3394i = 50L;
        this.f3391b = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b a(Bundle bundle) {
        b bVar;
        if (bundle != null) {
            bVar = new b();
            bVar.f3422c = bundle.getString("data");
            bVar.f3420a = bundle.getString(JThirdPlatFormInterface.KEY_MSG_ID);
            bVar.f3421b = bundle.getInt(JThirdPlatFormInterface.KEY_NOTI_ID, 0);
            bVar.f3423d = bundle.getByte("platform", (byte) -1).byteValue();
        } else {
            bVar = null;
        }
        Logger.d("ThirdPushManager", "parse third messgae:" + bVar);
        return bVar;
    }

    private boolean f(Context context) {
        Object newInstance;
        Logger.d("ThirdPushManager", "[loadThirdPush]");
        if (!JCoreHelper.isAuth(context)) {
            Logger.w("ThirdPushManager", "user don't auth, so return init");
            return false;
        }
        for (Map.Entry<String, Byte> entry : f3387c.entrySet()) {
            try {
                Class classInPlugin = entry.getValue().byteValue() == 6 ? ActionHelper.getInstance().getClassInPlugin(entry.getKey()) : null;
                if (classInPlugin == null) {
                    classInPlugin = Class.forName(entry.getKey(), false, context.getClassLoader());
                }
                if (classInPlugin != null && (newInstance = classInPlugin.newInstance()) != null && (newInstance instanceof JThirdPlatFormInterface)) {
                    ((JThirdPlatFormInterface) newInstance).init(context);
                    if (((JThirdPlatFormInterface) newInstance).isSupport(context)) {
                        this.f3391b.add((JThirdPlatFormInterface) newInstance);
                    }
                }
            } catch (Throwable th) {
                if (a(th)) {
                    if (cn.jpush.android.m.a.f3710c >= 238) {
                        JCoreHelper.futureExecutor(context, new f("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.ac.e.1
                            @Override // cn.jpush.android.ad.f
                            public void a() {
                                throw new RuntimeException(th);
                            }
                        });
                    } else {
                        new Thread(new Runnable() { // from class: cn.jpush.android.ac.e.2
                            @Override // java.lang.Runnable
                            public void run() {
                                throw new RuntimeException(th);
                            }
                        }).start();
                    }
                }
                Logger.w("ThirdPushManager", "loadThirdPush error:" + th.getMessage());
            }
        }
        if (Build.VERSION.SDK_INT >= 26 && !this.f3391b.isEmpty()) {
            cn.jpush.android.x.a.a(context);
        }
        a(context, this.f3391b);
        Logger.d("ThirdPushManager", "third init success, add " + this.f3391b.size() + " third push channel");
        return true;
    }

    private boolean l(Context context) {
        try {
            if (f(context, "cn.jpush.android.service.PluginFCMMessagingService")) {
                boolean e6 = e();
                Class<?> cls = Class.forName("com.google.android.gms.common.GoogleApiAvailabilityLight");
                int intValue = ((Integer) cls.getMethod("isGooglePlayServicesAvailable", Context.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), context)).intValue();
                if (e6 && intValue == 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public String b(Context context) {
        Logger.i("ThirdPushManager", "getThirdTokenOnServiceProcess");
        try {
            byte[] g6 = g(context);
            this.f3396k = g6;
            for (byte b6 : g6) {
                if (b6 != 8) {
                    return (String) Sp.get(context, Key.ThirdPush_RegID(b6));
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public void c(Context context) {
        c.a().a(context);
        Logger.i("ThirdPushManager", "uploadRegIdAfterLoginOnServiceProcess, then send broadcast action=intent.plugin.platform.REFRESSH_REGID");
        e(context, JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID);
    }

    public byte d(Context context) {
        byte[] g6 = g(context);
        this.f3396k = g6;
        byte b6 = 0;
        if (g6 == null) {
            Logger.i("ThirdPushManager", " mPlatforms is null return platforms=0");
            return (byte) 0;
        }
        Logger.i("ThirdPushManager", " romType all mPlatforms =" + this.f3396k);
        byte b7 = 0;
        for (byte b8 : this.f3396k) {
            try {
                b7 = (byte) (b7 | b8);
                String str = (String) Sp.get(context, Key.ThirdPush_RegID(b8));
                boolean booleanValue = ((Boolean) Sp.get(context, Key.ThirdPush_RegUpload(b8))).booleanValue();
                Logger.i("ThirdPushManager", " romType first =" + ((int) b8));
                Logger.i("ThirdPushManager", " romType with 0 =" + ((int) b7));
                Logger.i("ThirdPushManager", " token =" + str);
                Logger.i("ThirdPushManager", " regUploaded =" + booleanValue);
                if (b8 == 8) {
                    b7 = (byte) (b7 | 8);
                    if (booleanValue && !TextUtils.isEmpty(str)) {
                        b7 = (byte) (b7 | 32);
                    }
                } else {
                    if (b8 == 2) {
                        b7 = (byte) (b7 | SignedBytes.MAX_POWER_OF_TWO);
                    }
                    if (!booleanValue || TextUtils.isEmpty(str)) {
                        Logger.i("ThirdPushManager", " romType before 0x80  =" + ((int) b7));
                        b7 = (byte) (b7 | 128);
                        Logger.i("ThirdPushManager", " romType with 0x80  =" + ((int) b7));
                    }
                }
            } catch (Throwable unused) {
                b6 = b7;
                b7 = b6;
                Logger.i("ThirdPushManager", "getPlatformsOnServiceProcess final platforms=" + ((int) b7));
                return b7;
            }
        }
        Logger.i("ThirdPushManager", "getPlatformsOnServiceProcess final platforms=" + ((int) b7));
        return b7;
    }

    public byte e(Context context) {
        try {
            String lowerCase = cn.jpush.android.ad.a.c().toLowerCase();
            if (!lowerCase.contains("xiaomi") && !lowerCase.contains("blackshark")) {
                if (lowerCase.contains("huawei")) {
                    return (byte) 2;
                }
                if (lowerCase.contains("meizu")) {
                    return (byte) 3;
                }
                if (!lowerCase.contains("oppo") && !lowerCase.contains("realme") && !lowerCase.contains("oneplus")) {
                    if (lowerCase.contains("vivo")) {
                        return (byte) 5;
                    }
                    return lowerCase.contains("honor") ? (i(context) || !c()) ? (byte) 7 : (byte) 2 : lowerCase.contains("nio") ? (byte) 16 : (byte) 0;
                }
                return (byte) 4;
            }
            return (byte) 1;
        } catch (Throwable unused) {
            return (byte) 0;
        }
    }

    static {
        f3387c.put("cn.jpush.android.thirdpush.meizu.MeizuPushManager", (byte) 3);
        f3387c.put("cn.jpush.android.thirdpush.xiaomi.XMPushManager", (byte) 1);
        f3387c.put("cn.jpush.android.thirdpush.huawei.HWPushManager", (byte) 2);
        f3387c.put("cn.jpush.android.thirdpush.fcm.FCMPushManager", (byte) 8);
        f3387c.put("cn.jpush.android.thridpush.oppo.OPushManager", (byte) 4);
        f3387c.put("cn.jpush.android.thirdpush.vivo.VivoPushManager", (byte) 5);
        f3387c.put("cn.jpush.android.thirdpush.honor.HonorPushManager", (byte) 7);
        f3387c.put("cn.jpush.android.thirdpush.nio.NioPushManager", (byte) 16);
        f3387c.put(cn.jpush.android.asus.b.class.getName(), (byte) 6);
    }

    private void e(Context context, String str) {
        e(context, str, new Bundle());
    }

    private static boolean f(Context context, String str) {
        try {
            context.getPackageManager().getServiceInfo(new ComponentName(context.getPackageName(), str), 128);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private byte[] g(Context context) {
        byte[] bArr = this.f3396k;
        if (bArr == null || bArr.length == 0) {
            this.f3396k = h(context);
        }
        return this.f3396k;
    }

    private boolean i(Context context) {
        if (this.f3397l == null) {
            this.f3397l = Boolean.valueOf(j(context));
        }
        return this.f3397l.booleanValue();
    }

    private boolean j(Context context) {
        try {
            Class<?> cls = Class.forName("com.hihonor.push.sdk.HonorPushClient");
            boolean booleanValue = ((Boolean) cls.getMethod("checkSupportHonorPush", Context.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), context)).booleanValue();
            Logger.d("ThirdPushManager", "isSupportHonorPush =" + booleanValue);
            return booleanValue;
        } catch (Throwable th) {
            Logger.e("ThirdPushManager", " isSupportHonorPush error:" + th);
            return false;
        }
    }

    private boolean k(Context context) {
        if (this.f3398m == null) {
            this.f3398m = Boolean.valueOf(l(context));
        }
        return this.f3398m.booleanValue();
    }

    public void c(Context context, Bundle bundle) {
        Logger.i("ThirdPushManager", "uploadOnServiceProcess bundle=" + bundle);
        if (context == null) {
            context = JPushConstants.mApplicationContext;
        }
        if (context == null) {
            Logger.e("ThirdPushManager", "context was null");
        } else if (bundle == null) {
            Logger.ww("ThirdPushManager", "bundle is null");
        } else {
            a(context, bundle.getByte("platform", (byte) 0).byteValue(), bundle.getString(JThirdPlatFormInterface.KEY_TOKEN), false);
        }
    }

    public byte d(Context context, String str) {
        Logger.d("ThirdPushManager", "clearThirdNotificaitonOnServiceProcess");
        Bundle bundle = new Bundle();
        if (e(context) != 1) {
            return (byte) -1;
        }
        bundle.putInt("id", cn.jpush.android.x.b.a(str, 1));
        e(context, "clear_by_id", bundle);
        return (byte) 1;
    }

    public static e a() {
        return a.f3419a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, Bundle bundle) {
        try {
            if (cn.jpush.android.m.a.a()) {
                if (context == null) {
                    context = JPushConstants.mApplicationContext;
                }
                if (context == null) {
                    Logger.e("ThirdPushManager", "context was null");
                    return;
                }
                a(context);
                bundle.putString(f3386a, "1");
                JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "send_exception_stats", bundle);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context, String str, Bundle bundle) {
        try {
            if (cn.jpush.android.ad.a.c(context)) {
                Logger.d("ThirdPushManager", "process is main, do dealMessage action=" + str + " bundle=" + bundle);
                c(context, str, bundle);
                return;
            }
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            Intent intent = new Intent(context, Class.forName(messageReceiverClass));
            intent.setAction(str);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtras(bundle);
            intent.setPackage(context.getPackageName());
            Logger.ww("ThirdPushManager", "send intent=" + intent);
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "send " + str + " failed:" + th);
        }
    }

    private byte[] h(Context context) {
        try {
            byte e6 = e(context);
            if (k(context)) {
                if (e6 != 0) {
                    return new byte[]{8, e6};
                }
                return new byte[]{8};
            }
            if (e6 != 0) {
                return new byte[]{e6};
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void b(Context context, int i6, String str) {
        try {
            Logger.dd("ThirdPushManager", "[callBackTokenToUser] platform:" + i6 + ",token:" + str);
            Bundle bundle = new Bundle();
            bundle.putInt("platform", i6);
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            cn.jpush.android.x.b.a(context, 10000, 0, "", bundle);
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "callBackTokenToUser failed:" + th.getMessage());
        }
    }

    public void c(Context context, String str) {
        Logger.d("ThirdPushManager", "stopPushOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f3391b.iterator();
            while (it.hasNext()) {
                it.next().stopPush(context);
            }
        }
    }

    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, str);
            Logger.d("ThirdPushManager", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("ThirdPushManager", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    private void d(final Context context, final String str, final Bundle bundle) {
        try {
            JCoreHelper.majorExecutor(context, "ThirdPushManager", new f("ThirdPushManager#doAction") { // from class: cn.jpush.android.ac.e.6
                @Override // cn.jpush.android.ad.f
                public void a() {
                    Map map;
                    String str2;
                    try {
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED)) {
                            b a6 = e.this.a(bundle);
                            if (a6 != null) {
                                d.a(context, a6.f3422c, a6.f3420a, a6.f3421b, a6.f3423d, 1);
                                return;
                            }
                            return;
                        }
                        if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED)) {
                            b a7 = e.this.a(bundle);
                            if (a7 != null) {
                                d.a(context, a7.f3422c, a7.f3420a, a7.f3421b, a7.f3423d, 0);
                                return;
                            }
                            return;
                        }
                        if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_UN_SHOW)) {
                            b a8 = e.this.a(bundle);
                            if (a8 != null) {
                                d.a(context, a8.f3422c, a8.f3420a, a8.f3421b, a8.f3423d, 2);
                                return;
                            }
                            return;
                        }
                        if (str.equals(JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW)) {
                            return;
                        }
                        if (str.equals(JThirdPlatFormInterface.ACTION_REGISTER_TOKEN)) {
                            if (e.this.f3393g) {
                                Bundle bundle2 = bundle;
                                if (bundle2 != null) {
                                    e.this.a(context, bundle.getByte("platform", (byte) -1).byteValue(), bundle2.getString(JThirdPlatFormInterface.KEY_TOKEN));
                                    return;
                                }
                                return;
                            }
                            Logger.d("ThirdPushManager", "is not init cache action:" + str + ",bundle:" + bundle);
                            map = e.f3388d;
                            str2 = str;
                        } else {
                            if (!str.equals(JThirdPlatFormInterface.ACTION_SEND_EXCEPTION)) {
                                return;
                            }
                            if (e.this.f3393g) {
                                Bundle bundle3 = bundle;
                                if (bundle3 != null) {
                                    e.this.d(context, bundle3);
                                    return;
                                }
                                return;
                            }
                            Logger.d("ThirdPushManager", "is not init cache action:" + str + ",bundle:" + bundle);
                            map = e.f3388d;
                            str2 = str;
                        }
                        map.put(str2, bundle);
                    } catch (Throwable th) {
                        Logger.ww("ThirdPushManager", "doAction failed internal:" + th.getMessage());
                    }
                }
            });
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    private static boolean e() {
        Class.forName("com.google.firebase.messaging.FirebaseMessaging");
        return true;
    }

    public void b(Context context, Bundle bundle) {
        try {
            this.f3396k = g(context);
            Logger.i("ThirdPushManager", "unbindOnServiceProcess platforms=" + Arrays.toString(this.f3396k));
            for (byte b6 : this.f3396k) {
                Sp.set(context, Key.ThirdPush_RegUpload(b6).set(Boolean.FALSE));
                Sp.set(context, Key.ThirdPush_RegID(b6).set(null));
                a(context, b6, (String) null, true);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context, String str, Bundle bundle) {
        Logger.d("ThirdPushManager", "dealMessage action=" + str + " bundle=" + bundle);
        if (JThirdPlatFormInterface.ACTION_PLUGIN_PALTFORM_REFRESSH_REGID.equals(str)) {
            b(context, str, bundle);
            return;
        }
        if ("third_resume".equals(str)) {
            a(context, str);
            return;
        }
        if ("third_stop".equals(str)) {
            c(context, str);
            return;
        }
        if ("third_all_notify".equals(str)) {
            b(context, str);
            return;
        }
        if ("clear_by_id".equals(str)) {
            if (bundle != null) {
                a(context, bundle.getInt("id"), str);
                return;
            }
            return;
        }
        if ("set_third_token".equals(str)) {
            if (bundle != null) {
                b(context, bundle.getString("third_token"), str);
                return;
            }
            return;
        }
        if ("dy_register".equals(str)) {
            a(context, bundle.getString("dev_key"), str);
            return;
        }
        if ("third_enable".equals(str)) {
            boolean z5 = bundle.getBoolean("enable", true);
            try {
                JPushConstants.THIRD_ENABLE = z5;
            } catch (Throwable unused) {
            }
            if (z5) {
                b(context, str, bundle);
                return;
            }
            return;
        }
        if (JThirdPlatFormInterface.ACTION_NOTIFICATION_ARRIVED.equals(str) || JThirdPlatFormInterface.ACTION_NOTIFICATION_CLCKED.equals(str) || JThirdPlatFormInterface.ACTION_NOTIFICATION_UN_SHOW.equals(str) || JThirdPlatFormInterface.ACTION_NOTIFICATION_SHOW.equals(str) || JThirdPlatFormInterface.ACTION_REGISTER_TOKEN.equals(str) || JThirdPlatFormInterface.ACTION_SEND_EXCEPTION.equals(str)) {
            a(context, str, bundle, "");
        }
    }

    private boolean c() {
        if (this.f3399n == null) {
            this.f3399n = Boolean.valueOf(d());
        }
        return this.f3399n.booleanValue();
    }

    private boolean d() {
        String a6 = a("ro.build.version.emui");
        Logger.kd("ThirdPushManager", "isEmotionOs name:" + a6);
        if (TextUtils.isEmpty(a6)) {
            return false;
        }
        String lowerCase = a6.toLowerCase();
        if (!lowerCase.contains("magicui") && !lowerCase.contains("magicos")) {
            return false;
        }
        Logger.kd("ThirdPushManager", "isEmotionOs true");
        return true;
    }

    public synchronized void a(Context context) {
        if (this.f3393g) {
            return;
        }
        if (context == null) {
            return;
        }
        Logger.d("ThirdPushManager", "initOnMainProcess");
        try {
            Class.forName("cn.jpush.android.dy.JPushThirdDyManager").getDeclaredMethod("loadByJPush", Context.class).invoke(null, context);
        } catch (Throwable unused) {
        }
        this.f3393g = f(context);
    }

    public void b(Context context, String str) {
        Logger.d("ThirdPushManager", "clearAllNotificationOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f3391b.iterator();
            while (it.hasNext()) {
                it.next().clearAllNotification(context);
            }
        }
    }

    public void a(Context context, byte b6) {
        try {
            byte[] g6 = g(context);
            this.f3396k = g6;
            if (g6 == null) {
                this.f3396k = new byte[]{b6};
                return;
            }
            for (byte b7 : g6) {
                if (b7 == b6) {
                    return;
                }
            }
            byte[] bArr = this.f3396k;
            byte[] bArr2 = new byte[bArr.length + 1];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[this.f3396k.length] = b6;
            this.f3396k = bArr2;
        } catch (Throwable unused) {
        }
    }

    public void b(Context context, String str, Bundle bundle) {
        Logger.d("ThirdPushManager", "triggerTokenUploadOnMainProcess bundle=" + bundle + " isThirdEnable=" + cn.jpush.android.m.a.a());
        try {
            if (cn.jpush.android.m.a.a()) {
                Logger.d("ThirdPushManager", "triggerTokenUploadOnMainProcess start on main");
                a(context);
                Logger.d("ThirdPushManager", "[triggerTokenUploadOnMainProcess] , platFormInterfaceList size: " + this.f3391b.size());
                for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3391b) {
                    byte romType = jThirdPlatFormInterface.getRomType(context);
                    String token = jThirdPlatFormInterface.getToken(context);
                    Logger.d("ThirdPushManager", "triggerTokenUploadOnMainProcess token=" + token + " romType=" + ((int) romType));
                    if (!TextUtils.isEmpty(token)) {
                        a(context, romType, token);
                    } else {
                        if (!JCoreHelper.isAuth(context)) {
                            Logger.w("ThirdPushManager", "user don't auth, so return init");
                            return;
                        }
                        a(context, jThirdPlatFormInterface);
                    }
                }
            }
        } catch (Throwable th) {
            if (a(th)) {
                if (cn.jpush.android.m.a.f3710c >= 238) {
                    JCoreHelper.futureExecutor(context, new f("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.ac.e.7
                        @Override // cn.jpush.android.ad.f
                        public void a() {
                            throw new RuntimeException(th);
                        }
                    });
                } else {
                    new Thread(new Runnable() { // from class: cn.jpush.android.ac.e.8
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new RuntimeException(th);
                        }
                    }).start();
                }
            }
            Logger.d("ThirdPushManager", "triggerTokenUploadOnMainProcess on main process throwable=" + th);
        }
    }

    public void a(Context context, byte b6, String str) {
        Logger.d("ThirdPushManager", "uploadRegIdOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            if (context == null) {
                context = JPushConstants.mApplicationContext;
            }
            if (context == null) {
                Logger.e("ThirdPushManager", "context was null");
                return;
            }
            Logger.ii("ThirdPushManager", "uploadRegID regid:" + str);
            a(context);
            Bundle bundle = new Bundle();
            bundle.putString(JThirdPlatFormInterface.KEY_TOKEN, str);
            bundle.putByte("platform", b6);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_push_upload_regid", bundle);
        }
    }

    public void b(Context context, String str, String str2) {
        Logger.d("ThirdPushManager", "uploadThirdTokenFromUserOnMainProcess");
        byte e6 = e(context);
        if (e6 != 0) {
            if (TextUtils.isEmpty(str)) {
                a(context, e6, (String) null, true);
                return;
            }
            Logger.d("ThirdPushManager", "uploadThirdTokenFromUser platform：" + ((int) e6));
            a(context, e6, str);
        }
    }

    private void a(Context context, byte b6, String str, boolean z5) {
        Logger.d("ThirdPushManager", "sendUpdateRegIDRequest, WhichPlatform:" + ((int) b6) + ",regID:" + str);
        c.a().a(context, b6, str, z5);
    }

    public void a(Context context, int i6, String str) {
        Logger.d("ThirdPushManager", "clearNotificationOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f3391b.iterator();
            while (it.hasNext()) {
                it.next().clearNotification(context, i6);
            }
        }
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        if (!action.equals(cn.jpush.android.ad.a.e(context, "cmd_msg"))) {
            c(context, action, extras);
            return;
        }
        int intExtra = intent.getIntExtra("code", -2);
        int intExtra2 = intent.getIntExtra("cmd", -2);
        Logger.d("ThirdPushManager", "registerOnMainProcess :" + intExtra + ",cmd:" + intExtra2 + ",message:" + intent.getStringExtra(CrashHianalyticsData.MESSAGE));
        if (intExtra2 != 1 || this.f3395j) {
            return;
        }
        this.f3395j = true;
        a(context, extras, action);
        Logger.d("ThirdPushManager", "start to send cache map=" + f3388d);
        for (Map.Entry<String, Bundle> entry : f3388d.entrySet()) {
            d(context, entry.getKey(), entry.getValue());
        }
        f3388d.clear();
        Logger.d("ThirdPushManager", " cache map send finish map=" + f3388d);
    }

    public void a(Context context, Bundle bundle) {
        try {
            Logger.i("ThirdPushManager", "syncPlatformsOnServiceProcess bundle=" + bundle);
            this.f3396k = bundle.getByteArray("platform");
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Bundle bundle, String str) {
        Logger.d("ThirdPushManager", "registerOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            if (!JCoreHelper.isAuth(context)) {
                Logger.e("ThirdPushManager", "register user don't auth, so return init");
                return;
            }
            a(context);
            if (cn.jpush.android.cache.a.e(StubApp.getOrigApplicationContext(context.getApplicationContext()))) {
                Logger.d("ThirdPushManager", "push has close");
                return;
            }
            if (bundle != null) {
                try {
                    Serializable serializable = bundle.getSerializable("config");
                    JPushConfigEx jPushConfigEx = serializable instanceof JPushConfigEx ? (JPushConfigEx) serializable : serializable instanceof JPushConfig ? new JPushConfigEx((JPushConfig) serializable) : null;
                    if (jPushConfigEx != null) {
                        bundle.putString("MEIZU_APPID", jPushConfigEx.getMzAppId());
                        bundle.putString("MEIZU_APPKEY", jPushConfigEx.getMzAppKey());
                        bundle.putString("OPPO_APPKEY", jPushConfigEx.getOppoAppKey());
                        bundle.putString("OPPO_APPID", jPushConfigEx.getOppoAppId());
                        bundle.putString("OPPO_APPSECRET", jPushConfigEx.getOppoAppSecret());
                        bundle.putString("XIAOMI_APPID", jPushConfigEx.getXmAppId());
                        bundle.putString("XIAOMI_APPKEY", jPushConfigEx.getXmAppKey());
                        bundle.putString("VIVO_APPKEY", jPushConfigEx.getVivoAppKey());
                        bundle.putString("VIVO_APPID", jPushConfigEx.getVivoAppId());
                        bundle.putString("HW_APPID", jPushConfigEx.getHwAppId());
                        bundle.putString("HONOR_APPID", jPushConfigEx.getHonorAppId());
                    }
                } catch (Throwable unused) {
                }
            }
            this.f3392f = bundle;
            for (JThirdPlatFormInterface jThirdPlatFormInterface : this.f3391b) {
                try {
                    if (TextUtils.equals(cn.jpush.android.ad.a.d(context), context.getPackageName())) {
                        a(context, jThirdPlatFormInterface);
                    }
                    if (cn.jpush.android.cache.a.u(context) == 2) {
                        a(context, jThirdPlatFormInterface.getRomType(context), jThirdPlatFormInterface.getToken(context));
                    }
                } catch (Throwable th) {
                    if (a(th)) {
                        if (cn.jpush.android.m.a.f3710c >= 238) {
                            JCoreHelper.futureExecutor(context, new f("ThirdPushManager#loadThirdPush") { // from class: cn.jpush.android.ac.e.4
                                @Override // cn.jpush.android.ad.f
                                public void a() {
                                    throw new RuntimeException(th);
                                }
                            });
                        } else {
                            new Thread(new Runnable() { // from class: cn.jpush.android.ac.e.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    throw new RuntimeException(th);
                                }
                            }).start();
                        }
                    }
                    Logger.ww("ThirdPushManager", "Third push register failed#", th);
                }
            }
        }
    }

    private void a(Context context, JThirdPlatFormInterface jThirdPlatFormInterface) {
        Map<JThirdPlatFormInterface, Long> map;
        long currentTimeMillis;
        if (jThirdPlatFormInterface == null) {
            return;
        }
        try {
            if (f3389e.containsKey(jThirdPlatFormInterface)) {
                if (Math.abs(System.currentTimeMillis() - f3389e.get(jThirdPlatFormInterface).longValue()) <= this.f3394i) {
                    Logger.d("ThirdPushManager", "is registering,no need to register again < " + this.f3394i + " mills");
                    return;
                }
                Logger.d("ThirdPushManager", "start register > " + this.f3394i + " mills. platImpl=" + jThirdPlatFormInterface);
                jThirdPlatFormInterface.register(context, this.f3392f);
                map = f3389e;
                currentTimeMillis = System.currentTimeMillis();
            } else {
                Logger.d("ThirdPushManager", "start register platImpl=" + jThirdPlatFormInterface);
                jThirdPlatFormInterface.register(context, this.f3392f);
                map = f3389e;
                currentTimeMillis = System.currentTimeMillis();
            }
            map.put(jThirdPlatFormInterface, Long.valueOf(currentTimeMillis));
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, String str) {
        Logger.d("ThirdPushManager", "resumePushOnMainProcess");
        if (cn.jpush.android.m.a.a()) {
            a(context);
            Iterator<JThirdPlatFormInterface> it = this.f3391b.iterator();
            while (it.hasNext()) {
                it.next().resumePush(context);
            }
        }
    }

    public void a(Context context, String str, Bundle bundle) {
        try {
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "third_unbind", bundle);
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, String str, Bundle bundle, String str2) {
        try {
            Logger.d("ThirdPushManager", "doAction,action:" + str + ",bundle:" + bundle + ",enable:" + cn.jpush.android.m.a.a());
            if (cn.jpush.android.m.a.a()) {
                d(context, str, bundle);
            }
        } catch (Throwable th) {
            Logger.ww("ThirdPushManager", "doAction failed:" + th.getMessage());
        }
    }

    public void a(Context context, String str, String str2) {
        Context context2;
        Logger.d("ThirdPushManager", "registAndConfigureSDKOnMainProcess");
        final String d6 = cn.jpush.android.ad.a.d(str);
        final String g6 = cn.jpush.android.cache.a.g(context, d6);
        if (TextUtils.isEmpty(g6)) {
            context2 = context;
        } else {
            cn.jpush.android.cache.a.f(context, 1);
            Logger.d("ThirdPushManager", "use cache config register");
            context2 = context;
            a(context2, g6, cn.jpush.android.cache.a.h(context, d6), cn.jpush.android.cache.a.i(context, d6), cn.jpush.android.cache.a.j(context, d6));
        }
        cn.jpush.android.ac.b.a(context2, str, new cn.jpush.android.ac.a() { // from class: cn.jpush.android.ac.e.3
            @Override // cn.jpush.android.ac.a
            public void a() {
                Logger.w("ThirdPushManager", "plugin config request failed");
            }

            @Override // cn.jpush.android.ac.a
            public void a(Context context3, String str3) {
                String str4;
                if (TextUtils.isEmpty(str3)) {
                    str4 = "plugin response config is empty";
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        String optString = jSONObject.optString("j_key");
                        String optString2 = jSONObject.optString("m_key");
                        String optString3 = jSONObject.optString("m_id");
                        String optString4 = jSONObject.optString("m_scrt");
                        cn.jpush.android.cache.a.b(context3, d6, optString);
                        cn.jpush.android.cache.a.c(context3, d6, optString2);
                        cn.jpush.android.cache.a.d(context3, d6, optString3);
                        cn.jpush.android.cache.a.e(context3, d6, optString4);
                        if (TextUtils.isEmpty(g6)) {
                            Logger.d("ThirdPushManager", "start register sdk, use appKey: " + optString);
                            cn.jpush.android.cache.a.f(context3, 2);
                            e.this.a(context3, optString, optString2, optString3, optString4);
                            return;
                        }
                        if (TextUtils.equals(optString, g6)) {
                            return;
                        }
                        Logger.ww("ThirdPushManager", "push appKey change, old: " + g6 + ", new: " + optString);
                        return;
                    } catch (Throwable th) {
                        str4 = "parsing plugin config failed, " + th.getMessage();
                    }
                }
                Logger.w("ThirdPushManager", str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, String str4) {
        JPushConfigEx jPushConfigEx = new JPushConfigEx();
        jPushConfigEx.setjAppKey(str);
        byte e6 = e(context);
        if (e6 == 1) {
            jPushConfigEx.setXmAppKey(str2);
            jPushConfigEx.setXmAppId(str3);
        } else if (e6 == 2) {
            jPushConfigEx.setHwAppId(str3);
        } else if (e6 == 3) {
            jPushConfigEx.setMzAppKey(str2);
            jPushConfigEx.setMzAppId(str3);
        } else if (e6 == 4) {
            jPushConfigEx.setOppoAppKey(str2);
            jPushConfigEx.setOppoAppId(str3);
            jPushConfigEx.setOppoAppSecret(str4);
        } else if (e6 == 5) {
            jPushConfigEx.setVivoAppKey(str2);
            jPushConfigEx.setVivoAppId(str3);
        } else if (e6 == 7) {
            jPushConfigEx.setHonorAppId(str3);
        }
        JPushInterface.init(context, jPushConfigEx);
    }

    private void a(Context context, List<JThirdPlatFormInterface> list) {
        try {
            Bundle bundle = new Bundle();
            byte[] bArr = new byte[list.size()];
            for (int i6 = 0; i6 < list.size(); i6++) {
                bArr[i6] = list.get(i6).getRomType(context);
            }
            bundle.putByteArray("platform", bArr);
            JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "synce_platform", bundle);
        } catch (Throwable unused) {
        }
    }

    private boolean a(Throwable th) {
        return (th instanceof RuntimeException) && th.getMessage() != null && th.getMessage().contains("Please check") && JCoreManager.getDebugMode();
    }
}
