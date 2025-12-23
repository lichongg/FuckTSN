package com.uyumao;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static Context f42597a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final j f42598a = new j();
    }

    public synchronized i a() {
        i iVar;
        iVar = null;
        try {
            Intent registerReceiver = f42597a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i6 = 0;
            int intExtra = registerReceiver.getIntExtra("level", 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
            int i7 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i7 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
                    i7 = 0;
                } else if (intExtra4 == 5) {
                    i7 = 2;
                }
            }
            int intExtra5 = registerReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i6 = 1;
            } else if (intExtra5 == 2) {
                i6 = 2;
            }
            i iVar2 = new i();
            try {
                iVar2.f42591a = intExtra;
                iVar2.f42592b = intExtra2;
                iVar2.f42594d = i7;
                iVar2.f42593c = intExtra3;
                iVar2.f42595e = i6;
                iVar2.f42596f = System.currentTimeMillis();
            } catch (Throwable unused) {
            }
            iVar = iVar2;
        } catch (Throwable unused2) {
        }
        return iVar;
    }
}
