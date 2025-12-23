package cn.jpush.android.x;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\Downloads\app\classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Queue<Integer> f4009a = new ConcurrentLinkedQueue();

    public static int a() {
        if (f4009a.size() > 0) {
            return f4009a.poll().intValue();
        }
        return 0;
    }

    public static int b() {
        return f4009a.size();
    }

    public static boolean a(int i6) {
        return f4009a.offer(Integer.valueOf(i6));
    }

    public static boolean b(int i6) {
        return f4009a.contains(Integer.valueOf(i6));
    }
}
