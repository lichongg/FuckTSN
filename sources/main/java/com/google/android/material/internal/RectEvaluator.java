package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: D:\Downloads\app\classes5.dex */
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f6, @NonNull Rect rect, @NonNull Rect rect2) {
        this.rect.set(rect.left + ((int) ((rect2.left - r0) * f6)), rect.top + ((int) ((rect2.top - r1) * f6)), rect.right + ((int) ((rect2.right - r2) * f6)), rect.bottom + ((int) ((rect2.bottom - r6) * f6)));
        return this.rect;
    }

    public RectEvaluator(@NonNull Rect rect) {
        this.rect = rect;
    }
}
