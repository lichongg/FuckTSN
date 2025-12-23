package com.bytedance.sdk.component.ae.j;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.r.j.j {
    @Override // com.bytedance.sdk.component.r.j.j
    public int j() {
        return 32;
    }

    @Override // com.bytedance.sdk.component.r.j.j
    public <T> String j(T t5) {
        return Base64.encodeToString(t5.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.r.j.j
    public <T> T xt(T t5) {
        return (T) new String(Base64.decode(t5.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
