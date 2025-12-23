package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class av extends AlertDialog {
    private boolean cw;

    /* renamed from: j, reason: collision with root package name */
    private Context f31164j;

    /* renamed from: r, reason: collision with root package name */
    private j f31165r;
    private String xt;

    public interface j {
        void j(String str);

        void xt(String str);
    }

    public av(Context context, String str) {
        super(context, kt.tl(context, "tt_dialog_full"));
        this.f31164j = context;
        this.xt = str;
        this.cw = TextUtils.isEmpty(str);
    }

    private void j() {
        setContentView(xt());
    }

    private View xt() {
        LinearLayout linearLayout = new LinearLayout(this.f31164j);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        linearLayout.setGravity(17);
        TextView textView = new TextView(this.f31164j);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("您要访问的网站存在风险");
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        linearLayout.addView(textView);
        int cw = ed.cw(this.f31164j, 10.0f) * 2;
        TextView textView2 = new TextView(this.f31164j);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = cw;
        layoutParams3.gravity = 17;
        textView2.setLayoutParams(layoutParams3);
        textView2.setText("继续访问可能导致个人隐私泄漏、账号被盗用等危害");
        textView2.setTextColor(-1);
        textView2.setTextSize(15.0f);
        linearLayout.addView(textView2);
        int cw2 = ed.cw(this.f31164j, 25.0f);
        int cw3 = ed.cw(this.f31164j, 8.0f);
        if (!this.cw) {
            Button button = new Button(this.f31164j);
            button.setBackgroundColor(-7829368);
            button.setText("继续访问");
            button.setTextColor(-1);
            button.setPadding(cw2, cw3, cw2, cw3);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ed.cw(this.f31164j, 230.0f), -2);
            layoutParams4.topMargin = cw;
            layoutParams4.gravity = 17;
            button.setLayoutParams(layoutParams4);
            button.setTextSize(25.0f);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.av.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    av.this.dismiss();
                    if (av.this.f31165r == null) {
                        return;
                    }
                    av.this.f31165r.j(av.this.xt);
                }
            });
            linearLayout.addView(button);
        }
        Button button2 = new Button(this.f31164j);
        button2.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ed.cw(this.f31164j, 230.0f), -2);
        layoutParams5.topMargin = cw;
        layoutParams5.gravity = 17;
        button2.setLayoutParams(layoutParams5);
        button2.setText("返回安全链接");
        button2.setTextColor(-1);
        button2.setTextSize(25.0f);
        button2.setTypeface(null, 1);
        button2.setPadding(cw2, cw3, cw2, cw3);
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.av.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                av.this.dismiss();
                if (av.this.f31165r == null) {
                    return;
                }
                av.this.f31165r.xt(av.this.xt);
            }
        });
        linearLayout.addView(button2);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        j jVar = this.f31165r;
        if (jVar == null) {
            return;
        }
        jVar.xt(this.xt);
    }

    public void j(j jVar) {
        this.f31165r = jVar;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        if (this.f31164j == null) {
            this.f31164j = v.getContext();
        }
        j();
    }
}
