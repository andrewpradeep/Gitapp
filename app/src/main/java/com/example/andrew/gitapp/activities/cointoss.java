package com.example.andrew.gitapp.activities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andrew.gitapp.R;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class cointoss extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private ImageView coin;
    private Button btn,plybtn;
    String team ,twin,chose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cointoss);
        coin = (ImageView) findViewById(R.id.coin);
        btn = (Button) findViewById(R.id.btn);
        plybtn=(Button)findViewById(R.id.play);
        plybtn.setEnabled(false);
        team =RANDOM.nextFloat() > 0.5f ? "team1" : "team2";
        Toast.makeText(this,team+" will flip the coin",Toast.LENGTH_LONG).show();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipCoin();
                btn.setEnabled(false);

                plybtn.setEnabled(true);

            }
        });
        plybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(cointoss.this);
                builder.setMessage("who won the  toss");
                builder.setPositiveButton(
                        "team2", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                twin ="team2";
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(cointoss.this);
                                builder1.setMessage(twin+" choose to");
                                builder1.setPositiveButton(
                                        "bowl", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                chose ="bowl";
                                                Intent intent = new Intent(cointoss.this,GameMain.class);
                                                intent.putExtra("tosswon",twin);
                                                intent.putExtra("chose",chose);
                                                startActivity(intent);
                                            }
                                        }
                                );
                                builder1.setNegativeButton(
                                        "bat", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                chose ="bat";
                                                Intent intent = new Intent(cointoss.this,GameMain.class);
                                                intent.putExtra("tosswon",twin);
                                                intent.putExtra("chose",chose);
                                                startActivity(intent);
                                            }
                                        }
                                );
                                AlertDialog alert2 = builder1.create();
                                alert2.show();
                            }
                        }
                );
                builder.setNegativeButton(
                        "team1", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                twin ="team1";
                                AlertDialog.Builder builder1 = new AlertDialog.Builder(cointoss.this);
                                builder1.setMessage(twin+" choose to");
                                builder1.setPositiveButton(
                                        "bowl", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                chose="bowl";
                                                Intent intent = new Intent(cointoss.this,GameMain.class);
                                                intent.putExtra("tosswon",twin);
                                                intent.putExtra("chose",chose);
                                                startActivity(intent);
                                            }
                                        }
                                );
                                builder1.setNegativeButton(
                                        "bat", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                chose="bat";
                                                Intent intent = new Intent(cointoss.this,GameMain.class);
                                                intent.putExtra("tosswon",twin);
                                                intent.putExtra("chose",chose);
                                                startActivity(intent);
                                            }
                                        }
                                );
                                AlertDialog alert2 = builder1.create();
                                alert2.show();
                            }
                        }
                );
                AlertDialog alert = builder.create();
                alert.show();

                
            }
        });
    }

    private void flipCoin() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1000);
        fadeOut.setFillAfter(true);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                coin.setImageResource(RANDOM.nextFloat() > 0.5f ? R.drawable.tails : R.drawable.heads);

                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator());
                fadeIn.setDuration(1000);
                fadeIn.setFillAfter(true);

                coin.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        coin.startAnimation(fadeOut);

    }



}
