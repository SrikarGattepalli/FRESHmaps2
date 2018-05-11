package com.example.srikar.freshmaps;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * View of map that states the room and its corresponding teacher(s) and allows for scrolling to look around the map
 */
public class Mapper extends AppCompatActivity {
    /**
     * Method that is called to set the view to the map and set the text to the right information
     *
     * @param savedInstanceState state of the view
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String[] total = getIntent().getExtras().getStringArray("total");
        String total1 = total[0];
        ((TextView) findViewById(R.id.RoomDisplay)).setText(total1);

        String f = total[1].toLowerCase().substring(0, 1);
        String l = "";
        if (total[1].length() > 1) {
            l = total[1].toLowerCase().substring(1, 2);

        }
        int digits = 0;
        if (total[1].length() > 3) {
            digits = Integer.parseInt(total[1].substring(2, 4));
        }

        final int x = 500, y = 500;
        if (f.equals("p")) {
            if (total[1].length() == 2) {
                if (l.equals("1")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p1map);

                }
                if (l.equals("2")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p2map);

                }
                if (l.equals("3")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p3map);

                }
                if (l.equals("4")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p4map);

                }
                if (l.equals("5")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p5map);

                }
                if (l.equals("6")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p6map);

                }
                if (l.equals("7")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p7map);

                }
                if (l.equals("8")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p8map);

                }
                if (l.equals("9")) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p9map);

                }
            } else {
                if (f.equals("p") && total[1].length() == 3) {
                    l += total[1].substring(2, 3);
                    if (l.equals("10")) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p10map);

                    } else if (l.equals("11")) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p11map);

                    } else if (l.equals("12")) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p12map);

                    }

                } else {
                    digits = Integer.parseInt(total[1].substring(1, 4));
                    if (digits == 101 || digits == 105 || digits == 107 || digits == 111) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.pbottombottommap);
                    } else if (digits == 108 || digits == 106 || digits == 104 || digits == 102 || digits == 100) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.pbottomtopmap);
                    } else if (digits == 209 || digits == 207 || digits == 205 || digits == 203 || digits == 201) {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.ptopbottommap);
                    } else {
                        ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.ptoptopmap);
                    }

                }
            }

        } else if (f.equals("p") && total[1].length() == 3) {
            if (l.equals("10")) {
                ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p10map);

            } else if (l.equals("11")) {
                ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p11map);

            } else if (l.equals("12")) {
                ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.p12map);

            }

        } else if (f.equals("g")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.gmap);
        } else if (f.equals("e")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.emap);
        } else if (f.equals("a")) {
            if (l.equals("2")) {
                if (digits >= 8 && digits <= 18) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.atopleftmap);
                } else {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.atoprightmap);
                }


            } else {
                if (digits >= 8 && digits <= 22) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.abottomleftmap);
                } else {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.abottomrightmap);

                }
            }
        } else if (f.equals("b")) {
            if (l.equals("2")) {
                if (digits >= 8 && digits <= 18) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.btopleftmap);
                } else {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.btoprightmap);

                }
            } else {
                if (digits >= 8 && digits <= 18) {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.bbottomleftmap);

                } else {
                    ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.bbottomrightmap);
                }
            }
        } else if (f.equals("c")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.cmap);
        } else if (f.equals("f")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.fmap);
        } else if (f.equals("d")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.dmap);
        }

        final ImageView main = (ImageView) findViewById(R.id.evhsMap);
        boolean active = true;

        double currX = 0, currY = 0;
        while (currX != x || currY != y && active) {
            int xSp = (int) Math.copySign(1, x - currX);
            int ySp = (int) Math.copySign(1, y - currY);

            currX += xSp;
            currY += ySp;
            main.scrollBy(xSp, ySp);
        }
        active = false;


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        // set maximum scroll amount (based on center of image)
        int maxX = (int) ((width * 2) - (width / 2));
        int maxY = (int) ((height * 2) - (height / 2));

        // set scroll limits
        final int maxLeft = (maxX * -1);
        final int maxRight = maxX;
        final int maxTop = (maxY * -1);
        final int maxBottom = maxY;

        // set touchlistener
        main.setOnTouchListener(new View.OnTouchListener() {
            float downX, downY;
            int totalX = x, totalY = y;
            int scrollByX, scrollByY;
            int storedX = 0, storedY = 0;

            public boolean onTouch(View view, MotionEvent event) {

                float currentX, currentY;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        downX = event.getX();
                        downY = event.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        currentX = event.getX();
                        currentY = event.getY();
                        scrollByX = (int) (downX - currentX);
                        scrollByY = (int) (downY - currentY);

                        // scrolling to left side of image (pic moving to the right)
                        if (currentX > downX) {
                            if (totalX == maxLeft) {
                                scrollByX = 0;
                            }
                            if (totalX > maxLeft) {
                                totalX = totalX + scrollByX;
                            }
                            if (totalX < maxLeft) {
                                scrollByX = maxLeft - (totalX - scrollByX);
                                totalX = maxLeft;
                            }
                        }

                        // scrolling to right side of image (pic moving to the left)
                        if (currentX < downX) {
                            if (totalX == maxRight) {
                                scrollByX = 0;
                            }
                            if (totalX < maxRight) {
                                totalX = totalX + scrollByX;
                            }
                            if (totalX > maxRight) {
                                scrollByX = maxRight - (totalX - scrollByX);
                                totalX = maxRight;
                            }
                        }

                        // scrolling to top of image (pic moving to the bottom)
                        if (currentY > downY) {
                            if (totalY == maxTop) {
                                scrollByY = 0;
                            }
                            if (totalY > maxTop) {
                                totalY = totalY + scrollByY;
                            }
                            if (totalY < maxTop) {
                                scrollByY = maxTop - (totalY - scrollByY);
                                totalY = maxTop;
                            }
                        }

                        // scrolling to bottom of image (pic moving to the top)
                        if (currentY < downY) {
                            if (totalY == maxBottom) {
                                scrollByY = 0;
                            }
                            if (totalY < maxBottom) {
                                totalY = totalY + scrollByY;
                            }
                            if (totalY > maxBottom) {
                                scrollByY = maxBottom - (totalY - scrollByY);
                                totalY = maxBottom;
                            }
                        }

                        storedX += scrollByX;
                        storedY += scrollByY;

                        main.scrollBy(scrollByX, scrollByY);
                        downX = currentX;
                        downY = currentY;
                        break;

                }

                return true;
            }
        });
    }
}
