package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by jan on 16.09.15.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes k)
    {
        if (k == ImageTypes.JPG) return new JpgReader();
        else if (k == ImageTypes.PNG) return new PngReader();
        else if (k == ImageTypes.BMP) return new BmpReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
