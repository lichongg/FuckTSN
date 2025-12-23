package com.yalantis.ucrop.util;

import android.R;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i extends StateListDrawable {

    /* renamed from: a, reason: collision with root package name */
    private int f42817a;

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.StateListDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z5 = false;
        for (int i6 : iArr) {
            if (i6 == 16842913) {
                z5 = true;
            }
        }
        if (z5) {
            super.setColorFilter(this.f42817a, PorterDuff.Mode.SRC_ATOP);
        } else {
            super.clearColorFilter();
        }
        return super.onStateChange(iArr);
    }

    public i(Drawable drawable, int i6) {
        this.f42817a = i6;
        addState(new int[]{R.attr.state_selected}, drawable);
        addState(new int[0], drawable);
    }
}
