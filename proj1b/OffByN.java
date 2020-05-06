public class OffByN implements CharacterComparator {
    int offByN;
    OffByN(int N) {
        offByN = N;
    }
    public boolean equalChars(char x, char y) {
        int a = x;
        int b = y;
        return a - b == offByN || a - b == (offByN * (-1));
    }
}
