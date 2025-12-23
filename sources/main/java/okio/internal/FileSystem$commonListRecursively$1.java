package okio.internal;

import java.util.Iterator;
import kotlin.collections.m;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.j;
import kotlin.g0;
import kotlin.jvm.functions.Function2;
import kotlin.n1;
import kotlin.sequences.o;
import okio.FileSystem;
import okio.Path;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@DebugMetadata(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", i = {0, 0, 0}, l = {96}, m = "invokeSuspend", n = {"$this$sequence", "stack", "child"}, s = {"L$0", "L$1", "L$3"}, v = 1)
/* renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name */
/* loaded from: D:\Downloads\app\classes4.dex */
final class FileSystem$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<o<? super Path>, kotlin.coroutines.e<? super n1>, Object> {
    final /* synthetic */ Path $dir;
    final /* synthetic */ boolean $followSymlinks;
    final /* synthetic */ FileSystem $this_commonListRecursively;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileSystem$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z5, kotlin.coroutines.e<? super FileSystem$commonListRecursively$1> eVar) {
        super(2, eVar);
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = z5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.e<n1> create(Object obj, kotlin.coroutines.e<?> eVar) {
        FileSystem$commonListRecursively$1 fileSystem$commonListRecursively$1 = new FileSystem$commonListRecursively$1(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, eVar);
        fileSystem$commonListRecursively$1.L$0 = obj;
        return fileSystem$commonListRecursively$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(o<? super Path> oVar, kotlin.coroutines.e<? super n1> eVar) {
        return ((FileSystem$commonListRecursively$1) create(oVar, eVar)).invokeSuspend(n1.f44123a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterator<Path> it;
        m mVar;
        o oVar = (o) this.L$0;
        Object l6 = kotlin.coroutines.intrinsics.a.l();
        int i6 = this.label;
        if (i6 == 0) {
            g0.n(obj);
            m mVar2 = new m();
            mVar2.addLast(this.$dir);
            it = this.$this_commonListRecursively.list(this.$dir).iterator();
            mVar = mVar2;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            it = (Iterator) this.L$2;
            mVar = (m) this.L$1;
            g0.n(obj);
        }
        Iterator<Path> it2 = it;
        while (it2.hasNext()) {
            Path next = it2.next();
            FileSystem fileSystem = this.$this_commonListRecursively;
            boolean z5 = this.$followSymlinks;
            this.L$0 = oVar;
            this.L$1 = mVar;
            this.L$2 = it2;
            this.L$3 = j.a(next);
            this.label = 1;
            if (FileSystem.collectRecursively(oVar, fileSystem, mVar, next, z5, false, this) == l6) {
                return l6;
            }
        }
        return n1.f44123a;
    }
}
