package com.bytedance.sdk.component.m.cw.j.xt;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.m.w;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt implements w {
    private com.bytedance.sdk.component.m.cw.j.cw<String, Bitmap> cw;

    /* renamed from: j, reason: collision with root package name */
    private int f26572j;
    private int xt;

    @Override // com.bytedance.sdk.component.m.j
    public boolean xt(String str) {
        return this.cw.j((com.bytedance.sdk.component.m.cw.j.cw<String, Bitmap>) str) != null;
    }

    public xt(int i6, int i7) {
        this.xt = i6;
        this.f26572j = i7;
        this.cw = new com.bytedance.sdk.component.m.cw.j.cw<String, Bitmap>(i6) { // from class: com.bytedance.sdk.component.m.cw.j.xt.xt.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.sdk.component.m.cw.j.cw
            /* renamed from: j, reason: merged with bridge method [inline-methods] */
            public int xt(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return xt.j(bitmap);
            }
        };
    }

    @Override // com.bytedance.sdk.component.m.j
    public boolean j(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.cw.j(str, bitmap);
        return true;
    }

    @Override // com.bytedance.sdk.component.m.j
    public Bitmap j(String str) {
        return this.cw.j((com.bytedance.sdk.component.m.cw.j.cw<String, Bitmap>) str);
    }

    @Override // com.bytedance.sdk.component.m.j
    public void j(double d6) {
        this.cw.j((int) (this.xt * d6));
    }

    public static int j(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
