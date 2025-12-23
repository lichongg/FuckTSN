package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.jy.j;
import com.ss.android.socialbase.downloader.r.h;
import java.io.File;
import x2.m;

/* loaded from: D:\Downloads\app\classes6.dex */
public class f {

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f38498a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cw f38499b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38500c;

        a(Context context, cw cwVar, int i6) {
            this.f38498a = context;
            this.f38499b = cwVar;
            this.f38500c = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            m d6 = com.ss.android.socialbase.appdownloader.f.L().d();
            h g6 = ae.xt(this.f38498a).g(this.f38499b.ae());
            if (d6 != null || g6 != null) {
                File file = new File(this.f38499b.qv(), this.f38499b.tl());
                if (file.exists()) {
                    try {
                        PackageInfo m6 = com.ss.android.socialbase.appdownloader.b.m(this.f38499b, file);
                        if (m6 != null) {
                            if (this.f38500c != 1 && !TextUtils.isEmpty(this.f38499b.la())) {
                                str = this.f38499b.la();
                            } else {
                                str = m6.packageName;
                            }
                            String str2 = str;
                            if (d6 != null) {
                                d6.b(this.f38499b.ae(), 1, str2, -3, this.f38499b.hu());
                            }
                            if (g6 != null) {
                                g6.j(1, this.f38499b, str2, "");
                            }
                        }
                    } catch (Exception e6) {
                        vl.j(e6);
                    }
                }
            }
        }
    }

    public static void a(cw cwVar) {
        b(cwVar);
    }

    private static void b(cw cwVar) {
        int h6;
        Context nd = com.ss.android.socialbase.downloader.downloader.cw.nd();
        if (((cwVar.tj() && !cwVar.f()) || com.ss.android.socialbase.appdownloader.b.Q(cwVar.h()) || TextUtils.isEmpty(cwVar.xw()) || !cwVar.xw().equals("application/vnd.android.package-archive")) && j.j(cwVar.ae()).j("auto_install_when_resume", 0) != 1) {
            h6 = 2;
        } else {
            h6 = com.ss.android.socialbase.appdownloader.b.h(nd, cwVar.ae(), false);
        }
        com.ss.android.socialbase.downloader.downloader.cw.qv().execute(new a(nd, cwVar, h6));
    }
}
