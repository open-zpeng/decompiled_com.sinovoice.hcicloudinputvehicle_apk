package com.sinovoice.hcicloudsdk.common.ocr;
/* loaded from: classes.dex */
public class OcrRecogNode {

    /* renamed from: a  reason: collision with root package name */
    private int f408a;

    /* renamed from: b  reason: collision with root package name */
    private OcrRecogPageNode f409b;
    private OcrRecogRegionNode c;
    private OcrRecogCellNode d;
    private OcrRecogLineNode e;
    private OcrRecogCharNode f;

    public OcrRecogCellNode getCellNode() {
        return this.d;
    }

    public OcrRecogCharNode getCharNode() {
        return this.f;
    }

    public OcrRecogLineNode getLineNode() {
        return this.e;
    }

    public int getNodeType() {
        return this.f408a;
    }

    public OcrRecogPageNode getPageNode() {
        return this.f409b;
    }

    public OcrRecogRegionNode getRegionNode() {
        return this.c;
    }

    public void setCellNode(OcrRecogCellNode ocrRecogCellNode) {
        this.d = ocrRecogCellNode;
    }

    public void setCharNode(OcrRecogCharNode ocrRecogCharNode) {
        this.f = ocrRecogCharNode;
    }

    public void setLineNode(OcrRecogLineNode ocrRecogLineNode) {
        this.e = ocrRecogLineNode;
    }

    public void setNodeType(int i) {
        this.f408a = i;
    }

    public void setPageNode(OcrRecogPageNode ocrRecogPageNode) {
        this.f409b = ocrRecogPageNode;
    }

    public void setRegionNode(OcrRecogRegionNode ocrRecogRegionNode) {
        this.c = ocrRecogRegionNode;
    }
}
