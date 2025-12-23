package com.google.android.material.internal;

import android.widget.Checkable;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.MaterialCheckable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public interface MaterialCheckable<T extends MaterialCheckable<T>> extends Checkable {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface OnCheckedChangeListener<C> {
        void onCheckedChanged(C c6, boolean z5);
    }

    @IdRes
    int getId();

    void setInternalOnCheckedChangeListener(@Nullable OnCheckedChangeListener<T> onCheckedChangeListener);
}
