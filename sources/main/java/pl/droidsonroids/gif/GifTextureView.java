package pl.droidsonroids.gif;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.lang.ref.WeakReference;
import pl.droidsonroids.gif.k;
import pl.droidsonroids.gif.l;
import xyz.adscope.common.v2.dev.info.ResIdentify;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class GifTextureView extends TextureView {

    /* renamed from: g, reason: collision with root package name */
    private static final ImageView.ScaleType[] f51780g = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a, reason: collision with root package name */
    private ImageView.ScaleType f51781a;

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f51782b;

    /* renamed from: c, reason: collision with root package name */
    private l f51783c;

    /* renamed from: d, reason: collision with root package name */
    private c f51784d;

    /* renamed from: e, reason: collision with root package name */
    private float f51785e;

    /* renamed from: f, reason: collision with root package name */
    private k.b f51786f;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void a(Canvas canvas);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class c extends Thread implements TextureView.SurfaceTextureListener {

        /* renamed from: a, reason: collision with root package name */
        final pl.droidsonroids.gif.c f51788a;

        /* renamed from: b, reason: collision with root package name */
        private GifInfoHandle f51789b;

        /* renamed from: c, reason: collision with root package name */
        private IOException f51790c;

        /* renamed from: d, reason: collision with root package name */
        long[] f51791d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<GifTextureView> f51792e;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GifTextureView f51793a;

            a(GifTextureView gifTextureView) {
                this.f51793a = gifTextureView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f51793a.i(c.this.f51789b);
            }
        }

        c(GifTextureView gifTextureView) {
            super("GifRenderThread");
            this.f51788a = new pl.droidsonroids.gif.c();
            this.f51789b = new GifInfoHandle();
            this.f51792e = new WeakReference<>(gifTextureView);
        }

        void c(@NonNull GifTextureView gifTextureView, @Nullable b bVar) {
            this.f51788a.b();
            gifTextureView.setSuperSurfaceTextureListener(bVar != null ? new p(bVar) : null);
            this.f51789b.z();
            interrupt();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i6, int i7) {
            GifTextureView gifTextureView = this.f51792e.get();
            if (gifTextureView != null) {
                gifTextureView.i(this.f51789b);
            }
            this.f51788a.c();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f51788a.b();
            this.f51789b.z();
            interrupt();
            return true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                GifTextureView gifTextureView = this.f51792e.get();
                if (gifTextureView == null) {
                    return;
                }
                GifInfoHandle c6 = gifTextureView.f51783c.c();
                this.f51789b = c6;
                c6.K((char) 1, gifTextureView.isOpaque());
                if (gifTextureView.f51786f.f51841b >= 0) {
                    this.f51789b.J(gifTextureView.f51786f.f51841b);
                }
                GifTextureView gifTextureView2 = this.f51792e.get();
                if (gifTextureView2 == null) {
                    this.f51789b.A();
                    return;
                }
                gifTextureView2.setSuperSurfaceTextureListener(this);
                boolean isAvailable = gifTextureView2.isAvailable();
                this.f51788a.d(isAvailable);
                if (isAvailable) {
                    gifTextureView2.post(new a(gifTextureView2));
                }
                this.f51789b.L(gifTextureView2.f51785e);
                while (!isInterrupted()) {
                    try {
                        this.f51788a.a();
                        GifTextureView gifTextureView3 = this.f51792e.get();
                        if (gifTextureView3 == null) {
                            break;
                        }
                        SurfaceTexture surfaceTexture = gifTextureView3.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.f51789b.a(surface, this.f51791d);
                            } finally {
                                surface.release();
                            }
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                this.f51789b.A();
                this.f51789b = new GifInfoHandle();
            } catch (IOException e6) {
                this.f51790c = e6;
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i6, int i7) {
        }
    }

    public GifTextureView(Context context) {
        super(context);
        this.f51781a = ImageView.ScaleType.FIT_CENTER;
        this.f51782b = new Matrix();
        this.f51785e = 1.0f;
        g(null, 0, 0);
    }

    private void g(AttributeSet attributeSet, int i6, int i7) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = f51780g;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.f51781a = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.GifTextureView, i6, i7);
            this.f51783c = f(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(R.styleable.GifTextureView_isOpaque, false));
            obtainStyledAttributes.recycle();
            this.f51786f = new k.b(this, attributeSet, i6, i7);
        } else {
            super.setOpaque(false);
            this.f51786f = new k.b();
        }
        if (isInEditMode()) {
            return;
        }
        c cVar = new c(this);
        this.f51784d = cVar;
        if (this.f51783c != null) {
            cVar.start();
        }
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    public synchronized void h(@Nullable l lVar, @Nullable b bVar) {
        this.f51784d.c(this, bVar);
        try {
            this.f51784d.join();
        } catch (InterruptedException e6) {
            e6.printStackTrace();
        }
        this.f51783c = lVar;
        c cVar = new c(this);
        this.f51784d = cVar;
        if (lVar != null) {
            cVar.start();
        }
    }

    public synchronized void setInputSource(@Nullable l lVar) {
        h(lVar, null);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f51787a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f51787a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51787a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f51787a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f51787a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f51787a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f51787a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f51787a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f51787a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private static l f(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(R.styleable.GifTextureView_gifSource, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (k.f51837b.contains(resourceTypeName)) {
                return new l.i(typedArray.getResources(), typedValue.resourceId);
            }
            if (!ResIdentify.RES_TYPE_STRING.equals(resourceTypeName)) {
                throw new IllegalArgumentException("Expected string, drawable, mipmap or raw resource type. '" + resourceTypeName + "' is not supported");
            }
        }
        return new l.c(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float q5 = gifInfoHandle.q() / width;
        float i6 = gifInfoHandle.i() / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.q(), gifInfoHandle.i());
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        switch (a.f51787a[this.f51781a.ordinal()]) {
            case 1:
                matrix.setScale(q5, i6, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(q5, i6);
                matrix.setScale(q5 * min, min * i6, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float min2 = (((float) gifInfoHandle.q()) > width || ((float) gifInfoHandle.i()) > height) ? Math.min(1.0f / q5, 1.0f / i6) : 1.0f;
                matrix.setScale(q5 * min2, min2 * i6, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(q5, i6);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(q5, i6);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(q5, i6);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.f51782b);
                matrix.preScale(q5, i6);
                break;
        }
        super.setTransform(matrix);
    }

    @Nullable
    public IOException getIOException() {
        return this.f51784d.f51790c != null ? this.f51784d.f51790c : GifIOException.fromCode(this.f51784d.f51789b.l());
    }

    public ImageView.ScaleType getScaleType() {
        return this.f51781a;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.f51782b);
        return matrix;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f51784d.c(this, null);
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.f51784d.f51791d = gifViewSavedState.f51795a[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        c cVar = this.f51784d;
        cVar.f51791d = cVar.f51789b.o();
        return new GifViewSavedState(super.onSaveInstanceState(), this.f51786f.f51840a ? this.f51784d.f51791d : null);
    }

    public void setFreezesAnimation(boolean z5) {
        this.f51786f.f51840a = z5;
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
        this.f51781a = scaleType;
        i(this.f51784d.f51789b);
    }

    public void setSpeed(@FloatRange(from = 0.0d, fromInclusive = false) float f6) {
        this.f51785e = f6;
        this.f51784d.f51789b.L(f6);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.f51782b.set(matrix);
        i(this.f51784d.f51789b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSuperSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z5) {
        if (z5 != isOpaque()) {
            super.setOpaque(z5);
            setInputSource(this.f51783c);
        }
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f51781a = ImageView.ScaleType.FIT_CENTER;
        this.f51782b = new Matrix();
        this.f51785e = 1.0f;
        g(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f51781a = ImageView.ScaleType.FIT_CENTER;
        this.f51782b = new Matrix();
        this.f51785e = 1.0f;
        g(attributeSet, i6, 0);
    }

    @RequiresApi(21)
    public GifTextureView(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
        this.f51781a = ImageView.ScaleType.FIT_CENTER;
        this.f51782b = new Matrix();
        this.f51785e = 1.0f;
        g(attributeSet, i6, i7);
    }
}
