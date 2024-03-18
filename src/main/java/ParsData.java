import java.util.HashMap;

public class ParsData {
    public HashMap<String, String> parsInputData() {
        InputData inputData = new InputData();
        String[] data = inputData.enterData();
        HashMap<String, String> dataDict = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i: data){
            if(i.length() == 1){
                if (i.equals("f") || i.equals("m")){
                    dataDict.put("sex", i);
                } else {
                    try {
                        throw new SexException();
                    } catch (SexException e){
                        e.sexException();
                    }
                }
            } else if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                if(DateCheck.isDateValid(i)){
                    dataDict.put("date", i);
                } else {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateException();
                    }
                }

            } else if (i.matches("[0-9]+")){
                dataDict.put("tel", i);
            } else if (i.matches("[А-Яа-яA-Za-z]+")) {
                sb.append(i).append(" ");
            } else {
                try {
                    throw new DataException();
                } catch (DataException e){
                    e.dataException();
                }
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3){
            dataDict.put("Фамилия", fullName[0]);
            dataDict.put("Имя", fullName[1]);
            dataDict.put("Отчество", fullName[2]);
        }
        return dataDict;
    }
}
