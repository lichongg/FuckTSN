package com.kwad.sdk.utils;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class av {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static int a(boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6) {
        ?? r02 = z5;
        if (z6) {
            r02 = (z5 ? 1 : 0) | 2;
        }
        if (z7) {
            r02 = (r02 == true ? 1 : 0) | 4;
        }
        if (z8) {
            r02 = (r02 == true ? 1 : 0) | '\b';
        }
        if (z9) {
            r02 = (r02 == true ? 1 : 0) | 16;
        }
        if (z10) {
            r02 = (r02 == true ? 1 : 0) | ' ';
        }
        return i6 == 2 ? r02 | 64 : r02;
    }
}
