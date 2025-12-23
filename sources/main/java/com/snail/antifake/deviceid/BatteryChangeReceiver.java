package com.snail.antifake.deviceid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class BatteryChangeReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37527a;

    /* renamed from: b, reason: collision with root package name */
    private int f37528b;

    public int a() {
        return this.f37528b;
    }

    public boolean b() {
        return this.f37527a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, 0);
        this.f37528b = intent.getIntExtra("level", 0);
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra == 3 || intExtra == 4) {
                this.f37527a = false;
                return;
            } else if (intExtra != 5) {
                return;
            }
        }
        this.f37527a = true;
    }
}
