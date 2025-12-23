package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class PermissionUtils {
    public static boolean checkPermission(Context context, String str) {
        return checkPermissions(context, Arrays.asList(str)).get(0).booleanValue();
    }

    public static List<Boolean> checkPermissions(Context context, List<String> list) {
        boolean z5;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (packageManager.checkPermission(it.next(), packageName) != -1) {
                z5 = true;
            } else {
                z5 = false;
            }
            arrayList.add(Boolean.valueOf(z5));
        }
        return arrayList;
    }
}
