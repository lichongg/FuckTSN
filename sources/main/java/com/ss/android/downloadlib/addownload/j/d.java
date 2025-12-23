package com.ss.android.downloadlib.addownload.j;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a;

/* loaded from: D:\Downloads\app\classes6.dex */
public class d extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.j.c f37775a;

    /* renamed from: b, reason: collision with root package name */
    private com.ss.android.downloadlib.addownload.j.a f37776b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f37777c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f37778d;

    /* renamed from: e, reason: collision with root package name */
    private Activity f37779e;

    /* renamed from: f, reason: collision with root package name */
    private String f37780f;

    /* renamed from: g, reason: collision with root package name */
    private String f37781g;

    /* renamed from: h, reason: collision with root package name */
    private String f37782h;

    /* renamed from: i, reason: collision with root package name */
    private String f37783i;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.delete();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.g();
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.d();
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.j.d$d, reason: collision with other inner class name */
    public static class C0747d {

        /* renamed from: a, reason: collision with root package name */
        private Activity f37787a;

        /* renamed from: b, reason: collision with root package name */
        private String f37788b;

        /* renamed from: c, reason: collision with root package name */
        private String f37789c;

        /* renamed from: d, reason: collision with root package name */
        private String f37790d;

        /* renamed from: e, reason: collision with root package name */
        private String f37791e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f37792f;

        /* renamed from: g, reason: collision with root package name */
        private com.ss.android.downloadlib.addownload.j.c f37793g;

        /* renamed from: h, reason: collision with root package name */
        private com.ss.android.downloadlib.addownload.j.a f37794h;

        public C0747d a(String str) {
            this.f37790d = str;
            return this;
        }

        public C0747d b(com.ss.android.downloadlib.addownload.j.a aVar) {
            this.f37794h = aVar;
            return this;
        }

        public C0747d c(com.ss.android.downloadlib.addownload.j.c cVar) {
            this.f37793g = cVar;
            return this;
        }

        public C0747d d(String str) {
            this.f37788b = str;
            return this;
        }

        public C0747d e(boolean z5) {
            this.f37792f = z5;
            return this;
        }

        public d f() {
            return new d(this.f37787a, this.f37788b, this.f37789c, this.f37790d, this.f37791e, this.f37792f, this.f37793g, this.f37794h);
        }

        public C0747d g(String str) {
            this.f37791e = str;
            return this;
        }

        public C0747d h(String str) {
            this.f37789c = str;
            return this;
        }

        public C0747d(Activity activity) {
            this.f37787a = activity;
        }
    }

    private static int b(Context context, int i6) {
        return a.h.f(context, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.f37777c = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.f37778d = true;
        dismiss();
    }

    private static GradientDrawable c(Context context, String str, int i6) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadius(b(context, i6));
        return gradientDrawable;
    }

    private void e(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b(context, 290), -2);
        linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout2.setBackground(c(context, "#ffffff", 4));
        linearLayout2.setOrientation(1);
        int b6 = b(context, 16);
        TextView textView = new TextView(context);
        textView.setTextSize(2, 16.0f);
        textView.setText("是否在WiFi环境下恢复下载？");
        textView.setTextColor(Color.parseColor("#222222"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(b6, b6, b6, b6);
        textView.setLayoutParams(layoutParams3);
        if (!TextUtils.isEmpty(this.f37780f)) {
            textView.setText(this.f37780f);
        }
        linearLayout2.addView(textView);
        LinearLayout linearLayout3 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = b(context, 26);
        layoutParams4.bottomMargin = b6;
        linearLayout3.setOrientation(0);
        linearLayout3.setLayoutParams(layoutParams4);
        TextView textView2 = new TextView(context);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(b(context, 70), b(context, 33)));
        textView2.setText("管理");
        textView2.setTextColor(Color.parseColor("#CFCFCF"));
        textView2.setTextSize(2, 13.0f);
        textView2.setGravity(17);
        if (!TextUtils.isEmpty(this.f37783i)) {
            textView2.setText(this.f37783i);
            linearLayout3.addView(textView2);
            textView2.setOnClickListener(new a());
        }
        LinearLayout linearLayout4 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout4.setOrientation(0);
        layoutParams5.rightMargin = b(context, 16);
        linearLayout4.setGravity(5);
        linearLayout4.setLayoutParams(layoutParams5);
        TextView textView3 = new TextView(context);
        textView3.setLayoutParams(new LinearLayout.LayoutParams(b(context, 70), b(context, 33)));
        textView3.setTextColor(Color.parseColor("#CFCFCF"));
        textView3.setText("不，谢谢");
        textView3.setTextSize(2, 13.0f);
        textView3.setGravity(17);
        if (!TextUtils.isEmpty(this.f37782h)) {
            textView3.setText(this.f37782h);
        }
        textView3.setOnClickListener(new b());
        linearLayout4.addView(textView3);
        TextView textView4 = new TextView(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(b(context, 70), b(context, 33));
        layoutParams6.leftMargin = b(context, 8);
        layoutParams6.gravity = 5;
        textView4.setLayoutParams(layoutParams6);
        textView4.setTextColor(Color.parseColor("#ffffff"));
        textView4.setTextSize(2, 13.0f);
        textView4.setText("好的");
        textView4.setGravity(17);
        if (!TextUtils.isEmpty(this.f37781g)) {
            textView4.setText(this.f37781g);
        }
        textView4.setBackground(c(context, "#2A90D7", 2));
        textView4.setOnClickListener(new c());
        linearLayout4.addView(textView4);
        linearLayout3.addView(linearLayout4);
        linearLayout2.addView(linearLayout3);
        linearLayout.addView(linearLayout2);
        setContentView(linearLayout);
    }

    public d(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z5, @NonNull com.ss.android.downloadlib.addownload.j.c cVar, com.ss.android.downloadlib.addownload.j.a aVar) {
        super(activity);
        this.f37779e = activity;
        this.f37775a = cVar;
        this.f37780f = str;
        this.f37781g = str2;
        this.f37782h = str3;
        this.f37783i = str4;
        this.f37776b = aVar;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setCanceledOnTouchOutside(z5);
        e(this.f37779e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f37779e.isFinishing()) {
            this.f37779e.finish();
        }
        if (this.f37777c) {
            this.f37775a.j();
        } else if (this.f37778d) {
            this.f37776b.delete();
        } else {
            this.f37775a.xt();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
