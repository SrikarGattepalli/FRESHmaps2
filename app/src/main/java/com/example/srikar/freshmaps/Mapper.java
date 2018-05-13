package com.example.srikar.freshmaps;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;

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

        //creating view and setting text to teacher and room(s)
        setContentView(R.layout.activity_map);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String[] total = getIntent().getExtras().getStringArray("total");
        String first = total[0];
        String total1 = total[2];
        ((TextView) findViewById(R.id.RoomDisplay)).setText(Html.fromHtml(first + "<b>" + total1 + "</b"));

        //Obtaining the building number(first character) and room number(rest of string) from the selected room
        String f = total[1].toLowerCase().substring(0, 1);
        String l = "";
        if (total[1].length() > 1) {
            l = total[1].toLowerCase().substring(1, 2);

        }
        int digits = 0;
        if (total[1].length() > 3) {
            digits = Integer.parseInt(total[1].substring(2, 4));
        }

        final ImageView main = (ImageView) findViewById(R.id.evhsMap);

        int x = 0, y = 0;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int height = displayMetrics.heightPixels;
        final int width = displayMetrics.widthPixels;


        //checking for the building and room numbers to highlight the correct area of the map
        //checking for portables or p building
        if (f.equals("p")) {
            //Checking for the exact portable unit
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
                    //If proven to be p building, checks to see which part of p building the room is
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
            //checking for odd buildings of e and g
        } else if (f.equals("g")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.gmap);
        } else if (f.equals("e")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.emap);
        }
        // checking for a building
        else if (f.equals("a")) {
            // checking whether the room is on the second or first floor and then whether it is on the right or left side of the building
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
        }
        //Checking for b building
        else if (f.equals("b")) {
            // checking whether the room is on the second or first floor and then whether it is on the right or left side of the building
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
        }
        //more buildings that don't require in depth highlighting
        else if (f.equals("c")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.cmap);
        } else if (f.equals("f")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.fmap);
        } else if (f.equals("d")) {
            ((ImageView) findViewById(R.id.evhsMap)).setImageResource(R.mipmap.dmap);
        }

        //Creation of objects that will scale up or down the map
        ArrayList<ObjectAnimator> anim = new ArrayList<ObjectAnimator>();

        anim.add(ObjectAnimator.ofFloat(main, "scaleX", 1));
        anim.add(ObjectAnimator.ofFloat(main, "scaleY", 1));

        Iterator<ObjectAnimator> iter = anim.iterator();
        while (iter.hasNext()) {
            ObjectAnimator curr = iter.next();
            curr.setDuration(2000);
            curr.start();
        }

        // set maximum scroll amount (based on center of image)
        int maxX = (int) ((1300) - (width / 2));
        int maxY = (int) ((1400) - (height / 2));

        // set scroll limits
        final int maxLeft = (maxX * -1);
        final int maxRight = maxX;
        final int maxTop = (maxY * -1);
        final int maxBottom = maxY;

        // set touchlistener
        main.setOnTouchListener(new View.OnTouchListener() {
            float downX, downY;
            int totalX = 0, totalY = 0;
            int scrollByX, scrollByY;
            int storedX = 0, storedY = 0;

            /**
             * Method that tracks the the finger as it presses the mapo and moves and scrolls accordingly
             * @param view the view where the screen was pressed
             * @param event the touch followed by movement
             * @return true when complete (used to allow for breaks and thus constant updating)
             */
            public boolean onTouch(View view, MotionEvent event) {

                float currentX, currentY;

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
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

                        Log.d("msg", storedX + " " + storedY);
                        main.scrollBy(scrollByX, scrollByY);
                        downX = currentX;
                        downY = currentY;
                        break;

                }

                return true;
            }
        });
        // zoom button initialization
        final Button zoomIn = findViewById(R.id.zIn);
        final Button zoomOut = findViewById(R.id.zOut);
        final int[] globalScale = new int[1];
        globalScale[0] = 1;

        zoomIn.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when the zoomOut button is pressed. It will increase the scale fo the image
             * by 1 and allow the zoomIn button to be clicked. If the scale increases to 4, the zoomOut button
             * is made invisible
             * @param v the view where the button was clicked
             */
            @Override
            public void onClick(View v) {
                globalScale[0] = (globalScale[0] + 1 <= 4) ? globalScale[0] + 1 : globalScale[0];

                performZoom(main, globalScale[0]);
                if (globalScale[0] == 4) {
                    zoomIn.setClickable(false);
                    zoomIn.setAlpha(0);
                }
                zoomOut.setClickable(true);
                zoomOut.setAlpha(1);
            }
        });

        zoomOut.setOnClickListener(new View.OnClickListener() {
            /**
             * Method that is called when the zoomIn button is pressed. It will decrease the scale fo the image
             * by 1 and allow the zoomOut button to be clicked. If the scale decreases to 1, the zoomIn button
             * is made invisible
             * @param v the view where the button was clicked
             */
            @Override
            public void onClick(View v) {
                globalScale[0] = (globalScale[0] - 1 >= 1) ? globalScale[0] - 1 : globalScale[0];
                performZoom(main, globalScale[0]);
                if (globalScale[0] == 1) {
                    zoomOut.setClickable(false);
                    zoomOut.setAlpha(0);
                }
                zoomIn.setClickable(true);
                zoomIn.setAlpha(1);
            }
        });

        zoomOut.setClickable(false);
        zoomOut.setAlpha(0);
    }

    /**
     * Method that resizes the target image to the appropiate scale
     *
     * @param target the target image to be scaled
     * @param scale  the scale the image will be resized to
     */
    public void performZoom(ImageView target, float scale) {
        ObjectAnimator zoomX = ObjectAnimator.ofFloat(target, "scaleX", scale);
        ObjectAnimator zoomY = ObjectAnimator.ofFloat(target, "scaleY", scale);

        zoomX.setDuration(2000);
        zoomY.setDuration(2000);

        zoomX.start();
        zoomY.start();
    }
}