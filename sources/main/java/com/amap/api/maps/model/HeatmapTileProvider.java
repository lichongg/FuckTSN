package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.collection.LongSparseArray;
import com.amap.api.col.p0003l.l2;
import com.amap.api.maps.AMapException;
import com.autonavi.amap.mapcore.DPoint;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT;
    private static final int[] DEFAULT_GRADIENT_COLORS;
    private static final float[] DEFAULT_GRADIENT_START_POINTS;
    private static final int DEFAULT_MAX_ZOOM = 11;
    private static final int DEFAULT_MIN_ZOOM = 5;
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int MAX_RADIUS = 200;
    private static final int MAX_ZOOM_LEVEL = 21;
    private static final int MIN_RADIUS = 10;
    private static final int SCREEN_SIZE = 1280;
    private static final int TILE_DIM = 256;
    private l2 mBounds;
    private int[] mColorMap;
    private Collection<WeightedLatLng> mData;
    private Gradient mGradient;
    private double[] mKernel;
    private double[] mMaxIntensity;
    private double mOpacity;
    private int mRadius;
    private a mTree;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        private Collection<WeightedLatLng> data;
        private int radius = 12;
        private Gradient gradient = HeatmapTileProvider.DEFAULT_GRADIENT;
        private double opacity = 0.6d;

        public HeatmapTileProvider build() {
            Collection<WeightedLatLng> collection = this.data;
            if (collection != null && collection.size() != 0) {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
            try {
                throw new AMapException("No input points.");
            } catch (AMapException e6) {
                e6.getErrorMessage();
                e6.printStackTrace();
                return null;
            }
        }

        public Builder gradient(Gradient gradient) {
            this.gradient = gradient;
            return this;
        }

        public Builder radius(int i6) {
            this.radius = Math.max(10, Math.min(i6, 200));
            return this;
        }

        public Builder transparency(double d6) {
            this.opacity = Math.max(0.0d, Math.min(d6, 1.0d));
            return this;
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.data = collection;
            return this;
        }

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.c(collection));
        }
    }

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b6) {
        this(builder);
    }

    static {
        int[] iArr = {Color.rgb(102, l.f50687n, 0), Color.rgb(255, 0, 0)};
        DEFAULT_GRADIENT_COLORS = iArr;
        float[] fArr = {0.2f, 1.0f};
        DEFAULT_GRADIENT_START_POINTS = fArr;
        DEFAULT_GRADIENT = new Gradient(iArr, fArr);
    }

    private HeatmapTileProvider(Builder builder) {
        this.mData = builder.data;
        this.mRadius = builder.radius;
        Gradient gradient = builder.gradient;
        this.mGradient = gradient;
        if (gradient == null || !gradient.isAvailable()) {
            this.mGradient = DEFAULT_GRADIENT;
        }
        this.mOpacity = builder.opacity;
        int i6 = this.mRadius;
        this.mKernel = a(i6, i6 / 3.0d);
        a(this.mGradient);
        b(this.mData);
    }

    private void a(Gradient gradient) {
        this.mGradient = gradient;
        this.mColorMap = gradient.generateColorMap(this.mOpacity);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng weightedLatLng : collection) {
                double d6 = weightedLatLng.latLng.latitude;
                if (d6 < 85.0d && d6 > -85.0d) {
                    arrayList.add(weightedLatLng);
                }
            }
            this.mData = arrayList;
            l2 d7 = d(arrayList);
            this.mBounds = d7;
            this.mTree = new a(d7);
            Iterator<WeightedLatLng> it = this.mData.iterator();
            while (it.hasNext()) {
                this.mTree.a(it.next());
            }
            this.mMaxIntensity = a(this.mRadius);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Collection<WeightedLatLng> c(Collection<LatLng> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<LatLng> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng(it.next()));
        }
        return arrayList;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i6, int i7, int i8) {
        double d6 = 1.0d;
        double pow = 1.0d / Math.pow(2.0d, i8);
        double d7 = (this.mRadius * pow) / 256.0d;
        double d8 = ((2.0d * d7) + pow) / ((r10 * 2) + 256);
        double d9 = (i6 * pow) - d7;
        double d10 = ((i6 + 1) * pow) + d7;
        double d11 = (i7 * pow) - d7;
        double d12 = ((i7 + 1) * pow) + d7;
        Collection<WeightedLatLng> arrayList = new ArrayList<>();
        if (d9 < 0.0d) {
            arrayList = this.mTree.a(new l2(d9 + 1.0d, 1.0d, d11, d12));
            d6 = -1.0d;
        } else if (d10 > 1.0d) {
            arrayList = this.mTree.a(new l2(0.0d, d10 - 1.0d, d11, d12));
        } else {
            d6 = 0.0d;
        }
        l2 l2Var = new l2(d9, d10, d11, d12);
        l2 l2Var2 = this.mBounds;
        if (!l2Var.c(new l2(l2Var2.f6728a - d7, l2Var2.f6730c + d7, l2Var2.f6729b - d7, l2Var2.f6731d + d7))) {
            return TileProvider.NO_TILE;
        }
        Collection<WeightedLatLng> a6 = this.mTree.a(l2Var);
        if (a6.isEmpty()) {
            return TileProvider.NO_TILE;
        }
        int i9 = this.mRadius;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, (i9 * 2) + 256, (i9 * 2) + 256);
        for (WeightedLatLng weightedLatLng : a6) {
            DPoint point = weightedLatLng.getPoint();
            int i10 = (int) ((point.f9903x - d9) / d8);
            int i11 = (int) ((point.f9904y - d11) / d8);
            double[] dArr2 = dArr[i10];
            dArr2[i11] = dArr2[i11] + weightedLatLng.intensity;
        }
        for (WeightedLatLng weightedLatLng2 : arrayList) {
            DPoint point2 = weightedLatLng2.getPoint();
            int i12 = (int) (((point2.f9903x + d6) - d9) / d8);
            int i13 = (int) ((point2.f9904y - d11) / d8);
            double[] dArr3 = dArr[i12];
            dArr3[i13] = dArr3[i13] + weightedLatLng2.intensity;
        }
        return a(a(a(dArr, this.mKernel), this.mColorMap, this.mMaxIntensity[i8]));
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    private static l2 d(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d6 = next.getPoint().f9903x;
        double d7 = next.getPoint().f9903x;
        double d8 = d6;
        double d9 = d7;
        double d10 = next.getPoint().f9904y;
        double d11 = next.getPoint().f9904y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d12 = next2.getPoint().f9903x;
            double d13 = next2.getPoint().f9904y;
            if (d12 < d8) {
                d8 = d12;
            }
            if (d12 > d9) {
                d9 = d12;
            }
            if (d13 < d10) {
                d10 = d13;
            }
            if (d13 > d11) {
                d11 = d13;
            }
        }
        return new l2(d8, d9, d10, d11);
    }

    private double[] a(int i6) {
        int i7;
        double[] dArr = new double[21];
        int i8 = 5;
        while (true) {
            if (i8 >= 11) {
                break;
            }
            dArr[i8] = a(this.mData, this.mBounds, i6, (int) (Math.pow(2.0d, i8) * 1280.0d));
            if (i8 == 5) {
                for (int i9 = 0; i9 < i8; i9++) {
                    dArr[i9] = dArr[i8];
                }
            }
            i8++;
        }
        for (i7 = 11; i7 < 21; i7++) {
            dArr[i7] = dArr[10];
        }
        return dArr;
    }

    private static Tile a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return Tile.obtain(256, 256, byteArrayOutputStream.toByteArray());
    }

    private static double[] a(int i6, double d6) {
        double[] dArr = new double[(i6 * 2) + 1];
        for (int i7 = -i6; i7 <= i6; i7++) {
            dArr[i7 + i6] = Math.exp(((-i7) * i7) / ((2.0d * d6) * d6));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        double d6;
        int floor = (int) Math.floor(dArr2.length / 2.0d);
        int length = dArr.length;
        int i6 = length - (floor * 2);
        int i7 = floor + i6;
        int i8 = i7 - 1;
        Class cls = Double.TYPE;
        double[][] dArr3 = (double[][]) Array.newInstance((Class<?>) cls, length, length);
        int i9 = 0;
        while (true) {
            double d7 = 0.0d;
            if (i9 >= length) {
                break;
            }
            int i10 = 0;
            while (i10 < length) {
                double d8 = dArr[i9][i10];
                if (d8 != d7) {
                    int i11 = i9 + floor;
                    if (i8 < i11) {
                        i11 = i8;
                    }
                    int i12 = i11 + 1;
                    int i13 = i9 - floor;
                    d6 = d7;
                    for (int i14 = floor > i13 ? floor : i13; i14 < i12; i14++) {
                        double[] dArr4 = dArr3[i14];
                        dArr4[i10] = dArr4[i10] + (dArr2[i14 - i13] * d8);
                    }
                } else {
                    d6 = d7;
                }
                i10++;
                d7 = d6;
            }
            i9++;
        }
        double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, i6, i6);
        for (int i15 = floor; i15 < i7; i15++) {
            for (int i16 = 0; i16 < length; i16++) {
                double d9 = dArr3[i15][i16];
                if (d9 != 0.0d) {
                    int i17 = i16 + floor;
                    if (i8 < i17) {
                        i17 = i8;
                    }
                    int i18 = i17 + 1;
                    int i19 = i16 - floor;
                    for (int i20 = floor > i19 ? floor : i19; i20 < i18; i20++) {
                        double[] dArr6 = dArr5[i15 - floor];
                        int i21 = i20 - floor;
                        dArr6[i21] = dArr6[i21] + (dArr2[i20 - i19] * d9);
                    }
                }
            }
        }
        return dArr5;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d6) {
        int i6 = iArr[iArr.length - 1];
        double length = (iArr.length - 1) / d6;
        int length2 = dArr.length;
        int[] iArr2 = new int[length2 * length2];
        for (int i7 = 0; i7 < length2; i7++) {
            for (int i8 = 0; i8 < length2; i8++) {
                double d7 = dArr[i8][i7];
                int i9 = (i7 * length2) + i8;
                int i10 = (int) (d7 * length);
                if (d7 != 0.0d) {
                    if (i10 < iArr.length) {
                        iArr2[i9] = iArr[i10];
                    } else {
                        iArr2[i9] = i6;
                    }
                } else {
                    iArr2[i9] = 0;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }

    private static double a(Collection<WeightedLatLng> collection, l2 l2Var, int i6, int i7) {
        double d6 = l2Var.f6728a;
        double d7 = l2Var.f6730c;
        double d8 = l2Var.f6729b;
        double d9 = d7 - d6;
        double d10 = l2Var.f6731d - d8;
        if (d9 <= d10) {
            d9 = d10;
        }
        double d11 = ((int) ((i7 / (i6 * 2)) + 0.5d)) / d9;
        LongSparseArray longSparseArray = new LongSparseArray();
        double d12 = 0.0d;
        for (WeightedLatLng weightedLatLng : collection) {
            double d13 = weightedLatLng.getPoint().f9903x;
            int i8 = (int) ((weightedLatLng.getPoint().f9904y - d8) * d11);
            long j6 = (int) ((d13 - d6) * d11);
            LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j6);
            if (longSparseArray2 == null) {
                longSparseArray2 = new LongSparseArray();
                longSparseArray.put(j6, longSparseArray2);
            }
            long j7 = i8;
            Double d14 = (Double) longSparseArray2.get(j7);
            if (d14 == null) {
                d14 = Double.valueOf(0.0d);
            }
            LongSparseArray longSparseArray3 = longSparseArray;
            double d15 = d6;
            double doubleValue = d14.doubleValue() + weightedLatLng.intensity;
            longSparseArray2.put(j7, Double.valueOf(doubleValue));
            if (doubleValue > d12) {
                d12 = doubleValue;
            }
            longSparseArray = longSparseArray3;
            d6 = d15;
        }
        return d12;
    }
}
