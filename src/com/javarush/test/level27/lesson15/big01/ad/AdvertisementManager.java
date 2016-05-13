package com.javarush.test.level27.lesson15.big01.ad;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jan on 5/13/16.
 */
public class AdvertisementManager
{
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private int timeSeconds;

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos() throws NoVideoAvailableException {
        List<Advertisement> videos = storage.list();
        if (videos.isEmpty()) throw new NoVideoAvailableException();

        Collections.sort(videos, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        int timeLeft = timeSeconds;

        List<Advertisement> videosToShow = new ArrayList<>();

        for (Advertisement advertisement : videos) {
            if (timeLeft <= 0) break;
            videosToShow.add(advertisement);
            timeLeft -= advertisement.getDuration();
        }


        Collections.sort(videosToShow, new Comparator<Advertisement>()
        {
            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if (o1.getAmountPerOneDisplaying() == o2.getAmountPerOneDisplaying()) {
                    return (int) (((float)o1.getAmountPerOneDisplaying()/o1.getDuration() - (float)o2.getAmountPerOneDisplaying()/o2.getDuration()) * 1000);
                }
                else return (int) (o2.getAmountPerOneDisplaying() - o1.getAmountPerOneDisplaying());
            }
        });

        for (Advertisement advertisement : videosToShow) {


            ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", advertisement.getName(),
                    (int) advertisement.getAmountPerOneDisplaying(),
                    (int) (((float)advertisement.getAmountPerOneDisplaying() / (float) advertisement.getDuration()) * 1000)));

            advertisement.revalidate();
        }
    }
}
