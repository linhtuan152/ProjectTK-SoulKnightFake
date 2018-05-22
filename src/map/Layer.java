package map;

import base.GameObjectManager;

import java.util.List;

public class Layer {
    private List<Integer> data;
    private int height;
    private int width;

    @Override
    public String toString() {
        return "Layer{" +
                "data=" + data +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public void generate() {
        for (int titleY = 0; titleY < height; titleY ++) {
            for(int titleX = 0; titleX < width; titleX++) {
                int mapData = data.get(titleY * width + titleX);
                if (mapData != 0) {

                    Platform platform = Platform.create(mapData);
                    platform.position.set(titleX * 32, titleY * 32);
                    System.out.println(platform.position.x);
                    System.out.println(platform.position.y);
                    GameObjectManager.instance.add(platform);
                }
            }
        }
    }
}
