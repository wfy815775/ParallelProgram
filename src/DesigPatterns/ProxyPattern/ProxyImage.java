package DesigPatterns.ProxyPattern;

public class ProxyImage implements Image {
  private   RealImage realImage ;
    @Override
    public void display(String name) {
          if (realImage == null)
              realImage = new RealImage();

          realImage.display(name);
    }
}
