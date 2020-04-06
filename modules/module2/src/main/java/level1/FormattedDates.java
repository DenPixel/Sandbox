package level1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FormattedDates {

    public List<String> getListFormattedDates(Collection<String> dates){
        Objects.requireNonNull(dates);
        List<String> list = new ArrayList<>();

        for (String date : dates) {
            Optional<LocalDate> validDate = getValidDate(date);

            if(validDate.isPresent()){
                String format = validDate.get().format(DateTimeFormatter.BASIC_ISO_DATE);
                list.add(format);
            }

        }

        return list;
    }

    private Optional<LocalDate> getValidDate(String date){
        DateTimeFormatter[] formatters = new DateTimeFormatter[]{
                DateTimeFormatter.ofPattern("yyyyMMdd"),
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"),
                DateTimeFormatter.ofPattern("MM-dd-yyyy")
        };

        for (var formatter : formatters) {
            try {
                LocalDate parse = LocalDate.parse(date, formatter);
                return Optional.ofNullable(parse);
            } catch (Exception ignored){

            }
        }

        return Optional.empty();
    }


    public static void main(String[] args) {
        FormattedDates f = new FormattedDates();
        List<String> list = new ArrayList<>();
        list.add("2020/04/05");
        list.add("");
        list.add("1ffs32");
        list.add("05/04/2020");
        list.add("04-05-2020");
        list.add("20200405");

        f.getListFormattedDates(list).forEach(System.out::println);


    }
}
