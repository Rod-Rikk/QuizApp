package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.String.*;



public class quiz extends AppCompatActivity {

    //keep track of the score in the quiz
    int score = 0;


    int checkSubmit = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        displayScore(score);

        // This text view shows the username when the activity is created
        TextView showUserName = findViewById(R.id.username_text_view);
        showUserName.setText(displayUsername());
    }

    /**
     * Displays user's name on the screen.
     */
    private String displayUsername() {
        // Get username entered from the previous page and display in the current page
        Intent myIntent = getIntent();
        String nameEntered = myIntent.getStringExtra("EditTextValue");
        String userName = "Welcome, " + nameEntered;
        return userName;
    }

    /**
     * Display Score before quiz will be taken.
     *
     * @param score takes in the default value of score which is zero.
     */
    private void displayScore(int score) {
        // Set a text view to show the score.
        TextView scoreView = findViewById(R.id.score_text_view);
        scoreView.setText(format(" %d", score));
    }

    /**
     * This method calculates all ticked radio button that has the correct answer.
     *
     * @param question2_option3 when ticked adds one to the score.

     * @param question6_option2 when ticked adds one to the score.
     *
     * @param question7_option1 when ticked adds one to the score.
     */
    private void calculateScoreForRadioButtons(boolean question2_option3, boolean question6_option2,
                                       boolean question7_option1) {


        // if user picks option 3 in question 2, add 1 to score.
        if (question2_option3) {
            score += 1;
        }



        // if user picks option 1 in question 6, add 1 to score.
        if (question6_option2) {
            score += 1;
        }


        // if user picks option 1 in question 7, add 1 to score.
        if (question7_option1) {
            score += 1;
        }

        // calculate the total value of score
    }

    /**
     * This method calculates all the correct checkboxes that have been ticked.
     *
     * @param question3_option1 when ticked adds one to the current value of score.
     * @param question3_option3 when ticked adds one to the current value of score.
     * @param question3_option4 when ticked adds one to the current value of score.
     * @param question4_option1 when ticked adds one to the current value of score.
     * @param question4_option2 when ticked adds one to the current value of score.
     * @param question4_option4 when ticked adds one to the current value of score.
     * @param question8_option1 when ticked adds one to the current value of score.
     */
    private void calculateScoreForCheckBoxes(boolean question3_option1, boolean question3_option3,
                                     boolean question3_option4, boolean question4_option1,
                                     boolean question4_option2, boolean question4_option4,
                                     boolean question8_option1, boolean question8_option3) {
        // if user picks option 1 in question 3, add 1 to score.
        if (question3_option1) {
            score += 1;
        }

        // if user picks option 3 in question 3, add 1 to score.
        if (question3_option3) {
            score += 1;
        }

        // if user picks option 4 in question 3, add 1 to score.
        if (question3_option4) {
            score += 1;
        }

        // if user picks option 1 in question 4, add 1 to score.
        if (question4_option1) {
            score += 1;
        }

        // if user picks option 2 in question 4, add 1 to score.
        if (question4_option2) {
            score += 1;
        }

        // if user picks option 4 in question 4, add 1 to score.
        if (question4_option4) {
            score += 1;
        }
        // if user picks option 2 in question 4, add 1 to score.
        if (question8_option1) {
            score += 1;
        }
        // if user picks option 2 in question 4, add 1 to score.
        if (question8_option3) {
            score += 1;
        }

    }
    /**
     * This method accepts the input of all edited texts and check if they are correct.
     *
     * @param questionOne accepts the texts entered in question 1.
     * @param questionFive  accepts the texts entered in question 5.
     * @param questionNine accepts the texts entered in question 8.
     */
    private void calculateScoreForEditTextAnswers(String questionOne, String questionFive , String questionNine) {
        // Get the real answer of questions 1, 5 and 9 stored in strings.xml
        String answer1 = getString(R.string.answer1);
        String answer5 = getString(R.string.answer5);
        String answer9 = getString(R.string.answer9);

        // if answer entered  for question 1 is correct, update the value of score and add 3.

        if(questionOne.trim().equalsIgnoreCase(answer1)) {
            score +=5;
        }
        // if answer entered  for question 5 is correct, update the value of score and add 3.
        if (questionFive.trim().equalsIgnoreCase(answer5)) {
            score += 5;
        }
        // if answer entered  for question 9 is correct, update the value of score and add 3..
        if (questionNine.trim().equalsIgnoreCase(answer9)) {
            score += 5;
        }

        // calculate the total value of score
    }
    /**
     * This method is called whenever the submit button is clicked.
     */
    public void finishQuiz(View view) {
        // Call method to evaluate the questions.
        evaluateQuestions();
    }
    /**
     * This method is called whenever resets the quiz and resets the quiz to default.
     */
    public void resetQuiz(View view) {

        // Get the ID of radio group Question 2
        RadioGroup groupTwo = findViewById(R.id.radioGroupQ2);

        // Get the ID of radio group 6
        RadioGroup groupSix = findViewById(R.id.radioGroupQ6);

        // Get the ID of radio group 7
        RadioGroup groupSeven = findViewById(R.id.radioGroupQ7);



        // Get the ID of Question 3 checkboxes
        CheckBox question3Option1 =  findViewById(R.id.question_three_option1);
        CheckBox question3Option2 =  findViewById(R.id.question_three_option2);
        CheckBox question3Option3 =  findViewById(R.id.question_three_option3);
        CheckBox question3Option4 =  findViewById(R.id.question_three_option4);

        // Get the ID of Question 4 checkboxes
        CheckBox question4Option1 =  findViewById(R.id.question_four_option1);
        CheckBox question4Option2 =  findViewById(R.id.question_four_option2);
        CheckBox question4Option3 =  findViewById(R.id.question_four_option3);
        CheckBox question4Option4 =  findViewById(R.id.question_four_option4);


        // Get the ID of Question 8 checkboxes
        CheckBox question8Option1 =  findViewById(R.id.question_eight_option1);
        CheckBox question8Option2 =  findViewById(R.id.question_eight_option2);
        CheckBox question8Option3 =  findViewById(R.id.question_eight_option3);
        CheckBox question8Option4 =  findViewById(R.id.question_eight_option4);

        // Getting all EditTexts values for question 8 and question 10.
        EditText question1 = findViewById(R.id.question_one_field);
        EditText question5 = findViewById(R.id.question_five_field);
        EditText question9 = findViewById(R.id.question_nine_field);

        // Clear all radio buttons in each radio groups that has been checked.

        groupTwo.clearCheck();
        groupSix.clearCheck();
        groupSeven.clearCheck();



        //Uncheck all checkboxes that has been ticked in question 3
        question3Option1.setChecked(false);
        question3Option2.setChecked(false);
        question3Option3.setChecked(false);
        question3Option4.setChecked(false);

        // uncheck all checkboxes that has been ticked in question 4
        question4Option1.setChecked(false);
        question4Option2.setChecked(false);
        question4Option3.setChecked(false);
        question4Option4.setChecked(false);

        //Uncheck all checkboxes that has been ticked in question 8
        question8Option1.setChecked(false);
        question8Option2.setChecked(false);
        question8Option3.setChecked(false);
        question8Option4.setChecked(false);


        // Set the values in all EditText boxes to be empty.
        question1.setText("");
        question5.setText("");
        question9.setText("");

        // resets the checkSubmit counter
        checkSubmit = 0;

        // resets the score variable to zero
        score = 0;
        displayScore(score);
    }

    private void evaluateQuestions() {

        // Get the ID of radio group Question 2 to ascertain if a radio button has been ticked
        RadioGroup groupTwo =  findViewById(R.id.radioGroupQ2);
        int groupTwoId = groupTwo.getCheckedRadioButtonId();

        // Get the ID of radio group 6 to ascertain if a radio button has been ticked
        RadioGroup groupSix =  findViewById(R.id.radioGroupQ6);
        int groupSixId = groupSix.getCheckedRadioButtonId();

        // Get the ID of radio group 7 to ascertain if a radio button has been ticked
        RadioGroup groupSeven = findViewById(R.id.radioGroupQ7);
        int groupSevenId = groupSeven.getCheckedRadioButtonId();

        // Taking in the vale of any question that has been checked in question 3 and storing it
        CheckBox question3Option1 =  findViewById(R.id.question_three_option1);
        boolean stateOfQuestion3_option1 = question3Option1.isChecked();
        CheckBox question3Option2 =  findViewById(R.id.question_three_option2);
        boolean stateOfQuestion3Option2 = question3Option2.isChecked();
        CheckBox question3Option3 =  findViewById(R.id.question_three_option3);
        boolean stateOfQuestion3Option3 = question3Option3.isChecked();
        CheckBox question3Option4 =  findViewById(R.id.question_three_option4);
        boolean stateOfQuestion3Option4 = question3Option4.isChecked();

        // Taking in the value of any question that has been checked in question 4 and storing it
        CheckBox question4Option1 =  findViewById(R.id.question_four_option1);
        boolean stateOfQuestion4Option1 = question4Option1.isChecked();
        CheckBox question4Option2 =  findViewById(R.id.question_four_option2);
        boolean stateOfQuestion4Option2 = question4Option2.isChecked();
        CheckBox question4Option3 =  findViewById(R.id.question_four_option3);
        boolean stateOfQuestion4Option3 = question4Option3.isChecked();
        CheckBox question4Option4 =  findViewById(R.id.question_four_option4);
        boolean stateOfQuestion4Option4 = question4Option4.isChecked();

        // Taking in the vale of any question that has been checked in question 8 and storing it
        CheckBox question8Option1 =  findViewById(R.id.question_eight_option1);
        boolean stateOfQuestion8Option1 = question8Option1.isChecked();
        CheckBox question8Option2 =  findViewById(R.id.question_eight_option2);
        boolean stateOfQuestion8Option2 = question8Option2.isChecked();
        CheckBox question8Option3 =  findViewById(R.id.question_eight_option3);
        boolean stateOfQuestion8Option3 = question8Option3.isChecked();
        CheckBox question8Option4 =  findViewById(R.id.question_eight_option4);
        boolean stateOfQuestion8Option4 = question8Option4.isChecked();

        // Getting all EditText fields

        EditText questText1 =  findViewById(R.id.question_one_field);
        String question1 = questText1.getText().toString();


        EditText questText5 =  findViewById(R.id.question_five_field);
        String question5 = questText5.getText().toString();

        EditText questText9 =  findViewById(R.id.question_nine_field);
        String question9 = questText9.getText().toString();

        // Variable parameters for calculateRadiobutton method

        RadioButton quest2_opt3 =  findViewById(R.id.question_two_option3);
        boolean question2_option3 = quest2_opt3.isChecked();

        RadioButton quest6_opt1 =  findViewById(R.id.question_six_option2);
        boolean question6_option2= quest6_opt1.isChecked();

        RadioButton quest7_opt1 =  findViewById(R.id.question_seven_option1);
        boolean question7_option1 = quest7_opt1.isChecked();

        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 3
        boolean question3 = stateOfQuestion3_option1 || stateOfQuestion3Option2 ||
                stateOfQuestion3Option3 || stateOfQuestion3Option4;


        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 4
        boolean question4 = stateOfQuestion4Option1 || stateOfQuestion4Option2 || stateOfQuestion4Option3 ||
                stateOfQuestion4Option4;


        // Store all checked parameter to ascertain that at least one option was ticked in
        // question 8
        boolean question8 = stateOfQuestion8Option1 || stateOfQuestion8Option2 ||
                stateOfQuestion8Option3 || stateOfQuestion8Option4;

        // if no radio button has been checked in radio group 2 after submit button has been clicked
        if ( groupTwoId == -1) {
            Toast.makeText(this, "Please pick an answer in question 2",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been clicked in radio group 6 after submit button has been clicked
        else if (groupSixId == -1) {
            Toast.makeText(this, "Please pick an answer to question 6",
                    Toast.LENGTH_SHORT).show();
        }

        // if no radio button has been clicked in radio group 7 after submit button has been clicked
        else if (groupSevenId == -1) {
            Toast.makeText(this, "Please pick an answer to question 7",
                    Toast.LENGTH_SHORT).show();
        }

        // if no checkbox was clicked in question 3 after submit button has been clicked
        else if (!question3) {
            Toast.makeText(this, "Please select an answer to question 3",
                    Toast.LENGTH_SHORT).show();
        }

        // if no checkbox was clicked in question 4 after submit button has been clicked
        else if (!question4) {
            Toast.makeText(this, "Please select an answer to question 4",
                    Toast.LENGTH_SHORT).show();

        }

        // if no checkbox was clicked in question 8 after submit button has been clicked
        else if (!question8) {
            Toast.makeText(this, "Please select an answer to question 8",
                    Toast.LENGTH_SHORT).show();
        }

        // check if the questions has been answered without hitting the reset button
        else if (checkSubmit > 0) {
            Toast.makeText(this, "Press the reset button",
                    Toast.LENGTH_SHORT).show();
        } else {
            //Add one to checkSubmit variable to avoid the score from being recalculated and added to
            // the previous score if the submit button was pressed more than once.
            checkSubmit += 1;

            // calculate all checkboxes by calling calculateCheckboxes method
            calculateScoreForCheckBoxes( stateOfQuestion3_option1, stateOfQuestion3Option3,stateOfQuestion3Option4,
                                 stateOfQuestion4Option1, stateOfQuestion4Option2, stateOfQuestion4Option4,
                                 stateOfQuestion8Option1, stateOfQuestion8Option3);

            // calculate all radio buttons by calling calculateRadioButtons method
            calculateScoreForRadioButtons(question2_option3, question6_option2, question7_option1);

            // calculate all Text inputs by calling editTextAnswers method
            calculateScoreForEditTextAnswers(question1,question5, question9);

            displayScore(score);

            String grade;

            if (score < 10) {
                grade = "Meh...";
            } else if (score >=10 && score <=14) {
                grade = "Average";
            } else if ((score >= 15) && (19 >= score)) {
                grade = "Impressive!";
            } else {
                grade = "Excellent!";
            }

            // Display a toast message to show total score
            Toast.makeText(this, grade + " your score is " + score + "",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Email your result to a friend
     */
    public void emailResult(View view) {
        // Getting username only
        Intent myIntent = getIntent();
        String nameOfUser = myIntent.getStringExtra("EditTextValue");

        String result = "Name: " + nameOfUser;
        result += "\nMy score: " + score;

        // Create a new intent to send information to any mailing app
        Intent myResult = new Intent(Intent.ACTION_SENDTO);
        myResult.setData(Uri.parse("mailto:"));
        myResult.putExtra(Intent.EXTRA_SUBJECT, "Quiz result for " + nameOfUser);
        myResult.putExtra(Intent.EXTRA_TEXT, result);
        if (myResult.resolveActivity(getPackageManager()) != null) {
            startActivity(myResult);
        }
    }
}






