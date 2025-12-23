package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final Path overlappedEdgePath = new Path();
    private final Path boundsPath = new Path();
    private final ShapePath shapePath = new ShapePath();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final Path edgePath = new Path();
    private final Path cornerPath = new Path();
    private boolean edgeIntersectionCheckEnabled = true;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i6);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i6);
    }

    private void getCoordinatesOfCorner(int i6, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i6 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i6 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i6 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private CornerSize getCornerSizeForIndex(int i6, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? shapeAppearanceModel.getTopRightCornerSize() : shapeAppearanceModel.getTopLeftCornerSize() : shapeAppearanceModel.getBottomLeftCornerSize() : shapeAppearanceModel.getBottomRightCornerSize();
    }

    private CornerTreatment getCornerTreatmentForIndex(int i6, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? shapeAppearanceModel.getTopRightCorner() : shapeAppearanceModel.getTopLeftCorner() : shapeAppearanceModel.getBottomLeftCorner() : shapeAppearanceModel.getBottomRightCorner();
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i6, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        return i6 != 1 ? i6 != 2 ? i6 != 3 ? shapeAppearanceModel.getRightEdge() : shapeAppearanceModel.getTopEdge() : shapeAppearanceModel.getLeftEdge() : shapeAppearanceModel.getBottomEdge();
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f6, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f6, rectF, null, path);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class Lazy {
        static final ShapeAppearancePathProvider INSTANCE = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static final class ShapeAppearancePathSpec {

        @NonNull
        public final RectF bounds;
        public final float interpolation;

        @NonNull
        public final Path path;

        @Nullable
        public final PathListener pathListener;

        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f6, RectF rectF, @Nullable PathListener pathListener, Path path) {
            this.pathListener = pathListener;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.interpolation = f6;
            this.bounds = rectF;
            this.path = path;
        }
    }

    private float angleOfEdge(int i6) {
        return ((i6 + 1) % 4) * 90;
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i6) {
        this.scratch[0] = this.cornerPaths[i6].getStartX();
        this.scratch[1] = this.cornerPaths[i6].getStartY();
        this.cornerTransforms[i6].mapPoints(this.scratch);
        if (i6 == 0) {
            Path path = shapeAppearancePathSpec.path;
            float[] fArr = this.scratch;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.path;
            float[] fArr2 = this.scratch;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.cornerPaths[i6].applyToPath(this.cornerTransforms[i6], shapeAppearancePathSpec.path);
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.cornerPaths[i6], this.cornerTransforms[i6], i6);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i6) {
        int i7 = (i6 + 1) % 4;
        this.scratch[0] = this.cornerPaths[i6].getEndX();
        this.scratch[1] = this.cornerPaths[i6].getEndY();
        this.cornerTransforms[i6].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i7].getStartX();
        this.scratch2[1] = this.cornerPaths[i7].getStartY();
        this.cornerTransforms[i7].mapPoints(this.scratch2);
        float f6 = this.scratch[0];
        float[] fArr = this.scratch2;
        float max = Math.max(((float) Math.hypot(f6 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i6);
        this.shapePath.reset(0.0f, 0.0f);
        EdgeTreatment edgeTreatmentForIndex = getEdgeTreatmentForIndex(i6, shapeAppearancePathSpec.shapeAppearanceModel);
        edgeTreatmentForIndex.getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.edgePath.reset();
        this.shapePath.applyToPath(this.edgeTransforms[i6], this.edgePath);
        if (this.edgeIntersectionCheckEnabled && (edgeTreatmentForIndex.forceIntersection() || pathOverlapsCorner(this.edgePath, i6) || pathOverlapsCorner(this.edgePath, i7))) {
            Path path = this.edgePath;
            path.op(path, this.boundsPath, Path.Op.DIFFERENCE);
            this.scratch[0] = this.shapePath.getStartX();
            this.scratch[1] = this.shapePath.getStartY();
            this.edgeTransforms[i6].mapPoints(this.scratch);
            Path path2 = this.overlappedEdgePath;
            float[] fArr2 = this.scratch;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.shapePath.applyToPath(this.edgeTransforms[i6], this.overlappedEdgePath);
        } else {
            this.shapePath.applyToPath(this.edgeTransforms[i6], shapeAppearancePathSpec.path);
        }
        PathListener pathListener = shapeAppearancePathSpec.pathListener;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i6], i6);
        }
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i6) {
        float[] fArr = this.scratch;
        ShapePath shapePath = this.cornerPaths[i6];
        fArr[0] = shapePath.endX;
        fArr[1] = shapePath.endY;
        this.cornerTransforms[i6].mapPoints(fArr);
        return (i6 == 1 || i6 == 3) ? Math.abs(rectF.centerX() - this.scratch[0]) : Math.abs(rectF.centerY() - this.scratch[1]);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.INSTANCE;
    }

    @RequiresApi(19)
    private boolean pathOverlapsCorner(Path path, int i6) {
        this.cornerPath.reset();
        this.cornerPaths[i6].applyToPath(this.cornerTransforms[i6], this.cornerPath);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.cornerPath.computeBounds(rectF, true);
        path.op(this.cornerPath, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i6) {
        getCornerTreatmentForIndex(i6, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i6], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i6, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i6);
        this.cornerTransforms[i6].reset();
        getCoordinatesOfCorner(i6, shapeAppearancePathSpec.bounds, this.pointF);
        Matrix matrix = this.cornerTransforms[i6];
        PointF pointF = this.pointF;
        matrix.setTranslate(pointF.x, pointF.y);
        this.cornerTransforms[i6].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i6) {
        this.scratch[0] = this.cornerPaths[i6].getEndX();
        this.scratch[1] = this.cornerPaths[i6].getEndY();
        this.cornerTransforms[i6].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i6);
        this.edgeTransforms[i6].reset();
        Matrix matrix = this.edgeTransforms[i6];
        float[] fArr = this.scratch;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.edgeTransforms[i6].preRotate(angleOfEdge);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f6, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.overlappedEdgePath.rewind();
        this.boundsPath.rewind();
        this.boundsPath.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f6, rectF, pathListener, path);
        for (int i6 = 0; i6 < 4; i6++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i6);
            setEdgePathAndTransform(i6);
        }
        for (int i7 = 0; i7 < 4; i7++) {
            appendCornerPath(shapeAppearancePathSpec, i7);
            appendEdgePath(shapeAppearancePathSpec, i7);
        }
        path.close();
        this.overlappedEdgePath.close();
        if (this.overlappedEdgePath.isEmpty()) {
            return;
        }
        path.op(this.overlappedEdgePath, Path.Op.UNION);
    }

    void setEdgeIntersectionCheckEnable(boolean z5) {
        this.edgeIntersectionCheckEnabled = z5;
    }

    public ShapeAppearancePathProvider() {
        for (int i6 = 0; i6 < 4; i6++) {
            this.cornerPaths[i6] = new ShapePath();
            this.cornerTransforms[i6] = new Matrix();
            this.edgeTransforms[i6] = new Matrix();
        }
    }
}
