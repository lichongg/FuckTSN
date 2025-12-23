package com.bxkj.student.run.app.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d0 {

    /* renamed from: b, reason: collision with root package name */
    private static d0 f20208b;

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f20209a = Executors.newCachedThreadPool();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x006e -> B:41:0x0097). Please report as a decompilation issue!!! */
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void i(final Context mContext, final List<Integer> list) {
        Throwable th;
        Exception exc;
        synchronized (this) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final MediaPlayer mediaPlayer = new MediaPlayer();
            if (list != null && list.size() > 0) {
                final int[] iArr = {0};
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    try {
                        try {
                            final AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
                            audioManager.requestAudioFocus(null, 3, 2);
                            AssetFileDescriptor openRawResourceFd = mContext.getResources().openRawResourceFd(list.get(iArr[0]).intValue());
                            try {
                                mediaPlayer.setAudioStreamType(3);
                                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                                mediaPlayer.prepareAsync();
                                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.bxkj.student.run.app.utils.a0
                                    @Override // android.media.MediaPlayer.OnPreparedListener
                                    public final void onPrepared(MediaPlayer mediaPlayer2) {
                                        mediaPlayer2.start();
                                    }
                                });
                                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.bxkj.student.run.app.utils.b0
                                    @Override // android.media.MediaPlayer.OnCompletionListener
                                    public final void onCompletion(MediaPlayer mediaPlayer2) {
                                        d0.b(iArr, list, mContext, mediaPlayer, countDownLatch, audioManager, mediaPlayer2);
                                    }
                                });
                                openRawResourceFd.close();
                            } catch (Exception e6) {
                                exc = e6;
                                assetFileDescriptor = openRawResourceFd;
                                exc.printStackTrace();
                                countDownLatch.countDown();
                                if (assetFileDescriptor != null) {
                                    assetFileDescriptor.close();
                                }
                                countDownLatch.await();
                                notifyAll();
                            } catch (Throwable th2) {
                                th = th2;
                                assetFileDescriptor = openRawResourceFd;
                                if (assetFileDescriptor == null) {
                                    throw th;
                                }
                                try {
                                    assetFileDescriptor.close();
                                    throw th;
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e8) {
                        exc = e8;
                    }
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            try {
                countDownLatch.await();
                notifyAll();
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
        }
    }

    public static synchronized d0 e() {
        d0 d0Var;
        synchronized (d0.class) {
            try {
                if (f20208b == null) {
                    f20208b = new d0();
                }
                d0Var = f20208b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return d0Var;
    }

    private int h(Context mContext) {
        return (int) (((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(2) * 0.8d);
    }

    private void j(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(2, volume, 0);
    }

    private void k(Context mContext, int volume) {
        ((AudioManager) mContext.getSystemService("audio")).setStreamVolume(3, volume, 0);
    }

    public int d(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamVolume(2);
    }

    public int f(Context mContext) {
        return ((AudioManager) mContext.getSystemService("audio")).getStreamMaxVolume(3);
    }

    public int g(Context mContext) {
        AudioManager audioManager = (AudioManager) mContext.getSystemService("audio");
        com.orhanobut.logger.j.c(" audioManager.getMode()=" + audioManager.getMode());
        return audioManager.getStreamVolume(3);
    }

    public void l(final Context mContext, final List<Integer> list) {
        ExecutorService executorService = this.f20209a;
        if (executorService != null) {
            executorService.execute(new Runnable() { // from class: com.bxkj.student.run.app.utils.c0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.this.i(mContext, list);
                }
            });
        }
    }

    private d0() {
    }

    public static /* synthetic */ void b(int[] iArr, List list, Context context, MediaPlayer mediaPlayer, CountDownLatch countDownLatch, AudioManager audioManager, MediaPlayer mediaPlayer2) {
        mediaPlayer2.reset();
        int i6 = iArr[0] + 1;
        iArr[0] = i6;
        if (i6 < list.size()) {
            try {
                AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(((Integer) list.get(iArr[0])).intValue());
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                mediaPlayer2.prepare();
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                countDownLatch.countDown();
                return;
            }
        }
        mediaPlayer2.release();
        audioManager.abandonAudioFocus(null);
        countDownLatch.countDown();
    }
}
