package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f40530a;

    public c(Bundle bundle) {
        this.f40530a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f40530a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f40530a.get("time") + ", name=" + this.f40530a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> hashMap) {
        this.f40530a = new HashMap<>(hashMap);
    }
}
