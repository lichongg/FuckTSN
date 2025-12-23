package com.autonavi.base.amap.mapcore;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public class Rectangle {

    @JBindingInclude
    private int beyond180Mode;
    public float bottom;
    public FPoint[] clipMapRect;
    public IPoint[] clipRect;

    @JBindingInclude
    private int[] jniClipRect;
    public float left;
    public Rect rect;
    public float right;

    /* renamed from: top, reason: collision with root package name */
    public float f10287top;

    public Rectangle() {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    public boolean contains(int i6, int i7) {
        Rect rect = this.rect;
        if (rect == null) {
            return false;
        }
        if (rect.contains(i6, i7)) {
            return true;
        }
        if (this.beyond180Mode != 0) {
            return this.rect.contains(i6 - 268435456, i7) || this.rect.contains(i6 + 268435456, i7);
        }
        return false;
    }

    public boolean isOverlap(Rect rect) {
        Rect rect2 = this.rect;
        if (rect2 != null && rect != null) {
            int width = rect2.left + rect2.width();
            int i6 = rect.left;
            if (width > i6) {
                int width2 = i6 + rect.width();
                Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.top + rect3.height();
                    int i7 = rect.top;
                    if (height > i7 && i7 + rect.height() > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void updateClipMapRect(int i6, int i7) {
        int i8 = 0;
        if (this.clipMapRect == null) {
            FPoint[] fPointArr = new FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = FPoint.obtain(0.0f, 0.0f);
        }
        Rect rect = this.rect;
        if (rect != null) {
            FPoint[] fPointArr2 = this.clipMapRect;
            FPoint fPoint = fPointArr2[0];
            int i9 = rect.left;
            ((PointF) fPoint).x = i9 - i6;
            int i10 = rect.top;
            ((PointF) fPoint).y = i10 - i7;
            FPoint fPoint2 = fPointArr2[1];
            int i11 = rect.right;
            ((PointF) fPoint2).x = i11 - i6;
            ((PointF) fPoint2).y = i10 - i7;
            FPoint fPoint3 = fPointArr2[2];
            ((PointF) fPoint3).x = i11 - i6;
            int i12 = rect.bottom;
            ((PointF) fPoint3).y = i12 - i7;
            FPoint fPoint4 = fPointArr2[3];
            ((PointF) fPoint4).x = i9 - i6;
            ((PointF) fPoint4).y = i12 - i7;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            FPoint[] fPointArr3 = this.clipMapRect;
            if (i8 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i13 = i8 * 2;
            FPoint fPoint5 = fPointArr3[i8];
            iArr[i13] = (int) ((PointF) fPoint5).x;
            iArr[i13 + 1] = (int) ((PointF) fPoint5).y;
            i8++;
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            IPoint[] iPointArr = new IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = IPoint.obtain(0, 0);
            this.clipRect[1] = IPoint.obtain(0, 0);
            this.clipRect[2] = IPoint.obtain(0, 0);
            this.clipRect[3] = IPoint.obtain(0, 0);
        }
        Rect rect = this.rect;
        if (rect != null) {
            IPoint[] iPointArr2 = this.clipRect;
            IPoint iPoint = iPointArr2[0];
            int i6 = rect.left;
            ((Point) iPoint).x = i6;
            int i7 = rect.top;
            ((Point) iPoint).y = i7;
            IPoint iPoint2 = iPointArr2[1];
            int i8 = rect.right;
            ((Point) iPoint2).x = i8;
            ((Point) iPoint2).y = i7;
            IPoint iPoint3 = iPointArr2[2];
            ((Point) iPoint3).x = i8;
            int i9 = rect.bottom;
            ((Point) iPoint3).y = i9;
            IPoint iPoint4 = iPointArr2[3];
            ((Point) iPoint4).x = i6;
            ((Point) iPoint4).y = i9;
        }
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public IPoint[] getClipRect() {
        return this.clipRect;
    }

    public Rect getRect() {
        return this.rect;
    }

    public void updateRect(Rect rect, int i6, int i7) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            float f6 = r4.left / 100000.0f;
            int i8 = this.rect.right;
            if (f6 * (i8 / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i8 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i6, i7);
        }
    }

    public boolean contains(IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((Point) iPoint).x, ((Point) iPoint).y);
    }

    public boolean isOverlap(int i6, int i7, int i8, int i9) {
        Rect rect = this.rect;
        if (rect != null && rect.left + rect.width() > i6) {
            int i10 = i6 + i8;
            Rect rect2 = this.rect;
            if (i10 > rect2.left && rect2.top + rect2.height() > i7 && i7 + i9 > this.rect.top) {
                return true;
            }
        }
        return false;
    }

    public Rectangle(Rect rect, int i6, int i7) {
        new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i6, i7);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    public boolean contains(Rect rect) {
        if (rect == null) {
            return false;
        }
        return this.rect.contains(rect);
    }

    public Rectangle(float f6, float f7, float f8, float f9) {
        this.rect = new Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f6 >= f7 || f9 <= f8) {
            return;
        }
        this.left = f6;
        this.right = f7;
        this.f10287top = f9;
        this.bottom = f8;
    }
}
