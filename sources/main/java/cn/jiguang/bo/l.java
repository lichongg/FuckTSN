package cn.jiguang.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes2.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    private final k f2447a;

    private cn.jiguang.bp.h a(boolean z5, StackTraceElement[] stackTraceElementArr, Thread thread) {
        cn.jiguang.bp.h hVar = new cn.jiguang.bp.h();
        hVar.a(thread.getName());
        hVar.a(Integer.valueOf(thread.getPriority()));
        hVar.a(Long.valueOf(thread.getId()));
        hVar.c(Boolean.valueOf(thread.isDaemon()));
        hVar.b(thread.getState().name());
        hVar.a(Boolean.valueOf(z5));
        hVar.b(Boolean.valueOf(cn.jiguang.bu.a.a(thread)));
        cn.jiguang.bp.g gVar = new cn.jiguang.bp.g(this.f2447a.a(stackTraceElementArr));
        gVar.a(Boolean.TRUE);
        hVar.a(gVar);
        return hVar;
    }

    List<cn.jiguang.bp.h> a(List<Long> list) {
        return a(Thread.getAllStackTraces(), list);
    }

    public l(k kVar) {
        this.f2447a = kVar;
    }

    List<cn.jiguang.bp.h> a(Map<Thread, StackTraceElement[]> map, List<Long> list) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry<Thread, StackTraceElement[]> entry : map.entrySet()) {
            Thread key = entry.getKey();
            arrayList.add(a(key == currentThread || (list != null && list.contains(Long.valueOf(key.getId()))), entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }
}
