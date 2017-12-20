package fix;

public class RomanToInt {

    public int romanToInt(String s) {
        int maxNum = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int current;
            current = convert(s.charAt(i));
            if (current < maxNum) {
                sum -= current;
            } else {
                maxNum = current;
                sum += current;
            }
        }
        return sum;
    }

    public int convert(char c) { // TODO SHIKI why don't you just directly return the value instead of storing it in "result"?
        int result = 0;
        switch (c) {
            case 'I':
                result = 1;
                break;
            case 'V':
                result = 5;
                break;
            case 'X':
                result = 10;
                break;
            case 'L':
                result = 50;
                break;
            case 'C':
                result = 100;
                break;
            case 'D':
                result = 500;
                break;
            case 'M':
                result = 1000;
                break;
        }
        return result;
    }

}
