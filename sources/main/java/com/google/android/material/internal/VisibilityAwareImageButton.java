package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"AppCompatCustomView"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class VisibilityAwareImageButton extends ImageButton {
    private int userSetVisibility;

    public VisibilityAwareImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i6) {
        internalSetVisibility(i6, true);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.userSetVisibility = getVisibility();
    }

    public final void internalSetVisibility(int i6, boolean z5) {
        super.setVisibility(i6);
        if (z5) {
            this.userSetVisibility = i6;
        }
    }
}
