package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.downloader.cw;
import com.ss.android.socialbase.downloader.downloader.r;
import com.ss.android.socialbase.downloader.notification.xt;
import com.ss.android.socialbase.downloader.r.wq;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import x2.m;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: a, reason: collision with root package name */
    private static final String f38326a = "DownloadHandlerService";

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add("application/vnd.android.package-archive");
                arrayList.add("mime_type_plg");
                ae.xt(cw.nd()).j(arrayList);
            } catch (Exception e6) {
                vl.j(e6);
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.ae.cw f38328a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f38329b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.ss.android.socialbase.downloader.r.h f38330c;

        b(com.ss.android.socialbase.downloader.ae.cw cwVar, m mVar, com.ss.android.socialbase.downloader.r.h hVar) {
            this.f38328a = cwVar;
            this.f38329b = mVar;
            this.f38330c = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PackageInfo m6;
            try {
                File file = new File(this.f38328a.qv(), this.f38328a.tl());
                if (file.exists()) {
                    try {
                        String str = (cw.nd() == null || (m6 = com.ss.android.socialbase.appdownloader.b.m(this.f38328a, file)) == null) ? "" : m6.packageName;
                        m mVar = this.f38329b;
                        if (mVar != null) {
                            mVar.b(this.f38328a.ae(), 3, str, -3, this.f38328a.hu());
                        }
                        com.ss.android.socialbase.downloader.r.h hVar = this.f38330c;
                        if (hVar != null) {
                            hVar.j(3, this.f38328a, str, "");
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                }
            } catch (Exception e7) {
                vl.j(e7);
            }
        }
    }

    static {
        StubApp.interface11(41401);
    }

    private static void b(Context context, int i6, boolean z5) {
        boolean z6;
        wq vl;
        com.ss.android.socialbase.downloader.ae.cw tl;
        if (z5 && (vl = r.j().vl(i6)) != null) {
            try {
                tl = ae.xt(context).tl(i6);
            } catch (Throwable th) {
                vl.j(th);
            }
            if (tl != null) {
                z6 = vl.xt(tl);
                if (z6 && com.ss.android.socialbase.appdownloader.b.h(context, i6, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z6 = false;
        if (z6) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    private boolean f(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        m d6 = f.L().d();
        com.ss.android.socialbase.downloader.r.h g6 = ae.xt(this).g(intExtra);
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.jy.j.j(intExtra).xt("notification_opt_2") == 1) {
            xt.j().m(intExtra);
        }
        com.ss.android.socialbase.downloader.ae.cw tl = ae.xt(context).tl(intExtra);
        if (tl == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            g(context, tl, d6, g6);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            d(context, tl, d6, g6);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (tl.i() == 0) {
                return false;
            }
            d(context, tl, d6, g6);
            if (tl.hw() && com.ss.android.socialbase.downloader.jy.j.j(intExtra).j("no_hide_notification", 0) == 0 && (com.ss.android.socialbase.downloader.jy.j.j(intExtra).xt("enable_notification_ui") < 2 || tl.i() != -1)) {
                xt.j().j(intExtra);
                xt.j().m(intExtra);
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            a(context, tl, d6, g6);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            xt.j().j(intExtra);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            cw.qv().execute(new a());
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    private static void e(Context context, m mVar, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (cwVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.r.h g6 = ae.xt(context).g(cwVar.ae());
        if (mVar == null && g6 == null) {
            return;
        }
        cw.qv().execute(new b(cwVar, mVar, g6));
    }

    private void a(Context context, com.ss.android.socialbase.downloader.ae.cw cwVar, m mVar, com.ss.android.socialbase.downloader.r.h hVar) {
        int ae = cwVar.ae();
        Intent intent = new Intent(context, (Class<?>) DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", ae);
        intent.addFlags(268435456);
        context.startActivity(intent);
        xt.j().j(ae);
        cwVar.pz();
        if (mVar != null) {
            mVar.b(ae, 7, "", cwVar.i(), cwVar.hu());
        }
        if (hVar != null) {
            hVar.j(7, cwVar, "", "");
        }
    }

    private static void c(Context context, com.ss.android.socialbase.downloader.ae.cw cwVar) {
        if (com.ss.android.socialbase.downloader.az.m.xt(StubApp.getOrigApplicationContext(context.getApplicationContext())) && cwVar.qb()) {
            cwVar.k();
        }
    }

    public static void d(Context context, com.ss.android.socialbase.downloader.ae.cw cwVar, m mVar, com.ss.android.socialbase.downloader.r.h hVar) {
        com.ss.android.socialbase.downloader.notification.j up;
        int ae = cwVar.ae();
        wq vl = r.j().vl(ae);
        if ("application/vnd.android.package-archive".equals(cwVar.xw()) && vl != null && com.ss.android.socialbase.appdownloader.b.z(context, cwVar) && vl.cw(cwVar)) {
            return;
        }
        switch (cwVar.i()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.jy.j.j(ae).xt("enable_notification_ui") >= 2 && cwVar.x()) {
                    cwVar.r(false);
                }
                ae.xt(context).up(ae);
                break;
            case -3:
                b(cw.nd(), ae, true);
                e(context, mVar, cwVar);
                if (com.ss.android.socialbase.downloader.jy.j.j(ae).j("notification_click_install_auto_cancel", 1) == 0 && (up = xt.j().up(ae)) != null) {
                    up.ae();
                    up.j(-3, null, false, true);
                    break;
                } else {
                    xt.j().j(ae);
                    break;
                }
                break;
            case -2:
                if (r.j().up(ae)) {
                    ae.xt(context).cw(ae);
                } else {
                    com.ss.android.socialbase.appdownloader.b.w(cwVar, true, false);
                }
                if (mVar != null) {
                    mVar.b(ae, 6, "", cwVar.i(), cwVar.hu());
                }
                if (hVar != null) {
                    hVar.j(6, cwVar, "", "");
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                ae.xt(context).j(ae);
                c(context, cwVar);
                if (mVar != null) {
                    mVar.b(ae, 5, "", cwVar.i(), cwVar.hu());
                }
                if (hVar != null) {
                    hVar.j(5, cwVar, "", "");
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(android.content.Context r9, com.ss.android.socialbase.downloader.ae.cw r10, x2.m r11, com.ss.android.socialbase.downloader.r.h r12) {
        /*
            r8 = this;
            int r2 = r10.ae()
            com.ss.android.socialbase.downloader.downloader.r r0 = com.ss.android.socialbase.downloader.downloader.r.j()
            com.ss.android.socialbase.downloader.r.wq r0 = r0.vl(r2)
            if (r0 == 0) goto L17
            boolean r0 = r0.j(r10)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r0)
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r1 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r9, r1)
            java.lang.String r1 = "extra_click_download_ids"
            r0.putExtra(r1, r2)
            r1 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r1)
            r9.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.xt r9 = com.ss.android.socialbase.downloader.notification.xt.j()
            r9.j(r2)
            r10.pz()
            if (r11 == 0) goto L49
            int r5 = r10.i()
            long r6 = r10.hu()
            r3 = 7
            java.lang.String r4 = ""
            r1 = r11
            r1.b(r2, r3, r4, r5, r6)
        L49:
            if (r12 == 0) goto L51
            r9 = 7
            java.lang.String r11 = ""
            r12.j(r9, r10, r11, r11)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.g(android.content.Context, com.ss.android.socialbase.downloader.ae.cw, x2.m, com.ss.android.socialbase.downloader.r.h):void");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        cw.j(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        super.onStartCommand(intent, i6, i7);
        if (com.ss.android.socialbase.downloader.m.j.j()) {
            com.ss.android.socialbase.downloader.m.j.xt(f38326a, "onStartCommand");
        }
        f(cw.nd(), intent);
        stopSelf();
        return 2;
    }
}
