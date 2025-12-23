package com.acse.ottn;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class l4 {

    /* renamed from: a, reason: collision with root package name */
    public static l4 f4742a;

    public static l4 a() {
        if (f4742a == null) {
            synchronized (l4.class) {
                try {
                    if (f4742a == null) {
                        f4742a = new l4();
                    }
                } finally {
                }
            }
        }
        return f4742a;
    }

    public final Object b() throws ObjectStreamException {
        return f4742a;
    }

    public void b(int i6, String str, String str2) {
        Object systemService;
        if (!j3.a().a("debug_state") || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        systemService = HelpShopAppUtil.getContext().getSystemService((Class<Object>) NotificationManager.class);
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(cn.jiguang.bz.c0.a("1", "重要通知", 4));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HelpShopAppUtil.getContext(), "1");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-->");
        sb.append(r0.d().f(System.currentTimeMillis() + ""));
        builder.setContentText(sb.toString()).setContentTitle(str2).setSmallIcon(R.mipmap.up_green).setWhen(System.currentTimeMillis());
        notificationManager.notify(i6, builder.build());
    }

    public void a(Context context, String str) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ((LinearLayout) inflate.findViewById(R.id.toast_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) inflate.findViewById(R.id.toast_text)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    public void a(int i6, String str, String str2) {
        Object systemService;
        if (!j3.a().a("click_location_content") || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26) {
            return;
        }
        systemService = HelpShopAppUtil.getContext().getSystemService((Class<Object>) NotificationManager.class);
        NotificationManager notificationManager = (NotificationManager) systemService;
        notificationManager.createNotificationChannel(cn.jiguang.bz.c0.a("1", "重要通知", 4));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HelpShopAppUtil.getContext(), "1");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-->");
        sb.append(r0.d().f(System.currentTimeMillis() + ""));
        builder.setContentText(sb.toString()).setContentTitle(str2).setSmallIcon(R.mipmap.up_green).setWhen(System.currentTimeMillis());
        notificationManager.notify(i6, builder.build());
    }
}
