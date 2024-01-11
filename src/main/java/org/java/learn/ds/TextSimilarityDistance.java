package org.java.learn.ds;

import org.xm.Similarity;

import java.util.ArrayList;
import java.util.List;

/**
 * 算出两个输入句子的相似性距离
 *
 * @author Quan Fang
 * @version 创建时间：2016年3月10日 下午8:31:46
 */
public class TextSimilarityDistance {

    public static void main(String[] args) {
        //原始文本
        String s1_s = "晃州变一次试验工作 负责 负责人责人董坚12345555安全安全员全员陈俊宏159076690806";
        String s2_s = "红光 光变 基础 施工工作 负责 负责人责人潘启昌836784038534675安全 安全员 全员李子豪8397515101";
//
//        //预处理后
//        String s1 = "晃州变一次试验工作 负责 负责人责人董坚88888888888安全安全员全员陈俊宏88888888888";
//        String s2 = "红光 光变 基础 施工工作 负责 负责人责人潘启昌88888888888安全 安全员 全员李子豪88888888888";
//
//        System.out.println(getEditDistance(s1_s, s2_s));

        //开源包
        double result = Similarity.morphoSimilarity(s1_s, s2_s);
        System.out.println(result);
        result = Similarity.editDistanceSimilarity(s1_s, s2_s);
        System.out.println(result);
        result = Similarity.standardEditDistanceSimilarity(s1_s, s2_s);
        System.out.println(result);
    }

    public static double getSimScoreViaCWM(String input_sentence, String match_sentence)  // 最长相似字符
    {

        List<String> dict_commom = new ArrayList<String>();
        List<String> dict_match = new ArrayList<String>();

        for (int i = 0; i < input_sentence.length(); i++) {
            String word = input_sentence.substring(i, i + 1);
            if (match_sentence.contains(word) && !dict_commom.contains(word)) dict_commom.add(word);
        }


        for (int i = 0; i < match_sentence.length(); i++) {
            String word = match_sentence.substring(i, i + 1);
            if (!dict_match.contains(word)) dict_match.add(word);
        }

        if (dict_match.size() > 0)
            return (dict_commom.size() * 1.0 / (double) dict_match.size());
        else
            return 0;
    }


    public static double getSimScoreViaKWM(String input_sentence, String match_sentence)  // 最长相似字符
    {
        int length1 = input_sentence.length();
        int length2 = match_sentence.length();
        int lcsLength = 0;

        if (length1 <= length2) {
            for (int i = 0; i < input_sentence.length(); i++) {
                String word = input_sentence.substring(i, i + 1);
                if (match_sentence.contains(word)) lcsLength++;
            }
        } else {
            for (int i = 0; i < match_sentence.length(); i++) {
                String word = match_sentence.substring(i, i + 1);
                if (input_sentence.contains(word)) lcsLength++;
            }
        }

        return (lcsLength * 1.0 / (double) length2);
    }


    public static double getSimScoreViaLCS(String sentence1, String sentence2) {
        int[][] num = new int[sentence1.length() + 1][sentence2.length() + 1]; // 2D array,

        for (int i = 1; i <= sentence1.length(); i++) {
            for (int j = 1; j <= sentence2.length(); j++) {
                if (sentence1.charAt(i - 1) == sentence2.charAt(j - 1))
                    num[i][j] = 1 + num[i - 1][j - 1];
                else
                    num[i][j] = Math.max(num[i - 1][j], num[i][j - 1]);
            }
        }

        int lcsLength = num[sentence1.length()][sentence2.length()];
        return (lcsLength / (double) Math.min(sentence1.length(), sentence1.length()));
    }

    public static double getEditDistance(String text1, String text2) {

        int length1 = text1.length();
        int length2 = text2.length();
        if (length1 == 0) return (long) length2;
        if (length2 == 0) return (long) length1;
        int cost;
        char ch1;
        char ch2;
        int d[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= length2; j++) {
            d[0][j] = j;
        }

        for (int i = 1; i <= length1; i++) {
            ch1 = text1.charAt(i - 1);
            for (int j = 1; j <= length2; j++) {
                ch2 = text2.charAt(j - 1);
                if (ch1 == ch2) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                d[i][j] = Math.min(Math.min(d[i - 1][j] + 1, d[i][j - 1] + 1), d[i - 1][j - 1] + cost);

            }

        }
        long ld = (long) d[length1][length2];

        return 1 - (double) ld / Math.max(text1.length(), text2.length());

    }


    public static double getSimScoreViaJSA(String sentence1, String sentence2)  // 最长相似字符
    {
        int length1 = sentence1.length();
        int length2 = sentence2.length();
        int lcsLength = 0;

        if (length1 <= length2) {
            for (int i = 0; i < sentence1.length(); i++) {
                String word = sentence1.substring(i, i + 1);
                if (sentence2.contains(word)) lcsLength++;
            }
        } else {
            for (int i = 0; i < sentence2.length(); i++) {
                String word = sentence2.substring(i, i + 1);
                if (sentence1.contains(word)) lcsLength++;
            }
        }

        return (lcsLength / (double) Math.max(length1, length2));

    }

    public static double getSimScoreViaJSI(String sentence1, String sentence2)  // 最长相似字符
    {
        int length1 = sentence1.length();
        int length2 = sentence2.length();
        int lcsLength = 0;

        if (length1 <= length2) {
            for (int i = 0; i < sentence1.length(); i++) {
                String word = sentence1.substring(i, i + 1);
                if (sentence2.contains(word)) lcsLength++;
            }
        } else {
            for (int i = 0; i < sentence2.length(); i++) {
                String word = sentence2.substring(i, i + 1);
                if (sentence1.contains(word)) lcsLength++;
            }
        }
        return (lcsLength / (double) Math.min(length1, length2));

    }


    public static double getSimScoreViaLCC(String sentence1, String sentence2)  // 最长相似字符
    {
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < sentence1.length(); i++) {
            String word = sentence1.substring(i, i + 1);
            if (sentence2.contains(word)) num1++;
        }


        for (int i = 0; i < sentence2.length(); i++) {
            String word = sentence2.substring(i, i + 1);
            if (sentence1.contains(word)) num2++;
        }

        int lcsLength = Math.min(num1, num2);
        return (lcsLength / (double) Math.min(sentence1.length(), sentence1.length()));
    }


    public static double getSimScoreViaVSM(String sentence1, String sentence2) {

        ArrayList<String> dict = new ArrayList<String>();

        for (int i = 0; i < sentence1.length(); i++) {
            String word = sentence1.substring(i, i + 1);
            if (!dict.contains(word)) {
                dict.add(word);
            }
        }

        for (int i = 0; i < sentence2.length(); i++) {
            String word = sentence2.substring(i, i + 1);
            if (!dict.contains(word)) {
                dict.add(word);
            }
        }


        int[] v1 = new int[dict.size()];
        int[] v2 = new int[dict.size()];

        for (int idx = 0; idx < dict.size(); idx++) {
            String word = dict.get(idx);
            if (sentence1.contains(word)) v1[idx] = 1;
            if (sentence2.contains(word)) v2[idx] = 1;

        }
        return (getCosineSimilarity(v1, v2));

    }


    public static double getCosineSimilarity(int[] v1, int[] v2) {
        double denominator = 0;
        double sqv1 = 0;
        double sqv2 = 0;
        double s = 0;

        for (int i = 0; i < v1.length; i++) {
            denominator += v1[i] * v2[i];
            sqv1 += v1[i] * v1[i];
            sqv2 += v2[i] * v2[i];
        }
        if (sqv1 == 0 || sqv2 == 0) return 0;
        s = denominator * 1.0 / (Math.sqrt(sqv1) * Math.sqrt(sqv2));
        return s;
    }


}
