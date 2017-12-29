package complete;

public class ZigZagConversion2 {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i =0; i< numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < length) {
            for(int idx = 0; idx <numRows && i < length; idx++ ) {
                sb[idx].append(chars[i++]);
            }
            for(int idx = numRows - 2; idx >= 1 && i < length; idx--) {
                sb[idx].append(chars[i++]);
            }
        }
        for(int x = 1; x < numRows; x++) {
            sb[0].append(sb[x]);
        }

        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 6));
        System.out.println(convert("ABC", 2));
        System.out.println(convert("orfefwofihmozumjkgeilldtosfnorocltisrxxbelrdhdormtaxeftuxyhosxsdtbxkyuoehfkolyfxthwympskqcaibsnutkhtevylciznigkcohccywooaoychlycvfwbcuofepuowfqmouoordfttdvapudkbzmgvclzsfpomiaccqtvvyppdmrsiufkvtqqvdrnkjbzrddtwwrtwiiaucsdwzpushmomgdyphxgmdbibucycmyxoscnutjmcvcqdgoupocbremuaqsdcsctneihzrvboyrsghmvvpyovkjvadadwcylggshzninnbhvjusglrvibgdejgjfihqrpkyoajdpkllvhfeswzaahfeqlnyuwqnlblbdwesjpdewjiohjqjqynjlchhyxulagmdcrwlgbsfmcvwomfgmtpxxyfywzjyhycmpyxxbrcowakkmpqakixkgciectdjrhvghvgiokykkkuycnymvwydagicanorwladiilxsmhfwedytenocltcsdfusvnognrrvfoqrxvpdyowedmgoijilqeelsstfmkdtatkaobforctuqbjyktmayqnqkhxytarwvdyjfdawhvrywcyhxkjvcxnpglnbnfxjkxspbuoiphimjhvgteewbrnhcajqhibugtjjqzrfgctploygteewvrgaupsbztxhohqegkmpmfezuefpiklgbrgviazktwrjfiooucdihjhdqosayegcxozgoaqjzjtgtjunlzvuleydvqdtwkxuazcpzuaafthzedorfmmqqktlcyhbigvjfzahvahawozcsouxaipsukgwipztvuebvgiqgpregqhagdzilobfajdiyddtzhwvpgnwyecexlgfofozvrgvamfarlvsuspkydiyjkegwkokpcmkvuhvipvzaquwkjglmojyzogxyuhqwvctsmoadlcfewbqfibuwnuxdaudvevtbyntmdup"
                ,620));
    }
}
