package cn.jiguang.ba;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.android.IDataShare;
import cn.jiguang.ba.f;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jiguang.internal.JCoreInternalHelper;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, String> f1900a = new HashMap();

    /* renamed from: cn.jiguang.ba.e$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final e f1901a = new e(null);
    }

    private e() {
    }

    public Bundle a(Context context, String str, String str2, Bundle bundle, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String a6 = cn.jiguang.bz.a.a(context);
        if (TextUtils.isEmpty(a6)) {
            return null;
        }
        if (a6.equals(str3)) {
            return b(context, str, str2, bundle);
        }
        Bundle a7 = a(str, str2, bundle, str3);
        if (a7 != null) {
            return a7;
        }
        Bundle b6 = b(context, str, str2, bundle, str3);
        if (b6 != null) {
            return b6;
        }
        return null;
    }

    public Bundle b(Context context, String str, String str2, Bundle bundle) {
        try {
            cn.jiguang.bb.f.c("JMessenger", "directHandle, " + str + "." + str2);
            if ("INTERNAL_API".equals(str)) {
                return g.a().b(str2, bundle);
            }
            Class<?> cls = Class.forName(str);
            if (!BroadcastReceiver.class.isAssignableFrom(cls) && !Service.class.isAssignableFrom(cls)) {
                cn.jiguang.bb.f.l("JMessenger", "directHandle, not support " + str + "." + str2);
                return null;
            }
            if (JCommonService.class.isAssignableFrom(cls)) {
                cn.jiguang.bb.f.c("JMessenger", "JCommonService handle succeed," + str + "." + str2);
                JCoreInternalHelper.getInstance().onEvent(context, JConstants.SDK_TYPE, 2, true, str2, bundle, new Object[0]);
                return new Bundle();
            }
            Intent intent = new Intent(str2);
            intent.setClass(context, cls);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.setPackage(context.getPackageName());
            intent.addCategory(context.getPackageName());
            if (PushReceiver.class.isAssignableFrom(cls)) {
                cn.jiguang.bb.f.c("JMessenger", "PushReceiver handle succeed," + str + "." + str2);
                ActionManager.getInstance().handleMessage(context, bundle != null ? bundle.getString("sdktype") : null, intent);
            } else if (BroadcastReceiver.class.isAssignableFrom(cls)) {
                cn.jiguang.bb.f.c("JMessenger", "Receiver onReceive," + str + "." + str2);
                ((BroadcastReceiver) cls.newInstance()).onReceive(context, intent);
            } else {
                cn.jiguang.bb.f.c("JMessenger", "Service onStartCommand," + str + "." + str2);
                ((Service) cls.newInstance()).onStartCommand(intent, 0, 0);
            }
            return new Bundle();
        } catch (Throwable th) {
            cn.jiguang.bb.f.l("JMessenger", "directHandle e:" + th);
            return null;
        }
    }

    /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    private Bundle a(String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            IDataShare dataShare = DataShare.getInstance(str3);
            if (dataShare == null) {
                cn.jiguang.bb.f.c("JMessenger", str3 + "'s aidl not found, " + str4);
                return null;
            }
            cn.jiguang.bb.f.c("JMessenger", "sendByAidl, " + str4);
            if ("INTERNAL_API".equals(str)) {
                return dataShare.execute(str, str2, bundle);
            }
            if (f.b.a().a(bundle, str3)) {
                f.b.a().a(dataShare, str3);
            } else {
                dataShare.onAction(str, str2, bundle);
            }
            return new Bundle();
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JMessenger", "sendByAidl, " + str4 + ", e=" + th);
            return null;
        }
    }

    private Bundle b(Context context, String str, String str2, Bundle bundle, String str3) {
        String str4 = str + "." + str2;
        try {
            String a6 = a(context, str3);
            if (TextUtils.isEmpty(a6)) {
                cn.jiguang.bb.f.c("JMessenger", "uri is null, check provider config");
                return null;
            }
            Uri parse = Uri.parse(a6);
            cn.jiguang.bb.f.c("JMessenger", "sendByProvider, uri=" + a6 + ", " + str4);
            return f.b.a().a(bundle, str3) ? f.b.a().a(context, parse, str3) : context.getContentResolver().call(parse, str, str2, bundle);
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JMessenger", "provider call:" + th);
            return null;
        }
    }

    public static e a() {
        return a.f1901a;
    }

    private static String a(Context context, String str) {
        StringBuilder sb;
        String str2 = f1900a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = context.getPackageName() + JConstants.DATA_PROVIDER_SUFFIX;
        ProviderInfo a6 = cn.jiguang.bz.a.a(context, context.getPackageName(), str3);
        if (str.equals(a6 != null ? a6.processName : null)) {
            sb = new StringBuilder();
        } else {
            str3 = context.getPackageName() + ".DownloadProvider";
            ProviderInfo a7 = cn.jiguang.bz.a.a(context, context.getPackageName(), str3);
            if (!str.equals(a7 != null ? a7.processName : null)) {
                return "";
            }
            sb = new StringBuilder();
        }
        sb.append("content://");
        sb.append(str3);
        sb.append("/");
        String sb2 = sb.toString();
        f1900a.put(str, sb2);
        return sb2;
    }

    private boolean a(Context context, Class cls, String str, Bundle bundle) {
        Intent intent;
        if (cls == null) {
            return false;
        }
        String str2 = cls.getName() + "." + str;
        try {
            intent = new Intent();
            intent.setClass(context, cls);
            intent.setAction(str);
            intent.setPackage(context.getPackageName());
            if (bundle != null) {
                intent.putExtras(bundle);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("JMessenger", "sendByComponent, " + str2 + " e=" + th);
        }
        if (BroadcastReceiver.class.isAssignableFrom(cls)) {
            context.sendBroadcast(intent);
            cn.jiguang.bb.f.c("JMessenger", "sendByReceiver, " + str2);
            return true;
        }
        if (Service.class.isAssignableFrom(cls)) {
            if (context.startService(intent) != null) {
                cn.jiguang.bb.f.c("JMessenger", "sendByService, " + str2);
                return true;
            }
            cn.jiguang.bb.f.i("JMessenger", "startService, " + str2 + ", can't find component");
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:14:0x0067, B:18:0x006f), top: B:13:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r11, java.lang.String r12, java.lang.String r13, android.os.Bundle r14) {
        /*
            r10 = this;
            java.lang.String r7 = " meet e:"
            java.lang.String r8 = "JMessenger"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            java.lang.String r1 = "."
            r0.append(r1)
            r0.append(r13)
            java.lang.String r9 = r0.toString()
            r1 = 0
            java.lang.Class r6 = java.lang.Class.forName(r12)     // Catch: java.lang.Throwable -> L4f
            java.lang.Class<android.app.Service> r0 = android.app.Service.class
            boolean r0 = r0.isAssignableFrom(r6)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L3b
            java.lang.String r5 = cn.jiguang.bz.a.a(r11, r12)     // Catch: java.lang.Throwable -> L39
            cn.jiguang.ba.f$b r0 = cn.jiguang.ba.f.b.a()     // Catch: java.lang.Throwable -> L36
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r0.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L36
            r1 = r5
            goto L47
        L36:
            r0 = move-exception
            r1 = r5
            goto L51
        L39:
            r0 = move-exception
            goto L51
        L3b:
            java.lang.Class<android.content.BroadcastReceiver> r0 = android.content.BroadcastReceiver.class
            boolean r0 = r0.isAssignableFrom(r6)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L47
            java.lang.String r1 = cn.jiguang.bz.a.b(r11, r12)     // Catch: java.lang.Throwable -> L39
        L47:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r0 = r6
            r6 = r1
            r1 = r10
            goto L67
        L4f:
            r0 = move-exception
            r6 = r1
        L51:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r7)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            cn.jiguang.bb.f.c(r8, r0)
            goto L47
        L67:
            android.os.Bundle r3 = r1.a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L76
            r1 = 1
            if (r3 == 0) goto L6f
            return r1
        L6f:
            boolean r0 = r10.a(r11, r0, r13, r14)     // Catch: java.lang.Throwable -> L76
            if (r0 == 0) goto L91
            return r1
        L76:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "send, "
            r1.append(r3)
            r1.append(r9)
            r1.append(r7)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            cn.jiguang.bb.f.i(r8, r0)
        L91:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "send all failed, "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            cn.jiguang.bb.f.l(r8, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.ba.e.a(android.content.Context, java.lang.String, java.lang.String, android.os.Bundle):boolean");
    }
}
