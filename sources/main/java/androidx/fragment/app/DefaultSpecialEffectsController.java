package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        @Nullable
        FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }

        AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z5) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z5;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (from == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (from == state || finalState == state) ? false : true;
        }

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        @Nullable
        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z5, boolean z6) {
            super(operation, cancellationSignal);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z5) {
                    enterTransition = operation.getFragment().getReenterTransition();
                } else {
                    enterTransition = operation.getFragment().getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z5) {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = operation.getFragment().getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z5) {
                    exitTransition = operation.getFragment().getReturnTransition();
                } else {
                    exitTransition = operation.getFragment().getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (z6) {
                if (z5) {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
                    return;
                } else {
                    this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
                    return;
                }
            }
            this.mSharedElementTransition = null;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z5, @Nullable final SpecialEffectsController.Operation operation, @Nullable final SpecialEffectsController.Operation operation2) {
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        Object obj3;
        View view;
        View view2;
        ArrayList<View> arrayList2;
        ArrayList arrayList3;
        SpecialEffectsController.Operation operation3;
        View view3;
        Rect rect;
        ArrayList<View> arrayList4;
        ArrayMap arrayMap;
        View view4;
        ArrayList<View> arrayList5;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        int i6;
        final View view5;
        int i7;
        String findKeyForValue;
        int i8;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        final boolean z6 = z5;
        HashMap hashMap = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
        } else {
            View view6 = new View(defaultSpecialEffectsController.getContainer().getContext());
            final Rect rect2 = new Rect();
            ArrayList<View> arrayList6 = new ArrayList<>();
            ArrayList<View> arrayList7 = new ArrayList<>();
            ArrayMap arrayMap2 = new ArrayMap();
            Object obj4 = null;
            View view7 = null;
            boolean z7 = false;
            for (TransitionInfo transitionInfo3 : list) {
                if (!transitionInfo3.hasSharedElementTransition() || operation == null || operation2 == null) {
                    view3 = view6;
                    rect = rect2;
                    arrayList4 = arrayList6;
                    arrayMap = arrayMap2;
                    view4 = view7;
                    arrayList5 = arrayList7;
                } else {
                    Object wrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(transitionInfo3.getSharedElementTransition()));
                    ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                    ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                    ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                    int i9 = 0;
                    while (i9 < sharedElementTargetNames.size()) {
                        int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i9));
                        Object obj5 = wrapTransitionInSet;
                        if (indexOf != -1) {
                            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i9));
                        }
                        i9++;
                        wrapTransitionInSet = obj5;
                    }
                    Object obj6 = wrapTransitionInSet;
                    ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                    if (z6) {
                        enterTransitionCallback = operation.getFragment().getEnterTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getExitTransitionCallback();
                    } else {
                        enterTransitionCallback = operation.getFragment().getExitTransitionCallback();
                        exitTransitionCallback = operation2.getFragment().getEnterTransitionCallback();
                    }
                    int i10 = 0;
                    for (int size = sharedElementSourceNames.size(); i10 < size; size = size) {
                        arrayMap2.put(sharedElementSourceNames.get(i10), sharedElementTargetNames2.get(i10));
                        i10++;
                    }
                    ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                    defaultSpecialEffectsController.findNamedViews(arrayMap3, operation.getFragment().mView);
                    arrayMap3.retainAll(sharedElementSourceNames);
                    if (enterTransitionCallback != null) {
                        enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                        int size2 = sharedElementSourceNames.size() - 1;
                        while (size2 >= 0) {
                            String str = sharedElementSourceNames.get(size2);
                            View view8 = arrayMap3.get(str);
                            if (view8 == null) {
                                arrayMap2.remove(str);
                                i8 = size2;
                            } else {
                                i8 = size2;
                                if (!str.equals(ViewCompat.getTransitionName(view8))) {
                                    arrayMap2.put(ViewCompat.getTransitionName(view8), (String) arrayMap2.remove(str));
                                }
                            }
                            size2 = i8 - 1;
                        }
                    } else {
                        arrayMap2.retainAll(arrayMap3.keySet());
                    }
                    final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                    defaultSpecialEffectsController.findNamedViews(arrayMap4, operation2.getFragment().mView);
                    arrayMap4.retainAll(sharedElementTargetNames2);
                    arrayMap4.retainAll(arrayMap2.values());
                    if (exitTransitionCallback != null) {
                        exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                        int size3 = sharedElementTargetNames2.size() - 1;
                        while (size3 >= 0) {
                            String str2 = sharedElementTargetNames2.get(size3);
                            View view9 = arrayMap4.get(str2);
                            if (view9 == null) {
                                String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str2);
                                if (findKeyForValue2 != null) {
                                    arrayMap2.remove(findKeyForValue2);
                                }
                                i7 = size3;
                            } else {
                                i7 = size3;
                                if (!str2.equals(ViewCompat.getTransitionName(view9)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str2)) != null) {
                                    arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view9));
                                }
                            }
                            size3 = i7 - 1;
                        }
                    } else {
                        FragmentTransition.retainValues(arrayMap2, arrayMap4);
                    }
                    defaultSpecialEffectsController.retainMatchingViews(arrayMap3, arrayMap2.keySet());
                    defaultSpecialEffectsController.retainMatchingViews(arrayMap4, arrayMap2.values());
                    if (arrayMap2.isEmpty()) {
                        arrayList6.clear();
                        arrayList7.clear();
                        view3 = view6;
                        rect = rect2;
                        arrayList4 = arrayList6;
                        arrayMap = arrayMap2;
                        arrayList5 = arrayList7;
                        obj4 = null;
                        z6 = z5;
                        arrayList7 = arrayList5;
                        arrayList6 = arrayList4;
                        arrayMap2 = arrayMap;
                        view6 = view3;
                        rect2 = rect;
                    } else {
                        FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z6, arrayMap3, true);
                        defaultSpecialEffectsController = this;
                        arrayMap = arrayMap2;
                        view4 = view7;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                            @Override // java.lang.Runnable
                            public void run() {
                                FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z6, arrayMap4, false);
                            }
                        });
                        arrayList6.addAll(arrayMap3.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            i6 = 0;
                        } else {
                            i6 = 0;
                            View view10 = arrayMap3.get(sharedElementSourceNames.get(0));
                            fragmentTransitionImpl.setEpicenter(obj6, view10);
                            view4 = view10;
                        }
                        arrayList7.addAll(arrayMap4.values());
                        if (!sharedElementTargetNames2.isEmpty() && (view5 = arrayMap4.get(sharedElementTargetNames2.get(i6))) != null) {
                            OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    fragmentTransitionImpl.getBoundsOnScreen(view5, rect2);
                                }
                            });
                            z7 = true;
                        }
                        fragmentTransitionImpl.setSharedElementTargets(obj6, view6, arrayList6);
                        rect = rect2;
                        view3 = view6;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj6, null, null, null, null, obj6, arrayList7);
                        arrayList5 = arrayList7;
                        Boolean bool = Boolean.TRUE;
                        hashMap.put(operation, bool);
                        hashMap.put(operation2, bool);
                        arrayList4 = arrayList6;
                        obj4 = obj6;
                    }
                }
                view7 = view4;
                z6 = z5;
                arrayList7 = arrayList5;
                arrayList6 = arrayList4;
                arrayMap2 = arrayMap;
                view6 = view3;
                rect2 = rect;
            }
            SpecialEffectsController.Operation operation4 = operation;
            SpecialEffectsController.Operation operation5 = operation2;
            View view11 = view6;
            Rect rect3 = rect2;
            ArrayList<View> arrayList8 = arrayList6;
            ArrayMap arrayMap5 = arrayMap2;
            View view12 = view7;
            ArrayList<View> arrayList9 = arrayList7;
            ArrayList arrayList10 = new ArrayList();
            Object obj7 = null;
            Object obj8 = null;
            for (TransitionInfo transitionInfo4 : list) {
                if (transitionInfo4.isVisibilityUnchanged()) {
                    hashMap.put(transitionInfo4.getOperation(), Boolean.FALSE);
                    transitionInfo4.completeSpecialEffect();
                } else {
                    Object cloneTransition = fragmentTransitionImpl.cloneTransition(transitionInfo4.getTransition());
                    SpecialEffectsController.Operation operation6 = transitionInfo4.getOperation();
                    boolean z8 = obj4 != null && (operation6 == operation4 || operation6 == operation5);
                    if (cloneTransition == null) {
                        if (!z8) {
                            hashMap.put(operation6, Boolean.FALSE);
                            transitionInfo4.completeSpecialEffect();
                        }
                        view = view11;
                        arrayList = arrayList8;
                        arrayList3 = arrayList10;
                        view2 = view12;
                        arrayList2 = arrayList9;
                    } else {
                        ArrayList arrayList11 = arrayList10;
                        final ArrayList<View> arrayList12 = new ArrayList<>();
                        defaultSpecialEffectsController.captureTransitioningViews(arrayList12, operation6.getFragment().mView);
                        if (z8) {
                            if (operation6 == operation4) {
                                arrayList12.removeAll(arrayList8);
                            } else {
                                arrayList12.removeAll(arrayList9);
                            }
                        }
                        if (arrayList12.isEmpty()) {
                            fragmentTransitionImpl.addTarget(cloneTransition, view11);
                            view = view11;
                            arrayList = arrayList8;
                            obj2 = obj7;
                            obj3 = obj8;
                            operation3 = operation6;
                            view2 = view12;
                            arrayList3 = arrayList11;
                            arrayList2 = arrayList9;
                            obj = cloneTransition;
                        } else {
                            fragmentTransitionImpl.addTargets(cloneTransition, arrayList12);
                            ArrayList<View> arrayList13 = arrayList9;
                            obj = cloneTransition;
                            arrayList = arrayList8;
                            obj2 = obj7;
                            obj3 = obj8;
                            view = view11;
                            view2 = view12;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList11;
                            fragmentTransitionImpl.scheduleRemoveTargets(obj, obj, arrayList12, null, null, null, null);
                            if (operation6.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                operation3 = operation6;
                                list2.remove(operation3);
                                ArrayList<View> arrayList14 = new ArrayList<>(arrayList12);
                                arrayList14.remove(operation3.getFragment().mView);
                                fragmentTransitionImpl.scheduleHideFragmentView(obj, operation3.getFragment().mView, arrayList14);
                                OneShotPreDrawListener.add(defaultSpecialEffectsController.getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        FragmentTransition.setViewVisibility(arrayList12, 4);
                                    }
                                });
                            } else {
                                operation3 = operation6;
                            }
                        }
                        if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                            arrayList3.addAll(arrayList12);
                            if (z7) {
                                fragmentTransitionImpl.setEpicenter(obj, rect3);
                            }
                        } else {
                            fragmentTransitionImpl.setEpicenter(obj, view2);
                        }
                        hashMap.put(operation3, Boolean.TRUE);
                        if (transitionInfo4.isOverlapAllowed()) {
                            obj2 = fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, null);
                        } else {
                            obj3 = fragmentTransitionImpl.mergeTransitionsTogether(obj3, obj, null);
                        }
                        obj7 = obj2;
                        obj8 = obj3;
                    }
                    operation4 = operation;
                    operation5 = operation2;
                    arrayList10 = arrayList3;
                    arrayList9 = arrayList2;
                    arrayList8 = arrayList;
                    view12 = view2;
                    view11 = view;
                }
            }
            ArrayList<View> arrayList15 = arrayList9;
            ArrayList<View> arrayList16 = arrayList8;
            ArrayList arrayList17 = arrayList10;
            Object mergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj7, obj8, obj4);
            for (final TransitionInfo transitionInfo5 : list) {
                if (!transitionInfo5.isVisibilityUnchanged()) {
                    Object transition = transitionInfo5.getTransition();
                    SpecialEffectsController.Operation operation7 = transitionInfo5.getOperation();
                    boolean z9 = obj4 != null && (operation7 == operation || operation7 == operation2);
                    if (transition != null || z9) {
                        if (ViewCompat.isLaidOut(defaultSpecialEffectsController.getContainer())) {
                            fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo5.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo5.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                                @Override // java.lang.Runnable
                                public void run() {
                                    transitionInfo5.completeSpecialEffect();
                                }
                            });
                        } else {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(defaultSpecialEffectsController.getContainer());
                                Objects.toString(operation7);
                            }
                            transitionInfo5.completeSpecialEffect();
                        }
                    }
                }
            }
            if (ViewCompat.isLaidOut(defaultSpecialEffectsController.getContainer())) {
                FragmentTransition.setViewVisibility(arrayList17, 4);
                ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList15);
                fragmentTransitionImpl.beginDelayedTransition(defaultSpecialEffectsController.getContainer(), mergeTransitionsInSequence);
                fragmentTransitionImpl.setNameOverridesReordered(defaultSpecialEffectsController.getContainer(), arrayList16, arrayList15, prepareSetNameOverridesReordered, arrayMap5);
                FragmentTransition.setViewVisibility(arrayList17, 0);
                fragmentTransitionImpl.swapSharedElementTargets(obj4, arrayList16, arrayList15);
                return hashMap;
            }
        }
        return hashMap;
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = viewGroup.getChildAt(i6);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z5, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final boolean z6;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        boolean z7 = false;
        for (final AnimationInfo animationInfo : list) {
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo.getAnimation(context);
                if (animation == null) {
                    animationInfo.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo);
                    } else {
                        final SpecialEffectsController.Operation operation = animationInfo.getOperation();
                        Fragment fragment = operation.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Objects.toString(fragment);
                            }
                            animationInfo.completeSpecialEffect();
                        } else {
                            if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (z6) {
                                list2.remove(operation);
                            }
                            final View view = fragment.mView;
                            container.startViewTransition(view);
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view);
                                    if (z6) {
                                        operation.getFinalState().applyState(view);
                                    }
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            animator.setTarget(view);
                            animator.start();
                            animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                }
                            });
                            z7 = true;
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final AnimationInfo animationInfo2 = (AnimationInfo) it.next();
            SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
            Fragment fragment2 = operation2.getFragment();
            if (z5) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment2);
                }
                animationInfo2.completeSpecialEffect();
            } else if (z7) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Objects.toString(fragment2);
                }
                animationInfo2.completeSpecialEffect();
            } else {
                final View view2 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo2.getAnimation(context))).animation);
                if (operation2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view2.startAnimation(animation2);
                    animationInfo2.completeSpecialEffect();
                } else {
                    container.startViewTransition(view2);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view2);
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view2);
                                    animationInfo2.completeSpecialEffect();
                                }
                            });
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                        }
                    });
                    view2.startAnimation(endViewTransitionAnimation);
                }
                animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view2.clearAnimation();
                        container.endViewTransition(view2);
                        animationInfo2.completeSpecialEffect();
                    }
                });
            }
        }
    }

    void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z5) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i6 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i6 != 1 && i6 != 2 && i6 != 3) {
                if (i6 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation2 = operation3;
                }
            } else if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                operation = operation3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z5));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z6 = false;
            if (z5) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z6 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z6 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z5, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator<SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList3.clear();
    }

    void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = viewGroup.getChildAt(i6);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
