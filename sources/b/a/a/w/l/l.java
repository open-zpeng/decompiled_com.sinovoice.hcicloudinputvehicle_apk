package b.a.a.w.l;

import b.a.a.p;
import b.a.a.q;
import b.a.a.t;
import b.a.a.u;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes.dex */
public final class l<T> extends t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final q<T> f122a;

    /* renamed from: b  reason: collision with root package name */
    private final b.a.a.i<T> f123b;
    final b.a.a.e c;
    private final b.a.a.x.a<T> d;
    private final u e;
    private final l<T>.b f = new b();
    private t<T> g;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes.dex */
    private final class b implements p, b.a.a.h {
        private b() {
        }
    }

    public l(q<T> qVar, b.a.a.i<T> iVar, b.a.a.e eVar, b.a.a.x.a<T> aVar, u uVar) {
        this.f122a = qVar;
        this.f123b = iVar;
        this.c = eVar;
        this.d = aVar;
        this.e = uVar;
    }

    private t<T> e() {
        t<T> tVar = this.g;
        if (tVar != null) {
            return tVar;
        }
        t<T> m = this.c.m(this.e, this.d);
        this.g = m;
        return m;
    }

    @Override // b.a.a.t
    public T b(JsonReader jsonReader) {
        if (this.f123b == null) {
            return e().b(jsonReader);
        }
        b.a.a.j a2 = b.a.a.w.j.a(jsonReader);
        if (a2.e()) {
            return null;
        }
        return this.f123b.a(a2, this.d.e(), this.f);
    }

    @Override // b.a.a.t
    public void d(JsonWriter jsonWriter, T t) {
        q<T> qVar = this.f122a;
        if (qVar == null) {
            e().d(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            b.a.a.w.j.b(qVar.a(t, this.d.e(), this.f), jsonWriter);
        }
    }
}
