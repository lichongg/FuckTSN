package com.autonavi.base.ae.gmap.glanimation;

import com.amap.api.maps.AMap;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AdglMapAnimationMgr {
    private List<AbstractAdglAnimation> list = Collections.synchronizedList(new ArrayList());
    private AMap.CancelableCallback mCancelCallback;
    private MapAnimationListener mMapAnimationListener;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface MapAnimationListener {
        void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback);
    }

    public synchronized void clearAnimations() {
        this.list.clear();
    }

    public synchronized void doAnimations(GLMapState gLMapState) {
        if (gLMapState == null) {
            return;
        }
        try {
            if (this.list.size() <= 0) {
                return;
            }
            AbstractAdglAnimation abstractAdglAnimation = this.list.get(0);
            if (abstractAdglAnimation == null) {
                return;
            }
            if (!abstractAdglAnimation.isOver()) {
                abstractAdglAnimation.doAnimation(gLMapState);
                return;
            }
            MapAnimationListener mapAnimationListener = this.mMapAnimationListener;
            if (mapAnimationListener != null) {
                mapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
            }
            this.list.remove(abstractAdglAnimation);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized int getAnimationsCount() {
        return this.list.size();
    }

    public void setMapAnimationListener(MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }

    public void addAnimation(AbstractAdglAnimation abstractAdglAnimation, AMap.CancelableCallback cancelableCallback) {
        if (abstractAdglAnimation == null) {
            return;
        }
        synchronized (this.list) {
            try {
                if (!abstractAdglAnimation.isOver() && this.list.size() > 0) {
                    AbstractAdglAnimation abstractAdglAnimation2 = this.list.get(r1.size() - 1);
                    if (abstractAdglAnimation2 != null && (abstractAdglAnimation instanceof AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof AdglMapAnimGroup) && ((AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((AdglMapAnimGroup) abstractAdglAnimation2) && !((AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                        this.list.remove(abstractAdglAnimation2);
                    }
                }
                this.list.add(abstractAdglAnimation);
                this.mCancelCallback = cancelableCallback;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapCoreListener() {
    }
}
