package com.bxkj.student.v2.ui.sports.v3.service;

import android.media.MediaPlayer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.student.App;
import com.bxkj.student.R;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3SilentMusicObserver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3SilentMusicObserver.kt\ncom/bxkj/student/v2/ui/sports/v3/service/V3SilentMusicObserver\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3SilentMusicObserver implements LifecycleObserver {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private MediaPlayer f21997a;

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private final void createMusic() {
        MediaPlayer create = MediaPlayer.create(App.f17573d.a(), R.raw.slient);
        create.setLooping(true);
        this.f21997a = create;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void startPlayMusic() {
        MediaPlayer mediaPlayer = this.f21997a;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void stopPlayMusic() {
        MediaPlayer mediaPlayer = this.f21997a;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}
