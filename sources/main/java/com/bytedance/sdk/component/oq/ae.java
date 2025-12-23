package com.bytedance.sdk.component.oq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\Downloads\app\classes4.dex */
public class ae extends m {
    public static j xt;

    /* renamed from: j, reason: collision with root package name */
    public static final int f26611j = Runtime.getRuntime().availableProcessors();
    public static boolean cw = true;

    /* renamed from: r, reason: collision with root package name */
    public static int f26612r = 120;

    public static void cw(g gVar) {
        xt().execute(gVar);
    }

    public static void j(g gVar) {
        gVar.setPriority(10);
        qv.xt.oq().execute(gVar);
    }

    public static void r(g gVar) {
        qv.xt.jy().execute(gVar);
    }

    public static boolean up() {
        return cw;
    }

    public static void xt(g gVar) {
        j().execute(gVar);
    }

    public static ExecutorService cw() {
        return j();
    }

    public static ScheduledExecutorService r() {
        return qv.xt.vl();
    }

    public static void up(g gVar) {
        qv.xt.oq().execute(gVar);
    }

    public static ThreadPoolExecutor xt() {
        return qv.xt.g();
    }

    public static ExecutorService j() {
        return qv.xt.jy();
    }

    public static void xt(g gVar, int i6) {
        gVar.setPriority(i6);
        qv.xt.jy().execute(gVar);
    }

    public static void j(g gVar, int i6) {
        gVar.setPriority(i6);
        qv.xt.jy().execute(gVar);
    }

    public static void j(boolean z5) {
        cw = z5;
    }

    public static void j(j jVar) {
        xt = jVar;
    }

    public static void j(int i6) {
        f26612r = i6;
    }
}
