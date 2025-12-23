package xyz.adscope.amps.tool.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.internal.ViewUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.amps.tool.material.inner.OnBitmapCapturedListener;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSViewToBitmapUtil {
    private static final int DEFAULT_DIMENSION_THRESHOLD = 1920;
    private static final int DEFAULT_SCALE_SIZE = 2;
    private static final int DEFAULT_SIZE_THRESHOLD = 2073600;

    private static void drawViewGroupWithoutSurfaceViews(ViewGroup viewGroup, Canvas canvas, int[] iArr, int i6) {
        for (int i7 = 0; i7 < viewGroup.getChildCount(); i7++) {
            View childAt = viewGroup.getChildAt(i7);
            if (!(childAt instanceof SurfaceView)) {
                if (childAt instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) childAt;
                    if (findViewForSurfaceView(viewGroup2) != null) {
                        drawViewGroupWithoutSurfaceViews(viewGroup2, canvas, iArr, i6);
                    }
                }
                if (childAt.getVisibility() == 0) {
                    int[] iArr2 = new int[2];
                    childAt.getLocationInWindow(iArr2);
                    int i8 = iArr2[0] - iArr[0];
                    int i9 = iArr2[1] - iArr[1];
                    Matrix matrix = new Matrix();
                    float f6 = 1.0f / i6;
                    matrix.setScale(f6, f6);
                    canvas.setMatrix(matrix);
                    canvas.save();
                    canvas.translate(i8, i9);
                    childAt.draw(canvas);
                    canvas.restore();
                }
            }
        }
    }

    public static SurfaceView findViewForSurfaceView(ViewGroup viewGroup) {
        for (int i6 = 0; i6 < viewGroup.getChildCount(); i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt instanceof SurfaceView) {
                return (SurfaceView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                return findViewForSurfaceView((ViewGroup) childAt);
            }
        }
        return null;
    }

    public static /* synthetic */ void a(Bitmap bitmap, View view, int[] iArr, int i6, OnBitmapCapturedListener onBitmapCapturedListener, int i7) {
        if (i7 == 0) {
            drawViewGroupWithoutSurfaceViews((ViewGroup) view, new Canvas(bitmap), iArr, i6);
            onBitmapCapturedListener.onBitmapCaptured(bitmap);
        }
    }

    public static /* synthetic */ void b(OnBitmapCapturedListener onBitmapCapturedListener, Bitmap bitmap, int i6) {
        if (i6 == 0) {
            onBitmapCapturedListener.onBitmapCaptured(bitmap);
        }
    }

    public static double histogramSimilarity(Bitmap bitmap, Bitmap bitmap2) {
        int[] iArr = new int[ViewUtils.EDGE_TO_EDGE_FLAGS];
        int[] iArr2 = new int[ViewUtils.EDGE_TO_EDGE_FLAGS];
        calculateHistogram(bitmap, iArr);
        calculateHistogram(bitmap2, iArr2);
        double d6 = 0.0d;
        for (int i6 = 0; i6 < 768; i6++) {
            d6 += Math.sqrt(iArr[i6] * iArr2[i6]);
        }
        return d6 * 100.0d;
    }

    private static boolean shouldScaleView(int i6, int i7, int i8, int i9) {
        return (i6 * i7 > i8) || (i6 > i9 || i7 > i9);
    }

    private static void calculateHistogram(Bitmap bitmap, int[] iArr) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i6 = width * height;
        Arrays.fill(iArr, 0);
        for (int i7 = 0; i7 < height; i7++) {
            for (int i8 = 0; i8 < width; i8++) {
                int pixel = bitmap.getPixel(i8, i7);
                int red = Color.red(pixel);
                iArr[red] = iArr[red] + 1;
                int green = Color.green(pixel) + 256;
                iArr[green] = iArr[green] + 1;
                int blue = Color.blue(pixel) + 512;
                iArr[blue] = iArr[blue] + 1;
            }
        }
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr[i9] = iArr[i9] / i6;
        }
    }

    public static void getBitmapFromView(Context context, final View view, final OnBitmapCapturedListener onBitmapCapturedListener) {
        final int i6;
        SurfaceView surfaceView;
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width <= 0 || height <= 0) {
                view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                width = view.getWidth();
                height = view.getHeight();
            }
            if (width > 0 && height > 0) {
                if (shouldScaleView(width, height, DEFAULT_SIZE_THRESHOLD, 1920)) {
                    i6 = 2;
                } else {
                    i6 = 1;
                }
                final Bitmap createBitmap = Bitmap.createBitmap(Math.max(1, view.getMeasuredWidth() / i6), Math.max(1, view.getMeasuredHeight() / i6), Bitmap.Config.RGB_565);
                if (view instanceof ViewGroup) {
                    surfaceView = findViewForSurfaceView((ViewGroup) view);
                } else {
                    surfaceView = null;
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    final int[] iArr = new int[2];
                    view.getLocationInWindow(iArr);
                    if (surfaceView != null && surfaceView.getHolder().getSurface().isValid()) {
                        PixelCopy.request(surfaceView, (Rect) null, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: xyz.adscope.amps.tool.util.c
                            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                            public final void onPixelCopyFinished(int i7) {
                                AMPSViewToBitmapUtil.a(createBitmap, view, iArr, i6, onBitmapCapturedListener, i7);
                            }
                        }, new Handler(Looper.getMainLooper()));
                        return;
                    }
                    int i7 = iArr[0];
                    PixelCopy.request(((Activity) context).getWindow(), new Rect(i7, iArr[1], view.getWidth() + i7, iArr[1] + view.getHeight()), createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: xyz.adscope.amps.tool.util.d
                        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                        public final void onPixelCopyFinished(int i8) {
                            AMPSViewToBitmapUtil.b(OnBitmapCapturedListener.this, createBitmap, i8);
                        }
                    }, new Handler(Looper.getMainLooper()));
                    return;
                }
                Canvas canvas = new Canvas(createBitmap);
                Matrix matrix = new Matrix();
                float f6 = 1.0f / i6;
                matrix.setScale(f6, f6);
                canvas.setMatrix(matrix);
                view.draw(canvas);
                onBitmapCapturedListener.onBitmapCaptured(createBitmap);
            }
        } catch (Exception e6) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "getBitmapFromView Exception Message:" + e6.getMessage());
        }
    }

    public static File saveBitmapToFile(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i6, String str, File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        int i7 = 100;
        boolean z5 = false;
        while (i7 >= 10 && !z5) {
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    try {
                        bitmap.compress(compressFormat, i7, fileOutputStream);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        long length = file2.length();
                        if (length <= i6 * 1024) {
                            z5 = true;
                            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "素材保存成功 | 质量: " + i7 + "% | 大小: " + length + "字节");
                        } else {
                            i7 -= 20;
                            LogUtil.i(AMPSConstants.AMPS_LOG_TAG, "文件过大(" + length + "字节)，重新压缩质量至: " + i7 + "%");
                        }
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            } catch (Throwable th3) {
                bitmap.recycle();
                throw th3;
            }
        }
        if (!z5) {
            LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "压缩失败！最终文件仍然超过限制|大小：" + file2.length() + "字节");
        }
        bitmap.recycle();
        if (!z5) {
            return null;
        }
        return file2;
    }
}
