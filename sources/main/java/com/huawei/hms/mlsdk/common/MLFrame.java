package com.huawei.hms.mlsdk.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import com.huawei.hms.ml.common.utils.ImageConvertUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class MLFrame {
    public static final int SCREEN_FIRST_QUADRANT = 0;
    public static final int SCREEN_FOURTH_QUADRANT = 3;
    public static final int SCREEN_SECOND_QUADRANT = 1;
    public static final int SCREEN_THIRD_QUADRANT = 2;
    private Bitmap bitmap;
    private ByteBuffer byteBuffer;
    private byte[] bytes;
    private volatile Boolean frameInit;
    private Property property;
    private int recMode;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.mlsdk.common.MLFrame$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Creator {
        private MLFrame frame = new MLFrame();

        public MLFrame create() {
            if (this.frame.byteBuffer == null && this.frame.bitmap == null) {
                throw new IllegalStateException("Failed to create image instance, both bitmap and byteBuffer data are not specified.");
            }
            return this.frame;
        }

        public Creator setFramePropertyExt(Property.Ext ext) {
            this.frame.acquireProperty().ext = ext;
            return this;
        }

        public Creator setItemIdentity(int i6) {
            this.frame.acquireProperty().itemIdentity = i6;
            return this;
        }

        public Creator setQuadrant(int i6) {
            this.frame.acquireProperty().quadrant = i6;
            return this;
        }

        public Creator setTimestamp(long j6) {
            this.frame.acquireProperty().timestamp = j6;
            return this;
        }

        public Creator writeByteBufferData(ByteBuffer byteBuffer, int i6, int i7, int i8) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Parameter： data is not specified");
            }
            if (byteBuffer.capacity() < i6 * i7) {
                throw new IllegalArgumentException("Not enough capacity for image data size.");
            }
            if (i8 != 17 && i8 != 16 && i8 != 842094169) {
                throw new IllegalArgumentException("Parameter formatType:" + i8 + " is not supported");
            }
            this.frame.byteBuffer = byteBuffer;
            Property acquireProperty = this.frame.acquireProperty();
            if (acquireProperty != null) {
                acquireProperty.formatType = i8;
                acquireProperty.width = i6;
                acquireProperty.height = i7;
            }
            return this;
        }

        public Creator setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            this.frame.bitmap = bitmap;
            Property acquireProperty = this.frame.acquireProperty();
            acquireProperty.width = width;
            acquireProperty.height = height;
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Property {
        public static final int IMAGE_FORMAT_NV21 = 17;
        public static final int IMAGE_FORMAT_YV12 = 842094169;
        public static final int SCREEN_FIRST_QUADRANT = 0;
        public static final int SCREEN_FOURTH_QUADRANT = 3;
        public static final int SCREEN_SECOND_QUADRANT = 1;
        public static final int SCREEN_THIRD_QUADRANT = 2;
        private Ext ext;
        private int formatType;
        private int height;
        private int itemIdentity;
        private int quadrant;
        private long timestamp;
        private int width;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class Creator {
            private Ext ext;
            private int formatType;
            private int height;
            private int itemIdentity;
            private int quadrant;
            private long timestamp;
            private int width;

            public Creator setTimestamp(int i6) {
                this.timestamp = i6;
                return this;
            }

            public Property create() {
                return new Property(this.width, this.height, this.quadrant, this.formatType, this.itemIdentity, this.timestamp, this.ext, null);
            }

            public Creator setExt(Ext ext) {
                this.ext = ext;
                return this;
            }

            public Creator setFormatType(int i6) {
                this.formatType = i6;
                return this;
            }

            public Creator setHeight(int i6) {
                this.height = i6;
                return this;
            }

            public Creator setItemIdentity(int i6) {
                this.itemIdentity = i6;
                return this;
            }

            public Creator setQuadrant(int i6) {
                this.quadrant = i6;
                return this;
            }

            public Creator setWidth(int i6) {
                this.width = i6;
                return this;
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        public static class Ext {
            private int lensId;
            private int maxZoom;
            private Rect rect;
            private int zoom;

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            public static class Creator {
                private int maxZoom;
                private Rect rect;
                private int lensId = 0;
                private int zoom = 0;

                public Ext build() {
                    return new Ext(this.lensId, this.zoom, this.maxZoom, this.rect, null);
                }

                public Creator setLensId(int i6) {
                    this.lensId = i6;
                    return this;
                }

                public Creator setMaxZoom(int i6) {
                    this.maxZoom = i6;
                    return this;
                }

                public Creator setRect(Rect rect) {
                    this.rect = rect;
                    return this;
                }

                public Creator setZoom(int i6) {
                    this.zoom = i6;
                    return this;
                }
            }

            /* synthetic */ Ext(int i6, int i7, int i8, Rect rect, AnonymousClass1 anonymousClass1) {
                this(i6, i7, i8, rect);
            }

            private Ext(int i6, int i7, int i8, Rect rect) {
                this.lensId = i6;
                this.zoom = i7;
                this.maxZoom = i8;
                this.rect = rect;
            }

            public int getLensId() {
                return this.lensId;
            }

            public int getMaxZoom() {
                return this.maxZoom;
            }

            public Rect getRect() {
                return this.rect;
            }

            public int getZoom() {
                return this.zoom;
            }
        }

        /* synthetic */ Property(int i6, int i7, int i8, int i9, int i10, long j6, Ext ext, AnonymousClass1 anonymousClass1) {
            this(i6, i7, i8, i9, i10, j6, ext);
        }

        public Property() {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.ext = new Ext.Creator().build();
        }

        public Ext getExt() {
            return this.ext;
        }

        public int getFormatType() {
            return this.formatType;
        }

        public int getHeight() {
            return this.height;
        }

        public int getItemIdentity() {
            return this.itemIdentity;
        }

        public int getQuadrant() {
            return this.quadrant;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public int getWidth() {
            return this.width;
        }

        public void resetWidthAndHeight() {
            if (this.quadrant % 2 != 0) {
                int i6 = this.width;
                this.width = this.height;
                this.height = i6;
            }
            this.quadrant = 0;
        }

        public Property(Property property) {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.width = property.getWidth();
            this.height = property.getHeight();
            this.formatType = property.getFormatType();
            this.quadrant = property.getQuadrant();
            this.itemIdentity = property.getItemIdentity();
            this.timestamp = property.getTimestamp();
            this.ext = property.getExt();
        }

        private Property(int i6, int i7, int i8, int i9, int i10, long j6, Ext ext) {
            this.width = i6;
            this.height = i7;
            this.quadrant = i8;
            this.formatType = i9;
            this.itemIdentity = i10;
            this.timestamp = j6;
            this.ext = ext;
        }
    }

    public MLFrame() {
        this.frameInit = Boolean.FALSE;
        this.property = new Property();
        this.byteBuffer = null;
        this.bitmap = null;
    }

    public final synchronized MLFrame getFrame(boolean z5, boolean z6) {
        try {
            if (this.frameInit.booleanValue()) {
                return this;
            }
            if (!z5 && this.byteBuffer != null) {
                int formatType = this.property.getFormatType();
                if (z6 && formatType != 17) {
                    if (formatType == 842094169) {
                        this.byteBuffer = ByteBuffer.wrap(ImageConvertUtils.byteToNv21(ImageConvertUtils.buffer2Byte(this.byteBuffer)));
                    }
                    Property.Creator creator = new Property.Creator();
                    creator.setFormatType(17).setWidth(this.property.getWidth()).setHeight(this.property.getHeight()).setQuadrant(this.property.getQuadrant());
                    this.property = creator.create();
                    this.frameInit = Boolean.TRUE;
                    return this;
                }
                this.frameInit = Boolean.TRUE;
                return this;
            }
            this.bitmap = getPreviewBitmap();
            this.property = new Creator().setBitmap(readBitmap()).create().property;
            this.frameInit = Boolean.TRUE;
            return this;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static MLFrame fromBitmap(Bitmap bitmap) {
        return new MLFrame(bitmap);
    }

    public static MLFrame fromByteArray(byte[] bArr, Property property) {
        return new MLFrame(bArr, property);
    }

    public static MLFrame fromByteBuffer(ByteBuffer byteBuffer, Property property) {
        return new MLFrame(byteBuffer, property);
    }

    public static MLFrame fromFilePath(Context context, Uri uri) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Parameter context is mandatory");
        }
        if (uri == null) {
            throw new IllegalArgumentException("Parameter uri is mandatory");
        }
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
        if (bitmap != null) {
            return new MLFrame(bitmap);
        }
        throw new NullPointerException("Failed to load bitmap from uri");
    }

    private Pair<Integer, Integer> getPreviewSize() {
        Property property = this.property;
        if (property == null) {
            return null;
        }
        if (property.getItemIdentity() == -1) {
            return Pair.create(Integer.valueOf(wrapBitmap().getWidth()), Integer.valueOf(wrapBitmap().getHeight()));
        }
        boolean z5 = true;
        if (this.property.getQuadrant() != 1 && this.property.getQuadrant() != 3) {
            z5 = false;
        }
        Property property2 = this.property;
        return Pair.create(Integer.valueOf(z5 ? property2.getHeight() : property2.getWidth()), Integer.valueOf(z5 ? this.property.getWidth() : this.property.getHeight()));
    }

    public static Bitmap rotate(Bitmap bitmap, int i6) {
        if (i6 < 0 || i6 > 3) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Invalid quadrant: ");
            sb.append(i6);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i6 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i6 * 90);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    private final Bitmap wrapBitmap() {
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            return bitmap;
        }
        if (this.property != null) {
            try {
                byte[] wrapJpeg = wrapJpeg(false);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wrapJpeg, 0, wrapJpeg.length);
                if (this.property.getQuadrant() != 0) {
                    decodeByteArray = rotate(decodeByteArray, this.property.getQuadrant());
                }
                this.bitmap = decodeByteArray;
            } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | Exception unused) {
                return null;
            }
        }
        return this.bitmap;
    }

    public ByteBuffer acquireGrayByteBuffer() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null && this.property != null) {
            ImageConvertUtils.nv21ToGray(byteBuffer.array(), this.property.width, this.property.height);
        }
        return this.byteBuffer;
    }

    public Property acquireProperty() {
        return this.property;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public Bitmap getPreviewBitmap() {
        if (this.bytes == null && this.byteBuffer == null && this.bitmap == null) {
            throw new IllegalStateException("At least one of bytes, byteBuffer or bitmap should be not null");
        }
        return wrapBitmap();
    }

    public int getRecMode() {
        return this.recMode;
    }

    public final void initialize() {
        ByteBuffer byteBuffer = this.byteBuffer;
        if (byteBuffer != null) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity());
            byteBuffer.rewind();
            allocate.put(byteBuffer);
            byteBuffer.rewind();
            allocate.flip();
            this.byteBuffer = allocate;
        }
    }

    public Bitmap readBitmap() {
        return this.bitmap;
    }

    public void setRecMode(int i6) {
        this.recMode = i6;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] wrapJpeg(boolean r3) {
        /*
            r2 = this;
            byte[] r0 = r2.bytes
            if (r0 == 0) goto L5
            return r0
        L5:
            java.nio.ByteBuffer r0 = r2.byteBuffer
            if (r0 == 0) goto L51
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getFormatType()
            boolean r1 = r2.isSupportedYuvFormat(r0)
            if (r1 == 0) goto L49
            if (r3 == 0) goto L1f
            com.huawei.hms.mlsdk.common.MLFrame$Property r3 = r2.property
            int r3 = r3.getQuadrant()
            if (r3 != 0) goto L51
        L1f:
            java.nio.ByteBuffer r3 = r2.byteBuffer
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.buffer2Byte(r3)
            r1 = 842094169(0x32315659, float:1.0322389E-8)
            if (r1 != r0) goto L2e
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.byteToNv21(r3)
        L2e:
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getWidth()
            com.huawei.hms.mlsdk.common.MLFrame$Property r1 = r2.property
            int r1 = r1.getHeight()
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.nv21ToJpeg(r3, r0, r1)
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getQuadrant()
            if (r0 != 0) goto L52
            r2.bytes = r3
            goto L52
        L49:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "Only support NV21 or YV12"
            r3.<init>(r0)
            throw r3
        L51:
            r3 = 0
        L52:
            if (r3 != 0) goto L60
            android.graphics.Bitmap r3 = r2.wrapBitmap()
            r0 = 100
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.bitmap2Jpeg(r3, r0)
            r2.bytes = r3
        L60:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.mlsdk.common.MLFrame.wrapJpeg(boolean):byte[]");
    }

    @TargetApi(19)
    public static MLFrame fromMediaImage(Image image, int i6) {
        MLFrame mLFrame;
        Image.Plane plane;
        int format = image.getFormat();
        if (format != 256 && format != 35) {
            throw new IllegalArgumentException("Unsupported format: " + image.getFormat() + ", Only JPEG and YUV_420_888 are supported");
        }
        if (format == 256) {
            Image.Plane[] planes = image.getPlanes();
            if (planes != null && planes.length == 1 && (plane = planes[0]) != null && plane.getBuffer() != null) {
                ByteBuffer buffer = planes[0].getBuffer();
                int remaining = buffer.remaining();
                byte[] bArr = new byte[remaining];
                buffer.get(bArr);
                if (i6 != 0) {
                    mLFrame = new MLFrame(rotate(BitmapFactory.decodeByteArray(bArr, 0, remaining), i6));
                } else {
                    mLFrame = new MLFrame(bArr);
                }
            } else {
                mLFrame = null;
            }
        } else {
            Property.Creator creator = new Property.Creator();
            creator.setFormatType(17).setWidth(image.getWidth()).setHeight(image.getHeight()).setQuadrant(i6);
            mLFrame = new MLFrame(ImageConvertUtils.getDataFromImage(image, 2), creator.create());
        }
        if (mLFrame != null) {
            return mLFrame;
        }
        throw new IllegalStateException("Failed to create frame from media image.");
    }

    private boolean isSupportedYuvFormat(int i6) {
        if (i6 != 842094169 && i6 != 17) {
            return false;
        }
        return true;
    }

    public final Pair<byte[], Float> create(int i6, int i7) {
        byte[] bitmap2Jpeg;
        if (getPreviewSize() == null) {
            return null;
        }
        int intValue = ((Integer) getPreviewSize().first).intValue();
        int intValue2 = ((Integer) getPreviewSize().second).intValue();
        float min = Math.min(i6 / intValue, i7 / intValue2);
        float f6 = 1.0f;
        if (min >= 1.0f) {
            bitmap2Jpeg = wrapJpeg(true);
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            f6 = min;
            bitmap2Jpeg = ImageConvertUtils.bitmap2Jpeg(Bitmap.createBitmap(wrapBitmap(), 0, 0, intValue, intValue2, matrix, true), 100);
        }
        return Pair.create(bitmap2Jpeg, Float.valueOf(f6));
    }

    private MLFrame(ByteBuffer byteBuffer, Property property) {
        this.frameInit = Boolean.FALSE;
        this.byteBuffer = byteBuffer;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr, Property property) {
        this(ByteBuffer.wrap(bArr), property);
    }

    private MLFrame(Bitmap bitmap) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
    }

    private MLFrame(Bitmap bitmap, Property property) {
        this.frameInit = Boolean.FALSE;
        this.bitmap = bitmap;
        this.property = property == null ? new Property() : property;
    }

    private MLFrame(byte[] bArr) {
        this.frameInit = Boolean.FALSE;
        this.bytes = bArr;
    }
}
