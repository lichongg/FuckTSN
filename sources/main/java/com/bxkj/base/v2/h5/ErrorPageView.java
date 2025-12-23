package com.bxkj.base.v2.h5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.R;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class ErrorPageView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ErrorPageView(@Nullable Context context, @NotNull final SmartWebView smartWebView) {
        super(context);
        g0.p(smartWebView, "smartWebView");
        ((Button) LayoutInflater.from(context).inflate(R.layout.ac_error_page, this).findViewById(R.id.bt_refresh)).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.h5.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorPageView.b(SmartWebView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SmartWebView smartWebView, View view) {
        smartWebView.l();
    }
}
