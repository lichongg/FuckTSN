package com.bxkj.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import cn.bluemobi.dylan.base.utils.u;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyTextView extends AppCompatTextView {

    /* renamed from: c, reason: collision with root package name */
    private int f17168c;

    public MyTextView(Context context) {
        super(context);
        this.f17168c = SupportMenu.CATEGORY_MASK;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Path path = new Path();
        path.moveTo(u.a(0.0f, getContext()), u.a(0.0f, getContext()));
        path.lineTo(u.a(50.0f, getContext()), u.a(0.0f, getContext()));
        path.lineTo(u.a(50.0f, getContext()), u.a(50.0f, getContext()));
        path.close();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            int color = ((ColorDrawable) background).getColor();
            if (color != 0) {
                this.f17168c = color;
            }
            setBackgroundColor(0);
        }
        Paint paint = new Paint();
        paint.setColor(this.f17168c);
        canvas.drawPath(path, paint);
        canvas.rotate(45.0f, u.a(40.0f, getContext()), u.a(30.0f, getContext()));
        super.onDraw(canvas);
    }

    public MyTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17168c = SupportMenu.CATEGORY_MASK;
    }

    public MyTextView(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f17168c = SupportMenu.CATEGORY_MASK;
    }
}
