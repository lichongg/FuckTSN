package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up extends AlertDialog {
    protected static volatile AtomicInteger cw = new AtomicInteger(0);
    private Button ae;

    /* renamed from: g, reason: collision with root package name */
    private j f31252g;

    /* renamed from: j, reason: collision with root package name */
    protected String f31253j;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f31254m;

    /* renamed from: r, reason: collision with root package name */
    private SSWebView f31255r;
    private Button tl;
    private Context up;
    protected String xt;

    public interface j {
        void cw(Dialog dialog);

        void j(Dialog dialog);

        void xt(Dialog dialog);
    }

    public up(Context context, String str, String str2, String str3) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.up = context;
        this.f31253j = str;
        this.xt = str3;
        if (TextUtils.isEmpty(str) || !(this.f31253j.startsWith(b.f50155b) || this.f31253j.startsWith(b.f50154a))) {
            this.f31253j = str2;
        }
    }

    private View j(int i6) {
        LinearLayout linearLayout = new LinearLayout(this.up);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i6);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.up);
        LinearLayout.LayoutParams layoutParams2 = i6 == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.up);
        LinearLayout.LayoutParams layoutParams3 = i6 == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.up, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.up);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.up);
        this.f31254m = imageView;
        imageView.setMaxHeight(ed.cw(this.up, 46.0f));
        this.f31254m.setMaxWidth(ed.cw(this.up, 46.0f));
        this.f31254m.setMinimumHeight(ed.cw(this.up, 46.0f));
        this.f31254m.setMinimumWidth(ed.cw(this.up, 46.0f));
        this.f31254m.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.cw cwVar = new com.bytedance.sdk.openadsdk.res.cw(ed.cw(this.up, 14.0f));
        cwVar.j(ViewCompat.MEASURED_STATE_MASK);
        cwVar.j(ed.cw(this.up, 2.0f));
        this.f31254m.setImageDrawable(cwVar);
        relativeLayout.addView(this.f31254m);
        TextView textView = new TextView(this.up);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams4.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText(this.xt);
        textView.setLayoutParams(layoutParams4);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view2 = new View(this.up);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.up, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        this.f31255r = new SSWebView(this.up);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams5.weight = 1.0f;
        this.f31255r.setLayoutParams(layoutParams5);
        linearLayout2.addView(this.f31255r);
        View view3 = new View(this.up);
        view3.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.up, 1.0f)));
        view3.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view3);
        LinearLayout linearLayout3 = new LinearLayout(this.up);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int cw2 = ed.cw(this.up, 16.0f);
        linearLayout3.setPadding(cw2, cw2, cw2, cw2);
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout2.addView(linearLayout3);
        this.tl = new Button(this.up);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        int cw3 = ed.cw(this.up, 7.0f);
        layoutParams7.leftMargin = cw3;
        layoutParams7.rightMargin = cw3;
        layoutParams7.weight = 1.0f;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(ed.cw(this.up, 3.0f));
        gradientDrawable2.setStroke(ed.cw(this.up, 0.5f), Color.parseColor("#E0161823"));
        this.tl.setBackground(gradientDrawable2);
        int cw4 = ed.cw(this.up, 12.0f);
        this.tl.setText("上一步");
        this.tl.setPadding(0, cw4, 0, cw4);
        this.tl.setTextColor(Color.parseColor("#A8161823"));
        this.tl.setLayoutParams(layoutParams7);
        linearLayout3.addView(this.tl);
        this.ae = new Button(this.up);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(0, -2);
        layoutParams8.leftMargin = cw3;
        layoutParams8.rightMargin = cw3;
        layoutParams8.weight = 1.0f;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable3.setCornerRadius(ed.cw(this.up, 3.0f));
        this.ae.setBackground(gradientDrawable3);
        this.ae.setText("立即下载");
        this.ae.setPadding(0, cw4, 0, cw4);
        this.ae.setTextColor(-1);
        this.ae.setLayoutParams(layoutParams8);
        linearLayout3.addView(this.ae);
        if (i6 == 0) {
            return linearLayout;
        }
        View view4 = new View(this.up);
        view4.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.up, 34.0f)));
        linearLayout2.addView(view4);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        cw.set(0);
        j jVar = this.f31252g;
        if (jVar != null) {
            jVar.xt(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.up == null) {
            this.up = v.getContext();
        }
        j();
    }

    protected void j() {
        if (this.up.getResources().getConfiguration().orientation == 1) {
            setContentView(j(1));
        } else {
            setContentView(j(0));
        }
        this.f31254m.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.up.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                up.cw.set(0);
                if (up.this.f31252g != null) {
                    up.this.f31252g.xt(up.this);
                }
            }
        });
        this.tl.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.up.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                up.cw.set(0);
                if (up.this.f31252g != null) {
                    up.this.f31252g.cw(up.this);
                }
            }
        });
        this.ae.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.up.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                up.cw.set(0);
                if (up.this.f31252g != null) {
                    up.this.f31252g.j(up.this);
                }
            }
        });
        this.f31255r.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.up, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.up.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
                this.tl = up.cw;
                return super.j(webView, webResourceRequest);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
                    if (!lowerCase.contains(b.f50154a) && !lowerCase.contains(b.f50155b)) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            public boolean j(WebView webView, String str) {
                this.tl = up.cw;
                return super.j(webView, str);
            }
        });
        this.f31255r.setJavaScriptEnabled(true);
        this.f31255r.setDisplayZoomControls(false);
        this.f31255r.setCacheMode(2);
        this.f31255r.loadUrl(this.f31253j);
    }

    public up j(j jVar) {
        this.f31252g = jVar;
        return this;
    }
}
