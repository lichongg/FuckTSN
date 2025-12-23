package com.google.android.gms.common.data;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public final class DataBufferUtils {

    @NonNull
    @KeepForSdk
    public static final String KEY_NEXT_PAGE_TOKEN = "next_page_token";

    @NonNull
    @KeepForSdk
    public static final String KEY_PREV_PAGE_TOKEN = "prev_page_token";

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(@NonNull DataBuffer<E> dataBuffer) {
        ObservableArrayList observableArrayList = (ArrayList<T>) new ArrayList(dataBuffer.getCount());
        try {
            Iterator<E> it = dataBuffer.iterator();
            while (it.hasNext()) {
                observableArrayList.add(it.next().freeze());
            }
            return observableArrayList;
        } finally {
            dataBuffer.close();
        }
    }

    public static boolean hasData(@NonNull DataBuffer<?> dataBuffer) {
        return dataBuffer != null && dataBuffer.getCount() > 0;
    }

    private DataBufferUtils() {
    }

    public static boolean hasNextPage(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata != null && metadata.getString(KEY_NEXT_PAGE_TOKEN) != null) {
            return true;
        }
        return false;
    }

    public static boolean hasPrevPage(@NonNull DataBuffer<?> dataBuffer) {
        Bundle metadata = dataBuffer.getMetadata();
        if (metadata != null && metadata.getString(KEY_PREV_PAGE_TOKEN) != null) {
            return true;
        }
        return false;
    }
}
