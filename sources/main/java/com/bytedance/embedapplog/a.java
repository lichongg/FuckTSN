package com.bytedance.embedapplog;

import java.util.LinkedList;

/* loaded from: D:\Downloads\app\classes3.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    private static final LinkedList<ya> f23977j = new LinkedList<>();
    private static final LinkedList<ya> xt = new LinkedList<>();

    public static void j(ya yaVar) {
        LinkedList<ya> linkedList = f23977j;
        synchronized (linkedList) {
            try {
                if (linkedList.size() > 200) {
                    ya poll = linkedList.poll();
                    uc.xt("drop event in cache", null);
                    xt.add(poll);
                }
                linkedList.add(yaVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void j() {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        LinkedList<ya> linkedList3 = f23977j;
        synchronized (linkedList3) {
            linkedList.addAll(linkedList3);
            LinkedList<ya> linkedList4 = xt;
            linkedList2.addAll(linkedList4);
            linkedList3.clear();
            linkedList4.clear();
        }
        while (!linkedList.isEmpty()) {
            f.j((ya) linkedList.poll());
        }
    }
}
