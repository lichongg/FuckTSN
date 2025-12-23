package com.kwad.components.core.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.h.a;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c implements ImageLoadingListener {
    private b QF;

    @Nullable
    private a QG;
    private long QJ;
    private long jY;
    private int QH = 1;
    private int QI = 16;
    private List<i> QK = new CopyOnWriteArrayList();

    static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.h.c$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.g.a<i> aVar) {
        List<i> list;
        if (aVar == null || (list = this.QK) == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    private void ql() {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setImageGravity(this.QH | this.QI);
        }
    }

    public final void E(long j6) {
        this.QJ = j6;
    }

    public final void c(i iVar) {
        if (iVar != null) {
            this.QK.add(iVar);
        }
    }

    public final void d(i iVar) {
        if (iVar != null) {
            this.QK.remove(iVar);
        }
    }

    public final void destroy() {
        this.QK.clear();
        b bVar = this.QF;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.QF.getParent()).removeView(this.QF);
        }
        this.QF = null;
        a aVar = this.QG;
        if (aVar != null) {
            aVar.destroy();
            this.QG = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.QF == null) {
            this.QF = new b(context);
        }
        return this.QF;
    }

    public final long getPlayDuration() {
        return this.jY;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(i iVar) {
                iVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    public final void pause() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.2
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }

            private static void e(i iVar) {
                iVar.onMediaPlayPaused();
            }
        });
    }

    public final void play() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.3
                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(i iVar) {
                    e(iVar);
                }

                private static void e(i iVar) {
                    iVar.onMediaPlaying();
                }
            });
        }
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f6, float f7, float f8, float f9) {
        b bVar = this.QF;
        if (bVar != null) {
            bVar.setRadius(f6, f7, f8, f9);
        }
    }

    public final void setSpeed(float f6) {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.setSpeed(f6);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.QF;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.4
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }

            private static void e(i iVar) {
                iVar.onMediaPlayCompleted();
            }
        });
    }

    public final void stop() {
        a aVar = this.QG;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.QG = aVar;
        aVar.a(new a.InterfaceC0617a() { // from class: com.kwad.components.core.h.c.1
            private boolean QL = false;
            private boolean QM = false;

            private void mf() {
                if (this.QL) {
                    return;
                }
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.2
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }

                    private static void e(i iVar) {
                        iVar.onMediaPlayCompleted();
                    }
                });
                this.QL = true;
            }

            private void qm() {
                if (this.QM) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
                this.QM = true;
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }

                    private static void e(i iVar) {
                        iVar.onMediaPlayStart();
                    }
                });
            }

            @Override // com.kwad.components.core.h.a.InterfaceC0617a
            public final void D(final long j6) {
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j6);
                if (j6 == 0) {
                    qm();
                }
                c.this.jY = j6;
                c.this.b(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(i iVar) {
                        iVar.onMediaPlayProgress(c.this.QJ, j6);
                    }
                });
                if (c.this.jY < c.this.QJ || c.this.QJ <= 0) {
                    return;
                }
                mf();
            }
        });
    }

    public final void setHorizontalGravity(int i6) {
        this.QI = com.kwad.components.core.b.c.ax(i6);
        ql();
    }

    public final void setVerticalGravity(int i6) {
        this.QI = com.kwad.components.core.b.c.aw(i6);
        ql();
    }

    private static int a(FailReason.FailType failType) {
        int i6 = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i6 == 1) {
            return -2;
        }
        if (i6 == 2) {
            return -3;
        }
        if (i6 != 3) {
            return i6 != 4 ? -1 : -5;
        }
        return -4;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }
}
