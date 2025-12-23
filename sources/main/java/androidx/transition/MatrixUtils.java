package androidx.transition;

import android.graphics.Matrix;
import android.graphics.RectF;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class MatrixUtils {
    static final Matrix IDENTITY_MATRIX = new Matrix() { // from class: androidx.transition.MatrixUtils.1
        @Override // android.graphics.Matrix
        public boolean postRotate(float f6, float f7, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f6, float f7, float f8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f6, float f7, float f8, float f9) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f6, float f7, float f8) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f6, float f7, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f6, float f7, float f8, float f9) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f6, float f7, float f8, float f9) {
            oops();
        }

        void oops() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        @Override // android.graphics.Matrix
        public boolean postRotate(float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postScale(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postSkew(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preRotate(float f6) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preScale(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preSkew(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setRotate(float f6) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setScale(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSinCos(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setSkew(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean postConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean postTranslate(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preConcat(Matrix matrix) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean preTranslate(float f6, float f7) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void reset() {
            oops();
        }

        @Override // android.graphics.Matrix
        public void set(Matrix matrix) {
            oops();
        }

        @Override // android.graphics.Matrix
        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setPolyToPoly(float[] fArr, int i6, float[] fArr2, int i7, int i8) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            oops();
            return false;
        }

        @Override // android.graphics.Matrix
        public void setTranslate(float f6, float f7) {
            oops();
        }

        @Override // android.graphics.Matrix
        public void setValues(float[] fArr) {
            oops();
        }
    };

    private MatrixUtils() {
    }
}
