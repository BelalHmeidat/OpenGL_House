import java.awt.*;

public class ColorMath {

    static public int r = 0; static public int g = 0; static public int b = 0;
    static public int h = 0; static public float s = 0; static public float v =0;
    static public float c = 0; static public float m = 0; static public float y = 0;


    public static void rgb2hsv(int r, int g, int b) {
        int high = max(r, g, b);
        int low = min(r, g, b);
        int mid = mid(r, g, b);

        v = high / 255f;
        if (high == 0) {
            s = h = 0;
        } else {
            s = ((high - low) / (float) high);
        }
        if (s == 0) {
            h = 0;
        } else {
            float alpha = (float) 60 * (mid - low) / (high - low);
            if (high == r && mid == g) {
                h = (int) alpha;
            } else {
                if (high == r && mid == b) {
                    h = (int) (360 - alpha);
                } else {
                    if (high == g && mid == b) {
                        h = (int) (120 + alpha);
                    } else {
                        if (high == g && mid == r) {
                            h = (int) (120 - alpha);
                        } else {
                            if (high == b && mid == r) {
                                h = (int) (240 + alpha);
                            } else {
                                if (high == b && mid == g) {
                                    h = (int) (240 - alpha);
                                }
                            }
                        }
                    }
                }
            }


        }

    }
    public static void hsv2rgb(int h, float s, float v) {
        float high = v;
        float low = v * (1 - s);
//        float mid = v * (1 - s * (h % 60) / 60);
        float mid = low + (h%60) * (high - low)/60;
//        r = 0;
//        g = 0;
//        b = 0;

        if (h < 60) {
            r = (int)(high*255+0.5f);
            g = (int)(mid*255+0.5f);
            b = (int)(low*255+0.5);
        } else if (h < 120) {
            r = (int)(mid*255+0.5f);
            g = (int)(high*255+0.5f);
            b = (int)(low*255+0.5);
        } else if (h < 180) {
            r = (int)(low*255+0.5);
            g = (int)(high*255+0.5f);
            b = (int)(mid*255+0.5f);
        } else if (h < 240) {
            r = (int)(low*255+0.5);
            g = (int)(mid*255+0.5f);
            b = (int)(high*255+0.5f);
        } else if (h < 300) {
            r = (int)(mid*255+0.5f);
            g = (int)(low*255+0.5);
            b = (int)(high*255+0.5f);
        } else if (h < 360) {
            r = (int)(high*255+0.5f);
            g = (int)(low*255+0.5);
            b = (int)(mid*255+0.5f);
        }
    }

    //method that picks the max int out of 3 ints
        public static int max(int a, int b, int c) {
            if (a >= b && a >= c) {
                return a;
            } else if (b >= a && b >= c) {
                return b;
            } else if (c >= a && c >= b) {
                return c;
            }
            return a;
        }

        //method that picks the min int out of 3 ints
        public static int min(int a, int b, int c) {
            if (a <= b && a <= c) {
                return a;
            } else if (b <= a && b <= c) {
                return b;
            } else if (c <= a && c <= b) {
                return c;
            }
            return b;
        }
        //method that pickes the mid of 3 ints
        public static int mid(int a, int b, int c) {
            if (a >= b && a <= c || a <= b && a >= c) {
                return a;
            } else if (b >= a && b <= c || b <= a && b >= c) {
                return b;
            } else if (c >= a && c <= b || c <= a && c >= b) {
                return c;
            }
            return c;
        }


    public static void rgb2cmy (int r, int g, int b) {
        c = (255 - r)/255.0f;
        m = (255 - g)/255.0f;
        y = (255 - b)/255.0f;
    }
    public static void cmy2rgb (float c, float m, float y) {
        r = (int)((1 - c) * 255 + 0.5);
        g = (int)((1 - m) * 255 + 0.5);
        b = (int)((1 - y) * 255 + 0.5);
    }
    public static void hsv2cmy (int h, float s, float v) {
        hsv2rgb(h, s, v);
        rgb2cmy(r, g, b);
    }
    public static void cmy2hsv (float c, float m, float y) {
        cmy2rgb(c, m, y);
        rgb2hsv(r, g, b);
    }
}
