package com.ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.notification.xt;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static final String f38331b = "DownloadReceiver";

    /* renamed from: a, reason: collision with root package name */
    private Handler f38332a = new Handler(Looper.getMainLooper());

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Intent f38333a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f38334b;

        /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a, reason: collision with other inner class name */
        class RunnableC0768a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ cw f38336a;

            /* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver$a$a$a, reason: collision with other inner class name */
            class RunnableC0769a implements Runnable {
                RunnableC0769a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (RunnableC0768a.this.f38336a.ag()) {
                            m.xt(RunnableC0768a.this.f38336a);
                        }
                    } catch (Throwable th) {
                        vl.j(th);
                    }
                }
            }

            RunnableC0768a(cw cwVar) {
                this.f38336a = cwVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new RunnableC0769a());
            }
        }

        a(Intent intent, Context context) {
            this.f38333a = intent;
            this.f38334b = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Uri data = this.f38333a.getData();
            if (data == null) {
                return;
            }
            String schemeSpecificPart = data.getSchemeSpecificPart();
            x2.m d6 = f.L().d();
            if (d6 != null) {
                d6.j(this.f38334b, schemeSpecificPart);
            }
            List<cw> xt = ae.xt(this.f38334b).xt("application/vnd.android.package-archive");
            if (xt != null) {
                for (cw cwVar : xt) {
                    if (cwVar != null && com.ss.android.socialbase.appdownloader.b.E(cwVar, schemeSpecificPart)) {
                        com.ss.android.socialbase.downloader.r.h g6 = ae.xt(this.f38334b).g(cwVar.ae());
                        if (g6 != null && m.m(g6.j())) {
                            g6.j(9, cwVar, schemeSpecificPart, "");
                        }
                        com.ss.android.socialbase.downloader.notification.j up = xt.j().up(cwVar.ae());
                        if (up != null) {
                            up.j((com.ss.android.socialbase.downloader.up.j) null, false);
                        }
                        if (com.ss.android.socialbase.downloader.jy.j.j(cwVar.ae()).j("install_queue_enable", 0) == 1) {
                            g.f().i(cwVar, schemeSpecificPart);
                        }
                        DownloadReceiver.this.f38332a.postDelayed(new RunnableC0768a(cwVar), 1000L);
                        return;
                    }
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38339a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f38340b;

        b(Context context, String str) {
            this.f38339a = context;
            this.f38340b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent(this.f38339a, (Class<?>) DownloadHandlerService.class);
                intent.setAction(this.f38340b);
                this.f38339a.startService(intent);
            } catch (Throwable th) {
                vl.j(th);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (com.ss.android.socialbase.downloader.m.j.j()) {
                com.ss.android.socialbase.downloader.m.j.j(f38331b, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            b(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new a(intent, context));
        }
    }

    private void b(Context context, String str) {
        if (!com.ss.android.socialbase.downloader.downloader.cw.rn()) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.cw.j(new b(context, str), 2000L, TimeUnit.MILLISECONDS);
    }
}
