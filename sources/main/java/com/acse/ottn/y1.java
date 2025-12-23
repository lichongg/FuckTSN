package com.acse.ottn;

import com.acse.ottn.model.AccessiblityModel;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class y1 {

    /* renamed from: a, reason: collision with root package name */
    public static y1 f5525a;

    public void a() {
        j3.a().b("tb_lj_data", "");
    }

    public static y1 b() {
        if (f5525a == null) {
            synchronized (y1.class) {
                try {
                    if (f5525a == null) {
                        f5525a = new y1();
                    }
                } finally {
                }
            }
        }
        return f5525a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        j3.a().b("tb_lj_data", JSON.toJSONString(accessiblityModel));
    }

    public final Object c() throws ObjectStreamException {
        return f5525a;
    }
}
