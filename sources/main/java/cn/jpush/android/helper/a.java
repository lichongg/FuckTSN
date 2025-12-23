package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.net.Uri;
import android.os.Bundle;
import cn.jpush.android.api.CmdMessage;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JPushMessageReceiver;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.components.ad.reward.monitor.FraudVerifyCode;
import com.kwad.library.solder.lib.ext.PluginError;
import com.stub.StubApp;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3671a;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f3672c;

    /* renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f3673b;

    /* renamed from: cn.jpush.android.helper.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* renamed from: cn.jpush.android.helper.a$a, reason: collision with other inner class name */
    private class C0055a extends cn.jpush.android.ad.f {

        /* renamed from: b, reason: collision with root package name */
        private Context f3675b;

        /* renamed from: c, reason: collision with root package name */
        private JPushMessageReceiver f3676c;

        /* renamed from: d, reason: collision with root package name */
        private Intent f3677d;

        public C0055a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
            this.f3675b = context;
            this.f3676c = jPushMessageReceiver;
            this.f3677d = intent;
            this.f3443e = "JMessageReceiverHelper#MessageReceiverRunable";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            a.b(this.f3675b, this.f3676c, this.f3677d);
            cn.jpush.android.ac.e.a().a(this.f3675b, this.f3677d);
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f3678a = new a(null);
    }

    private a() {
        b();
    }

    public static a a() {
        return b.f3678a;
    }

    private void b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
        this.f3673b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static void a(Context context, Intent intent) {
        StringBuilder sb;
        if (context == null) {
            return;
        }
        try {
            String packageName = context.getPackageName();
            if (JPushConstants.isForeGround == 0) {
                Logger.d("JMessageReceiverHelper", "foreground no need provider,use sendBroadcast");
                sb = new StringBuilder();
                sb.append(packageName);
                sb.append(JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
            } else {
                if (a(context)) {
                    Logger.d("JMessageReceiverHelper", "send by provider intent=" + intent);
                    context.getContentResolver().call(Uri.parse("content://" + (packageName + ".jiguang.InitProvider") + "/"), "null", "null", cn.jpush.android.ad.a.a(intent));
                    return;
                }
                Logger.d("JMessageReceiverHelper", "no support provider ,use sendBroadcast");
                sb = new StringBuilder();
                sb.append(packageName);
                sb.append(JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
            }
            context.sendBroadcast(intent, sb.toString());
        } catch (Throwable th) {
            Logger.d("JMessageReceiverHelper", "send Throwable: " + th);
        }
    }

    public static void b(Context context, Intent intent) {
        try {
            Logger.i("JMessageReceiverHelper", "Click notification action with extra: " + intent.getExtras().getString(JPushInterface.EXTRA_NOTIFICATION_ACTION_EXTRA));
            Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_CLICK_ACTION);
            intent2.putExtras(intent.getExtras());
            intent2.addCategory(context.getPackageName());
            intent2.setPackage(context.getPackageName());
            context.sendBroadcast(intent2, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX);
        } catch (Throwable th) {
            Logger.ww("JMessageReceiverHelper", "Click notification sendBroadcast :" + th.getMessage());
        }
    }

    public static void a(Context context, CustomMessage customMessage) {
        if (context == null || customMessage == null) {
            Logger.dd("JMessageReceiverHelper", "Send custom message to app failed, param is invalid!");
            return;
        }
        Logger.dd("JMessageReceiverHelper", "not found user push message,use old action to user");
        Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
        intent.putExtra(JPushInterface.EXTRA_APP_KEY, customMessage.senderId);
        intent.putExtra(JPushInterface.EXTRA_MESSAGE, customMessage.message);
        intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, customMessage.contentType);
        intent.putExtra(JPushInterface.EXTRA_TITLE, customMessage.title);
        intent.putExtra(JPushInterface.EXTRA_EXTRA, customMessage.extra);
        intent.putExtra(JPushInterface.EXTRA_MSG_ID, customMessage.messageId);
        if (JPushConstants.SDK_VERSION_CODE >= 387) {
            intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, customMessage.platform);
        }
        intent.addCategory(customMessage.appId);
        intent.setPackage(context.getPackageName());
        Locale locale = Locale.ENGLISH;
        context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
        Logger.i("JMessageReceiverHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", customMessage.appId));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r9, cn.jpush.android.service.JPushMessageReceiver r10, android.content.Intent r11) {
        /*
            Method dump skipped, instructions count: 621
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.a.b(android.content.Context, cn.jpush.android.service.JPushMessageReceiver, android.content.Intent):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ad A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cb A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00da A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0103 A[Catch: all -> 0x005e, TryCatch #0 {all -> 0x005e, blocks: (B:8:0x0019, B:10:0x0056, B:11:0x0061, B:13:0x0069, B:14:0x0070, B:16:0x0075, B:18:0x007d, B:19:0x0093, B:20:0x00a9, B:22:0x00ad, B:23:0x00c3, B:25:0x00cb, B:26:0x00d2, B:28:0x00da, B:29:0x00e1, B:31:0x00e9, B:32:0x00f0, B:34:0x00f8, B:35:0x00ff, B:37:0x0103, B:41:0x010a, B:43:0x010e, B:45:0x0114, B:46:0x0121, B:48:0x0125, B:50:0x012b, B:51:0x013c, B:53:0x0142, B:55:0x0150, B:56:0x0155, B:60:0x015f, B:58:0x0166, B:63:0x016c, B:64:0x0175, B:68:0x0082, B:70:0x0087, B:72:0x008f, B:73:0x0097, B:75:0x009c, B:77:0x00a4), top: B:7:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r8, cn.jpush.android.api.NotificationMessage r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.helper.a.a(android.content.Context, cn.jpush.android.api.NotificationMessage, java.lang.String):void");
    }

    public void a(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        if (context == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor = this.f3673b;
        if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
            b();
        }
        this.f3673b.execute(new C0055a(StubApp.getOrigApplicationContext(context.getApplicationContext()), jPushMessageReceiver, intent));
    }

    public static void a(JPushMessageReceiver jPushMessageReceiver, Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("code", -2);
            int intExtra2 = intent.getIntExtra("cmd", -2);
            String stringExtra = intent.getStringExtra(CrashHianalyticsData.MESSAGE);
            Logger.d("JMessageReceiverHelper", "[callCmdMessage] code:" + intExtra + ",cmd:" + intExtra2 + ",message:" + stringExtra);
            Bundle extras = intent.getExtras();
            if (intExtra2 == -1) {
                jPushMessageReceiver.onConnected(context, false);
                return;
            }
            if (intExtra2 == 0) {
                if (intExtra == 0) {
                    jPushMessageReceiver.onRegister(context, stringExtra);
                    return;
                } else {
                    jPushMessageReceiver.onCommandResult(context, new CmdMessage(intExtra2, intExtra, stringExtra, extras));
                    return;
                }
            }
            if (intExtra2 == 1) {
                jPushMessageReceiver.onConnected(context, true);
                if (f3671a) {
                    return;
                }
                f3671a = true;
                Bundle bundle = new Bundle();
                bundle.putInt("cmd", PluginError.ERROR_UPD_NO_DOWNLOADER);
                bundle.putInt("code", 0);
                bundle.putString(CrashHianalyticsData.MESSAGE, "success");
                jPushMessageReceiver.onCommandResult(context, new CmdMessage(PluginError.ERROR_UPD_NO_DOWNLOADER, 0, stringExtra, bundle));
                return;
            }
            if (intExtra2 != 2001) {
                if (intExtra2 != 2009) {
                    if (intExtra2 == 2011) {
                        Logger.d("debug_110", "CMD_TCP_STATE code=" + intExtra);
                        cn.jpush.android.cache.a.b(context, intExtra == 0);
                        return;
                    }
                    if (intExtra2 != 10000) {
                        switch (intExtra2) {
                            case 2003:
                            case PluginError.ERROR_UPD_EXTRACT /* 2004 */:
                            case PluginError.ERROR_UPD_CAPACITY /* 2005 */:
                            case PluginError.ERROR_UPD_REQUEST /* 2006 */:
                            case PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD /* 2007 */:
                                break;
                            default:
                                switch (intExtra2) {
                                    case FraudVerifyCode.RerwardFraudUnknown /* 100001 */:
                                    case 100002:
                                    case 100003:
                                    case 100004:
                                    case 100005:
                                        break;
                                    default:
                                        Logger.dd("JMessageReceiverHelper", "unkown cmd:" + intExtra2);
                                        break;
                                }
                                return;
                        }
                    }
                }
                jPushMessageReceiver.onCommandResult(context, new CmdMessage(intExtra2, intExtra, stringExtra, extras));
            }
        } catch (Throwable th) {
            Logger.e("JMessageReceiverHelper", "callCmdMessage failed:" + th.getMessage());
        }
    }

    private static boolean a(Context context) {
        try {
        } catch (Throwable th) {
            f3672c = Boolean.FALSE;
            Logger.d("JMessageReceiverHelper", "throwable=" + th);
        }
        if (cn.jpush.android.m.a.f3710c < 470) {
            Logger.d("JMessageReceiverHelper", "jcore < 470");
            return false;
        }
        Boolean bool = f3672c;
        if (bool != null) {
            return bool.booleanValue();
        }
        ComponentInfo a6 = cn.jpush.android.ad.a.a(context, context.getPackageName(), Class.forName("cn.jpush.android.service.InitProvider"));
        if (a6 != null) {
            f3672c = Boolean.valueOf(context.getPackageName().equals(a6.processName));
            Logger.d("JMessageReceiverHelper", "isSupportProvider info=" + f3672c);
        } else {
            Logger.d("JMessageReceiverHelper", "ComponentInfo is null");
            f3672c = Boolean.FALSE;
        }
        return f3672c.booleanValue();
    }
}
