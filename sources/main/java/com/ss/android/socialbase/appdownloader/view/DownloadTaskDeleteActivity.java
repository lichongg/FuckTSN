package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import com.ss.android.socialbase.appdownloader.f;
import com.ss.android.socialbase.downloader.ae.cw;
import com.ss.android.socialbase.downloader.az.m;
import com.ss.android.socialbase.downloader.downloader.ae;
import com.ss.android.socialbase.downloader.jy.j;
import com.ss.android.socialbase.downloader.r.h;
import com.stub.StubApp;
import x2.g;
import x2.k;
import x2.n;

/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private n f38552a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f38553b;

    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f38555a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cw f38556b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38557c;

        b(boolean z5, cw cwVar, int i6) {
            this.f38555a = z5;
            this.f38556b = cwVar;
            this.f38557c = i6;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            if (this.f38555a) {
                DownloadTaskDeleteActivity.this.c(this.f38556b, this.f38557c);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f38559a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cw f38560b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f38561c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ae.xt(DownloadTaskDeleteActivity.this).cw(c.this.f38560b.ae());
            }
        }

        c(boolean z5, cw cwVar, int i6) {
            this.f38559a = z5;
            this.f38560b = cwVar;
            this.f38561c = i6;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i6) {
            if (this.f38559a) {
                this.f38560b.r(true);
                ae.xt(DownloadTaskDeleteActivity.this).j(this.f38560b.ae());
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 100L);
            } else {
                DownloadTaskDeleteActivity.this.c(this.f38560b, this.f38561c);
            }
            DownloadTaskDeleteActivity.this.finish();
        }
    }

    static {
        StubApp.interface11(41489);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void d() {
        Intent intent;
        if (this.f38552a != null || (intent = this.f38553b) == null) {
            return;
        }
        try {
            boolean z5 = false;
            int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            cw tl = ae.xt(StubApp.getOrigApplicationContext(getApplicationContext())).tl(intExtra);
            if (tl == null) {
                return;
            }
            String g6 = tl.g();
            if (TextUtils.isEmpty(g6)) {
                vl.xt("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_notification_download_delete")), g6);
            k X = f.L().X();
            g j6 = X != null ? X.j(this) : null;
            if (j6 == null) {
                j6 = new f.g(this);
            }
            int b6 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_tip");
            int b7 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_ok");
            int b8 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_cancel");
            if (j.j(tl.ae()).j("cancel_with_net_opt", 0) == 1 && m.tl() && tl.uq() != tl.ka()) {
                z5 = true;
            }
            if (z5) {
                b7 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_reserve_wifi");
                b8 = com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(com.ss.android.socialbase.appdownloader.c.b(this, "tt_appdownloader_resume_in_wifi"));
            }
            j6.j(b6).j(format).b(b7, new c(z5, tl, intExtra)).a(b8, new b(z5, tl, intExtra)).c(new a());
            this.f38552a = j6.j();
        } catch (Exception e6) {
            vl.j(e6);
        }
    }

    private void a() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(cw cwVar, int i6) {
        x2.m d6 = f.L().d();
        if (d6 != null) {
            d6.j(cwVar);
        }
        h g6 = ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).g(i6);
        if (g6 != null) {
            g6.j(10, cwVar, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.cw.nd() != null) {
            ae.xt(com.ss.android.socialbase.downloader.downloader.cw.nd()).xt(i6);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f38553b = getIntent();
        d();
        n nVar = this.f38552a;
        if (nVar != null && !nVar.xt()) {
            this.f38552a.j();
        } else if (this.f38552a == null) {
            finish();
        }
    }
}
