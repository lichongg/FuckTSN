package com.bxkj.base.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.Button;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.base.BaseApp;
import com.bxkj.base.R;
import java.io.File;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class InstallUtil {

    /* renamed from: a, reason: collision with root package name */
    private Context f16551a;

    /* renamed from: b, reason: collision with root package name */
    private File f16552b;

    /* renamed from: c, reason: collision with root package name */
    private AlertDialog f16553c;

    /* renamed from: d, reason: collision with root package name */
    boolean f16554d = false;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class UpdateActivityObserver implements LifecycleObserver {
        /* synthetic */ UpdateActivityObserver(InstallUtil installUtil, r rVar) {
            this();
        }

        private UpdateActivityObserver() {
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            com.orhanobut.logger.j.c("UpdateApk->UpdateActivityObserver->");
            InstallUtil.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i6, Intent intent) {
        com.orhanobut.logger.j.c("UpdateApk->onActivityResult->");
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(DialogInterface dialogInterface, int i6) {
        boolean canRequestPackageInstalls;
        canRequestPackageInstalls = this.f16551a.getPackageManager().canRequestPackageInstalls();
        if (canRequestPackageInstalls) {
            g();
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f16551a.getPackageName()));
        intent.setFlags(268435456);
        Context context = this.f16551a;
        if (context instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            new u.b(fragmentActivity).startActivityForResult(intent).c(new b.a() { // from class: com.bxkj.base.util.p
                @Override // u.b.a
                public final void a(int i7, Intent intent2) {
                    InstallUtil.this.d(i7, intent2);
                }
            });
            fragmentActivity.getLifecycle().addObserver(new UpdateActivityObserver(this, null));
        }
    }

    private void f() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(this.f16552b), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        this.f16551a.startActivity(intent);
    }

    private void g() {
        if (this.f16554d) {
            return;
        }
        Uri uriForFile = FileProvider.getUriForFile(this.f16551a, this.f16551a.getPackageName() + ".provider", this.f16552b);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        this.f16551a.startActivity(intent);
        this.f16554d = true;
    }

    @RequiresApi(api = 26)
    private void h() {
        boolean canRequestPackageInstalls;
        int color;
        int color2;
        AlertDialog alertDialog = this.f16553c;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f16553c.dismiss();
        }
        canRequestPackageInstalls = this.f16551a.getPackageManager().canRequestPackageInstalls();
        com.orhanobut.logger.j.c("startInstallO->isGranted=" + canRequestPackageInstalls);
        g();
        if (canRequestPackageInstalls) {
            g();
            return;
        }
        AlertDialog show = new AlertDialog.Builder(this.f16551a).setCancelable(false).setTitle("安装应用需要打开未知来源权限，请去设置中开启权限").setPositiveButton("确定", new DialogInterface.OnClickListener() { // from class: com.bxkj.base.util.q
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                InstallUtil.this.e(dialogInterface, i6);
            }
        }).show();
        this.f16553c = show;
        Button button = show.getButton(-2);
        BaseApp c6 = BaseApp.c();
        int i6 = R.color.cardBlue;
        color = c6.getColor(i6);
        button.setTextColor(color);
        Button button2 = this.f16553c.getButton(-1);
        color2 = BaseApp.c().getColor(i6);
        button2.setTextColor(color2);
    }

    public void c() {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            g();
            return;
        }
        if (i6 >= 26) {
            h();
        } else if (i6 >= 24) {
            g();
        } else {
            f();
        }
    }

    public InstallUtil(Context context, File file) {
        this.f16551a = context;
        this.f16552b = file;
    }
}
