package com.amap.api.maps.model;

import android.util.Pair;
import com.amap.api.col.p0003l.eq;
import com.amap.api.col.p0003l.er;
import com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class RouteOverlay {
    private IRouteOverlayInner mBaseRouteOverlay;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum MapRouteScene {
        NORMAL,
        CHARGE,
        LIMIT,
        CIMMUTE,
        WRONG,
        SHARE,
        HD
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class RouteOverlayHighLightParam {
        public int arrowColorNormal;
        public int borderColorHightLight;
        public int borderColorNormal;
        public int fillColorHightLight;
        public int fillColorNormal;
    }

    public Pair<Float, Float> getDisplayRange() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return null;
            }
            return iRouteOverlayInner.getDisplayRange();
        } catch (Exception e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public void addRouteItem(int i6, er[] erVarArr, boolean z5, eq eqVar, int[] iArr) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteItem(i6, erVarArr, z5 ? 1 : 0, eqVar, iArr);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void addRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.addRouteName();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public int getOverlayPriority() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.getOverlayProperty();
            }
            return 0;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                return iRouteOverlayInner.isVisible();
            }
            return false;
        } catch (Exception e6) {
            e6.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.remove();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void removeRouteName() {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.removeRouteName();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrow3DTexture(bitmapDescriptor);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setArrowFlow(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setArrowFlow(z5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setCar2DPosition(int i6, float f6) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setCar2DPosition(i6, f6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setDisplayRange(float f6, float f7) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setDisplayRange(f6, f7);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setHighlightParam(RouteOverlayHighLightParam routeOverlayHighLightParam) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightParam(routeOverlayHighLightParam);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setHighlightType(int i6) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setHighlightType(i6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setLine2DWidth(int i6, int i7) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLine2DWidth(i6, i7);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setLineWidthScale(float f6) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setLineWidthScale(f6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setOverlayPriority(int i6) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner == null) {
                return;
            }
            iRouteOverlayInner.setOverlayProperty(i6);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setRouteItemParam(er erVar) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setRouteItemParam(erVar);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setSelectStatus(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setSelectStatus(z5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setShowArrow(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowArrow(z5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setShowNaviRouteNameCountMap(map);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            IRouteOverlayInner iRouteOverlayInner = this.mBaseRouteOverlay;
            if (iRouteOverlayInner != null) {
                iRouteOverlayInner.setVisible(z5);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public RouteOverlay(IRouteOverlayInner iRouteOverlayInner) {
        this.mBaseRouteOverlay = iRouteOverlayInner;
    }
}
