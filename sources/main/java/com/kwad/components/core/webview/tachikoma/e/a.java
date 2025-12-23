package com.kwad.components.core.webview.tachikoma.e;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a {
    private List<Integer> ahH;
    private final List<Integer> ahI;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.core.webview.tachikoma.e.a$a, reason: collision with other inner class name */
    static class C0646a {
        private static final a ahM = new a(0);
    }

    /* synthetic */ a(byte b6) {
        this();
    }

    private a() {
        this.ahH = new ArrayList();
        this.ahI = Arrays.asList(123, 184, 185, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), 199, 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bh(String str) {
        int i6;
        try {
            i6 = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i6 = Integer.MAX_VALUE;
        }
        if (this.ahI.contains(Integer.valueOf(i6))) {
            this.ahH.add(Integer.valueOf(i6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(int i6) {
        if (this.ahI.contains(Integer.valueOf(i6))) {
            this.ahH.add(Integer.valueOf(i6));
        }
    }

    public final void bm(final int i6) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bl(i6);
            }
        });
    }

    public final List<Integer> vJ() {
        return this.ahH;
    }

    public final void vK() {
        this.ahH.clear();
    }

    public static a vI() {
        return C0646a.ahM;
    }

    public final void bi(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bh(str);
            }
        });
    }
}
