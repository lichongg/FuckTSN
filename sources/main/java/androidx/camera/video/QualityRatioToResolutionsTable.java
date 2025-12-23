package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import com.google.auto.value.AutoValue;
import com.jmolsmobile.landscapevideocapture.configuration.PredefinedCaptureConfigurations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@RequiresApi(21)
/* loaded from: D:\Downloads\app\classes.dex */
class QualityRatioToResolutionsTable {
    private static final Map<Integer, Rational> sAspectRatioMap;
    private static final Map<Quality, Range<Integer>> sQualityRangeMap;
    private final Map<QualityRatio, List<Size>> mTable = new HashMap();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @AutoValue
    static abstract class QualityRatio {
        abstract int getAspectRatio();

        @NonNull
        abstract Quality getQuality();

        static QualityRatio of(@NonNull Quality quality, int i6) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(quality, i6);
        }

        QualityRatio() {
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sQualityRangeMap = hashMap;
        hashMap.put(Quality.UHD, Range.create(Integer.valueOf(PredefinedCaptureConfigurations.C), 4319));
        hashMap.put(Quality.FHD, Range.create(Integer.valueOf(PredefinedCaptureConfigurations.f35652s), 1439));
        hashMap.put(Quality.HD, Range.create(Integer.valueOf(PredefinedCaptureConfigurations.f35647n), 1079));
        hashMap.put(Quality.SD, Range.create(241, 719));
        HashMap hashMap2 = new HashMap();
        sAspectRatioMap = hashMap2;
        hashMap2.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        hashMap2.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    @Nullable
    private static Integer findMappedAspectRatio(@NonNull Size size) {
        for (Map.Entry<Integer, Rational> entry : sAspectRatioMap.entrySet()) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, entry.getValue(), SizeUtil.RESOLUTION_QVGA)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    private static Quality findMappedQuality(@NonNull Size size) {
        for (Map.Entry<Quality, Range<Integer>> entry : sQualityRangeMap.entrySet()) {
            if (entry.getValue().contains((Range<Integer>) Integer.valueOf(size.getHeight()))) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    private List<Size> getQualityRatioRow(@NonNull Quality quality, int i6) {
        return this.mTable.get(QualityRatio.of(quality, i6));
    }

    private void sortQualityRatioRow(@NonNull Map<Quality, Size> map) {
        for (Map.Entry<QualityRatio, List<Size>> entry : this.mTable.entrySet()) {
            Size size = map.get(entry.getKey().getQuality());
            if (size != null) {
                final int area = SizeUtil.getArea(size);
                Collections.sort(entry.getValue(), new Comparator() { // from class: androidx.camera.video.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return QualityRatioToResolutionsTable.a(area, (Size) obj, (Size) obj2);
                    }
                });
            }
        }
    }

    QualityRatioToResolutionsTable(@NonNull List<Size> list, @NonNull Map<Quality, Size> map) {
        for (Quality quality : sQualityRangeMap.keySet()) {
            this.mTable.put(QualityRatio.of(quality, -1), new ArrayList());
            Iterator<Integer> it = sAspectRatioMap.keySet().iterator();
            while (it.hasNext()) {
                this.mTable.put(QualityRatio.of(quality, it.next().intValue()), new ArrayList());
            }
        }
        addProfileSizesToTable(map);
        addResolutionsToTable(list);
        sortQualityRatioRow(map);
    }

    public static /* synthetic */ int a(int i6, Size size, Size size2) {
        return Math.abs(SizeUtil.getArea(size) - i6) - Math.abs(SizeUtil.getArea(size2) - i6);
    }

    private void addProfileSizesToTable(@NonNull Map<Quality, Size> map) {
        for (Map.Entry<Quality, Size> entry : map.entrySet()) {
            List<Size> qualityRatioRow = getQualityRatioRow(entry.getKey(), -1);
            Objects.requireNonNull(qualityRatioRow);
            qualityRatioRow.add(entry.getValue());
        }
    }

    private void addResolutionsToTable(@NonNull List<Size> list) {
        Integer findMappedAspectRatio;
        for (Size size : list) {
            Quality findMappedQuality = findMappedQuality(size);
            if (findMappedQuality != null && (findMappedAspectRatio = findMappedAspectRatio(size)) != null) {
                List<Size> qualityRatioRow = getQualityRatioRow(findMappedQuality, findMappedAspectRatio.intValue());
                Objects.requireNonNull(qualityRatioRow);
                qualityRatioRow.add(size);
            }
        }
    }

    @NonNull
    List<Size> getResolutions(@NonNull Quality quality, int i6) {
        List<Size> qualityRatioRow = getQualityRatioRow(quality, i6);
        if (qualityRatioRow != null) {
            return new ArrayList(qualityRatioRow);
        }
        return new ArrayList(0);
    }
}
