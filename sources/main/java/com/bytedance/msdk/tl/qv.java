package com.bytedance.msdk.tl;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class qv {

    /* renamed from: j, reason: collision with root package name */
    private static boolean f25228j;
    private static boolean xt;

    public static List<String> j() {
        ArrayList arrayList = null;
        if (!com.bytedance.msdk.core.j.qv().ch()) {
            return null;
        }
        Field[] declaredFields = com.bytedance.msdk.core.oq.xt.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mTotalWaterFallCount");
            arrayList.remove("mWaterFallConfigList");
            arrayList.remove("mWaterFallConfMap");
            arrayList.remove("mTotalLoadLevelCount");
            arrayList.remove("mCurrentCommonAdMaxCpm");
            arrayList.remove("mLoadSortLevelList");
            arrayList.remove("hasServerBidding");
            arrayList.remove("hasClientOrMultiLevel");
            arrayList.remove("mRitInfoJson");
        }
        return arrayList;
    }

    public static void xt(List<String> list, String str) {
    }

    public static List<String> xt() {
        ArrayList arrayList = null;
        if (!com.bytedance.msdk.core.j.qv().ch()) {
            return null;
        }
        Field[] declaredFields = com.bytedance.msdk.core.oq.oq.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mServerBiddingWinner");
        }
        return arrayList;
    }

    public static void j(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }
}
