package androidx.camera.core.processing;

import android.opengl.EGLSurface;
import androidx.annotation.NonNull;
import androidx.camera.core.processing.OpenGlRenderer;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
final class AutoValue_OpenGlRenderer_OutputSurface extends OpenGlRenderer.OutputSurface {
    private final EGLSurface eglSurface;
    private final int height;
    private final int width;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenGlRenderer.OutputSurface) {
            OpenGlRenderer.OutputSurface outputSurface = (OpenGlRenderer.OutputSurface) obj;
            if (this.eglSurface.equals(outputSurface.getEglSurface()) && this.width == outputSurface.getWidth() && this.height == outputSurface.getHeight()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    @NonNull
    EGLSurface getEglSurface() {
        return this.eglSurface;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    int getHeight() {
        return this.height;
    }

    @Override // androidx.camera.core.processing.OpenGlRenderer.OutputSurface
    int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return ((((this.eglSurface.hashCode() ^ 1000003) * 1000003) ^ this.width) * 1000003) ^ this.height;
    }

    public String toString() {
        return "OutputSurface{eglSurface=" + this.eglSurface + ", width=" + this.width + ", height=" + this.height + "}";
    }

    AutoValue_OpenGlRenderer_OutputSurface(EGLSurface eGLSurface, int i6, int i7) {
        if (eGLSurface != null) {
            this.eglSurface = eGLSurface;
            this.width = i6;
            this.height = i7;
            return;
        }
        throw new NullPointerException("Null eglSurface");
    }
}
