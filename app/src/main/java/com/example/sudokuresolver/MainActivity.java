package com.example.sudokuresolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onConfirmClick(View view) {
        EditText numberOneOne = findViewById(R.id.OneOne);
        EditText numberOneTwo = findViewById(R.id.OneTwo);
        EditText numberOneThree = findViewById(R.id.OneThree);
        EditText numberOneFour = findViewById(R.id.OneFour);
        EditText numberOneFive = findViewById(R.id.OneFive);
        EditText numberOneSix = findViewById(R.id.OneSix);
        EditText numberOneSeven = findViewById(R.id.OneSeven);
        EditText numberOneEight = findViewById(R.id.OneEight);
        EditText numberOneNine = findViewById(R.id.OneNine);

        EditText numberTwoOne = findViewById(R.id.TwoOne);
        EditText numberTwoTwo = findViewById(R.id.TwoTwo);
        EditText numberTwoThree = findViewById(R.id.TwoThree);
        EditText numberTwoFour = findViewById(R.id.TwoFour);
        EditText numberTwoFive = findViewById(R.id.TwoFive);
        EditText numberTwoSix = findViewById(R.id.TwoSix);
        EditText numberTwoSeven = findViewById(R.id.TwoSeven);
        EditText numberTwoEight = findViewById(R.id.TwoEight);
        EditText numberTwoNine = findViewById(R.id.TwoNine);

        EditText numberThreeOne = findViewById(R.id.ThreeOne);
        EditText numberThreeTwo = findViewById(R.id.ThreeTwo);
        EditText numberThreeThree = findViewById(R.id.ThreeThree);
        EditText numberThreeFour = findViewById(R.id.ThreeFour);
        EditText numberThreeFive = findViewById(R.id.ThreeFive);
        EditText numberThreeSix = findViewById(R.id.ThreeSix);
        EditText numberThreeSeven = findViewById(R.id.ThreeSeven);
        EditText numberThreeEight = findViewById(R.id.ThreeEight);
        EditText numberThreeNine = findViewById(R.id.ThreeNine);

        EditText numberFourOne = findViewById(R.id.FourOne);
        EditText numberFourTwo = findViewById(R.id.FourTwo);
        EditText numberFourThree = findViewById(R.id.FourThree);
        EditText numberFourFour = findViewById(R.id.FourFour);
        EditText numberFourFive = findViewById(R.id.FourFive);
        EditText numberFourSix = findViewById(R.id.FourSix);
        EditText numberFourSeven = findViewById(R.id.FourSeven);
        EditText numberFourEight = findViewById(R.id.FourEight);
        EditText numberFourNine = findViewById(R.id.FourNine);

        EditText numberFiveOne = findViewById(R.id.FiveOne);
        EditText numberFiveTwo = findViewById(R.id.FiveTwo);
        EditText numberFiveThree = findViewById(R.id.FiveThree);
        EditText numberFiveFour = findViewById(R.id.FiveFour);
        EditText numberFiveFive = findViewById(R.id.FiveFive);
        EditText numberFiveSix = findViewById(R.id.FiveSix);
        EditText numberFiveSeven = findViewById(R.id.FiveSeven);
        EditText numberFiveEight = findViewById(R.id.FiveEight);
        EditText numberFiveNine = findViewById(R.id.FiveNine);

        EditText numberSixOne = findViewById(R.id.SixOne);
        EditText numberSixTwo = findViewById(R.id.SixTwo);
        EditText numberSixThree = findViewById(R.id.SixThree);
        EditText numberSixFour = findViewById(R.id.SixFour);
        EditText numberSixFive = findViewById(R.id.SixFive);
        EditText numberSixSix = findViewById(R.id.SixSix);
        EditText numberSixSeven = findViewById(R.id.SixSeven);
        EditText numberSixEight = findViewById(R.id.SixEight);
        EditText numberSixNine = findViewById(R.id.SixNine);

        EditText numberSevenOne = findViewById(R.id.SevenOne);
        EditText numberSevenTwo = findViewById(R.id.SevenTwo);
        EditText numberSevenThree = findViewById(R.id.SevenThree);
        EditText numberSevenFour = findViewById(R.id.SevenFour);
        EditText numberSevenFive = findViewById(R.id.SevenFive);
        EditText numberSevenSix = findViewById(R.id.SevenSix);
        EditText numberSevenSeven = findViewById(R.id.SevenSeven);
        EditText numberSevenEight = findViewById(R.id.SevenEight);
        EditText numberSevenNine = findViewById(R.id.SevenNine);

        EditText numberEightOne = findViewById(R.id.EightOne);
        EditText numberEightTwo = findViewById(R.id.EightTwo);
        EditText numberEightThree = findViewById(R.id.EightThree);
        EditText numberEightFour = findViewById(R.id.EightFour);
        EditText numberEightFive = findViewById(R.id.EightFive);
        EditText numberEightSix = findViewById(R.id.EightSix);
        EditText numberEightSeven = findViewById(R.id.EightSeven);
        EditText numberEightEight = findViewById(R.id.EightEight);
        EditText numberEightNine = findViewById(R.id.EightNine);

        EditText numberNineOne = findViewById(R.id.NineOne);
        EditText numberNineTwo = findViewById(R.id.NineTwo);
        EditText numberNineThree = findViewById(R.id.NineThree);
        EditText numberNineFour = findViewById(R.id.NineFour);
        EditText numberNineFive = findViewById(R.id.NineFive);
        EditText numberNineSix = findViewById(R.id.NineSix);
        EditText numberNineSeven = findViewById(R.id.NineSeven);
        EditText numberNineEight = findViewById(R.id.NineEight);
        EditText numberNineNine = findViewById(R.id.NineNine);

        SudokuResolver resolver = new SudokuResolver(Arrays.asList(
                numberOneOne.getText().toString(),
                numberOneTwo.getText().toString(),
                numberOneThree.getText().toString(),
                numberOneFour.getText().toString(),
                numberOneFive.getText().toString(),
                numberOneSix.getText().toString(),
                numberOneSeven.getText().toString(),
                numberOneEight.getText().toString(),
                numberOneNine.getText().toString(),
                numberTwoOne.getText().toString(),
                numberTwoTwo.getText().toString(),
                numberTwoThree.getText().toString(),
                numberTwoFour.getText().toString(),
                numberTwoFive.getText().toString(),
                numberTwoSix.getText().toString(),
                numberTwoSeven.getText().toString(),
                numberTwoEight.getText().toString(),
                numberTwoNine.getText().toString(),
                numberThreeThree.getText().toString(),
                numberThreeOne.getText().toString(),
                numberThreeTwo.getText().toString(),
                numberThreeFour.getText().toString(),
                numberThreeFive.getText().toString(),
                numberThreeSix.getText().toString(),
                numberThreeSeven.getText().toString(),
                numberThreeEight.getText().toString(),
                numberThreeNine.getText().toString(),
                numberFourOne.getText().toString(),
                numberFourTwo.getText().toString(),
                numberFourThree.getText().toString(),
                numberFourFour.getText().toString(),
                numberFourFive.getText().toString(),
                numberFourSix.getText().toString(),
                numberFourSeven.getText().toString(),
                numberFourEight.getText().toString(),
                numberFourNine.getText().toString(),
                numberFiveOne.getText().toString(),
                numberFiveTwo.getText().toString(),
                numberFiveThree.getText().toString(),
                numberFiveFour.getText().toString(),
                numberFiveFive.getText().toString(),
                numberFiveSix.getText().toString(),
                numberFiveSeven.getText().toString(),
                numberFiveEight.getText().toString(),
                numberFiveNine.getText().toString(),
                numberSixOne.getText().toString(),
                numberSixTwo.getText().toString(),
                numberSixThree.getText().toString(),
                numberSixFour.getText().toString(),
                numberSixFive.getText().toString(),
                numberSixSix.getText().toString(),
                numberSixSeven.getText().toString(),
                numberSixEight.getText().toString(),
                numberSixNine.getText().toString(),
                numberSevenOne.getText().toString(),
                numberSevenTwo.getText().toString(),
                numberSevenThree.getText().toString(),
                numberSevenFour.getText().toString(),
                numberSevenFive.getText().toString(),
                numberSevenSix.getText().toString(),
                numberSevenSeven.getText().toString(),
                numberSevenEight.getText().toString(),
                numberSevenNine.getText().toString(),
                numberEightOne.getText().toString(),
                numberEightTwo.getText().toString(),
                numberEightThree.getText().toString(),
                numberEightFour.getText().toString(),
                numberEightFive.getText().toString(),
                numberEightSix.getText().toString(),
                numberEightSeven.getText().toString(),
                numberEightEight.getText().toString(),
                numberEightNine.getText().toString(),
                numberNineOne.getText().toString(),
                numberNineTwo.getText().toString(),
                numberNineThree.getText().toString(),
                numberNineFour.getText().toString(),
                numberNineFive.getText().toString(),
                numberNineSix.getText().toString(),
                numberNineSeven.getText().toString(),
                numberNineEight.getText().toString(),
                numberNineNine.getText().toString())
        );
        TextView txtView = findViewById(R.id.Test12);
        txtView.setText(numberOneOne.getText());
    }
}
