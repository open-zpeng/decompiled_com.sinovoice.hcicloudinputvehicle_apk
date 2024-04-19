package b.a.a.w.l;

import b.a.a.q;
import b.a.a.t;
import b.a.a.u;
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* loaded from: classes.dex */
public final class d implements u {

    /* renamed from: a  reason: collision with root package name */
    private final b.a.a.w.c f100a;

    public d(b.a.a.w.c cVar) {
        this.f100a = cVar;
    }

    @Override // b.a.a.u
    public <T> t<T> a(b.a.a.e eVar, b.a.a.x.a<T> aVar) {
        b.a.a.v.b bVar = (b.a.a.v.b) aVar.c().getAnnotation(b.a.a.v.b.class);
        if (bVar == null) {
            return null;
        }
        return (t<T>) b(this.f100a, eVar, aVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t<?> b(b.a.a.w.c cVar, b.a.a.e eVar, b.a.a.x.a<?> aVar, b.a.a.v.b bVar) {
        t<?> lVar;
        Object a2 = cVar.a(b.a.a.x.a.a(bVar.value())).a();
        if (a2 instanceof t) {
            lVar = (t) a2;
        } else if (a2 instanceof u) {
            lVar = ((u) a2).a(eVar, aVar);
        } else {
            boolean z = a2 instanceof q;
            if (!z && !(a2 instanceof b.a.a.i)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            lVar = new l<>(z ? (q) a2 : null, a2 instanceof b.a.a.i ? (b.a.a.i) a2 : null, eVar, aVar, null);
        }
        return (lVar == null || !bVar.nullSafe()) ? lVar : lVar.a();
    }
}
