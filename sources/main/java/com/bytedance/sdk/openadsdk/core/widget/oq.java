package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq extends AlertDialog {
    private String ae;
    private Button cw;

    /* renamed from: g, reason: collision with root package name */
    private String f31229g;

    /* renamed from: j, reason: collision with root package name */
    private TextView f31230j;

    /* renamed from: m, reason: collision with root package name */
    private String f31231m;
    private Drawable oq;
    private j qv;

    /* renamed from: r, reason: collision with root package name */
    private Button f31232r;
    private String tl;
    private Context up;
    private TextView xt;

    public interface j {
        void onClickNo(Dialog dialog);

        void onClickYes(Dialog dialog);
    }

    private void xt() {
        TextView textView = this.f31230j;
        if (textView != null) {
            textView.setText(this.f31231m);
            Drawable drawable = this.oq;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.oq.getIntrinsicHeight();
                int cw = ed.cw(this.up, 45.0f);
                if (intrinsicWidth > cw || intrinsicWidth < cw) {
                    intrinsicWidth = cw;
                }
                if (intrinsicHeight > cw || intrinsicHeight < cw) {
                    intrinsicHeight = cw;
                }
                this.oq.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f31230j.setCompoundDrawables(this.oq, null, null, null);
                this.f31230j.setCompoundDrawablePadding(ed.cw(this.up, 10.0f));
            }
        }
        TextView textView2 = this.xt;
        if (textView2 != null) {
            textView2.setText(this.ae);
        }
        Button button = this.cw;
        if (button != null) {
            button.setText(this.tl);
        }
        Button button2 = this.f31232r;
        if (button2 != null) {
            button2.setText(this.f31229g);
        }
    }

    public oq(Context context) {
        super(context, kt.tl(context, "tt_custom_dialog"));
        this.up = context;
    }

    private void j() {
        this.f31230j = (TextView) findViewById(2114387858);
        this.xt = (TextView) findViewById(2114387660);
        this.cw = (Button) findViewById(2114387757);
        this.f31232r = (Button) findViewById(2114387895);
        this.cw.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.oq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oq.this.dismiss();
                if (oq.this.qv != null) {
                    oq.this.qv.onClickYes(oq.this);
                }
            }
        });
        this.f31232r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.oq.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                oq.this.dismiss();
                if (oq.this.qv != null) {
                    oq.this.qv.onClickNo(oq.this);
                }
            }
        });
    }

    public oq cw(String str) {
        this.tl = str;
        return this;
    }

    public oq r(String str) {
        this.f31229g = str;
        return this;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.up.sm(this.up));
        setCanceledOnTouchOutside(true);
        j();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        xt();
    }

    public oq j(String str) {
        this.f31231m = str;
        return this;
    }

    public oq j(Drawable drawable) {
        this.oq = drawable;
        return this;
    }

    public oq j(j jVar) {
        this.qv = jVar;
        return this;
    }

    public oq j(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public oq xt(String str) {
        this.ae = str;
        return this;
    }
}
