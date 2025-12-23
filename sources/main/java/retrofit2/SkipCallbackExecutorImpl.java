package retrofit2;

import java.lang.annotation.Annotation;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (f0.l(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = INSTANCE;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }

    SkipCallbackExecutorImpl() {
    }
}
