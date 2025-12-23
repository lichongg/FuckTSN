package com.bxkj.base.v2.common.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class DrawableLeftCenterButton extends AppCompatButton {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawableLeftCenterButton(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        g0.p(context, "context");
        g0.p(attrs, "attrs");
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        g0.p(canvas, "canvas");
        super.onDraw(a(canvas));
    }

    private final Canvas a(Canvas canvas) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables == null) {
            return canvas;
        }
        Drawable drawable = compoundDrawables[0];
        if (drawable == null) {
            drawable = compoundDrawables[2];
        }
        float measureText = getPaint().measureText(getText().toString()) + drawable.getIntrinsicWidth() + getCompoundDrawablePadding();
        setPadding(0, 0, (int) (getWidth() - measureText), 0);
        canvas.translate((getWidth() - measureText) / 2, 0.0f);
        return canvas;
    }
}
