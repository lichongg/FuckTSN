package com.bxkj.base.v2.common.utils;

import android.app.Activity;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Activity f16930a;

    public n0(@NotNull Activity context) {
        kotlin.jvm.internal.g0.p(context, "context");
        this.f16930a = context;
    }

    private final void a(long j6, long j7) {
        VibrationEffect createWaveform;
        Object systemService = this.f16930a.getSystemService("vibrator");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        Vibrator vibrator = (Vibrator) systemService;
        if (!vibrator.hasVibrator()) {
            com.orhanobut.logger.j.m("手机不支持震动功能->VibrateManager->Device does not support vibration.", new Object[0]);
            return;
        }
        long[] jArr = {0, j6, j7};
        if (Build.VERSION.SDK_INT < 26) {
            vibrator.vibrate(jArr, -1);
        } else {
            createWaveform = VibrationEffect.createWaveform(jArr, 0);
            vibrator.vibrate(createWaveform, new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        }
    }

    public final void b() {
        a(1000L, 2000L);
    }

    public final void c() {
        Object systemService = this.f16930a.getSystemService("vibrator");
        kotlin.jvm.internal.g0.n(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).cancel();
    }
}
