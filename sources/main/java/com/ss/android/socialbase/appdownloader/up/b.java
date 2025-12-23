package com.ss.android.socialbase.appdownloader.up;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.appdownloader.i;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.notification.j;
import com.stub.StubApp;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes6.dex */
public class b extends j {

    /* renamed from: a, reason: collision with root package name */
    private final Context f38532a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources f38533b;

    /* renamed from: c, reason: collision with root package name */
    private String f38534c;

    /* renamed from: d, reason: collision with root package name */
    private String f38535d;

    /* renamed from: e, reason: collision with root package name */
    private String f38536e;

    private boolean f(com.ss.android.socialbase.downloader.up.j jVar, com.ss.android.socialbase.downloader.jy.j jVar2, cw cwVar) {
        return jVar != null && (jVar.j() == 1013 || jVar.j() == 1049) && cwVar != null && "application/vnd.android.package-archive".contains(cwVar.xw()) && jVar2.j("notification_text_opt", 0) == 1;
    }

    @Override // com.ss.android.socialbase.downloader.notification.j
    public void j(cw cwVar) {
        super.j(cwVar);
        this.f38535d = cwVar.qv();
        this.f38534c = cwVar.tl();
        this.f38536e = cwVar.h();
    }

    private Notification d(x2.d dVar, com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        int i6;
        com.ss.android.socialbase.downloader.up.j jVar2;
        boolean z6;
        int up = up();
        int f6 = com.ss.android.socialbase.appdownloader.b.f(up);
        if (f6 == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("click_type", Integer.valueOf(f6));
        int j6 = j();
        hashMap.put("click_download_id", Integer.valueOf(j6));
        com.ss.android.socialbase.downloader.jy.j j7 = com.ss.android.socialbase.downloader.jy.j.j(j6);
        long xt = xt();
        long cw = cw();
        int i7 = cw > 0 ? (int) ((100 * xt) / cw) : 0;
        String r5 = r();
        int xt2 = j7.xt("notification_opt_2");
        hashMap.put("notification_opt_2", Integer.valueOf(xt2));
        if (xt2 != 1) {
            hashMap.put("action_click_btn", "android.ss.intent.action.DOWNLOAD_CLICK_BTN");
        }
        int xt3 = j7.xt("enable_notification_ui");
        hashMap.put("enable_notification_ui", Integer.valueOf(xt3));
        hashMap.put("show_title", r5);
        hashMap.put("percent", Integer.valueOf(i7));
        hashMap.put("indeterminate", Boolean.valueOf(z5));
        hashMap.put("notification_type", Integer.valueOf(f6));
        String K = f.L().K();
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 26 && TextUtils.isEmpty(K)) {
            K = com.ss.android.socialbase.appdownloader.b.N(this.f38532a);
        }
        hashMap.put("channel_id", K);
        hashMap.put("download_status", Integer.valueOf(up));
        hashMap.put("first_time", Long.valueOf(m()));
        if (i8 >= 24 && j7.j("set_notification_group", 0) == 1) {
            hashMap.put("notification_group", "com.ss.android.socialbase.APP_DOWNLOADER");
        }
        hashMap.put("csj_enable_target_34", Boolean.valueOf(i8 >= 31 && com.ss.android.socialbase.downloader.jy.j.j(j6).xt("enable_target_34") > 0));
        if (xt3 > 0) {
            hashMap.put("bitmap", a.d().b(j6));
        }
        if (f6 == 1 || f6 == 4) {
            hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.o(xt) + "/" + com.ss.android.socialbase.appdownloader.b.o(cw));
            i6 = f6;
            if (i6 == 1) {
                hashMap.put("download_status", Integer.valueOf(up()));
            }
            hashMap.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.b.F(this.f38536e)));
        } else if (f6 == 2) {
            hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.o(xt) + "/" + com.ss.android.socialbase.appdownloader.b.o(cw));
            if (xt2 == 1) {
                hashMap.put("progress_70", Integer.valueOf(j7.j("noti_progress_show_th", 70)));
            }
            hashMap.put("is_bind_app", Boolean.valueOf(com.ss.android.socialbase.appdownloader.b.F(this.f38536e)));
            if (!com.ss.android.socialbase.appdownloader.b.F(this.f38536e) && xt3 >= 2) {
                hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.r(xt, false) + "/" + com.ss.android.socialbase.appdownloader.b.r(cw, false));
            }
            i6 = f6;
        } else if (f6 == 3) {
            cw tl = ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).tl(j6);
            int up2 = up();
            hashMap.put("download_status", Integer.valueOf(up2));
            if (up2 == -1 || up2 == -4) {
                boolean g6 = m.g(jVar);
                boolean tl2 = m.tl(jVar);
                hashMap.put("is_network_error", Boolean.valueOf(g6));
                hashMap.put("is_insufficient_space_error", Boolean.valueOf(tl2));
                if (xt3 >= 2 && up2 == -1 && (g6 || tl2)) {
                    hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.o(xt) + "/" + com.ss.android.socialbase.appdownloader.b.o(cw));
                }
                if (jVar == null || jVar.j() != 1006) {
                    jVar2 = jVar;
                    if (f(jVar2, j7, tl)) {
                        z6 = g6;
                        hashMap.put("is_need_show_wait_net_text", Boolean.TRUE);
                        hashMap.put("is_wait_wifi", Boolean.valueOf(tl != null && tl.x()));
                        if (xt3 >= 2 && up2 == -1 && z6) {
                            hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(m.xt(jVar2, tl)));
                        }
                    }
                } else {
                    hashMap.put("is_error_code_insufficient_space_error", Boolean.TRUE);
                    jVar2 = jVar;
                }
                z6 = g6;
                if (xt3 >= 2) {
                    hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(m.xt(jVar2, tl)));
                }
            } else {
                if (up2 == -3) {
                    hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.o(cw));
                    hashMap.put("is_mime_apk", Boolean.valueOf((tl == null || TextUtils.isEmpty(tl.xw()) || !tl.xw().equals("application/vnd.android.package-archive")) ? false : true));
                    hashMap.put("is_apk_installed", Boolean.valueOf(com.ss.android.socialbase.appdownloader.b.D(this.f38532a, tl, false)));
                    hashMap.put("is_have_notification_click_callback", Boolean.valueOf(r.j().vl(j6) != null));
                }
                jVar2 = jVar;
            }
            boolean g7 = m.g(jVar2);
            boolean tl3 = m.tl(jVar2);
            hashMap.put("is_network_error", Boolean.valueOf(g7));
            hashMap.put("is_insufficient_space_error", Boolean.valueOf(tl3));
            if (xt3 >= 2 && up2 == -1) {
                if (g7 || tl3) {
                    boolean xt4 = m.xt(jVar2, tl);
                    hashMap.put("is_wait_wifi_and_in_net", Boolean.valueOf(xt4));
                    if (xt4) {
                        hashMap.put("download_size", com.ss.android.socialbase.appdownloader.b.r(xt, false) + "/" + com.ss.android.socialbase.appdownloader.b.r(cw, false));
                        i6 = f6;
                    }
                } else {
                    i6 = f6;
                }
            }
            i6 = f6;
        } else {
            i6 = f6;
        }
        String str = "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT";
        if (i6 == 1 || i6 == 4 || i6 == 2) {
            hashMap.put("action_apa", "android.ss.intent.action.DOWNLOAD_CLICK_CONTENT");
        } else if (i6 == 3) {
            if (up != -1 && up != -4) {
                if (up == -3) {
                    hashMap.put("auto_cancel", Boolean.valueOf(j7.j("notification_click_install_auto_cancel", 1) == 0));
                }
                str = "android.ss.intent.action.DOWNLOAD_OPEN";
            }
            hashMap.put("action_complete", str);
            hashMap.put("action_hide", "android.ss.intent.action.DOWNLOAD_HIDE");
        }
        Notification notification = (Notification) dVar.j(hashMap).get("notification");
        this.f38895j = notification;
        return notification;
    }

    private PendingIntent e(String str, int i6, int i7) {
        Pair<Intent, Boolean> T = f.T(this.f38532a, i7);
        Intent intent = (Intent) T.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i7);
        intent.putExtra("extra_click_download_type", i6);
        intent.putExtra("extra_from_notification", true);
        return f.i(this.f38532a, T, i7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0237  */
    /* JADX WARN: Type inference failed for: r13v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification h(com.ss.android.socialbase.downloader.up.j r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 1423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.up.b.h(com.ss.android.socialbase.downloader.up.j, boolean):android.app.Notification");
    }

    public b(Context context, int i6, String str, String str2, String str3, String str4) {
        super(i6, str);
        this.f38535d = str2;
        this.f38534c = str3;
        this.f38536e = str4;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f38532a = origApplicationContext;
        this.f38533b = origApplicationContext.getResources();
    }

    private RemoteViews a() {
        RemoteViews remoteViews = new RemoteViews(this.f38532a.getPackageName(), i.h());
        try {
            if (com.ss.android.socialbase.appdownloader.b.x(this.f38532a)) {
                remoteViews.setInt(i.k(), "setBackgroundColor", this.f38532a.getResources().getColor(i.u()));
            }
        } catch (Throwable unused) {
        }
        return remoteViews;
    }

    private int b(int i6) {
        if (com.ss.android.socialbase.downloader.jy.j.j(i6).xt("enable_notification_ui") > 0) {
            return i.q();
        }
        return i.a();
    }

    private int c(int i6, int i7) {
        if (com.ss.android.socialbase.downloader.jy.j.j(i7).xt("notification_opt_2") == 1) {
            return i.e();
        }
        if (i6 != 1 && i6 != 4) {
            if (i6 == 2) {
                return i.p();
            }
            if (i6 == 3) {
                return i.e();
            }
            return 0;
        }
        return i.j();
    }

    private NotificationCompat.Builder g() {
        String K = f.L().K();
        if (Build.VERSION.SDK_INT < 26) {
            return new NotificationCompat.Builder(this.f38532a);
        }
        if (TextUtils.isEmpty(K)) {
            K = com.ss.android.socialbase.appdownloader.b.N(this.f38532a);
        }
        try {
            if (f.L().S() != null) {
                return f.L().S().j(this.f38532a, K);
            }
            return new NotificationCompat.Builder(this.f38532a, K);
        } catch (NoSuchMethodError unused) {
            return new NotificationCompat.Builder(this.f38532a);
        }
    }

    @Override // com.ss.android.socialbase.downloader.notification.j
    public void j(com.ss.android.socialbase.downloader.up.j jVar, boolean z5) {
        if (this.f38532a == null) {
            return;
        }
        try {
            x2.d p5 = f.L().p();
            if (p5 != null) {
                this.f38895j = d(p5, jVar, z5);
            } else {
                this.f38895j = h(jVar, z5);
            }
            j(this.f38895j);
        } catch (Exception e6) {
            vl.j(e6);
        }
    }
}
