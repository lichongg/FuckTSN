package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\Downloads\app\classes3.dex */
public class IntentUtils {

    /* renamed from: j, reason: collision with root package name */
    static HashMap<Long, WeakReference<Bundle>> f25372j = new HashMap<>();

    public static void j(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            j(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    @Keep
    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    private static void j(long j6, Bundle bundle) {
        f25372j.put(Long.valueOf(j6), new WeakReference<>(bundle));
    }

    public static void j(Intent intent) {
        Bundle j6;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (j6 = j(longExtra)) == null) {
            return;
        }
        intent.putExtras(j6);
    }

    private static Bundle j(long j6) {
        WeakReference<Bundle> remove = f25372j.remove(Long.valueOf(j6));
        if (remove != null) {
            return remove.get();
        }
        return null;
    }
}
