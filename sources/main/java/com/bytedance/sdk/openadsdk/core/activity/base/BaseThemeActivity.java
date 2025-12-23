package com.bytedance.sdk.openadsdk.core.activity.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.tj.n;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BaseThemeActivity extends Activity {
    protected n up;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        n j6 = uf.j(getIntent());
        this.up = j6;
        if (j6 == null) {
            vl.xt("BaseLandingPageActivity", "物料为空,退出落地页!");
        } else if (j6.r() && (window = getWindow()) != null) {
            window.addFlags(512);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }
}
