package com.bxkj.base.v2.common.qrcode;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.orhanobut.logger.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.v;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nSoundUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SoundUtils.kt\ncom/bxkj/base/v2/common/qrcode/SoundUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,277:1\n1#2:278\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class SoundUtils implements LifecycleObserver {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f16845l = new a(null);

    /* renamed from: m, reason: collision with root package name */
    private static final int f16846m = -1;

    /* renamed from: n, reason: collision with root package name */
    private static final int f16847n = 0;

    /* renamed from: o, reason: collision with root package name */
    private static final int f16848o = 2;

    /* renamed from: p, reason: collision with root package name */
    private static final int f16849p = 3;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f16850a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private SoundPool f16851b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final SparseArray<Integer> f16852c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private final SparseArray<Integer> f16853d;

    /* renamed from: e, reason: collision with root package name */
    private int f16854e;

    /* renamed from: f, reason: collision with root package name */
    private float f16855f;

    /* renamed from: g, reason: collision with root package name */
    private float f16856g;

    /* renamed from: h, reason: collision with root package name */
    private float f16857h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Handler f16858i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private List<Integer> f16859j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    private Function0<n1> f16860k;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(v vVar) {
            this();
        }

        private a() {
        }
    }

    private SoundUtils(Context context) {
        this.f16850a = context;
        this.f16852c = new SparseArray<>();
        this.f16853d = new SparseArray<>();
        this.f16854e = 3;
        try {
            this.f16858i = new Handler();
            Object systemService = context.getSystemService("audio");
            g0.n(systemService, "null cannot be cast to non-null type android.media.AudioManager");
            this.f16855f = r2.getStreamMaxVolume(this.f16854e);
            float streamVolume = ((AudioManager) systemService).getStreamVolume(this.f16854e);
            this.f16856g = streamVolume;
            this.f16857h = streamVolume / this.f16855f;
            this.f16851b = new SoundPool.Builder().setMaxStreams(5).build();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        this.f16859j = new ArrayList();
    }

    public final void h(int i6, float f6) {
        i(i6, f6, 0);
    }

    private final void d() {
        if (this.f16859j.isEmpty()) {
            Function0<n1> function0 = this.f16860k;
            if (function0 != null) {
                function0.invoke();
            }
            j.d("所有音乐播放完毕", new Object[0]);
            return;
        }
        final int intValue = this.f16859j.get(0).intValue();
        Handler handler = this.f16858i;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.bxkj.base.v2.common.qrcode.d
                @Override // java.lang.Runnable
                public final void run() {
                    SoundUtils.e(SoundUtils.this, intValue);
                }
            }, this.f16853d.get(intValue).intValue());
        }
    }

    public static /* synthetic */ void k(SoundUtils soundUtils, int i6, float f6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            f6 = 1.0f;
        }
        soundUtils.h(i6, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SoundUtils soundUtils, int i6, float f6, SoundPool soundPool, int i7, int i8) {
        if (soundPool != null) {
            Integer num = soundUtils.f16852c.get(i7);
            g0.o(num, "get(...)");
            int intValue = num.intValue();
            float f7 = soundUtils.f16857h;
            soundPool.play(intValue, f7, f7, 1, i6, f6);
        }
    }

    public final int c(int i6) {
        try {
            Uri parse = Uri.parse("android.resource://" + this.f16850a.getPackageName() + "/" + i6);
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(this.f16850a, parse);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.prepare();
            return mediaPlayer.getDuration();
        } catch (IOException e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    public final void f(int i6) {
        SoundPool soundPool = this.f16851b;
        if (soundPool != null) {
            Integer num = this.f16852c.get(i6);
            g0.o(num, "get(...)");
            soundPool.pause(num.intValue());
        }
    }

    public final void g(int i6) {
        i(i6, 1.0f, 0);
    }

    public final void i(int i6, final float f6, final int i7) {
        try {
            if (this.f16852c.indexOfKey(i6) < 0) {
                m(i6);
                SoundPool soundPool = this.f16851b;
                if (soundPool != null) {
                    soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.bxkj.base.v2.common.qrcode.c
                        @Override // android.media.SoundPool.OnLoadCompleteListener
                        public final void onLoadComplete(SoundPool soundPool2, int i8, int i9) {
                            SoundUtils.l(SoundUtils.this, i7, f6, soundPool2, i8, i9);
                        }
                    });
                    return;
                }
                return;
            }
            SoundPool soundPool2 = this.f16851b;
            if (soundPool2 != null) {
                Integer num = this.f16852c.get(i6);
                g0.o(num, "get(...)");
                int intValue = num.intValue();
                float f7 = this.f16857h;
                soundPool2.play(intValue, f7, f7, 1, i7, f6);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final void j(@NotNull List<Integer> soundList) {
        g0.p(soundList, "soundList");
        if (!this.f16859j.isEmpty()) {
            this.f16859j.addAll(soundList);
        } else {
            this.f16859j.addAll(soundList);
            d();
        }
    }

    public final void m(int i6) {
        SparseArray<Integer> sparseArray = this.f16852c;
        SoundPool soundPool = this.f16851b;
        sparseArray.put(i6, soundPool != null ? Integer.valueOf(soundPool.load(this.f16850a, i6, 1)) : null);
        this.f16853d.put(i6, Integer.valueOf(c(i6)));
    }

    public final void n(@NotNull List<Integer> soundList) {
        g0.p(soundList, "soundList");
        Iterator<Integer> it = soundList.iterator();
        while (it.hasNext()) {
            m(it.next().intValue());
        }
    }

    public final void o(int i6) {
        SoundPool soundPool = this.f16851b;
        if (soundPool != null) {
            Integer num = this.f16852c.get(i6);
            g0.o(num, "get(...)");
            soundPool.resume(num.intValue());
        }
    }

    public final void p(@NotNull Function0<n1> completeListener) {
        g0.p(completeListener, "completeListener");
        this.f16860k = completeListener;
    }

    public final void q(int i6) {
        this.f16854e = i6;
    }

    public final void r(int i6) {
        SoundPool soundPool = this.f16851b;
        if (soundPool != null) {
            Integer num = this.f16852c.get(i6);
            g0.o(num, "get(...)");
            soundPool.stop(num.intValue());
        }
        Handler handler = this.f16858i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        SoundPool soundPool2 = this.f16851b;
        if (soundPool2 != null) {
            soundPool2.release();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void release() {
        try {
            int size = this.f16852c.size();
            for (int i6 = 0; i6 < size; i6++) {
                int keyAt = this.f16852c.keyAt(i6);
                SoundPool soundPool = this.f16851b;
                if (soundPool != null) {
                    Integer num = this.f16852c.get(keyAt);
                    g0.o(num, "get(...)");
                    soundPool.stop(num.intValue());
                }
            }
            SoundPool soundPool2 = this.f16851b;
            if (soundPool2 != null) {
                soundPool2.release();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(SoundUtils soundUtils, int i6) {
        soundUtils.g(i6);
        soundUtils.f16859j.remove(Integer.valueOf(i6));
        soundUtils.d();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SoundUtils(@org.jetbrains.annotations.NotNull androidx.fragment.app.FragmentActivity r3) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.g0.p(r3, r0)
            android.content.Context r0 = r3.getApplicationContext()
            android.content.Context r0 = com.stub.StubApp.getOrigApplicationContext(r0)
            java.lang.String r1 = "getApplicationContext(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            r2.<init>(r0)
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            r3.addObserver(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.qrcode.SoundUtils.<init>(androidx.fragment.app.FragmentActivity):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SoundUtils(@org.jetbrains.annotations.NotNull androidx.fragment.app.Fragment r3) {
        /*
            r2 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.g0.p(r3, r0)
            android.content.Context r0 = r3.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.g0.o(r0, r1)
            r2.<init>(r0)
            androidx.lifecycle.Lifecycle r3 = r3.getLifecycle()
            r3.addObserver(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.common.qrcode.SoundUtils.<init>(androidx.fragment.app.Fragment):void");
    }
}
