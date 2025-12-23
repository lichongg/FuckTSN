package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam = null;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

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
        gLMapState.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
    }

    public void setPositionAndVelocity(float f6, float f7) {
        this.moveParam = null;
        this.velocityScreenX = f6;
        this.velocityScreenY = f7;
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
        float f6 = this.velocityScreenX;
        int i6 = this.duration;
        float f7 = (f6 * i6) / 2000.0f;
        float f8 = (this.velocityScreenY * i6) / 2000.0f;
        if (Math.abs(f7) != 0.0f && Math.abs(f8) != 0.0f) {
            this.isOver = false;
            IPoint obtain = IPoint.obtain();
            gLMapState.getMapGeoCenter(obtain);
            this.moveParam.setFromValue(((Point) obtain).x, ((Point) obtain).y);
            double mapAngle = (gLMapState.getMapAngle() * 3.141592653589793d) / 180.0d;
            double mapLenWithWin = gLMapState.getMapLenWithWin(1);
            double d6 = f7;
            double d7 = f8;
            this.moveParam.setToValue(((Point) obtain).x - (((Math.cos(mapAngle) * d6) - (Math.sin(mapAngle) * d7)) * mapLenWithWin), ((Point) obtain).y - (mapLenWithWin * ((d6 * Math.sin(mapAngle)) + (d7 * Math.cos(mapAngle)))));
            this.needMove = this.moveParam.needToCaculate();
            obtain.recycle();
        }
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
    }

    public void reset() {
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.moveParam;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public AdglMapAnimFlingP20(int i6) {
        reset();
        this.duration = i6;
    }
}
