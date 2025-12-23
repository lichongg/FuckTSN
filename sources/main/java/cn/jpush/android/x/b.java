package cn.jpush.android.x;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.PushNotificationBuilder;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import cn.jpush.android.x.a;
import cn.jpush.android.x.e;
import com.acse.ottn.l3;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.stub.StubApp;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.UUID;
import java.util.zip.Adler32;
import org.json.JSONObject;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f3988a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f3989b;

    static class a extends cn.jpush.android.ad.f {

        /* renamed from: a, reason: collision with root package name */
        private Context f3990a;

        /* renamed from: b, reason: collision with root package name */
        private cn.jpush.android.d.d f3991b;

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                long b6 = cn.jpush.android.ad.b.b(this.f3991b.av);
                long b7 = cn.jpush.android.ad.b.b(this.f3991b.aw);
                if (b6 > 0 && b6 == b7) {
                    Logger.ww("NotificationHelper", "the beginTime == endTime,not deal this notification");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (b7 > 0) {
                    if (b7 < b6) {
                        Logger.e("NotificationHelper", "illegal argument, endTime earlier than beginTime");
                        return;
                    } else if (b7 < currentTimeMillis) {
                        Logger.w("NotificationHelper", this.f3991b.f3588d + " already end");
                        cn.jpush.android.helper.c.a(this.f3991b.f3588d, 1034L, this.f3990a);
                        return;
                    }
                }
                if (b6 >= currentTimeMillis) {
                    e.a().a(this.f3990a, new e.a(b6, this.f3991b, false));
                    cn.jpush.android.helper.c.a(this.f3991b.f3588d, 1035L, this.f3990a);
                } else {
                    a(this.f3990a, this.f3991b);
                    if (b7 > 0) {
                        e.a().a(this.f3990a, new e.a(b7, b.a(this.f3991b)));
                    }
                }
            } catch (Throwable th) {
                Logger.w("NotificationHelper", "run NotifyAction failed:" + th.getMessage());
            }
        }

        public static void a(Context context, cn.jpush.android.d.d dVar) {
            b.g(context, dVar);
            int i6 = dVar.ad;
            if (i6 != 0 && i6 != 4) {
                b.f(context, dVar);
            } else {
                cn.jpush.android.helper.c.a(dVar.f3588d, 995L, context);
                b.b(context, dVar);
            }
        }

        public a(Context context, cn.jpush.android.d.d dVar) {
            this.f3990a = context;
            this.f3991b = dVar;
            this.f3443e = "NotificationHelper#NotifyAction";
        }
    }

    private static int a(int i6) {
        if (i6 == 0) {
            return 1;
        }
        if (i6 != 1) {
            return i6 != 2 ? 1 : 32;
        }
        return 16;
    }

    public static Intent b(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PopWinActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    private static Intent c(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, JNotifyActivity.class);
        intent.setFlags(8388608);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        return intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public static int d(Context context) {
        StringBuilder sb;
        String str;
        boolean areNotificationsEnabled;
        if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
            Logger.ww("NotificationHelper", "sdk is banned, call failed");
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager == null) {
                    return -1;
                }
                areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                Logger.d("NotificationHelper", "from NotificationManager enable=" + areNotificationsEnabled);
                return areNotificationsEnabled ? 1 : 0;
            } catch (Throwable th) {
                th = th;
                sb = new StringBuilder();
                str = "isNotificationEnabled e:";
            }
        } else {
            try {
                Object obj = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                Object packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
                int i6 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.intValue();
                ?? r12 = ((Integer) method.invoke(obj, num, Integer.valueOf(i6), packageName)).intValue() == 0 ? 1 : 0;
                Logger.d("NotificationHelper", "from AppOpsManager enable=" + ((boolean) r12));
                return r12;
            } catch (Throwable th2) {
                th = th2;
                sb = new StringBuilder();
                str = "appOps check e:";
            }
        }
        sb.append(str);
        sb.append(th);
        Logger.w("NotificationHelper", sb.toString());
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(Context context, cn.jpush.android.d.d dVar) {
        String str;
        Context context2;
        boolean z5;
        String str2 = dVar.f3588d;
        String str3 = dVar.Z;
        str = "";
        if (TextUtils.isEmpty(str3)) {
            context2 = context;
            Logger.w("NotificationHelper", "Show url is Empty! Give up to download!");
            z5 = false;
        } else {
            context2 = context;
            String a6 = cn.jpush.android.w.b.a(context2, str3, "rich", 5, 5000L);
            boolean isEmpty = TextUtils.isEmpty(a6);
            str = isEmpty ? "" : a6;
            z5 = !isEmpty;
        }
        String c6 = cn.jpush.android.ad.c.c(context2, str2);
        if (!z5) {
            Logger.w("NotificationHelper", "NOTE: failed to download html page. Give up this.");
            cn.jpush.android.helper.c.a(str2, 1014L, context2);
            cn.jpush.android.helper.c.a(str2, 1021L, (String) null, context2);
            return;
        }
        String str4 = c6 + str2 + ".html";
        String substring = str3.substring(0, str3.lastIndexOf("/") + 1);
        if (dVar.af.isEmpty()) {
            dVar.ab = dVar.Z;
            b(context2, dVar);
            return;
        }
        if (!h.a(dVar.af, context2, substring, str2, true)) {
            Logger.d("NotificationHelper", "Loads rich push resources failed, webView will open url!");
            cn.jpush.android.helper.c.a(str2, 1014L, context2);
            b(context2, dVar);
            return;
        }
        Logger.d("NotificationHelper", "Loads rich push resources succeed, webView will open cache!");
        if (!cn.jpush.android.ad.c.b(str4, str.replaceAll("img src=\"" + substring, "img src=\"" + c6))) {
            cn.jpush.android.helper.c.a(str2, 1014L, context2);
            return;
        }
        dVar.ab = "file://" + str4;
        cn.jpush.android.helper.c.a(str2, 995L, context2);
        b(context2, dVar);
    }

    private static String g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setPackage(context.getPackageName());
            intent.addCategory("android.intent.category.LAUNCHER");
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                resolveActivity = packageManager.resolveActivity(intent, 0);
            }
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.name;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String h(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage != null && launchIntentForPackage.getComponent() != null) {
                return launchIntentForPackage.getComponent().getClassName();
            }
        } catch (Throwable unused) {
        }
        return g(context);
    }

    public static int a(cn.jpush.android.d.d dVar) {
        return a(TextUtils.isEmpty(dVar.f3592h) ? dVar.f3588d : dVar.f3592h, 0);
    }

    public static cn.jpush.android.d.d b(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("msg_data");
        if (TextUtils.isEmpty(stringExtra)) {
            return null;
        }
        return cn.jpush.android.d.d.b(stringExtra);
    }

    public static synchronized Bitmap c(Context context, String str) {
        synchronized (b.class) {
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                Drawable applicationIcon = packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0));
                if (applicationIcon != null) {
                    if (Build.VERSION.SDK_INT < 26 || !z.a(applicationIcon)) {
                        return ((BitmapDrawable) applicationIcon).getBitmap();
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                    applicationIcon.draw(canvas);
                    Logger.d("NotificationHelper", "adaptive-icon to bitmap");
                    return createBitmap;
                }
            } finally {
                return null;
            }
            return null;
        }
    }

    private static String d(Context context, String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith(JPushConstants.HTTP_PRE) && !str.startsWith(JPushConstants.HTTPS_PRE)) {
            return null;
        }
        String c6 = c(context, str, i6);
        if (!TextUtils.isEmpty(c6)) {
            return c6;
        }
        Logger.ww("NotificationHelper", "Get network picture failed.");
        return null;
    }

    public static boolean e(Context context) {
        String str;
        ApplicationInfo applicationInfo;
        try {
            if (JCoreHelper.checkSdkBanned(context).booleanValue()) {
                Logger.ww("NotificationHelper", "sdk is banned, call failed");
                return false;
            }
            Intent intent = new Intent();
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (Build.VERSION.SDK_INT >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                str = "android.provider.extra.CHANNEL_ID";
                applicationInfo = context.getApplicationInfo();
            } else {
                intent.putExtra("app_package", context.getPackageName());
                str = "app_uid";
                applicationInfo = context.getApplicationInfo();
            }
            intent.putExtra(str, applicationInfo.uid);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(WiseOpenHianalyticsData.UNION_PACKAGE, context.getPackageName(), null));
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2 = dVar.B;
        dVar.B = "";
        if (dVar.f3610z != 3 || TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.startsWith(JPushConstants.HTTP_PRE) || str2.startsWith(JPushConstants.HTTPS_PRE)) {
            String a6 = a(context, str2, dVar.f3588d);
            if (!TextUtils.isEmpty(a6)) {
                dVar.B = a6;
                return;
            }
            str = "Get network picture failed, show basic notification only.";
        } else {
            String e6 = cn.jpush.android.ad.c.e(context, str2);
            if (!TextUtils.isEmpty(e6)) {
                dVar.B = e6;
                return;
            }
            str = "Get developer picture failed, show basic notification only.";
        }
        Logger.ww("NotificationHelper", str);
    }

    private static boolean h(Context context, int i6) {
        try {
            Logger.d("NotificationHelper", "【setEMUIBadge】number：" + i6);
            Bundle bundle = new Bundle();
            bundle.putString(WiseOpenHianalyticsData.UNION_PACKAGE, context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i6);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            return true;
        } catch (Exception e6) {
            Logger.e("NotificationHelper", "e: " + e6);
            return false;
        }
    }

    public static int a(String str, int i6) {
        if (TextUtils.isEmpty(str)) {
            Logger.d("NotificationHelper", "action:getNotificationID - empty messageId");
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Logger.w("NotificationHelper", "Ths msgId is not a integer");
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            return value < 0 ? Math.abs(value) : value;
        }
    }

    public static Object b(Context context, String str) {
        return b(context, str, 307200);
    }

    public static NotificationMessage c(Context context, Intent intent) {
        cn.jpush.android.d.d b6 = b(context, intent);
        NotificationMessage notificationMessage = new NotificationMessage();
        if (b6 != null) {
            notificationMessage = b6.b();
        }
        if (TextUtils.isEmpty(notificationMessage.appkey)) {
            notificationMessage.appkey = JCoreHelper.getAppKey(context);
        }
        return notificationMessage;
    }

    public static void d(Context context, int i6) {
        try {
            Logger.d("NotificationHelper", "action:cleanNotification - notificationId:" + i6);
            ((NotificationManager) context.getSystemService("notification")).cancel(i6);
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "cancelNotification failed:" + th.getMessage());
        }
    }

    private static boolean e(Context context, int i6) {
        try {
            Object invoke = Class.forName("com.skyui.push.sdk.SkyPushAgent").getMethod("getPushService", null).invoke(null, null);
            invoke.getClass().getMethod("setAppBadgeCount", Context.class, Integer.TYPE, String.class).invoke(invoke, context, Integer.valueOf(i6), null);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean f(Context context, int i6) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Uri parse = Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
            if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                parse = Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                if (TextUtils.isEmpty(contentResolver.getType(parse))) {
                    Logger.e("NotificationHelper", " setHonorBadge fail, uri is null");
                    return false;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(WiseOpenHianalyticsData.UNION_PACKAGE, context.getPackageName());
            bundle.putString("class", h(context));
            bundle.putInt("badgenumber", i6);
            contentResolver.call(parse, "change_badge", (String) null, bundle);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setHonorBadge wrong error:" + th);
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    private static boolean g(Context context, int i6) {
        try {
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.PACKAGE_NAME, context.getPackageName());
            intent.putExtra("className", h(context));
            intent.putExtra("notificationNum", i6);
            intent.addFlags(16777216);
            context.sendBroadcast(intent);
            return true;
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " setVivoBadge wrong error:" + th);
            return false;
        }
    }

    private static Notification a(Notification.Builder builder) {
        try {
            return builder.build();
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "Build notification error:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:16:0x0054, B:17:0x0069, B:21:0x009c, B:24:0x00a4, B:25:0x00b5, B:30:0x00de, B:33:0x00bd, B:35:0x00c3, B:37:0x00c9, B:40:0x0074, B:42:0x007a, B:44:0x0085), top: B:14:0x0052 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00dc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x003a -> B:14:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object b(android.content.Context r6, java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.b(android.content.Context, java.lang.String, int):java.lang.Object");
    }

    public static String c(Context context, String str, int i6) {
        if (!cn.jpush.android.ad.a.a(str, false)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String d6 = cn.jpush.android.ad.a.d(str);
        if (TextUtils.isEmpty(d6)) {
            d6 = UUID.randomUUID().toString();
        }
        String str2 = cn.jpush.android.ad.c.c(context, "noti_res") + (d6 + cn.jpush.android.ad.a.b(str));
        Logger.i("NotificationHelper", "picture notification resource path: " + str2);
        if (!new File(str2).exists()) {
            byte[] a6 = cn.jpush.android.w.b.a(context, str, "notify_img", 2, i6);
            return (a6 == null || !cn.jpush.android.ad.c.a(str2, a6)) ? "" : str2;
        }
        Logger.d("NotificationHelper", "need not download again with same url:" + str);
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.Notification a(android.content.Context r7, cn.jpush.android.d.d r8, cn.jpush.android.x.c r9, cn.jpush.android.x.c r10) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.a(android.content.Context, cn.jpush.android.d.d, cn.jpush.android.x.c, cn.jpush.android.x.c):android.app.Notification");
    }

    public static void b(Context context, int i6) {
        int a6;
        if (!f.b(i6)) {
            f.a(i6);
        }
        int j6 = cn.jpush.android.cache.a.j(context);
        Logger.d("NotificationHelper", "queueSize:" + f.b() + ", max num:" + j6);
        if (f.b() <= j6 || (a6 = f.a()) == 0) {
            return;
        }
        d(context, a6);
    }

    public static void c(Context context, int i6) {
        if (i6 <= 0) {
            return;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            int a6 = f.a();
            if (a6 != 0) {
                d(context, a6);
            }
        }
    }

    private static boolean d(Context context, String str) {
        int importance;
        try {
            if (Build.VERSION.SDK_INT < 26 || TextUtils.isEmpty(str)) {
                return true;
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null) {
                importance = notificationChannel.getImportance();
                if (importance != 0) {
                    Logger.dd("NotificationHelper", str + " channel is opened,will use it");
                    return true;
                }
            }
            Logger.ww("NotificationHelper", str + " channel maybe closed,please check it");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static Intent a(Context context, String str, cn.jpush.android.d.d dVar) {
        Intent intent = new Intent(str);
        intent.setClass(context, PushActivity.class);
        if (dVar != null) {
            intent.putExtra("msg_data", dVar.c());
        }
        if (!cn.jpush.android.ad.a.j(context)) {
            intent.addFlags(32768);
        }
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00c6 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x000f, B:6:0x001a, B:9:0x0027, B:13:0x0037, B:15:0x0041, B:17:0x0048, B:19:0x0060, B:21:0x006f, B:23:0x007c, B:25:0x008f, B:32:0x00c6, B:34:0x00cc, B:107:0x00aa, B:108:0x0045, B:27:0x0094, B:29:0x009a), top: B:2:0x000f, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ee A[Catch: all -> 0x00f8, TRY_ENTER, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0172 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0183 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018f A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020b A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d2 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c3 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0164 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0146 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0101 A[Catch: all -> 0x00f8, TryCatch #1 {all -> 0x00f8, blocks: (B:40:0x00e0, B:43:0x00ee, B:45:0x00f3, B:46:0x0105, B:50:0x013d, B:53:0x014a, B:56:0x0168, B:58:0x0172, B:59:0x0174, B:61:0x0183, B:62:0x0185, B:64:0x018f, B:65:0x01c8, B:68:0x01ce, B:69:0x0207, B:71:0x020b, B:75:0x01d2, B:77:0x01d6, B:79:0x01df, B:80:0x01eb, B:81:0x01f3, B:82:0x01c3, B:83:0x0164, B:84:0x0146, B:93:0x00fc, B:94:0x0101), top: B:39:0x00e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0211  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r17, cn.jpush.android.d.d r18) {
        /*
            Method dump skipped, instructions count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.b(android.content.Context, cn.jpush.android.d.d):void");
    }

    public static void c(Context context, cn.jpush.android.d.d dVar) {
        if (dVar != null) {
            d(context, a(dVar));
        }
    }

    @TargetApi(23)
    private static Icon a(String str) {
        Icon createWithFilePath;
        try {
            if (new File(str).exists()) {
                createWithFilePath = Icon.createWithFilePath(str);
                return createWithFilePath;
            }
            Logger.w("NotificationHelper", "icon file doesn't exist, path=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "createIcon err:" + th);
            return null;
        }
    }

    public static boolean b(Context context) {
        try {
            if (!cn.jpush.android.cache.a.g(context)) {
                Logger.ii("NotificationHelper", "Notification was disabled by JPushInterface.setPushTime !");
                return false;
            }
            String h6 = cn.jpush.android.cache.a.h(context);
            if (TextUtils.isEmpty(h6)) {
                Logger.i("NotificationHelper", "no time limited");
                return true;
            }
            Logger.i("NotificationHelper", "push time is ：" + h6);
            String[] split = h6.split("_");
            String str = split[0];
            String str2 = split[1];
            char[] charArray = str.toCharArray();
            String[] split2 = str2.split("\\^");
            Calendar calendar = Calendar.getInstance();
            int i6 = calendar.get(7);
            int i7 = calendar.get(11);
            for (char c6 : charArray) {
                if (i6 == Integer.valueOf(String.valueOf(c6)).intValue() + 1) {
                    int intValue = Integer.valueOf(split2[0]).intValue();
                    int intValue2 = Integer.valueOf(split2[1]).intValue();
                    if (i7 >= intValue && i7 <= intValue2) {
                        return true;
                    }
                }
            }
            Logger.ii("NotificationHelper", "Current time is out of the push time - " + h6);
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b7, code lost:
    
        if (r8 <= 23) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
    
        if (r8 < r6) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bf, code lost:
    
        if (r7 >= r5) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c3, code lost:
    
        if (r7 <= r2) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.c(android.content.Context):boolean");
    }

    public static Uri a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (context.getResources().getIdentifier(str, ResIdentify.RES_TYPE_RAW, context.getPackageName()) != 0) {
                Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + str);
                StringBuilder sb = new StringBuilder();
                sb.append("found sound uri=");
                sb.append(parse);
                Logger.d("NotificationHelper", sb.toString());
                return parse;
            }
            Logger.d("NotificationHelper", "not found sound=" + str);
            return null;
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "find sound e:" + th);
            return null;
        }
    }

    private static PushNotificationBuilder a(Context context, NotificationMessage notificationMessage) {
        try {
            Class<?> cls = Class.forName("cn.jpush.android.support.JPushSupport");
            return (PushNotificationBuilder) cls.getDeclaredMethod("getNotificationBuilder", Context.class, NotificationMessage.class).invoke(cls, context, notificationMessage);
        } catch (Throwable unused) {
            return null;
        }
    }

    @TargetApi(11)
    public static c a(Context context, String str, int i6) {
        c cVar = new c();
        Object b6 = b(context, str, i6);
        if (b6 == null) {
            cVar.a(973L);
            return cVar;
        }
        if (Build.VERSION.SDK_INT >= 23 && androidx.core.app.k.a(b6)) {
            cVar.a(102);
            cVar.a(b6);
            return cVar;
        }
        if (!(b6 instanceof Bitmap)) {
            cVar.a(973L);
            return cVar;
        }
        cVar.a(100);
        cVar.a((Bitmap) b6);
        return cVar;
    }

    @TargetApi(11)
    public static c a(Context context, String str, String str2, String str3, String str4, String str5) {
        Icon a6;
        c cVar = new c();
        String str6 = "";
        int i6 = 0;
        try {
            if (TextUtils.isEmpty(str3)) {
                Logger.d("NotificationHelper", "[buildSmallIcon] smallIcon is empty");
            } else if (cn.jpush.android.ad.a.c(str3)) {
                str6 = d(JPushConstants.mApplicationContext, str3, 307200);
            } else {
                i6 = JPushConstants.mApplicationContext.getResources().getIdentifier(str3, ResIdentify.RES_TYPE_DRAWABLE, JPushConstants.mApplicationContext.getPackageName());
            }
        } catch (Throwable th) {
            Logger.d("NotificationHelper", "load small icon failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                Bitmap decodeFile = cn.jpush.android.ad.c.a(str6) ? BitmapFactory.decodeFile(str6) : null;
                if (decodeFile != null) {
                    Logger.d("NotificationHelper", "set small icon with path bitmap:" + decodeFile);
                    cVar.a(100);
                    cVar.a(decodeFile);
                } else {
                    Logger.d("NotificationHelper", "not set small icon by bitmap");
                    if (Build.VERSION.SDK_INT >= 23 && (a6 = a(str6)) != null) {
                        Logger.d("NotificationHelper", "set small icon success by path:" + str6);
                        cVar.a(102);
                        cVar.a(a6);
                    }
                }
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with sdcard path");
            }
            return cVar;
        }
        if (i6 != 0) {
            cVar.a(101);
            cVar.b(i6);
            Logger.d("NotificationHelper", "set small icon success by resId:" + i6 + ",resName:" + str3);
            return cVar;
        }
        if (TextUtils.isEmpty(str2) || str2.equals(context.getPackageName())) {
            int a7 = g.a(context);
            if (a7 == 0) {
                cVar.a(972L);
                return cVar;
            }
            cVar.a(101);
            cVar.b(a7);
            Logger.d("NotificationHelper", "set small icon success by mine icon resId:" + a7);
            return cVar;
        }
        try {
            if (cn.jpush.android.ad.a.a(context, str2, str5)) {
                Bitmap c6 = c(context, str2);
                if (c6 == null) {
                    Logger.w("NotificationHelper", "not found targetApp small icon bitmap,will give up notify the msg");
                    cVar.a(972L);
                } else {
                    cVar.a(100);
                    cVar.a(c6);
                    Logger.d("NotificationHelper", "set small icon success by targetAppBitmap");
                }
            } else {
                Logger.w("NotificationHelper", "targetApp ：" + str2 + " is not install,will give up notify the msg");
                cVar.a(993L);
            }
            return cVar;
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "set small icon by targetApp icon bitmap failed:" + th2.getMessage());
            cVar.a(972L);
            return cVar;
        }
    }

    private static String a(Context context, String str, String str2) {
        if (!cn.jpush.android.ad.a.a(str, false)) {
            Logger.i("NotificationHelper", "The url is not a picture resources.");
            return "";
        }
        Logger.i("NotificationHelper", "The url is a picture resources.");
        String str3 = cn.jpush.android.ad.c.c(context, str2) + (str2 + cn.jpush.android.ad.a.b(str));
        Logger.i("NotificationHelper", "Big picture notification resource path: " + str3);
        byte[] a6 = cn.jpush.android.w.b.a(context, str, "notify_img", 5, 5000L, 4);
        return (a6 == null || !cn.jpush.android.ad.c.a(str3, a6)) ? "" : str3;
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", Context.class, CharSequence.class, CharSequence.class, PendingIntent.class).invoke(notification, context, str, str2, pendingIntent);
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, a.C0059a c0059a) {
    }

    public static void a(Context context) {
        while (true) {
            int a6 = f.a();
            if (a6 == 0) {
                return;
            } else {
                d(context, a6);
            }
        }
    }

    public static void a(Context context, int i6, int i7, String str) {
        a(context, i6, i7, str, (Bundle) null);
    }

    public static void a(Context context, int i6, int i7, String str, Bundle bundle) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                return;
            }
            boolean z5 = true;
            if (i6 == -1 || i6 == 1) {
                try {
                    z5 = a((Class<?>) JPushMessageReceiver.class, Class.forName(messageReceiverClass), "onConnected", (Class<?>[]) new Class[]{Context.class, Boolean.TYPE});
                    Logger.d("NotificationHelper", "method isImplemented: " + z5);
                } catch (Throwable unused) {
                }
            }
            if (z5) {
                Intent intent = new Intent();
                intent.setClassName(context, messageReceiverClass);
                intent.setAction(cn.jpush.android.ad.a.e(context, "cmd_msg"));
                intent.putExtra("cmd", i6);
                intent.putExtra("code", i7);
                intent.putExtra(CrashHianalyticsData.MESSAGE, str);
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    cn.jpush.android.helper.a.a(JPushConstants.getPushMessageReceiver(context), context, intent);
                } else {
                    cn.jpush.android.helper.a.a(context, intent);
                }
            }
        } catch (Throwable th) {
            Logger.w("NotificationHelper", "sendCmdMsgToUser failed:" + th.getMessage());
        }
    }

    public static void a(Context context, int i6, boolean z5) {
        try {
            boolean z6 = true;
            if (d(context) != 1) {
                z6 = false;
            }
            Logger.d("NotificationHelper", "[checkNotificationSettings] new state:" + z6 + ",last state:" + f3989b + ",soucre:" + i6 + ",isFocre:" + z5);
            if (!z6) {
                Logger.kd("NotificationHelper", "notification trigger is off, will not show notification");
            }
            Boolean bool = f3989b;
            if (bool != null && z6 == bool.booleanValue() && !z5) {
                Logger.d("NotificationHelper", "[checkNotificationSettings] no change");
                return;
            }
            f3989b = Boolean.valueOf(z6);
            JPushMessageReceiver pushMessageReceiver = JPushConstants.getPushMessageReceiver(context);
            if (pushMessageReceiver != null) {
                pushMessageReceiver.onNotificationSettingsCheck(context, f3989b.booleanValue(), i6);
            } else {
                try {
                    Intent intent = new Intent(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                    intent.setAction("on_noti_settings_check");
                    intent.putExtra("isOn", f3989b);
                    intent.putExtra(SocialConstants.PARAM_SOURCE, i6);
                    cn.jpush.android.helper.a.a(context, intent);
                } catch (Throwable th) {
                    Logger.w("NotificationHelper", "checkNotificationSettings send to user e:" + th);
                }
            }
            cn.jpush.android.aa.a.a().a(context, "on_check");
        } catch (Throwable th2) {
            Logger.w("NotificationHelper", "checkNotificationSettings e:" + th2);
        }
    }

    public static void a(Context context, Notification.Builder builder, a.C0059a c0059a) {
        if (c0059a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 26 && c0059a.f3987i) {
                    Logger.d("NotificationHelper", "setChannelId =" + c0059a.f3979a);
                    d(context, c0059a.f3979a);
                    builder.setChannelId(c0059a.f3979a);
                }
                builder.setPriority(c0059a.f3981c);
                builder.setDefaults(c0059a.f3984f);
                builder.setSound(c0059a.f3986h);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, cn.jpush.android.d.d dVar) {
        Logger.d("NotificationHelper", "[processMessage] pushEntity:" + dVar);
        if (dVar.ae == 0) {
            JCoreHelper.majorExecutor(context, JPushConstants.SDK_TYPE, new a(context, dVar));
            return;
        }
        Logger.d("NotificationHelper", "Unexpected: unknown show  mode - " + dVar.ae);
    }

    public static void a(Context context, Integer num, Notification notification) {
        if (num == null) {
            return;
        }
        Key<Integer> BadgeCurNum = Key.BadgeCurNum();
        int intValue = ((Integer) Sp.get(context, BadgeCurNum)).intValue();
        if (intValue < 0) {
            intValue = 0;
        }
        if (num.intValue() != 0) {
            if (num.intValue() + intValue < 0) {
                num = Integer.valueOf(-intValue);
            }
            intValue += num.intValue();
            Sp.set(context, BadgeCurNum.set(Integer.valueOf(intValue)));
        }
        Logger.d("NotificationHelper", "curNum：" + intValue + ",addNum:" + num);
        a(context, notification, num.intValue(), intValue);
    }

    public static void a(Context context, String str, cn.jpush.android.d.d dVar, Intent intent) {
        a(context, str, dVar, intent, (String) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0101 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #0 {all -> 0x001b, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x0017, B:8:0x001e, B:10:0x0023, B:12:0x0029, B:13:0x002c, B:14:0x004d, B:17:0x0055, B:19:0x005d, B:20:0x00fb, B:22:0x0101, B:27:0x006b, B:29:0x0072, B:30:0x0076, B:32:0x007e, B:33:0x0084, B:35:0x008c, B:36:0x0094, B:38:0x009a, B:39:0x00a2, B:41:0x00aa, B:42:0x00b2, B:44:0x00ba, B:45:0x00c2, B:47:0x00ca, B:48:0x00d2, B:50:0x00da, B:51:0x00e2, B:52:0x00e6), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r3, java.lang.String r4, cn.jpush.android.d.d r5, android.content.Intent r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.b.a(android.content.Context, java.lang.String, cn.jpush.android.d.d, android.content.Intent, java.lang.String):void");
    }

    private static boolean a() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(l3.f4736f, String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                Logger.i("NotificationHelper", "get EMUI version is:" + str);
                return cn.jpush.android.ad.a.a(str.toLowerCase().replace("emotionui_", ""), "8.0") >= 0;
            }
        } catch (Throwable th) {
            Logger.e("NotificationHelper", " getEmuiVersion wrong error:" + th);
        }
        return false;
    }

    private static boolean a(Notification notification, int i6) {
        try {
            if (f3988a == null) {
                try {
                    f3988a = Integer.valueOf(cn.jpush.android.ad.a.e("ro.miui.ui.version.name"));
                } catch (Throwable unused) {
                    f3988a = 7;
                }
            }
        } catch (Exception unused2) {
        }
        if (notification == null) {
            return false;
        }
        if (f3988a.intValue() >= 12) {
            notification.number = i6;
            return false;
        }
        Object obj = notification.getClass().getDeclaredField("extraNotification").get(notification);
        obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i6));
        return true;
    }

    public static boolean a(Context context, int i6) {
        StringBuilder sb;
        StatusBarNotification[] activeNotifications;
        boolean z5 = false;
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                Logger.d("NotificationHelper", "active size:" + activeNotifications.length);
                int length = activeNotifications.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length) {
                        break;
                    }
                    if (activeNotifications[i7].getId() == i6) {
                        z5 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (z5) {
                sb = new StringBuilder();
                sb.append("show  notification success:");
                sb.append(i6);
            } else {
                sb = new StringBuilder();
                sb.append("show  notification maybe failed:");
                sb.append(i6);
            }
            Logger.dd("NotificationHelper", sb.toString());
            return z5;
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "[checkNotficationShow] failed:" + th.getMessage());
            return z5;
        }
    }

    @TargetApi(11)
    private static boolean a(Context context, Notification.Builder builder, c cVar, c cVar2) {
        boolean z5;
        Icon createWithBitmap;
        int a6 = cVar.a();
        if (a6 != 102 || Build.VERSION.SDK_INT < 23) {
            z5 = false;
        } else {
            builder.setSmallIcon(androidx.core.app.l.a(cVar.b()));
            z5 = true;
        }
        if (!z5 && a6 == 100 && Build.VERSION.SDK_INT >= 23) {
            createWithBitmap = Icon.createWithBitmap(cVar.c());
            builder.setSmallIcon(createWithBitmap);
            z5 = true;
        }
        if (!z5 && a6 == 101) {
            try {
                context.getResources().getDrawable(cVar.d());
                Logger.d("NotificationHelper", "set small icon by local resId:" + cVar.d());
                builder.setSmallIcon(cVar.d());
                z5 = true;
            } catch (Throwable unused) {
                Logger.w("NotificationHelper", "resource not found with local app");
            }
        }
        if (!z5) {
            return false;
        }
        int a7 = cVar2.a();
        if (a7 == 102) {
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setLargeIcon(androidx.core.app.l.a(cVar2.b()));
            }
        } else if (a7 == 100) {
            builder.setLargeIcon(cVar2.c());
        } else {
            Logger.d("NotificationHelper", "not set large icon");
        }
        return true;
    }

    public static boolean a(Context context, Notification notification, int i6, int i7) {
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("xiaomi")) {
            return a(notification, i6);
        }
        if (a()) {
            if (i7 == 0 || i6 != 0) {
                return h(context, i7);
            }
            return false;
        }
        if (cn.jpush.android.ad.a.b()) {
            if (i7 == 0 || i6 != 0) {
                return g(context, i7);
            }
            return false;
        }
        if (str.equalsIgnoreCase("HONOR")) {
            if (i7 == 0 || i6 != 0) {
                return f(context, i7);
            }
            return false;
        }
        if (!str.equalsIgnoreCase("NIO")) {
            Logger.d("NotificationHelper", "not support");
            return false;
        }
        if (i7 == 0 || i6 != 0) {
            return e(context, i7);
        }
        return false;
    }

    public static boolean a(Context context, Intent intent) {
        String stringExtra;
        JSONObject jSONObject;
        String str = "";
        try {
            stringExtra = intent.getStringExtra("msg_data");
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(stringExtra)) {
            return true;
        }
        Logger.d("NotificationHelper", "handleOriginalMessage string=" + stringExtra);
        JSONObject jSONObject2 = new JSONObject(stringExtra);
        Logger.d("NotificationHelper", "handleOriginalMessage json=" + jSONObject2);
        String str2 = jSONObject2.optString("messageId");
        try {
            Logger.d("NotificationHelper", "handleOriginalMessage msgID=" + str2);
            String optString = jSONObject2.optString("originalMessage");
            Logger.d("NotificationHelper", "handleOriginalMessage originalMessage=" + optString);
            jSONObject = new JSONObject(optString);
            Logger.d("NotificationHelper", "handleOriginalMessage jsonObject=" + jSONObject);
        } catch (Throwable unused2) {
            str = str2;
            str2 = str;
            Logger.d("NotificationHelper", "handleOriginalMessage check fail drop it");
            cn.jpush.android.helper.c.a(str2, 1107L, context);
            return false;
        }
        if (1 == jSONObject.optInt("notificaion_type")) {
            Logger.d("NotificationHelper", "handleOriginalMessage local notification return true");
            return true;
        }
        String optString2 = jSONObject.optString("n_ssl");
        Logger.d("NotificationHelper", "handleOriginalMessage server ssl=" + optString2);
        String a6 = cn.jpush.android.ad.l.a(JCoreHelper.getUid(context) + str2);
        if (!TextUtils.isEmpty(a6)) {
            a6 = a6.toLowerCase().replace(":", "");
        }
        Logger.d("NotificationHelper", "handleOriginalMessage local ssl=" + a6);
        if (TextUtils.equals(a6, optString2)) {
            Logger.d("NotificationHelper", "handleOriginalMessage check success");
            return true;
        }
        Logger.d("NotificationHelper", "handleOriginalMessage check fail drop it");
        cn.jpush.android.helper.c.a(str2, 1107L, context);
        return false;
    }

    public static boolean a(Context context, String str, cn.jpush.android.d.d dVar, NotificationMessage notificationMessage) {
        try {
        } catch (Throwable th) {
            Logger.ww("NotificationHelper", "check display foreground failed:" + th.getMessage());
        }
        if (Class.forName(str).getMethod("onNotifyMessageUnShow", Context.class, NotificationMessage.class) == null) {
            Logger.dd("NotificationHelper", "not found onNotifyMessageUnShow method");
            return false;
        }
        if (!TextUtils.isEmpty(dVar.J)) {
            if (dVar.J.equals("0")) {
                if (cn.jpush.android.ad.a.j(context)) {
                    Logger.dd("NotificationHelper", "displayForeground...");
                    a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                    cn.jpush.android.helper.c.a(dVar.f3588d, 1060L, context);
                    return true;
                }
            } else if (!((JPushMessageReceiver) Class.forName(str).newInstance()).isNeedShowNotification(context, notificationMessage, cn.jpush.android.ad.a.d(context))) {
                Logger.dd("NotificationHelper", "need not show notication by user");
                a(context, "cn.jpush.android.intent.NOTIFICATION_UN_SHOW", dVar, (Intent) null);
                cn.jpush.android.helper.c.a(dVar.f3588d, 1061L, context);
                return true;
            }
        }
        return false;
    }

    public static boolean a(Class<?> cls, Class<?> cls2, String str, Class<?>... clsArr) {
        try {
            return !cls2.getDeclaredMethod(str, clsArr).getDeclaringClass().equals(cls.getDeclaredMethod(str, clsArr).getDeclaringClass());
        } catch (NoSuchMethodException unused) {
            return false;
        } catch (Throwable unused2) {
            return true;
        }
    }
}
