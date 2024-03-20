import java.util.HashMap;

public class ParsData {
    public HashMap<String, String> parsInputData() {
        InputData inputData = new InputData();
        String[] data = inputData.enterData();
        HashMap<String, String> dataDict = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String i : data) {
            if (i.length() == 1) {
                if (i.equals("f") || i.equals("m")) {
                    dataDict.put("sex", i);
                } else {
                    try {
                        throw new SexException();
                    } catch (SexException e) {
                        e.sexException();
                    }
                }
            }
        }
        if (!dataDict.containsKey("sex")){
            try {
                throw new SexException();
            } catch (SexException e) {
                e.sexException();
            }
        }
        for (String i : data) {
            if (i.matches("\\d{1,2}\\.\\d{1,2}\\.\\d{4}")) {
                if(DateCheck.isDateValid(i)){
                    dataDict.put("date", i);
                } else {
                    try {
                        throw new DateException();
                    } catch (DateException e) {
                        e.dateException();
                    }
                }
            }
        }
        if (!dataDict.containsKey("date")){
            try {
                throw new DateException();
            } catch (DateException e) {
                e.dateException();
            }
        }
        for (String i : data) {
            if (i.matches("[0-9]+")) {
                dataDict.put("phone", i);
                }
        }
        if (!dataDict.containsKey("phone")){
            try {
                throw new PhoneException();
            } catch (PhoneException e) {
                e.phoneException();
            }
        }
        for (String i : data) {
            if (i.matches("[А-Яа-яA-Za-z]+") && i.length() > 1) {
                sb.append(i).append(" ");
            }
        }
        String[] fullName = String.valueOf(sb).split(" ");
        if (fullName.length == 3){
            dataDict.put("Фамилия", fullName[0]);
            dataDict.put("Имя", fullName[1]);
            dataDict.put("Отчество", fullName[2]);
        }
        if (!dataDict.containsKey("Фамилия") && !dataDict.containsKey("Имя") && !dataDict.containsKey("Отчество")){
            try {
                throw new DataException();
            } catch (DataException e){
                e.dataException();
            }
        }
        return dataDict;
    }
}

