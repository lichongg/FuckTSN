package com.kwad.sdk.core.imageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.core.imageloader.core.assist.LoadedFrom;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageAware;
import com.kwad.sdk.core.imageloader.core.imageaware.ImageViewAware;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class RoundedBitmapDisplayer implements BitmapDisplayer {
    protected final int cornerRadius;
    protected final int margin;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RoundedDrawable extends Drawable {
        protected final BitmapShader bitmapShader;
        protected final float cornerRadius;
        protected final RectF mBitmapRect;
        protected final RectF mRect = new RectF();
        protected final int margin;
        protected final Paint paint;

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.mRect;
            float f6 = this.cornerRadius;
            canvas.drawRoundRect(rectF, f6, f6, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i6) {
            this.paint.setAlpha(i6);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }

        public RoundedDrawable(Bitmap bitmap, int i6, int i7) {
            this.cornerRadius = i6;
            this.margin = i7;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.bitmapShader = bitmapShader;
            float f6 = i7;
            this.mBitmapRect = new RectF(f6, f6, bitmap.getWidth() - i7, bitmap.getHeight() - i7);
            Paint paint = new Paint();
            this.paint = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
            paint.setFilterBitmap(true);
            paint.setDither(true);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.mRect;
            int i6 = this.margin;
            rectF.set(i6, i6, rect.width() - this.margin, rect.height() - this.margin);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
            this.bitmapShader.setLocalMatrix(matrix);
        }
    }

    public RoundedBitmapDisplayer(int i6) {
        this(i6, 0);
    }

    public RoundedBitmapDisplayer(int i6, int i7) {
        this.cornerRadius = i6;
        this.margin = i7;
    }

    @Override // com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer
    public void display(DecodedResult decodedResult, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }
        imageAware.setImageDrawable(new RoundedDrawable(decodedResult.mBitmap, this.cornerRadius, this.margin));
    }
}
