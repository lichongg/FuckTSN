package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class ar implements Comparator<Map.Entry<String, Long>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ aq f10637a;

    ar(aq aqVar) {
        this.f10637a = aqVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
