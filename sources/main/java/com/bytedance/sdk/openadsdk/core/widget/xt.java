package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import master.flame.danmaku.danmaku.parser.b;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: D:\Downloads\app\classes4.dex */
public class xt extends AlertDialog {
    protected static volatile AtomicInteger xt = new AtomicInteger(0);
    private SSWebView ae;
    private Button cw;

    /* renamed from: g, reason: collision with root package name */
    private j f31273g;

    /* renamed from: j, reason: collision with root package name */
    protected Context f31274j;
    private boolean jy;

    /* renamed from: m, reason: collision with root package name */
    private ListView f31275m;
    private String oq;
    private HashMap<String, String> qv;

    /* renamed from: r, reason: collision with root package name */
    private Button f31276r;
    private String tl;
    private ImageView up;
    private List<cw> vl;

    class cw {
        private String cw;
        private String xt;

        cw(String str, String str2) {
            this.xt = str;
            this.cw = str2;
        }

        public String j() {
            return this.xt;
        }

        public String xt() {
            return this.cw;
        }
    }

    public interface j {
        void cw(Dialog dialog);

        void j(Dialog dialog);

        void xt(Dialog dialog);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.xt$xt, reason: collision with other inner class name */
    class C0497xt extends ArrayAdapter<cw> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.xt$xt$j */
        class j {
            private TextView cw;

            /* renamed from: r, reason: collision with root package name */
            private ImageView f31284r;
            private TextView xt;

            j() {
            }
        }

        C0497xt(Context context, int i6, List<cw> list) {
            super(context, i6, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            j jVar;
            View view2;
            cw cwVar = (cw) getItem(i6);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(xt.this.f31274j);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, ed.cw(xt.this.f31274j, 17.0f));
                TextView textView = new TextView(xt.this.f31274j);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int cw = ed.cw(xt.this.f31274j, 16.0f);
                layoutParams.leftMargin = cw;
                layoutParams.rightMargin = cw;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, ed.cw(xt.this.f31274j, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(xt.this.f31274j);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(cw, cw);
                layoutParams2.topMargin = ed.cw(xt.this.f31274j, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                kt.j(xt.this.f31274j, "tt_open_app_detail_list_item", (View) imageView);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(xt.this.f31274j);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = ed.cw(xt.this.f31274j, 8.0f);
                layoutParams3.topMargin = ed.cw(xt.this.f31274j, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                jVar = new j();
                jVar.xt = textView;
                jVar.cw = textView2;
                jVar.f31284r = imageView;
                relativeLayout.setTag(jVar);
                view2 = relativeLayout;
            } else {
                jVar = (j) view.getTag();
                view2 = view;
            }
            jVar.f31284r.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(cwVar.j())) {
                jVar.f31284r.setVisibility(4);
            }
            jVar.xt.setText(cwVar.j());
            jVar.cw.setText(cwVar.xt());
            return view2;
        }
    }

    private LinearLayout cw(int i6, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.f31274j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int cw2 = ed.cw(this.f31274j, 16.0f);
        linearLayout2.setPadding(cw2, cw2, cw2, cw2);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.f31276r = new Button(this.f31274j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int cw3 = ed.cw(this.f31274j, 7.0f);
        layoutParams2.leftMargin = cw3;
        layoutParams2.rightMargin = cw3;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.f31274j, 3.0f));
        gradientDrawable.setStroke(ed.cw(this.f31274j, 0.5f), Color.parseColor("#E0161823"));
        this.f31276r.setBackground(gradientDrawable);
        int cw4 = ed.cw(this.f31274j, 12.0f);
        this.f31276r.setText("上一步");
        this.f31276r.setPadding(0, cw4, 0, cw4);
        this.f31276r.setTextColor(Color.parseColor("#A8161823"));
        this.f31276r.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f31276r);
        return j(i6, linearLayout, relativeLayout, linearLayout2, cw3, cw4);
    }

    private void r() {
        if (this.f31274j == null) {
            this.f31274j = v.getContext();
        }
        if (this.f31274j.getResources().getConfiguration().orientation == 1) {
            setContentView(j(1));
        } else {
            setContentView(j(0));
        }
    }

    private LinearLayout xt(int i6, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i6 == 0) {
            return linearLayout;
        }
        View view = new View(this.f31274j);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.f31274j, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    public xt(Context context, String str) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.vl = new ArrayList();
        this.jy = false;
        this.f31274j = context;
        this.oq = str;
    }

    private View j(int i6) {
        LinearLayout linearLayout = new LinearLayout(this.f31274j);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i6);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.f31274j);
        LinearLayout.LayoutParams layoutParams2 = i6 == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.f31274j);
        LinearLayout.LayoutParams layoutParams3 = i6 == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.f31274j, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.f31274j);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return j(i6, linearLayout, linearLayout2, relativeLayout);
    }

    private void up() {
        if (this.f31274j == null) {
            this.f31274j = v.getContext();
        }
        if (this.f31274j.getResources().getConfiguration().orientation == 1) {
            setContentView(xt(1));
        } else {
            setContentView(xt(0));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        xt.set(0);
        j jVar = this.f31273g;
        if (jVar != null) {
            jVar.xt(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xt();
        if (!this.jy) {
            r();
        } else {
            up();
        }
        cw();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private LinearLayout r(int i6, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i6 == 0) {
            return linearLayout;
        }
        View view = new View(this.f31274j);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.f31274j, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    private View xt(int i6) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f31274j);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i6);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.f31274j);
        if (i6 == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.f31274j);
        if (i6 == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.f31274j, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return j(i6, linearLayout, relativeLayout);
    }

    protected void cw() {
        if (this.jy) {
            j();
        } else {
            SSWebView sSWebView = this.ae;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.j());
            }
        }
        this.cw.setVisibility(0);
        this.cw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xt.xt.set(0);
                if (xt.this.f31273g != null) {
                    xt.this.f31273g.j(xt.this);
                }
            }
        });
        this.up.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xt.xt.set(0);
                if (xt.this.f31273g != null) {
                    xt.this.f31273g.xt(xt.this);
                }
            }
        });
        this.f31276r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.xt.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                xt.xt.set(0);
                if (xt.this.f31273g != null) {
                    xt.this.f31273g.cw(xt.this);
                }
            }
        });
        List<cw> list = this.vl;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f31275m.setAdapter((ListAdapter) new C0497xt(this.f31274j, 0, this.vl));
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.f31274j);
        this.up = imageView;
        imageView.setMaxHeight(ed.cw(this.f31274j, 46.0f));
        this.up.setMaxWidth(ed.cw(this.f31274j, 46.0f));
        this.up.setMinimumHeight(ed.cw(this.f31274j, 46.0f));
        this.up.setMinimumWidth(ed.cw(this.f31274j, 46.0f));
        this.up.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.cw cwVar = new com.bytedance.sdk.openadsdk.res.cw(ed.cw(this.f31274j, 14.0f));
        cwVar.j(ViewCompat.MEASURED_STATE_MASK);
        cwVar.j(ed.cw(this.f31274j, 2.0f));
        this.up.setImageDrawable(cwVar);
        relativeLayout.addView(this.up);
        TextView textView = new TextView(this.f31274j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.f31274j);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, ed.cw(this.f31274j, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return j(i6, linearLayout, j(linearLayout2, view));
    }

    private LinearLayout xt(int i6, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.f31274j);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.f31274j, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.ae = new SSWebView(this.f31274j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.ae.setLayoutParams(layoutParams);
        relativeLayout.addView(this.ae);
        View view2 = new View(this.f31274j);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.f31274j, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return cw(i6, linearLayout, relativeLayout);
    }

    protected void xt() {
        if (TextUtils.isEmpty(this.oq)) {
            j(this.qv);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.tj.m up = com.bytedance.sdk.openadsdk.core.j.up(new JSONObject(this.oq));
            if (up != null) {
                HashMap<String, String> j6 = up.j();
                this.qv = j6;
                if (!j6.isEmpty()) {
                    this.jy = false;
                    j(this.qv);
                } else if (!TextUtils.isEmpty(up.xt())) {
                    this.tl = up.xt();
                    this.jy = true;
                } else {
                    j(this.qv);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
        }
    }

    private LinearLayout j(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.f31274j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.f31275m = new ListView(this.f31274j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = ed.cw(this.f31274j, 20.0f);
        int cw2 = ed.cw(this.f31274j, 16.0f);
        this.f31275m.setPadding(cw2, 0, cw2, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(ed.cw(this.f31274j, 1.0f), Color.parseColor("#F0F0F0"));
        this.f31275m.setDivider(gradientDrawable);
        this.f31275m.setDividerHeight(ed.cw(this.f31274j, 24.0f));
        this.f31275m.setSelector(new ColorDrawable(0));
        this.f31275m.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f31275m);
        View view2 = new View(this.f31274j);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, ed.cw(this.f31274j, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.f31274j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int cw2 = ed.cw(this.f31274j, 16.0f);
        linearLayout3.setPadding(cw2, cw2, cw2, cw2);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.f31276r = new Button(this.f31274j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int cw3 = ed.cw(this.f31274j, 7.0f);
        layoutParams2.leftMargin = cw3;
        layoutParams2.rightMargin = cw3;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(ed.cw(this.f31274j, 3.0f));
        gradientDrawable.setStroke(ed.cw(this.f31274j, 0.5f), Color.parseColor("#E0161823"));
        this.f31276r.setBackground(gradientDrawable);
        int cw4 = ed.cw(this.f31274j, 12.0f);
        this.f31276r.setText("上一步");
        this.f31276r.setPadding(0, cw4, 0, cw4);
        this.f31276r.setTextColor(Color.parseColor("#A8161823"));
        this.f31276r.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.f31276r);
        return j(cw3, cw4, linearLayout3, xt(i6, linearLayout, linearLayout2));
    }

    private LinearLayout j(int i6, int i7, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.cw = new Button(this.f31274j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i6;
        layoutParams.rightMargin = i6;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(ed.cw(this.f31274j, 3.0f));
        this.cw.setBackground(gradientDrawable);
        this.cw.setText("立即下载");
        this.cw.setPadding(0, i7, 0, i7);
        this.cw.setTextColor(-1);
        this.cw.setLayoutParams(layoutParams);
        linearLayout.addView(this.cw);
        return linearLayout2;
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f31274j);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.f31274j);
        this.up = imageView;
        imageView.setMaxHeight(ed.cw(this.f31274j, 46.0f));
        this.up.setMaxWidth(ed.cw(this.f31274j, 46.0f));
        this.up.setMinimumHeight(ed.cw(this.f31274j, 46.0f));
        this.up.setMinimumWidth(ed.cw(this.f31274j, 46.0f));
        this.up.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.bytedance.sdk.openadsdk.res.cw cwVar = new com.bytedance.sdk.openadsdk.res.cw(ed.cw(this.f31274j, 14.0f));
        cwVar.j(ViewCompat.MEASURED_STATE_MASK);
        cwVar.j(ed.cw(this.f31274j, 2.0f));
        this.up.setImageDrawable(cwVar);
        relativeLayout2.addView(this.up);
        TextView textView = new TextView(this.f31274j);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return xt(i6, linearLayout, relativeLayout);
    }

    private LinearLayout j(int i6, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i7, int i8) {
        return j(i7, i8, linearLayout2, r(i6, linearLayout, relativeLayout));
    }

    protected void j() {
        this.ae.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.j.r(this.f31274j, null, 0 == true ? 1 : 0) { // from class: com.bytedance.sdk.openadsdk.core.widget.xt.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.j.r
            protected boolean j(WebView webView, WebResourceRequest webResourceRequest) {
                this.tl = xt.xt;
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
                this.tl = xt.xt;
                return super.j(webView, str);
            }
        });
        this.ae.setJavaScriptEnabled(true);
        this.ae.setDisplayZoomControls(false);
        this.ae.setCacheMode(2);
        this.ae.loadUrl(this.tl);
    }

    private void j(HashMap<String, String> hashMap) {
        List<cw> list = this.vl;
        if (list != null && list.size() > 0) {
            this.vl.clear();
        }
        if (this.vl == null) {
            this.vl = new ArrayList();
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                this.vl.add(new cw(str, hashMap.get(str)));
            }
            return;
        }
        this.vl.add(new cw("补充中，可于应用官网查看", ""));
    }

    public xt j(j jVar) {
        this.f31273g = jVar;
        return this;
    }
}
