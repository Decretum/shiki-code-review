package complete;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

/*
/*n=numRows
Δ=2n-2    1                           2n-1                         4n-3
Δ=        2                     2n-2  2n                    4n-4   4n-2
Δ=        3               2n-3        2n+1              4n-5       .
Δ=        .           .               .               .            .
Δ=        .       n+2                 .           3n               .
Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
Δ=2n-2    n                           3n-2                         5n-4

that is the zigzag pattern the question asked!
*/
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || length <= numRows) {
            return s;
        } else {
            int size_x = (length / (2 * (numRows - 1)) + 1) * (numRows - 1);
            System.out.println("length: " + length);
            System.out.println("size x : " + size_x);
            int size_y = numRows;
            char[][] chars = new char[size_y][size_x];
            int x = 0, y = 0;
            for (int i = 0; i < length - 1; i++) {
                if (i / (numRows - 1) % 2 == 0) {
                    chars[++y][x] = s.charAt(i + 1);
                    System.out.println(y + ", " + x);
                } else {
                    chars[--y][++x] = s.charAt(i + 1);
                    System.out.println(y + ", " + x);
                }
            }
            String result = "" + s.charAt(0);
            for (int i = 0; i < numRows; i++) {
                result += new String(chars[i]);
            }
            return result.replace("\u0000", "");
        }
    }


    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 6));
        System.out.println(convert("ABC", 2));
        System.out.println(convert("orfefwofihmozumjkgeilldtosfnorocltisrxxbelrdhdormtaxeftuxyhosxsdtbxkyuoehfkolyfxthwympskqcaibsnutkhtevylciznigkcohccywooaoychlycvfwbcuofepuowfqmouoordfttdvapudkbzmgvclzsfpomiaccqtvvyppdmrsiufkvtqqvdrnkjbzrddtwwrtwiiaucsdwzpushmomgdyphxgmdbibucycmyxoscnutjmcvcqdgoupocbremuaqsdcsctneihzrvboyrsghmvvpyovkjvadadwcylggshzninnbhvjusglrvibgdejgjfihqrpkyoajdpkllvhfeswzaahfeqlnyuwqnlblbdwesjpdewjiohjqjqynjlchhyxulagmdcrwlgbsfmcvwomfgmtpxxyfywzjyhycmpyxxbrcowakkmpqakixkgciectdjrhvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxvpdyowedmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhxkjvcxnpglnbnfxjkxspbuoiphimjhvgteewbrnhcajqhibugtjjqzrfgctploygteewvrgaupsbztxhohqegkmpmfezuefpiklgbrgviazktwrjfiooucdihjhdqosayegcxozgoaqjzjtgtjunlzvuleydvqdtwkxuazcpzuaafthzedorfmmqqktlcyhbigvjfzahvahawozcsouxaipsukgwipztvuebvgiqgpregqhagdzilobfajdiyddtzhwvpgnwyecexlgfofozvrgvamfarlvsuspkydiyjkegwkokpcmkvuhvipvzaquwkjglmojyzogxyuhqwvctsmoadlcfewbqfibuwnuxdaudvevtbyntmdup"
        ,620));
    }
}
