package com.baidu.idl.face.platform.ui.utils;

import android.graphics.Point;
import android.hardware.Camera;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class CameraPreviewUtils {
    private static final int MAX_PREVIEW_PIXELS = 2073600;
    private static final int MIN_PREVIEW_PIXELS = 307200;
    private static final String TAG = "CameraPreviewUtils";

    public static Point getBestPreview(Camera.Parameters parameters, Point point) {
        double d6;
        double d7;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            parameters.getPreviewSize();
            return new Point(640, 480);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.baidu.idl.face.platform.ui.utils.CameraPreviewUtils.1
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i6 = size.height * size.width;
                int i7 = size2.height * size2.width;
                if (i7 < i6) {
                    return -1;
                }
                return i7 > i6 ? 1 : 0;
            }
        });
        int i6 = point.x;
        int i7 = point.y;
        if (i6 > i7) {
            d6 = i6;
            d7 = i7;
        } else {
            d6 = i7;
            d7 = i6;
        }
        double d8 = d6 / d7;
        Iterator it = arrayList.iterator();
        Camera.Size size = null;
        double d9 = -1.0d;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i8 = size2.width;
            int i9 = size2.height;
            int i10 = i8 * i9;
            if (i10 < MIN_PREVIEW_PIXELS) {
                it.remove();
            } else if (i10 > MAX_PREVIEW_PIXELS) {
                it.remove();
            } else if (i9 > i8) {
                it.remove();
            } else if (i9 % 2 == 0 && i8 % 2 == 0) {
                double abs = Math.abs((i8 > i9 ? i8 / i9 : i9 / i8) - d8);
                if ((d9 == -1.0d && abs <= 0.25d) || (d9 >= abs && abs <= 0.25d)) {
                    size = size2;
                    d9 = abs;
                }
            } else {
                it.remove();
            }
        }
        if (size != null) {
            return new Point(size.width, size.height);
        }
        parameters.getPreviewSize();
        return new Point(640, 480);
    }
}
