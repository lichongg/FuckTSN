package com.bytedance.adsdk.xt.xt.cw.j;

/* loaded from: D:\Downloads\app\classes3.dex */
public class g extends m {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (r0.j() != com.bytedance.adsdk.xt.xt.r.xt.METHOD) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        r0 = (com.bytedance.adsdk.xt.xt.xt.j.oq) r0;
        r1 = new java.util.LinkedList();
        r2 = new java.util.LinkedList();
        r10 = r10.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        if (r10.hasNext() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
    
        r3 = (com.bytedance.adsdk.xt.xt.xt.j) r10.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005a, code lost:
    
        if (r3.j() != com.bytedance.adsdk.xt.xt.r.r.COMMA) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        r2.addLast(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
    
        r1.add(com.bytedance.adsdk.xt.xt.up.xt.j(r2, r7, r8));
        r2.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006f, code lost:
    
        if (r2.isEmpty() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
    
        r1.add(com.bytedance.adsdk.xt.xt.up.xt.j(r2, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0078, code lost:
    
        r0.j((com.bytedance.adsdk.xt.xt.xt.j[]) r1.toArray(new com.bytedance.adsdk.xt.xt.xt.j[r1.size()]));
        r8 = r8 + 1;
        r9.push(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008c, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x008d, code lost:
    
        r9.push(com.bytedance.adsdk.xt.xt.up.xt.j(r10, r7, r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
    
        return r8 + 1;
     */
    @Override // com.bytedance.adsdk.xt.xt.cw.j.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int j(java.lang.String r7, int r8, java.util.Deque<com.bytedance.adsdk.xt.xt.xt.j> r9, com.bytedance.adsdk.xt.xt.cw.j r10) {
        /*
            r6 = this;
            r0 = 41
            char r1 = r6.j(r8, r7)
            if (r0 == r1) goto Ld
            int r7 = r10.j(r7, r8, r9)
            return r7
        Ld:
            java.util.LinkedList r10 = new java.util.LinkedList
            r10.<init>()
        L12:
            java.lang.Object r0 = r9.pollFirst()
            com.bytedance.adsdk.xt.xt.xt.j r0 = (com.bytedance.adsdk.xt.xt.xt.j) r0
            if (r0 == 0) goto L2e
            com.bytedance.adsdk.xt.xt.r.up r1 = r0.j()
            com.bytedance.adsdk.xt.xt.r.xt r2 = com.bytedance.adsdk.xt.xt.r.xt.METHOD
            if (r1 == r2) goto L2e
            com.bytedance.adsdk.xt.xt.r.up r1 = r0.j()
            com.bytedance.adsdk.xt.xt.r.r r2 = com.bytedance.adsdk.xt.xt.r.r.LEFT_PAREN
            if (r1 == r2) goto L2e
            r10.addFirst(r0)
            goto L12
        L2e:
            if (r0 == 0) goto L97
            com.bytedance.adsdk.xt.xt.r.up r1 = r0.j()
            com.bytedance.adsdk.xt.xt.r.xt r2 = com.bytedance.adsdk.xt.xt.r.xt.METHOD
            if (r1 != r2) goto L8d
            com.bytedance.adsdk.xt.xt.xt.j.oq r0 = (com.bytedance.adsdk.xt.xt.xt.j.oq) r0
            java.util.LinkedList r1 = new java.util.LinkedList
            r1.<init>()
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.util.Iterator r10 = r10.iterator()
        L48:
            boolean r3 = r10.hasNext()
            if (r3 == 0) goto L6b
            java.lang.Object r3 = r10.next()
            com.bytedance.adsdk.xt.xt.xt.j r3 = (com.bytedance.adsdk.xt.xt.xt.j) r3
            com.bytedance.adsdk.xt.xt.r.up r4 = r3.j()
            com.bytedance.adsdk.xt.xt.r.r r5 = com.bytedance.adsdk.xt.xt.r.r.COMMA
            if (r4 != r5) goto L67
            com.bytedance.adsdk.xt.xt.xt.j r3 = com.bytedance.adsdk.xt.xt.up.xt.j(r2, r7, r8)
            r1.add(r3)
            r2.clear()
            goto L48
        L67:
            r2.addLast(r3)
            goto L48
        L6b:
            boolean r10 = r2.isEmpty()
            if (r10 != 0) goto L78
            com.bytedance.adsdk.xt.xt.xt.j r7 = com.bytedance.adsdk.xt.xt.up.xt.j(r2, r7, r8)
            r1.add(r7)
        L78:
            int r7 = r1.size()
            com.bytedance.adsdk.xt.xt.xt.j[] r7 = new com.bytedance.adsdk.xt.xt.xt.j[r7]
            java.lang.Object[] r7 = r1.toArray(r7)
            com.bytedance.adsdk.xt.xt.xt.j[] r7 = (com.bytedance.adsdk.xt.xt.xt.j[]) r7
            r0.j(r7)
            int r8 = r8 + 1
            r9.push(r0)
            return r8
        L8d:
            com.bytedance.adsdk.xt.xt.xt.j r7 = com.bytedance.adsdk.xt.xt.up.xt.j(r10, r7, r8)
            r9.push(r7)
            int r8 = r8 + 1
            return r8
        L97:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r10 = 0
            java.lang.String r7 = r7.substring(r10, r8)
            r9.<init>(r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.xt.xt.cw.j.g.j(java.lang.String, int, java.util.Deque, com.bytedance.adsdk.xt.xt.cw.j):int");
    }
}
