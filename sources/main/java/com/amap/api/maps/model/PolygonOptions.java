package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.amap.api.col.p0003l.b3;
import com.amap.api.maps.model.AMapPara;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@JBindingInclude
/* loaded from: D:\Downloads\app\classes2.dex */
public final class PolygonOptions extends BaseOptions implements Parcelable, Cloneable {

    @JBindingExclude
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();

    /* renamed from: a, reason: collision with root package name */
    @JBindingExclude
    String f8983a;
    private float strokeWidth = 10.0f;
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    private int fillColor = ViewCompat.MEASURED_STATE_MASK;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private boolean isUsePolylineStroke = true;

    @JBindingExclude
    private AMapPara.LineJoinType lineJoinType = AMapPara.LineJoinType.LineJoinBevel;
    private int nLineCapType = 3;
    private int nLineJoinType = 0;
    private PolygonUpdateFlags updateFlags = new PolygonUpdateFlags();
    private final List<LatLng> points = new ArrayList();
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    public final PolygonOptions add(LatLng latLng) {
        try {
            this.points.add(latLng);
            this.updateFlags.isPointsUpdated = true;
            a();
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public final PolygonOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr == null) {
            return this;
        }
        try {
            this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
            a();
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @JBindingInclude
    protected static class PolygonUpdateFlags extends BaseOptions.BaseUpdateFlags {
        protected boolean isPointsUpdated = false;
        protected boolean isHoleOptionsUpdated = false;

        protected PolygonUpdateFlags() {
        }

        @Override // com.amap.api.maps.model.BaseOptions.BaseUpdateFlags
        public void reset() {
            super.reset();
            this.isPointsUpdated = false;
            this.isHoleOptionsUpdated = false;
        }
    }

    private void a() {
        if (this.holeOptions != null) {
            ArrayList arrayList = new ArrayList();
            List<BaseHoleOptions> list = this.holeOptions;
            for (int i6 = 0; i6 < list.size(); i6++) {
                BaseHoleOptions baseHoleOptions = list.get(i6);
                if (baseHoleOptions instanceof PolygonHoleOptions) {
                    PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                    if (b3.b0(getPoints(), polygonHoleOptions) && !b3.O(arrayList, polygonHoleOptions)) {
                        arrayList.add(polygonHoleOptions);
                    }
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                    if (b3.Q(getPoints(), arrayList, circleHoleOptions) && !b3.N(arrayList, circleHoleOptions)) {
                        arrayList.add(circleHoleOptions);
                    }
                }
            }
            this.holeOptions.clear();
            this.holeOptions.addAll(arrayList);
            this.updateFlags.isHoleOptionsUpdated = true;
        }
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            try {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    this.points.add(it.next());
                }
                a();
                this.updateFlags.isPointsUpdated = true;
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final PolygonOptions m57clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e6) {
            e6.printStackTrace();
        }
        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.points.addAll(this.points);
        polygonOptions.strokeWidth = this.strokeWidth;
        polygonOptions.strokeColor = this.strokeColor;
        polygonOptions.fillColor = this.fillColor;
        polygonOptions.zIndex = this.zIndex;
        polygonOptions.isVisible = this.isVisible;
        polygonOptions.holeOptions = this.holeOptions;
        polygonOptions.f8983a = this.f8983a;
        polygonOptions.isUsePolylineStroke = this.isUsePolylineStroke;
        polygonOptions.lineJoinType = this.lineJoinType;
        polygonOptions.nLineCapType = this.nLineCapType;
        polygonOptions.nLineJoinType = this.nLineJoinType;
        polygonOptions.updateFlags = this.updateFlags;
        return polygonOptions;
    }

    public final PolygonOptions fillColor(int i6) {
        this.fillColor = i6;
        return this;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public final AMapPara.LineJoinType getLineJoinType() {
        return this.lineJoinType;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final PolygonUpdateFlags getUpdateFlags() {
        return this.updateFlags;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolygonOptions lineJoinType(AMapPara.LineJoinType lineJoinType) {
        if (lineJoinType != null) {
            this.lineJoinType = lineJoinType;
            this.nLineJoinType = lineJoinType.getTypeValue();
        }
        return this;
    }

    @Override // com.amap.api.maps.model.BaseOptions
    public final void resetUpdateFlags() {
        this.updateFlags.reset();
    }

    public final void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.holeOptions.clear();
            if (list != null) {
                this.holeOptions.addAll(list);
            }
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.points.clear();
            if (list == null) {
                return;
            }
            this.points.addAll(list);
            a();
            this.updateFlags.isPointsUpdated = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final PolygonOptions strokeColor(int i6) {
        this.strokeColor = i6;
        return this;
    }

    public final PolygonOptions strokeWidth(float f6) {
        this.strokeWidth = f6;
        return this;
    }

    public final PolygonOptions usePolylineStroke(boolean z5) {
        this.isUsePolylineStroke = z5;
        return this;
    }

    public final PolygonOptions visible(boolean z5) {
        this.isVisible = z5;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i6) {
        parcel.writeTypedList(this.points);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f8983a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.lineJoinType.getTypeValue());
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public final PolygonOptions zIndex(float f6) {
        float f7 = this.zIndex;
        if (f7 != f7) {
            this.updateFlags.zIndexUpdate = true;
        }
        this.zIndex = f6;
        return this;
    }

    public PolygonOptions() {
        this.type = "PolygonOptions";
    }

    public final PolygonOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable == null) {
            return this;
        }
        try {
            Iterator<BaseHoleOptions> it = iterable.iterator();
            while (it.hasNext()) {
                this.holeOptions.add(it.next());
            }
            a();
            return this;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        if (latLngArr != null) {
            try {
                this.points.addAll(Arrays.asList(latLngArr));
                this.updateFlags.isPointsUpdated = true;
                a();
                return this;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
