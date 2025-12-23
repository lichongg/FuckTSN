package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public class TransitionSet extends Transition {
    private static final int FLAG_CHANGE_EPICENTER = 8;
    private static final int FLAG_CHANGE_INTERPOLATOR = 1;
    private static final int FLAG_CHANGE_PATH_MOTION = 4;
    private static final int FLAG_CHANGE_PROPAGATION = 2;
    public static final int ORDERING_SEQUENTIAL = 1;
    public static final int ORDERING_TOGETHER = 0;
    private int mChangeFlags;
    int mCurrentListeners;
    private boolean mPlayTogether;
    boolean mStarted;
    private ArrayList<Transition> mTransitions;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet mTransitionSet;

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int i6 = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = i6;
            if (i6 == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (transitionSet.mStarted) {
                return;
            }
            transitionSet.start();
            this.mTransitionSet.mStarted = true;
        }

        TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }
    }

    public TransitionSet() {
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull View view, boolean z5) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).excludeTarget(view, z5);
        }
        return super.excludeTarget(view, z5);
    }

    @NonNull
    public TransitionSet setOrdering(int i6) {
        if (i6 == 0) {
            this.mPlayTogether = true;
            return this;
        }
        if (i6 == 1) {
            this.mPlayTogether = false;
            return this;
        }
        throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i6);
    }

    private void addTransitionInternal(@NonNull Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
    }

    private void setupStartEndListeners() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        if (isValidTarget(transitionValues.view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(transitionValues.view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo43clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo43clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            transitionSet.addTransitionInternal(this.mTransitions.get(i6).mo43clone());
        }
        return transitionSet;
    }

    public int getOrdering() {
        return !this.mPlayTogether ? 1 : 0;
    }

    @Nullable
    public Transition getTransitionAt(int i6) {
        if (i6 < 0 || i6 >= this.mTransitions.size()) {
            return null;
        }
        return this.mTransitions.get(i6);
    }

    public int getTransitionCount() {
        return this.mTransitions.size();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeListener(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.removeListener(transitionListener);
    }

    @NonNull
    public TransitionSet removeTransition(@NonNull Transition transition) {
        this.mTransitions.remove(transition);
        transition.mParent = null;
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        setupStartEndListeners();
        if (this.mPlayTogether) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                it.next().runAnimators();
            }
            return;
        }
        for (int i6 = 1; i6 < this.mTransitions.size(); i6++) {
            Transition transition = this.mTransitions.get(i6 - 1);
            final Transition transition2 = this.mTransitions.get(i6);
            transition.addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition3) {
                    transition2.runAnimators();
                    transition3.removeListener(this);
                }
            });
        }
        Transition transition3 = this.mTransitions.get(0);
        if (transition3 != null) {
            transition3.runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setDuration(long j6) {
        ArrayList<Transition> arrayList;
        super.setDuration(j6);
        if (this.mDuration >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mTransitions.get(i6).setDuration(j6);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i6 = 0; i6 < size; i6++) {
                this.mTransitions.get(i6).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.transition.Transition
    public TransitionSet setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet setStartDelay(long j6) {
        return (TransitionSet) super.setStartDelay(j6);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition addTarget(@NonNull Class cls) {
        return addTarget((Class<?>) cls);
    }

    @NonNull
    public TransitionSet addTransition(@NonNull Transition transition) {
        addTransitionInternal(transition);
        long j6 = this.mDuration;
        if (j6 >= 0) {
            transition.setDuration(j6);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).cancel();
        }
    }

    @Override // androidx.transition.Transition
    void capturePropagationValues(TransitionValues transitionValues) {
        super.capturePropagationValues(transitionValues);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            Transition transition = this.mTransitions.get(i6);
            if (startDelay > 0 && (this.mPlayTogether || i6 == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).forceToEnd(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    @NonNull
    public /* bridge */ /* synthetic */ Transition removeTarget(@NonNull Class cls) {
        return removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.Transition
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void resume(View view) {
        super.resume(view);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    void setCanRemoveViews(boolean z5) {
        super.setCanRemoveViews(z5);
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).setCanRemoveViews(z5);
        }
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        super.setEpicenterCallback(epicenterCallback);
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
                this.mTransitions.get(i6).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(TransitionPropagation transitionPropagation) {
        super.setPropagation(transitionPropagation);
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mTransitions.get(i6).setPropagation(transitionPropagation);
        }
    }

    @Override // androidx.transition.Transition
    String toString(String str) {
        String transition = super.toString(str);
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            StringBuilder sb = new StringBuilder();
            sb.append(transition);
            sb.append(com.snail.antifake.deviceid.e.f37542d);
            sb.append(this.mTransitions.get(i6).toString(str + "  "));
            transition = sb.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull String str, boolean z5) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).excludeTarget(str, z5);
        }
        return super.excludeTarget(str, z5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull View view) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@IdRes int i6) {
        for (int i7 = 0; i7 < this.mTransitions.size(); i7++) {
            this.mTransitions.get(i7).removeTarget(i6);
        }
        return (TransitionSet) super.removeTarget(i6);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTransitions = new ArrayList<>();
        this.mPlayTogether = true;
        this.mStarted = false;
        this.mChangeFlags = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_SET);
        setOrdering(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(int i6, boolean z5) {
        for (int i7 = 0; i7 < this.mTransitions.size(); i7++) {
            this.mTransitions.get(i7).excludeTarget(i6, z5);
        }
        return super.excludeTarget(i6, z5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@IdRes int i6) {
        for (int i7 = 0; i7 < this.mTransitions.size(); i7++) {
            this.mTransitions.get(i7).addTarget(i6);
        }
        return (TransitionSet) super.addTarget(i6);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull View view) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public Transition excludeTarget(@NonNull Class<?> cls, boolean z5) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).excludeTarget(cls, z5);
        }
        return super.excludeTarget(cls, z5);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull String str) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull Class<?> cls) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet addTarget(@NonNull Class<?> cls) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    @NonNull
    public TransitionSet removeTarget(@NonNull String str) {
        for (int i6 = 0; i6 < this.mTransitions.size(); i6++) {
            this.mTransitions.get(i6).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
