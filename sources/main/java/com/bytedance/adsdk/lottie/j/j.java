package com.bytedance.adsdk.lottie.j;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.os.LocaleList;
import com.bytedance.adsdk.lottie.up.tl;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j extends Paint {
    public j() {
    }

    public j(int i6) {
        super(i6);
    }

    @Override // android.graphics.Paint
    public void setAlpha(int i6) {
        if (Build.VERSION.SDK_INT >= 29) {
            super.setAlpha(tl.j(i6, 0, 255));
        } else {
            setColor((tl.j(i6, 0, 255) << 24) | (getColor() & 16777215));
        }
    }

    public j(PorterDuff.Mode mode) {
        setXfermode(new PorterDuffXfermode(mode));
    }

    public j(int i6, PorterDuff.Mode mode) {
        super(i6);
        setXfermode(new PorterDuffXfermode(mode));
    }

    @Override // android.graphics.Paint
    public void setTextLocales(LocaleList localeList) {
    }
}
