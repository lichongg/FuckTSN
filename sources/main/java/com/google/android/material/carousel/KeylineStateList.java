package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private static int findFirstInBoundsKeylineIndex(KeylineState keylineState) {
        for (int i6 = 0; i6 < keylineState.getKeylines().size(); i6++) {
            if (keylineState.getKeylines().get(i6).locOffset >= 0.0f) {
                return i6;
            }
        }
        return -1;
    }

    public KeylineState getShiftedState(float f6, float f7, float f8) {
        return getShiftedState(f6, f7, f8, false);
    }

    static KeylineStateList from(Carousel carousel, KeylineState keylineState) {
        return new KeylineStateList(keylineState, getStateStepsStart(keylineState), getStateStepsEnd(carousel, keylineState));
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastInBoundsKeylineIndex = findLastInBoundsKeylineIndex(carousel, keylineState);
        if (!isLastFocalItemAtRightOfContainer(carousel, keylineState) && findLastInBoundsKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastInBoundsKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f6 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i6 = 0; i6 < lastFocalKeylineIndex; i6++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i7 = (findLastInBoundsKeylineIndex - i6) + 1;
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findLastInBoundsKeylineIndex, i7 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i7).mask) + 1 : 0, f6, keylineState.getFirstFocalKeylineIndex() + i6 + 1, keylineState.getLastFocalKeylineIndex() + i6 + 1));
            }
        }
        return arrayList;
    }

    private static List<KeylineState> getStateStepsStart(KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstInBoundsKeylineIndex = findFirstInBoundsKeylineIndex(keylineState);
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && findFirstInBoundsKeylineIndex != -1) {
            int firstFocalKeylineIndex = (keylineState.getFirstFocalKeylineIndex() - 1) - findFirstInBoundsKeylineIndex;
            float f6 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i6 = 0; i6 <= firstFocalKeylineIndex; i6++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int size = keylineState.getKeylines().size() - 1;
                int i7 = (findFirstInBoundsKeylineIndex + i6) - 1;
                if (i7 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i7).mask) - 1;
                }
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, findFirstInBoundsKeylineIndex, size, f6, (keylineState.getFirstFocalKeylineIndex() - i6) - 1, (keylineState.getLastFocalKeylineIndex() - i6) - 1));
            }
        }
        return arrayList;
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i6, int i7, float f6, int i8, int i9) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i7, (KeylineState.Keyline) arrayList.remove(i6));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize());
        int i10 = 0;
        while (i10 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i10);
            float f7 = keyline.maskedItemSize;
            builder.addKeyline((f7 / 2.0f) + f6, keyline.mask, f7, i10 >= i8 && i10 <= i9);
            f6 += keyline.maskedItemSize;
            i10++;
        }
        return builder.build();
    }

    KeylineState getDefaultState() {
        return this.defaultState;
    }

    KeylineState getEndState() {
        return this.endStateSteps.get(r0.size() - 1);
    }

    Map<Integer, KeylineState> getKeylineStateForPositionMap(int i6, int i7, int i8, boolean z5) {
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i9 >= i6) {
                break;
            }
            int i11 = z5 ? (i6 - i9) - 1 : i9;
            if (i11 * itemSize * (z5 ? -1 : 1) > i8 - this.endShiftRange || i9 >= i6 - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i11);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i10, 0, list.size() - 1)));
                i10++;
            }
            i9++;
        }
        int i12 = 0;
        for (int i13 = i6 - 1; i13 >= 0; i13--) {
            int i14 = z5 ? (i6 - i13) - 1 : i13;
            if (i14 * itemSize * (z5 ? -1 : 1) < i7 + this.startShiftRange || i13 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i14);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i12, 0, list2.size() - 1)));
                i12++;
            }
        }
        return hashMap;
    }

    KeylineState getShiftedState(float f6, float f7, float f8, boolean z5) {
        float lerp;
        List<KeylineState> list;
        float[] fArr;
        float f9 = this.startShiftRange + f7;
        float f10 = f8 - this.endShiftRange;
        if (f6 < f9) {
            lerp = AnimationUtils.lerp(1.0f, 0.0f, f7, f9, f6);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f6 <= f10) {
                return this.defaultState;
            }
            lerp = AnimationUtils.lerp(0.0f, 1.0f, f10, f8, f6);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z5 ? closestStateStepFromInterpolation(list, lerp, fArr) : lerp(list, lerp, fArr);
    }

    KeylineState getStartState() {
        return this.startStateSteps.get(r0.size() - 1);
    }

    private KeylineStateList(KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f6 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f6;
        float f7 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f7;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f6, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f7, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f6, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f6, fArr);
        if (stateStepsRange[0] > 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f6) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f6 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findLastInBoundsKeylineIndex(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (keylineState.getKeylines().get(size).locOffset <= containerHeight) {
                return size;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f6) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f6 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static float[] getStateStepInterpolationPoints(float f6, List<KeylineState> list, boolean z5) {
        float f7;
        float f8;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i6 = 1; i6 < size; i6++) {
            int i7 = i6 - 1;
            KeylineState keylineState = list.get(i7);
            KeylineState keylineState2 = list.get(i6);
            if (z5) {
                f7 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f7 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f9 = f7 / f6;
            if (i6 == size - 1) {
                f8 = 1.0f;
            } else {
                f8 = fArr[i7] + f9;
            }
            fArr[i6] = f8;
        }
        return fArr;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f6, float[] fArr) {
        int size = list.size();
        float f7 = fArr[0];
        int i6 = 1;
        while (i6 < size) {
            float f8 = fArr[i6];
            if (f6 <= f8) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f7, f8, f6), i6 - 1, i6};
            }
            i6++;
            f7 = f8;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) > 0.0f && keylineState.getFirstFocalKeyline() != keylineState.getFirstKeyline()) {
            return false;
        }
        return true;
    }

    private static boolean isLastFocalItemAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if (keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) < containerHeight && keylineState.getLastFocalKeyline() != keylineState.getLastKeyline()) {
            return false;
        }
        return true;
    }

    private static KeylineState lerp(List<KeylineState> list, float f6, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f6, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }
}
