package com.amap.api.maps.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.d;
import com.amap.api.col.p0003l.d3;
import com.amap.api.col.p0003l.dk;
import com.bxkj.base.v2.common.utils.g0;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static final String ICON_ID_PREFIX = "com.amap.api.icon_";

    public static BitmapDescriptor defaultMarker() {
        try {
            return fromAsset(dk.a.marker_default.name() + g0.f16898c);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            return new BitmapDescriptor(bitmap, ICON_ID_PREFIX + b3.V());
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from bitmap failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FileInputStream openFileInput = context.openFileInput(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(openFileInput);
            openFileInput.close();
            BitmapDescriptor fromBitmap = fromBitmap(decodeStream);
            b3.B(decodeStream);
            return fromBitmap;
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i6) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(BitmapFactory.decodeStream(context.getResources().openRawResource(i6)));
            }
            return null;
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from res failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context context = getContext();
            if (context == null) {
                return null;
            }
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.addView(view);
            frameLayout.setDrawingCacheEnabled(true);
            return fromBitmap(b3.n(frameLayout));
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from view failed " + th.getMessage());
            return null;
        }
    }

    public static Context getContext() {
        return d.f5883f;
    }

    public static BitmapDescriptor defaultMarker(float f6) {
        try {
            float f7 = (((int) (f6 + 15.0f)) / 30) * 30;
            if (f7 > 330.0f) {
                f7 = 330.0f;
            } else if (f7 < 0.0f) {
                f7 = 0.0f;
            }
            String str = "";
            if (f7 == 0.0f) {
                str = "RED";
            } else if (f7 == 30.0f) {
                str = "ORANGE";
            } else if (f7 == 60.0f) {
                str = "YELLOW";
            } else if (f7 == 120.0f) {
                str = "GREEN";
            } else if (f7 == 180.0f) {
                str = "CYAN";
            } else if (f7 == 210.0f) {
                str = "AZURE";
            } else if (f7 == 240.0f) {
                str = "BLUE";
            } else if (f7 == 270.0f) {
                str = "VIOLET";
            } else if (f7 == 300.0f) {
                str = "MAGENTA";
            } else if (f7 == 330.0f) {
                str = "ROSE";
            }
            return fromAsset(str + g0.f16898c);
        } catch (Throwable th) {
            b3.D(th);
            return null;
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            Context context = getContext();
            if (context != null) {
                return fromBitmap(b3.l(context, str));
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(decodeStream);
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from assets failed " + th.getMessage());
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Throwable th) {
            b3.D(th);
            d3.l(c3.f5806f, "read bitmap from disk failed " + th.getMessage());
            return null;
        }
    }
}
