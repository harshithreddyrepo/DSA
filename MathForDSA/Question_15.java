package DSA_with_kunal.MathForDSA;

public class Question_15 {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(zeroToA_XoR(a));
    }
    public static int zeroToA_XoR(int a){
        return switch(a%4){
            case 0->a;
            case 1->1;
            case 2->a+1;
            case 3->0;
            default -> throw new IllegalStateException("Unexpected value: " + a%4);
        };

    }
}
