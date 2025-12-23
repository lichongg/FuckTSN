package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        if (!this.hasCheckParams) {
            commitAnimation(obj);
        }
        if (this.isOver) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = uptimeMillis;
        float f6 = uptimeMillis / this.duration;
        if (f6 > 1.0f) {
            this.isOver = true;
            f6 = 1.0f;
        }
        if (f6 < 0.0f || f6 > 1.0f || !this.needMove) {
            return;
        }
        this.moveParam.setNormalizedTime(f6);
        int curXValue = (int) this.moveParam.getCurXValue();
        int curYValue = (int) this.moveParam.getCurYValue();
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point((this.screenCenterX + curXValue) - this.lastMoveX, (this.screenCenterY + curYValue) - this.lastMoveY, obtain);
        gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        this.lastMoveX = curXValue;
        this.lastMoveY = curYValue;
        obtain.recycle();
    }

    public void setPositionAndVelocity(float f6, float f7) {
        this.moveParam = null;
        this.velocityX = f6;
        this.velocityY = f7;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = new AbstractAdglAnimationParam2V();
        this.moveParam = abstractAdglAnimationParam2V;
        abstractAdglAnimationParam2V.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void commitAnimation(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f6 = this.velocityX;
        int i6 = this.duration;
        int i7 = (int) ((f6 * i6) / 2000.0f);
        int i8 = (int) ((this.velocityY * i6) / 2000.0f);
        if (Math.abs(i7) != 0 && Math.abs(i8) != 0) {
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - i7, this.screenCenterY - i8);
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void commitAnimationold(Object obj) {
        GLMapState gLMapState = (GLMapState) obj;
        if (gLMapState == null) {
            return;
        }
        this.hasCheckParams = false;
        this.isOver = true;
        float f6 = this.velocityX;
        float f7 = this.velocityY;
        float sqrt = ((float) Math.sqrt((f6 * f6) + (f7 * f7))) / 1000.0f;
        if (sqrt >= 0.1f) {
            float f8 = sqrt * 0.02f;
            if (this.fromCenter == null) {
                this.fromCenter = IPoint.obtain();
            }
            gLMapState.getMapGeoCenter(this.fromCenter);
            this.isOver = false;
            this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
            this.moveParam.setToValue(this.screenCenterX - (this.velocityX * f8), this.screenCenterY - (this.velocityY * f8));
            this.needMove = this.moveParam.needToCaculate();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public AdglMapAnimFling(int i6, int i7, int i8) {
        this.screenCenterX = i7;
        this.screenCenterY = i8;
        this.lastMoveX = i7;
        this.lastMoveY = i8;
        reset();
        this.duration = i6;
    }
}
