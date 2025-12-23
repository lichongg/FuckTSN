package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.dislike.ui.r;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import com.bytedance.sdk.openadsdk.widget.TTDislikeLayout;
import com.bytedance.sdk.openadsdk.widget.TTDislikeScrollListView;
import java.util.ArrayList;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw extends Dialog {
    private final com.bytedance.sdk.openadsdk.core.dislike.cw.xt cw;

    /* renamed from: j, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.dislike.xt.cw f28882j;

    /* renamed from: r, reason: collision with root package name */
    private boolean f28883r;
    private TextView up;
    private TTDislikeLayout xt;

    private void xt() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setDimAmount(0.34f);
        }
    }

    public cw(Context context, com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        super(context);
        this.f28883r = false;
        getWindow().addFlags(1024);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.cw = xtVar;
    }

    private void cw() {
        TTDislikeLayout tTDislikeLayout = (TTDislikeLayout) findViewById(2047279103);
        this.xt = tTDislikeLayout;
        j(tTDislikeLayout);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.bytedance.sdk.openadsdk.core.dislike.xt.cw cwVar = this.f28882j;
        if (cwVar != null && !this.f28883r) {
            cwVar.cw();
        }
    }

    public void j(com.bytedance.sdk.openadsdk.core.dislike.xt.cw cwVar) {
        this.f28882j = cwVar;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        setContentView(com.bytedance.sdk.openadsdk.res.r.j(getContext()), j());
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        xt();
        cw();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.f28883r = false;
            com.bytedance.sdk.openadsdk.core.dislike.xt.cw cwVar = this.f28882j;
            if (cwVar != null) {
                cwVar.xt();
            }
        } catch (Exception unused) {
        }
    }

    public ViewGroup.LayoutParams j() {
        return new ViewGroup.LayoutParams(com.bytedance.sdk.openadsdk.core.dislike.j.j.xt().j(getContext(), 345.0f), -2);
    }

    public void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        TTDislikeLayout tTDislikeLayout;
        if (xtVar == null || (tTDislikeLayout = this.xt) == null) {
            return;
        }
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) tTDislikeLayout.findViewById(2047279097);
        r rVar = (r) tTDislikeScrollListView.getAdapter();
        if (rVar != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.j.xt(xtVar));
            rVar.j(xtVar.j());
        }
    }

    private void j(View view) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(2047279095);
        this.up = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.cw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (cw.this.f28882j != null) {
                    cw.this.f28882j.j();
                }
                cw.this.dismiss();
            }
        });
        TTDislikeScrollListView tTDislikeScrollListView = (TTDislikeScrollListView) view.findViewById(2047279097);
        tTDislikeScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.cw.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i6, long j6) {
                try {
                    if (cw.this.f28882j != null) {
                        cw.this.f28882j.j(i6, cw.this.cw.j().get(i6));
                        cw.this.f28883r = true;
                    }
                    cw.this.dismiss();
                } catch (Throwable unused) {
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar = this.cw;
        r rVar = new r(getContext(), xtVar == null ? new ArrayList<>(0) : xtVar.j());
        rVar.j(new r.j() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.cw.3
            @Override // com.bytedance.sdk.openadsdk.core.dislike.ui.r.j
            public void j(int i6, m mVar) {
                if (cw.this.f28882j != null) {
                    cw.this.f28882j.j(i6, mVar);
                    cw.this.f28883r = true;
                }
                cw.this.dismiss();
                com.bytedance.sdk.openadsdk.core.dislike.j.j.j().j(cw.this.cw, mVar);
            }
        });
        tTDislikeScrollListView.setAdapter((ListAdapter) rVar);
        com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar2 = this.cw;
        if (xtVar2 != null) {
            tTDislikeScrollListView.setDislikeController(new com.bytedance.sdk.openadsdk.core.dislike.j.xt(xtVar2));
        }
    }

    public void j(String str) {
        TextView textView = this.up;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
