package tv.danmaku.ijk.media.player;

import android.graphics.Rect;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public final class IjkTimedText {
    private Rect mTextBounds;
    private String mTextChars;

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }

    public IjkTimedText(Rect rect, String str) {
        this.mTextBounds = rect;
        this.mTextChars = str;
    }
}
