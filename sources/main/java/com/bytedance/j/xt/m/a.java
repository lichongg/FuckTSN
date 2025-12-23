package com.bytedance.j.xt.m;

import android.content.Context;
import android.os.Handler;
import com.bytedance.j.xt.tl.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private List<b> f24217a;

    public static a a(Handler handler, Context context) {
        return new a(handler, context);
    }

    public void b() {
        i.a("[ScheduleTaskManager] execute, task size=" + this.f24217a.size());
        Iterator<b> it = this.f24217a.iterator();
        while (it.hasNext()) {
            try {
                it.next().b();
            } catch (Throwable unused) {
            }
        }
    }

    private a(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.f24217a = arrayList;
        arrayList.add(new c(handler, 0L, 15000L));
    }
}
