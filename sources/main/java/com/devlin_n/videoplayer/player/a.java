package com.devlin_n.videoplayer.player;

import android.content.Context;
import com.danikula.videocache.file.f;
import com.danikula.videocache.i;
import com.stub.StubApp;
import h1.e;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static i f32401a;

    public static boolean b(Context context, String str) {
        String generate = new f().generate(str);
        StringBuilder sb = new StringBuilder();
        sb.append(e.e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append(generate);
        sb.append(".download");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(e.e(StubApp.getOrigApplicationContext(context.getApplicationContext())).getAbsolutePath());
        sb3.append(str2);
        sb3.append(generate);
        return e.a(sb2) && e.a(sb3.toString());
    }

    public static i c(Context context) {
        i iVar = f32401a;
        if (iVar != null) {
            return iVar;
        }
        i d6 = d(context);
        f32401a = d6;
        return d6;
    }

    private static i d(Context context) {
        return new i.b(context).h(IjkMediaMeta.AV_CH_STEREO_RIGHT).b();
    }

    private a() {
    }

    public static boolean a(Context context) {
        return e.b(e.e(context));
    }
}
