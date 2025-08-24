package altimetrik;

public class BinarySubSequence {

    public static void main(String[] args) {
        System.out.println(getSubSequence(21));
    }

    public static int getSubSequence(int n){
        String binaryString = Integer.toBinaryString(n);
        int count1 =0, count10=0, count101=0;

        for(char c : binaryString.toCharArray()){
            if(c == '1'){
                count101 += count10;
                count1 += 1;
            }else{
                count10 += count1;
            }
        }

        return count101;
    }
}
