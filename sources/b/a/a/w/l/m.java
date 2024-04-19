package b.a.a.w.l;

import b.a.a.t;
import b.a.a.w.l.i;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TypeAdapterRuntimeTypeWrapper.java */
/* loaded from: classes.dex */
public final class m<T> extends t<T> {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.e f125a;

    /* renamed from: b  reason: collision with root package name */
    private final t<T> f126b;
    private final Type c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b.a.a.e eVar, t<T> tVar, Type type) {
        this.f125a = eVar;
        this.f126b = tVar;
        this.c = type;
    }

    private Type e(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // b.a.a.t
    public T b(JsonReader jsonReader) {
        return this.f126b.b(jsonReader);
    }

    @Override // b.a.a.t
    public void d(JsonWriter jsonWriter, T t) {
        t<T> tVar = this.f126b;
        Type e = e(this.c, t);
        if (e != this.c) {
            tVar = this.f125a.k(b.a.a.x.a.b(e));
            if (tVar instanceof i.b) {
                t<T> tVar2 = this.f126b;
                if (!(tVar2 instanceof i.b)) {
                    tVar = tVar2;
                }
            }
        }
        tVar.d(jsonWriter, t);
    }
}
