package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.kwad.sdk.R;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class ac {
    private static Handler iK = new Handler(Looper.getMainLooper());
    private static volatile boolean Mg = false;

    static /* synthetic */ boolean access$002(boolean z5) {
        Mg = false;
        return false;
    }

    public static void c(Context context, String str, long j6) {
        a(context, str, R.layout.ksad_content_alliance_toast_2, 0L);
    }

    public static void Q(Context context, String str) {
        b(context, str, R.layout.ksad_content_alliance_toast_2);
    }

    private static void a(Context context, String str, int i6, long j6) {
        if (com.kwad.framework.a.a.akZ.booleanValue() && !Mg) {
            Mg = true;
            View inflate = com.kwad.sdk.o.m.inflate(context, i6, null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
            iK.postDelayed(new bg() { // from class: com.kwad.sdk.utils.ac.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    ac.access$002(false);
                }
            }, j6);
        }
    }

    private static void b(Context context, String str, int i6) {
        a(context, str, i6, 800L);
    }

    public static void c(Context context, String str, int i6) {
        if (com.kwad.framework.a.a.akZ.booleanValue()) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ksad_content_alliance_toast, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.ksad_message_toast_txt)).setText(str);
            Toast toast = new Toast(context);
            toast.setGravity(17, 0, 0);
            toast.setDuration(0);
            toast.setView(inflate);
            toast.show();
        }
    }

    public static void d(Context context, String str, long j6) {
        a(context, str, R.layout.ksad_toast_corner, 0L);
    }
}
