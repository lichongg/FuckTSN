package com.huawei.hms.feature.dynamic;

import android.os.Bundle;
import com.huawei.hms.common.util.Logger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public static final String f33233b = "d";

    /* renamed from: c, reason: collision with root package name */
    public static final d f33234c = new d();

    /* renamed from: a, reason: collision with root package name */
    public Set<String> f33235a;

    public static d a() {
        return f33234c;
    }

    public void a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("installed_module_name");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            Logger.w(f33233b, "Get installed module name failed.");
            this.f33235a = new HashSet();
            return;
        }
        Logger.i(f33233b, "Installed module name:" + stringArrayList);
        this.f33235a = new HashSet(stringArrayList);
    }
}
