package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.HashMap;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes;
    static final HashMap<String, String> allMargins;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;
    private String mLastStartState = null;
    private String mLastEndState = null;
    private int mLastStartStateId = -1;
    private int mLastEndStateId = -1;

    private static int GetPxFromDp(int i6, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, indexOf)).intValue() * i6) / 160.0f);
    }

    private static void SetBias(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i6) {
        String str = hashMap.get(i6 == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (i6 == 0) {
                constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str));
            } else if (i6 == 1) {
                constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str));
            }
        }
    }

    private static void SetDimensions(int i6, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i7) {
        String str = hashMap.get(i7 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int GetPxFromDp = !str.equalsIgnoreCase("wrap_content") ? GetPxFromDp(i6, str) : -2;
            if (i7 == 0) {
                constraintSet.constrainWidth(view.getId(), GetPxFromDp);
            } else {
                constraintSet.constrainHeight(view.getId(), GetPxFromDp);
            }
        }
    }

    public Object getKeyframe(int i6, int i7, int i8) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getKeyFrame(motionLayout.getContext(), i6, i7, i8);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i6, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap hashMap = (HashMap) obj2;
        int lookUpConstraintId = this.mMotionLayout.lookUpConstraintId(str);
        ConstraintSet constraintSet = this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId);
        if (constraintSet == null) {
            return;
        }
        constraintSet.clear(view.getId());
        SetDimensions(i6, constraintSet, view, hashMap, 0);
        SetDimensions(i6, constraintSet, view, hashMap, 1);
        Connect(i6, constraintSet, view, hashMap, 6, 6);
        Connect(i6, constraintSet, view, hashMap, 6, 7);
        Connect(i6, constraintSet, view, hashMap, 7, 7);
        Connect(i6, constraintSet, view, hashMap, 7, 6);
        Connect(i6, constraintSet, view, hashMap, 1, 1);
        Connect(i6, constraintSet, view, hashMap, 1, 2);
        Connect(i6, constraintSet, view, hashMap, 2, 2);
        Connect(i6, constraintSet, view, hashMap, 2, 1);
        Connect(i6, constraintSet, view, hashMap, 3, 3);
        Connect(i6, constraintSet, view, hashMap, 3, 4);
        Connect(i6, constraintSet, view, hashMap, 4, 3);
        Connect(i6, constraintSet, view, hashMap, 4, 4);
        Connect(i6, constraintSet, view, hashMap, 5, 5);
        SetBias(constraintSet, view, hashMap, 0);
        SetBias(constraintSet, view, hashMap, 1);
        SetAbsolutePositions(i6, constraintSet, view, hashMap);
        this.mMotionLayout.updateState(lookUpConstraintId, constraintSet);
        this.mMotionLayout.requestLayout();
    }

    static {
        HashMap<Pair<Integer, Integer>, String> hashMap = new HashMap<>();
        allAttributes = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        allMargins = hashMap2;
        hashMap.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        hashMap.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        hashMap.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        hashMap.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        hashMap.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        hashMap.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        hashMap.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        hashMap.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        hashMap.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        hashMap.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        hashMap.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        hashMap.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        hashMap.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        hashMap2.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        hashMap2.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        hashMap2.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        hashMap2.put("layout_constraintTop_toTopOf", "layout_marginTop");
        hashMap2.put("layout_constraintStart_toStartOf", "layout_marginStart");
        hashMap2.put("layout_constraintStart_toEndOf", "layout_marginStart");
        hashMap2.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        hashMap2.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        hashMap2.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        hashMap2.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        hashMap2.put("layout_constraintRight_toRightOf", "layout_marginRight");
        hashMap2.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    private static void Connect(int i6, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i7, int i8) {
        String str = allAttributes.get(Pair.create(Integer.valueOf(i7), Integer.valueOf(i8)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = allMargins.get(str);
            constraintSet.connect(view.getId(), i7, Integer.parseInt(str2), i8, str3 != null ? GetPxFromDp(i6, hashMap.get(str3)) : 0);
        }
    }

    private static void SetAbsolutePositions(int i6, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), GetPxFromDp(i6, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), GetPxFromDp(i6, str2));
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i6, String str, Object obj, float[] fArr, int i7, float[] fArr2, int i8) {
        MotionController motionController;
        View view = (View) obj;
        if (i6 != 0) {
            MotionLayout motionLayout = this.mMotionLayout;
            if (motionLayout.mScene == null || view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
                return -1;
            }
        } else {
            motionController = null;
        }
        if (i6 == 0) {
            return 1;
        }
        if (i6 == 1) {
            int duration = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildPath(fArr2, duration);
            return duration;
        }
        if (i6 == 2) {
            int duration2 = this.mMotionLayout.mScene.getDuration() / 16;
            motionController.buildKeyFrames(fArr2, null);
            return duration2;
        }
        if (i6 != 3) {
            return -1;
        }
        this.mMotionLayout.mScene.getDuration();
        return motionController.getAttributeValues(str, fArr2, i8);
    }

    public void disableAutoTransition(boolean z5) {
        this.mMotionLayout.disableAutoTransition(z5);
    }

    public void dumpConstraintSet(String str) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        System.out.getClass();
        try {
            this.mMotionLayout.mScene.getConstraintSet(lookUpConstraintId).dump(this.mMotionLayout.mScene, new int[0]);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildKeyFrames(fArr, null);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i6) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.buildPath(fArr, i6);
        return i6;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return;
        }
        int duration = motionScene.getDuration() / 16;
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.buildRectangles(fArr, duration);
    }

    public String getEndState() {
        int endState = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == endState) {
            return this.mLastEndState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(endState);
        if (constraintSetNames != null) {
            this.mLastEndState = constraintSetNames;
            this.mLastEndStateId = endState;
        }
        return constraintSetNames;
    }

    public int getKeyFrameInfo(Object obj, int i6, int[] iArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i6, iArr);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object obj, int i6, float f6, float f7) {
        return this.mMotionLayout.mFrameArrayList.get((View) obj).getKeyFrameParameter(i6, f6, f7);
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getkeyFramePositions(iArr, fArr);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object obj, float f6, float f7) {
        MotionController motionController;
        View view = (View) obj;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return -1;
        }
        if (view == null || (motionController = motionLayout.mFrameArrayList.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.getPositionKeyframe(viewGroup.getWidth(), viewGroup.getHeight(), f6, f7);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object obj, Object obj2, float f6, float f7, String[] strArr, float[] fArr) {
        if (!(obj instanceof KeyPositionBase)) {
            return Boolean.FALSE;
        }
        View view = (View) obj2;
        this.mMotionLayout.mFrameArrayList.get(view).positionKeyframe(view, (KeyPositionBase) obj, f6, f7, strArr, fArr);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return Boolean.TRUE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int startState = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == startState) {
            return this.mLastStartState;
        }
        String constraintSetNames = this.mMotionLayout.getConstraintSetNames(startState);
        if (constraintSetNames != null) {
            this.mLastStartState = constraintSetNames;
            this.mLastStartStateId = startState;
        }
        return this.mMotionLayout.getConstraintSetNames(startState);
    }

    public String getState() {
        if (this.mLastStartState != null && this.mLastEndState != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.mLastStartState;
            }
            if (progress >= 0.99f) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        return (this.mLastStartState == null || this.mLastEndState == null) ? false : true;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object obj, int i6, String str, Object obj2) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            motionScene.setKeyframe((View) obj, i6, str, obj2);
            MotionLayout motionLayout = this.mMotionLayout;
            motionLayout.mTransitionGoalPosition = i6 / 100.0f;
            motionLayout.mTransitionLastPosition = 0.0f;
            motionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object obj, int i6, int i7, float f6, float f7) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            return false;
        }
        MotionController motionController = motionLayout.mFrameArrayList.get(obj);
        MotionLayout motionLayout2 = this.mMotionLayout;
        int i8 = (int) (motionLayout2.mTransitionPosition * 100.0f);
        if (motionController == null) {
            return false;
        }
        View view = (View) obj;
        if (!motionLayout2.mScene.hasKeyFramePosition(view, i8)) {
            return false;
        }
        float keyFrameParameter = motionController.getKeyFrameParameter(2, f6, f7);
        float keyFrameParameter2 = motionController.getKeyFrameParameter(5, f6, f7);
        this.mMotionLayout.mScene.setKeyframe(view, i8, "motion:percentX", Float.valueOf(keyFrameParameter));
        this.mMotionLayout.mScene.setKeyframe(view, i8, "motion:percentY", Float.valueOf(keyFrameParameter2));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(String str) {
        if (str == null) {
            str = "motion_base";
        }
        if (this.mLastStartState == str) {
            return;
        }
        this.mLastStartState = str;
        this.mLastEndState = null;
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        this.mLastStartStateId = lookUpConstraintId;
        if (lookUpConstraintId != 0) {
            if (lookUpConstraintId == this.mMotionLayout.getStartState()) {
                this.mMotionLayout.setProgress(0.0f);
            } else if (lookUpConstraintId == this.mMotionLayout.getEndState()) {
                this.mMotionLayout.setProgress(1.0f);
            } else {
                this.mMotionLayout.transitionToState(lookUpConstraintId);
                this.mMotionLayout.setProgress(1.0f);
            }
        }
        this.mMotionLayout.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f6) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        motionLayout.setProgress(f6);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String str, String str2) {
        MotionLayout motionLayout = this.mMotionLayout;
        if (motionLayout.mScene == null) {
            motionLayout.mScene = this.mSceneCache;
        }
        int lookUpConstraintId = motionLayout.lookUpConstraintId(str);
        int lookUpConstraintId2 = this.mMotionLayout.lookUpConstraintId(str2);
        this.mMotionLayout.setTransition(lookUpConstraintId, lookUpConstraintId2);
        this.mLastStartStateId = lookUpConstraintId;
        this.mLastEndStateId = lookUpConstraintId2;
        this.mLastStartState = str;
        this.mLastEndState = str2;
    }

    public void setViewDebug(Object obj, int i6) {
        MotionController motionController = this.mMotionLayout.mFrameArrayList.get(obj);
        if (motionController != null) {
            motionController.setDrawPath(i6);
            this.mMotionLayout.invalidate();
        }
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    public Object getKeyframe(Object obj, int i6, int i7) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int id = ((View) obj).getId();
        MotionLayout motionLayout = this.mMotionLayout;
        return motionLayout.mScene.getKeyFrame(motionLayout.getContext(), i6, id, i7);
    }
}
