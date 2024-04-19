package b.a.a;

import java.util.Map;
import java.util.Set;
/* compiled from: JsonObject.java */
/* loaded from: classes.dex */
public final class m extends j {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.w.g<String, j> f38a = new b.a.a.w.g<>();

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f38a.equals(this.f38a));
    }

    public void h(String str, j jVar) {
        if (jVar == null) {
            jVar = l.f37a;
        }
        this.f38a.put(str, jVar);
    }

    public int hashCode() {
        return this.f38a.hashCode();
    }

    public Set<Map.Entry<String, j>> i() {
        return this.f38a.entrySet();
    }
}
