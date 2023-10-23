package oop.immutable;

public class ImmutableRGB {
    // Values must be between 0 and 255
    final private int red;
    final private int green;
    final private int blue;
    final private String name;

    public static void main(String[] args) {
        ImmutableRGB rgb = new ImmutableRGB(255, 0, 0, "Red");
        System.out.println("The color: " + rgb.getName());

        rgb = new ImmutableRGB(0, 255, 0, "Green");
        System.out.println("The color: " + rgb.getName());

        rgb = new ImmutableRGB(0, 0, 255, "Blue");
        System.out.println("The color: " + rgb.getName());
    }

    private void check(int red, int green, int blue) {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255) {
            throw new IllegalArgumentException();
        }
    }

    public ImmutableRGB(int red, int green, int blue, String name) {
        check(red, green, blue);
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.name = name;
    }

    public int getRGB() {
        return ((red << 16) | (green << 8) | blue);
    }

    public String getName() {
        return name;
    }

    public ImmutableRGB invert() {
        return new ImmutableRGB(255 - red, 255 - green, 255 - blue, "Inverse of " + name);
    }

}
