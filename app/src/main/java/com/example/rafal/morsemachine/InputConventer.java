package com.example.rafal.morsemachine;

import android.hardware.Camera;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by Rafal on 3/7/2017.
 */

public class InputConventer {

    public static final String LOG_TAG = InputConventer.class.getSimpleName();
    //miliseconds of the lowest interval in morse code (one dot/dit)
    public static final int DIT = 0700;
    public static final int DAH = DIT * 3;
    public static final int PAUSE = DIT * 7;

    public static void convertInput(String userInput) {
        for (int i = 0; i < userInput.length(); i++) {
            char convertibleChar = userInput.charAt(i);

            // and if char != space
            if (i != 0 && convertibleChar != ' '){
                pauseBetweenCharacters();
            } else {
                // no pause
            }

            switch (convertibleChar) {
                case ' ':
                    pauseBetweenWords();
                    break;
                case 'a':
                case 'A':
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'b':
                case 'B':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'c':
                case 'C':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'd':
                case 'D':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'e':
                case 'E':
                    dit();
                    break;
                case 'f':
                case 'F':
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'g':
                case 'G':
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'h':
                case 'H':
                    dit();
                    pauseBetweenCharacters();
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'i':
                case 'I':
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'j':
                case 'J':
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'k':
                case 'K':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'l':
                case 'L':
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'm':
                case 'M':
                    dah();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'n':
                case 'N':
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'o':
                case 'O':
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'p':
                case 'P':
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 'q':
                case 'Q':
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'r':
                case 'R':
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    break;
                case 's':
                case 'S':
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    break;
                case 't':
                case 'T':
                    dah();
                    break;
                case 'u':
                case 'U':
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'v':
                case 'V':
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'w':
                case 'W':
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'x':
                case 'X':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'y':
                case 'Y':
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dah();
                    break;
                case 'z':
                case 'Z':
                    dah();
                    pauseBetweenElements();
                    dah();
                    pauseBetweenElements();
                    dit();
                    pauseBetweenElements();
                    dit();
                default:
                    Log.v(LOG_TAG, "non a, b, c letter");
            }
        }
    }

    public static void dit() {
        Camera cam = Camera.open();
        Camera.Parameters p = cam.getParameters();
        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        cam.startPreview();
        SystemClock.sleep(DIT);
        cam.stopPreview();
        cam.release();
    }
    public static void dah(){
        Camera cam = Camera.open();
        Camera.Parameters p = cam.getParameters();
        p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        cam.setParameters(p);
        cam.startPreview();
        SystemClock.sleep(DAH);
        cam.stopPreview();
        cam.release();
    }
    public static void pauseBetweenCharacters(){
        SystemClock.sleep(DAH);
    }
    public static void pauseBetweenElements(){
        SystemClock.sleep(DIT);
    }
    public static void pauseBetweenWords(){
        SystemClock.sleep(PAUSE);
    }
}
