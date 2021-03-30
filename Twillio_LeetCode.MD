Twilio OA 1st question 
VANITY NUMBER SEARCH
public List<String> vanity(List<String> codes, List<String> phoneNumbers){
    Map<String, String> phone
        = new HashMap<String, String>();
    phone.put("abc", "2");
    phone.put( "def", "3");
    phone.put( "ghi", "4");
    phone.put("jkl", "5");
    phone.put("mno", "6");
    phone.put( "pqrs", "7");
    phone.put("tuv", "8");
    phone.put("wxyz", "9");
    
List<String> validPhoneCodes = new ArrayList<>();
for(String code : codes) {
    int start = 0;
    StringBuilder sb = new StringBuilder();
    while (start < code.length()) {
        for(String i : phone.keySet()) {
            if(i.indexOf(code.charAt(start)) != -1){
                sb.append(phone.get(i));
            }
        }
        start++;
    }
    validPhoneCodes.add(sb.toString());
}

List<String> result = new ArrayList<>();

for(String validCode : validPhoneCodes) {
    for(String phoneNum : phoneNumbers) {
        if(phoneNum.contains(validCode))
            result.add(phoneNum);
    }
}

return result;

}


public static void main(String[] args) {

List<String> codes = new ArrayList<>();
codes.add("twlo");
codes.add("code");
codes.add("htch");

List<String> phoneNumbers = new ArrayList<>();
phoneNumbers.add("+17474824380");
phoneNumbers.add("+14157088956");
phoneNumbers.add("+919810155555");
phoneNumbers.add("+15109926333");
phoneNumbers.add("+1415123456");

VanityPhoneSearch vps = new VanityPhoneSearch();
List<String> result = vps.getPhoneNumbers(codes, phoneNumbers);

for(String i : result)
    System.out.println(i);
}

2nd QUESTION SMS SPLITTNG
public static List<String> segments(String message) {
        return getSplits(message);
    }
    public static List<String> getSplits(String message){
        List<String> result = new ArrayList<>();
        if (message.length() < 160) {
            result.add(message);
            return result;
        }
 
        int maxlen = 154;
        int s = 0, e = s + maxlen;
        while (e < message.length()) {
            if (message.charAt(e) != ' ') {
                while (e >= s && message.charAt(e) != ' ' && message.charAt(e + 1) != ' ') {
                    e--;
                }
            }
            result.add(message.substring(s, e+ 1));
            s = e + 1;
            e = s + maxlen;
        }
        result.add(message.substring(s, message.length()));
 
        for (int i = 0; i < result.size(); i++) {
            result.set(i, result.get(i)+"(" + (i + 1) + "/" + (result.size()) + ")");
        }
        return result;
    }
