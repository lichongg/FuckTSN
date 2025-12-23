package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class aj {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {
        private int aZH;
        private int aZI;
        private int aZJ;
        private int aZK;
        private int mHeight;
        private int mWidth;

        public a() {
            this.mWidth = -1;
            this.mHeight = -1;
            this.aZH = -1;
            this.aZI = -1;
            this.aZJ = -1;
            this.aZK = -1;
        }

        public final void e(float f6, float f7) {
            this.aZH = (int) f6;
            this.aZI = (int) f7;
        }

        public final void f(float f6, float f7) {
            this.aZJ = (int) f6;
            this.aZK = (int) f7;
        }

        public final void B(int i6, int i7) {
            this.mWidth = i6;
            this.mHeight = i7;
        }

        public final int QO() {
            return this.aZH;
        }

        public final int QP() {
            return this.aZI;
        }

        public final int QQ() {
            return this.aZJ;
        }

        public final int QR() {
            return this.aZK;
        }

        public final int getHeight() {
            return this.mHeight;
        }

        public final int getWidth() {
            return this.mWidth;
        }

        public final String toString() {
            return "TouchCoords{mWidth=" + this.mWidth + ", mHeight=" + this.mHeight + ", mDownX=" + this.aZH + ", mDownY=" + this.aZI + ", mUpX=" + this.aZJ + ", mUpY=" + this.aZK + '}';
        }

        public a(int i6, int i7) {
            this.aZH = -1;
            this.aZI = -1;
            this.aZJ = -1;
            this.aZK = -1;
            this.mWidth = i6;
            this.mHeight = i7;
        }
    }

    private static String eQ(int i6) {
        return i6 >= 0 ? String.valueOf(i6) : "-999";
    }

    @WorkerThread
    public static String a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            return str.replace("__WIDTH__", eQ(aVar.getWidth())).replace("__HEIGHT__", eQ(aVar.getHeight())).replace("__DOWN_X__", eQ(aVar.QO())).replace("__DOWN_Y__", eQ(aVar.QP())).replace("__UP_X__", eQ(aVar.QQ())).replace("__UP_Y__", eQ(aVar.QR()));
        }
        return str;
    }

    public static String ao(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("__SCREEN_WIDTH__", String.valueOf(m.getScreenWidth(context))).replace("__SCREEN_HEIGHT__", String.valueOf(m.getScreenHeight(context))).replace("__DEVICE_WIDTH__", String.valueOf(m.cI(context))).replace("__DEVICE_HEIGHT__", String.valueOf(m.cJ(context)));
    }

    public static String c(@Nullable Context context, String str, boolean z5) {
        return str.replace("__TS__", String.valueOf(bt.x(context, z5)));
    }
}
