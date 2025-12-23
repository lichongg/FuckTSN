package com.bytedance.sdk.openadsdk.core.playable;

import com.bytedance.sdk.component.utils.m;
import java.io.File;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class r extends com.bytedance.sdk.openadsdk.core.oq.xt {
    public r(int i6, int i7) {
        super(i6, i7);
    }

    @Override // com.bytedance.sdk.openadsdk.core.oq.xt, com.bytedance.sdk.openadsdk.core.oq.j
    protected void j(List<File> list) {
        int size = list.size();
        if (!j(0L, size)) {
            for (File file : list) {
                m.cw(file);
                size--;
                if (j(file, 0L, size)) {
                    return;
                }
            }
        }
    }
}
