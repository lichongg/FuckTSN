package com.kwad.sdk.core.imageloader.core.assist;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    public ImageSize(int i6, int i7) {
        this.width = i6;
        this.height = i7;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public ImageSize scale(float f6) {
        return new ImageSize((int) (this.width * f6), (int) (this.height * f6));
    }

    public ImageSize scaleDown(int i6) {
        return new ImageSize(this.width / i6, this.height / i6);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.width);
        sb.append(SEPARATOR);
        sb.append(this.height);
        return sb.toString();
    }

    public ImageSize(int i6, int i7, int i8) {
        if (i8 % 180 == 0) {
            this.width = i6;
            this.height = i7;
        } else {
            this.width = i7;
            this.height = i6;
        }
    }
}
