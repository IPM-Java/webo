package utils;

public class TimeHelper {
    
    public static int toMins(String s) {
        String[] hourMin = s.split(":");
        int mins = Integer.parseInt(hourMin[0]);
        int secs = Integer.parseInt(hourMin[1]);
        int minToSec = mins * 60;
        return minToSec + secs;
    }
    
}
