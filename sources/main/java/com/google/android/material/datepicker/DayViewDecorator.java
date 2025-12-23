package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public abstract class DayViewDecorator implements Parcelable {
    @Nullable
    public ColorStateList getBackgroundColor(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableBottom(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableLeft(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableRight(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    @Nullable
    public Drawable getCompoundDrawableTop(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    @Nullable
    public ColorStateList getTextColor(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6) {
        return null;
    }

    public void initialize(@NonNull Context context) {
    }

    @Nullable
    public CharSequence getContentDescription(@NonNull Context context, int i6, int i7, int i8, boolean z5, boolean z6, @Nullable CharSequence charSequence) {
        return charSequence;
    }
}
