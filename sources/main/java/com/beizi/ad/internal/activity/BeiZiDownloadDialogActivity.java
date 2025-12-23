package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.ad.AdActivity;
import com.beizi.ad.DownloadService;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.h.i;
import com.beizi.ad.internal.h.l;
import com.beizi.ad.internal.h.x;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.j;
import com.beizi.ad.lance.a.o;
import com.beizi.fusion.R;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class BeiZiDownloadDialogActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f11447a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f11448b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f11449c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f11450d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f11451e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f11452f;

    /* renamed from: g, reason: collision with root package name */
    private ExpandableListView f11453g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f11454h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f11455i;

    /* renamed from: j, reason: collision with root package name */
    private TextView f11456j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f11457k;

    /* renamed from: l, reason: collision with root package name */
    private ApkBean f11458l;

    /* renamed from: m, reason: collision with root package name */
    private int f11459m = -1;

    /* renamed from: n, reason: collision with root package name */
    private int f11460n = 1;

    /* renamed from: o, reason: collision with root package name */
    private List<String> f11461o;

    /* renamed from: p, reason: collision with root package name */
    private String f11462p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f11463q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f11464r;

    /* renamed from: s, reason: collision with root package name */
    private String f11465s;

    /* renamed from: t, reason: collision with root package name */
    private int f11466t;

    static {
        StubApp.interface11(12473);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void a() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("apkBean")) {
                this.f11458l = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            if (bundleExtra.containsKey("type")) {
                this.f11460n = bundleExtra.getInt("type");
            }
            if (bundleExtra.containsKey("openList")) {
                this.f11461o = bundleExtra.getStringArrayList("openList");
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.f11462p = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("isCanJump")) {
                this.f11463q = bundleExtra.getBoolean("isCanJump", false);
            }
            if (bundleExtra.containsKey("isDownload")) {
                this.f11464r = bundleExtra.getBoolean("isDownload", false);
            }
            if (bundleExtra.containsKey("deeplinkUrl")) {
                this.f11465s = bundleExtra.getString("deeplinkUrl");
            }
            if (bundleExtra.containsKey("webDeepLink")) {
                this.f11466t = bundleExtra.getInt("webDeepLink");
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void b() {
        try {
            this.f11447a = (FrameLayout) findViewById(R.id.beizi_download_dialog_container_fl);
            this.f11451e = (ImageView) findViewById(R.id.beizi_download_dialog_close_iv);
            this.f11452f = (ImageView) findViewById(R.id.beizi_download_dialog_icon_iv);
            this.f11448b = (TextView) findViewById(R.id.beizi_download_dialog_name_tv);
            this.f11449c = (TextView) findViewById(R.id.beizi_download_dialog_version_tv);
            this.f11450d = (TextView) findViewById(R.id.beizi_download_dialog_developer_tv);
            this.f11453g = (ExpandableListView) findViewById(R.id.beizi_download_dialog_expand_lv);
            this.f11454h = (LinearLayout) findViewById(R.id.beizi_download_dialog_download_container_ll);
            this.f11455i = (LinearLayout) findViewById(R.id.beizi_download_dialog_market_container_ll);
            this.f11456j = (TextView) findViewById(R.id.beizi_download_dialog_market_cancel_tv);
            this.f11457k = (TextView) findViewById(R.id.beizi_download_dialog_market_confirm_tv);
            this.f11453g.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.1
                @Override // android.widget.ExpandableListView.OnGroupClickListener
                public boolean onGroupClick(ExpandableListView expandableListView, View view, int i6, long j6) {
                    try {
                        if (BeiZiDownloadDialogActivity.this.f11453g.isGroupExpanded(i6)) {
                            BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(i6);
                        } else {
                            BeiZiDownloadDialogActivity.this.f11453g.expandGroup(i6);
                            if (i6 == 0) {
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(1);
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(2);
                            } else if (i6 == 1) {
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(0);
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(2);
                            } else if (i6 == 2) {
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(0);
                                BeiZiDownloadDialogActivity.this.f11453g.collapseGroup(1);
                            }
                        }
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return false;
                    }
                }
            });
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        try {
            if (this.f11458l == null) {
                return;
            }
            if (this.f11460n == 1) {
                this.f11451e.setVisibility(0);
                this.f11451e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f11454h.setVisibility(0);
                this.f11454h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.d();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f11455i.setVisibility(8);
            } else {
                this.f11451e.setVisibility(8);
                this.f11454h.setVisibility(8);
                this.f11455i.setVisibility(0);
                this.f11456j.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f11457k.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.d();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
            }
            if (this.f11452f != null && !TextUtils.isEmpty(this.f11458l.getAppIconURL())) {
                try {
                    i.a((Context) null).a(this.f11458l.getAppIconURL(), new i.a() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.6
                        @Override // com.beizi.ad.internal.h.i.a
                        public void a() {
                        }

                        @Override // com.beizi.ad.internal.h.i.a
                        public void a(Bitmap bitmap) {
                            try {
                                BeiZiDownloadDialogActivity.this.f11452f.setImageBitmap(bitmap);
                            } catch (Exception e6) {
                                e6.printStackTrace();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            if (this.f11448b != null && !TextUtils.isEmpty(this.f11458l.getApkTittleName())) {
                this.f11448b.setText(this.f11458l.getApkTittleName());
            }
            if (this.f11449c != null && !TextUtils.isEmpty(this.f11458l.getAppVersion())) {
                this.f11449c.setText("版本号 ：" + this.f11458l.getAppVersion());
            }
            if (this.f11450d != null && !TextUtils.isEmpty(this.f11458l.getAppDeveloper())) {
                this.f11450d.setText("开发者 ：" + this.f11458l.getAppDeveloper());
            }
            ArrayList arrayList = new ArrayList();
            com.beizi.ad.internal.download.b bVar = new com.beizi.ad.internal.download.b();
            bVar.a("应用权限");
            if (!TextUtils.isEmpty(this.f11458l.getAppPermissionsUrl())) {
                bVar.c(this.f11458l.getAppPermissionsUrl());
                bVar.b("h5");
            } else if (!TextUtils.isEmpty(this.f11458l.getAppPermissionsDesc())) {
                bVar.c(this.f11458l.getAppPermissionsDesc());
                bVar.b(com.baidu.mobads.sdk.internal.a.f10501b);
            }
            arrayList.add(bVar);
            com.beizi.ad.internal.download.b bVar2 = new com.beizi.ad.internal.download.b();
            bVar2.a("隐私协议");
            String appPrivacyUrl = this.f11458l.getAppPrivacyUrl();
            if (!TextUtils.isEmpty(appPrivacyUrl)) {
                if (appPrivacyUrl.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b("h5");
                } else {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b(com.baidu.mobads.sdk.internal.a.f10501b);
                }
            }
            arrayList.add(bVar2);
            com.beizi.ad.internal.download.b bVar3 = new com.beizi.ad.internal.download.b();
            bVar3.a("产品功能介绍");
            String appintro = this.f11458l.getAppintro();
            if (!TextUtils.isEmpty(appintro)) {
                if (appintro.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
                    bVar3.c(appintro);
                    bVar3.b("h5");
                } else {
                    bVar3.c(appintro);
                    bVar3.b(com.baidu.mobads.sdk.internal.a.f10501b);
                }
            }
            arrayList.add(bVar3);
            this.f11453g.setAdapter(new com.beizi.ad.internal.download.a(this, arrayList));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            if (this.f11458l == null) {
                return;
            }
            if (this.f11460n == 2) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f11458l.getApkUrl()));
                intent.setFlags(268435456);
                startActivity(intent);
                List<String> list = this.f11461o;
                if (list != null) {
                    l.a(list);
                    return;
                }
                return;
            }
            if (o.a(this)) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("apkBean", this.f11458l);
                Intent intent2 = new Intent(this, (Class<?>) DownloadService.class);
                intent2.putExtra("data", bundle);
                startService(intent2);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f11460n == 2 && !TextUtils.isEmpty(this.f11462p) && this.f11462p.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            Class a6 = AdActivity.a();
            try {
                WebView webView = new WebView(this);
                x.a(webView);
                webView.loadUrl(this.f11462p, j.a());
                a.f11616a.add(webView);
                Intent intent = new Intent(h.a().e(), (Class<?>) a6);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.f11463q);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", this.f11464r);
                if (!TextUtils.isEmpty(this.f11465s)) {
                    intent.putExtra("deeplinkUrl", this.f11465s);
                    intent.putExtra("webDeepLink", this.f11466t);
                }
                startActivity(intent);
            } catch (Exception unused) {
                a.f11616a.remove();
            }
        }
    }
}
