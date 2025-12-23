package com.bytedance.sdk.component.panglearmor.xt;

import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import com.umeng.analytics.pro.bi;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class cw {
    public static float[] j(List<Float> list, List<Float> list2, List<Float> list3, List<Float> list4, List<Float> list5, List<Float> list6) {
        float f6;
        float f7;
        char c6;
        char c7;
        int min = Math.min(list.size(), list4.size());
        float f8 = 0.0f;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i6 = 0; i6 < min; i6++) {
            Float f11 = list.get(i6);
            Float f12 = list2.get(i6);
            Float f13 = list3.get(i6);
            Float f14 = list4.get(i6);
            c6 = 0;
            Float f15 = list5.get(i6);
            c7 = 2;
            Float f16 = list6.get(i6);
            if (f11 == null || f12 == null || f13 == null || f14 == null || f15 == null || f16 == null) {
                f6 = f8;
                f7 = f9;
                break;
            }
            float[] fArr = new float[9];
            SensorManager.getRotationMatrix(fArr, null, new float[]{f11.floatValue(), f12.floatValue(), f13.floatValue()}, new float[]{f14.floatValue(), f15.floatValue(), f16.floatValue()});
            SensorManager.getOrientation(fArr, new float[3]);
            f8 += (((float) Math.toDegrees(r7[0])) + 360.0f) % 360.0f;
            f9 += (((float) Math.toDegrees(r7[1])) + 360.0f) % 360.0f;
            f10 += (((float) Math.toDegrees(r7[2])) + 360.0f) % 360.0f;
        }
        f6 = f8;
        f7 = f9;
        c6 = 0;
        c7 = 2;
        if (min == 0) {
            return new float[]{0.0f, 0.0f, 0.0f};
        }
        float f17 = min;
        float f18 = f6 / f17;
        float f19 = f7 / f17;
        float f20 = f10 / f17;
        float[] fArr2 = new float[3];
        fArr2[c6] = f18;
        fArr2[1] = f19;
        fArr2[c7] = f20;
        return fArr2;
    }

    @NonNull
    public static int[][] j(List<JSONObject> list, long j6, long j7) throws JSONException {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        double[] dArr3 = new double[size];
        for (int i6 = 0; i6 < size; i6++) {
            JSONArray optJSONArray = list.get(i6).optJSONArray("val");
            if (optJSONArray != null && optJSONArray.length() == 3) {
                dArr[i6] = optJSONArray.getDouble(0);
                dArr2[i6] = optJSONArray.getDouble(1);
                dArr3[i6] = optJSONArray.getDouble(2);
            }
        }
        return new int[][]{j(dArr, j6), j(dArr2, j7), j(dArr3, j7)};
    }

    @NonNull
    public static int[] j(double[] dArr, long j6) {
        if (j6 > 0 && j6 <= 360) {
            int[] iArr = new int[(int) (360 / j6)];
            for (double d6 : dArr) {
                int i6 = (int) (d6 / j6);
                iArr[i6] = iArr[i6] + 1;
            }
            return iArr;
        }
        return new int[0];
    }

    @NonNull
    public static int[] j(LinkedList<JSONObject> linkedList, int i6) {
        int[] iArr = new int[i6];
        if (linkedList.size() > 0) {
            int optLong = (int) (((linkedList.getLast().optLong(bi.aL, 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = linkedList.iterator();
            while (it.hasNext()) {
                int optLong2 = optLong - ((int) (((it.next().optLong(bi.aL, 0L) / 1000) / 60) / 60));
                if (optLong2 >= 0 && optLong2 < i6) {
                    iArr[optLong2] = iArr[optLong2] + 1;
                }
            }
        }
        return iArr;
    }
}
