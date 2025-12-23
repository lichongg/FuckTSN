package cn.easyar.engine.gl;

import android.graphics.RectF;
import cn.easyar.engine.gl.Drawable2d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FullFrameRect {
    private Texture2dProgram mProgram;
    private Drawable2d mRectDrawable;

    public FullFrameRect(Texture2dProgram program) {
        this.mRectDrawable = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mProgram = program;
    }

    public void changeProgram(Texture2dProgram program) {
        this.mProgram.release();
        this.mProgram = program;
    }

    public int createTextureObject() {
        return this.mProgram.createTextureObject();
    }

    public void drawFrame(int textureId, float[] texMatrix) {
        this.mProgram.draw(GlUtil.IDENTITY_MATRIX, this.mRectDrawable.getVertexArray(), 0, this.mRectDrawable.getVertexCount(), this.mRectDrawable.getCoordsPerVertex(), this.mRectDrawable.getVertexStride(), texMatrix, this.mRectDrawable.getTexCoordArray(), textureId, this.mRectDrawable.getTexCoordStride());
    }

    public Texture2dProgram getProgram() {
        return this.mProgram;
    }

    public void release(boolean doEglCleanup) {
        Texture2dProgram texture2dProgram = this.mProgram;
        if (texture2dProgram != null) {
            if (doEglCleanup) {
                texture2dProgram.release();
            }
            this.mProgram = null;
        }
    }

    public FullFrameRect(Texture2dProgram program, RectF arect) {
        Drawable2d drawable2d = new Drawable2d(Drawable2d.Prefab.FULL_RECTANGLE);
        this.mRectDrawable = drawable2d;
        this.mProgram = program;
        drawable2d.setCoordsArray(arect);
    }
}
