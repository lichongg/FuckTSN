package com.bytedance.sdk.openadsdk.core.dislike.j;

import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bykv.j.j.j.j.f;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.i.cw.xt.m;
import java.lang.reflect.Field;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final com.bytedance.sdk.openadsdk.core.dislike.cw.xt f28875j;

    /* renamed from: com.bytedance.sdk.openadsdk.core.dislike.j.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class j implements AdapterView.OnItemClickListener {

        /* renamed from: j, reason: collision with root package name */
        private final xt f28876j;
        private final AdapterView.OnItemClickListener xt;

        /* synthetic */ j(AdapterView.OnItemClickListener onItemClickListener, xt xtVar, AnonymousClass1 anonymousClass1) {
            this(onItemClickListener, xtVar);
        }

        private com.bytedance.sdk.openadsdk.core.dislike.cw.cw j(Object obj) {
            Object obj2;
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i6 = 0; i6 < declaredFields.length; i6++) {
                try {
                    declaredFields[i6].setAccessible(true);
                    obj2 = declaredFields[i6].get(obj);
                } catch (Exception e6) {
                    vl.j(e6);
                }
                if (obj2 instanceof m) {
                    return new com.bytedance.sdk.openadsdk.core.dislike.cw.cw(((m) obj2).j(), ((m) obj2).xt());
                }
                continue;
            }
            return null;
        }

        private j(AdapterView.OnItemClickListener onItemClickListener, xt xtVar) {
            this.f28876j = xtVar;
            this.xt = onItemClickListener;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.Adapter] */
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i6, long j6) {
            ?? adapter = adapterView.getAdapter();
            if (adapter != 0) {
                Object item = adapter.getItem(i6);
                if (f.a(item)) {
                    this.f28876j.j(j(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.xt;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i6, j6);
            }
        }
    }

    public void j(m mVar) {
        if (this.f28875j == null || mVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.j.j.j().j(this.f28875j, mVar);
    }

    public xt(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar) {
        this.f28875j = xtVar;
    }

    public static final void j(com.bytedance.sdk.openadsdk.core.dislike.cw.xt xtVar, Dialog dialog, Integer[] numArr) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        xt xtVar2 = new xt(xtVar);
        for (Integer num : numArr) {
            View findViewById = dialog.findViewById(num.intValue());
            if (findViewById instanceof ListView) {
                ListView listView = (ListView) findViewById;
                listView.setOnItemClickListener(new j(listView.getOnItemClickListener(), xtVar2, null));
            }
        }
    }
}
