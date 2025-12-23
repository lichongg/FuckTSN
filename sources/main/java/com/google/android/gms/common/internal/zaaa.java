package com.google.android.gms.common.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.common.util.DeviceProperties;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class zaaa extends Button {
    public zaaa(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, R.attr.buttonStyle);
    }

    private static final int zab(int i6, int i7, int i8, int i9) {
        if (i6 == 0) {
            return i7;
        }
        if (i6 == 1) {
            return i8;
        }
        if (i6 == 2) {
            return i9;
        }
        throw new IllegalStateException("Unknown color scheme: " + i6);
    }

    public final void zaa(Resources resources, int i6, int i7) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i8 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i8);
        setMinWidth(i8);
        int i9 = com.bjtsn.pose_detection.R.drawable.common_google_signin_btn_icon_dark;
        int i10 = com.bjtsn.pose_detection.R.drawable.common_google_signin_btn_icon_light;
        int zab = zab(i7, i9, i10, i10);
        int i11 = com.bjtsn.pose_detection.R.drawable.common_google_signin_btn_text_dark;
        int i12 = com.bjtsn.pose_detection.R.drawable.common_google_signin_btn_text_light;
        int zab2 = zab(i7, i11, i12, i12);
        if (i6 == 0 || i6 == 1) {
            zab = zab2;
        } else if (i6 != 2) {
            throw new IllegalStateException("Unknown button size: " + i6);
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(zab));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(com.bjtsn.pose_detection.R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i13 = com.bjtsn.pose_detection.R.color.common_google_signin_btn_text_dark;
        int i14 = com.bjtsn.pose_detection.R.color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i7, i13, i14, i14))));
        if (i6 == 0) {
            setText(resources.getString(com.bjtsn.pose_detection.R.string.common_signin_button_text));
        } else if (i6 == 1) {
            setText(resources.getString(com.bjtsn.pose_detection.R.string.common_signin_button_text_long));
        } else {
            if (i6 != 2) {
                throw new IllegalStateException("Unknown button size: " + i6);
            }
            setText((CharSequence) null);
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
