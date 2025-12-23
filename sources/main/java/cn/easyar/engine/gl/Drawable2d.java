package cn.easyar.engine.gl;

import android.graphics.RectF;
import java.nio.FloatBuffer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class Drawable2d {
    private static final FloatBuffer FULL_RECTANGLE_BUF;
    private static final float[] FULL_RECTANGLE_COORDS;
    private static FloatBuffer FULL_RECTANGLE_TEX_BUF = null;
    private static final float[] FULL_RECTANGLE_TEX_COORDS;
    private static final FloatBuffer RECTANGLE_BUF;
    private static final float[] RECTANGLE_COORDS;
    private static final FloatBuffer RECTANGLE_TEX_BUF;
    private static final float[] RECTANGLE_TEX_COORDS;
    private static final int SIZEOF_FLOAT = 4;
    private static final FloatBuffer TRIANGLE_BUF;
    private static final float[] TRIANGLE_COORDS;
    private static final FloatBuffer TRIANGLE_TEX_BUF;
    private static final float[] TRIANGLE_TEX_COORDS;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_TEX_COORDS = fArr2;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_TEX_COORDS = fArr4;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr5;
        float[] fArr6 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = fArr6;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr5);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: cn.easyar.engine.gl.Drawable2d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$easyar$engine$gl$Drawable2d$Prefab;

        static {
            int[] iArr = new int[Prefab.values().length];
            $SwitchMap$cn$easyar$engine$gl$Drawable2d$Prefab = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cn$easyar$engine$gl$Drawable2d$Prefab[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$cn$easyar$engine$gl$Drawable2d$Prefab[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public void setCoordsArray(RectF arect) {
        float f6 = arect.left;
        float f7 = arect.top;
        float f8 = arect.right;
        float f9 = arect.bottom;
        this.mTexCoordArray = GlUtil.createFloatBuffer(new float[]{f6, f7, f8, f7, f6, f9, f8, f9});
    }

    public String toString() {
        if (this.mPrefab == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.mPrefab + "]";
    }

    public Drawable2d(Prefab shape) {
        int i6 = AnonymousClass1.$SwitchMap$cn$easyar$engine$gl$Drawable2d$Prefab[shape.ordinal()];
        if (i6 != 1) {
            if (i6 != 2) {
                if (i6 == 3) {
                    this.mVertexArray = FULL_RECTANGLE_BUF;
                    this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                    this.mCoordsPerVertex = 2;
                    this.mVertexStride = 2 * 4;
                    this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
                } else {
                    throw new RuntimeException("Unknown shape " + shape);
                }
            } else {
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = 2 * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / 2;
            }
        } else {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        }
        this.mTexCoordStride = 8;
        this.mPrefab = shape;
    }
}
