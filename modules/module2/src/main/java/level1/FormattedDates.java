package level1;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class FormattedDates {

    public List<String> getListFormattedDates(Collection<String> dates){
        Objects.requireNonNull(dates);

        List<String> list = new ArrayList<>();

        for (String date : dates) {
            try {
                LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
                list.add(date);
            } catch (Exception ignored){}
        }

        return list;
    }

    public static void main(String[] args) {
        FormattedDates f = new FormattedDates();
        List<String> list = new ArrayList<>();
        list.add("2020/04/05");
        list.add("05/04/2020");
        list.add("04-05-2020");
        list.add("20200405");

        f.getListFormattedDates(list).forEach(System.out::println);
    }
}
