package org.example.th_zkouska_interactive.loader;


import org.example.th_zkouska_interactive.models.Question;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private final List<Question> questions = new ArrayList<>();
    private static int linesNum = 0;

    public void loadQuestions() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/static/questions.txt");
            assert inputStream != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }

                linesNum++;
                Question q = new Question(line);
                questions.add(q);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public static int getLinesNum() {
        return linesNum;
    }

}
