package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;

/* loaded from: D:\Downloads\app\classes4.dex */
public class BookPageView extends View {
    Point ae;
    Point cw;

    /* renamed from: j, reason: collision with root package name */
    Paint f25875j;

    /* renamed from: m, reason: collision with root package name */
    Point f25876m;

    /* renamed from: r, reason: collision with root package name */
    Point f25877r;
    Point up;
    Paint xt;

    public void j(Point point) {
        Point point2 = this.cw;
        point2.x = point.x;
        point2.y = point.y;
        invalidate();
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        Point point = this.f25877r;
        path.moveTo(point.x, point.y);
        Point point2 = this.f25876m;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.ae;
        path.lineTo(point3.x, point3.y);
        path.close();
        return path;
    }

    public BookPageView(Context context) {
        super(context);
        this.f25875j = new Paint();
        this.xt = new Paint();
        this.cw = new Point();
        this.f25877r = new Point();
        this.up = new Point();
        this.f25876m = new Point();
        this.ae = new Point();
        this.f25875j.setColor(-16711936);
        this.f25875j.setTextSize(25.0f);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView.this.cw.x = r0.getWidth() - 10;
                BookPageView.this.cw.y = r0.getHeight() - 10;
                BookPageView.this.xt.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.xt.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.xt.setStrokeWidth(6.0f);
                BookPageView.this.xt.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        j();
        Path path = new Path();
        Point point = this.f25876m;
        path.moveTo(point.x, point.y);
        Point point2 = this.cw;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.ae;
        path.lineTo(point3.x, point3.y);
        path.close();
        canvas.drawPath(path, this.xt);
    }

    private void j() {
        this.f25877r.x = getWidth();
        this.f25877r.y = getHeight();
        Point point = this.up;
        Point point2 = this.cw;
        int i6 = point2.x;
        Point point3 = this.f25877r;
        int i7 = (i6 + point3.x) / 2;
        point.x = i7;
        int i8 = (point2.y + point3.y) / 2;
        point.y = i8;
        Point point4 = this.f25876m;
        int i9 = point3.y;
        point4.x = i7 - (((i9 - i8) * (i9 - i8)) / (point3.x - i7));
        point4.y = i9;
        Point point5 = this.ae;
        point5.x = point3.x;
        int i10 = point.y;
        int i11 = point3.x;
        int i12 = point.x;
        point5.y = i10 - (((i11 - i12) * (i11 - i12)) / (point3.y - i10));
    }
}
