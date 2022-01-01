package com.example.electionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean vote = false;
private TextView textView_id;
private TextView msg_hello;
private TextView msg_select_party;
private TextView citizen;
private TextView sickCitizen;
private TextView soldier;
private EditText Tv_enterId;
private Button bt_confirm;

private ImageView btn_Licud;
private ImageView btn_white_blue;
private ImageView btn_havoda;
private TextView msg_wrong_kelpi;
private TextView txt_wearing_suit;
private Button btn_yes;
private Button btn_No;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_id = findViewById(R.id.textView_id);
        msg_hello = findViewById(R.id.msg_hello);
        msg_select_party = findViewById(R.id.msg_select_party);
        Tv_enterId = findViewById(R.id.Tv_enterId);
        bt_confirm = findViewById(R.id.bt_confirm);
        btn_Licud =findViewById(R.id.btn_Licud);
        btn_white_blue =findViewById(R.id.btn_white_blue);
        btn_havoda =findViewById(R.id.btn_havoda);
        msg_wrong_kelpi = findViewById(R.id.msg_wrong_kelpi);
        txt_wearing_suit = findViewById(R.id.txt_wearing_suit);
        btn_yes = findViewById(R.id.btn_yes);
        btn_No = findViewById(R.id.btn_no);
        citizen = findViewById(R.id.citizen);
        sickCitizen = findViewById(R.id.sickCitizen);
        soldier = findViewById(R.id.soldier);
        citizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citizen.setVisibility(View.GONE);
                sickCitizen.setVisibility(View.GONE);
                soldier.setVisibility(View.GONE);
                normalCitizenTryToVote();
            }
        });
        sickCitizen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citizen.setVisibility(View.GONE);
               // sickCitizen.setVisibility(View.GONE);
                //soldier.setVisibility(View.GONE);
                sickCitizen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sickCitizen.setVisibility(View.GONE);
                        soldier.setVisibility(View.GONE);
                        sickCitizen();
                    }
                });
                soldier.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sickCitizen.setVisibility(View.GONE);
                        soldier.setVisibility(View.GONE);
                        textView_id.setVisibility(View.GONE);
                        Tv_enterId.setVisibility(View.GONE);
                        bt_confirm.setVisibility(View.GONE);
                        txt_wearing_suit.setVisibility(View.VISIBLE);
                        btn_yes.setVisibility(View.VISIBLE);
                        btn_No.setVisibility(View.VISIBLE);
                        btn_yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                txt_wearing_suit.setVisibility(View.GONE);
                                btn_yes.setVisibility(View.GONE);
                                btn_No.setVisibility(View.GONE);
                                normalSoldier();
                            }
                        });
                        btn_No.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                txt_wearing_suit.setText("You Can't Vote");
                                btn_yes.setVisibility(View.GONE);
                                btn_No.setVisibility(View.GONE);
                            }
                        });
                    }
                });
            }
        });
        soldier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citizen.setVisibility(View.GONE);
                sickCitizen.setVisibility(View.GONE);
                soldier.setVisibility(View.GONE);
                normalSoldier();
            }
        });
        //normalCitizenTryToVote();
        //normalCitizenInWrongKalpi();
        //sickCitizen();
        //normalSoldier();
       // voteTwice();
      //  if(vote)
           // sickCitizen();


    }

    private void voteTwice() {
        sickCitizen();

        /*
        if(vote) {
            textView_id.setVisibility(View.GONE);
            Tv_enterId.setVisibility(View.GONE);
            bt_confirm.setVisibility(View.GONE);
            txt_wearing_suit.setVisibility(View.VISIBLE);
            btn_yes.setVisibility(View.VISIBLE);
            btn_No.setVisibility(View.VISIBLE);
            btn_yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txt_wearing_suit.setVisibility(View.GONE);
                    btn_yes.setVisibility(View.GONE);
                    btn_No.setVisibility(View.GONE);
                    textView_id.setVisibility(View.VISIBLE);
                    Tv_enterId.setVisibility(View.VISIBLE);
                    bt_confirm.setVisibility(View.VISIBLE);
                    bt_confirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            txt_wearing_suit.setText("You Are Already Voted");
                            txt_wearing_suit.setVisibility(View.VISIBLE);
                        }
                    });
                }
            });
            btn_No.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    txt_wearing_suit.setText("You Cant Vote");
                    btn_yes.setVisibility(View.GONE);
                    btn_No.setVisibility(View.GONE);
                }
            });
        }

         */
    }

    private void normalSoldier() {
        txt_wearing_suit.setText("Are You Carrying A Weapon?");
        sickCitizen();

    }

    private void sickCitizen() {
        textView_id.setVisibility(View.GONE);
        Tv_enterId.setVisibility(View.GONE);
        bt_confirm.setVisibility(View.GONE);
        txt_wearing_suit.setVisibility(View.VISIBLE);
        btn_yes.setVisibility(View.VISIBLE);
        btn_No.setVisibility(View.VISIBLE);
        btn_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_wearing_suit.setVisibility(View.GONE);
                btn_yes.setVisibility(View.GONE);
                btn_No.setVisibility(View.GONE);
                textView_id.setVisibility(View.VISIBLE);
                Tv_enterId.setVisibility(View.VISIBLE);
                bt_confirm.setVisibility(View.VISIBLE);
                if(!vote) {
                    normalCitizenTryToVote();
                }
                else{
                    txt_wearing_suit.setText("You Are Already Voted");
                    txt_wearing_suit.setVisibility(View.VISIBLE);
                }
            }
        });
        btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_wearing_suit.setText("You Can't Vote");
                btn_yes.setVisibility(View.GONE);
                btn_No.setVisibility(View.GONE);
            }
        });
    }

    private void normalCitizenInWrongKalpi() {
        bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_id.setVisibility(View.GONE);
                Tv_enterId.setVisibility(View.GONE);
                bt_confirm.setVisibility(View.GONE);
                msg_wrong_kelpi.setVisibility(View.VISIBLE);
               // msg_hello.setVisibility(View.VISIBLE);
                // msg_hello.setText("Sorry You Are In The Wrong Kalpi");
            }
        });
    }

    private void normalCitizenTryToVote() {
        bt_confirm.setVisibility(View.VISIBLE);
        textView_id.setVisibility(View.VISIBLE);
        Tv_enterId.setVisibility(View.VISIBLE);
        bt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView_id.setVisibility(View.GONE);
                Tv_enterId.setVisibility(View.GONE);
                bt_confirm.setVisibility(View.GONE);
                msg_hello.setVisibility(View.VISIBLE);
                msg_hello.setText("Hello please select a party");
                //msg_ok_or_not.setVisibility(View.GONE);
               // btn_start_vote.setVisibility(View.GONE);
                btn_Licud.setVisibility(View.VISIBLE);
                btn_white_blue.setVisibility(View.VISIBLE);
                btn_havoda.setVisibility(View.VISIBLE);
                //msg_ok_or_not.setText("you are in the wrong kalpi");
                //btn_start_vote.setVisibility(View.VISIBLE);
            }
        });

        btn_Licud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote =true;
                msg_hello.setVisibility(View.GONE);
                btn_Licud.setVisibility(View.GONE);
                btn_white_blue.setVisibility(View.GONE);
                btn_havoda.setVisibility(View.GONE);
                msg_select_party.setVisibility(View.VISIBLE);
                msg_select_party.setText("You Have Selected The Licud Party");
                Context context = getApplicationContext();
                CharSequence text = "Thanks For Your Participation!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btn_white_blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote =true;
                msg_hello.setVisibility(View.GONE);
                btn_Licud.setVisibility(View.GONE);
                btn_white_blue.setVisibility(View.GONE);
                btn_havoda.setVisibility(View.GONE);
                msg_select_party.setVisibility(View.VISIBLE);
                msg_select_party.setText("You Have Selected The White-Blue Party");
                Context context = getApplicationContext();
                CharSequence text = "Thanks For Your Participation!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btn_havoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vote =true;
                msg_hello.setVisibility(View.GONE);
                btn_Licud.setVisibility(View.GONE);
                btn_white_blue.setVisibility(View.GONE);
                btn_havoda.setVisibility(View.GONE);
                msg_select_party.setVisibility(View.VISIBLE);
                msg_select_party.setText("You Have Selected The Havoda Party");
                Context context = getApplicationContext();
                CharSequence text = "Thanks For Your Participation!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}