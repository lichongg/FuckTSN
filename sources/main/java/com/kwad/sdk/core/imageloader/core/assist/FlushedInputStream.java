package com.kwad.sdk.core.imageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class FlushedInputStream extends FilterInputStream {
    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j6) {
        long j7 = 0;
        while (j7 < j6) {
            long skip = ((FilterInputStream) this).in.skip(j6 - j7);
            if (skip == 0) {
                if (read() < 0) {
                    break;
                }
                skip = 1;
            }
            j7 += skip;
        }
        return j7;
    }

    public FlushedInputStream(InputStream inputStream) {
        super(inputStream);
    }
}
