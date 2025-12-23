package com.bytedance.sdk.component.ae.cw;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements com.bytedance.sdk.component.ae.j, com.bytedance.sdk.component.ae.xt {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.component.r.j.j f26068j;
    private final boolean xt = false;

    @Override // com.bytedance.sdk.component.ae.j
    public Map<String, Object> j(File file) {
        if (file.getName().endsWith(".prop")) {
            return new xt(this.f26068j, this.xt).j(file);
        }
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        return (!file2.exists() || file2.length() <= 0) ? file.getName().endsWith("xml") ? up.j() ? new up(this.f26068j, this.xt).j(file) : new m(this.f26068j, this.xt).j(file) : new ConcurrentHashMap() : new xt(this.f26068j, this.xt).j(file2);
    }

    public j(com.bytedance.sdk.component.r.j.j jVar) {
        this.f26068j = jVar;
    }

    @Override // com.bytedance.sdk.component.ae.xt
    public void j(Map<String, Object> map, File file) throws IOException {
        if (!file.getName().endsWith(".prop")) {
            file = new File(file.getParent(), file.getName() + ".prop");
        }
        file.setReadable(true, false);
        new xt(this.f26068j, this.xt).j(map, file);
    }
}
