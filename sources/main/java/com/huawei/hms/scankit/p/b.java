package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class b implements v2 {
    public int a() {
        return 0;
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        if (d4.a(y2Var.d(), y2Var.f35037f) >= 2) {
            y2Var.a(a(y2Var.d().charAt(y2Var.f35037f), y2Var.d().charAt(y2Var.f35037f + 1)));
            y2Var.f35037f += 2;
            return;
        }
        char c6 = y2Var.c();
        int a6 = d4.a(y2Var.d(), y2Var.f35037f, a());
        if (a6 == a()) {
            if (!d4.c(c6)) {
                y2Var.a((char) (c6 + 1));
                y2Var.f35037f++;
                return;
            } else {
                y2Var.a((char) 235);
                y2Var.a((char) (c6 - 127));
                y2Var.f35037f++;
                return;
            }
        }
        if (a6 == 1) {
            y2Var.a((char) 230);
            y2Var.b(1);
            return;
        }
        if (a6 == 2) {
            y2Var.a((char) 239);
            y2Var.b(2);
            return;
        }
        if (a6 == 3) {
            y2Var.a((char) 238);
            y2Var.b(3);
            return;
        }
        if (a6 == 4) {
            y2Var.a((char) 240);
            y2Var.b(4);
        } else if (a6 == 5) {
            y2Var.a((char) 231);
            y2Var.b(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + a6);
        }
    }

    b() {
    }

    private static char a(char c6, char c7) {
        if (d4.b(c6) && d4.b(c7)) {
            return (char) (((c6 - '0') * 10) + (c7 - '0') + MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE);
        }
        throw new IllegalArgumentException("not digits: " + c6 + c7);
    }
}
