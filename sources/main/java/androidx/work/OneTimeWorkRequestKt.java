package androidx.work;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import kotlin.jvm.internal.g0;
import kotlin.reflect.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes.dex */
public final class OneTimeWorkRequestKt {
    public static final /* synthetic */ <W extends ListenableWorker> OneTimeWorkRequest.Builder OneTimeWorkRequestBuilder() {
        g0.y(4, ExifInterface.LONGITUDE_WEST);
        return new OneTimeWorkRequest.Builder(ListenableWorker.class);
    }

    @NotNull
    public static final OneTimeWorkRequest.Builder setInputMerger(@NotNull OneTimeWorkRequest.Builder builder, @NonNull @NotNull d<? extends InputMerger> inputMerger) {
        g0.p(builder, "<this>");
        g0.p(inputMerger, "inputMerger");
        OneTimeWorkRequest.Builder inputMerger2 = builder.setInputMerger(l3.a.e(inputMerger));
        g0.o(inputMerger2, "setInputMerger(inputMerger.java)");
        return inputMerger2;
    }
}
