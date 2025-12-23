package com.tencent.open.c;

import android.content.Context;
import android.view.WindowInsets;
import android.widget.FrameLayout;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c extends FrameLayout {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        r5 = r5.getDisplayCutout();
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        r0 = r5.getBoundingRects();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.WindowInsets r5) {
        /*
            r4 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 >= r1) goto L7
            goto L42
        L7:
            if (r5 != 0) goto La
            goto L42
        La:
            android.view.DisplayCutout r5 = androidx.core.view.x1.a(r5)
            if (r5 != 0) goto L11
            goto L42
        L11:
            java.util.List r0 = com.tencent.open.c.e.a(r5)
            if (r0 == 0) goto L42
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1e
            goto L42
        L1e:
            int r0 = com.bytedance.sdk.openadsdk.core.i.j.e.a(r5)
            r1 = 0
            int r0 = java.lang.Math.max(r0, r1)
            int r2 = com.bytedance.sdk.openadsdk.core.i.j.c.a(r5)
            int r2 = java.lang.Math.max(r2, r1)
            int r3 = com.bytedance.sdk.openadsdk.core.i.j.k.a(r5)
            int r3 = java.lang.Math.max(r3, r1)
            int r5 = com.bytedance.sdk.openadsdk.core.i.j.d.a(r5)
            int r5 = java.lang.Math.max(r5, r1)
            r4.setPadding(r0, r2, r3, r5)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.c.c.a(android.view.WindowInsets):void");
    }

    public c(Context context) {
        super(context);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        a(windowInsets);
        return super.onApplyWindowInsets(windowInsets);
    }
}
