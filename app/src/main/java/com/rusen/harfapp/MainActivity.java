package com.rusen.harfapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.rusen.harfapp.databinding.ActivityMainBinding;
import com.rusen.harfapp.model.ViewList;
import com.rusen.harfapp.model.Picture;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Picture[] pictures = new Picture[]{
            new Picture(R.drawable.pomegranate,"Nar"),
            new Picture(R.drawable.cow,"İnek"),
            new Picture(R.drawable.book,"Kitap"),
            new Picture(R.drawable.crane,"Leylek"),
            new Picture(R.drawable.donkey,"Eşek"),
            new Picture(R.drawable.tree,"Ağaç"),
    };



    private int questionNumber = 0;
    private int starNum = 0;

    private View[] buttonList;
    private  View[] starImages;
    private ViewList list = new ViewList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.imageView.setImageResource(pictures[questionNumber].getImageNumber());


      buttonList = createViewList(new View[]{
              binding.button,
              binding.button2,
              binding.button3,
              binding.button4,
              binding.button5,
              binding.button6
      });

      starImages = createViewList(new View[]{
                binding.star1,
                binding.star2,
                binding.star3,
                binding.star4,
                binding.star5,
                binding.star6
        });

        //Get Buttons Text
        for (View view:buttonList
             ) {

            view.setOnClickListener(v->{
                Button button = findViewById(v.getId());
                checkImage(button.getText().toString());
            });
        }


    }

    public void checkImage(String buttonText){

        if(questionNumber==pictures.length-1){

            binding.imageView.setImageResource(R.drawable.clap);
            ImageView star = (ImageView) starImages[starNum];
            star.setImageResource(R.drawable.favourite);

            for (View view:buttonList
            ) {
                Button button = findViewById(view.getId());
                button.setVisibility(View.INVISIBLE);

            }
            Snackbar.make(binding.imageView,"Tebrikler diğer gruba geçtin", Snackbar.LENGTH_LONG)
            .show();
            binding.textView.setVisibility(View.GONE);
            binding.logo.setVisibility(View.INVISIBLE);

            LinearLayout  layout = binding.starsLayout;
            layout.setVisibility(View.INVISIBLE);
            LinearLayout finished_layout = binding.starsFinish;
            finished_layout.setVisibility(View.VISIBLE);
            for(int i=0;i<starNum;i++){
                finished_layout.getChildAt(i).setVisibility(View.VISIBLE);

            }
            binding.ilerleButton.setVisibility(View.VISIBLE);
            binding.kucukBoyutBaslik.setVisibility(View.VISIBLE);
            binding.ikincigrupHarflerText.setVisibility(View.VISIBLE);

            //ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams)layout.getLayoutParams();
            //params.setMargins(350, 300, 350, 0); //substitute parameters for left, top, right, bottom
            //layout.setLayoutParams(params);
            return;
        }

        if(buttonText.charAt(0) == pictures[questionNumber].getImageName().charAt(0)){
                ImageView star = (ImageView) starImages[starNum];
                star.setImageResource(R.drawable.favourite);
                questionNumber++;
                starNum++;
                binding.imageView.setImageResource(pictures[questionNumber].getImageNumber());
        }



    }

    public View[] createViewList(View[] views){
        list.setViews(views);
        return list.getViews();

    }






}