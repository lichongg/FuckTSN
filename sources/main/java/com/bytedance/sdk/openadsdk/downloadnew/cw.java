package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import cn.jiguang.bz.c0;
import cn.jpush.android.f.g;
import com.bykv.j.j.j.j.f;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* loaded from: D:\Downloads\app\classes4.dex */
public final class cw implements Function<SparseArray<Object>, Object> {

    /* renamed from: j, reason: collision with root package name */
    private static volatile cw f31372j;
    private Function<SparseArray<Object>, Object> cw;
    private final Context xt;

    public static cw j() {
        return f31372j;
    }

    private Map<String, Object> xt(Map<String, Object> map) {
        String concat;
        String str;
        String str2;
        Icon createWithBitmap;
        String str3;
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int intValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int intValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean booleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.xt.getPackageName(), this.xt.getResources().getIdentifier("tt_install_notification_layout", ResIdentify.RES_TYPE_LAYOUT, this.xt.getPackageName()));
        int jy = j.jy();
        int vl = j.vl();
        int ws = j.ws();
        int i6 = intValue2;
        int az = j.az();
        int av = j.av();
        if (intValue == 1) {
            concat = "打开".concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            concat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = concat;
        String str12 = str2;
        remoteViews.setTextViewText(vl, str10);
        remoteViews.setTextViewText(ws, str11);
        remoteViews.setTextViewText(az, str12);
        int ch = j.ch();
        if (ch == 0) {
            ch = j.x();
        }
        int i7 = ch;
        createWithBitmap = Icon.createWithBitmap(bitmap);
        remoteViews.setImageViewIcon(jy, createWithBitmap);
        PendingIntent j6 = j(str5, intValue, i6, booleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(av, j6);
        remoteViews.setOnClickPendingIntent(az, j6);
        String str13 = "csj_" + this.xt.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                g.a();
                NotificationChannel a6 = c0.a(str13, "csj_install", 4);
                a6.setShowBadge(true);
                a6.setBypassDnd(true);
                str3 = "notification";
                try {
                    ((NotificationManager) this.xt.getSystemService(str3)).createNotificationChannel(a6);
                } catch (Throwable th) {
                    th = th;
                    m.j(th);
                    NotificationCompat.Builder j7 = j(str13);
                    j7.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(j6).setSmallIcon(i7).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
                    Notification build = j7.build();
                    build.contentView = remoteViews;
                    hashMap.put(str3, build);
                    return hashMap;
                }
            } else {
                str3 = "notification";
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "notification";
        }
        NotificationCompat.Builder j72 = j(str13);
        j72.setStyle(new NotificationCompat.DecoratedCustomViewStyle()).setContentIntent(j6).setSmallIcon(i7).setContentTitle(str10).setContentText(str11).setPriority(1).setDefaults(-1).setVisibility(1).setAutoCancel(true);
        Notification build2 = j72.build();
        build2.contentView = remoteViews;
        hashMap.put(str3, build2);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04fb  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Map<java.lang.String, java.lang.Object> cw(java.util.Map<java.lang.String, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 1362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.cw.cw(java.util.Map):java.util.Map");
    }

    public static cw j(Context context) {
        if (f31372j == null) {
            synchronized (cw.class) {
                try {
                    if (f31372j == null) {
                        f31372j = new cw(context);
                    }
                } finally {
                }
            }
        }
        return f31372j;
    }

    private cw(Context context) {
        this.xt = context;
    }

    public <T> T j(Class<T> cls, int i6, Map<String, Object> map) {
        Object apply;
        m.xt("xgc_dl", "api:".concat(String.valueOf(i6)));
        if (i6 == 0) {
            if (this.cw != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, 0);
                sparseArray.put(0, map);
                apply = this.cw.apply(sparseArray);
                return (T) apply;
            }
            return (T) Boolean.FALSE;
        }
        if (i6 == 159) {
            if (map != null) {
                Object obj = map.get("n");
                if (f.a(obj)) {
                    this.cw = a1.b.a(obj);
                }
            }
            return null;
        }
        if (i6 == 161) {
            return (T) xt(map);
        }
        if (i6 == 155) {
            return (T) j((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
        }
        if (i6 != 156) {
            return null;
        }
        return (T) j(map);
    }

    protected void j(Map<String, Object> map, int i6) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, Integer.valueOf(i6));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.cw;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private NotificationCompat.Builder j(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.xt);
        }
        try {
            return new NotificationCompat.Builder(this.xt, str);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.xt);
        }
    }

    private Map<String, Object> j(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> cw = cw(map2);
        Object obj = cw.get("remote_views");
        Object obj2 = cw.get("builder_content_type");
        int intValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int intValue2 = ((Integer) map2.get("download_status")).intValue();
        NotificationCompat.Builder j6 = j(str);
        j6.setWhen(((Long) map2.get("first_time")).longValue());
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            j6.setGroup((String) obj3);
            j6.setGroupSummary(false);
        }
        j6.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        if (intValue == 1 || intValue == 4 || intValue == 2) {
            j6.setContentIntent((PendingIntent) cw.get("apa_click_content_intent"));
            j6.setAutoCancel(false);
        } else if (intValue == 3) {
            j6.setAutoCancel(true);
            if (intValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    j6.setAutoCancel(false);
                }
            }
            j6.setContentIntent((PendingIntent) cw.get("complete_click_content_intent"));
            j6.setDeleteIntent((PendingIntent) cw.get("hide_click_content_intent"));
        }
        if (intValue == 3 && intValue2 == -3 && (obj2 instanceof String)) {
            j6.setContentText((String) obj2);
        }
        Object obj5 = cw.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            j6.setSmallIcon(((Integer) obj5).intValue());
        }
        Notification build = j6.build();
        build.contentView = (RemoteViews) obj;
        cw.put("notification", build);
        return cw;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean xt(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "#7f0b0198"
            int r1 = android.graphics.Color.parseColor(r1)     // Catch: java.lang.Throwable -> L2f
            int r2 = com.bytedance.sdk.openadsdk.downloadnew.j.j()     // Catch: java.lang.Throwable -> L2f
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.j.xt()     // Catch: java.lang.Throwable -> L2f
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L2f
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.j.cw()     // Catch: java.lang.Throwable -> L2f
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L2f
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L2d
            if (r1 != r2) goto L29
            r4.recycle()     // Catch: java.lang.Throwable -> L27
        L27:
            r4 = 1
            return r4
        L29:
            r4.recycle()     // Catch: java.lang.Throwable -> L33
            goto L33
        L2d:
            goto L30
        L2f:
            r4 = 0
        L30:
            if (r4 == 0) goto L33
            goto L29
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.cw.xt(android.content.Context):boolean");
    }

    private boolean xt(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private Pair<Intent, Boolean> j(Context context, long j6, boolean z5) {
        if (z5) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent j(String str, int i6, int i7, boolean z5, String str2) {
        Pair<Intent, Boolean> j6 = j(this.xt, i7, z5);
        Intent intent = (Intent) j6.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i7);
        intent.putExtra("extra_click_download_type", i6);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return j(this.xt, j6, i7);
    }

    private PendingIntent j(String str, int i6, int i7, boolean z5, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> j6 = j(this.xt, i7, z5);
        Intent intent = (Intent) j6.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i7);
        intent.putExtra("extra_click_download_type", i6);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return j(this.xt, j6, i7);
    }

    private PendingIntent j(Context context, Pair<Intent, Boolean> pair, int i6) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i6, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i6, (Intent) pair.first, 201326592);
    }

    private boolean j(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private int j(int i6, boolean z5) {
        if (z5) {
            return j.x();
        }
        if (i6 == 1 || i6 == 4) {
            return j.f();
        }
        if (i6 == 2) {
            return j.v();
        }
        if (i6 == 3) {
            return j.x();
        }
        return 0;
    }

    public Uri j(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.xt, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Map<String, Object> hashMap;
        if (sparseArray == null) {
            return null;
        }
        ValueSet k6 = com.bykv.j.j.j.j.a.j(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        Class cls = (Class) k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return com.bykv.j.j.j.j.a.a().e(10000, 3).k().sparseArray();
        }
        if (k6.objectValue(0, Map.class) != null) {
            hashMap = (Map) k6.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return j(cls, intValue, hashMap);
    }
}
