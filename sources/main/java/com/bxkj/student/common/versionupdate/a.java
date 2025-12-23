package com.bxkj.student.common.versionupdate;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import androidx.core.content.FileProvider;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.InstallUtil;
import com.bxkj.student.common.download.a;
import com.orhanobut.logger.j;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import rx.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x.f;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f17834a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.bxkj.student.common.versionupdate.a$a, reason: collision with other inner class name */
    class C0204a extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f17835a;

        C0204a(final d val$versionUpdateListener) {
            this.f17835a = val$versionUpdateListener;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i6 = JsonParse.getInt(data, "versions");
            String string = JsonParse.getString(data, "versionsName");
            String string2 = JsonParse.getString(data, "instruction");
            String string3 = JsonParse.getString(data, "filePath");
            c0.b bVar = c0.b.f1042a;
            if (i6 > bVar.m(a.this.f17834a)) {
                d dVar = this.f17835a;
                if (dVar != null) {
                    dVar.a(true, string, string3, string2);
                    return;
                }
                return;
            }
            d dVar2 = this.f17835a;
            if (dVar2 != null) {
                dVar2.a(false, bVar.n(a.this.f17834a), string3, string2);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            ex.printStackTrace();
            d dVar = this.f17835a;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            d dVar = this.f17835a;
            if (dVar != null) {
                dVar.a(false, c0.b.f1042a.n(a.this.f17834a), "", "");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17837a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17838b;

        b(final String val$downLoadUrl, final String val$versionName) {
            this.f17837a = val$downLoadUrl;
            this.f17838b = val$versionName;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            a.this.c(this.f17837a, BaseApp.c().getString(2131951695) + "_" + this.f17838b + ".apk");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements a.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProgressDialog f17840a;

        public int d(long bt) {
            return Math.round(Math.round((bt / 1048576) * 100.0f) / 100.0f);
        }

        public String e(long size) {
            if (size >= IjkMediaMeta.AV_CH_STEREO_RIGHT) {
                return String.format("%.1f GB", Float.valueOf(size / IjkMediaMeta.AV_CH_STEREO_RIGHT));
            }
            if (size >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                float f6 = size / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                return String.format(f6 > 100.0f ? "%.0f MB" : "%.1f MB", Float.valueOf(f6));
            }
            if (size < 1024) {
                return String.format("%d B", Long.valueOf(size));
            }
            float f7 = size / 1024;
            return String.format(f7 > 100.0f ? "%.0f KB" : "%.1f KB", Float.valueOf(f7));
        }

        c(final ProgressDialog val$progressDialog) {
            this.f17840a = val$progressDialog;
        }

        private int c(long bt) {
            return Math.round(bt / 1024);
        }

        private void f(File apkFile) {
            Uri fromFile;
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                new ProcessBuilder("chmod", "777", apkFile.toString()).start();
            } catch (IOException unused) {
            }
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(a.this.f17834a, "com.bxkj.student.provider", apkFile);
                intent.addFlags(1);
            } else {
                fromFile = Uri.fromFile(apkFile);
            }
            j.c("uri.getPath()=" + fromFile.getPath());
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            intent.addFlags(268435456);
            a.this.f17834a.startActivity(intent);
            cn.bluemobi.dylan.base.utils.a.n().j();
        }

        private void g(File file) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            a.this.f17834a.startActivity(intent);
        }

        @Override // com.bxkj.student.common.download.a.d
        public void a(final File file) {
            j.c("下载完成");
            this.f17840a.dismiss();
            new InstallUtil(a.this.f17834a, file).c();
        }

        @Override // com.bxkj.student.common.download.a.d
        public void b(final long totalSize, final long bytesWritten, final int progress) {
            this.f17840a.show();
            this.f17840a.setProgressNumberFormat("%1d M/%2d M");
            this.f17840a.setMax(d(totalSize));
            this.f17840a.setProgress(d(bytesWritten));
        }

        @Override // com.bxkj.student.common.download.a.d
        public void onDownloadFailed() {
            j.c("下载失败");
            this.f17840a.dismiss();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://sj.qq.com/myapp/detail.htm?apkName=com.bxkj.student"));
            a.this.f17834a.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface d {
        void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction);

        void b();
    }

    public m b(final d versionUpdateListener) {
        return Http.with(this.f17834a).setCanCancel(false).setObservable(((f) Http.getApiService(f.class)).a(LoginUser.getLoginUser().getSchoolId(), c0.b.f1042a.f(this.f17834a))).setDataListener(new C0204a(versionUpdateListener));
    }

    public void c(String downLoadUrl, String fileName) {
        ProgressDialog progressDialog = new ProgressDialog(this.f17834a);
        progressDialog.setTitle("正在下载...");
        progressDialog.setProgressStyle(1);
        progressDialog.setIndeterminate(false);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);
        com.bxkj.student.common.download.a.f().e(downLoadUrl, fileName, new c(progressDialog));
    }

    public Dialog d(String versionName, final String downLoadUrl, String instruction) {
        iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(this.f17834a).setTitle("提示").setMessage("检测到新版本" + versionName + "请升级\n" + instruction).setOneButtonText("升级").setMessageGrivity(3).setButtonOnClickListener(new b(downLoadUrl, versionName));
        buttonOnClickListener.setClickAutoCancel(false);
        buttonOnClickListener.setCancelable(false);
        buttonOnClickListener.show();
        return buttonOnClickListener;
    }

    public a(Context mcContext) {
        this.f17834a = mcContext;
    }
}
