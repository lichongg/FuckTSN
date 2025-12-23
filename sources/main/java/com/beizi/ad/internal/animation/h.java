package com.beizi.ad.internal.animation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public enum h {
    NONE,
    RANDOM,
    FADE,
    PUSH,
    MOVEIN,
    REVEAL;

    public static h a(int i6) {
        for (h hVar : values()) {
            if (hVar.ordinal() == i6) {
                return hVar;
            }
        }
        return NONE;
    }
}
