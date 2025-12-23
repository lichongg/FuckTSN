package androidx.camera.core;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
final class ImageProxyDownsampler {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    enum DownsamplingMethod {
        NEAREST_NEIGHBOR,
        AVERAGING
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static final class ForwardingImageProxyImpl extends ForwardingImageProxy {
        private final int mDownsampledHeight;
        private final ImageProxy.PlaneProxy[] mDownsampledPlanes;
        private final int mDownsampledWidth;

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getHeight() {
            return this.mDownsampledHeight;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        @NonNull
        public ImageProxy.PlaneProxy[] getPlanes() {
            return this.mDownsampledPlanes;
        }

        @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
        public int getWidth() {
            return this.mDownsampledWidth;
        }

        ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy.PlaneProxy[] planeProxyArr, int i6, int i7) {
            super(imageProxy);
            this.mDownsampledPlanes = planeProxyArr;
            this.mDownsampledWidth = i6;
            this.mDownsampledHeight = i7;
        }
    }

    private static void resizeNearestNeighbor(ByteBuffer byteBuffer, int i6, int i7, int i8, int i9, byte[] bArr, int i10, int i11) {
        float f6 = i6 / i10;
        float f7 = i9 / i11;
        byte[] bArr2 = new byte[i8];
        int[] iArr = new int[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            iArr[i12] = ((int) (i12 * f6)) * i7;
        }
        synchronized (byteBuffer) {
            try {
                byteBuffer.rewind();
                for (int i13 = 0; i13 < i11; i13++) {
                    int i14 = i13 * i10;
                    byteBuffer.position(Math.min((int) (i13 * f7), i9 - 1) * i8);
                    byteBuffer.get(bArr2, 0, Math.min(i8, byteBuffer.remaining()));
                    for (int i15 = 0; i15 < i10; i15++) {
                        bArr[i14 + i15] = bArr2[iArr[i15]];
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.camera.core.ImageProxyDownsampler$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod;

        static {
            int[] iArr = new int[DownsamplingMethod.values().length];
            $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod = iArr;
            try {
                iArr[DownsamplingMethod.NEAREST_NEIGHBOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[DownsamplingMethod.AVERAGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(int i6, int i7, byte[] bArr) {
        return new ImageProxy.PlaneProxy(bArr, i6, i7) { // from class: androidx.camera.core.ImageProxyDownsampler.1
            final ByteBuffer mBuffer;
            final /* synthetic */ byte[] val$data;
            final /* synthetic */ int val$pixelStride;
            final /* synthetic */ int val$rowStride;

            {
                this.val$data = bArr;
                this.val$rowStride = i6;
                this.val$pixelStride = i7;
                this.mBuffer = ByteBuffer.wrap(bArr);
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            @NonNull
            public ByteBuffer getBuffer() {
                return this.mBuffer;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return this.val$pixelStride;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return this.val$rowStride;
            }
        };
    }

    static ForwardingImageProxy downsample(ImageProxy imageProxy, int i6, int i7, DownsamplingMethod downsamplingMethod) {
        byte[] bArr;
        int i8;
        byte[] bArr2;
        if (imageProxy.getFormat() != 35) {
            throw new UnsupportedOperationException("Only YUV_420_888 format is currently supported.");
        }
        if (imageProxy.getWidth() < i6 || imageProxy.getHeight() < i7) {
            throw new IllegalArgumentException("Downsampled dimension " + new Size(i6, i7) + " is not <= original dimension " + new Size(imageProxy.getWidth(), imageProxy.getHeight()) + ".");
        }
        if (imageProxy.getWidth() == i6 && imageProxy.getHeight() == i7) {
            return new ForwardingImageProxyImpl(imageProxy, imageProxy.getPlanes(), i6, i7);
        }
        int[] iArr = {imageProxy.getWidth(), imageProxy.getWidth() / 2, imageProxy.getWidth() / 2};
        int[] iArr2 = {imageProxy.getHeight(), imageProxy.getHeight() / 2, imageProxy.getHeight() / 2};
        int i9 = i6 / 2;
        int[] iArr3 = {i6, i9, i9};
        int i10 = i7 / 2;
        int[] iArr4 = {i7, i10, i10};
        ImageProxy.PlaneProxy[] planeProxyArr = new ImageProxy.PlaneProxy[3];
        for (int i11 = 0; i11 < 3; i11++) {
            ImageProxy.PlaneProxy planeProxy = imageProxy.getPlanes()[i11];
            ByteBuffer buffer = planeProxy.getBuffer();
            byte[] bArr3 = new byte[iArr3[i11] * iArr4[i11]];
            int i12 = AnonymousClass2.$SwitchMap$androidx$camera$core$ImageProxyDownsampler$DownsamplingMethod[downsamplingMethod.ordinal()];
            if (i12 == 1) {
                bArr = bArr3;
                int i13 = iArr[i11];
                int pixelStride = planeProxy.getPixelStride();
                int rowStride = planeProxy.getRowStride();
                i8 = 1;
                resizeNearestNeighbor(buffer, i13, pixelStride, rowStride, iArr2[i11], bArr, iArr3[i11], iArr4[i11]);
            } else if (i12 != 2) {
                bArr2 = bArr3;
                i8 = 1;
                planeProxyArr[i11] = createPlaneProxy(iArr3[i11], i8, bArr2);
            } else {
                bArr = bArr3;
                int i14 = iArr[i11];
                int pixelStride2 = planeProxy.getPixelStride();
                int rowStride2 = planeProxy.getRowStride();
                i8 = 1;
                resizeAveraging(buffer, i14, pixelStride2, rowStride2, iArr2[i11], bArr, iArr3[i11], iArr4[i11]);
            }
            bArr2 = bArr;
            planeProxyArr[i11] = createPlaneProxy(iArr3[i11], i8, bArr2);
        }
        return new ForwardingImageProxyImpl(imageProxy, planeProxyArr, i6, i7);
    }

    private static void resizeAveraging(ByteBuffer byteBuffer, int i6, int i7, int i8, int i9, byte[] bArr, int i10, int i11) {
        float f6 = i6 / i10;
        float f7 = i9 / i11;
        byte[] bArr2 = new byte[i8];
        byte[] bArr3 = new byte[i8];
        int[] iArr = new int[i10];
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            iArr[i13] = ((int) (i13 * f6)) * i7;
        }
        synchronized (byteBuffer) {
            try {
                byteBuffer.rewind();
                int i14 = 0;
                while (i14 < i11) {
                    int i15 = (int) (i14 * f7);
                    int i16 = i9 - 1;
                    int min = Math.min(i15, i16) * i8;
                    int min2 = Math.min(i15 + 1, i16) * i8;
                    int i17 = i14 * i10;
                    byteBuffer.position(min);
                    byteBuffer.get(bArr2, i12, Math.min(i8, byteBuffer.remaining()));
                    byteBuffer.position(min2);
                    byteBuffer.get(bArr3, i12, Math.min(i8, byteBuffer.remaining()));
                    for (int i18 = 0; i18 < i10; i18++) {
                        int i19 = iArr[i18];
                        bArr[i17 + i18] = (byte) ((((((bArr2[i19] & 255) + (bArr2[i19 + i7] & 255)) + (bArr3[i19] & 255)) + (bArr3[i19 + i7] & 255)) / 4) & 255);
                    }
                    i14++;
                    i12 = 0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ImageProxyDownsampler() {
    }
}
