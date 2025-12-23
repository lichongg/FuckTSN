package cn.jiguang.bo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes2.dex */
final class j {

    /* renamed from: a, reason: collision with root package name */
    private final k f2446a;

    private cn.jiguang.bp.d a(Throwable th, cn.jiguang.bp.c cVar, Thread thread, boolean z5) {
        Package r02 = th.getClass().getPackage();
        String name = th.getClass().getName();
        cn.jiguang.bp.d dVar = new cn.jiguang.bp.d();
        String message = th.getMessage();
        if (r02 != null) {
            name = name.replace(r02.getName() + ".", "");
        }
        String name2 = r02 != null ? r02.getName() : null;
        List<cn.jiguang.bp.f> a6 = this.f2446a.a(th.getStackTrace());
        if (a6 != null && !a6.isEmpty()) {
            if (!a(thread) && !a(a6)) {
                return null;
            }
            cn.jiguang.bp.g gVar = new cn.jiguang.bp.g(a6);
            if (z5) {
                gVar.a(Boolean.TRUE);
            }
            dVar.a(gVar);
        }
        if (thread != null) {
            dVar.a(Long.valueOf(thread.getId()));
        }
        dVar.a(name);
        dVar.a(cVar);
        dVar.c(name2);
        dVar.b(message);
        return dVar;
    }

    List<cn.jiguang.bp.d> a(Throwable th) {
        return a(b(th));
    }

    Deque<cn.jiguang.bp.d> b(Throwable th) {
        Thread currentThread;
        boolean z5;
        cn.jiguang.bp.c cVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            if (th instanceof c) {
                c cVar2 = (c) th;
                cn.jiguang.bp.c a6 = cVar2.a();
                Throwable b6 = cVar2.b();
                currentThread = cVar2.c();
                z5 = cVar2.d();
                th = b6;
                cVar = a6;
            } else {
                currentThread = Thread.currentThread();
                z5 = false;
                cVar = null;
            }
            arrayDeque.addFirst(a(th, cVar, currentThread, z5));
            th = th.getCause();
        }
        return arrayDeque;
    }

    public j(k kVar) {
        this.f2446a = kVar;
    }

    private List<cn.jiguang.bp.d> a(Deque<cn.jiguang.bp.d> deque) {
        return new ArrayList(deque);
    }

    boolean a(Thread thread) {
        if (thread.getName() != null) {
            return thread.getName().contains("jg");
        }
        return false;
    }

    boolean a(List<cn.jiguang.bp.f> list) {
        Iterator<cn.jiguang.bp.f> it = list.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 = z5 || it.next().h().booleanValue();
            if (z5) {
                break;
            }
        }
        return z5;
    }
}
