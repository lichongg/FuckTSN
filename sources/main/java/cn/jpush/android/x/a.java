package cn.jpush.android.x;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.util.Locale;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a {
    public static int a(int i6) {
        if (i6 == -2) {
            return 1;
        }
        if (i6 != -1) {
            return (i6 == 1 || i6 == 2) ? 4 : 3;
        }
        return 2;
    }

    public static int b(int i6) {
        if (i6 == 0 || i6 == 1) {
            return -2;
        }
        if (i6 != 2) {
            return (i6 == 4 || i6 == 5) ? 1 : 0;
        }
        return -1;
    }

    /* renamed from: cn.jpush.android.x.a$a, reason: collision with other inner class name */
    public static class C0059a {

        /* renamed from: a, reason: collision with root package name */
        public String f3979a;

        /* renamed from: b, reason: collision with root package name */
        public CharSequence f3980b;

        /* renamed from: c, reason: collision with root package name */
        public int f3981c;

        /* renamed from: d, reason: collision with root package name */
        public int f3982d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3983e;

        /* renamed from: f, reason: collision with root package name */
        public int f3984f;

        /* renamed from: g, reason: collision with root package name */
        public String f3985g;

        /* renamed from: h, reason: collision with root package name */
        public Uri f3986h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3987i;

        public C0059a(String str, CharSequence charSequence, int i6, int i7, String str2, int i8) {
            boolean z5;
            this.f3979a = str;
            this.f3980b = charSequence;
            this.f3981c = i6;
            this.f3984f = i7;
            this.f3985g = str2;
            this.f3982d = i8;
            if (-1 != i8) {
                z5 = true;
            } else {
                z5 = false;
            }
            this.f3983e = z5;
        }
    }

    private static String a(Context context, int i6) {
        boolean z5;
        StringBuilder sb;
        String str = "";
        try {
            String str2 = "jg_channel_name_p_" + (i6 != -2 ? i6 != -1 ? (i6 == 1 || i6 == 2) ? "HIGH" : "DEFAULT" : "LOW" : "MIN").toLowerCase();
            int identifier = context.getResources().getIdentifier(str2, ResIdentify.RES_TYPE_STRING, context.getPackageName());
            if (identifier != 0) {
                str = context.getResources().getString(identifier);
                sb = new StringBuilder();
                sb.append("found ");
                sb.append(str);
                sb.append(" from resource by name:");
                sb.append(str2);
            } else {
                sb = new StringBuilder();
                sb.append("not found string value from resource by name:");
                sb.append(str2);
            }
            Logger.dd("ChannelHelper", sb.toString());
        } catch (Throwable th) {
            Logger.ww("ChannelHelper", "get resource channel ID failed:" + th.getMessage());
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            z5 = Locale.getDefault().getLanguage().contains("zh");
        } catch (Throwable th2) {
            Logger.ww("ChannelHelper", "get language failed:" + th2.getMessage());
            z5 = true;
        }
        if (i6 == -2 || i6 == -1) {
            return z5 ? "不重要" : "LOW";
        }
        if (i6 == 1 || i6 == 2) {
            return z5 ? "重要" : "HIGH";
        }
        return z5 ? "普通" : "NORMAL";
    }

    private static NotificationChannel b(Context context, C0059a c0059a) {
        try {
        } catch (Throwable th) {
            Logger.e("ChannelHelper", "config channelID error,will use sdk default channel ID:" + th);
        }
        if (Build.VERSION.SDK_INT < 26 || c0059a == null) {
            return null;
        }
        String str = c0059a.f3979a;
        if (!TextUtils.isEmpty(str)) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager != null ? notificationManager.getNotificationChannel(str) : null;
            if (notificationChannel != null) {
                if (c0059a.f3983e) {
                    int a6 = a(c0059a.f3981c);
                    notificationChannel.setImportance(a6);
                    Logger.dd("ChannelHelper", "channel has created: " + str + ",set importance:" + a6);
                }
                Logger.dd("ChannelHelper", "channel has created: " + str);
                return notificationChannel;
            }
            Logger.dd("ChannelHelper", "not found channed id from user set,will use sdk default channel ID");
        }
        return null;
    }

    private static String a(Context context, int i6, int i7) {
        int a6 = a(i6);
        String str = "JPush_" + a6 + "_" + i7;
        String a7 = a(context, i6);
        Logger.d("ChannelHelper", "channelId:" + str + ",channelName:" + a7 + ",importance:" + a6);
        return a(context, str, a7, a6, i7, null, false) ? str : "";
    }

    private static String a(C0059a c0059a) {
        String str = "JPush_" + c0059a.f3982d + "_" + c0059a.f3984f;
        if (c0059a.f3986h == null) {
            return str;
        }
        return str + "_" + c0059a.f3985g;
    }

    public static void a(Context context) {
        a(context, -1, 0);
        a(context, 0, 7);
    }

    public static void a(Context context, Notification.Builder builder, String str, CharSequence charSequence, int i6, int i7, String str2, int i8) {
        C0059a c0059a = new C0059a(str, charSequence, i6, i7, str2, i8);
        a(context, c0059a);
        b.a(context, builder, c0059a);
    }

    public static void a(Context context, Notification notification, String str, CharSequence charSequence, int i6, int i7, String str2, int i8) {
        C0059a c0059a = new C0059a(str, charSequence, i6, i7, str2, i8);
        a(context, c0059a);
        b.a(notification, c0059a);
    }

    public static void a(Context context, C0059a c0059a) {
        NotificationChannel b6;
        String id;
        CharSequence name;
        int importance;
        Uri sound;
        NotificationChannel b7;
        String id2;
        CharSequence name2;
        if (b.c(context)) {
            Logger.d("ChannelHelper", "in silence push time,change defaults to 0");
            c0059a.f3979a = "";
            c0059a.f3984f = 0;
            c0059a.f3985g = null;
        } else if (Build.VERSION.SDK_INT >= 26 && (b6 = b(context, c0059a)) != null) {
            id = b6.getId();
            c0059a.f3979a = id;
            name = b6.getName();
            c0059a.f3980b = name;
            importance = b6.getImportance();
            c0059a.f3982d = importance;
            c0059a.f3981c = b(importance);
            sound = b6.getSound();
            c0059a.f3986h = sound;
            if (sound != null) {
                c0059a.f3985g = sound.getPath();
            }
            c0059a.f3987i = true;
            return;
        }
        int i6 = c0059a.f3981c;
        if (i6 == -2 || i6 == -1) {
            c0059a.f3984f = 0;
            c0059a.f3985g = null;
        } else if (i6 >= 0 && c0059a.f3984f == 0 && TextUtils.isEmpty(c0059a.f3985g)) {
            c0059a.f3981c = -1;
        }
        c0059a.f3984f &= 7;
        if (c0059a.f3981c == 2) {
            c0059a.f3981c = 1;
        }
        int a6 = a(c0059a.f3981c);
        c0059a.f3982d = a6;
        c0059a.f3981c = b(a6);
        Uri a7 = b.a(context, c0059a.f3985g);
        c0059a.f3986h = a7;
        if (a7 != null) {
            c0059a.f3984f &= -2;
        } else {
            c0059a.f3985g = null;
        }
        if (TextUtils.isEmpty(c0059a.f3979a)) {
            c0059a.f3979a = a(c0059a);
            if (Build.VERSION.SDK_INT >= 26 && (b7 = b(context, c0059a)) != null) {
                id2 = b7.getId();
                c0059a.f3979a = id2;
                name2 = b7.getName();
                c0059a.f3980b = name2;
                c0059a.f3987i = true;
                return;
            }
        }
        if (TextUtils.isEmpty(c0059a.f3980b)) {
            c0059a.f3980b = ("KG_channel_normal".equals(c0059a.f3979a) && "com.tencent.karaoke".equals(context.getPackageName())) ? "普通_K歌" : a(context, c0059a.f3981c);
        }
        Logger.d("ChannelHelper", "create channelId:" + c0059a.f3979a + ",channelName:" + ((Object) c0059a.f3980b) + ",soundUri:" + c0059a.f3986h + ",importance:" + c0059a.f3982d + ", hasImportance:" + c0059a.f3983e);
        c0059a.f3987i = a(context, c0059a.f3979a, c0059a.f3980b, c0059a.f3982d, c0059a.f3984f, c0059a.f3986h, c0059a.f3983e);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(26:11|12|13|14|(4:16|(1:18)|19|20)|22|23|24|25|(2:27|(16:29|30|31|(1:33)(1:63)|34|35|36|(1:38)(1:59)|39|40|41|42|(1:44)(2:49|(1:51)(1:52))|45|46|47))|65|30|31|(0)(0)|34|35|36|(0)(0)|39|40|41|42|(0)(0)|45|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0112, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x011d, code lost:
    
        cn.jpush.android.helper.Logger.ww("ChannelHelper", "setSound fail:" + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f6, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
    
        cn.jpush.android.helper.Logger.ww("ChannelHelper", "enableVibration fail:" + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d6, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d7, code lost:
    
        cn.jpush.android.helper.Logger.ww("ChannelHelper", "enableLights fail:" + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010e A[Catch: all -> 0x0112, TRY_ENTER, TryCatch #0 {all -> 0x0112, blocks: (B:44:0x010e, B:49:0x0114, B:52:0x0119), top: B:42:0x010c, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0114 A[Catch: all -> 0x0112, TryCatch #0 {all -> 0x0112, blocks: (B:44:0x010e, B:49:0x0114, B:52:0x0119), top: B:42:0x010c, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r6, java.lang.String r7, java.lang.CharSequence r8, int r9, int r10, android.net.Uri r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.x.a.a(android.content.Context, java.lang.String, java.lang.CharSequence, int, int, android.net.Uri, boolean):boolean");
    }
}
