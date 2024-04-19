package b.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: JsonArray.java */
/* loaded from: classes.dex */
public final class g extends j implements Iterable<j> {

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f36a = new ArrayList();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof g) && ((g) obj).f36a.equals(this.f36a));
    }

    public void h(j jVar) {
        if (jVar == null) {
            jVar = l.f37a;
        }
        this.f36a.add(jVar);
    }

    public int hashCode() {
        return this.f36a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<j> iterator() {
        return this.f36a.iterator();
    }
}
