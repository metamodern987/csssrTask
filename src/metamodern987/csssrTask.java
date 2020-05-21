package metamodern987;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by igor on 21.05.2020
 */

public class csssrTask {

    public static void main(String[] args){
        String str = "сапог сарай арбуз болт бокс биржа";

/**
 Определим структуру конечной мапы
 */
         Map<String, List<String>> map = new TreeMap<>();

/**
   Используем компаратор для сортировки слов в зависимости от кол-ва символов
  */
        Comparator<String> wordsComparator = (wordFirst, wordSec) ->
                 wordFirst.length() == wordSec.length()
                         ? wordFirst.compareTo(wordSec)
                         : wordSec.length() - wordFirst.length();
/**
 Разбиваем имеющуюся строку и представляем массив в виде списка
 */
        List<String> listW = Arrays.asList(str.split("\\s+"));


        listW.stream()                                       //создаем стрим
              .distinct()                                    //без дубликатов
                .collect(Collectors.groupingBy(w ->
                                String.valueOf(w.charAt(0))))//группировка списка слов по первому символу
                .forEach((key, value) -> {                   //для каждого объекта стрима проверяем кол-во элементов
                    if (value.size() > 1) {
                        value.sort(wordsComparator);         //проводим сортировку
                        map.put(key, value);                 //добавляем текущий ключ и значение в конечную мапу
                    }
                });


        System.out.println(map);
    }

}
