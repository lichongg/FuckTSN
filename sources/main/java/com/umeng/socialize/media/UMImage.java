package com.umeng.socialize.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import com.stub.StubApp;
import com.umeng.social.tool.UMImageMark;
import com.umeng.socialize.c.a.a;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class UMImage extends BaseMediaObject {
    public static int BINARY_IMAGE = 5;
    public static int BITMAP_IMAGE = 4;
    public static int FILE_IMAGE = 1;
    public static int MAX_HEIGHT = 1024;
    public static int MAX_WIDTH = 768;
    public static int RES_IMAGE = 3;
    public static int URL_IMAGE = 2;
    public Bitmap.CompressFormat compressFormat;
    public CompressStyle compressStyle;

    /* renamed from: f, reason: collision with root package name */
    private ConfiguredConvertor f42376f;

    /* renamed from: g, reason: collision with root package name */
    private UMImage f42377g;

    /* renamed from: h, reason: collision with root package name */
    private UMImageMark f42378h;

    /* renamed from: i, reason: collision with root package name */
    private int f42379i;
    public boolean isLoadImgByCompress;

    /* renamed from: j, reason: collision with root package name */
    private boolean f42380j;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class BinaryConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private byte[] f42382b;

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }

        public BinaryConvertor(byte[] bArr) {
            this.f42382b = bArr;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return this.f42382b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class BitmapConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private Bitmap f42384b;

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }

        public BitmapConvertor(Bitmap bitmap) {
            this.f42384b = bitmap;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f42384b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            return this.f42384b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            byte[] a6 = a.a(this.f42384b, UMImage.this.compressFormat);
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(a6);
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum CompressStyle {
        SCALE,
        QUALITY
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class FileConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private File f42387b;

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }

        public FileConvertor(File file) {
            this.f42387b = file;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f42387b, UMImage.this.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            return this.f42387b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(UMImage.this.asBinImage());
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    interface IImageConvertor {
        byte[] asBinary();

        Bitmap asBitmap();

        File asFile();

        String asUrl();
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class ResConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private Context f42389b;

        /* renamed from: c, reason: collision with root package name */
        private int f42390c;

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return null;
        }

        public ResConvertor(Context context, int i6) {
            this.f42389b = context;
            this.f42390c = i6;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            Context context = this.f42389b;
            int i6 = this.f42390c;
            UMImage uMImage = UMImage.this;
            return a.a(context, i6, uMImage.isLoadImgByCompress, uMImage.compressFormat);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class UrlConvertor extends ConfiguredConvertor {

        /* renamed from: b, reason: collision with root package name */
        private String f42392b;

        public UrlConvertor(String str) {
            this.f42392b = str;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public byte[] asBinary() {
            return a.a(this.f42392b);
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public String asUrl() {
            return this.f42392b;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public Bitmap asBitmap() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.a(asBinary());
            }
            return null;
        }

        @Override // com.umeng.socialize.media.UMImage.IImageConvertor
        public File asFile() {
            if (SocializeUtils.assertBinaryInvalid(asBinary())) {
                return a.b(asBinary());
            }
            return null;
        }
    }

    public UMImage(Context context, File file) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, file);
    }

    private float a(float f6, float f7, float f8, float f9) {
        if (f6 <= f9 && f7 <= f9) {
            return -1.0f;
        }
        float f10 = f6 / f8;
        float f11 = f7 / f9;
        return f10 > f11 ? f10 : f11;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static abstract class ConfiguredConvertor implements IImageConvertor {
        ConfiguredConvertor() {
        }
    }

    private void a(Context context, Object obj) {
        a(context, obj, null);
    }

    private void b(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                bitmap.recycle();
            } catch (Exception e6) {
                SLog.error(e6);
            }
        }
    }

    public byte[] asBinImage() {
        ConfiguredConvertor configuredConvertor = this.f42376f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBinary();
    }

    public Bitmap asBitmap() {
        ConfiguredConvertor configuredConvertor = this.f42376f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asBitmap();
    }

    public File asFileImage() {
        ConfiguredConvertor configuredConvertor = this.f42376f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asFile();
    }

    public String asUrlImage() {
        ConfiguredConvertor configuredConvertor = this.f42376f;
        if (configuredConvertor == null) {
            return null;
        }
        return configuredConvertor.asUrl();
    }

    public int getImageStyle() {
        return this.f42379i;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public UMediaObject.MediaType getMediaType() {
        return UMediaObject.MediaType.IMAGE;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public UMImage getThumbImage() {
        return this.f42377g;
    }

    public boolean isHasWaterMark() {
        return this.f42380j;
    }

    @Override // com.umeng.socialize.media.BaseMediaObject
    public void setThumb(UMImage uMImage) {
        this.f42377g = uMImage;
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public final Map<String, Object> toUrlExtraParams() {
        HashMap hashMap = new HashMap();
        if (isUrlMedia()) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FURL, this.f42355a);
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_FTYPE, getMediaType());
        }
        return hashMap;
    }

    private void a(Context context, Object obj, UMImageMark uMImageMark) {
        Bitmap a6;
        if (uMImageMark != null) {
            this.f42380j = true;
            this.f42378h = uMImageMark;
            uMImageMark.setContext(context);
        }
        if (ContextUtil.getContext() == null) {
            ContextUtil.setContext(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        }
        if (obj instanceof File) {
            this.f42379i = FILE_IMAGE;
            this.f42376f = new FileConvertor((File) obj);
            return;
        }
        if (obj instanceof String) {
            this.f42379i = URL_IMAGE;
            this.f42376f = new UrlConvertor((String) obj);
            return;
        }
        if (obj instanceof Integer) {
            this.f42379i = RES_IMAGE;
            a6 = isHasWaterMark() ? a(context, ((Integer) obj).intValue()) : null;
            if (a6 != null) {
                this.f42376f = new BitmapConvertor(a6);
                return;
            } else {
                this.f42376f = new ResConvertor(StubApp.getOrigApplicationContext(context.getApplicationContext()), ((Integer) obj).intValue());
                return;
            }
        }
        if (obj instanceof byte[]) {
            this.f42379i = BINARY_IMAGE;
            a6 = isHasWaterMark() ? a((byte[]) obj) : null;
            if (a6 != null) {
                this.f42376f = new BitmapConvertor(a6);
                return;
            } else {
                this.f42376f = new BinaryConvertor((byte[]) obj);
                return;
            }
        }
        if (obj instanceof Bitmap) {
            this.f42379i = BITMAP_IMAGE;
            a6 = isHasWaterMark() ? a((Bitmap) obj, true) : null;
            if (a6 == null) {
                a6 = (Bitmap) obj;
            }
            this.f42376f = new BitmapConvertor(a6);
            return;
        }
        if (obj != null) {
            SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + obj.getClass().getSimpleName());
            return;
        }
        SLog.E(UmengText.IMAGE.UNKNOW_UMIMAGE + "null");
    }

    @Override // com.umeng.socialize.media.UMediaObject
    public byte[] toByte() {
        return asBinImage();
    }

    public UMImage(Context context, String str) {
        super(str);
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a((Context) new WeakReference(context).get(), str);
    }

    public UMImage(Context context, int i6) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, Integer.valueOf(i6));
    }

    public UMImage(Context context, byte[] bArr) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, bArr);
    }

    public UMImage(Context context, Bitmap bitmap) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, bitmap);
    }

    private Bitmap a(Bitmap bitmap, boolean z5) {
        if (this.f42378h == null) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        if (z5) {
            try {
                bitmap = a(bitmap);
            } catch (Exception e6) {
                SLog.error(e6);
                return null;
            }
        }
        return this.f42378h.compound(bitmap);
    }

    public UMImage(Context context, Bitmap bitmap, UMImageMark uMImageMark) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, bitmap, uMImageMark);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0037: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:30:0x0037 */
    private Bitmap a(Context context, int i6) {
        Closeable closeable;
        InputStream inputStream;
        BitmapFactory.Options options;
        Closeable closeable2 = null;
        if (i6 != 0 && context != null) {
            try {
                if (this.f42378h != null) {
                    try {
                        options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        inputStream = context.getResources().openRawResource(i6);
                    } catch (Exception e6) {
                        e = e6;
                        inputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        a(closeable2);
                        throw th;
                    }
                    try {
                        BitmapFactory.decodeStream(inputStream, null, options);
                        a(inputStream);
                        int a6 = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                        if (a6 > 0) {
                            options.inSampleSize = a6;
                        }
                        options.inJustDecodeBounds = false;
                        inputStream = context.getResources().openRawResource(i6);
                        Bitmap a7 = a(BitmapFactory.decodeStream(inputStream, null, options), false);
                        a(inputStream);
                        return a7;
                    } catch (Exception e7) {
                        e = e7;
                        SLog.error(e);
                        a(inputStream);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
            }
        }
        return null;
    }

    public UMImage(Context context, int i6, UMImageMark uMImageMark) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, Integer.valueOf(i6), uMImageMark);
    }

    public UMImage(Context context, byte[] bArr, UMImageMark uMImageMark) {
        this.f42376f = null;
        this.isLoadImgByCompress = true;
        this.compressStyle = CompressStyle.SCALE;
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.f42379i = 0;
        a(context, bArr, uMImageMark);
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e6) {
                SLog.error(e6);
            }
        }
    }

    private Bitmap a(byte[] bArr) {
        if (bArr != null && this.f42378h != null) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                int a6 = (int) a(options.outWidth, options.outHeight, MAX_WIDTH, MAX_HEIGHT);
                if (a6 > 0) {
                    options.inSampleSize = a6;
                }
                options.inJustDecodeBounds = false;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options), false);
            } catch (Exception e6) {
                SLog.error(e6);
            }
        }
        return null;
    }

    private Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float a6 = a(width, height, MAX_WIDTH, MAX_HEIGHT);
        if (a6 < 0.0f) {
            return bitmap;
        }
        float f6 = 1.0f / a6;
        Matrix matrix = new Matrix();
        matrix.postScale(f6, f6);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        b(bitmap);
        return createBitmap;
    }
}
