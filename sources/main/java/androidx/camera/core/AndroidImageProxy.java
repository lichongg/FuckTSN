package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class AndroidImageProxy implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class PlaneProxy implements ImageProxy.PlaneProxy {
        private final Image.Plane mPlane;

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        @NonNull
        public ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getRowStride() {
            return this.mPlane.getRowStride();
        }

        PlaneProxy(Image.Plane plane) {
            this.mPlane = plane;
        }
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    @ExperimentalGetImage
    public Image getImage() {
        return this.mImage;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    @NonNull
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(@Nullable Rect rect) {
        this.mImage.setCropRect(rect);
    }

    AndroidImageProxy(@NonNull Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PlaneProxy[planes.length];
            for (int i6 = 0; i6 < planes.length; i6++) {
                this.mPlanes[i6] = new PlaneProxy(planes[i6]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create(TagBundle.emptyBundle(), image.getTimestamp(), 0, new Matrix());
    }

    @Override // androidx.camera.core.ImageProxy
    public /* synthetic */ Bitmap toBitmap() {
        return f0.a(this);
    }
}
