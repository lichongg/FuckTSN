package androidx.constraintlayout.solver.widgets;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f813x;

    /* renamed from: y, reason: collision with root package name */
    public int f814y;

    public boolean contains(int i6, int i7) {
        int i8;
        int i9 = this.f813x;
        return i6 >= i9 && i6 < i9 + this.width && i7 >= (i8 = this.f814y) && i7 < i8 + this.height;
    }

    public int getCenterX() {
        return (this.f813x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f814y + this.height) / 2;
    }

    void grow(int i6, int i7) {
        this.f813x -= i6;
        this.f814y -= i7;
        this.width += i6 * 2;
        this.height += i7 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i6;
        int i7;
        int i8 = this.f813x;
        int i9 = rectangle.f813x;
        return i8 >= i9 && i8 < i9 + rectangle.width && (i6 = this.f814y) >= (i7 = rectangle.f814y) && i6 < i7 + rectangle.height;
    }

    public void setBounds(int i6, int i7, int i8, int i9) {
        this.f813x = i6;
        this.f814y = i7;
        this.width = i8;
        this.height = i9;
    }
}
