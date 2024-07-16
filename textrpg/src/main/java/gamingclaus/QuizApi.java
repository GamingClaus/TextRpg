package gamingclaus;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuizApi {
    private String Api_Key = "https://opentdb.com/api.php?amount=1";
    private String question;
    private String correct_answer;
    private String user_answer;
    Scanner scanner;
    
    
    QuizApi(){
        scanner = new Scanner(System.in);

    }


    public boolean QuizQuestionFetcher() throws IOException, InterruptedException{
       // Create the HTTP request 
        HttpRequest request = HttpRequest.newBuilder().GET()
        .uri(URI.create(Api_Key))
        .build();

        //Create the HTTP CLIENT
        HttpClient client = HttpClient.newBuilder().build();


        //Send response to the api and get the response
        HttpResponse<String> response = client.send(request,BodyHandlers.ofString());


        if(response.statusCode()==200){
            JSONObject jsonResponse = new JSONObject(response.body());
            int responseCode = jsonResponse.getInt("response_code");

            switch(responseCode){
                case 0:
                JSONArray results = jsonResponse.getJSONArray("results");
                JSONObject resultObject = results.getJSONObject(0); // this gets the all the objects from the array list from the results in the api 
                question = resultObject.getString("question");
                correct_answer = resultObject.getString("correct_answer");
                
                //the incorrect answers are a list of array.
                JSONArray incorrect_answerArray = resultObject.getJSONArray("incorrect_answers");
    
                System.out.println("Question: " + question); // printing the question from the response from the api
               System.out.println("Options:");
               System.out.print("1. " + correct_answer + "\t");
               for(int i = 0; i < incorrect_answerArray.length(); i++){
                    System.out.print((i+2) + ". " + incorrect_answerArray.getString(i)+ "\t" );
               }
               System.out.println();
                user_answer = scanner.next();
                
                if(correct_answer.equalsIgnoreCase(user_answer)){
                    return correct_answer.equalsIgnoreCase(user_answer);
                }
                else{
                    System.out.println("Incorrect Answer the the correct answer is " + correct_answer);
                }


                break;

                case 1:
                System.out.println("No Results Could not return results.");
                break;

                case 2:
                System.out.println("Invalid Parameter Contains an invalid parameter.");
                break;

                case 3:
                System.out.println("Token Not Found.");
                break;

                case 4:
                System.out.println("Token Empty");
                break;

                case 5:
                System.out.println("Rate Limited!!");
                break;

            }



        }
        return false;

    }

  











    
}
