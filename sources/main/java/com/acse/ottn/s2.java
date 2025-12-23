package com.acse.ottn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.acse.ottn.util.HelpShopAppUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class s2 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public String f5082a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f5083b = new Handler();

    /* renamed from: c, reason: collision with root package name */
    public Runnable f5084c = new a();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s2.this.f5082a));
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.addFlags(268435456);
                HelpShopAppUtil.getContext().startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f5082a = intent.getStringExtra("url");
        this.f5083b.postDelayed(this.f5084c, 1000L);
    }
}
