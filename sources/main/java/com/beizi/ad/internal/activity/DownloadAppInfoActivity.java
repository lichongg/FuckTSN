package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.beizi.ad.internal.download.BeiZiWebView;
import com.beizi.fusion.R;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DownloadAppInfoActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f11587a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f11588b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f11589c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f11590d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f11591e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f11592f;

    /* renamed from: g, reason: collision with root package name */
    private TextView f11593g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f11594h;

    /* renamed from: i, reason: collision with root package name */
    private View f11595i;

    /* renamed from: j, reason: collision with root package name */
    private View f11596j;

    /* renamed from: k, reason: collision with root package name */
    private View f11597k;

    /* renamed from: l, reason: collision with root package name */
    private int f11598l = 0;

    /* renamed from: m, reason: collision with root package name */
    private String f11599m = "";

    /* renamed from: n, reason: collision with root package name */
    private String f11600n = "";

    /* renamed from: o, reason: collision with root package name */
    private String f11601o = "";

    /* renamed from: p, reason: collision with root package name */
    private String f11602p = "";

    /* renamed from: q, reason: collision with root package name */
    private ScrollView f11603q;

    /* renamed from: r, reason: collision with root package name */
    private ScrollView f11604r;

    /* renamed from: s, reason: collision with root package name */
    private ScrollView f11605s;

    /* renamed from: t, reason: collision with root package name */
    private TextView f11606t;

    /* renamed from: u, reason: collision with root package name */
    private TextView f11607u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f11608v;

    /* renamed from: w, reason: collision with root package name */
    private BeiZiWebView f11609w;

    /* renamed from: x, reason: collision with root package name */
    private BeiZiWebView f11610x;

    /* renamed from: y, reason: collision with root package name */
    private BeiZiWebView f11611y;

    static {
        StubApp.interface11(12524);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void a() {
        this.f11587a = (ImageView) findViewById(R.id.beizi_download_appinfo_back);
        this.f11588b = (TextView) findViewById(R.id.beizi_download_appinfo_title);
        this.f11589c = (LinearLayout) findViewById(R.id.beizi_appinfo_permission_layout);
        this.f11592f = (TextView) findViewById(R.id.beizi_appinfo_permission_textview);
        this.f11595i = findViewById(R.id.beizi_appinfo_permission_below_line);
        this.f11590d = (LinearLayout) findViewById(R.id.beizi_appinfo_privacy_layout);
        this.f11593g = (TextView) findViewById(R.id.beizi_appinfo_privacy_textview);
        this.f11596j = findViewById(R.id.beizi_appinfo_privacy_below_line);
        this.f11591e = (LinearLayout) findViewById(R.id.beizi_appinfo_intro_layout);
        this.f11594h = (TextView) findViewById(R.id.beizi_appinfo_intro_textview);
        this.f11597k = findViewById(R.id.beizi_appinfo_intro_below_line);
        this.f11603q = (ScrollView) findViewById(R.id.beizi_download_appinfo_persmission_content_scrollview);
        this.f11606t = (TextView) findViewById(R.id.beizi_download_appinfo_persmission_content_textview);
        this.f11609w = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_persmission_content_webview);
        this.f11604r = (ScrollView) findViewById(R.id.beizi_download_appinfo_privacy_content_scrollview);
        this.f11607u = (TextView) findViewById(R.id.beizi_download_appinfo_privacy_content_textview);
        this.f11610x = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_privacy_content_webview);
        this.f11605s = (ScrollView) findViewById(R.id.beizi_download_appinfo_intro_content_scrollview);
        this.f11608v = (TextView) findViewById(R.id.beizi_download_appinfo_intro_content_textview);
        this.f11611y = (BeiZiWebView) findViewById(R.id.beizi_download_appinfo_intro_content_webview);
    }

    private void c() {
        if (!TextUtils.isEmpty(this.f11602p)) {
            this.f11588b.setText(this.f11602p);
        }
        this.f11587a.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.finish();
            }
        });
        this.f11589c.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(0);
            }
        });
        this.f11590d.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(1);
            }
        });
        this.f11591e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.DownloadAppInfoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloadAppInfoActivity.this.a(2);
            }
        });
    }

    private void d() {
        TextView textView = this.f11594h;
        int i6 = R.color.appinfo_tab_unselected_color;
        textView.setTextColor(ContextCompat.getColor(this, i6));
        this.f11597k.setVisibility(4);
        this.f11592f.setTextColor(ContextCompat.getColor(this, i6));
        this.f11595i.setVisibility(4);
        this.f11593g.setTextColor(ContextCompat.getColor(this, i6));
        this.f11596j.setVisibility(4);
        this.f11605s.setVisibility(8);
        this.f11611y.setVisibility(8);
        this.f11608v.setVisibility(8);
        this.f11603q.setVisibility(8);
        this.f11606t.setVisibility(8);
        this.f11609w.setVisibility(8);
        this.f11604r.setVisibility(8);
        this.f11607u.setVisibility(8);
        this.f11610x.setVisibility(8);
    }

    private void b() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        this.f11600n = extras.getString("privacy_content_key");
        this.f11602p = extras.getString("title_content_key");
        this.f11599m = extras.getString("permission_content_key");
        this.f11601o = extras.getString("intro_content_key");
        this.f11598l = extras.getInt("from_position_key");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i6) {
        if (i6 == 2) {
            d();
            a(this.f11594h, this.f11597k, this.f11601o, this.f11608v, this.f11605s, this.f11611y);
        } else if (i6 == 1) {
            d();
            a(this.f11593g, this.f11596j, this.f11600n, this.f11607u, this.f11604r, this.f11610x);
        } else {
            d();
            a(this.f11592f, this.f11595i, this.f11599m, this.f11606t, this.f11603q, this.f11609w);
        }
    }

    private void a(TextView textView, View view, String str, TextView textView2, ScrollView scrollView, WebView webView) {
        int i6 = R.color.appinfo_tab_selected_color;
        textView.setTextColor(ContextCompat.getColor(this, i6));
        view.setBackgroundColor(ContextCompat.getColor(this, i6));
        view.setVisibility(0);
        if (str.startsWith(master.flame.danmaku.danmaku.parser.b.f50154a)) {
            textView2.setText("");
            scrollView.setVisibility(8);
            webView.setVisibility(0);
            webView.loadUrl(str);
            return;
        }
        textView2.setText(str);
        textView2.setVisibility(0);
        scrollView.setVisibility(0);
        webView.setVisibility(8);
    }
}
