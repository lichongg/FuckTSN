package com.bxkj.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class y {
    public static List<Integer> a(int i6, int i7) {
        Random random = new Random();
        HashSet hashSet = new HashSet();
        while (hashSet.size() < i7) {
            hashSet.add(Integer.valueOf(random.nextInt(i6) + 1));
        }
        com.orhanobut.logger.j.c("随机输入的十个数：" + hashSet);
        ArrayList arrayList = new ArrayList(hashSet);
        Collections.sort(arrayList);
        com.orhanobut.logger.j.c("排好序之后的列表：" + arrayList);
        return arrayList;
    }
}
