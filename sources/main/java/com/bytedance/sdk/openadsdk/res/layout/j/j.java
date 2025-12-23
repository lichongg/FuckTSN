package com.bytedance.sdk.openadsdk.res.layout.j;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bytedance.sdk.component.utils.kt;
import com.bytedance.sdk.openadsdk.core.rn.ed;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.openadsdk.res.layout.j {
    @Override // com.bytedance.sdk.openadsdk.res.layout.j
    public View xt(Context context) {
        Button button = new Button(context);
        button.setId(2114387735);
        button.setLayoutParams(new ViewGroup.LayoutParams(-1, ed.cw(context, 48.0f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#2A90D7"));
        button.setBackground(gradientDrawable);
        button.setText(kt.j(context, "tt_download"));
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTextSize(2, 16.0f);
        return button;
    }
}
