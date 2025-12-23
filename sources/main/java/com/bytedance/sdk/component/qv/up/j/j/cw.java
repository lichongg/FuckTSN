package com.bytedance.sdk.component.qv.up.j.j;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw implements com.bytedance.sdk.component.qv.up.j.j {
    @Override // com.bytedance.sdk.component.qv.up.j.j
    public Object j(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
