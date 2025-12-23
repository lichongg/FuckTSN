package com.bytedance.sdk.component.m.r;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends j {
    @Override // com.bytedance.sdk.component.m.r.g
    public void j(com.bytedance.sdk.component.m.cw.cw cwVar) {
        List<com.bytedance.sdk.component.m.cw.cw> list;
        String x5 = cwVar.x();
        Map<String, List<com.bytedance.sdk.component.m.cw.cw>> ae = cwVar.kt().ae();
        synchronized (ae) {
            try {
                list = ae.get(x5);
                if (list == null) {
                    list = new LinkedList<>();
                }
            } finally {
            }
        }
        synchronized (list) {
            try {
                list.add(cwVar);
                ae.put(x5, list);
                if (list.size() <= 1) {
                    cwVar.j(new r());
                }
            } finally {
            }
        }
    }

    @Override // com.bytedance.sdk.component.m.r.g
    public String j() {
        return "check_duplicate";
    }
}
