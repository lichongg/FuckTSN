package com.huawei.hms.framework.common.hianalytics;

import java.util.LinkedHashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class LinkedHashMapPack {

    /* renamed from: a, reason: collision with root package name */
    private LinkedHashMap<String, String> f33390a = new LinkedHashMap<>();

    public LinkedHashMapPack put(String str, String str2) {
        if (str != null && str2 != null) {
            this.f33390a.put(str, str2);
        }
        return this;
    }

    public LinkedHashMap<String, String> getAll() {
        return this.f33390a;
    }

    public LinkedHashMapPack put(String str, boolean z5) {
        if (str != null) {
            if (z5) {
                this.f33390a.put(str, "1");
                return this;
            }
            this.f33390a.put(str, "0");
        }
        return this;
    }

    public LinkedHashMapPack putIfNotDefault(String str, long j6, long j7) {
        return j6 == j7 ? this : put(str, j6);
    }

    public LinkedHashMapPack put(String str, long j6) {
        if (str != null) {
            this.f33390a.put(str, "" + j6);
        }
        return this;
    }
}
