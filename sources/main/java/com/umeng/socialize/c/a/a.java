package com.umeng.socialize.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.umeng.socialize.c.b.b;
import com.umeng.socialize.c.b.c;
import com.umeng.socialize.c.b.d;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class a {
    public static byte[] a(UMImage uMImage, int i6) {
        if (uMImage == null) {
            return DefaultClass.getBytes();
        }
        if (uMImage.asBinImage() == null || a(uMImage) < i6) {
            return uMImage.asBinImage();
        }
        if (uMImage.compressStyle == UMImage.CompressStyle.QUALITY) {
            return a(uMImage.asBinImage(), i6, uMImage.compressFormat);
        }
        try {
            byte[] asBinImage = uMImage.asBinImage();
            if (asBinImage == null) {
                return new byte[1];
            }
            if (asBinImage.length <= 0) {
                return uMImage.asBinImage();
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(asBinImage, 0, asBinImage.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(asBinImage, 0, asBinImage.length);
            while (byteArrayOutputStream.toByteArray().length > i6) {
                double sqrt = Math.sqrt((asBinImage.length * 1.0d) / i6);
                decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, (int) (decodeByteArray.getWidth() / sqrt), (int) (decodeByteArray.getHeight() / sqrt), true);
                byteArrayOutputStream.reset();
                if (decodeByteArray != null) {
                    decodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                    asBinImage = byteArrayOutputStream.toByteArray();
                }
            }
            if (byteArrayOutputStream.toByteArray().length > i6) {
                return null;
            }
            return asBinImage;
        } catch (Throwable th) {
            SLog.error(th);
            return DefaultClass.getBytes();
        }
    }

    private static byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            float rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                            float f6 = c.f42313b;
                            bitmap.compress(compressFormat, rowBytes > f6 ? (int) ((f6 / rowBytes) * 100) : 100, byteArrayOutputStream2);
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            try {
                                byteArrayOutputStream2.close();
                                return byteArray;
                            } catch (IOException e6) {
                                SLog.error(UmengText.IMAGE.CLOSE, e6);
                                return byteArray;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            SLog.error(UmengText.IMAGE.BITMAOTOBINARY, e);
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e8) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e8);
                                }
                            }
                            return DefaultClass.getBytes();
                        } catch (Throwable th) {
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e9) {
                                    SLog.error(UmengText.IMAGE.CLOSE, e9);
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        e = e10;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private static BitmapFactory.Options d(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int ceil = (int) Math.ceil(options.outWidth / UMImage.MAX_WIDTH);
        int ceil2 = (int) Math.ceil(options.outHeight / UMImage.MAX_HEIGHT);
        if (ceil2 <= 1 || ceil <= 1) {
            if (ceil2 > 2) {
                options.inSampleSize = ceil2;
            } else if (ceil > 2) {
                options.inSampleSize = ceil;
            }
        } else if (ceil2 > ceil) {
            options.inSampleSize = ceil2;
        } else {
            options.inSampleSize = ceil;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static int e(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public static String c(byte[] bArr) {
        return d.a(bArr);
    }

    public static File b(byte[] bArr) {
        try {
            return a(bArr, b.a().b());
        } catch (IOException e6) {
            SLog.error(UmengText.IMAGE.BINARYTOFILE, e6);
            return null;
        }
    }

    private static byte[] b(File file, Bitmap.CompressFormat compressFormat) {
        if (file != null && file.getAbsoluteFile().exists()) {
            byte[] a6 = b.a().a(file);
            if (SocializeUtils.assertBinaryInvalid(a6)) {
                return d.f42326m[1].equals(d.a(a6)) ? a6 : a(a6, compressFormat);
            }
        }
        return null;
    }

    public static byte[] a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    public static Bitmap a(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    private static File a(byte[] bArr, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.close();
                        return file;
                    } catch (Exception e6) {
                        e = e6;
                        bufferedOutputStream = bufferedOutputStream2;
                        SLog.error(UmengText.IMAGE.GET_FILE_FROM_BINARY, e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return file;
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e7) {
                                SLog.error(UmengText.IMAGE.CLOSE, e7);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (IOException e9) {
            SLog.error(UmengText.IMAGE.CLOSE, e9);
            return file;
        }
    }

    public static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return b(bitmap, compressFormat);
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static byte[] a(Context context, int i6, boolean z5, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!z5) {
            Bitmap a6 = a(context.getResources().getDrawable(i6, null));
            if (a6 != null) {
                a6.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        byte[] bArr = new byte[0];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap decodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i6), null, options);
            if (decodeStream != null) {
                decodeStream.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Error e6) {
            SLog.error(UmengText.IMAGE.TOOBIG, e6);
            return bArr;
        }
    }

    public static byte[] a(File file, Bitmap.CompressFormat compressFormat) {
        return b(file, compressFormat);
    }

    public static int a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return a(uMImage.asFileImage());
        }
        return e(uMImage.asBinImage());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003b, code lost:
    
        if (r1 == null) goto L23;
     */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x001f: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:23:0x001f */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] a(byte[] r4, android.graphics.Bitmap.CompressFormat r5) {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = d(r4)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            int r2 = r4.length     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r3 = 0
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r3, r2, r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r1.<init>()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            if (r4 == 0) goto L23
            r2 = 100
            r4.compress(r5, r2, r1)     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r4.recycle()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            java.lang.System.gc()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            goto L23
        L1e:
            r4 = move-exception
            r0 = r1
            goto L3f
        L21:
            r4 = move-exception
            goto L36
        L23:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
        L27:
            r1.close()     // Catch: java.io.IOException -> L2b
            goto L3e
        L2b:
            r4 = move-exception
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r5, r4)
            goto L3e
        L32:
            r4 = move-exception
            goto L3f
        L34:
            r4 = move-exception
            r1 = r0
        L36:
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.FILE_TO_BINARY_ERROR     // Catch: java.lang.Throwable -> L1e
            com.umeng.socialize.utils.SLog.error(r5, r4)     // Catch: java.lang.Throwable -> L1e
            if (r1 == 0) goto L3e
            goto L27
        L3e:
            return r0
        L3f:
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.io.IOException -> L45
            goto L4b
        L45:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.c.a.a.a(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    public static byte[] a(byte[] bArr, int i6, Bitmap.CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i6) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z5 = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i7 = 1;
        while (!z5 && i7 <= 10) {
            int pow = (int) (Math.pow(0.8d, i7) * 100.0d);
            if (decodeByteArray != null) {
                decodeByteArray.compress(compressFormat, pow, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() < i6) {
                z5 = true;
            } else {
                byteArrayOutputStream.reset();
                i7++;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!decodeByteArray.isRecycled()) {
            decodeByteArray.recycle();
        }
        if (byteArray != null && byteArray.length <= 0) {
            SLog.E(UmengText.IMAGE.THUMB_ERROR);
        }
        return byteArray;
    }

    private static int a(File file) {
        if (file == null) {
            return 0;
        }
        try {
            return new FileInputStream(file).available();
        } catch (Throwable th) {
            SLog.error(UmengText.IMAGE.GET_IMAGE_SCALE_ERROR, th);
            return 0;
        }
    }
}
