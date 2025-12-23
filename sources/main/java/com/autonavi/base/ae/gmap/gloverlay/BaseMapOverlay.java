package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class BaseMapOverlay<T extends GLOverlay, E> implements Serializable {
    private static final long serialVersionUID = 1;
    protected Context mContext;
    protected int mEngineID;
    protected T mGLOverlay;
    protected Vector<E> mItemList;
    protected int mLastFocusedIndex;
    protected IAMapDelegate mMapView;

    public abstract void addItem(E e6);

    public void clearFocus() {
        this.mLastFocusedIndex = -1;
        this.mGLOverlay.clearFocus();
    }

    public final E getItem(int i6) {
        try {
            synchronized (this.mItemList) {
                if (i6 >= 0) {
                    try {
                        if (i6 <= this.mItemList.size() - 1) {
                            return this.mItemList.get(i6);
                        }
                    } finally {
                    }
                }
                return null;
            }
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    protected abstract void iniGLOverlay();

    public void removeItem(int i6) {
        if (i6 >= 0) {
            try {
                if (i6 > this.mItemList.size() - 1) {
                    return;
                }
                if (i6 == this.mLastFocusedIndex) {
                    this.mLastFocusedIndex = -1;
                    clearFocus();
                }
                this.mItemList.remove(i6);
                T t5 = this.mGLOverlay;
                if (t5 != null) {
                    t5.removeItem(i6);
                }
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }

    public abstract void resumeMarker(Bitmap bitmap);

    public abstract void setVisible(boolean z5);

    public boolean clear() {
        try {
            this.mItemList.clear();
            clearFocus();
            T t5 = this.mGLOverlay;
            if (t5 == null) {
                return true;
            }
            t5.removeAll();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public T getGLOverlay() {
        return this.mGLOverlay;
    }

    public List<E> getItems() {
        return this.mItemList;
    }

    public int getSize() {
        return this.mItemList.size();
    }

    public boolean isClickable() {
        T t5 = this.mGLOverlay;
        if (t5 != null) {
            return t5.isClickable();
        }
        return false;
    }

    public boolean isVisible() {
        T t5 = this.mGLOverlay;
        if (t5 != null) {
            return t5.isVisible();
        }
        return false;
    }

    public void setClickable(boolean z5) {
        T t5 = this.mGLOverlay;
        if (t5 != null) {
            t5.setClickable(z5);
        }
    }

    public BaseMapOverlay(int i6, Context context, IAMap iAMap) {
        this.mItemList = null;
        this.mEngineID = i6;
        this.mContext = context;
        try {
            this.mMapView = (IAMapDelegate) iAMap;
        } catch (Throwable unused) {
        }
        this.mItemList = new Vector<>();
        iniGLOverlay();
    }

    public void releaseInstance() {
        if (getGLOverlay() != null) {
            IAMapDelegate iAMapDelegate = this.mMapView;
            if (iAMapDelegate != null && iAMapDelegate.isMaploaded()) {
                this.mMapView.removeEngineGLOverlay(this);
            }
            getGLOverlay().releaseInstance();
            this.mGLOverlay = null;
        }
    }

    public boolean removeAll() {
        return clear();
    }

    public void removeItem(E e6) {
        if (e6 == null) {
            return;
        }
        try {
            synchronized (this.mItemList) {
                removeItem(this.mItemList.indexOf(e6));
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }
}
