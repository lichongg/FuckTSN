package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class x5 implements f4 {

    /* renamed from: a, reason: collision with root package name */
    private List<f4> f35005a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.f4
    public void a(@NonNull w5 w5Var, long j6) {
        Iterator<f4> it = this.f35005a.iterator();
        while (it.hasNext()) {
            it.next().a(w5Var, j6);
        }
    }

    public void a(@NonNull f4 f4Var) {
        if (this.f35005a == null) {
            this.f35005a = new ArrayList();
        }
        this.f35005a.add(f4Var);
    }
}
