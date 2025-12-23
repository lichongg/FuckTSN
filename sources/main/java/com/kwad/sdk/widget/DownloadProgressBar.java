package com.kwad.sdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class DownloadProgressBar extends View {
    Paint bcV;
    Paint bcW;
    Paint bcX;
    private String bcY;
    private float bcZ;
    private Rect bda;
    private LinearGradient bdb;
    private LinearGradient bdc;
    private LinearGradient bdd;
    private Runnable bde;
    private Matrix mMatrix;
    private Path mPath;
    private RectF mRectF;
    private long mStartTime;

    public DownloadProgressBar(Context context) {
        this(context, null, 0);
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i6, int i7, int i8, int i9) {
        super.onSizeChanged(i6, i7, i8, i9);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.bdb = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{1291525714, 1291569420}, new float[]{0.0f, 1.0f}, tileMode);
        this.bdc = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{-319918, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.bcV.setShader(this.bdb);
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{16501004, -276212}, new float[]{0.0f, 1.0f}, tileMode);
        this.bdd = linearGradient;
        this.bcW.setShader(linearGradient);
        float f6 = i6;
        this.mRectF.set(0.0f, 0.0f, f6, i7);
        this.mPath.reset();
        float f7 = f6 / 2.0f;
        this.mPath.addRoundRect(this.mRectF, f7, f7, Path.Direction.CW);
    }

    public void setProgress(float f6) {
        this.bcZ = f6;
        invalidate();
        if (f6 == 0.0f || f6 == 100.0f) {
            removeCallbacks(this.bde);
        } else if (getWindowVisibility() == 0 && this.mStartTime == 0) {
            post(this.bde);
        }
    }

    public void setText(String str) {
        this.bcY = str;
        invalidate();
    }

    public DownloadProgressBar(Context context, @Nullable AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.bde = new Runnable() { // from class: com.kwad.sdk.widget.DownloadProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                DownloadProgressBar.this.invalidate();
                if (DownloadProgressBar.this.getWindowVisibility() == 0) {
                    DownloadProgressBar.this.postDelayed(this, 34L);
                }
            }
        };
        this.bcV = new Paint(1);
        this.bcW = new Paint(1);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.bcX = paint;
        paint.setTextSize(com.kwad.sdk.c.a.a.a(context, 16.0f));
        this.bcX.setColor(-1);
        this.bcX.setTextAlign(Paint.Align.CENTER);
        this.bda = new Rect();
        this.mMatrix = new Matrix();
        this.mPath = new Path();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.bde);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f6;
        super.onDraw(canvas);
        canvas.clipPath(this.mPath);
        this.bcV.setShader(this.bdb);
        canvas.drawRect(this.mRectF, this.bcV);
        this.bcV.setShader(this.bdc);
        canvas.drawRect(0.0f, 0.0f, (getWidth() * this.bcZ) / 100.0f, getHeight(), this.bcV);
        float f7 = this.bcZ;
        float f8 = 0.0f;
        if (f7 > 0.0f && f7 < 100.0f) {
            long elapsedRealtime = (SystemClock.elapsedRealtime() - this.mStartTime) % 2500;
            if (elapsedRealtime >= 1500) {
                f6 = 0.0f;
            } else {
                f6 = elapsedRealtime / 1500.0f;
            }
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f6);
            this.bdd.setLocalMatrix(this.mMatrix);
            this.bcW.setShader(this.bdd);
            canvas.drawRect(0.0f, 0.0f, ((getWidth() * this.bcZ) / 100.0f) * f6, getHeight(), this.bcW);
            if (elapsedRealtime > 500 && elapsedRealtime <= 1500) {
                f8 = (elapsedRealtime - 500) / 1000.0f;
            }
            float width = ((getWidth() * this.bcZ) / 100.0f) * f8;
            this.mMatrix.reset();
            this.mMatrix.setScale(1.0f, f6);
            this.bdd.setLocalMatrix(this.mMatrix);
            this.bcW.setShader(this.bdd);
            canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.bcW);
        }
        String str = this.bcY;
        if (str != null) {
            this.bcX.getTextBounds(str, 0, str.length(), this.bda);
            Rect rect = this.bda;
            canvas.drawText(this.bcY, getWidth() / 2.0f, (getHeight() / 2.0f) - ((rect.top + rect.bottom) / 2.0f), this.bcX);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i6) {
        super.onVisibilityChanged(view, i6);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i6) {
        super.onWindowVisibilityChanged(i6);
        if (i6 == 0) {
            float f6 = this.bcZ;
            if (f6 > 0.0f && f6 < 100.0f) {
                this.mStartTime = SystemClock.elapsedRealtime();
                post(this.bde);
                return;
            }
            return;
        }
        removeCallbacks(this.bde);
    }
}
