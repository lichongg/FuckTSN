package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.v;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j extends AlertDialog {

    /* renamed from: j, reason: collision with root package name */
    private Context f31205j;
    private String xt;

    public j(Context context, String str) {
        super(context, kt.tl(context, "tt_custom_dialog"));
        this.f31205j = context == null ? v.getContext() : context;
        this.xt = str;
    }

    private void j() {
        ((TextView) findViewById(2114387705)).setText(this.xt);
        findViewById(2114387761).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                j.this.dismiss();
            }
        });
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.up.c(getContext()));
        j();
    }
}
