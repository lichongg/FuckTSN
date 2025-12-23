package com.bytedance.sdk.openadsdk.core.qv.xt;

import com.bytedance.sdk.openadsdk.core.qv.xt.xt;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\Downloads\app\classes4.dex */
public class up implements j {

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentHashMap<Integer, j> f30004j = new ConcurrentHashMap<>();

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void cw(long j6, long j7, String str, String str2) {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xt.j().j(next.getValue()).j("onDownloadFailed").j(j6).xt(j7).xt(str).cw(str2).j();
            }
        }
    }

    public void j(j jVar) {
        if (jVar != null) {
            this.f30004j.put(Integer.valueOf(jVar.hashCode()), jVar);
        }
    }

    public void xt() {
        if (this.f30004j.isEmpty()) {
            return;
        }
        this.f30004j.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void j() {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xt.j().j(next.getValue()).j("onIdle").j();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void xt(long j6, long j7, String str, String str2) {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xt.j().j(next.getValue()).j("onDownloadPaused").j(j6).xt(j7).xt(str).cw(str2).j();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void j(long j6, long j7, String str, String str2) {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xt.j().j(next.getValue()).j("onDownloadActive").j(j6).xt(j7).xt(str).cw(str2).j();
            }
        }
    }

    public boolean cw() {
        return this.f30004j.size() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void j(String str, String str2) {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().j(str, str2);
                new xt.j().j(next.getValue()).j("onInstalled").xt(str).cw(str2).j();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.qv.xt.j
    public void j(long j6, String str, String str2) {
        Iterator<Map.Entry<Integer, j>> it = this.f30004j.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, j> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new xt.j().j(next.getValue()).j("onDownloadFinished").j(j6).xt(str).cw(str2).j();
            }
        }
    }
}
