package DesigPatterns.BridgePattern;

public abstract class shape {
    protected DrawAPI drawAPI;

    protected shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
