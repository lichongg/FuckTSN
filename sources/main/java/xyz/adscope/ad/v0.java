package xyz.adscope.ad;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import xyz.adscope.ad.download.service.DownloadService;
import xyz.adscope.ad.download.service.a;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.DisplayModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.NativeModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.down.DownloadInfoModel;
import xyz.adscope.ad.model.impl.resp.ad.resp.seatbid.bid.media.ad.display.nativ.link.LinkModel;
import xyz.adscope.common.v2.tool.str.StringUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class v0 extends t0 {

    /* renamed from: f, reason: collision with root package name */
    private v2 f56015f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(v0 v0Var, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("prompt");
                LinkModel d6 = v0.this.d();
                if (CommonNetImpl.CANCEL.equals(stringExtra) && d6 != null) {
                    v0.this.a(d6.d(), context);
                }
                if ("confirm".equals(stringExtra) && d6 != null) {
                    v0.this.a(context, d6);
                }
            }
            v0.this.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), this);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f56017a;

        /* renamed from: b, reason: collision with root package name */
        private final a.C1087a f56018b;

        /* synthetic */ c(Context context, String str, DownloadInfoModel downloadInfoModel, String str2, String str3, b1 b1Var, a aVar) {
            this(context, str, downloadInfoModel, str2, str3, b1Var);
        }

        private c(Context context, String str, DownloadInfoModel downloadInfoModel, String str2, String str3, b1 b1Var) {
            this.f56017a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f56018b = new a.C1087a(str, downloadInfoModel, str2, str3, b1Var);
        }

        private void a(IBinder iBinder) {
            xyz.adscope.ad.download.service.a a6;
            if (!(iBinder instanceof DownloadService.b) || (a6 = ((DownloadService.b) iBinder).a()) == null) {
                return;
            }
            a6.a(this.f56018b);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a(iBinder);
            this.f56017a.unbindService(this);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private DownloadInfoModel b() {
        NativeModel nativeModel = this.f56207d;
        if (nativeModel == null || nativeModel.b() == null) {
            return null;
        }
        return this.f56207d.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LinkModel d() {
        NativeModel nativeModel = this.f56207d;
        if (nativeModel == null || nativeModel.c() == null) {
            return null;
        }
        return this.f56207d.c();
    }

    private String e() {
        DisplayModel displayModel = this.f56206c;
        return displayModel != null ? displayModel.f() : "";
    }

    private boolean b(Context context, String str) {
        if (b() == null) {
            return false;
        }
        b bVar = new b(this, null);
        a(context, bVar);
        DownloadInfoModel b6 = this.f56207d.b();
        if (b6 == null) {
            return false;
        }
        boolean a6 = n4.a(context, str, b6.toJsonString());
        if (!a6) {
            b(context, bVar);
        }
        return a6;
    }

    private boolean c(Context context, String str) {
        return a(context, str);
    }

    private boolean f() {
        DownloadInfoModel b6;
        LinkModel d6 = d();
        if (d6 != null && d6.c() == 1) {
            String e6 = d6.e();
            String b7 = d6.b();
            if ((!TextUtils.isEmpty(e6) || !TextUtils.isEmpty(b7)) && (b6 = b()) != null && b6.m()) {
                return true;
            }
        }
        return false;
    }

    @Override // xyz.adscope.ad.z1
    protected x1 a() {
        v2 v2Var = new v2();
        this.f56015f = v2Var;
        return v2Var;
    }

    @Override // xyz.adscope.ad.t0, xyz.adscope.ad.f2
    protected void a(LinkModel linkModel, View view, int i6) {
        if (linkModel != null) {
            if (TextUtils.isEmpty(linkModel.a()) || !a(view.getContext(), linkModel.a())) {
                if (f()) {
                    if (a(i6)) {
                        if (b(view.getContext(), linkModel.b())) {
                            return;
                        }
                    } else if (a(view.getContext(), linkModel)) {
                        return;
                    }
                }
                a(linkModel.d(), view.getContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, b bVar) {
        LocalBroadcastManager.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).unregisterReceiver(bVar);
    }

    private boolean a(int i6) {
        DownloadInfoModel b6 = b();
        return (i6 == 0 || b6 == null || !b6.o()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, LinkModel linkModel) {
        if (!TextUtils.isEmpty(linkModel.e()) && c(context, linkModel.e())) {
            return true;
        }
        if (TextUtils.isEmpty(linkModel.b())) {
            return false;
        }
        return a(linkModel.b(), this.f56207d.b());
    }

    @Override // xyz.adscope.ad.t0
    protected void a(String str, Context context) {
        if (TextUtils.isEmpty(str) || b() == null) {
            return;
        }
        new Bundle().putBoolean("allow", b().n());
        n4.a(context, str, (Bundle) null);
    }

    private boolean a(String str, DownloadInfoModel downloadInfoModel) {
        if (!StringUtil.isValidURL(str)) {
            return false;
        }
        b1 b6 = this.f56015f.b();
        n4.a(this.f56208e, new c(this.f56208e, str, downloadInfoModel, this.f56205b, e(), b6, null));
        return true;
    }

    private void a(Context context, b bVar) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.asnp.ad.ACTION_DOWNLOAD_PROMPT_RESULT");
        LocalBroadcastManager.getInstance(StubApp.getOrigApplicationContext(context.getApplicationContext())).registerReceiver(bVar, intentFilter);
    }
}
