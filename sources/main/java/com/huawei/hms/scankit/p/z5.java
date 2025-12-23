package com.huawei.hms.scankit.p;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class z5 implements g4 {

    /* renamed from: a, reason: collision with root package name */
    private List<g4> f35074a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.g4
    public void a(@NonNull w5 w5Var) {
        Iterator<g4> it = this.f35074a.iterator();
        while (it.hasNext()) {
            it.next().a(w5Var);
        }
    }

    public void a(@NonNull g4 g4Var) {
        if (this.f35074a == null) {
            this.f35074a = new ArrayList();
        }
        this.f35074a.add(g4Var);
    }
}
