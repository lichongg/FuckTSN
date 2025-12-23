package cn.jpush.android.s;

import android.os.CountDownTimer;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private CountDownTimer f3810a;

    public interface a {
        void a();
    }

    public void a() {
        CountDownTimer countDownTimer = this.f3810a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f3810a = null;
        }
    }

    public void a(final a aVar, long j6, long j7) {
        this.f3810a = new CountDownTimer(j6, j7) { // from class: cn.jpush.android.s.c.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j8) {
            }
        }.start();
    }
}
